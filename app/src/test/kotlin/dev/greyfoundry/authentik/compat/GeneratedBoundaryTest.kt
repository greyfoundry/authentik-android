package dev.greyfoundry.authentik.compat

import dev.greyfoundry.authentik.domain.model.CompatibilityLevel
import dev.greyfoundry.authentik.domain.model.ServerEdition
import dev.greyfoundry.authentik.domain.model.ServerProfile
import java.nio.file.Files
import java.nio.file.Path
import java.util.concurrent.atomic.AtomicReference
import kotlin.coroutines.Continuation
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.startCoroutine
import org.junit.Assert.assertEquals
import org.junit.Assert.assertSame
import org.junit.Test

class GeneratedBoundaryTest {
    @Test
    fun `gateway returns an app-owned server profile`() {
        val expected = ServerProfile(
            versionCurrent = "2026.8.1",
            versionLatest = "2026.8.1",
            buildHash = "b4de7336",
            outdated = false,
            outpostOutdated = false,
            edition = ServerEdition.COMMUNITY,
            compatibilityLevel = CompatibilityLevel.SUPPORTED,
        )
        val gateway = object : AuthentikGateway {
            override suspend fun serverProfile(): ServerProfile = expected
        }

        assertSame(expected, runSuspend { gateway.serverProfile() })
    }

    @Test
    fun `generated imports stay inside transport boundary packages`() {
        val sourceRoot = Path.of(
            System.getProperty("user.dir"),
            "src",
            "main",
            "kotlin",
            "dev",
            "greyfoundry",
            "authentik",
        )
        val allowedPrefixes = listOf("compat/", "network/")

        val violations = Files.walk(sourceRoot).use { paths ->
            paths
                .filter { path -> Files.isRegularFile(path) && path.toString().endsWith(".kt") }
                .map { path ->
                    sourceRoot.relativize(path).toString().replace('\\', '/') to
                        Files.readString(path)
                }
                .filter { (relativePath, source) ->
                    allowedPrefixes.none(relativePath::startsWith) &&
                        GENERATED_IMPORT in source
                }
                .map { (relativePath, _) -> relativePath }
                .sorted()
                .toList()
        }

        assertEquals(
            "Generated transport imports escaped the compat/network boundary.",
            emptyList<String>(),
            violations,
        )
    }

    private fun <T> runSuspend(block: suspend () -> T): T {
        val outcome = AtomicReference<Result<T>>()
        block.startCoroutine(
            object : Continuation<T> {
                override val context = EmptyCoroutineContext

                override fun resumeWith(result: Result<T>) {
                    outcome.set(result)
                }
            },
        )
        return checkNotNull(outcome.get()) { "Test coroutine did not complete synchronously." }
            .getOrThrow()
    }

    private companion object {
        const val GENERATED_IMPORT = "import dev.greyfoundry.authentik.generated."
    }
}
