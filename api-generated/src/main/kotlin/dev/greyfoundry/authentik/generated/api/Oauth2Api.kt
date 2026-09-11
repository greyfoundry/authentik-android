package dev.greyfoundry.authentik.generated.api

import dev.greyfoundry.authentik.generated.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import dev.greyfoundry.authentik.generated.model.ExpiringBaseGrantModel
import dev.greyfoundry.authentik.generated.model.GenericError
import dev.greyfoundry.authentik.generated.model.PaginatedExpiringBaseGrantModelList
import dev.greyfoundry.authentik.generated.model.PaginatedTokenModelList
import dev.greyfoundry.authentik.generated.model.TokenModel
import dev.greyfoundry.authentik.generated.model.UsedBy
import dev.greyfoundry.authentik.generated.model.ValidationError

interface Oauth2Api {
    /**
     * DELETE oauth2/access_tokens/{id}/
     *
     * AccessToken Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this OAuth2 Access Token.
     * @return [Unit]
     */
    @DELETE("oauth2/access_tokens/{id}/")
    suspend fun oauth2AccessTokensDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET oauth2/access_tokens/
     *
     * AccessToken Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param provider  (optional)
     * @param search A search term. (optional)
     * @param user  (optional)
     * @return [PaginatedTokenModelList]
     */
    @GET("oauth2/access_tokens/")
    suspend fun oauth2AccessTokensList(@Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("provider") provider: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("user") user: kotlin.Int? = null): Response<PaginatedTokenModelList>

    /**
     * GET oauth2/access_tokens/{id}/
     *
     * AccessToken Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this OAuth2 Access Token.
     * @return [TokenModel]
     */
    @GET("oauth2/access_tokens/{id}/")
    suspend fun oauth2AccessTokensRetrieve(@Path("id") id: kotlin.Int): Response<TokenModel>

    /**
     * GET oauth2/access_tokens/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this OAuth2 Access Token.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("oauth2/access_tokens/{id}/used_by/")
    suspend fun oauth2AccessTokensUsedByList(@Path("id") id: kotlin.Int): Response<kotlin.collections.List<UsedBy>>

    /**
     * DELETE oauth2/authorization_codes/{id}/
     *
     * AuthorizationCode Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Authorization Code.
     * @return [Unit]
     */
    @DELETE("oauth2/authorization_codes/{id}/")
    suspend fun oauth2AuthorizationCodesDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET oauth2/authorization_codes/
     *
     * AuthorizationCode Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param provider  (optional)
     * @param search A search term. (optional)
     * @param user  (optional)
     * @return [PaginatedExpiringBaseGrantModelList]
     */
    @GET("oauth2/authorization_codes/")
    suspend fun oauth2AuthorizationCodesList(@Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("provider") provider: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("user") user: kotlin.Int? = null): Response<PaginatedExpiringBaseGrantModelList>

    /**
     * GET oauth2/authorization_codes/{id}/
     *
     * AuthorizationCode Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Authorization Code.
     * @return [ExpiringBaseGrantModel]
     */
    @GET("oauth2/authorization_codes/{id}/")
    suspend fun oauth2AuthorizationCodesRetrieve(@Path("id") id: kotlin.Int): Response<ExpiringBaseGrantModel>

    /**
     * GET oauth2/authorization_codes/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Authorization Code.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("oauth2/authorization_codes/{id}/used_by/")
    suspend fun oauth2AuthorizationCodesUsedByList(@Path("id") id: kotlin.Int): Response<kotlin.collections.List<UsedBy>>

    /**
     * DELETE oauth2/refresh_tokens/{id}/
     *
     * RefreshToken Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this OAuth2 Refresh Token.
     * @return [Unit]
     */
    @DELETE("oauth2/refresh_tokens/{id}/")
    suspend fun oauth2RefreshTokensDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET oauth2/refresh_tokens/
     *
     * RefreshToken Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param provider  (optional)
     * @param search A search term. (optional)
     * @param user  (optional)
     * @return [PaginatedTokenModelList]
     */
    @GET("oauth2/refresh_tokens/")
    suspend fun oauth2RefreshTokensList(@Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("provider") provider: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("user") user: kotlin.Int? = null): Response<PaginatedTokenModelList>

    /**
     * GET oauth2/refresh_tokens/{id}/
     *
     * RefreshToken Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this OAuth2 Refresh Token.
     * @return [TokenModel]
     */
    @GET("oauth2/refresh_tokens/{id}/")
    suspend fun oauth2RefreshTokensRetrieve(@Path("id") id: kotlin.Int): Response<TokenModel>

    /**
     * GET oauth2/refresh_tokens/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this OAuth2 Refresh Token.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("oauth2/refresh_tokens/{id}/used_by/")
    suspend fun oauth2RefreshTokensUsedByList(@Path("id") id: kotlin.Int): Response<kotlin.collections.List<UsedBy>>

}
