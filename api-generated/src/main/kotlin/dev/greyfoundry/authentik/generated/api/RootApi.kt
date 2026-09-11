package dev.greyfoundry.authentik.generated.api

import dev.greyfoundry.authentik.generated.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import dev.greyfoundry.authentik.generated.model.Config
import dev.greyfoundry.authentik.generated.model.GenericError
import dev.greyfoundry.authentik.generated.model.ValidationError

interface RootApi {
    /**
     * GET root/config/
     *
     * Retrieve public configuration options
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @return [Config]
     */
    @GET("root/config/")
    suspend fun rootConfigRetrieve(): Response<Config>

}
