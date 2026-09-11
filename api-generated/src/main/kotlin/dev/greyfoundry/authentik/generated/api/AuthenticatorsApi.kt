package dev.greyfoundry.authentik.generated.api

import dev.greyfoundry.authentik.generated.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import dev.greyfoundry.authentik.generated.model.Device
import dev.greyfoundry.authentik.generated.model.DuoDevice
import dev.greyfoundry.authentik.generated.model.DuoDeviceRequest
import dev.greyfoundry.authentik.generated.model.EmailDevice
import dev.greyfoundry.authentik.generated.model.EmailDeviceRequest
import dev.greyfoundry.authentik.generated.model.GenericError
import dev.greyfoundry.authentik.generated.model.GoogleEndpointDevice
import dev.greyfoundry.authentik.generated.model.GoogleEndpointDeviceRequest
import dev.greyfoundry.authentik.generated.model.PaginatedDuoDeviceList
import dev.greyfoundry.authentik.generated.model.PaginatedEmailDeviceList
import dev.greyfoundry.authentik.generated.model.PaginatedGoogleEndpointDeviceList
import dev.greyfoundry.authentik.generated.model.PaginatedSMSDeviceList
import dev.greyfoundry.authentik.generated.model.PaginatedStaticDeviceList
import dev.greyfoundry.authentik.generated.model.PaginatedTOTPDeviceList
import dev.greyfoundry.authentik.generated.model.PaginatedWebAuthnDeviceList
import dev.greyfoundry.authentik.generated.model.PatchedDuoDeviceRequest
import dev.greyfoundry.authentik.generated.model.PatchedEmailDeviceRequest
import dev.greyfoundry.authentik.generated.model.PatchedGoogleEndpointDeviceRequest
import dev.greyfoundry.authentik.generated.model.PatchedSMSDeviceRequest
import dev.greyfoundry.authentik.generated.model.PatchedStaticDeviceRequest
import dev.greyfoundry.authentik.generated.model.PatchedTOTPDeviceRequest
import dev.greyfoundry.authentik.generated.model.PatchedWebAuthnDeviceRequest
import dev.greyfoundry.authentik.generated.model.SMSDevice
import dev.greyfoundry.authentik.generated.model.SMSDeviceRequest
import dev.greyfoundry.authentik.generated.model.StaticDevice
import dev.greyfoundry.authentik.generated.model.StaticDeviceRequest
import dev.greyfoundry.authentik.generated.model.TOTPDevice
import dev.greyfoundry.authentik.generated.model.TOTPDeviceRequest
import dev.greyfoundry.authentik.generated.model.UsedBy
import dev.greyfoundry.authentik.generated.model.ValidationError
import dev.greyfoundry.authentik.generated.model.WebAuthnDevice
import dev.greyfoundry.authentik.generated.model.WebAuthnDeviceRequest

interface AuthenticatorsApi {
    /**
     * GET authenticators/admin/all/
     *
     * Get all devices for current user
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param user  (optional)
     * @return [kotlin.collections.List<Device>]
     */
    @GET("authenticators/admin/all/")
    suspend fun authenticatorsAdminAllList(@Query("user") user: kotlin.Int? = null): Response<kotlin.collections.List<Device>>

    /**
     * POST authenticators/admin/duo/
     *
     * Viewset for Duo authenticator devices (for admins)
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param duoDeviceRequest
     * @return [DuoDevice]
     */
    @POST("authenticators/admin/duo/")
    suspend fun authenticatorsAdminDuoCreate(@Body duoDeviceRequest: DuoDeviceRequest): Response<DuoDevice>

