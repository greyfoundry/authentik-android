package dev.greyfoundry.authentik.generated.api

import dev.greyfoundry.authentik.generated.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import dev.greyfoundry.authentik.generated.model.GenericError
import dev.greyfoundry.authentik.generated.model.GoogleWorkspaceProviderMapping
import dev.greyfoundry.authentik.generated.model.GoogleWorkspaceProviderMappingRequest
import dev.greyfoundry.authentik.generated.model.KerberosSourcePropertyMapping
import dev.greyfoundry.authentik.generated.model.KerberosSourcePropertyMappingRequest
import dev.greyfoundry.authentik.generated.model.LDAPSourcePropertyMapping
import dev.greyfoundry.authentik.generated.model.LDAPSourcePropertyMappingRequest
import dev.greyfoundry.authentik.generated.model.MicrosoftEntraProviderMapping
import dev.greyfoundry.authentik.generated.model.MicrosoftEntraProviderMappingRequest
import dev.greyfoundry.authentik.generated.model.NotificationWebhookMapping
import dev.greyfoundry.authentik.generated.model.NotificationWebhookMappingRequest
import dev.greyfoundry.authentik.generated.model.OAuthSourcePropertyMapping
import dev.greyfoundry.authentik.generated.model.OAuthSourcePropertyMappingRequest
import dev.greyfoundry.authentik.generated.model.PaginatedGoogleWorkspaceProviderMappingList
import dev.greyfoundry.authentik.generated.model.PaginatedKerberosSourcePropertyMappingList
import dev.greyfoundry.authentik.generated.model.PaginatedLDAPSourcePropertyMappingList
import dev.greyfoundry.authentik.generated.model.PaginatedMicrosoftEntraProviderMappingList
import dev.greyfoundry.authentik.generated.model.PaginatedNotificationWebhookMappingList
import dev.greyfoundry.authentik.generated.model.PaginatedOAuthSourcePropertyMappingList
import dev.greyfoundry.authentik.generated.model.PaginatedPlexSourcePropertyMappingList
import dev.greyfoundry.authentik.generated.model.PaginatedPropertyMappingList
import dev.greyfoundry.authentik.generated.model.PaginatedRACPropertyMappingList
import dev.greyfoundry.authentik.generated.model.PaginatedRadiusProviderPropertyMappingList
import dev.greyfoundry.authentik.generated.model.PaginatedSAMLPropertyMappingList
import dev.greyfoundry.authentik.generated.model.PaginatedSAMLSourcePropertyMappingList
import dev.greyfoundry.authentik.generated.model.PaginatedSCIMMappingList
import dev.greyfoundry.authentik.generated.model.PaginatedSCIMSourcePropertyMappingList
import dev.greyfoundry.authentik.generated.model.PaginatedScopeMappingList
import dev.greyfoundry.authentik.generated.model.PaginatedTelegramSourcePropertyMappingList
import dev.greyfoundry.authentik.generated.model.PatchedGoogleWorkspaceProviderMappingRequest
import dev.greyfoundry.authentik.generated.model.PatchedKerberosSourcePropertyMappingRequest
import dev.greyfoundry.authentik.generated.model.PatchedLDAPSourcePropertyMappingRequest
import dev.greyfoundry.authentik.generated.model.PatchedMicrosoftEntraProviderMappingRequest
import dev.greyfoundry.authentik.generated.model.PatchedNotificationWebhookMappingRequest
import dev.greyfoundry.authentik.generated.model.PatchedOAuthSourcePropertyMappingRequest
import dev.greyfoundry.authentik.generated.model.PatchedPlexSourcePropertyMappingRequest
import dev.greyfoundry.authentik.generated.model.PatchedRACPropertyMappingRequest
import dev.greyfoundry.authentik.generated.model.PatchedRadiusProviderPropertyMappingRequest
import dev.greyfoundry.authentik.generated.model.PatchedSAMLPropertyMappingRequest
import dev.greyfoundry.authentik.generated.model.PatchedSAMLSourcePropertyMappingRequest
import dev.greyfoundry.authentik.generated.model.PatchedSCIMMappingRequest
import dev.greyfoundry.authentik.generated.model.PatchedSCIMSourcePropertyMappingRequest
import dev.greyfoundry.authentik.generated.model.PatchedScopeMappingRequest
import dev.greyfoundry.authentik.generated.model.PatchedTelegramSourcePropertyMappingRequest
import dev.greyfoundry.authentik.generated.model.PlexSourcePropertyMapping
import dev.greyfoundry.authentik.generated.model.PlexSourcePropertyMappingRequest
import dev.greyfoundry.authentik.generated.model.PropertyMapping
import dev.greyfoundry.authentik.generated.model.PropertyMappingTestRequest
import dev.greyfoundry.authentik.generated.model.PropertyMappingTestResult
import dev.greyfoundry.authentik.generated.model.RACPropertyMapping
import dev.greyfoundry.authentik.generated.model.RACPropertyMappingRequest
import dev.greyfoundry.authentik.generated.model.RadiusProviderPropertyMapping
import dev.greyfoundry.authentik.generated.model.RadiusProviderPropertyMappingRequest
import dev.greyfoundry.authentik.generated.model.SAMLPropertyMapping
import dev.greyfoundry.authentik.generated.model.SAMLPropertyMappingRequest
import dev.greyfoundry.authentik.generated.model.SAMLSourcePropertyMapping
import dev.greyfoundry.authentik.generated.model.SAMLSourcePropertyMappingRequest
import dev.greyfoundry.authentik.generated.model.SCIMMapping
import dev.greyfoundry.authentik.generated.model.SCIMMappingRequest
import dev.greyfoundry.authentik.generated.model.SCIMSourcePropertyMapping
import dev.greyfoundry.authentik.generated.model.SCIMSourcePropertyMappingRequest
import dev.greyfoundry.authentik.generated.model.ScopeMapping
import dev.greyfoundry.authentik.generated.model.ScopeMappingRequest
import dev.greyfoundry.authentik.generated.model.TelegramSourcePropertyMapping
import dev.greyfoundry.authentik.generated.model.TelegramSourcePropertyMappingRequest
import dev.greyfoundry.authentik.generated.model.TypeCreate
import dev.greyfoundry.authentik.generated.model.UsedBy
import dev.greyfoundry.authentik.generated.model.ValidationError

interface PropertymappingsApi {
    /**
     * DELETE propertymappings/all/{pm_uuid}/
     *
     * PropertyMapping Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Property Mapping.
     * @return [Unit]
     */
    @DELETE("propertymappings/all/{pm_uuid}/")
    suspend fun propertymappingsAllDestroy(@Path("pm_uuid") pmUuid: java.util.UUID): Response<Unit>

