package dev.greyfoundry.authentik.generated.api

import dev.greyfoundry.authentik.generated.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import dev.greyfoundry.authentik.generated.model.FormatEnum
import dev.greyfoundry.authentik.generated.model.GenericError
import dev.greyfoundry.authentik.generated.model.LangEnum
import dev.greyfoundry.authentik.generated.model.ValidationError

interface SchemaApi {
    /**
     * GET schema/
     *
     * OpenApi3 schema for this API. Format can be selected via content negotiation.  - YAML: application/vnd.oai.openapi - JSON: application/vnd.oai.openapi+json
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param format  (optional)
     * @param lang  (optional)
     * @return [kotlin.collections.Map<kotlin.String, kotlinx.serialization.json.JsonElement>]
     */
    @GET("schema/")
    suspend fun schemaRetrieve(@Query("format") format: FormatEnum? = null, @Query("lang") lang: LangEnum? = null): Response<kotlin.collections.Map<kotlin.String, kotlinx.serialization.json.JsonElement>>

}
