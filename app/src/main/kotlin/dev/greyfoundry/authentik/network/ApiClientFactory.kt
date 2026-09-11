package dev.greyfoundry.authentik.network

import dev.greyfoundry.authentik.domain.model.InstanceProfile
import dev.greyfoundry.authentik.generated.api.AdminApi
import dev.greyfoundry.authentik.generated.api.RootApi
import dev.greyfoundry.authentik.generated.infrastructure.Serializer
import java.util.concurrent.TimeUnit
import kotlinx.serialization.json.Json
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

class AuthentikApiClient internal constructor(
    internal val adminApi: AdminApi,
    internal val rootApi: RootApi,
    internal val okHttpClient: OkHttpClient,
)

class ApiClientFactory {
    fun create(instance: InstanceProfile): AuthentikApiClient =
        create(instance.baseUrl.toHttpUrl())

    internal fun createForLocalTest(baseUrl: HttpUrl): AuthentikApiClient {
        require(baseUrl.host in LOCAL_TEST_HOSTS) {
            "Plain HTTP test clients are limited to local loopback hosts."
        }
        return create(baseUrl)
    }

    private fun create(instanceBaseUrl: HttpUrl): AuthentikApiClient {
        require(instanceBaseUrl.encodedPath.endsWith('/')) {
            "Instance base URL must end with a slash."
        }

        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(CONNECT_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .callTimeout(CALL_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .followRedirects(false)
            .followSslRedirects(false)
            .retryOnConnectionFailure(false)
            .build()
        val apiBaseUrl = instanceBaseUrl.resolve("api/v3/")
            ?: error("Unable to resolve the authentik API base URL.")
        val json = Json {
            serializersModule = Serializer.kotlinxSerializationAdapters
            ignoreUnknownKeys = true
        }
        val retrofit = Retrofit.Builder()
            .baseUrl(apiBaseUrl)
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory(JSON_MEDIA_TYPE))
            .build()

        return AuthentikApiClient(
            adminApi = retrofit.create(AdminApi::class.java),
            rootApi = retrofit.create(RootApi::class.java),
            okHttpClient = okHttpClient,
        )
    }

    private companion object {
        const val CONNECT_TIMEOUT_SECONDS = 10L
        const val READ_TIMEOUT_SECONDS = 30L
        const val WRITE_TIMEOUT_SECONDS = 30L
        const val CALL_TIMEOUT_SECONDS = 45L

        val JSON_MEDIA_TYPE = "application/json".toMediaType()
        val LOCAL_TEST_HOSTS = setOf("localhost", "127.0.0.1", "::1")
    }
}
