package dev.greyfoundry.authentik.compat

import dev.greyfoundry.authentik.domain.model.AuthenticationExpired
import dev.greyfoundry.authentik.domain.model.CompatibilityLevel
import dev.greyfoundry.authentik.domain.model.Conflict
import dev.greyfoundry.authentik.domain.model.MalformedServerResponse
import dev.greyfoundry.authentik.domain.model.NotFound
import dev.greyfoundry.authentik.domain.model.PermissionDenied
import dev.greyfoundry.authentik.domain.model.RateLimited
import dev.greyfoundry.authentik.domain.model.ServerCapability
import dev.greyfoundry.authentik.domain.model.ServerEdition
import dev.greyfoundry.authentik.domain.model.ServerError
import dev.greyfoundry.authentik.network.ApiClientFactory
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicReference
import kotlin.coroutines.Continuation
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.startCoroutine
import mockwebserver3.MockResponse
import mockwebserver3.MockWebServer
import okhttp3.Headers.Companion.headersOf
import okhttp3.HttpUrl.Companion.toHttpUrl
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertThrows
import org.junit.Before
import org.junit.Test

class ServerProfileTest {
    private lateinit var server: MockWebServer
    private lateinit var clientFactory: ApiClientFactory

    @Before
    fun setUp() {
        server = MockWebServer()
        server.start()
        clientFactory = ApiClientFactory()
    }

    @After
    fun tearDown() {
        server.close()
    }

    @Test
    fun `maps version and capabilities into a stable server profile`() {
        server.enqueue(jsonResponse(VERSION_RESPONSE))
        server.enqueue(jsonResponse(CONFIG_RESPONSE))

        val client = clientFactory.createForLocalTest(server.url("/authentik/"))
        val profile = runSuspend { DefaultAuthentikGateway(client).serverProfile() }

        assertEquals("2026.8.1", profile.versionCurrent)
        assertEquals("2026.8.2", profile.versionLatest)
        assertEquals("server-build", profile.buildHash)
        assertFalse(profile.outdated)
        assertFalse(profile.outpostOutdated)
        assertEquals(ServerEdition.ENTERPRISE, profile.edition)
        assertEquals(CompatibilityLevel.SUPPORTED, profile.compatibilityLevel)
        assertEquals(
            setOf(
                ServerCapability("can_request"),
                ServerCapability("is_enterprise"),
                ServerCapability("future_capability"),
            ),
            profile.capabilities,
        )
        assertEquals("/authentik/api/v3/admin/version/", server.takeRequest().url.encodedPath)
        assertEquals("/authentik/api/v3/root/config/", server.takeRequest().url.encodedPath)
    }

    @Test
    fun `omits an invalid latest version and blank build hash`() {
        server.enqueue(
            jsonResponse(
                VERSION_RESPONSE
                    .replace("\"version_latest_valid\": true", "\"version_latest_valid\": false")
                    .replace("\"server-build\"", "\"   \""),
            ),
        )
        server.enqueue(jsonResponse(CONFIG_RESPONSE))

        val client = clientFactory.createForLocalTest(server.url("/"))
        val profile = runSuspend { DefaultAuthentikGateway(client).serverProfile() }

        assertNull(profile.versionLatest)
        assertNull(profile.buildHash)
    }

    @Test
    fun `classifies tested older and unverified release lines`() {
        val cases = listOf(
            "2026.5.4" to CompatibilityLevel.SUPPORTED,
            "2026.2.8" to CompatibilityLevel.DEGRADED,
            "2025.12.1" to CompatibilityLevel.UNSUPPORTED,
            "2026.11.0" to CompatibilityLevel.UNKNOWN,
            "development" to CompatibilityLevel.UNKNOWN,
        )

        cases.forEach { (version, expectedLevel) ->
            server.enqueue(jsonResponse(VERSION_RESPONSE.replace("2026.8.1", version)))
            server.enqueue(jsonResponse(CONFIG_RESPONSE))
            val client = clientFactory.createForLocalTest(server.url("/"))

            val profile = runSuspend { DefaultAuthentikGateway(client).serverProfile() }

            assertEquals(expectedLevel, profile.compatibilityLevel)
        }
    }