    /**
     * GET propertymappings/all/
     *
     * PropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param managed  (optional)
     * @param managedIsnull  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedPropertyMappingList]
     */
    @GET("propertymappings/all/")
    suspend fun propertymappingsAllList(@Query("managed") managed: @JvmSuppressWildcards kotlin.collections.List<kotlin.String>? = null, @Query("managed__isnull") managedIsnull: kotlin.Boolean? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedPropertyMappingList>

    /**
     * GET propertymappings/all/{pm_uuid}/
     *
     * PropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Property Mapping.
     * @return [PropertyMapping]
     */
    @GET("propertymappings/all/{pm_uuid}/")
    suspend fun propertymappingsAllRetrieve(@Path("pm_uuid") pmUuid: java.util.UUID): Response<PropertyMapping>

    /**
     * POST propertymappings/all/{pm_uuid}/test/
     *
     * Test Property Mapping
     * Responses:
     *  - 200:
     *  - 400: Invalid parameters
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Property Mapping.
     * @param formatResult  (optional)
     * @param propertyMappingTestRequest  (optional)
     * @return [PropertyMappingTestResult]
     */
    @POST("propertymappings/all/{pm_uuid}/test/")
    suspend fun propertymappingsAllTestCreate(@Path("pm_uuid") pmUuid: java.util.UUID, @Query("format_result") formatResult: kotlin.Boolean? = null, @Body propertyMappingTestRequest: PropertyMappingTestRequest? = null): Response<PropertyMappingTestResult>

    /**
     * GET propertymappings/all/types/
     *
     * Get all creatable types
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @return [kotlin.collections.List<TypeCreate>]
     */
    @GET("propertymappings/all/types/")
    suspend fun propertymappingsAllTypesList(): Response<kotlin.collections.List<TypeCreate>>

    /**
     * GET propertymappings/all/{pm_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Property Mapping.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("propertymappings/all/{pm_uuid}/used_by/")
    suspend fun propertymappingsAllUsedByList(@Path("pm_uuid") pmUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST propertymappings/notification/
     *
     * NotificationWebhookMapping Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param notificationWebhookMappingRequest
     * @return [NotificationWebhookMapping]
     */
    @POST("propertymappings/notification/")
    suspend fun propertymappingsNotificationCreate(@Body notificationWebhookMappingRequest: NotificationWebhookMappingRequest): Response<NotificationWebhookMapping>

    /**
     * DELETE propertymappings/notification/{pm_uuid}/
     *
     * NotificationWebhookMapping Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Webhook Mapping.
     * @return [Unit]
     */
    @DELETE("propertymappings/notification/{pm_uuid}/")
    suspend fun propertymappingsNotificationDestroy(@Path("pm_uuid") pmUuid: java.util.UUID): Response<Unit>

    /**
     * GET propertymappings/notification/
     *
     * NotificationWebhookMapping Viewset
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
     * @return [PaginatedNotificationWebhookMappingList]
     */
    @GET("propertymappings/notification/")
    suspend fun propertymappingsNotificationList(@Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedNotificationWebhookMappingList>

    /**
     * PATCH propertymappings/notification/{pm_uuid}/
     *
     * NotificationWebhookMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Webhook Mapping.
     * @param patchedNotificationWebhookMappingRequest  (optional)
     * @return [NotificationWebhookMapping]
     */
    @PATCH("propertymappings/notification/{pm_uuid}/")
    suspend fun propertymappingsNotificationPartialUpdate(@Path("pm_uuid") pmUuid: java.util.UUID, @Body patchedNotificationWebhookMappingRequest: PatchedNotificationWebhookMappingRequest? = null): Response<NotificationWebhookMapping>

    /**
     * GET propertymappings/notification/{pm_uuid}/
     *
     * NotificationWebhookMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Webhook Mapping.
     * @return [NotificationWebhookMapping]
     */
    @GET("propertymappings/notification/{pm_uuid}/")
    suspend fun propertymappingsNotificationRetrieve(@Path("pm_uuid") pmUuid: java.util.UUID): Response<NotificationWebhookMapping>

    /**
     * PUT propertymappings/notification/{pm_uuid}/
     *
     * NotificationWebhookMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Webhook Mapping.
     * @param notificationWebhookMappingRequest
     * @return [NotificationWebhookMapping]
     */
    @PUT("propertymappings/notification/{pm_uuid}/")
    suspend fun propertymappingsNotificationUpdate(@Path("pm_uuid") pmUuid: java.util.UUID, @Body notificationWebhookMappingRequest: NotificationWebhookMappingRequest): Response<NotificationWebhookMapping>

    /**
     * GET propertymappings/notification/{pm_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Webhook Mapping.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("propertymappings/notification/{pm_uuid}/used_by/")
    suspend fun propertymappingsNotificationUsedByList(@Path("pm_uuid") pmUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST propertymappings/provider/google_workspace/
     *
     * GoogleWorkspaceProviderMapping Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param googleWorkspaceProviderMappingRequest
     * @return [GoogleWorkspaceProviderMapping]
     */
    @POST("propertymappings/provider/google_workspace/")
    suspend fun propertymappingsProviderGoogleWorkspaceCreate(@Body googleWorkspaceProviderMappingRequest: GoogleWorkspaceProviderMappingRequest): Response<GoogleWorkspaceProviderMapping>

    /**
     * DELETE propertymappings/provider/google_workspace/{pm_uuid}/
     *
     * GoogleWorkspaceProviderMapping Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Google Workspace Provider Mapping.
     * @return [Unit]
     */
    @DELETE("propertymappings/provider/google_workspace/{pm_uuid}/")
    suspend fun propertymappingsProviderGoogleWorkspaceDestroy(@Path("pm_uuid") pmUuid: java.util.UUID): Response<Unit>

    /**
     * GET propertymappings/provider/google_workspace/
     *
     * GoogleWorkspaceProviderMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param expression  (optional)
     * @param managed  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param pmUuid  (optional)
     * @param search A search term. (optional)
     * @return [PaginatedGoogleWorkspaceProviderMappingList]
     */
    @GET("propertymappings/provider/google_workspace/")
    suspend fun propertymappingsProviderGoogleWorkspaceList(@Query("expression") expression: kotlin.String? = null, @Query("managed") managed: @JvmSuppressWildcards kotlin.collections.List<kotlin.String>? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("pm_uuid") pmUuid: java.util.UUID? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedGoogleWorkspaceProviderMappingList>

    /**
     * PATCH propertymappings/provider/google_workspace/{pm_uuid}/
     *
     * GoogleWorkspaceProviderMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Google Workspace Provider Mapping.
     * @param patchedGoogleWorkspaceProviderMappingRequest  (optional)
     * @return [GoogleWorkspaceProviderMapping]
     */
    @PATCH("propertymappings/provider/google_workspace/{pm_uuid}/")
    suspend fun propertymappingsProviderGoogleWorkspacePartialUpdate(@Path("pm_uuid") pmUuid: java.util.UUID, @Body patchedGoogleWorkspaceProviderMappingRequest: PatchedGoogleWorkspaceProviderMappingRequest? = null): Response<GoogleWorkspaceProviderMapping>

    /**
     * GET propertymappings/provider/google_workspace/{pm_uuid}/
     *
     * GoogleWorkspaceProviderMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Google Workspace Provider Mapping.
     * @return [GoogleWorkspaceProviderMapping]
     */
    @GET("propertymappings/provider/google_workspace/{pm_uuid}/")
    suspend fun propertymappingsProviderGoogleWorkspaceRetrieve(@Path("pm_uuid") pmUuid: java.util.UUID): Response<GoogleWorkspaceProviderMapping>

    /**
     * PUT propertymappings/provider/google_workspace/{pm_uuid}/
     *
     * GoogleWorkspaceProviderMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Google Workspace Provider Mapping.
     * @param googleWorkspaceProviderMappingRequest
     * @return [GoogleWorkspaceProviderMapping]
     */
    @PUT("propertymappings/provider/google_workspace/{pm_uuid}/")
    suspend fun propertymappingsProviderGoogleWorkspaceUpdate(@Path("pm_uuid") pmUuid: java.util.UUID, @Body googleWorkspaceProviderMappingRequest: GoogleWorkspaceProviderMappingRequest): Response<GoogleWorkspaceProviderMapping>

    /**
     * GET propertymappings/provider/google_workspace/{pm_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Google Workspace Provider Mapping.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("propertymappings/provider/google_workspace/{pm_uuid}/used_by/")
    suspend fun propertymappingsProviderGoogleWorkspaceUsedByList(@Path("pm_uuid") pmUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST propertymappings/provider/microsoft_entra/
     *
     * MicrosoftEntraProviderMapping Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param microsoftEntraProviderMappingRequest
     * @return [MicrosoftEntraProviderMapping]
     */
    @POST("propertymappings/provider/microsoft_entra/")
    suspend fun propertymappingsProviderMicrosoftEntraCreate(@Body microsoftEntraProviderMappingRequest: MicrosoftEntraProviderMappingRequest): Response<MicrosoftEntraProviderMapping>

    /**
     * DELETE propertymappings/provider/microsoft_entra/{pm_uuid}/
     *
     * MicrosoftEntraProviderMapping Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Microsoft Entra Provider Mapping.
     * @return [Unit]
     */
    @DELETE("propertymappings/provider/microsoft_entra/{pm_uuid}/")
    suspend fun propertymappingsProviderMicrosoftEntraDestroy(@Path("pm_uuid") pmUuid: java.util.UUID): Response<Unit>

    /**
     * GET propertymappings/provider/microsoft_entra/
     *
     * MicrosoftEntraProviderMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param expression  (optional)
     * @param managed  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param pmUuid  (optional)
     * @param search A search term. (optional)
     * @return [PaginatedMicrosoftEntraProviderMappingList]
     */
    @GET("propertymappings/provider/microsoft_entra/")
    suspend fun propertymappingsProviderMicrosoftEntraList(@Query("expression") expression: kotlin.String? = null, @Query("managed") managed: @JvmSuppressWildcards kotlin.collections.List<kotlin.String>? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("pm_uuid") pmUuid: java.util.UUID? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedMicrosoftEntraProviderMappingList>

    /**
     * PATCH propertymappings/provider/microsoft_entra/{pm_uuid}/
     *
     * MicrosoftEntraProviderMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Microsoft Entra Provider Mapping.
     * @param patchedMicrosoftEntraProviderMappingRequest  (optional)
     * @return [MicrosoftEntraProviderMapping]
     */
    @PATCH("propertymappings/provider/microsoft_entra/{pm_uuid}/")
    suspend fun propertymappingsProviderMicrosoftEntraPartialUpdate(@Path("pm_uuid") pmUuid: java.util.UUID, @Body patchedMicrosoftEntraProviderMappingRequest: PatchedMicrosoftEntraProviderMappingRequest? = null): Response<MicrosoftEntraProviderMapping>

    /**
     * GET propertymappings/provider/microsoft_entra/{pm_uuid}/
     *
     * MicrosoftEntraProviderMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Microsoft Entra Provider Mapping.
     * @return [MicrosoftEntraProviderMapping]
     */
    @GET("propertymappings/provider/microsoft_entra/{pm_uuid}/")
    suspend fun propertymappingsProviderMicrosoftEntraRetrieve(@Path("pm_uuid") pmUuid: java.util.UUID): Response<MicrosoftEntraProviderMapping>

    /**
     * PUT propertymappings/provider/microsoft_entra/{pm_uuid}/
     *
     * MicrosoftEntraProviderMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Microsoft Entra Provider Mapping.
     * @param microsoftEntraProviderMappingRequest
     * @return [MicrosoftEntraProviderMapping]
     */
    @PUT("propertymappings/provider/microsoft_entra/{pm_uuid}/")
    suspend fun propertymappingsProviderMicrosoftEntraUpdate(@Path("pm_uuid") pmUuid: java.util.UUID, @Body microsoftEntraProviderMappingRequest: MicrosoftEntraProviderMappingRequest): Response<MicrosoftEntraProviderMapping>

    /**
     * GET propertymappings/provider/microsoft_entra/{pm_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Microsoft Entra Provider Mapping.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("propertymappings/provider/microsoft_entra/{pm_uuid}/used_by/")
    suspend fun propertymappingsProviderMicrosoftEntraUsedByList(@Path("pm_uuid") pmUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST propertymappings/provider/rac/
     *
     * RACPropertyMapping Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param raCPropertyMappingRequest
     * @return [RACPropertyMapping]
     */
    @POST("propertymappings/provider/rac/")
    suspend fun propertymappingsProviderRacCreate(@Body raCPropertyMappingRequest: RACPropertyMappingRequest): Response<RACPropertyMapping>

    /**
     * DELETE propertymappings/provider/rac/{pm_uuid}/
     *
     * RACPropertyMapping Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this RAC Provider Property Mapping.
     * @return [Unit]
     */
    @DELETE("propertymappings/provider/rac/{pm_uuid}/")
    suspend fun propertymappingsProviderRacDestroy(@Path("pm_uuid") pmUuid: java.util.UUID): Response<Unit>

    /**
     * GET propertymappings/provider/rac/
     *
     * RACPropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param managed  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedRACPropertyMappingList]
     */
    @GET("propertymappings/provider/rac/")
    suspend fun propertymappingsProviderRacList(@Query("managed") managed: @JvmSuppressWildcards kotlin.collections.List<kotlin.String>? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedRACPropertyMappingList>

    /**
     * PATCH propertymappings/provider/rac/{pm_uuid}/
     *
     * RACPropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this RAC Provider Property Mapping.
     * @param patchedRACPropertyMappingRequest  (optional)
     * @return [RACPropertyMapping]
     */
    @PATCH("propertymappings/provider/rac/{pm_uuid}/")
    suspend fun propertymappingsProviderRacPartialUpdate(@Path("pm_uuid") pmUuid: java.util.UUID, @Body patchedRACPropertyMappingRequest: PatchedRACPropertyMappingRequest? = null): Response<RACPropertyMapping>

    /**
     * GET propertymappings/provider/rac/{pm_uuid}/
     *
     * RACPropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this RAC Provider Property Mapping.
     * @return [RACPropertyMapping]
     */
    @GET("propertymappings/provider/rac/{pm_uuid}/")
    suspend fun propertymappingsProviderRacRetrieve(@Path("pm_uuid") pmUuid: java.util.UUID): Response<RACPropertyMapping>

    /**
     * PUT propertymappings/provider/rac/{pm_uuid}/
     *
     * RACPropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this RAC Provider Property Mapping.
     * @param raCPropertyMappingRequest
     * @return [RACPropertyMapping]
     */
    @PUT("propertymappings/provider/rac/{pm_uuid}/")
    suspend fun propertymappingsProviderRacUpdate(@Path("pm_uuid") pmUuid: java.util.UUID, @Body raCPropertyMappingRequest: RACPropertyMappingRequest): Response<RACPropertyMapping>

    /**
     * GET propertymappings/provider/rac/{pm_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this RAC Provider Property Mapping.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("propertymappings/provider/rac/{pm_uuid}/used_by/")
    suspend fun propertymappingsProviderRacUsedByList(@Path("pm_uuid") pmUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST propertymappings/provider/radius/
     *
     * RadiusProviderPropertyMapping Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param radiusProviderPropertyMappingRequest
     * @return [RadiusProviderPropertyMapping]
     */
    @POST("propertymappings/provider/radius/")
    suspend fun propertymappingsProviderRadiusCreate(@Body radiusProviderPropertyMappingRequest: RadiusProviderPropertyMappingRequest): Response<RadiusProviderPropertyMapping>

    /**
     * DELETE propertymappings/provider/radius/{pm_uuid}/
     *
     * RadiusProviderPropertyMapping Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Radius Provider Property Mapping.
     * @return [Unit]
     */
    @DELETE("propertymappings/provider/radius/{pm_uuid}/")
    suspend fun propertymappingsProviderRadiusDestroy(@Path("pm_uuid") pmUuid: java.util.UUID): Response<Unit>

    /**
     * GET propertymappings/provider/radius/
     *
     * RadiusProviderPropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param managed  (optional)
     * @param managedIsnull  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedRadiusProviderPropertyMappingList]
     */
    @GET("propertymappings/provider/radius/")
    suspend fun propertymappingsProviderRadiusList(@Query("managed") managed: @JvmSuppressWildcards kotlin.collections.List<kotlin.String>? = null, @Query("managed__isnull") managedIsnull: kotlin.Boolean? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedRadiusProviderPropertyMappingList>

    /**
     * PATCH propertymappings/provider/radius/{pm_uuid}/
     *
     * RadiusProviderPropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Radius Provider Property Mapping.
     * @param patchedRadiusProviderPropertyMappingRequest  (optional)
     * @return [RadiusProviderPropertyMapping]
     */
    @PATCH("propertymappings/provider/radius/{pm_uuid}/")
    suspend fun propertymappingsProviderRadiusPartialUpdate(@Path("pm_uuid") pmUuid: java.util.UUID, @Body patchedRadiusProviderPropertyMappingRequest: PatchedRadiusProviderPropertyMappingRequest? = null): Response<RadiusProviderPropertyMapping>

    /**
     * GET propertymappings/provider/radius/{pm_uuid}/
     *
     * RadiusProviderPropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Radius Provider Property Mapping.
     * @return [RadiusProviderPropertyMapping]
     */
    @GET("propertymappings/provider/radius/{pm_uuid}/")
    suspend fun propertymappingsProviderRadiusRetrieve(@Path("pm_uuid") pmUuid: java.util.UUID): Response<RadiusProviderPropertyMapping>

    /**
     * PUT propertymappings/provider/radius/{pm_uuid}/
     *
     * RadiusProviderPropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Radius Provider Property Mapping.
     * @param radiusProviderPropertyMappingRequest
     * @return [RadiusProviderPropertyMapping]
     */
    @PUT("propertymappings/provider/radius/{pm_uuid}/")
    suspend fun propertymappingsProviderRadiusUpdate(@Path("pm_uuid") pmUuid: java.util.UUID, @Body radiusProviderPropertyMappingRequest: RadiusProviderPropertyMappingRequest): Response<RadiusProviderPropertyMapping>

    /**
     * GET propertymappings/provider/radius/{pm_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Radius Provider Property Mapping.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("propertymappings/provider/radius/{pm_uuid}/used_by/")
    suspend fun propertymappingsProviderRadiusUsedByList(@Path("pm_uuid") pmUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST propertymappings/provider/saml/
     *
     * SAMLPropertyMapping Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param saMLPropertyMappingRequest
     * @return [SAMLPropertyMapping]
     */
    @POST("propertymappings/provider/saml/")
    suspend fun propertymappingsProviderSamlCreate(@Body saMLPropertyMappingRequest: SAMLPropertyMappingRequest): Response<SAMLPropertyMapping>

    /**
     * DELETE propertymappings/provider/saml/{pm_uuid}/
     *
     * SAMLPropertyMapping Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this SAML Provider Property Mapping.
     * @return [Unit]
     */
    @DELETE("propertymappings/provider/saml/{pm_uuid}/")
    suspend fun propertymappingsProviderSamlDestroy(@Path("pm_uuid") pmUuid: java.util.UUID): Response<Unit>

    /**
     * GET propertymappings/provider/saml/
     *
     * SAMLPropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param friendlyName  (optional)
     * @param managed  (optional)
     * @param managedIsnull  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param samlName  (optional)
     * @param search A search term. (optional)
     * @return [PaginatedSAMLPropertyMappingList]
     */
    @GET("propertymappings/provider/saml/")
    suspend fun propertymappingsProviderSamlList(@Query("friendly_name") friendlyName: kotlin.String? = null, @Query("managed") managed: @JvmSuppressWildcards kotlin.collections.List<kotlin.String>? = null, @Query("managed__isnull") managedIsnull: kotlin.Boolean? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("saml_name") samlName: kotlin.String? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedSAMLPropertyMappingList>

    /**
     * PATCH propertymappings/provider/saml/{pm_uuid}/
     *
     * SAMLPropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this SAML Provider Property Mapping.
     * @param patchedSAMLPropertyMappingRequest  (optional)
     * @return [SAMLPropertyMapping]
     */
    @PATCH("propertymappings/provider/saml/{pm_uuid}/")
    suspend fun propertymappingsProviderSamlPartialUpdate(@Path("pm_uuid") pmUuid: java.util.UUID, @Body patchedSAMLPropertyMappingRequest: PatchedSAMLPropertyMappingRequest? = null): Response<SAMLPropertyMapping>

    /**
     * GET propertymappings/provider/saml/{pm_uuid}/
     *
     * SAMLPropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this SAML Provider Property Mapping.
     * @return [SAMLPropertyMapping]
     */
    @GET("propertymappings/provider/saml/{pm_uuid}/")
    suspend fun propertymappingsProviderSamlRetrieve(@Path("pm_uuid") pmUuid: java.util.UUID): Response<SAMLPropertyMapping>

    /**
     * PUT propertymappings/provider/saml/{pm_uuid}/
     *
     * SAMLPropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this SAML Provider Property Mapping.
     * @param saMLPropertyMappingRequest
     * @return [SAMLPropertyMapping]
     */
    @PUT("propertymappings/provider/saml/{pm_uuid}/")
    suspend fun propertymappingsProviderSamlUpdate(@Path("pm_uuid") pmUuid: java.util.UUID, @Body saMLPropertyMappingRequest: SAMLPropertyMappingRequest): Response<SAMLPropertyMapping>

    /**
     * GET propertymappings/provider/saml/{pm_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this SAML Provider Property Mapping.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("propertymappings/provider/saml/{pm_uuid}/used_by/")
    suspend fun propertymappingsProviderSamlUsedByList(@Path("pm_uuid") pmUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST propertymappings/provider/scim/
     *
     * SCIMMapping Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param scIMMappingRequest
     * @return [SCIMMapping]
     */
    @POST("propertymappings/provider/scim/")
    suspend fun propertymappingsProviderScimCreate(@Body scIMMappingRequest: SCIMMappingRequest): Response<SCIMMapping>

    /**
     * DELETE propertymappings/provider/scim/{pm_uuid}/
     *
     * SCIMMapping Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this SCIM Provider Mapping.
     * @return [Unit]
     */
    @DELETE("propertymappings/provider/scim/{pm_uuid}/")
    suspend fun propertymappingsProviderScimDestroy(@Path("pm_uuid") pmUuid: java.util.UUID): Response<Unit>

    /**
     * GET propertymappings/provider/scim/
     *
     * SCIMMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param managed  (optional)
     * @param managedIsnull  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedSCIMMappingList]
     */
    @GET("propertymappings/provider/scim/")
    suspend fun propertymappingsProviderScimList(@Query("managed") managed: @JvmSuppressWildcards kotlin.collections.List<kotlin.String>? = null, @Query("managed__isnull") managedIsnull: kotlin.Boolean? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedSCIMMappingList>

    /**
     * PATCH propertymappings/provider/scim/{pm_uuid}/
     *
     * SCIMMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this SCIM Provider Mapping.
     * @param patchedSCIMMappingRequest  (optional)
     * @return [SCIMMapping]
     */
    @PATCH("propertymappings/provider/scim/{pm_uuid}/")
    suspend fun propertymappingsProviderScimPartialUpdate(@Path("pm_uuid") pmUuid: java.util.UUID, @Body patchedSCIMMappingRequest: PatchedSCIMMappingRequest? = null): Response<SCIMMapping>

    /**
     * GET propertymappings/provider/scim/{pm_uuid}/
     *
     * SCIMMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this SCIM Provider Mapping.
     * @return [SCIMMapping]
     */
    @GET("propertymappings/provider/scim/{pm_uuid}/")
    suspend fun propertymappingsProviderScimRetrieve(@Path("pm_uuid") pmUuid: java.util.UUID): Response<SCIMMapping>

    /**
     * PUT propertymappings/provider/scim/{pm_uuid}/
     *
     * SCIMMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this SCIM Provider Mapping.
     * @param scIMMappingRequest
     * @return [SCIMMapping]
     */
    @PUT("propertymappings/provider/scim/{pm_uuid}/")
    suspend fun propertymappingsProviderScimUpdate(@Path("pm_uuid") pmUuid: java.util.UUID, @Body scIMMappingRequest: SCIMMappingRequest): Response<SCIMMapping>

    /**
     * GET propertymappings/provider/scim/{pm_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this SCIM Provider Mapping.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("propertymappings/provider/scim/{pm_uuid}/used_by/")
    suspend fun propertymappingsProviderScimUsedByList(@Path("pm_uuid") pmUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST propertymappings/provider/scope/
     *
     * ScopeMapping Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param scopeMappingRequest
     * @return [ScopeMapping]
     */
    @POST("propertymappings/provider/scope/")
    suspend fun propertymappingsProviderScopeCreate(@Body scopeMappingRequest: ScopeMappingRequest): Response<ScopeMapping>

    /**
     * DELETE propertymappings/provider/scope/{pm_uuid}/
     *
     * ScopeMapping Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Scope Mapping.
     * @return [Unit]
     */
    @DELETE("propertymappings/provider/scope/{pm_uuid}/")
    suspend fun propertymappingsProviderScopeDestroy(@Path("pm_uuid") pmUuid: java.util.UUID): Response<Unit>

    /**
     * GET propertymappings/provider/scope/
     *
     * ScopeMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param managed  (optional)
     * @param managedIsnull  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param scopeName  (optional)
     * @param search A search term. (optional)
     * @return [PaginatedScopeMappingList]
     */
    @GET("propertymappings/provider/scope/")
    suspend fun propertymappingsProviderScopeList(@Query("managed") managed: @JvmSuppressWildcards kotlin.collections.List<kotlin.String>? = null, @Query("managed__isnull") managedIsnull: kotlin.Boolean? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("scope_name") scopeName: kotlin.String? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedScopeMappingList>

    /**
     * PATCH propertymappings/provider/scope/{pm_uuid}/
     *
     * ScopeMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Scope Mapping.
     * @param patchedScopeMappingRequest  (optional)
     * @return [ScopeMapping]
     */
    @PATCH("propertymappings/provider/scope/{pm_uuid}/")
    suspend fun propertymappingsProviderScopePartialUpdate(@Path("pm_uuid") pmUuid: java.util.UUID, @Body patchedScopeMappingRequest: PatchedScopeMappingRequest? = null): Response<ScopeMapping>

    /**
     * GET propertymappings/provider/scope/{pm_uuid}/
     *
     * ScopeMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Scope Mapping.
     * @return [ScopeMapping]
     */
    @GET("propertymappings/provider/scope/{pm_uuid}/")
    suspend fun propertymappingsProviderScopeRetrieve(@Path("pm_uuid") pmUuid: java.util.UUID): Response<ScopeMapping>

    /**
     * PUT propertymappings/provider/scope/{pm_uuid}/
     *
     * ScopeMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Scope Mapping.
     * @param scopeMappingRequest
     * @return [ScopeMapping]
     */
    @PUT("propertymappings/provider/scope/{pm_uuid}/")
    suspend fun propertymappingsProviderScopeUpdate(@Path("pm_uuid") pmUuid: java.util.UUID, @Body scopeMappingRequest: ScopeMappingRequest): Response<ScopeMapping>

    /**
     * GET propertymappings/provider/scope/{pm_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Scope Mapping.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("propertymappings/provider/scope/{pm_uuid}/used_by/")
    suspend fun propertymappingsProviderScopeUsedByList(@Path("pm_uuid") pmUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST propertymappings/source/kerberos/
     *
     * KerberosSource PropertyMapping Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param kerberosSourcePropertyMappingRequest
     * @return [KerberosSourcePropertyMapping]
     */
    @POST("propertymappings/source/kerberos/")
    suspend fun propertymappingsSourceKerberosCreate(@Body kerberosSourcePropertyMappingRequest: KerberosSourcePropertyMappingRequest): Response<KerberosSourcePropertyMapping>

    /**
     * DELETE propertymappings/source/kerberos/{pm_uuid}/
     *
     * KerberosSource PropertyMapping Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Kerberos Source Property Mapping.
     * @return [Unit]
     */
    @DELETE("propertymappings/source/kerberos/{pm_uuid}/")
    suspend fun propertymappingsSourceKerberosDestroy(@Path("pm_uuid") pmUuid: java.util.UUID): Response<Unit>

    /**
     * GET propertymappings/source/kerberos/
     *
     * KerberosSource PropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param managed  (optional)
     * @param managedIsnull  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedKerberosSourcePropertyMappingList]
     */
    @GET("propertymappings/source/kerberos/")
    suspend fun propertymappingsSourceKerberosList(@Query("managed") managed: @JvmSuppressWildcards kotlin.collections.List<kotlin.String>? = null, @Query("managed__isnull") managedIsnull: kotlin.Boolean? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedKerberosSourcePropertyMappingList>

    /**
     * PATCH propertymappings/source/kerberos/{pm_uuid}/
     *
     * KerberosSource PropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Kerberos Source Property Mapping.
     * @param patchedKerberosSourcePropertyMappingRequest  (optional)
     * @return [KerberosSourcePropertyMapping]
     */
    @PATCH("propertymappings/source/kerberos/{pm_uuid}/")
    suspend fun propertymappingsSourceKerberosPartialUpdate(@Path("pm_uuid") pmUuid: java.util.UUID, @Body patchedKerberosSourcePropertyMappingRequest: PatchedKerberosSourcePropertyMappingRequest? = null): Response<KerberosSourcePropertyMapping>

    /**
     * GET propertymappings/source/kerberos/{pm_uuid}/
     *
     * KerberosSource PropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Kerberos Source Property Mapping.
     * @return [KerberosSourcePropertyMapping]
     */
    @GET("propertymappings/source/kerberos/{pm_uuid}/")
    suspend fun propertymappingsSourceKerberosRetrieve(@Path("pm_uuid") pmUuid: java.util.UUID): Response<KerberosSourcePropertyMapping>

    /**
     * PUT propertymappings/source/kerberos/{pm_uuid}/
     *
     * KerberosSource PropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Kerberos Source Property Mapping.
     * @param kerberosSourcePropertyMappingRequest
     * @return [KerberosSourcePropertyMapping]
     */
    @PUT("propertymappings/source/kerberos/{pm_uuid}/")
    suspend fun propertymappingsSourceKerberosUpdate(@Path("pm_uuid") pmUuid: java.util.UUID, @Body kerberosSourcePropertyMappingRequest: KerberosSourcePropertyMappingRequest): Response<KerberosSourcePropertyMapping>

    /**
     * GET propertymappings/source/kerberos/{pm_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Kerberos Source Property Mapping.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("propertymappings/source/kerberos/{pm_uuid}/used_by/")
    suspend fun propertymappingsSourceKerberosUsedByList(@Path("pm_uuid") pmUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST propertymappings/source/ldap/
     *
     * LDAP PropertyMapping Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param ldAPSourcePropertyMappingRequest
     * @return [LDAPSourcePropertyMapping]
     */
    @POST("propertymappings/source/ldap/")
    suspend fun propertymappingsSourceLdapCreate(@Body ldAPSourcePropertyMappingRequest: LDAPSourcePropertyMappingRequest): Response<LDAPSourcePropertyMapping>

    /**
     * DELETE propertymappings/source/ldap/{pm_uuid}/
     *
     * LDAP PropertyMapping Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this LDAP Source Property Mapping.
     * @return [Unit]
     */
    @DELETE("propertymappings/source/ldap/{pm_uuid}/")
    suspend fun propertymappingsSourceLdapDestroy(@Path("pm_uuid") pmUuid: java.util.UUID): Response<Unit>

    /**
     * GET propertymappings/source/ldap/
     *
     * LDAP PropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param managed  (optional)
     * @param managedIsnull  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedLDAPSourcePropertyMappingList]
     */
    @GET("propertymappings/source/ldap/")
    suspend fun propertymappingsSourceLdapList(@Query("managed") managed: @JvmSuppressWildcards kotlin.collections.List<kotlin.String>? = null, @Query("managed__isnull") managedIsnull: kotlin.Boolean? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedLDAPSourcePropertyMappingList>

    /**
     * PATCH propertymappings/source/ldap/{pm_uuid}/
     *
     * LDAP PropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this LDAP Source Property Mapping.
     * @param patchedLDAPSourcePropertyMappingRequest  (optional)
     * @return [LDAPSourcePropertyMapping]
     */
    @PATCH("propertymappings/source/ldap/{pm_uuid}/")
    suspend fun propertymappingsSourceLdapPartialUpdate(@Path("pm_uuid") pmUuid: java.util.UUID, @Body patchedLDAPSourcePropertyMappingRequest: PatchedLDAPSourcePropertyMappingRequest? = null): Response<LDAPSourcePropertyMapping>

    /**
     * GET propertymappings/source/ldap/{pm_uuid}/
     *
     * LDAP PropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this LDAP Source Property Mapping.
     * @return [LDAPSourcePropertyMapping]
     */
    @GET("propertymappings/source/ldap/{pm_uuid}/")
    suspend fun propertymappingsSourceLdapRetrieve(@Path("pm_uuid") pmUuid: java.util.UUID): Response<LDAPSourcePropertyMapping>

    /**
     * PUT propertymappings/source/ldap/{pm_uuid}/
     *
     * LDAP PropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this LDAP Source Property Mapping.
     * @param ldAPSourcePropertyMappingRequest
     * @return [LDAPSourcePropertyMapping]
     */
    @PUT("propertymappings/source/ldap/{pm_uuid}/")
    suspend fun propertymappingsSourceLdapUpdate(@Path("pm_uuid") pmUuid: java.util.UUID, @Body ldAPSourcePropertyMappingRequest: LDAPSourcePropertyMappingRequest): Response<LDAPSourcePropertyMapping>

    /**
     * GET propertymappings/source/ldap/{pm_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this LDAP Source Property Mapping.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("propertymappings/source/ldap/{pm_uuid}/used_by/")
    suspend fun propertymappingsSourceLdapUsedByList(@Path("pm_uuid") pmUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST propertymappings/source/oauth/
     *
     * OAuthSourcePropertyMapping Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param oauthSourcePropertyMappingRequest
     * @return [OAuthSourcePropertyMapping]
     */
    @POST("propertymappings/source/oauth/")
    suspend fun propertymappingsSourceOauthCreate(@Body oauthSourcePropertyMappingRequest: OAuthSourcePropertyMappingRequest): Response<OAuthSourcePropertyMapping>

    /**
     * DELETE propertymappings/source/oauth/{pm_uuid}/
     *
     * OAuthSourcePropertyMapping Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this OAuth Source Property Mapping.
     * @return [Unit]
     */
    @DELETE("propertymappings/source/oauth/{pm_uuid}/")
    suspend fun propertymappingsSourceOauthDestroy(@Path("pm_uuid") pmUuid: java.util.UUID): Response<Unit>

    /**
     * GET propertymappings/source/oauth/
     *
     * OAuthSourcePropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param managed  (optional)
     * @param managedIsnull  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedOAuthSourcePropertyMappingList]
     */
    @GET("propertymappings/source/oauth/")
    suspend fun propertymappingsSourceOauthList(@Query("managed") managed: @JvmSuppressWildcards kotlin.collections.List<kotlin.String>? = null, @Query("managed__isnull") managedIsnull: kotlin.Boolean? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedOAuthSourcePropertyMappingList>

    /**
     * PATCH propertymappings/source/oauth/{pm_uuid}/
     *
     * OAuthSourcePropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this OAuth Source Property Mapping.
     * @param patchedOAuthSourcePropertyMappingRequest  (optional)
     * @return [OAuthSourcePropertyMapping]
     */
    @PATCH("propertymappings/source/oauth/{pm_uuid}/")
    suspend fun propertymappingsSourceOauthPartialUpdate(@Path("pm_uuid") pmUuid: java.util.UUID, @Body patchedOAuthSourcePropertyMappingRequest: PatchedOAuthSourcePropertyMappingRequest? = null): Response<OAuthSourcePropertyMapping>

    /**
     * GET propertymappings/source/oauth/{pm_uuid}/
     *
     * OAuthSourcePropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this OAuth Source Property Mapping.
     * @return [OAuthSourcePropertyMapping]
     */
    @GET("propertymappings/source/oauth/{pm_uuid}/")
    suspend fun propertymappingsSourceOauthRetrieve(@Path("pm_uuid") pmUuid: java.util.UUID): Response<OAuthSourcePropertyMapping>

    /**
     * PUT propertymappings/source/oauth/{pm_uuid}/
     *
     * OAuthSourcePropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this OAuth Source Property Mapping.
     * @param oauthSourcePropertyMappingRequest
     * @return [OAuthSourcePropertyMapping]
     */
    @PUT("propertymappings/source/oauth/{pm_uuid}/")
    suspend fun propertymappingsSourceOauthUpdate(@Path("pm_uuid") pmUuid: java.util.UUID, @Body oauthSourcePropertyMappingRequest: OAuthSourcePropertyMappingRequest): Response<OAuthSourcePropertyMapping>

    /**
     * GET propertymappings/source/oauth/{pm_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this OAuth Source Property Mapping.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("propertymappings/source/oauth/{pm_uuid}/used_by/")
    suspend fun propertymappingsSourceOauthUsedByList(@Path("pm_uuid") pmUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST propertymappings/source/plex/
     *
     * PlexSourcePropertyMapping Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param plexSourcePropertyMappingRequest
     * @return [PlexSourcePropertyMapping]
     */
    @POST("propertymappings/source/plex/")
    suspend fun propertymappingsSourcePlexCreate(@Body plexSourcePropertyMappingRequest: PlexSourcePropertyMappingRequest): Response<PlexSourcePropertyMapping>

    /**
     * DELETE propertymappings/source/plex/{pm_uuid}/
     *
     * PlexSourcePropertyMapping Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Plex Source Property Mapping.
     * @return [Unit]
     */
    @DELETE("propertymappings/source/plex/{pm_uuid}/")
    suspend fun propertymappingsSourcePlexDestroy(@Path("pm_uuid") pmUuid: java.util.UUID): Response<Unit>

    /**
     * GET propertymappings/source/plex/
     *
     * PlexSourcePropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param managed  (optional)
     * @param managedIsnull  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedPlexSourcePropertyMappingList]
     */
    @GET("propertymappings/source/plex/")
    suspend fun propertymappingsSourcePlexList(@Query("managed") managed: @JvmSuppressWildcards kotlin.collections.List<kotlin.String>? = null, @Query("managed__isnull") managedIsnull: kotlin.Boolean? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedPlexSourcePropertyMappingList>

    /**
     * PATCH propertymappings/source/plex/{pm_uuid}/
     *
     * PlexSourcePropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Plex Source Property Mapping.
     * @param patchedPlexSourcePropertyMappingRequest  (optional)
     * @return [PlexSourcePropertyMapping]
     */
    @PATCH("propertymappings/source/plex/{pm_uuid}/")
    suspend fun propertymappingsSourcePlexPartialUpdate(@Path("pm_uuid") pmUuid: java.util.UUID, @Body patchedPlexSourcePropertyMappingRequest: PatchedPlexSourcePropertyMappingRequest? = null): Response<PlexSourcePropertyMapping>

    /**
     * GET propertymappings/source/plex/{pm_uuid}/
     *
     * PlexSourcePropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Plex Source Property Mapping.
     * @return [PlexSourcePropertyMapping]
     */
    @GET("propertymappings/source/plex/{pm_uuid}/")
    suspend fun propertymappingsSourcePlexRetrieve(@Path("pm_uuid") pmUuid: java.util.UUID): Response<PlexSourcePropertyMapping>

    /**
     * PUT propertymappings/source/plex/{pm_uuid}/
     *
     * PlexSourcePropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Plex Source Property Mapping.
     * @param plexSourcePropertyMappingRequest
     * @return [PlexSourcePropertyMapping]
     */
    @PUT("propertymappings/source/plex/{pm_uuid}/")
    suspend fun propertymappingsSourcePlexUpdate(@Path("pm_uuid") pmUuid: java.util.UUID, @Body plexSourcePropertyMappingRequest: PlexSourcePropertyMappingRequest): Response<PlexSourcePropertyMapping>

    /**
     * GET propertymappings/source/plex/{pm_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Plex Source Property Mapping.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("propertymappings/source/plex/{pm_uuid}/used_by/")
    suspend fun propertymappingsSourcePlexUsedByList(@Path("pm_uuid") pmUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST propertymappings/source/saml/
     *
     * SAMLSourcePropertyMapping Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param saMLSourcePropertyMappingRequest
     * @return [SAMLSourcePropertyMapping]
     */
    @POST("propertymappings/source/saml/")
    suspend fun propertymappingsSourceSamlCreate(@Body saMLSourcePropertyMappingRequest: SAMLSourcePropertyMappingRequest): Response<SAMLSourcePropertyMapping>

    /**
     * DELETE propertymappings/source/saml/{pm_uuid}/
     *
     * SAMLSourcePropertyMapping Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this SAML Source Property Mapping.
     * @return [Unit]
     */
    @DELETE("propertymappings/source/saml/{pm_uuid}/")
    suspend fun propertymappingsSourceSamlDestroy(@Path("pm_uuid") pmUuid: java.util.UUID): Response<Unit>

    /**
     * GET propertymappings/source/saml/
     *
     * SAMLSourcePropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param managed  (optional)
     * @param managedIsnull  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedSAMLSourcePropertyMappingList]
     */
    @GET("propertymappings/source/saml/")
    suspend fun propertymappingsSourceSamlList(@Query("managed") managed: @JvmSuppressWildcards kotlin.collections.List<kotlin.String>? = null, @Query("managed__isnull") managedIsnull: kotlin.Boolean? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedSAMLSourcePropertyMappingList>

    /**
     * PATCH propertymappings/source/saml/{pm_uuid}/
     *
     * SAMLSourcePropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this SAML Source Property Mapping.
     * @param patchedSAMLSourcePropertyMappingRequest  (optional)
     * @return [SAMLSourcePropertyMapping]
     */
    @PATCH("propertymappings/source/saml/{pm_uuid}/")
    suspend fun propertymappingsSourceSamlPartialUpdate(@Path("pm_uuid") pmUuid: java.util.UUID, @Body patchedSAMLSourcePropertyMappingRequest: PatchedSAMLSourcePropertyMappingRequest? = null): Response<SAMLSourcePropertyMapping>

    /**
     * GET propertymappings/source/saml/{pm_uuid}/
     *
     * SAMLSourcePropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this SAML Source Property Mapping.
     * @return [SAMLSourcePropertyMapping]
     */
    @GET("propertymappings/source/saml/{pm_uuid}/")
    suspend fun propertymappingsSourceSamlRetrieve(@Path("pm_uuid") pmUuid: java.util.UUID): Response<SAMLSourcePropertyMapping>

    /**
     * PUT propertymappings/source/saml/{pm_uuid}/
     *
     * SAMLSourcePropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this SAML Source Property Mapping.
     * @param saMLSourcePropertyMappingRequest
     * @return [SAMLSourcePropertyMapping]
     */
    @PUT("propertymappings/source/saml/{pm_uuid}/")
    suspend fun propertymappingsSourceSamlUpdate(@Path("pm_uuid") pmUuid: java.util.UUID, @Body saMLSourcePropertyMappingRequest: SAMLSourcePropertyMappingRequest): Response<SAMLSourcePropertyMapping>

    /**
     * GET propertymappings/source/saml/{pm_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this SAML Source Property Mapping.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("propertymappings/source/saml/{pm_uuid}/used_by/")
    suspend fun propertymappingsSourceSamlUsedByList(@Path("pm_uuid") pmUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST propertymappings/source/scim/
     *
     * SCIMSourcePropertyMapping Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param scIMSourcePropertyMappingRequest
     * @return [SCIMSourcePropertyMapping]
     */
    @POST("propertymappings/source/scim/")
    suspend fun propertymappingsSourceScimCreate(@Body scIMSourcePropertyMappingRequest: SCIMSourcePropertyMappingRequest): Response<SCIMSourcePropertyMapping>

    /**
     * DELETE propertymappings/source/scim/{pm_uuid}/
     *
     * SCIMSourcePropertyMapping Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this SCIM Source Property Mapping.
     * @return [Unit]
     */
    @DELETE("propertymappings/source/scim/{pm_uuid}/")
    suspend fun propertymappingsSourceScimDestroy(@Path("pm_uuid") pmUuid: java.util.UUID): Response<Unit>

    /**
     * GET propertymappings/source/scim/
     *
     * SCIMSourcePropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param managed  (optional)
     * @param managedIsnull  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedSCIMSourcePropertyMappingList]
     */
    @GET("propertymappings/source/scim/")
    suspend fun propertymappingsSourceScimList(@Query("managed") managed: @JvmSuppressWildcards kotlin.collections.List<kotlin.String>? = null, @Query("managed__isnull") managedIsnull: kotlin.Boolean? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedSCIMSourcePropertyMappingList>

    /**
     * PATCH propertymappings/source/scim/{pm_uuid}/
     *
     * SCIMSourcePropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this SCIM Source Property Mapping.
     * @param patchedSCIMSourcePropertyMappingRequest  (optional)
     * @return [SCIMSourcePropertyMapping]
     */
    @PATCH("propertymappings/source/scim/{pm_uuid}/")
    suspend fun propertymappingsSourceScimPartialUpdate(@Path("pm_uuid") pmUuid: java.util.UUID, @Body patchedSCIMSourcePropertyMappingRequest: PatchedSCIMSourcePropertyMappingRequest? = null): Response<SCIMSourcePropertyMapping>

    /**
     * GET propertymappings/source/scim/{pm_uuid}/
     *
     * SCIMSourcePropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this SCIM Source Property Mapping.
     * @return [SCIMSourcePropertyMapping]
     */
    @GET("propertymappings/source/scim/{pm_uuid}/")
    suspend fun propertymappingsSourceScimRetrieve(@Path("pm_uuid") pmUuid: java.util.UUID): Response<SCIMSourcePropertyMapping>

    /**
     * PUT propertymappings/source/scim/{pm_uuid}/
     *
     * SCIMSourcePropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this SCIM Source Property Mapping.
     * @param scIMSourcePropertyMappingRequest
     * @return [SCIMSourcePropertyMapping]
     */
    @PUT("propertymappings/source/scim/{pm_uuid}/")
    suspend fun propertymappingsSourceScimUpdate(@Path("pm_uuid") pmUuid: java.util.UUID, @Body scIMSourcePropertyMappingRequest: SCIMSourcePropertyMappingRequest): Response<SCIMSourcePropertyMapping>

    /**
     * GET propertymappings/source/scim/{pm_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this SCIM Source Property Mapping.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("propertymappings/source/scim/{pm_uuid}/used_by/")
    suspend fun propertymappingsSourceScimUsedByList(@Path("pm_uuid") pmUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST propertymappings/source/telegram/
     *
     * TelegramSourcePropertyMapping Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param telegramSourcePropertyMappingRequest
     * @return [TelegramSourcePropertyMapping]
     */
    @POST("propertymappings/source/telegram/")
    suspend fun propertymappingsSourceTelegramCreate(@Body telegramSourcePropertyMappingRequest: TelegramSourcePropertyMappingRequest): Response<TelegramSourcePropertyMapping>

    /**
     * DELETE propertymappings/source/telegram/{pm_uuid}/
     *
     * TelegramSourcePropertyMapping Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Telegram Source Property Mapping.
     * @return [Unit]
     */
    @DELETE("propertymappings/source/telegram/{pm_uuid}/")
    suspend fun propertymappingsSourceTelegramDestroy(@Path("pm_uuid") pmUuid: java.util.UUID): Response<Unit>

    /**
     * GET propertymappings/source/telegram/
     *
     * TelegramSourcePropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param managed  (optional)
     * @param managedIsnull  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedTelegramSourcePropertyMappingList]
     */
    @GET("propertymappings/source/telegram/")
    suspend fun propertymappingsSourceTelegramList(@Query("managed") managed: @JvmSuppressWildcards kotlin.collections.List<kotlin.String>? = null, @Query("managed__isnull") managedIsnull: kotlin.Boolean? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedTelegramSourcePropertyMappingList>

    /**
     * PATCH propertymappings/source/telegram/{pm_uuid}/
     *
     * TelegramSourcePropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Telegram Source Property Mapping.
     * @param patchedTelegramSourcePropertyMappingRequest  (optional)
     * @return [TelegramSourcePropertyMapping]
     */
    @PATCH("propertymappings/source/telegram/{pm_uuid}/")
    suspend fun propertymappingsSourceTelegramPartialUpdate(@Path("pm_uuid") pmUuid: java.util.UUID, @Body patchedTelegramSourcePropertyMappingRequest: PatchedTelegramSourcePropertyMappingRequest? = null): Response<TelegramSourcePropertyMapping>

    /**
     * GET propertymappings/source/telegram/{pm_uuid}/
     *
     * TelegramSourcePropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Telegram Source Property Mapping.
     * @return [TelegramSourcePropertyMapping]
     */
    @GET("propertymappings/source/telegram/{pm_uuid}/")
    suspend fun propertymappingsSourceTelegramRetrieve(@Path("pm_uuid") pmUuid: java.util.UUID): Response<TelegramSourcePropertyMapping>

    /**
     * PUT propertymappings/source/telegram/{pm_uuid}/
     *
     * TelegramSourcePropertyMapping Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Telegram Source Property Mapping.
     * @param telegramSourcePropertyMappingRequest
     * @return [TelegramSourcePropertyMapping]
     */
    @PUT("propertymappings/source/telegram/{pm_uuid}/")
    suspend fun propertymappingsSourceTelegramUpdate(@Path("pm_uuid") pmUuid: java.util.UUID, @Body telegramSourcePropertyMappingRequest: TelegramSourcePropertyMappingRequest): Response<TelegramSourcePropertyMapping>

    /**
     * GET propertymappings/source/telegram/{pm_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pmUuid A UUID string identifying this Telegram Source Property Mapping.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("propertymappings/source/telegram/{pm_uuid}/used_by/")
    suspend fun propertymappingsSourceTelegramUsedByList(@Path("pm_uuid") pmUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

}
