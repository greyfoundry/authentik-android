package dev.greyfoundry.authentik.generated.api

import dev.greyfoundry.authentik.generated.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import dev.greyfoundry.authentik.generated.model.Application
import dev.greyfoundry.authentik.generated.model.ApplicationEntitlement
import dev.greyfoundry.authentik.generated.model.ApplicationEntitlementRequest
import dev.greyfoundry.authentik.generated.model.ApplicationRequest
import dev.greyfoundry.authentik.generated.model.AuthenticatedSession
import dev.greyfoundry.authentik.generated.model.Brand
import dev.greyfoundry.authentik.generated.model.BrandRequest
import dev.greyfoundry.authentik.generated.model.BulkDeleteSessionResponse
import dev.greyfoundry.authentik.generated.model.CurrentBrand
import dev.greyfoundry.authentik.generated.model.DataExport
import dev.greyfoundry.authentik.generated.model.GenericError
import dev.greyfoundry.authentik.generated.model.Group
import dev.greyfoundry.authentik.generated.model.GroupRequest
import dev.greyfoundry.authentik.generated.model.ImpersonationRequest
import dev.greyfoundry.authentik.generated.model.IntentEnum
import dev.greyfoundry.authentik.generated.model.Link
import dev.greyfoundry.authentik.generated.model.ObjectAttribute
import dev.greyfoundry.authentik.generated.model.ObjectAttributeRequest
import dev.greyfoundry.authentik.generated.model.PaginatedApplicationEntitlementList
import dev.greyfoundry.authentik.generated.model.PaginatedApplicationList
import dev.greyfoundry.authentik.generated.model.PaginatedAuthenticatedSessionList
import dev.greyfoundry.authentik.generated.model.PaginatedBrandList
import dev.greyfoundry.authentik.generated.model.PaginatedGroupList
import dev.greyfoundry.authentik.generated.model.PaginatedObjectAttributeList
import dev.greyfoundry.authentik.generated.model.PaginatedRequestableTargetList
import dev.greyfoundry.authentik.generated.model.PaginatedTokenList
import dev.greyfoundry.authentik.generated.model.PaginatedUserConsentList
import dev.greyfoundry.authentik.generated.model.PaginatedUserList
import dev.greyfoundry.authentik.generated.model.PatchedApplicationEntitlementRequest
import dev.greyfoundry.authentik.generated.model.PatchedApplicationRequest
import dev.greyfoundry.authentik.generated.model.PatchedBrandRequest
import dev.greyfoundry.authentik.generated.model.PatchedGroupRequest
import dev.greyfoundry.authentik.generated.model.PatchedObjectAttributeRequest
import dev.greyfoundry.authentik.generated.model.PatchedTokenRequest
import dev.greyfoundry.authentik.generated.model.PatchedUserRequest
import dev.greyfoundry.authentik.generated.model.PolicyTestResult
import dev.greyfoundry.authentik.generated.model.SessionUser
import dev.greyfoundry.authentik.generated.model.Token
import dev.greyfoundry.authentik.generated.model.TokenRequest
import dev.greyfoundry.authentik.generated.model.TokenSetKeyRequest
import dev.greyfoundry.authentik.generated.model.TokenView
import dev.greyfoundry.authentik.generated.model.TransactionApplicationRequest
import dev.greyfoundry.authentik.generated.model.TransactionApplicationResponse
import dev.greyfoundry.authentik.generated.model.UsedBy
import dev.greyfoundry.authentik.generated.model.User
import dev.greyfoundry.authentik.generated.model.UserAccountLockdownRequest
import dev.greyfoundry.authentik.generated.model.UserAccountRequest
import dev.greyfoundry.authentik.generated.model.UserConsent
import dev.greyfoundry.authentik.generated.model.UserPasswordHashSetRequest
import dev.greyfoundry.authentik.generated.model.UserPasswordSetRequest
import dev.greyfoundry.authentik.generated.model.UserPath
import dev.greyfoundry.authentik.generated.model.UserRecoveryEmailRequest
import dev.greyfoundry.authentik.generated.model.UserRecoveryLinkRequest
import dev.greyfoundry.authentik.generated.model.UserRequest
import dev.greyfoundry.authentik.generated.model.UserServiceAccountRequest
import dev.greyfoundry.authentik.generated.model.UserServiceAccountResponse
import dev.greyfoundry.authentik.generated.model.UserSwitchRequest
import dev.greyfoundry.authentik.generated.model.UserSwitchResponse
import dev.greyfoundry.authentik.generated.model.UserTypeEnum
import dev.greyfoundry.authentik.generated.model.ValidationError

interface CoreApi {
    /**
     * POST core/application_entitlements/
     *
     * ApplicationEntitlement Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param applicationEntitlementRequest
     * @return [ApplicationEntitlement]
     */
    @POST("core/application_entitlements/")
    suspend fun coreApplicationEntitlementsCreate(@Body applicationEntitlementRequest: ApplicationEntitlementRequest): Response<ApplicationEntitlement>

    /**
     * DELETE core/application_entitlements/{pbm_uuid}/
     *
     * ApplicationEntitlement Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param pbmUuid A UUID string identifying this Application Entitlement.
     * @return [Unit]
     */
    @DELETE("core/application_entitlements/{pbm_uuid}/")
    suspend fun coreApplicationEntitlementsDestroy(@Path("pbm_uuid") pbmUuid: java.util.UUID): Response<Unit>