    /**
     * DELETE authenticators/admin/duo/{id}/
     *
     * Viewset for Duo authenticator devices (for admins)
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Duo Device.
     * @return [Unit]
     */
    @DELETE("authenticators/admin/duo/{id}/")
    suspend fun authenticatorsAdminDuoDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET authenticators/admin/duo/
     *
     * Viewset for Duo authenticator devices (for admins)
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedDuoDeviceList]
     */
    @GET("authenticators/admin/duo/")
    suspend fun authenticatorsAdminDuoList(@Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedDuoDeviceList>

    /**
     * PATCH authenticators/admin/duo/{id}/
     *
     * Viewset for Duo authenticator devices (for admins)
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Duo Device.
     * @param patchedDuoDeviceRequest  (optional)
     * @return [DuoDevice]
     */
    @PATCH("authenticators/admin/duo/{id}/")
    suspend fun authenticatorsAdminDuoPartialUpdate(@Path("id") id: kotlin.Int, @Body patchedDuoDeviceRequest: PatchedDuoDeviceRequest? = null): Response<DuoDevice>

    /**
     * GET authenticators/admin/duo/{id}/
     *
     * Viewset for Duo authenticator devices (for admins)
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Duo Device.
     * @return [DuoDevice]
     */
    @GET("authenticators/admin/duo/{id}/")
    suspend fun authenticatorsAdminDuoRetrieve(@Path("id") id: kotlin.Int): Response<DuoDevice>

    /**
     * PUT authenticators/admin/duo/{id}/
     *
     * Viewset for Duo authenticator devices (for admins)
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Duo Device.
     * @param duoDeviceRequest
     * @return [DuoDevice]
     */
    @PUT("authenticators/admin/duo/{id}/")
    suspend fun authenticatorsAdminDuoUpdate(@Path("id") id: kotlin.Int, @Body duoDeviceRequest: DuoDeviceRequest): Response<DuoDevice>

    /**
     * POST authenticators/admin/email/
     *
     * Viewset for email authenticator devices (for admins)
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param emailDeviceRequest
     * @return [EmailDevice]
     */
    @POST("authenticators/admin/email/")
    suspend fun authenticatorsAdminEmailCreate(@Body emailDeviceRequest: EmailDeviceRequest): Response<EmailDevice>

    /**
     * DELETE authenticators/admin/email/{id}/
     *
     * Viewset for email authenticator devices (for admins)
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Email Device.
     * @return [Unit]
     */
    @DELETE("authenticators/admin/email/{id}/")
    suspend fun authenticatorsAdminEmailDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET authenticators/admin/email/
     *
     * Viewset for email authenticator devices (for admins)
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedEmailDeviceList]
     */
    @GET("authenticators/admin/email/")
    suspend fun authenticatorsAdminEmailList(@Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedEmailDeviceList>

    /**
     * PATCH authenticators/admin/email/{id}/
     *
     * Viewset for email authenticator devices (for admins)
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Email Device.
     * @param patchedEmailDeviceRequest  (optional)
     * @return [EmailDevice]
     */
    @PATCH("authenticators/admin/email/{id}/")
    suspend fun authenticatorsAdminEmailPartialUpdate(@Path("id") id: kotlin.Int, @Body patchedEmailDeviceRequest: PatchedEmailDeviceRequest? = null): Response<EmailDevice>

    /**
     * GET authenticators/admin/email/{id}/
     *
     * Viewset for email authenticator devices (for admins)
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Email Device.
     * @return [EmailDevice]
     */
    @GET("authenticators/admin/email/{id}/")
    suspend fun authenticatorsAdminEmailRetrieve(@Path("id") id: kotlin.Int): Response<EmailDevice>

    /**
     * PUT authenticators/admin/email/{id}/
     *
     * Viewset for email authenticator devices (for admins)
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Email Device.
     * @param emailDeviceRequest
     * @return [EmailDevice]
     */
    @PUT("authenticators/admin/email/{id}/")
    suspend fun authenticatorsAdminEmailUpdate(@Path("id") id: kotlin.Int, @Body emailDeviceRequest: EmailDeviceRequest): Response<EmailDevice>

    /**
     * POST authenticators/admin/endpoint/
     *
     * Viewset for Endpoint authenticator devices (for admins)
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param googleEndpointDeviceRequest
     * @return [GoogleEndpointDevice]
     */
    @POST("authenticators/admin/endpoint/")
    suspend fun authenticatorsAdminEndpointCreate(@Body googleEndpointDeviceRequest: GoogleEndpointDeviceRequest): Response<GoogleEndpointDevice>

    /**
     * DELETE authenticators/admin/endpoint/{uuid}/
     *
     * Viewset for Endpoint authenticator devices (for admins)
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Endpoint Device.
     * @return [Unit]
     */
    @DELETE("authenticators/admin/endpoint/{uuid}/")
    suspend fun authenticatorsAdminEndpointDestroy(@Path("uuid") uuid: java.util.UUID): Response<Unit>

    /**
     * GET authenticators/admin/endpoint/
     *
     * Viewset for Endpoint authenticator devices (for admins)
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedGoogleEndpointDeviceList]
     */
    @GET("authenticators/admin/endpoint/")
    suspend fun authenticatorsAdminEndpointList(@Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedGoogleEndpointDeviceList>

    /**
     * PATCH authenticators/admin/endpoint/{uuid}/
     *
     * Viewset for Endpoint authenticator devices (for admins)
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Endpoint Device.
     * @param patchedGoogleEndpointDeviceRequest  (optional)
     * @return [GoogleEndpointDevice]
     */
    @PATCH("authenticators/admin/endpoint/{uuid}/")
    suspend fun authenticatorsAdminEndpointPartialUpdate(@Path("uuid") uuid: java.util.UUID, @Body patchedGoogleEndpointDeviceRequest: PatchedGoogleEndpointDeviceRequest? = null): Response<GoogleEndpointDevice>

    /**
     * GET authenticators/admin/endpoint/{uuid}/
     *
     * Viewset for Endpoint authenticator devices (for admins)
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Endpoint Device.
     * @return [GoogleEndpointDevice]
     */
    @GET("authenticators/admin/endpoint/{uuid}/")
    suspend fun authenticatorsAdminEndpointRetrieve(@Path("uuid") uuid: java.util.UUID): Response<GoogleEndpointDevice>

    /**
     * PUT authenticators/admin/endpoint/{uuid}/
     *
     * Viewset for Endpoint authenticator devices (for admins)
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Endpoint Device.
     * @param googleEndpointDeviceRequest
     * @return [GoogleEndpointDevice]
     */
    @PUT("authenticators/admin/endpoint/{uuid}/")
    suspend fun authenticatorsAdminEndpointUpdate(@Path("uuid") uuid: java.util.UUID, @Body googleEndpointDeviceRequest: GoogleEndpointDeviceRequest): Response<GoogleEndpointDevice>

    /**
     * POST authenticators/admin/sms/
     *
     * Viewset for sms authenticator devices (for admins)
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param smSDeviceRequest
     * @return [SMSDevice]
     */
    @POST("authenticators/admin/sms/")
    suspend fun authenticatorsAdminSmsCreate(@Body smSDeviceRequest: SMSDeviceRequest): Response<SMSDevice>

    /**
     * DELETE authenticators/admin/sms/{id}/
     *
     * Viewset for sms authenticator devices (for admins)
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this SMS Device.
     * @return [Unit]
     */
    @DELETE("authenticators/admin/sms/{id}/")
    suspend fun authenticatorsAdminSmsDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET authenticators/admin/sms/
     *
     * Viewset for sms authenticator devices (for admins)
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedSMSDeviceList]
     */
    @GET("authenticators/admin/sms/")
    suspend fun authenticatorsAdminSmsList(@Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedSMSDeviceList>

    /**
     * PATCH authenticators/admin/sms/{id}/
     *
     * Viewset for sms authenticator devices (for admins)
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this SMS Device.
     * @param patchedSMSDeviceRequest  (optional)
     * @return [SMSDevice]
     */
    @PATCH("authenticators/admin/sms/{id}/")
    suspend fun authenticatorsAdminSmsPartialUpdate(@Path("id") id: kotlin.Int, @Body patchedSMSDeviceRequest: PatchedSMSDeviceRequest? = null): Response<SMSDevice>

    /**
     * GET authenticators/admin/sms/{id}/
     *
     * Viewset for sms authenticator devices (for admins)
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this SMS Device.
     * @return [SMSDevice]
     */
    @GET("authenticators/admin/sms/{id}/")
    suspend fun authenticatorsAdminSmsRetrieve(@Path("id") id: kotlin.Int): Response<SMSDevice>

    /**
     * PUT authenticators/admin/sms/{id}/
     *
     * Viewset for sms authenticator devices (for admins)
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this SMS Device.
     * @param smSDeviceRequest
     * @return [SMSDevice]
     */
    @PUT("authenticators/admin/sms/{id}/")
    suspend fun authenticatorsAdminSmsUpdate(@Path("id") id: kotlin.Int, @Body smSDeviceRequest: SMSDeviceRequest): Response<SMSDevice>

    /**
     * POST authenticators/admin/static/
     *
     * Viewset for static authenticator devices (for admins)
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param staticDeviceRequest
     * @return [StaticDevice]
     */
    @POST("authenticators/admin/static/")
    suspend fun authenticatorsAdminStaticCreate(@Body staticDeviceRequest: StaticDeviceRequest): Response<StaticDevice>

    /**
     * DELETE authenticators/admin/static/{id}/
     *
     * Viewset for static authenticator devices (for admins)
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Static Device.
     * @return [Unit]
     */
    @DELETE("authenticators/admin/static/{id}/")
    suspend fun authenticatorsAdminStaticDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET authenticators/admin/static/
     *
     * Viewset for static authenticator devices (for admins)
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedStaticDeviceList]
     */
    @GET("authenticators/admin/static/")
    suspend fun authenticatorsAdminStaticList(@Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedStaticDeviceList>

    /**
     * PATCH authenticators/admin/static/{id}/
     *
     * Viewset for static authenticator devices (for admins)
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Static Device.
     * @param patchedStaticDeviceRequest  (optional)
     * @return [StaticDevice]
     */
    @PATCH("authenticators/admin/static/{id}/")
    suspend fun authenticatorsAdminStaticPartialUpdate(@Path("id") id: kotlin.Int, @Body patchedStaticDeviceRequest: PatchedStaticDeviceRequest? = null): Response<StaticDevice>

    /**
     * GET authenticators/admin/static/{id}/
     *
     * Viewset for static authenticator devices (for admins)
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Static Device.
     * @return [StaticDevice]
     */
    @GET("authenticators/admin/static/{id}/")
    suspend fun authenticatorsAdminStaticRetrieve(@Path("id") id: kotlin.Int): Response<StaticDevice>

    /**
     * PUT authenticators/admin/static/{id}/
     *
     * Viewset for static authenticator devices (for admins)
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Static Device.
     * @param staticDeviceRequest
     * @return [StaticDevice]
     */
    @PUT("authenticators/admin/static/{id}/")
    suspend fun authenticatorsAdminStaticUpdate(@Path("id") id: kotlin.Int, @Body staticDeviceRequest: StaticDeviceRequest): Response<StaticDevice>

    /**
     * POST authenticators/admin/totp/
     *
     * Viewset for totp authenticator devices (for admins)
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param toTPDeviceRequest
     * @return [TOTPDevice]
     */
    @POST("authenticators/admin/totp/")
    suspend fun authenticatorsAdminTotpCreate(@Body toTPDeviceRequest: TOTPDeviceRequest): Response<TOTPDevice>

    /**
     * DELETE authenticators/admin/totp/{id}/
     *
     * Viewset for totp authenticator devices (for admins)
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this TOTP Device.
     * @return [Unit]
     */
    @DELETE("authenticators/admin/totp/{id}/")
    suspend fun authenticatorsAdminTotpDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET authenticators/admin/totp/
     *
     * Viewset for totp authenticator devices (for admins)
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedTOTPDeviceList]
     */
    @GET("authenticators/admin/totp/")
    suspend fun authenticatorsAdminTotpList(@Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedTOTPDeviceList>

    /**
     * PATCH authenticators/admin/totp/{id}/
     *
     * Viewset for totp authenticator devices (for admins)
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this TOTP Device.
     * @param patchedTOTPDeviceRequest  (optional)
     * @return [TOTPDevice]
     */
    @PATCH("authenticators/admin/totp/{id}/")
    suspend fun authenticatorsAdminTotpPartialUpdate(@Path("id") id: kotlin.Int, @Body patchedTOTPDeviceRequest: PatchedTOTPDeviceRequest? = null): Response<TOTPDevice>

    /**
     * GET authenticators/admin/totp/{id}/
     *
     * Viewset for totp authenticator devices (for admins)
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this TOTP Device.
     * @return [TOTPDevice]
     */
    @GET("authenticators/admin/totp/{id}/")
    suspend fun authenticatorsAdminTotpRetrieve(@Path("id") id: kotlin.Int): Response<TOTPDevice>

    /**
     * PUT authenticators/admin/totp/{id}/
     *
     * Viewset for totp authenticator devices (for admins)
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this TOTP Device.
     * @param toTPDeviceRequest
     * @return [TOTPDevice]
     */
    @PUT("authenticators/admin/totp/{id}/")
    suspend fun authenticatorsAdminTotpUpdate(@Path("id") id: kotlin.Int, @Body toTPDeviceRequest: TOTPDeviceRequest): Response<TOTPDevice>

    /**
     * POST authenticators/admin/webauthn/
     *
     * Viewset for WebAuthn authenticator devices (for admins)
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param webAuthnDeviceRequest
     * @return [WebAuthnDevice]
     */
    @POST("authenticators/admin/webauthn/")
    suspend fun authenticatorsAdminWebauthnCreate(@Body webAuthnDeviceRequest: WebAuthnDeviceRequest): Response<WebAuthnDevice>

    /**
     * DELETE authenticators/admin/webauthn/{id}/
     *
     * Viewset for WebAuthn authenticator devices (for admins)
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this WebAuthn Device.
     * @return [Unit]
     */
    @DELETE("authenticators/admin/webauthn/{id}/")
    suspend fun authenticatorsAdminWebauthnDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET authenticators/admin/webauthn/
     *
     * Viewset for WebAuthn authenticator devices (for admins)
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedWebAuthnDeviceList]
     */
    @GET("authenticators/admin/webauthn/")
    suspend fun authenticatorsAdminWebauthnList(@Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedWebAuthnDeviceList>

    /**
     * PATCH authenticators/admin/webauthn/{id}/
     *
     * Viewset for WebAuthn authenticator devices (for admins)
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this WebAuthn Device.
     * @param patchedWebAuthnDeviceRequest  (optional)
     * @return [WebAuthnDevice]
     */
    @PATCH("authenticators/admin/webauthn/{id}/")
    suspend fun authenticatorsAdminWebauthnPartialUpdate(@Path("id") id: kotlin.Int, @Body patchedWebAuthnDeviceRequest: PatchedWebAuthnDeviceRequest? = null): Response<WebAuthnDevice>

    /**
     * GET authenticators/admin/webauthn/{id}/
     *
     * Viewset for WebAuthn authenticator devices (for admins)
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this WebAuthn Device.
     * @return [WebAuthnDevice]
     */
    @GET("authenticators/admin/webauthn/{id}/")
    suspend fun authenticatorsAdminWebauthnRetrieve(@Path("id") id: kotlin.Int): Response<WebAuthnDevice>

    /**
     * PUT authenticators/admin/webauthn/{id}/
     *
     * Viewset for WebAuthn authenticator devices (for admins)
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this WebAuthn Device.
     * @param webAuthnDeviceRequest
     * @return [WebAuthnDevice]
     */
    @PUT("authenticators/admin/webauthn/{id}/")
    suspend fun authenticatorsAdminWebauthnUpdate(@Path("id") id: kotlin.Int, @Body webAuthnDeviceRequest: WebAuthnDeviceRequest): Response<WebAuthnDevice>

    /**
     * GET authenticators/all/
     *
     * Get all devices for current user
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @return [kotlin.collections.List<Device>]
     */
    @GET("authenticators/all/")
    suspend fun authenticatorsAllList(): Response<kotlin.collections.List<Device>>

    /**
     * DELETE authenticators/duo/{id}/
     *
     * Viewset for Duo authenticator devices
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Duo Device.
     * @return [Unit]
     */
    @DELETE("authenticators/duo/{id}/")
    suspend fun authenticatorsDuoDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET authenticators/duo/
     *
     * Viewset for Duo authenticator devices
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedDuoDeviceList]
     */
    @GET("authenticators/duo/")
    suspend fun authenticatorsDuoList(@Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedDuoDeviceList>

    /**
     * PATCH authenticators/duo/{id}/
     *
     * Viewset for Duo authenticator devices
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Duo Device.
     * @param patchedDuoDeviceRequest  (optional)
     * @return [DuoDevice]
     */
    @PATCH("authenticators/duo/{id}/")
    suspend fun authenticatorsDuoPartialUpdate(@Path("id") id: kotlin.Int, @Body patchedDuoDeviceRequest: PatchedDuoDeviceRequest? = null): Response<DuoDevice>

    /**
     * GET authenticators/duo/{id}/
     *
     * Viewset for Duo authenticator devices
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Duo Device.
     * @return [DuoDevice]
     */
    @GET("authenticators/duo/{id}/")
    suspend fun authenticatorsDuoRetrieve(@Path("id") id: kotlin.Int): Response<DuoDevice>

    /**
     * PUT authenticators/duo/{id}/
     *
     * Viewset for Duo authenticator devices
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Duo Device.
     * @param duoDeviceRequest
     * @return [DuoDevice]
     */
    @PUT("authenticators/duo/{id}/")
    suspend fun authenticatorsDuoUpdate(@Path("id") id: kotlin.Int, @Body duoDeviceRequest: DuoDeviceRequest): Response<DuoDevice>

    /**
     * GET authenticators/duo/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Duo Device.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("authenticators/duo/{id}/used_by/")
    suspend fun authenticatorsDuoUsedByList(@Path("id") id: kotlin.Int): Response<kotlin.collections.List<UsedBy>>

    /**
     * DELETE authenticators/email/{id}/
     *
     * Viewset for email authenticator devices
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Email Device.
     * @return [Unit]
     */
    @DELETE("authenticators/email/{id}/")
    suspend fun authenticatorsEmailDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET authenticators/email/
     *
     * Viewset for email authenticator devices
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedEmailDeviceList]
     */
    @GET("authenticators/email/")
    suspend fun authenticatorsEmailList(@Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedEmailDeviceList>

    /**
     * PATCH authenticators/email/{id}/
     *
     * Viewset for email authenticator devices
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Email Device.
     * @param patchedEmailDeviceRequest  (optional)
     * @return [EmailDevice]
     */
    @PATCH("authenticators/email/{id}/")
    suspend fun authenticatorsEmailPartialUpdate(@Path("id") id: kotlin.Int, @Body patchedEmailDeviceRequest: PatchedEmailDeviceRequest? = null): Response<EmailDevice>

    /**
     * GET authenticators/email/{id}/
     *
     * Viewset for email authenticator devices
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Email Device.
     * @return [EmailDevice]
     */
    @GET("authenticators/email/{id}/")
    suspend fun authenticatorsEmailRetrieve(@Path("id") id: kotlin.Int): Response<EmailDevice>

    /**
     * PUT authenticators/email/{id}/
     *
     * Viewset for email authenticator devices
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Email Device.
     * @param emailDeviceRequest
     * @return [EmailDevice]
     */
    @PUT("authenticators/email/{id}/")
    suspend fun authenticatorsEmailUpdate(@Path("id") id: kotlin.Int, @Body emailDeviceRequest: EmailDeviceRequest): Response<EmailDevice>

    /**
     * GET authenticators/email/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Email Device.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("authenticators/email/{id}/used_by/")
    suspend fun authenticatorsEmailUsedByList(@Path("id") id: kotlin.Int): Response<kotlin.collections.List<UsedBy>>

    /**
     * GET authenticators/endpoint/
     *
     * Viewset for Endpoint authenticator devices
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedGoogleEndpointDeviceList]
     */
    @GET("authenticators/endpoint/")
    suspend fun authenticatorsEndpointList(@Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedGoogleEndpointDeviceList>

    /**
     * GET authenticators/endpoint/{uuid}/
     *
     * Viewset for Endpoint authenticator devices
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Endpoint Device.
     * @return [GoogleEndpointDevice]
     */
    @GET("authenticators/endpoint/{uuid}/")
    suspend fun authenticatorsEndpointRetrieve(@Path("uuid") uuid: java.util.UUID): Response<GoogleEndpointDevice>

    /**
     * GET authenticators/endpoint/{uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Endpoint Device.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("authenticators/endpoint/{uuid}/used_by/")
    suspend fun authenticatorsEndpointUsedByList(@Path("uuid") uuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * DELETE authenticators/sms/{id}/
     *
     * Viewset for sms authenticator devices
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this SMS Device.
     * @return [Unit]
     */
    @DELETE("authenticators/sms/{id}/")
    suspend fun authenticatorsSmsDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET authenticators/sms/
     *
     * Viewset for sms authenticator devices
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedSMSDeviceList]
     */
    @GET("authenticators/sms/")
    suspend fun authenticatorsSmsList(@Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedSMSDeviceList>

    /**
     * PATCH authenticators/sms/{id}/
     *
     * Viewset for sms authenticator devices
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this SMS Device.
     * @param patchedSMSDeviceRequest  (optional)
     * @return [SMSDevice]
     */
    @PATCH("authenticators/sms/{id}/")
    suspend fun authenticatorsSmsPartialUpdate(@Path("id") id: kotlin.Int, @Body patchedSMSDeviceRequest: PatchedSMSDeviceRequest? = null): Response<SMSDevice>

    /**
     * GET authenticators/sms/{id}/
     *
     * Viewset for sms authenticator devices
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this SMS Device.
     * @return [SMSDevice]
     */
    @GET("authenticators/sms/{id}/")
    suspend fun authenticatorsSmsRetrieve(@Path("id") id: kotlin.Int): Response<SMSDevice>

    /**
     * PUT authenticators/sms/{id}/
     *
     * Viewset for sms authenticator devices
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this SMS Device.
     * @param smSDeviceRequest
     * @return [SMSDevice]
     */
    @PUT("authenticators/sms/{id}/")
    suspend fun authenticatorsSmsUpdate(@Path("id") id: kotlin.Int, @Body smSDeviceRequest: SMSDeviceRequest): Response<SMSDevice>

    /**
     * GET authenticators/sms/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this SMS Device.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("authenticators/sms/{id}/used_by/")
    suspend fun authenticatorsSmsUsedByList(@Path("id") id: kotlin.Int): Response<kotlin.collections.List<UsedBy>>

    /**
     * DELETE authenticators/static/{id}/
     *
     * Viewset for static authenticator devices
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Static Device.
     * @return [Unit]
     */
    @DELETE("authenticators/static/{id}/")
    suspend fun authenticatorsStaticDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET authenticators/static/
     *
     * Viewset for static authenticator devices
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedStaticDeviceList]
     */
    @GET("authenticators/static/")
    suspend fun authenticatorsStaticList(@Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedStaticDeviceList>

    /**
     * PATCH authenticators/static/{id}/
     *
     * Viewset for static authenticator devices
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Static Device.
     * @param patchedStaticDeviceRequest  (optional)
     * @return [StaticDevice]
     */
    @PATCH("authenticators/static/{id}/")
    suspend fun authenticatorsStaticPartialUpdate(@Path("id") id: kotlin.Int, @Body patchedStaticDeviceRequest: PatchedStaticDeviceRequest? = null): Response<StaticDevice>

    /**
     * GET authenticators/static/{id}/
     *
     * Viewset for static authenticator devices
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Static Device.
     * @return [StaticDevice]
     */
    @GET("authenticators/static/{id}/")
    suspend fun authenticatorsStaticRetrieve(@Path("id") id: kotlin.Int): Response<StaticDevice>

    /**
     * PUT authenticators/static/{id}/
     *
     * Viewset for static authenticator devices
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Static Device.
     * @param staticDeviceRequest
     * @return [StaticDevice]
     */
    @PUT("authenticators/static/{id}/")
    suspend fun authenticatorsStaticUpdate(@Path("id") id: kotlin.Int, @Body staticDeviceRequest: StaticDeviceRequest): Response<StaticDevice>

    /**
     * GET authenticators/static/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Static Device.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("authenticators/static/{id}/used_by/")
    suspend fun authenticatorsStaticUsedByList(@Path("id") id: kotlin.Int): Response<kotlin.collections.List<UsedBy>>

    /**
     * DELETE authenticators/totp/{id}/
     *
     * Viewset for totp authenticator devices
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this TOTP Device.
     * @return [Unit]
     */
    @DELETE("authenticators/totp/{id}/")
    suspend fun authenticatorsTotpDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET authenticators/totp/
     *
     * Viewset for totp authenticator devices
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedTOTPDeviceList]
     */
    @GET("authenticators/totp/")
    suspend fun authenticatorsTotpList(@Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedTOTPDeviceList>

    /**
     * PATCH authenticators/totp/{id}/
     *
     * Viewset for totp authenticator devices
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this TOTP Device.
     * @param patchedTOTPDeviceRequest  (optional)
     * @return [TOTPDevice]
     */
    @PATCH("authenticators/totp/{id}/")
    suspend fun authenticatorsTotpPartialUpdate(@Path("id") id: kotlin.Int, @Body patchedTOTPDeviceRequest: PatchedTOTPDeviceRequest? = null): Response<TOTPDevice>

    /**
     * GET authenticators/totp/{id}/
     *
     * Viewset for totp authenticator devices
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this TOTP Device.
     * @return [TOTPDevice]
     */
    @GET("authenticators/totp/{id}/")
    suspend fun authenticatorsTotpRetrieve(@Path("id") id: kotlin.Int): Response<TOTPDevice>

    /**
     * PUT authenticators/totp/{id}/
     *
     * Viewset for totp authenticator devices
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this TOTP Device.
     * @param toTPDeviceRequest
     * @return [TOTPDevice]
     */
    @PUT("authenticators/totp/{id}/")
    suspend fun authenticatorsTotpUpdate(@Path("id") id: kotlin.Int, @Body toTPDeviceRequest: TOTPDeviceRequest): Response<TOTPDevice>

    /**
     * GET authenticators/totp/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this TOTP Device.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("authenticators/totp/{id}/used_by/")
    suspend fun authenticatorsTotpUsedByList(@Path("id") id: kotlin.Int): Response<kotlin.collections.List<UsedBy>>

    /**
     * DELETE authenticators/webauthn/{id}/
     *
     * Viewset for WebAuthn authenticator devices
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this WebAuthn Device.
     * @return [Unit]
     */
    @DELETE("authenticators/webauthn/{id}/")
    suspend fun authenticatorsWebauthnDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET authenticators/webauthn/
     *
     * Viewset for WebAuthn authenticator devices
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedWebAuthnDeviceList]
     */
    @GET("authenticators/webauthn/")
    suspend fun authenticatorsWebauthnList(@Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedWebAuthnDeviceList>

    /**
     * PATCH authenticators/webauthn/{id}/
     *
     * Viewset for WebAuthn authenticator devices
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this WebAuthn Device.
     * @param patchedWebAuthnDeviceRequest  (optional)
     * @return [WebAuthnDevice]
     */
    @PATCH("authenticators/webauthn/{id}/")
    suspend fun authenticatorsWebauthnPartialUpdate(@Path("id") id: kotlin.Int, @Body patchedWebAuthnDeviceRequest: PatchedWebAuthnDeviceRequest? = null): Response<WebAuthnDevice>

    /**
     * GET authenticators/webauthn/{id}/
     *
     * Viewset for WebAuthn authenticator devices
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this WebAuthn Device.
     * @return [WebAuthnDevice]
     */
    @GET("authenticators/webauthn/{id}/")
    suspend fun authenticatorsWebauthnRetrieve(@Path("id") id: kotlin.Int): Response<WebAuthnDevice>

    /**
     * PUT authenticators/webauthn/{id}/
     *
     * Viewset for WebAuthn authenticator devices
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this WebAuthn Device.
     * @param webAuthnDeviceRequest
     * @return [WebAuthnDevice]
     */
    @PUT("authenticators/webauthn/{id}/")
    suspend fun authenticatorsWebauthnUpdate(@Path("id") id: kotlin.Int, @Body webAuthnDeviceRequest: WebAuthnDeviceRequest): Response<WebAuthnDevice>

    /**
     * GET authenticators/webauthn/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this WebAuthn Device.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("authenticators/webauthn/{id}/used_by/")
    suspend fun authenticatorsWebauthnUsedByList(@Path("id") id: kotlin.Int): Response<kotlin.collections.List<UsedBy>>

}