    @Test
    fun `maps forbidden responses without exposing Retrofit types`() {
        server.enqueue(MockResponse(code = 403))

        val client = clientFactory.createForLocalTest(server.url("/"))

        assertThrows(PermissionDenied::class.java) {
            runSuspend { DefaultAuthentikGateway(client).serverProfile() }
        }
    }

    @Test
    fun `maps HTTP failures into stable domain failures`() {
        val cases = listOf(
            401 to AuthenticationExpired::class.java,
            404 to NotFound::class.java,
            409 to Conflict::class.java,
            429 to RateLimited::class.java,
            500 to ServerError::class.java,
        )

        cases.forEach { (statusCode, expectedType) ->
            server.enqueue(MockResponse(code = statusCode))
            val client = clientFactory.createForLocalTest(server.url("/"))

            val failure = assertThrows(expectedType) {
                runSuspend { DefaultAuthentikGateway(client).serverProfile() }
            }

            assertEquals(expectedType, failure.javaClass)
        }
    }

    @Test
    fun `maps malformed response bodies at the compatibility boundary`() {
        server.enqueue(jsonResponse("{\"version_current\":42}"))

        val client = clientFactory.createForLocalTest(server.url("/"))

        assertThrows(MalformedServerResponse::class.java) {
            runSuspend { DefaultAuthentikGateway(client).serverProfile() }
        }
    }

    @Test
    fun `uses finite timeouts without automatic redirects or connection retries`() {
        val client = clientFactory.createForLocalTest(server.url("/"))

        assertEquals(10_000, client.okHttpClient.connectTimeoutMillis)
        assertEquals(30_000, client.okHttpClient.readTimeoutMillis)
        assertEquals(30_000, client.okHttpClient.writeTimeoutMillis)
        assertEquals(45_000, client.okHttpClient.callTimeoutMillis)
        assertFalse(client.okHttpClient.followRedirects)
        assertFalse(client.okHttpClient.followSslRedirects)
        assertFalse(client.okHttpClient.retryOnConnectionFailure)
    }

    @Test
    fun `limits plain HTTP clients to local tests`() {
        assertThrows(IllegalArgumentException::class.java) {
            clientFactory.createForLocalTest("http://example.com/".toHttpUrl())
        }
    }

    private fun jsonResponse(body: String): MockResponse = MockResponse(
        headers = headersOf("Content-Type", "application/json"),
        body = body,
    )

    private fun <T> runSuspend(block: suspend () -> T): T {
        val outcome = AtomicReference<Result<T>>()
        val completed = CountDownLatch(1)
        block.startCoroutine(
            object : Continuation<T> {
                override val context = EmptyCoroutineContext

                override fun resumeWith(result: Result<T>) {
                    outcome.set(result)
                    completed.countDown()
                }
            },
        )
        check(completed.await(10, TimeUnit.SECONDS)) { "Test coroutine timed out." }
        return checkNotNull(outcome.get()).getOrThrow()
    }

    private companion object {
        val VERSION_RESPONSE = """
            {
              "version_current": "2026.8.1",
              "version_latest": "2026.8.2",
              "version_latest_valid": true,
              "build_hash": "server-build",
              "outdated": false,
              "outpost_outdated": false,
              "future_version_field": "ignored"
            }
        """.trimIndent()

        val CONFIG_RESPONSE = """
            {
              "error_reporting": {
                "enabled": false,
                "sentry_dsn": "",
                "environment": "self-hosted",
                "send_pii": false,
                "traces_sample_rate": 0.0
              },
              "capabilities": ["can_request", "is_enterprise", "future_capability"],
              "cache_timeout": 300,
              "cache_timeout_flows": 300,
              "cache_timeout_policies": 300,
              "future_config_field": {"safe": true}
            }
        """.trimIndent()
    }
}