    /**
     * GET core/application_entitlements/
     *
     * ApplicationEntitlement Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param app  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param pbmUuid  (optional)
     * @param search A search term. (optional)
     * @return [PaginatedApplicationEntitlementList]
     */
    @GET("core/application_entitlements/")
    suspend fun coreApplicationEntitlementsList(@Query("app") app: java.util.UUID? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("pbm_uuid") pbmUuid: java.util.UUID? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedApplicationEntitlementList>

    /**
     * PATCH core/application_entitlements/{pbm_uuid}/
     *
     * ApplicationEntitlement Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pbmUuid A UUID string identifying this Application Entitlement.
     * @param patchedApplicationEntitlementRequest  (optional)
     * @return [ApplicationEntitlement]
     */
    @PATCH("core/application_entitlements/{pbm_uuid}/")
    suspend fun coreApplicationEntitlementsPartialUpdate(@Path("pbm_uuid") pbmUuid: java.util.UUID, @Body patchedApplicationEntitlementRequest: PatchedApplicationEntitlementRequest? = null): Response<ApplicationEntitlement>

    /**
     * GET core/application_entitlements/requestable/
     *
     * List application entitlements which the current user can request access to
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param app  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param pbmUuid  (optional)
     * @param search A search term. (optional)
     * @return [PaginatedRequestableTargetList]
     */
    @GET("core/application_entitlements/requestable/")
    suspend fun coreApplicationEntitlementsRequestableList(@Query("app") app: java.util.UUID? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("pbm_uuid") pbmUuid: java.util.UUID? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedRequestableTargetList>

    /**
     * GET core/application_entitlements/{pbm_uuid}/
     *
     * ApplicationEntitlement Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pbmUuid A UUID string identifying this Application Entitlement.
     * @return [ApplicationEntitlement]
     */
    @GET("core/application_entitlements/{pbm_uuid}/")
    suspend fun coreApplicationEntitlementsRetrieve(@Path("pbm_uuid") pbmUuid: java.util.UUID): Response<ApplicationEntitlement>

    /**
     * PUT core/application_entitlements/{pbm_uuid}/
     *
     * ApplicationEntitlement Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pbmUuid A UUID string identifying this Application Entitlement.
     * @param applicationEntitlementRequest
     * @return [ApplicationEntitlement]
     */
    @PUT("core/application_entitlements/{pbm_uuid}/")
    suspend fun coreApplicationEntitlementsUpdate(@Path("pbm_uuid") pbmUuid: java.util.UUID, @Body applicationEntitlementRequest: ApplicationEntitlementRequest): Response<ApplicationEntitlement>

    /**
     * GET core/application_entitlements/{pbm_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pbmUuid A UUID string identifying this Application Entitlement.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("core/application_entitlements/{pbm_uuid}/used_by/")
    suspend fun coreApplicationEntitlementsUsedByList(@Path("pbm_uuid") pbmUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * GET core/applications/{slug}/check_access/
     *
     * Check access to a single application by slug
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @param forUser  (optional)
     * @return [PolicyTestResult]
     */
    @GET("core/applications/{slug}/check_access/")
    suspend fun coreApplicationsCheckAccessRetrieve(@Path("slug") slug: kotlin.String, @Query("for_user") forUser: kotlin.Int? = null): Response<PolicyTestResult>

    /**
     * POST core/applications/
     *
     * Application Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param applicationRequest
     * @return [Application]
     */
    @POST("core/applications/")
    suspend fun coreApplicationsCreate(@Body applicationRequest: ApplicationRequest): Response<Application>

    /**
     * DELETE core/applications/{slug}/
     *
     * Application Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @return [Unit]
     */
    @DELETE("core/applications/{slug}/")
    suspend fun coreApplicationsDestroy(@Path("slug") slug: kotlin.String): Response<Unit>

    /**
     * GET core/applications/
     *
     * Custom list method that checks Policy based access instead of guardian
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param forUser  (optional)
     * @param group  (optional)
     * @param metaDescription  (optional)
     * @param metaLaunchUrl  (optional)
     * @param metaPublisher  (optional)
     * @param name  (optional)
     * @param onlyWithLaunchUrl  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param slug  (optional)
     * @param superuserFullList  (optional)
     * @return [PaginatedApplicationList]
     */
    @GET("core/applications/")
    suspend fun coreApplicationsList(@Query("for_user") forUser: kotlin.Int? = null, @Query("group") group: kotlin.String? = null, @Query("meta_description") metaDescription: kotlin.String? = null, @Query("meta_launch_url") metaLaunchUrl: kotlin.String? = null, @Query("meta_publisher") metaPublisher: kotlin.String? = null, @Query("name") name: kotlin.String? = null, @Query("only_with_launch_url") onlyWithLaunchUrl: kotlin.Boolean? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("slug") slug: kotlin.String? = null, @Query("superuser_full_list") superuserFullList: kotlin.Boolean? = null): Response<PaginatedApplicationList>

    /**
     * PATCH core/applications/{slug}/
     *
     * Application Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @param patchedApplicationRequest  (optional)
     * @return [Application]
     */
    @PATCH("core/applications/{slug}/")
    suspend fun coreApplicationsPartialUpdate(@Path("slug") slug: kotlin.String, @Body patchedApplicationRequest: PatchedApplicationRequest? = null): Response<Application>

    /**
     * GET core/applications/requestable/
     *
     * List applications which the current user can request access to
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param group  (optional)
     * @param metaDescription  (optional)
     * @param metaLaunchUrl  (optional)
     * @param metaPublisher  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param slug  (optional)
     * @return [PaginatedApplicationList]
     */
    @GET("core/applications/requestable/")
    suspend fun coreApplicationsRequestableList(@Query("group") group: kotlin.String? = null, @Query("meta_description") metaDescription: kotlin.String? = null, @Query("meta_launch_url") metaLaunchUrl: kotlin.String? = null, @Query("meta_publisher") metaPublisher: kotlin.String? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("slug") slug: kotlin.String? = null): Response<PaginatedApplicationList>

    /**
     * GET core/applications/{slug}/
     *
     * Application Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @return [Application]
     */
    @GET("core/applications/{slug}/")
    suspend fun coreApplicationsRetrieve(@Path("slug") slug: kotlin.String): Response<Application>

    /**
     * PUT core/applications/{slug}/
     *
     * Application Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @param applicationRequest
     * @return [Application]
     */
    @PUT("core/applications/{slug}/")
    suspend fun coreApplicationsUpdate(@Path("slug") slug: kotlin.String, @Body applicationRequest: ApplicationRequest): Response<Application>

    /**
     * GET core/applications/{slug}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("core/applications/{slug}/used_by/")
    suspend fun coreApplicationsUsedByList(@Path("slug") slug: kotlin.String): Response<kotlin.collections.List<UsedBy>>

    /**
     * DELETE core/authenticated_sessions/bulk_delete/
     *
     * Bulk revoke all sessions for multiple users
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param userPks List of user IDs to revoke all sessions for
     * @return [BulkDeleteSessionResponse]
     */
    @DELETE("core/authenticated_sessions/bulk_delete/")
    suspend fun coreAuthenticatedSessionsBulkDeleteDestroy(@Query("user_pks") userPks: @JvmSuppressWildcards kotlin.collections.List<kotlin.Int>): Response<BulkDeleteSessionResponse>

    /**
     * DELETE core/authenticated_sessions/{uuid}/
     *
     * AuthenticatedSession Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param uuid
     * @return [Unit]
     */
    @DELETE("core/authenticated_sessions/{uuid}/")
    suspend fun coreAuthenticatedSessionsDestroy(@Path("uuid") uuid: java.util.UUID): Response<Unit>

    /**
     * GET core/authenticated_sessions/
     *
     * AuthenticatedSession Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param sessionLastIp  (optional)
     * @param sessionLastUserAgent  (optional)
     * @param userUsername  (optional)
     * @return [PaginatedAuthenticatedSessionList]
     */
    @GET("core/authenticated_sessions/")
    suspend fun coreAuthenticatedSessionsList(@Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("session__last_ip") sessionLastIp: kotlin.String? = null, @Query("session__last_user_agent") sessionLastUserAgent: kotlin.String? = null, @Query("user__username") userUsername: kotlin.String? = null): Response<PaginatedAuthenticatedSessionList>

    /**
     * GET core/authenticated_sessions/{uuid}/
     *
     * AuthenticatedSession Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid
     * @return [AuthenticatedSession]
     */
    @GET("core/authenticated_sessions/{uuid}/")
    suspend fun coreAuthenticatedSessionsRetrieve(@Path("uuid") uuid: java.util.UUID): Response<AuthenticatedSession>

    /**
     * GET core/authenticated_sessions/{uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("core/authenticated_sessions/{uuid}/used_by/")
    suspend fun coreAuthenticatedSessionsUsedByList(@Path("uuid") uuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST core/brands/
     *
     * Brand Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param brandRequest
     * @return [Brand]
     */
    @POST("core/brands/")
    suspend fun coreBrandsCreate(@Body brandRequest: BrandRequest): Response<Brand>

    /**
     * GET core/brands/current/
     *
     * Get current brand
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @return [CurrentBrand]
     */
    @GET("core/brands/current/")
    suspend fun coreBrandsCurrentRetrieve(): Response<CurrentBrand>

    /**
     * DELETE core/brands/{brand_uuid}/
     *
     * Brand Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param brandUuid A UUID string identifying this Brand.
     * @return [Unit]
     */
    @DELETE("core/brands/{brand_uuid}/")
    suspend fun coreBrandsDestroy(@Path("brand_uuid") brandUuid: java.util.UUID): Response<Unit>

    /**
     * GET core/brands/
     *
     * Brand Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param brandUuid  (optional)
     * @param brandingDefaultFlowBackground  (optional)
     * @param brandingFavicon  (optional)
     * @param brandingLogo  (optional)
     * @param brandingTitle  (optional)
     * @param clientCertificates  (optional)
     * @param default  (optional)
     * @param domain  (optional)
     * @param flowAuthentication  (optional)
     * @param flowDeviceCode  (optional)
     * @param flowInvalidation  (optional)
     * @param flowLockdown  (optional)
     * @param flowRecovery  (optional)
     * @param flowRequest  (optional)
     * @param flowUnenrollment  (optional)
     * @param flowUserSettings  (optional)
     * @param flowUserSwitch  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param webCertificate  (optional)
     * @return [PaginatedBrandList]
     */
    @GET("core/brands/")
    suspend fun coreBrandsList(@Query("brand_uuid") brandUuid: java.util.UUID? = null, @Query("branding_default_flow_background") brandingDefaultFlowBackground: kotlin.String? = null, @Query("branding_favicon") brandingFavicon: kotlin.String? = null, @Query("branding_logo") brandingLogo: kotlin.String? = null, @Query("branding_title") brandingTitle: kotlin.String? = null, @Query("client_certificates") clientCertificates: @JvmSuppressWildcards kotlin.collections.List<java.util.UUID>? = null, @Query("default") default: kotlin.Boolean? = null, @Query("domain") domain: kotlin.String? = null, @Query("flow_authentication") flowAuthentication: java.util.UUID? = null, @Query("flow_device_code") flowDeviceCode: java.util.UUID? = null, @Query("flow_invalidation") flowInvalidation: java.util.UUID? = null, @Query("flow_lockdown") flowLockdown: java.util.UUID? = null, @Query("flow_recovery") flowRecovery: java.util.UUID? = null, @Query("flow_request") flowRequest: java.util.UUID? = null, @Query("flow_unenrollment") flowUnenrollment: java.util.UUID? = null, @Query("flow_user_settings") flowUserSettings: java.util.UUID? = null, @Query("flow_user_switch") flowUserSwitch: java.util.UUID? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("web_certificate") webCertificate: java.util.UUID? = null): Response<PaginatedBrandList>

    /**
     * PATCH core/brands/{brand_uuid}/
     *
     * Brand Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param brandUuid A UUID string identifying this Brand.
     * @param patchedBrandRequest  (optional)
     * @return [Brand]
     */
    @PATCH("core/brands/{brand_uuid}/")
    suspend fun coreBrandsPartialUpdate(@Path("brand_uuid") brandUuid: java.util.UUID, @Body patchedBrandRequest: PatchedBrandRequest? = null): Response<Brand>

    /**
     * GET core/brands/{brand_uuid}/
     *
     * Brand Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param brandUuid A UUID string identifying this Brand.
     * @return [Brand]
     */
    @GET("core/brands/{brand_uuid}/")
    suspend fun coreBrandsRetrieve(@Path("brand_uuid") brandUuid: java.util.UUID): Response<Brand>

    /**
     * PUT core/brands/{brand_uuid}/
     *
     * Brand Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param brandUuid A UUID string identifying this Brand.
     * @param brandRequest
     * @return [Brand]
     */
    @PUT("core/brands/{brand_uuid}/")
    suspend fun coreBrandsUpdate(@Path("brand_uuid") brandUuid: java.util.UUID, @Body brandRequest: BrandRequest): Response<Brand>

    /**
     * GET core/brands/{brand_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param brandUuid A UUID string identifying this Brand.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("core/brands/{brand_uuid}/used_by/")
    suspend fun coreBrandsUsedByList(@Path("brand_uuid") brandUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST core/groups/{group_uuid}/add_user/
     *
     * Add user to group
     * Responses:
     *  - 204: User added
     *  - 404: User not found
     *  - 400:
     *  - 403:
     *
     * @param groupUuid A UUID string identifying this Group.
     * @param userAccountRequest
     * @return [Unit]
     */
    @POST("core/groups/{group_uuid}/add_user/")
    suspend fun coreGroupsAddUserCreate(@Path("group_uuid") groupUuid: java.util.UUID, @Body userAccountRequest: UserAccountRequest): Response<Unit>

    /**
     * POST core/groups/
     *
     * Group Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param groupRequest
     * @return [Group]
     */
    @POST("core/groups/")
    suspend fun coreGroupsCreate(@Body groupRequest: GroupRequest): Response<Group>

    /**
     * DELETE core/groups/{group_uuid}/
     *
     * Group Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param groupUuid A UUID string identifying this Group.
     * @return [Unit]
     */
    @DELETE("core/groups/{group_uuid}/")
    suspend fun coreGroupsDestroy(@Path("group_uuid") groupUuid: java.util.UUID): Response<Unit>

    /**
     * GET core/groups/
     *
     * Group Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param attributes Attributes (optional)
     * @param includeChildren  (optional, default to false)
     * @param includeInheritedRoles  (optional, default to false)
     * @param includeParents  (optional, default to false)
     * @param includeUsers  (optional, default to true)
     * @param isSuperuser  (optional)
     * @param membersByPk  (optional)
     * @param membersByUsername Required. 150 characters or fewer. Letters, digits and @/./+/-/_ only. (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedGroupList]
     */
    @GET("core/groups/")
    suspend fun coreGroupsList(@Query("attributes") attributes: kotlin.String? = null, @Query("include_children") includeChildren: kotlin.Boolean? = false, @Query("include_inherited_roles") includeInheritedRoles: kotlin.Boolean? = false, @Query("include_parents") includeParents: kotlin.Boolean? = false, @Query("include_users") includeUsers: kotlin.Boolean? = true, @Query("is_superuser") isSuperuser: kotlin.Boolean? = null, @Query("members_by_pk") membersByPk: @JvmSuppressWildcards kotlin.collections.List<kotlin.Int>? = null, @Query("members_by_username") membersByUsername: @JvmSuppressWildcards kotlin.collections.List<kotlin.String>? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedGroupList>

    /**
     * PATCH core/groups/{group_uuid}/
     *
     * Group Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param groupUuid A UUID string identifying this Group.
     * @param patchedGroupRequest  (optional)
     * @return [Group]
     */
    @PATCH("core/groups/{group_uuid}/")
    suspend fun coreGroupsPartialUpdate(@Path("group_uuid") groupUuid: java.util.UUID, @Body patchedGroupRequest: PatchedGroupRequest? = null): Response<Group>

    /**
     * POST core/groups/{group_uuid}/remove_user/
     *
     * Remove user from group
     * Responses:
     *  - 204: User removed
     *  - 404: User not found
     *  - 400:
     *  - 403:
     *
     * @param groupUuid A UUID string identifying this Group.
     * @param userAccountRequest
     * @return [Unit]
     */
    @POST("core/groups/{group_uuid}/remove_user/")
    suspend fun coreGroupsRemoveUserCreate(@Path("group_uuid") groupUuid: java.util.UUID, @Body userAccountRequest: UserAccountRequest): Response<Unit>

    /**
     * GET core/groups/{group_uuid}/
     *
     * Group Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param groupUuid A UUID string identifying this Group.
     * @param includeChildren  (optional, default to false)
     * @param includeInheritedRoles  (optional, default to false)
     * @param includeParents  (optional, default to false)
     * @param includeUsers  (optional, default to true)
     * @return [Group]
     */
    @GET("core/groups/{group_uuid}/")
    suspend fun coreGroupsRetrieve(@Path("group_uuid") groupUuid: java.util.UUID, @Query("include_children") includeChildren: kotlin.Boolean? = false, @Query("include_inherited_roles") includeInheritedRoles: kotlin.Boolean? = false, @Query("include_parents") includeParents: kotlin.Boolean? = false, @Query("include_users") includeUsers: kotlin.Boolean? = true): Response<Group>

    /**
     * PUT core/groups/{group_uuid}/
     *
     * Group Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param groupUuid A UUID string identifying this Group.
     * @param groupRequest
     * @return [Group]
     */
    @PUT("core/groups/{group_uuid}/")
    suspend fun coreGroupsUpdate(@Path("group_uuid") groupUuid: java.util.UUID, @Body groupRequest: GroupRequest): Response<Group>

    /**
     * GET core/groups/{group_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param groupUuid A UUID string identifying this Group.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("core/groups/{group_uuid}/used_by/")
    suspend fun coreGroupsUsedByList(@Path("group_uuid") groupUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST core/object_attributes/
     *
     *
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param objectAttributeRequest
     * @return [ObjectAttribute]
     */
    @POST("core/object_attributes/")
    suspend fun coreObjectAttributesCreate(@Body objectAttributeRequest: ObjectAttributeRequest): Response<ObjectAttribute>

    /**
     * DELETE core/object_attributes/{attribute_id}/
     *
     *
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param attributeId A UUID string identifying this Object Attribute.
     * @return [Unit]
     */
    @DELETE("core/object_attributes/{attribute_id}/")
    suspend fun coreObjectAttributesDestroy(@Path("attribute_id") attributeId: java.util.UUID): Response<Unit>

    /**
     * GET core/object_attributes/
     *
     *
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param enabled  (optional)
     * @param objectTypeAppLabel  (optional)
     * @param objectTypeModel  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedObjectAttributeList]
     */
    @GET("core/object_attributes/")
    suspend fun coreObjectAttributesList(@Query("enabled") enabled: kotlin.Boolean? = null, @Query("object_type__app_label") objectTypeAppLabel: kotlin.String? = null, @Query("object_type__model") objectTypeModel: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedObjectAttributeList>

    /**
     * PATCH core/object_attributes/{attribute_id}/
     *
     *
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param attributeId A UUID string identifying this Object Attribute.
     * @param patchedObjectAttributeRequest  (optional)
     * @return [ObjectAttribute]
     */
    @PATCH("core/object_attributes/{attribute_id}/")
    suspend fun coreObjectAttributesPartialUpdate(@Path("attribute_id") attributeId: java.util.UUID, @Body patchedObjectAttributeRequest: PatchedObjectAttributeRequest? = null): Response<ObjectAttribute>

    /**
     * GET core/object_attributes/{attribute_id}/
     *
     *
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param attributeId A UUID string identifying this Object Attribute.
     * @return [ObjectAttribute]
     */
    @GET("core/object_attributes/{attribute_id}/")
    suspend fun coreObjectAttributesRetrieve(@Path("attribute_id") attributeId: java.util.UUID): Response<ObjectAttribute>

    /**
     * PUT core/object_attributes/{attribute_id}/
     *
     *
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param attributeId A UUID string identifying this Object Attribute.
     * @param objectAttributeRequest
     * @return [ObjectAttribute]
     */
    @PUT("core/object_attributes/{attribute_id}/")
    suspend fun coreObjectAttributesUpdate(@Path("attribute_id") attributeId: java.util.UUID, @Body objectAttributeRequest: ObjectAttributeRequest): Response<ObjectAttribute>

    /**
     * POST core/tokens/
     *
     * Token Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param tokenRequest
     * @return [Token]
     */
    @POST("core/tokens/")
    suspend fun coreTokensCreate(@Body tokenRequest: TokenRequest): Response<Token>

    /**
     * DELETE core/tokens/{identifier}/
     *
     * Token Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param identifier
     * @return [Unit]
     */
    @DELETE("core/tokens/{identifier}/")
    suspend fun coreTokensDestroy(@Path("identifier") identifier: kotlin.String): Response<Unit>

    /**
     * GET core/tokens/
     *
     * Token Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param description  (optional)
     * @param expires  (optional)
     * @param expiring  (optional)
     * @param identifier  (optional)
     * @param intent  (optional)
     * @param managed  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param userUsername  (optional)
     * @return [PaginatedTokenList]
     */
    @GET("core/tokens/")
    suspend fun coreTokensList(@Query("description") description: kotlin.String? = null, @Query("expires") expires: java.time.OffsetDateTime? = null, @Query("expiring") expiring: kotlin.Boolean? = null, @Query("identifier") identifier: kotlin.String? = null, @Query("intent") intent: IntentEnum? = null, @Query("managed") managed: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("user__username") userUsername: kotlin.String? = null): Response<PaginatedTokenList>

    /**
     * PATCH core/tokens/{identifier}/
     *
     * Token Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param identifier
     * @param patchedTokenRequest  (optional)
     * @return [Token]
     */
    @PATCH("core/tokens/{identifier}/")
    suspend fun coreTokensPartialUpdate(@Path("identifier") identifier: kotlin.String, @Body patchedTokenRequest: PatchedTokenRequest? = null): Response<Token>

    /**
     * GET core/tokens/{identifier}/
     *
     * Token Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param identifier
     * @return [Token]
     */
    @GET("core/tokens/{identifier}/")
    suspend fun coreTokensRetrieve(@Path("identifier") identifier: kotlin.String): Response<Token>

    /**
     * POST core/tokens/{identifier}/set_key/
     *
     * Set token key. Action is logged as event. &#x60;authentik_core.set_token_key&#x60; permission is required.
     * Responses:
     *  - 204: Successfully changed key
     *  - 400: Missing key
     *  - 404: Token not found or expired
     *  - 403:
     *
     * @param identifier
     * @param tokenSetKeyRequest
     * @return [Unit]
     */
    @POST("core/tokens/{identifier}/set_key/")
    suspend fun coreTokensSetKeyCreate(@Path("identifier") identifier: kotlin.String, @Body tokenSetKeyRequest: TokenSetKeyRequest): Response<Unit>

    /**
     * PUT core/tokens/{identifier}/
     *
     * Token Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param identifier
     * @param tokenRequest
     * @return [Token]
     */
    @PUT("core/tokens/{identifier}/")
    suspend fun coreTokensUpdate(@Path("identifier") identifier: kotlin.String, @Body tokenRequest: TokenRequest): Response<Token>

    /**
     * GET core/tokens/{identifier}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param identifier
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("core/tokens/{identifier}/used_by/")
    suspend fun coreTokensUsedByList(@Path("identifier") identifier: kotlin.String): Response<kotlin.collections.List<UsedBy>>

    /**
     * GET core/tokens/{identifier}/view_key/
     *
     * Return token key and log access
     * Responses:
     *  - 200:
     *  - 404: Token not found or expired
     *  - 400:
     *  - 403:
     *
     * @param identifier
     * @return [TokenView]
     */
    @GET("core/tokens/{identifier}/view_key/")
    suspend fun coreTokensViewKeyRetrieve(@Path("identifier") identifier: kotlin.String): Response<TokenView>

    /**
     * PUT core/transactional/applications/
     *
     * Convert data into a blueprint, validate it and apply it
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param transactionApplicationRequest
     * @return [TransactionApplicationResponse]
     */
    @PUT("core/transactional/applications/")
    suspend fun coreTransactionalApplicationsUpdate(@Body transactionApplicationRequest: TransactionApplicationRequest): Response<TransactionApplicationResponse>

    /**
     * DELETE core/user_consent/{id}/
     *
     * UserConsent Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User Consent.
     * @return [Unit]
     */
    @DELETE("core/user_consent/{id}/")
    suspend fun coreUserConsentDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET core/user_consent/
     *
     * UserConsent Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param application  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param user  (optional)
     * @return [PaginatedUserConsentList]
     */
    @GET("core/user_consent/")
    suspend fun coreUserConsentList(@Query("application") application: java.util.UUID? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("user") user: kotlin.Int? = null): Response<PaginatedUserConsentList>

    /**
     * GET core/user_consent/{id}/
     *
     * UserConsent Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User Consent.
     * @return [UserConsent]
     */
    @GET("core/user_consent/{id}/")
    suspend fun coreUserConsentRetrieve(@Path("id") id: kotlin.Int): Response<UserConsent>

    /**
     * GET core/user_consent/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User Consent.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("core/user_consent/{id}/used_by/")
    suspend fun coreUserConsentUsedByList(@Path("id") id: kotlin.Int): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST core/users/account_lockdown/
     *
     * Choose the target account, then return a flow link.
     * Responses:
     *  - 200:
     *  - 400: No lockdown flow configured or the flow is not applicable
     *  - 403: Permission denied (when targeting another user)
     *
     * @param userAccountLockdownRequest  (optional)
     * @return [Link]
     */
    @POST("core/users/account_lockdown/")
    suspend fun coreUsersAccountLockdownCreate(@Body userAccountLockdownRequest: UserAccountLockdownRequest? = null): Response<Link>

    /**
     * POST core/users/
     *
     * User Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param userRequest
     * @return [User]
     */
    @POST("core/users/")
    suspend fun coreUsersCreate(@Body userRequest: UserRequest): Response<User>

    /**
     * DELETE core/users/{id}/
     *
     * User Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User.
     * @return [Unit]
     */
    @DELETE("core/users/{id}/")
    suspend fun coreUsersDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * POST core/users/export/
     *
     * Create a data export for this data type. Note that the export is generated asynchronously: this method returns a &#x60;DataExport&#x60; object that will initially have &#x60;completed&#x3D;false&#x60; as well as the permanent URL to that object in the &#x60;Location&#x60; header. You can poll that URL until &#x60;completed&#x3D;true&#x60;, at which point the &#x60;file_url&#x60; property will contain a URL to download
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param attributes Attributes (optional)
     * @param dateJoined  (optional)
     * @param dateJoinedGt  (optional)
     * @param dateJoinedLt  (optional)
     * @param email  (optional)
     * @param groupsByName  (optional)
     * @param groupsByPk  (optional)
     * @param isActive  (optional)
     * @param isSuperuser  (optional)
     * @param lastLogin  (optional)
     * @param lastLoginGt  (optional)
     * @param lastLoginIsnull  (optional)
     * @param lastLoginLt  (optional)
     * @param lastUpdated  (optional)
     * @param lastUpdatedGt  (optional)
     * @param lastUpdatedLt  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param path  (optional)
     * @param pathStartswith  (optional)
     * @param rolesByName  (optional)
     * @param rolesByPk  (optional)
     * @param search A search term. (optional)
     * @param type  (optional)
     * @param username  (optional)
     * @param uuid  (optional)
     * @return [DataExport]
     */
    @POST("core/users/export/")
    suspend fun coreUsersExportCreate(@Query("attributes") attributes: kotlin.String? = null, @Query("date_joined") dateJoined: java.time.OffsetDateTime? = null, @Query("date_joined__gt") dateJoinedGt: java.time.OffsetDateTime? = null, @Query("date_joined__lt") dateJoinedLt: java.time.OffsetDateTime? = null, @Query("email") email: kotlin.String? = null, @Query("groups_by_name") groupsByName: @JvmSuppressWildcards kotlin.collections.List<kotlin.String>? = null, @Query("groups_by_pk") groupsByPk: @JvmSuppressWildcards kotlin.collections.List<java.util.UUID>? = null, @Query("is_active") isActive: kotlin.Boolean? = null, @Query("is_superuser") isSuperuser: kotlin.Boolean? = null, @Query("last_login") lastLogin: java.time.OffsetDateTime? = null, @Query("last_login__gt") lastLoginGt: java.time.OffsetDateTime? = null, @Query("last_login__isnull") lastLoginIsnull: kotlin.Boolean? = null, @Query("last_login__lt") lastLoginLt: java.time.OffsetDateTime? = null, @Query("last_updated") lastUpdated: java.time.OffsetDateTime? = null, @Query("last_updated__gt") lastUpdatedGt: java.time.OffsetDateTime? = null, @Query("last_updated__lt") lastUpdatedLt: java.time.OffsetDateTime? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("path") path: kotlin.String? = null, @Query("path_startswith") pathStartswith: kotlin.String? = null, @Query("roles_by_name") rolesByName: @JvmSuppressWildcards kotlin.collections.List<kotlin.String>? = null, @Query("roles_by_pk") rolesByPk: @JvmSuppressWildcards kotlin.collections.List<java.util.UUID>? = null, @Query("search") search: kotlin.String? = null, @Query("type") type: @JvmSuppressWildcards kotlin.collections.List<UserTypeEnum>? = null, @Query("username") username: kotlin.String? = null, @Query("uuid") uuid: java.util.UUID? = null): Response<DataExport>

    /**
     * POST core/users/{id}/impersonate/
     *
     * Impersonate a user
     * Responses:
     *  - 204: Successfully started impersonation
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User.
     * @param impersonationRequest
     * @return [Unit]
     */
    @POST("core/users/{id}/impersonate/")
    suspend fun coreUsersImpersonateCreate(@Path("id") id: kotlin.Int, @Body impersonationRequest: ImpersonationRequest): Response<Unit>

    /**
     * GET core/users/impersonate_end/
     *
     * End Impersonation a user
     * Responses:
     *  - 204: Successfully ended impersonation
     *  - 400:
     *  - 403:
     *
     * @return [Unit]
     */
    @GET("core/users/impersonate_end/")
    suspend fun coreUsersImpersonateEndRetrieve(): Response<Unit>

    /**
     * GET core/users/
     *
     * User Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param attributes Attributes (optional)
     * @param dateJoined  (optional)
     * @param dateJoinedGt  (optional)
     * @param dateJoinedLt  (optional)
     * @param email  (optional)
     * @param groupsByName  (optional)
     * @param groupsByPk  (optional)
     * @param includeGroups  (optional, default to true)
     * @param includeRoles  (optional, default to true)
     * @param isActive  (optional)
     * @param isSuperuser  (optional)
     * @param lastLogin  (optional)
     * @param lastLoginGt  (optional)
     * @param lastLoginIsnull  (optional)
     * @param lastLoginLt  (optional)
     * @param lastUpdated  (optional)
     * @param lastUpdatedGt  (optional)
     * @param lastUpdatedLt  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param path  (optional)
     * @param pathStartswith  (optional)
     * @param rolesByName  (optional)
     * @param rolesByPk  (optional)
     * @param search A search term. (optional)
     * @param type  (optional)
     * @param username  (optional)
     * @param uuid  (optional)
     * @return [PaginatedUserList]
     */
    @GET("core/users/")
    suspend fun coreUsersList(@Query("attributes") attributes: kotlin.String? = null, @Query("date_joined") dateJoined: java.time.OffsetDateTime? = null, @Query("date_joined__gt") dateJoinedGt: java.time.OffsetDateTime? = null, @Query("date_joined__lt") dateJoinedLt: java.time.OffsetDateTime? = null, @Query("email") email: kotlin.String? = null, @Query("groups_by_name") groupsByName: @JvmSuppressWildcards kotlin.collections.List<kotlin.String>? = null, @Query("groups_by_pk") groupsByPk: @JvmSuppressWildcards kotlin.collections.List<java.util.UUID>? = null, @Query("include_groups") includeGroups: kotlin.Boolean? = true, @Query("include_roles") includeRoles: kotlin.Boolean? = true, @Query("is_active") isActive: kotlin.Boolean? = null, @Query("is_superuser") isSuperuser: kotlin.Boolean? = null, @Query("last_login") lastLogin: java.time.OffsetDateTime? = null, @Query("last_login__gt") lastLoginGt: java.time.OffsetDateTime? = null, @Query("last_login__isnull") lastLoginIsnull: kotlin.Boolean? = null, @Query("last_login__lt") lastLoginLt: java.time.OffsetDateTime? = null, @Query("last_updated") lastUpdated: java.time.OffsetDateTime? = null, @Query("last_updated__gt") lastUpdatedGt: java.time.OffsetDateTime? = null, @Query("last_updated__lt") lastUpdatedLt: java.time.OffsetDateTime? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("path") path: kotlin.String? = null, @Query("path_startswith") pathStartswith: kotlin.String? = null, @Query("roles_by_name") rolesByName: @JvmSuppressWildcards kotlin.collections.List<kotlin.String>? = null, @Query("roles_by_pk") rolesByPk: @JvmSuppressWildcards kotlin.collections.List<java.util.UUID>? = null, @Query("search") search: kotlin.String? = null, @Query("type") type: @JvmSuppressWildcards kotlin.collections.List<UserTypeEnum>? = null, @Query("username") username: kotlin.String? = null, @Query("uuid") uuid: java.util.UUID? = null): Response<PaginatedUserList>

    /**
     * GET core/users/me/
     *
     * Get information about current user
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @return [SessionUser]
     */
    @GET("core/users/me/")
    suspend fun coreUsersMeRetrieve(): Response<SessionUser>

    /**
     * PATCH core/users/{id}/
     *
     * User Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User.
     * @param patchedUserRequest  (optional)
     * @return [User]
     */
    @PATCH("core/users/{id}/")
    suspend fun coreUsersPartialUpdate(@Path("id") id: kotlin.Int, @Body patchedUserRequest: PatchedUserRequest? = null): Response<User>

    /**
     * GET core/users/paths/
     *
     * Get all user paths
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param search A search term. (optional)
     * @return [UserPath]
     */
    @GET("core/users/paths/")
    suspend fun coreUsersPathsRetrieve(@Query("search") search: kotlin.String? = null): Response<UserPath>

    /**
     * POST core/users/{id}/recovery/
     *
     * Create a temporary link that a user can use to recover their account
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User.
     * @param userRecoveryLinkRequest  (optional)
     * @return [Link]
     */
    @POST("core/users/{id}/recovery/")
    suspend fun coreUsersRecoveryCreate(@Path("id") id: kotlin.Int, @Body userRecoveryLinkRequest: UserRecoveryLinkRequest? = null): Response<Link>

    /**
     * POST core/users/{id}/recovery_email/
     *
     * Send an email with a temporary link that a user can use to recover their account
     * Responses:
     *  - 204: Successfully sent recover email
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User.
     * @param userRecoveryEmailRequest
     * @return [Unit]
     */
    @POST("core/users/{id}/recovery_email/")
    suspend fun coreUsersRecoveryEmailCreate(@Path("id") id: kotlin.Int, @Body userRecoveryEmailRequest: UserRecoveryEmailRequest): Response<Unit>

    /**
     * GET core/users/{id}/
     *
     * User Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User.
     * @return [User]
     */
    @GET("core/users/{id}/")
    suspend fun coreUsersRetrieve(@Path("id") id: kotlin.Int): Response<User>

    /**
     * POST core/users/service_account/
     *
     * Create a new user account that is marked as a service account
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param userServiceAccountRequest
     * @return [UserServiceAccountResponse]
     */
    @POST("core/users/service_account/")
    suspend fun coreUsersServiceAccountCreate(@Body userServiceAccountRequest: UserServiceAccountRequest): Response<UserServiceAccountResponse>

    /**
     * POST core/users/{id}/set_password/
     *
     * Set password for user
     * Responses:
     *  - 204: Successfully changed password
     *  - 400: Bad request
     *  - 403:
     *
     * @param id A unique integer value identifying this User.
     * @param userPasswordSetRequest
     * @return [Unit]
     */
    @POST("core/users/{id}/set_password/")
    suspend fun coreUsersSetPasswordCreate(@Path("id") id: kotlin.Int, @Body userPasswordSetRequest: UserPasswordSetRequest): Response<Unit>

    /**
     * POST core/users/{id}/set_password_hash/
     *
     * Set a user&#39;s password from a pre-hashed Django password value.  Submit the Django password hash in the shared &#x60;&#x60;password&#x60;&#x60; request field.  This updates authentik&#39;s local password verifier only. It does not attempt to propagate the password change to LDAP or Kerberos because no raw password is available from the request payload.
     * Responses:
     *  - 204: Successfully changed password
     *  - 400: Bad request
     *  - 403:
     *
     * @param id A unique integer value identifying this User.
     * @param userPasswordHashSetRequest
     * @return [Unit]
     */
    @POST("core/users/{id}/set_password_hash/")
    suspend fun coreUsersSetPasswordHashCreate(@Path("id") id: kotlin.Int, @Body userPasswordHashSetRequest: UserPasswordHashSetRequest): Response<Unit>

    /**
     * POST core/users/switch/
     *
     * Start browser user switching.
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param next  (optional)
     * @param userSwitchRequest  (optional)
     * @return [UserSwitchResponse]
     */
    @POST("core/users/switch/")
    suspend fun coreUsersSwitchCreate(@Query("next") next: kotlin.String? = null, @Body userSwitchRequest: UserSwitchRequest? = null): Response<UserSwitchResponse>

    /**
     * PUT core/users/{id}/
     *
     * User Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User.
     * @param userRequest
     * @return [User]
     */
    @PUT("core/users/{id}/")
    suspend fun coreUsersUpdate(@Path("id") id: kotlin.Int, @Body userRequest: UserRequest): Response<User>

    /**
     * GET core/users/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("core/users/{id}/used_by/")
    suspend fun coreUsersUsedByList(@Path("id") id: kotlin.Int): Response<kotlin.collections.List<UsedBy>>

}
