package dev.greyfoundry.authentik.generated.api

import dev.greyfoundry.authentik.generated.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import dev.greyfoundry.authentik.generated.model.ConnectionToken
import dev.greyfoundry.authentik.generated.model.ConnectionTokenRequest
import dev.greyfoundry.authentik.generated.model.Endpoint
import dev.greyfoundry.authentik.generated.model.EndpointRequest
import dev.greyfoundry.authentik.generated.model.GenericError
import dev.greyfoundry.authentik.generated.model.PaginatedConnectionTokenList
import dev.greyfoundry.authentik.generated.model.PaginatedEndpointList
import dev.greyfoundry.authentik.generated.model.PatchedConnectionTokenRequest
import dev.greyfoundry.authentik.generated.model.PatchedEndpointRequest
import dev.greyfoundry.authentik.generated.model.UsedBy
import dev.greyfoundry.authentik.generated.model.ValidationError

interface RacApi {
    /**
     * DELETE rac/connection_tokens/{connection_token_uuid}/
     *
     * ConnectionToken Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param connectionTokenUuid A UUID string identifying this RAC Connection token.
     * @return [Unit]
     */
    @DELETE("rac/connection_tokens/{connection_token_uuid}/")
    suspend fun racConnectionTokensDestroy(@Path("connection_token_uuid") connectionTokenUuid: java.util.UUID): Response<Unit>

    /**
     * GET rac/connection_tokens/
     *
     * ConnectionToken Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param endpoint  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param provider  (optional)
     * @param search A search term. (optional)
     * @param sessionUser  (optional)
     * @return [PaginatedConnectionTokenList]
     */
    @GET("rac/connection_tokens/")
    suspend fun racConnectionTokensList(@Query("endpoint") endpoint: java.util.UUID? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("provider") provider: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("session__user") sessionUser: kotlin.Int? = null): Response<PaginatedConnectionTokenList>

    /**
     * PATCH rac/connection_tokens/{connection_token_uuid}/
     *
     * ConnectionToken Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param connectionTokenUuid A UUID string identifying this RAC Connection token.
     * @param patchedConnectionTokenRequest  (optional)
     * @return [ConnectionToken]
     */
    @PATCH("rac/connection_tokens/{connection_token_uuid}/")
    suspend fun racConnectionTokensPartialUpdate(@Path("connection_token_uuid") connectionTokenUuid: java.util.UUID, @Body patchedConnectionTokenRequest: PatchedConnectionTokenRequest? = null): Response<ConnectionToken>

    /**
     * GET rac/connection_tokens/{connection_token_uuid}/
     *
     * ConnectionToken Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param connectionTokenUuid A UUID string identifying this RAC Connection token.
     * @return [ConnectionToken]
     */
    @GET("rac/connection_tokens/{connection_token_uuid}/")
    suspend fun racConnectionTokensRetrieve(@Path("connection_token_uuid") connectionTokenUuid: java.util.UUID): Response<ConnectionToken>

    /**
     * PUT rac/connection_tokens/{connection_token_uuid}/
     *
     * ConnectionToken Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param connectionTokenUuid A UUID string identifying this RAC Connection token.
     * @param connectionTokenRequest
     * @return [ConnectionToken]
     */
    @PUT("rac/connection_tokens/{connection_token_uuid}/")
    suspend fun racConnectionTokensUpdate(@Path("connection_token_uuid") connectionTokenUuid: java.util.UUID, @Body connectionTokenRequest: ConnectionTokenRequest): Response<ConnectionToken>

    /**
     * GET rac/connection_tokens/{connection_token_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param connectionTokenUuid A UUID string identifying this RAC Connection token.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("rac/connection_tokens/{connection_token_uuid}/used_by/")
    suspend fun racConnectionTokensUsedByList(@Path("connection_token_uuid") connectionTokenUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST rac/endpoints/
     *
     * Endpoint Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param endpointRequest
     * @return [Endpoint]
     */
    @POST("rac/endpoints/")
    suspend fun racEndpointsCreate(@Body endpointRequest: EndpointRequest): Response<Endpoint>

    /**
     * DELETE rac/endpoints/{pbm_uuid}/
     *
     * Endpoint Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param pbmUuid A UUID string identifying this RAC Endpoint.
     * @return [Unit]
     */
    @DELETE("rac/endpoints/{pbm_uuid}/")
    suspend fun racEndpointsDestroy(@Path("pbm_uuid") pbmUuid: java.util.UUID): Response<Unit>

    /**
     * GET rac/endpoints/
     *
     * List accessible endpoints
     * Responses:
     *  - 200:
     *  - 400: Bad request
     *  - 403:
     *
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param provider  (optional)
     * @param search A search term. (optional)
     * @param superuserFullList  (optional)
     * @return [PaginatedEndpointList]
     */
    @GET("rac/endpoints/")
    suspend fun racEndpointsList(@Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("provider") provider: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("superuser_full_list") superuserFullList: kotlin.Boolean? = null): Response<PaginatedEndpointList>

    /**
     * PATCH rac/endpoints/{pbm_uuid}/
     *
     * Endpoint Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pbmUuid A UUID string identifying this RAC Endpoint.
     * @param patchedEndpointRequest  (optional)
     * @return [Endpoint]
     */
    @PATCH("rac/endpoints/{pbm_uuid}/")
    suspend fun racEndpointsPartialUpdate(@Path("pbm_uuid") pbmUuid: java.util.UUID, @Body patchedEndpointRequest: PatchedEndpointRequest? = null): Response<Endpoint>

    /**
     * GET rac/endpoints/{pbm_uuid}/
     *
     * Endpoint Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pbmUuid A UUID string identifying this RAC Endpoint.
     * @return [Endpoint]
     */
    @GET("rac/endpoints/{pbm_uuid}/")
    suspend fun racEndpointsRetrieve(@Path("pbm_uuid") pbmUuid: java.util.UUID): Response<Endpoint>

    /**
     * PUT rac/endpoints/{pbm_uuid}/
     *
     * Endpoint Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pbmUuid A UUID string identifying this RAC Endpoint.
     * @param endpointRequest
     * @return [Endpoint]
     */
    @PUT("rac/endpoints/{pbm_uuid}/")
    suspend fun racEndpointsUpdate(@Path("pbm_uuid") pbmUuid: java.util.UUID, @Body endpointRequest: EndpointRequest): Response<Endpoint>

    /**
     * GET rac/endpoints/{pbm_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pbmUuid A UUID string identifying this RAC Endpoint.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("rac/endpoints/{pbm_uuid}/used_by/")
    suspend fun racEndpointsUsedByList(@Path("pbm_uuid") pbmUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

}
