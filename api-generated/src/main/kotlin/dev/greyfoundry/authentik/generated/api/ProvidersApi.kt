package dev.greyfoundry.authentik.generated.api

import dev.greyfoundry.authentik.generated.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import dev.greyfoundry.authentik.generated.model.ClientTypeEnum
import dev.greyfoundry.authentik.generated.model.DigestAlgorithmEnum
import dev.greyfoundry.authentik.generated.model.ForceBindingEnum
import dev.greyfoundry.authentik.generated.model.GenericError
import dev.greyfoundry.authentik.generated.model.GoogleWorkspaceProvider
import dev.greyfoundry.authentik.generated.model.GoogleWorkspaceProviderGroup
import dev.greyfoundry.authentik.generated.model.GoogleWorkspaceProviderGroupRequest
import dev.greyfoundry.authentik.generated.model.GoogleWorkspaceProviderRequest
import dev.greyfoundry.authentik.generated.model.GoogleWorkspaceProviderUser
import dev.greyfoundry.authentik.generated.model.GoogleWorkspaceProviderUserRequest
import dev.greyfoundry.authentik.generated.model.IssuerModeEnum
import dev.greyfoundry.authentik.generated.model.LDAPProvider
import dev.greyfoundry.authentik.generated.model.LDAPProviderRequest
import dev.greyfoundry.authentik.generated.model.MicrosoftEntraProvider
import dev.greyfoundry.authentik.generated.model.MicrosoftEntraProviderGroup
import dev.greyfoundry.authentik.generated.model.MicrosoftEntraProviderGroupRequest
import dev.greyfoundry.authentik.generated.model.MicrosoftEntraProviderRequest
import dev.greyfoundry.authentik.generated.model.MicrosoftEntraProviderUser
import dev.greyfoundry.authentik.generated.model.MicrosoftEntraProviderUserRequest
import dev.greyfoundry.authentik.generated.model.OAuth2DynamicClientRegistration
import dev.greyfoundry.authentik.generated.model.OAuth2DynamicClientRegistrationRequest
import dev.greyfoundry.authentik.generated.model.OAuth2Provider
import dev.greyfoundry.authentik.generated.model.OAuth2ProviderRequest
import dev.greyfoundry.authentik.generated.model.OAuth2ProviderSetupURLs
import dev.greyfoundry.authentik.generated.model.PaginatedGoogleWorkspaceProviderGroupList
import dev.greyfoundry.authentik.generated.model.PaginatedGoogleWorkspaceProviderList
import dev.greyfoundry.authentik.generated.model.PaginatedGoogleWorkspaceProviderUserList
import dev.greyfoundry.authentik.generated.model.PaginatedLDAPProviderList
import dev.greyfoundry.authentik.generated.model.PaginatedMicrosoftEntraProviderGroupList
import dev.greyfoundry.authentik.generated.model.PaginatedMicrosoftEntraProviderList
import dev.greyfoundry.authentik.generated.model.PaginatedMicrosoftEntraProviderUserList
import dev.greyfoundry.authentik.generated.model.PaginatedOAuth2DynamicClientRegistrationList
import dev.greyfoundry.authentik.generated.model.PaginatedOAuth2ProviderList
import dev.greyfoundry.authentik.generated.model.PaginatedProviderList
import dev.greyfoundry.authentik.generated.model.PaginatedProxyProviderList
import dev.greyfoundry.authentik.generated.model.PaginatedRACProviderList
import dev.greyfoundry.authentik.generated.model.PaginatedRadiusProviderList
import dev.greyfoundry.authentik.generated.model.PaginatedSAMLProviderList
import dev.greyfoundry.authentik.generated.model.PaginatedSCIMProviderGroupList
import dev.greyfoundry.authentik.generated.model.PaginatedSCIMProviderList
import dev.greyfoundry.authentik.generated.model.PaginatedSCIMProviderUserList
import dev.greyfoundry.authentik.generated.model.PaginatedSSFProviderList
import dev.greyfoundry.authentik.generated.model.PaginatedWSFederationProviderList
import dev.greyfoundry.authentik.generated.model.PatchedGoogleWorkspaceProviderRequest
import dev.greyfoundry.authentik.generated.model.PatchedLDAPProviderRequest
import dev.greyfoundry.authentik.generated.model.PatchedMicrosoftEntraProviderRequest
import dev.greyfoundry.authentik.generated.model.PatchedOAuth2DynamicClientRegistrationRequest
import dev.greyfoundry.authentik.generated.model.PatchedOAuth2ProviderRequest
import dev.greyfoundry.authentik.generated.model.PatchedProxyProviderRequest
import dev.greyfoundry.authentik.generated.model.PatchedRACProviderRequest
import dev.greyfoundry.authentik.generated.model.PatchedRadiusProviderRequest
import dev.greyfoundry.authentik.generated.model.PatchedSAMLProviderRequest
import dev.greyfoundry.authentik.generated.model.PatchedSCIMProviderRequest
import dev.greyfoundry.authentik.generated.model.PatchedSSFProviderRequest
import dev.greyfoundry.authentik.generated.model.PatchedWSFederationProviderRequest
import dev.greyfoundry.authentik.generated.model.PropertyMappingPreview
import dev.greyfoundry.authentik.generated.model.Provider
import dev.greyfoundry.authentik.generated.model.ProxyProvider
import dev.greyfoundry.authentik.generated.model.ProxyProviderRequest
import dev.greyfoundry.authentik.generated.model.RACProvider
import dev.greyfoundry.authentik.generated.model.RACProviderRequest
import dev.greyfoundry.authentik.generated.model.RadiusProvider
import dev.greyfoundry.authentik.generated.model.RadiusProviderRequest
import dev.greyfoundry.authentik.generated.model.SAMLBindingsEnum
import dev.greyfoundry.authentik.generated.model.SAMLLogoutMethods
import dev.greyfoundry.authentik.generated.model.SAMLMetadata
import dev.greyfoundry.authentik.generated.model.SAMLNameIDPolicyEnum
import dev.greyfoundry.authentik.generated.model.SAMLProvider
import dev.greyfoundry.authentik.generated.model.SAMLProviderRequest
import dev.greyfoundry.authentik.generated.model.SCIMProvider
import dev.greyfoundry.authentik.generated.model.SCIMProviderGroup
import dev.greyfoundry.authentik.generated.model.SCIMProviderGroupRequest
import dev.greyfoundry.authentik.generated.model.SCIMProviderRequest
import dev.greyfoundry.authentik.generated.model.SCIMProviderUser
import dev.greyfoundry.authentik.generated.model.SCIMProviderUserRequest
import dev.greyfoundry.authentik.generated.model.SSFProvider
import dev.greyfoundry.authentik.generated.model.SSFProviderRequest
import dev.greyfoundry.authentik.generated.model.SamlVersionEnum
import dev.greyfoundry.authentik.generated.model.SignatureAlgorithmEnum
import dev.greyfoundry.authentik.generated.model.SubModeEnum
import dev.greyfoundry.authentik.generated.model.SyncObjectRequest
import dev.greyfoundry.authentik.generated.model.SyncObjectResult
import dev.greyfoundry.authentik.generated.model.SyncStatus
import dev.greyfoundry.authentik.generated.model.TypeCreate
import dev.greyfoundry.authentik.generated.model.UsedBy
import dev.greyfoundry.authentik.generated.model.ValidationError
import dev.greyfoundry.authentik.generated.model.WSFederationProvider
import dev.greyfoundry.authentik.generated.model.WSFederationProviderRequest

import okhttp3.MultipartBody

interface ProvidersApi {
    /**
     * DELETE providers/all/{id}/
     *
     * Provider Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this provider.
     * @return [Unit]
     */
    @DELETE("providers/all/{id}/")
    suspend fun providersAllDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET providers/all/
     *
     * Provider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param applicationIsnull  (optional)
     * @param backchannel When not set all providers are returned. When set to true, only backchannel providers are returned. When set to false, backchannel providers are excluded (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedProviderList]
     */
    @GET("providers/all/")
    suspend fun providersAllList(@Query("application__isnull") applicationIsnull: kotlin.Boolean? = null, @Query("backchannel") backchannel: kotlin.Boolean? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedProviderList>

    /**
     * GET providers/all/{id}/
     *
     * Provider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this provider.
     * @return [Provider]
     */
    @GET("providers/all/{id}/")
    suspend fun providersAllRetrieve(@Path("id") id: kotlin.Int): Response<Provider>

    /**
     * GET providers/all/types/
     *
     * Get all creatable types
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @return [kotlin.collections.List<TypeCreate>]
     */
    @GET("providers/all/types/")
    suspend fun providersAllTypesList(): Response<kotlin.collections.List<TypeCreate>>

    /**
     * GET providers/all/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this provider.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("providers/all/{id}/used_by/")
    suspend fun providersAllUsedByList(@Path("id") id: kotlin.Int): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST providers/google_workspace/
     *
     * GoogleWorkspaceProvider Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param googleWorkspaceProviderRequest
     * @return [GoogleWorkspaceProvider]
     */
    @POST("providers/google_workspace/")
    suspend fun providersGoogleWorkspaceCreate(@Body googleWorkspaceProviderRequest: GoogleWorkspaceProviderRequest): Response<GoogleWorkspaceProvider>

    /**
     * DELETE providers/google_workspace/{id}/
     *
     * GoogleWorkspaceProvider Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Google Workspace Provider.
     * @return [Unit]
     */
    @DELETE("providers/google_workspace/{id}/")
    suspend fun providersGoogleWorkspaceDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * POST providers/google_workspace_groups/
     *
     * GoogleWorkspaceProviderGroup Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param googleWorkspaceProviderGroupRequest
     * @return [GoogleWorkspaceProviderGroup]
     */
    @POST("providers/google_workspace_groups/")
    suspend fun providersGoogleWorkspaceGroupsCreate(@Body googleWorkspaceProviderGroupRequest: GoogleWorkspaceProviderGroupRequest): Response<GoogleWorkspaceProviderGroup>

    /**
     * DELETE providers/google_workspace_groups/{id}/
     *
     * GoogleWorkspaceProviderGroup Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A UUID string identifying this Google Workspace Provider Group.
     * @return [Unit]
     */
    @DELETE("providers/google_workspace_groups/{id}/")
    suspend fun providersGoogleWorkspaceGroupsDestroy(@Path("id") id: java.util.UUID): Response<Unit>

    /**
     * GET providers/google_workspace_groups/
     *
     * GoogleWorkspaceProviderGroup Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param groupGroupUuid  (optional)
     * @param groupName  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param providerId  (optional)
     * @param search A search term. (optional)
     * @return [PaginatedGoogleWorkspaceProviderGroupList]
     */
    @GET("providers/google_workspace_groups/")
    suspend fun providersGoogleWorkspaceGroupsList(@Query("group__group_uuid") groupGroupUuid: java.util.UUID? = null, @Query("group__name") groupName: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("provider__id") providerId: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedGoogleWorkspaceProviderGroupList>

    /**
     * GET providers/google_workspace_groups/{id}/
     *
     * GoogleWorkspaceProviderGroup Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A UUID string identifying this Google Workspace Provider Group.
     * @return [GoogleWorkspaceProviderGroup]
     */
    @GET("providers/google_workspace_groups/{id}/")
    suspend fun providersGoogleWorkspaceGroupsRetrieve(@Path("id") id: java.util.UUID): Response<GoogleWorkspaceProviderGroup>

    /**
     * GET providers/google_workspace_groups/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A UUID string identifying this Google Workspace Provider Group.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("providers/google_workspace_groups/{id}/used_by/")
    suspend fun providersGoogleWorkspaceGroupsUsedByList(@Path("id") id: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * GET providers/google_workspace/
     *
     * GoogleWorkspaceProvider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param delegatedSubject  (optional)
     * @param excludeUsersServiceAccount  (optional)
     * @param filterGroup  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedGoogleWorkspaceProviderList]
     */
    @GET("providers/google_workspace/")
    suspend fun providersGoogleWorkspaceList(@Query("delegated_subject") delegatedSubject: kotlin.String? = null, @Query("exclude_users_service_account") excludeUsersServiceAccount: kotlin.Boolean? = null, @Query("filter_group") filterGroup: java.util.UUID? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedGoogleWorkspaceProviderList>

    /**
     * PATCH providers/google_workspace/{id}/
     *
     * GoogleWorkspaceProvider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Google Workspace Provider.
     * @param patchedGoogleWorkspaceProviderRequest  (optional)
     * @return [GoogleWorkspaceProvider]
     */
    @PATCH("providers/google_workspace/{id}/")
    suspend fun providersGoogleWorkspacePartialUpdate(@Path("id") id: kotlin.Int, @Body patchedGoogleWorkspaceProviderRequest: PatchedGoogleWorkspaceProviderRequest? = null): Response<GoogleWorkspaceProvider>

    /**
     * GET providers/google_workspace/{id}/
     *
     * GoogleWorkspaceProvider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Google Workspace Provider.
     * @return [GoogleWorkspaceProvider]
     */
    @GET("providers/google_workspace/{id}/")
    suspend fun providersGoogleWorkspaceRetrieve(@Path("id") id: kotlin.Int): Response<GoogleWorkspaceProvider>

    /**
     * POST providers/google_workspace/{id}/sync/object/
     *
     * Sync/Re-sync a single user/group object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Google Workspace Provider.
     * @param syncObjectRequest
     * @return [SyncObjectResult]
     */
    @POST("providers/google_workspace/{id}/sync/object/")
    suspend fun providersGoogleWorkspaceSyncObjectCreate(@Path("id") id: kotlin.Int, @Body syncObjectRequest: SyncObjectRequest): Response<SyncObjectResult>

    /**
     * GET providers/google_workspace/{id}/sync/status/
     *
     * Get provider&#39;s sync status
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Google Workspace Provider.
     * @return [SyncStatus]
     */
    @GET("providers/google_workspace/{id}/sync/status/")
    suspend fun providersGoogleWorkspaceSyncStatusRetrieve(@Path("id") id: kotlin.Int): Response<SyncStatus>

    /**
     * PUT providers/google_workspace/{id}/
     *
     * GoogleWorkspaceProvider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Google Workspace Provider.
     * @param googleWorkspaceProviderRequest
     * @return [GoogleWorkspaceProvider]
     */
    @PUT("providers/google_workspace/{id}/")
    suspend fun providersGoogleWorkspaceUpdate(@Path("id") id: kotlin.Int, @Body googleWorkspaceProviderRequest: GoogleWorkspaceProviderRequest): Response<GoogleWorkspaceProvider>

    /**
     * GET providers/google_workspace/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Google Workspace Provider.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("providers/google_workspace/{id}/used_by/")
    suspend fun providersGoogleWorkspaceUsedByList(@Path("id") id: kotlin.Int): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST providers/google_workspace_users/
     *
     * GoogleWorkspaceProviderUser Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param googleWorkspaceProviderUserRequest
     * @return [GoogleWorkspaceProviderUser]
     */
    @POST("providers/google_workspace_users/")
    suspend fun providersGoogleWorkspaceUsersCreate(@Body googleWorkspaceProviderUserRequest: GoogleWorkspaceProviderUserRequest): Response<GoogleWorkspaceProviderUser>

    /**
     * DELETE providers/google_workspace_users/{id}/
     *
     * GoogleWorkspaceProviderUser Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A UUID string identifying this Google Workspace Provider User.
     * @return [Unit]
     */
    @DELETE("providers/google_workspace_users/{id}/")
    suspend fun providersGoogleWorkspaceUsersDestroy(@Path("id") id: java.util.UUID): Response<Unit>

    /**
     * GET providers/google_workspace_users/
     *
     * GoogleWorkspaceProviderUser Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param providerId  (optional)
     * @param search A search term. (optional)
     * @param userId  (optional)
     * @param userUsername  (optional)
     * @return [PaginatedGoogleWorkspaceProviderUserList]
     */
    @GET("providers/google_workspace_users/")
    suspend fun providersGoogleWorkspaceUsersList(@Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("provider__id") providerId: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("user__id") userId: kotlin.Int? = null, @Query("user__username") userUsername: kotlin.String? = null): Response<PaginatedGoogleWorkspaceProviderUserList>

    /**
     * GET providers/google_workspace_users/{id}/
     *
     * GoogleWorkspaceProviderUser Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A UUID string identifying this Google Workspace Provider User.
     * @return [GoogleWorkspaceProviderUser]
     */
    @GET("providers/google_workspace_users/{id}/")
    suspend fun providersGoogleWorkspaceUsersRetrieve(@Path("id") id: java.util.UUID): Response<GoogleWorkspaceProviderUser>

    /**
     * GET providers/google_workspace_users/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A UUID string identifying this Google Workspace Provider User.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("providers/google_workspace_users/{id}/used_by/")
    suspend fun providersGoogleWorkspaceUsersUsedByList(@Path("id") id: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST providers/ldap/
     *
     * LDAPProvider Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param ldAPProviderRequest
     * @return [LDAPProvider]
     */
    @POST("providers/ldap/")
    suspend fun providersLdapCreate(@Body ldAPProviderRequest: LDAPProviderRequest): Response<LDAPProvider>

    /**
     * DELETE providers/ldap/{id}/
     *
     * LDAPProvider Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this LDAP Provider.
     * @return [Unit]
     */
    @DELETE("providers/ldap/{id}/")
    suspend fun providersLdapDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET providers/ldap/
     *
     * LDAPProvider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param applicationIsnull  (optional)
     * @param authorizationFlowSlugIexact  (optional)
     * @param baseDnIexact  (optional)
     * @param certificateKpUuidIexact  (optional)
     * @param certificateNameIexact  (optional)
     * @param gidStartNumberIexact  (optional)
     * @param nameIexact  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param tlsServerNameIexact  (optional)
     * @param uidStartNumberIexact  (optional)
     * @return [PaginatedLDAPProviderList]
     */
    @GET("providers/ldap/")
    suspend fun providersLdapList(@Query("application__isnull") applicationIsnull: kotlin.Boolean? = null, @Query("authorization_flow__slug__iexact") authorizationFlowSlugIexact: kotlin.String? = null, @Query("base_dn__iexact") baseDnIexact: kotlin.String? = null, @Query("certificate__kp_uuid__iexact") certificateKpUuidIexact: java.util.UUID? = null, @Query("certificate__name__iexact") certificateNameIexact: kotlin.String? = null, @Query("gid_start_number__iexact") gidStartNumberIexact: kotlin.Int? = null, @Query("name__iexact") nameIexact: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("tls_server_name__iexact") tlsServerNameIexact: kotlin.String? = null, @Query("uid_start_number__iexact") uidStartNumberIexact: kotlin.Int? = null): Response<PaginatedLDAPProviderList>

    /**
     * PATCH providers/ldap/{id}/
     *
     * LDAPProvider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this LDAP Provider.
     * @param patchedLDAPProviderRequest  (optional)
     * @return [LDAPProvider]
     */
    @PATCH("providers/ldap/{id}/")
    suspend fun providersLdapPartialUpdate(@Path("id") id: kotlin.Int, @Body patchedLDAPProviderRequest: PatchedLDAPProviderRequest? = null): Response<LDAPProvider>

    /**
     * GET providers/ldap/{id}/
     *
     * LDAPProvider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this LDAP Provider.
     * @return [LDAPProvider]
     */
    @GET("providers/ldap/{id}/")
    suspend fun providersLdapRetrieve(@Path("id") id: kotlin.Int): Response<LDAPProvider>

    /**
     * PUT providers/ldap/{id}/
     *
     * LDAPProvider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this LDAP Provider.
     * @param ldAPProviderRequest
     * @return [LDAPProvider]
     */
    @PUT("providers/ldap/{id}/")
    suspend fun providersLdapUpdate(@Path("id") id: kotlin.Int, @Body ldAPProviderRequest: LDAPProviderRequest): Response<LDAPProvider>

    /**
     * GET providers/ldap/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this LDAP Provider.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("providers/ldap/{id}/used_by/")
    suspend fun providersLdapUsedByList(@Path("id") id: kotlin.Int): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST providers/microsoft_entra/
     *
     * MicrosoftEntraProvider Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param microsoftEntraProviderRequest
     * @return [MicrosoftEntraProvider]
     */
    @POST("providers/microsoft_entra/")
    suspend fun providersMicrosoftEntraCreate(@Body microsoftEntraProviderRequest: MicrosoftEntraProviderRequest): Response<MicrosoftEntraProvider>

    /**
     * DELETE providers/microsoft_entra/{id}/
     *
     * MicrosoftEntraProvider Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Microsoft Entra Provider.
     * @return [Unit]
     */
    @DELETE("providers/microsoft_entra/{id}/")
    suspend fun providersMicrosoftEntraDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * POST providers/microsoft_entra_groups/
     *
     * MicrosoftEntraProviderGroup Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param microsoftEntraProviderGroupRequest
     * @return [MicrosoftEntraProviderGroup]
     */
    @POST("providers/microsoft_entra_groups/")
    suspend fun providersMicrosoftEntraGroupsCreate(@Body microsoftEntraProviderGroupRequest: MicrosoftEntraProviderGroupRequest): Response<MicrosoftEntraProviderGroup>

    /**
     * DELETE providers/microsoft_entra_groups/{id}/
     *
     * MicrosoftEntraProviderGroup Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A UUID string identifying this Microsoft Entra Provider Group.
     * @return [Unit]
     */
    @DELETE("providers/microsoft_entra_groups/{id}/")
    suspend fun providersMicrosoftEntraGroupsDestroy(@Path("id") id: java.util.UUID): Response<Unit>

    /**
     * GET providers/microsoft_entra_groups/
     *
     * MicrosoftEntraProviderGroup Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param groupGroupUuid  (optional)
     * @param groupName  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param providerId  (optional)
     * @param search A search term. (optional)
     * @return [PaginatedMicrosoftEntraProviderGroupList]
     */
    @GET("providers/microsoft_entra_groups/")
    suspend fun providersMicrosoftEntraGroupsList(@Query("group__group_uuid") groupGroupUuid: java.util.UUID? = null, @Query("group__name") groupName: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("provider__id") providerId: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedMicrosoftEntraProviderGroupList>

    /**
     * GET providers/microsoft_entra_groups/{id}/
     *
     * MicrosoftEntraProviderGroup Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A UUID string identifying this Microsoft Entra Provider Group.
     * @return [MicrosoftEntraProviderGroup]
     */
    @GET("providers/microsoft_entra_groups/{id}/")
    suspend fun providersMicrosoftEntraGroupsRetrieve(@Path("id") id: java.util.UUID): Response<MicrosoftEntraProviderGroup>

    /**
     * GET providers/microsoft_entra_groups/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A UUID string identifying this Microsoft Entra Provider Group.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("providers/microsoft_entra_groups/{id}/used_by/")
    suspend fun providersMicrosoftEntraGroupsUsedByList(@Path("id") id: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * GET providers/microsoft_entra/
     *
     * MicrosoftEntraProvider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param excludeUsersServiceAccount  (optional)
     * @param filterGroup  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedMicrosoftEntraProviderList]
     */
    @GET("providers/microsoft_entra/")
    suspend fun providersMicrosoftEntraList(@Query("exclude_users_service_account") excludeUsersServiceAccount: kotlin.Boolean? = null, @Query("filter_group") filterGroup: java.util.UUID? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedMicrosoftEntraProviderList>

    /**
     * PATCH providers/microsoft_entra/{id}/
     *
     * MicrosoftEntraProvider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Microsoft Entra Provider.
     * @param patchedMicrosoftEntraProviderRequest  (optional)
     * @return [MicrosoftEntraProvider]
     */
    @PATCH("providers/microsoft_entra/{id}/")
    suspend fun providersMicrosoftEntraPartialUpdate(@Path("id") id: kotlin.Int, @Body patchedMicrosoftEntraProviderRequest: PatchedMicrosoftEntraProviderRequest? = null): Response<MicrosoftEntraProvider>

    /**
     * GET providers/microsoft_entra/{id}/
     *
     * MicrosoftEntraProvider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Microsoft Entra Provider.
     * @return [MicrosoftEntraProvider]
     */
    @GET("providers/microsoft_entra/{id}/")
    suspend fun providersMicrosoftEntraRetrieve(@Path("id") id: kotlin.Int): Response<MicrosoftEntraProvider>

    /**
     * POST providers/microsoft_entra/{id}/sync/object/
     *
     * Sync/Re-sync a single user/group object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Microsoft Entra Provider.
     * @param syncObjectRequest
     * @return [SyncObjectResult]
     */
    @POST("providers/microsoft_entra/{id}/sync/object/")
    suspend fun providersMicrosoftEntraSyncObjectCreate(@Path("id") id: kotlin.Int, @Body syncObjectRequest: SyncObjectRequest): Response<SyncObjectResult>

    /**
     * GET providers/microsoft_entra/{id}/sync/status/
     *
     * Get provider&#39;s sync status
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Microsoft Entra Provider.
     * @return [SyncStatus]
     */
    @GET("providers/microsoft_entra/{id}/sync/status/")
    suspend fun providersMicrosoftEntraSyncStatusRetrieve(@Path("id") id: kotlin.Int): Response<SyncStatus>

    /**
     * PUT providers/microsoft_entra/{id}/
     *
     * MicrosoftEntraProvider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Microsoft Entra Provider.
     * @param microsoftEntraProviderRequest
     * @return [MicrosoftEntraProvider]
     */
    @PUT("providers/microsoft_entra/{id}/")
    suspend fun providersMicrosoftEntraUpdate(@Path("id") id: kotlin.Int, @Body microsoftEntraProviderRequest: MicrosoftEntraProviderRequest): Response<MicrosoftEntraProvider>

    /**
     * GET providers/microsoft_entra/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Microsoft Entra Provider.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("providers/microsoft_entra/{id}/used_by/")
    suspend fun providersMicrosoftEntraUsedByList(@Path("id") id: kotlin.Int): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST providers/microsoft_entra_users/
     *
     * MicrosoftEntraProviderUser Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param microsoftEntraProviderUserRequest
     * @return [MicrosoftEntraProviderUser]
     */
    @POST("providers/microsoft_entra_users/")
    suspend fun providersMicrosoftEntraUsersCreate(@Body microsoftEntraProviderUserRequest: MicrosoftEntraProviderUserRequest): Response<MicrosoftEntraProviderUser>

    /**
     * DELETE providers/microsoft_entra_users/{id}/
     *
     * MicrosoftEntraProviderUser Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A UUID string identifying this Microsoft Entra Provider User.
     * @return [Unit]
     */
    @DELETE("providers/microsoft_entra_users/{id}/")
    suspend fun providersMicrosoftEntraUsersDestroy(@Path("id") id: java.util.UUID): Response<Unit>

    /**
     * GET providers/microsoft_entra_users/
     *
     * MicrosoftEntraProviderUser Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param providerId  (optional)
     * @param search A search term. (optional)
     * @param userId  (optional)
     * @param userUsername  (optional)
     * @return [PaginatedMicrosoftEntraProviderUserList]
     */
    @GET("providers/microsoft_entra_users/")
    suspend fun providersMicrosoftEntraUsersList(@Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("provider__id") providerId: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("user__id") userId: kotlin.Int? = null, @Query("user__username") userUsername: kotlin.String? = null): Response<PaginatedMicrosoftEntraProviderUserList>

    /**
     * GET providers/microsoft_entra_users/{id}/
     *
     * MicrosoftEntraProviderUser Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A UUID string identifying this Microsoft Entra Provider User.
     * @return [MicrosoftEntraProviderUser]
     */
    @GET("providers/microsoft_entra_users/{id}/")
    suspend fun providersMicrosoftEntraUsersRetrieve(@Path("id") id: java.util.UUID): Response<MicrosoftEntraProviderUser>

    /**
     * GET providers/microsoft_entra_users/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A UUID string identifying this Microsoft Entra Provider User.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("providers/microsoft_entra_users/{id}/used_by/")
    suspend fun providersMicrosoftEntraUsersUsedByList(@Path("id") id: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST providers/oauth2/
     *
     * OAuth2Provider Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param oauth2ProviderRequest
     * @return [OAuth2Provider]
     */
    @POST("providers/oauth2/")
    suspend fun providersOauth2Create(@Body oauth2ProviderRequest: OAuth2ProviderRequest): Response<OAuth2Provider>

    /**
     * POST providers/oauth2-dcr/
     *
     * OAuth2 Dynamic Client Registration configuration ViewSet
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param oauth2DynamicClientRegistrationRequest
     * @return [OAuth2DynamicClientRegistration]
     */
    @POST("providers/oauth2-dcr/")
    suspend fun providersOauth2DcrCreate(@Body oauth2DynamicClientRegistrationRequest: OAuth2DynamicClientRegistrationRequest): Response<OAuth2DynamicClientRegistration>

    /**
     * DELETE providers/oauth2-dcr/{pbm_uuid}/
     *
     * OAuth2 Dynamic Client Registration configuration ViewSet
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param pbmUuid A UUID string identifying this OAuth2 Dynamic Client Registration.
     * @return [Unit]
     */
    @DELETE("providers/oauth2-dcr/{pbm_uuid}/")
    suspend fun providersOauth2DcrDestroy(@Path("pbm_uuid") pbmUuid: java.util.UUID): Response<Unit>

    /**
     * GET providers/oauth2-dcr/
     *
     * OAuth2 Dynamic Client Registration configuration ViewSet
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
     * @return [PaginatedOAuth2DynamicClientRegistrationList]
     */
    @GET("providers/oauth2-dcr/")
    suspend fun providersOauth2DcrList(@Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("provider") provider: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedOAuth2DynamicClientRegistrationList>

    /**
     * PATCH providers/oauth2-dcr/{pbm_uuid}/
     *
     * OAuth2 Dynamic Client Registration configuration ViewSet
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pbmUuid A UUID string identifying this OAuth2 Dynamic Client Registration.
     * @param patchedOAuth2DynamicClientRegistrationRequest  (optional)
     * @return [OAuth2DynamicClientRegistration]
     */
    @PATCH("providers/oauth2-dcr/{pbm_uuid}/")
    suspend fun providersOauth2DcrPartialUpdate(@Path("pbm_uuid") pbmUuid: java.util.UUID, @Body patchedOAuth2DynamicClientRegistrationRequest: PatchedOAuth2DynamicClientRegistrationRequest? = null): Response<OAuth2DynamicClientRegistration>

    /**
     * GET providers/oauth2-dcr/{pbm_uuid}/
     *
     * OAuth2 Dynamic Client Registration configuration ViewSet
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pbmUuid A UUID string identifying this OAuth2 Dynamic Client Registration.
     * @return [OAuth2DynamicClientRegistration]
     */
    @GET("providers/oauth2-dcr/{pbm_uuid}/")
    suspend fun providersOauth2DcrRetrieve(@Path("pbm_uuid") pbmUuid: java.util.UUID): Response<OAuth2DynamicClientRegistration>

    /**
     * PUT providers/oauth2-dcr/{pbm_uuid}/
     *
     * OAuth2 Dynamic Client Registration configuration ViewSet
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pbmUuid A UUID string identifying this OAuth2 Dynamic Client Registration.
     * @param oauth2DynamicClientRegistrationRequest
     * @return [OAuth2DynamicClientRegistration]
     */
    @PUT("providers/oauth2-dcr/{pbm_uuid}/")
    suspend fun providersOauth2DcrUpdate(@Path("pbm_uuid") pbmUuid: java.util.UUID, @Body oauth2DynamicClientRegistrationRequest: OAuth2DynamicClientRegistrationRequest): Response<OAuth2DynamicClientRegistration>

    /**
     * DELETE providers/oauth2/{id}/
     *
     * OAuth2Provider Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this OAuth2/OpenID Provider.
     * @return [Unit]
     */
    @DELETE("providers/oauth2/{id}/")
    suspend fun providersOauth2Destroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET providers/oauth2/
     *
     * OAuth2Provider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param accessCodeValidity  (optional)
     * @param accessTokenValidity  (optional)
     * @param application  (optional)
     * @param authorizationFlow  (optional)
     * @param clientId  (optional)
     * @param clientType  (optional)
     * @param includeClaimsInIdToken  (optional)
     * @param issuerMode  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param propertyMappings  (optional)
     * @param refreshTokenValidity  (optional)
     * @param search A search term. (optional)
     * @param signingKey  (optional)
     * @param subMode  (optional)
     * @return [PaginatedOAuth2ProviderList]
     */
    @GET("providers/oauth2/")
    suspend fun providersOauth2List(@Query("access_code_validity") accessCodeValidity: kotlin.String? = null, @Query("access_token_validity") accessTokenValidity: kotlin.String? = null, @Query("application") application: java.util.UUID? = null, @Query("authorization_flow") authorizationFlow: java.util.UUID? = null, @Query("client_id") clientId: kotlin.String? = null, @Query("client_type") clientType: ClientTypeEnum? = null, @Query("include_claims_in_id_token") includeClaimsInIdToken: kotlin.Boolean? = null, @Query("issuer_mode") issuerMode: IssuerModeEnum? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("property_mappings") propertyMappings: @JvmSuppressWildcards kotlin.collections.List<java.util.UUID>? = null, @Query("refresh_token_validity") refreshTokenValidity: kotlin.String? = null, @Query("search") search: kotlin.String? = null, @Query("signing_key") signingKey: java.util.UUID? = null, @Query("sub_mode") subMode: SubModeEnum? = null): Response<PaginatedOAuth2ProviderList>

    /**
     * PATCH providers/oauth2/{id}/
     *
     * OAuth2Provider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this OAuth2/OpenID Provider.
     * @param patchedOAuth2ProviderRequest  (optional)
     * @return [OAuth2Provider]
     */
    @PATCH("providers/oauth2/{id}/")
    suspend fun providersOauth2PartialUpdate(@Path("id") id: kotlin.Int, @Body patchedOAuth2ProviderRequest: PatchedOAuth2ProviderRequest? = null): Response<OAuth2Provider>

    /**
     * GET providers/oauth2/{id}/preview_user/
     *
     * Preview user data for provider
     * Responses:
     *  - 200:
     *  - 400: Bad request
     *  - 403:
     *
     * @param id A unique integer value identifying this OAuth2/OpenID Provider.
     * @param forUser  (optional)
     * @return [PropertyMappingPreview]
     */
    @GET("providers/oauth2/{id}/preview_user/")
    suspend fun providersOauth2PreviewUserRetrieve(@Path("id") id: kotlin.Int, @Query("for_user") forUser: kotlin.Int? = null): Response<PropertyMappingPreview>

    /**
     * GET providers/oauth2/{id}/
     *
     * OAuth2Provider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this OAuth2/OpenID Provider.
     * @return [OAuth2Provider]
     */
    @GET("providers/oauth2/{id}/")
    suspend fun providersOauth2Retrieve(@Path("id") id: kotlin.Int): Response<OAuth2Provider>

    /**
     * GET providers/oauth2/{id}/setup_urls/
     *
     * Get Providers setup URLs
     * Responses:
     *  - 200:
     *  - 404: Provider has no application assigned
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this OAuth2/OpenID Provider.
     * @return [OAuth2ProviderSetupURLs]
     */
    @GET("providers/oauth2/{id}/setup_urls/")
    suspend fun providersOauth2SetupUrlsRetrieve(@Path("id") id: kotlin.Int): Response<OAuth2ProviderSetupURLs>

    /**
     * PUT providers/oauth2/{id}/
     *
     * OAuth2Provider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this OAuth2/OpenID Provider.
     * @param oauth2ProviderRequest
     * @return [OAuth2Provider]
     */
    @PUT("providers/oauth2/{id}/")
    suspend fun providersOauth2Update(@Path("id") id: kotlin.Int, @Body oauth2ProviderRequest: OAuth2ProviderRequest): Response<OAuth2Provider>

    /**
     * GET providers/oauth2/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this OAuth2/OpenID Provider.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("providers/oauth2/{id}/used_by/")
    suspend fun providersOauth2UsedByList(@Path("id") id: kotlin.Int): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST providers/proxy/
     *
     * ProxyProvider Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param proxyProviderRequest
     * @return [ProxyProvider]
     */
    @POST("providers/proxy/")
    suspend fun providersProxyCreate(@Body proxyProviderRequest: ProxyProviderRequest): Response<ProxyProvider>

    /**
     * DELETE providers/proxy/{id}/
     *
     * ProxyProvider Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Proxy Provider.
     * @return [Unit]
     */
    @DELETE("providers/proxy/{id}/")
    suspend fun providersProxyDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET providers/proxy/
     *
     * ProxyProvider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param applicationIsnull  (optional)
     * @param authorizationFlowSlugIexact  (optional)
     * @param basicAuthEnabledIexact  (optional)
     * @param basicAuthPasswordAttributeIexact  (optional)
     * @param basicAuthUserAttributeIexact  (optional)
     * @param certificateKpUuidIexact  (optional)
     * @param certificateNameIexact  (optional)
     * @param cookieDomainIexact  (optional)
     * @param externalHostIexact  (optional)
     * @param internalHostIexact  (optional)
     * @param internalHostSslValidationIexact  (optional)
     * @param modeIexact  (optional)
     * @param nameIexact  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param propertyMappingsIexact  (optional)
     * @param search A search term. (optional)
     * @param skipPathRegexIexact  (optional)
     * @return [PaginatedProxyProviderList]
     */
    @GET("providers/proxy/")
    suspend fun providersProxyList(@Query("application__isnull") applicationIsnull: kotlin.Boolean? = null, @Query("authorization_flow__slug__iexact") authorizationFlowSlugIexact: kotlin.String? = null, @Query("basic_auth_enabled__iexact") basicAuthEnabledIexact: kotlin.Boolean? = null, @Query("basic_auth_password_attribute__iexact") basicAuthPasswordAttributeIexact: kotlin.String? = null, @Query("basic_auth_user_attribute__iexact") basicAuthUserAttributeIexact: kotlin.String? = null, @Query("certificate__kp_uuid__iexact") certificateKpUuidIexact: java.util.UUID? = null, @Query("certificate__name__iexact") certificateNameIexact: kotlin.String? = null, @Query("cookie_domain__iexact") cookieDomainIexact: kotlin.String? = null, @Query("external_host__iexact") externalHostIexact: kotlin.String? = null, @Query("internal_host__iexact") internalHostIexact: kotlin.String? = null, @Query("internal_host_ssl_validation__iexact") internalHostSslValidationIexact: kotlin.Boolean? = null, @Query("mode__iexact") modeIexact: kotlin.String? = null, @Query("name__iexact") nameIexact: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("property_mappings__iexact") propertyMappingsIexact: @JvmSuppressWildcards kotlin.collections.List<java.util.UUID>? = null, @Query("search") search: kotlin.String? = null, @Query("skip_path_regex__iexact") skipPathRegexIexact: kotlin.String? = null): Response<PaginatedProxyProviderList>

    /**
     * PATCH providers/proxy/{id}/
     *
     * ProxyProvider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Proxy Provider.
     * @param patchedProxyProviderRequest  (optional)
     * @return [ProxyProvider]
     */
    @PATCH("providers/proxy/{id}/")
    suspend fun providersProxyPartialUpdate(@Path("id") id: kotlin.Int, @Body patchedProxyProviderRequest: PatchedProxyProviderRequest? = null): Response<ProxyProvider>

    /**
     * GET providers/proxy/{id}/
     *
     * ProxyProvider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Proxy Provider.
     * @return [ProxyProvider]
     */
    @GET("providers/proxy/{id}/")
    suspend fun providersProxyRetrieve(@Path("id") id: kotlin.Int): Response<ProxyProvider>

    /**
     * PUT providers/proxy/{id}/
     *
     * ProxyProvider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Proxy Provider.
     * @param proxyProviderRequest
     * @return [ProxyProvider]
     */
    @PUT("providers/proxy/{id}/")
    suspend fun providersProxyUpdate(@Path("id") id: kotlin.Int, @Body proxyProviderRequest: ProxyProviderRequest): Response<ProxyProvider>

    /**
     * GET providers/proxy/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Proxy Provider.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("providers/proxy/{id}/used_by/")
    suspend fun providersProxyUsedByList(@Path("id") id: kotlin.Int): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST providers/rac/
     *
     * RACProvider Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param raCProviderRequest
     * @return [RACProvider]
     */
    @POST("providers/rac/")
    suspend fun providersRacCreate(@Body raCProviderRequest: RACProviderRequest): Response<RACProvider>

    /**
     * DELETE providers/rac/{id}/
     *
     * RACProvider Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this RAC Provider.
     * @return [Unit]
     */
    @DELETE("providers/rac/{id}/")
    suspend fun providersRacDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET providers/rac/
     *
     * RACProvider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param applicationIsnull  (optional)
     * @param nameIexact  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedRACProviderList]
     */
    @GET("providers/rac/")
    suspend fun providersRacList(@Query("application__isnull") applicationIsnull: kotlin.Boolean? = null, @Query("name__iexact") nameIexact: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedRACProviderList>

    /**
     * PATCH providers/rac/{id}/
     *
     * RACProvider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this RAC Provider.
     * @param patchedRACProviderRequest  (optional)
     * @return [RACProvider]
     */
    @PATCH("providers/rac/{id}/")
    suspend fun providersRacPartialUpdate(@Path("id") id: kotlin.Int, @Body patchedRACProviderRequest: PatchedRACProviderRequest? = null): Response<RACProvider>

    /**
     * GET providers/rac/{id}/
     *
     * RACProvider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this RAC Provider.
     * @return [RACProvider]
     */
    @GET("providers/rac/{id}/")
    suspend fun providersRacRetrieve(@Path("id") id: kotlin.Int): Response<RACProvider>

    /**
     * PUT providers/rac/{id}/
     *
     * RACProvider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this RAC Provider.
     * @param raCProviderRequest
     * @return [RACProvider]
     */
    @PUT("providers/rac/{id}/")
    suspend fun providersRacUpdate(@Path("id") id: kotlin.Int, @Body raCProviderRequest: RACProviderRequest): Response<RACProvider>

    /**
     * GET providers/rac/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this RAC Provider.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("providers/rac/{id}/used_by/")
    suspend fun providersRacUsedByList(@Path("id") id: kotlin.Int): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST providers/radius/
     *
     * RadiusProvider Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param radiusProviderRequest
     * @return [RadiusProvider]
     */
    @POST("providers/radius/")
    suspend fun providersRadiusCreate(@Body radiusProviderRequest: RadiusProviderRequest): Response<RadiusProvider>

    /**
     * DELETE providers/radius/{id}/
     *
     * RadiusProvider Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Radius Provider.
     * @return [Unit]
     */
    @DELETE("providers/radius/{id}/")
    suspend fun providersRadiusDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET providers/radius/
     *
     * RadiusProvider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param applicationIsnull  (optional)
     * @param authorizationFlowSlugIexact  (optional)
     * @param clientNetworksIexact  (optional)
     * @param nameIexact  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedRadiusProviderList]
     */
    @GET("providers/radius/")
    suspend fun providersRadiusList(@Query("application__isnull") applicationIsnull: kotlin.Boolean? = null, @Query("authorization_flow__slug__iexact") authorizationFlowSlugIexact: kotlin.String? = null, @Query("client_networks__iexact") clientNetworksIexact: kotlin.String? = null, @Query("name__iexact") nameIexact: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedRadiusProviderList>

    /**
     * PATCH providers/radius/{id}/
     *
     * RadiusProvider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Radius Provider.
     * @param patchedRadiusProviderRequest  (optional)
     * @return [RadiusProvider]
     */
    @PATCH("providers/radius/{id}/")
    suspend fun providersRadiusPartialUpdate(@Path("id") id: kotlin.Int, @Body patchedRadiusProviderRequest: PatchedRadiusProviderRequest? = null): Response<RadiusProvider>

    /**
     * GET providers/radius/{id}/
     *
     * RadiusProvider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Radius Provider.
     * @return [RadiusProvider]
     */
    @GET("providers/radius/{id}/")
    suspend fun providersRadiusRetrieve(@Path("id") id: kotlin.Int): Response<RadiusProvider>

    /**
     * PUT providers/radius/{id}/
     *
     * RadiusProvider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Radius Provider.
     * @param radiusProviderRequest
     * @return [RadiusProvider]
     */
    @PUT("providers/radius/{id}/")
    suspend fun providersRadiusUpdate(@Path("id") id: kotlin.Int, @Body radiusProviderRequest: RadiusProviderRequest): Response<RadiusProvider>

    /**
     * GET providers/radius/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Radius Provider.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("providers/radius/{id}/used_by/")
    suspend fun providersRadiusUsedByList(@Path("id") id: kotlin.Int): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST providers/saml/
     *
     * SAMLProvider Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param saMLProviderRequest
     * @return [SAMLProvider]
     */
    @POST("providers/saml/")
    suspend fun providersSamlCreate(@Body saMLProviderRequest: SAMLProviderRequest): Response<SAMLProvider>

    /**
     * DELETE providers/saml/{id}/
     *
     * SAMLProvider Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this SAML Provider.
     * @return [Unit]
     */
    @DELETE("providers/saml/{id}/")
    suspend fun providersSamlDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * POST providers/saml/import_metadata/
     *
     * Create provider from SAML Metadata
     * Responses:
     *  - 201:
     *  - 400: Bad request
     *  - 403:
     *
     * @param name
     * @param authorizationFlow
     * @param invalidationFlow
     * @param file
     * @return [SAMLProvider]
     */
    @Multipart
    @POST("providers/saml/import_metadata/")
    suspend fun providersSamlImportMetadataCreate(@Part("name") name: kotlin.String, @Part("authorization_flow") authorizationFlow: java.util.UUID, @Part("invalidation_flow") invalidationFlow: java.util.UUID, @Part file: MultipartBody.Part): Response<SAMLProvider>

    /**
     * GET providers/saml/
     *
     * SAMLProvider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param acsUrl  (optional)
     * @param assertionValidNotBefore  (optional)
     * @param assertionValidNotOnOrAfter  (optional)
     * @param audience  (optional)
     * @param authenticationFlow  (optional)
     * @param authnContextClassRefMapping  (optional)
     * @param authorizationFlow  (optional)
     * @param backchannelApplication  (optional)
     * @param defaultNameIdPolicy  (optional)
     * @param defaultRelayState  (optional)
     * @param digestAlgorithm  (optional)
     * @param encryptionKp  (optional)
     * @param invalidationFlow  (optional)
     * @param isBackchannel  (optional)
     * @param issuerOverride  (optional)
     * @param logoutMethod  (optional)
     * @param name  (optional)
     * @param nameIdMapping  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param propertyMappings  (optional)
     * @param search A search term. (optional)
     * @param sessionValidNotOnOrAfter  (optional)
     * @param signAssertion  (optional)
     * @param signLogoutRequest  (optional)
     * @param signLogoutResponse  (optional)
     * @param signResponse  (optional)
     * @param signatureAlgorithm  (optional)
     * @param signingKp  (optional)
     * @param slsBinding  (optional)
     * @param slsUrl  (optional)
     * @param spBinding  (optional)
     * @param verificationKp  (optional)
     * @return [PaginatedSAMLProviderList]
     */
    @GET("providers/saml/")
    suspend fun providersSamlList(@Query("acs_url") acsUrl: kotlin.String? = null, @Query("assertion_valid_not_before") assertionValidNotBefore: kotlin.String? = null, @Query("assertion_valid_not_on_or_after") assertionValidNotOnOrAfter: kotlin.String? = null, @Query("audience") audience: kotlin.String? = null, @Query("authentication_flow") authenticationFlow: java.util.UUID? = null, @Query("authn_context_class_ref_mapping") authnContextClassRefMapping: java.util.UUID? = null, @Query("authorization_flow") authorizationFlow: java.util.UUID? = null, @Query("backchannel_application") backchannelApplication: java.util.UUID? = null, @Query("default_name_id_policy") defaultNameIdPolicy: SAMLNameIDPolicyEnum? = null, @Query("default_relay_state") defaultRelayState: kotlin.String? = null, @Query("digest_algorithm") digestAlgorithm: DigestAlgorithmEnum? = null, @Query("encryption_kp") encryptionKp: java.util.UUID? = null, @Query("invalidation_flow") invalidationFlow: java.util.UUID? = null, @Query("is_backchannel") isBackchannel: kotlin.Boolean? = null, @Query("issuer_override") issuerOverride: kotlin.String? = null, @Query("logout_method") logoutMethod: SAMLLogoutMethods? = null, @Query("name") name: kotlin.String? = null, @Query("name_id_mapping") nameIdMapping: java.util.UUID? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("property_mappings") propertyMappings: @JvmSuppressWildcards kotlin.collections.List<java.util.UUID>? = null, @Query("search") search: kotlin.String? = null, @Query("session_valid_not_on_or_after") sessionValidNotOnOrAfter: kotlin.String? = null, @Query("sign_assertion") signAssertion: kotlin.Boolean? = null, @Query("sign_logout_request") signLogoutRequest: kotlin.Boolean? = null, @Query("sign_logout_response") signLogoutResponse: kotlin.Boolean? = null, @Query("sign_response") signResponse: kotlin.Boolean? = null, @Query("signature_algorithm") signatureAlgorithm: SignatureAlgorithmEnum? = null, @Query("signing_kp") signingKp: java.util.UUID? = null, @Query("sls_binding") slsBinding: SAMLBindingsEnum? = null, @Query("sls_url") slsUrl: kotlin.String? = null, @Query("sp_binding") spBinding: SAMLBindingsEnum? = null, @Query("verification_kp") verificationKp: java.util.UUID? = null): Response<PaginatedSAMLProviderList>

    /**
     * GET providers/saml/{id}/metadata/
     *
     * Return metadata as XML string
     * Responses:
     *  - 200:
     *  - 404: Provider has no application assigned
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this SAML Provider.
     * @param download  (optional)
     * @param forceBinding  (optional)
     * @return [SAMLMetadata]
     */
    @GET("providers/saml/{id}/metadata/")
    suspend fun providersSamlMetadataRetrieve(@Path("id") id: kotlin.Int, @Query("download") download: kotlin.Boolean? = null, @Query("force_binding") forceBinding: ForceBindingEnum? = null): Response<SAMLMetadata>

    /**
     * PATCH providers/saml/{id}/
     *
     * SAMLProvider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this SAML Provider.
     * @param patchedSAMLProviderRequest  (optional)
     * @return [SAMLProvider]
     */
    @PATCH("providers/saml/{id}/")
    suspend fun providersSamlPartialUpdate(@Path("id") id: kotlin.Int, @Body patchedSAMLProviderRequest: PatchedSAMLProviderRequest? = null): Response<SAMLProvider>

    /**
     * GET providers/saml/{id}/preview_user/
     *
     * Preview user data for provider
     * Responses:
     *  - 200:
     *  - 400: Bad request
     *  - 403:
     *
     * @param id A unique integer value identifying this SAML Provider.
     * @param forUser  (optional)
     * @return [PropertyMappingPreview]
     */
    @GET("providers/saml/{id}/preview_user/")
    suspend fun providersSamlPreviewUserRetrieve(@Path("id") id: kotlin.Int, @Query("for_user") forUser: kotlin.Int? = null): Response<PropertyMappingPreview>

    /**
     * GET providers/saml/{id}/
     *
     * SAMLProvider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this SAML Provider.
     * @return [SAMLProvider]
     */
    @GET("providers/saml/{id}/")
    suspend fun providersSamlRetrieve(@Path("id") id: kotlin.Int): Response<SAMLProvider>

    /**
     * PUT providers/saml/{id}/
     *
     * SAMLProvider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this SAML Provider.
     * @param saMLProviderRequest
     * @return [SAMLProvider]
     */
    @PUT("providers/saml/{id}/")
    suspend fun providersSamlUpdate(@Path("id") id: kotlin.Int, @Body saMLProviderRequest: SAMLProviderRequest): Response<SAMLProvider>

    /**
     * GET providers/saml/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this SAML Provider.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("providers/saml/{id}/used_by/")
    suspend fun providersSamlUsedByList(@Path("id") id: kotlin.Int): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST providers/scim/
     *
     * SCIMProvider Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param scIMProviderRequest
     * @return [SCIMProvider]
     */
    @POST("providers/scim/")
    suspend fun providersScimCreate(@Body scIMProviderRequest: SCIMProviderRequest): Response<SCIMProvider>

    /**
     * DELETE providers/scim/{id}/
     *
     * SCIMProvider Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this SCIM Provider.
     * @return [Unit]
     */
    @DELETE("providers/scim/{id}/")
    suspend fun providersScimDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * POST providers/scim_groups/
     *
     * SCIMProviderGroup Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param scIMProviderGroupRequest
     * @return [SCIMProviderGroup]
     */
    @POST("providers/scim_groups/")
    suspend fun providersScimGroupsCreate(@Body scIMProviderGroupRequest: SCIMProviderGroupRequest): Response<SCIMProviderGroup>

    /**
     * DELETE providers/scim_groups/{id}/
     *
     * SCIMProviderGroup Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A UUID string identifying this scim provider group.
     * @return [Unit]
     */
    @DELETE("providers/scim_groups/{id}/")
    suspend fun providersScimGroupsDestroy(@Path("id") id: java.util.UUID): Response<Unit>

    /**
     * GET providers/scim_groups/
     *
     * SCIMProviderGroup Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param groupGroupUuid  (optional)
     * @param groupName  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param providerId  (optional)
     * @param search A search term. (optional)
     * @return [PaginatedSCIMProviderGroupList]
     */
    @GET("providers/scim_groups/")
    suspend fun providersScimGroupsList(@Query("group__group_uuid") groupGroupUuid: java.util.UUID? = null, @Query("group__name") groupName: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("provider__id") providerId: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedSCIMProviderGroupList>

    /**
     * GET providers/scim_groups/{id}/
     *
     * SCIMProviderGroup Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A UUID string identifying this scim provider group.
     * @return [SCIMProviderGroup]
     */
    @GET("providers/scim_groups/{id}/")
    suspend fun providersScimGroupsRetrieve(@Path("id") id: java.util.UUID): Response<SCIMProviderGroup>

    /**
     * GET providers/scim_groups/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A UUID string identifying this scim provider group.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("providers/scim_groups/{id}/used_by/")
    suspend fun providersScimGroupsUsedByList(@Path("id") id: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * GET providers/scim/
     *
     * SCIMProvider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param excludeUsersServiceAccount  (optional)
     * @param groupFilters  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param url  (optional)
     * @return [PaginatedSCIMProviderList]
     */
    @GET("providers/scim/")
    suspend fun providersScimList(@Query("exclude_users_service_account") excludeUsersServiceAccount: kotlin.Boolean? = null, @Query("group_filters") groupFilters: @JvmSuppressWildcards kotlin.collections.List<java.util.UUID>? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("url") url: kotlin.String? = null): Response<PaginatedSCIMProviderList>

    /**
     * PATCH providers/scim/{id}/
     *
     * SCIMProvider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this SCIM Provider.
     * @param patchedSCIMProviderRequest  (optional)
     * @return [SCIMProvider]
     */
    @PATCH("providers/scim/{id}/")
    suspend fun providersScimPartialUpdate(@Path("id") id: kotlin.Int, @Body patchedSCIMProviderRequest: PatchedSCIMProviderRequest? = null): Response<SCIMProvider>

    /**
     * GET providers/scim/{id}/
     *
     * SCIMProvider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this SCIM Provider.
     * @return [SCIMProvider]
     */
    @GET("providers/scim/{id}/")
    suspend fun providersScimRetrieve(@Path("id") id: kotlin.Int): Response<SCIMProvider>

    /**
     * POST providers/scim/{id}/sync/object/
     *
     * Sync/Re-sync a single user/group object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this SCIM Provider.
     * @param syncObjectRequest
     * @return [SyncObjectResult]
     */
    @POST("providers/scim/{id}/sync/object/")
    suspend fun providersScimSyncObjectCreate(@Path("id") id: kotlin.Int, @Body syncObjectRequest: SyncObjectRequest): Response<SyncObjectResult>

    /**
     * GET providers/scim/{id}/sync/status/
     *
     * Get provider&#39;s sync status
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this SCIM Provider.
     * @return [SyncStatus]
     */
    @GET("providers/scim/{id}/sync/status/")
    suspend fun providersScimSyncStatusRetrieve(@Path("id") id: kotlin.Int): Response<SyncStatus>

    /**
     * PUT providers/scim/{id}/
     *
     * SCIMProvider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this SCIM Provider.
     * @param scIMProviderRequest
     * @return [SCIMProvider]
     */
    @PUT("providers/scim/{id}/")
    suspend fun providersScimUpdate(@Path("id") id: kotlin.Int, @Body scIMProviderRequest: SCIMProviderRequest): Response<SCIMProvider>

    /**
     * GET providers/scim/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this SCIM Provider.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("providers/scim/{id}/used_by/")
    suspend fun providersScimUsedByList(@Path("id") id: kotlin.Int): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST providers/scim_users/
     *
     * SCIMProviderUser Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param scIMProviderUserRequest
     * @return [SCIMProviderUser]
     */
    @POST("providers/scim_users/")
    suspend fun providersScimUsersCreate(@Body scIMProviderUserRequest: SCIMProviderUserRequest): Response<SCIMProviderUser>

    /**
     * DELETE providers/scim_users/{id}/
     *
     * SCIMProviderUser Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A UUID string identifying this scim provider user.
     * @return [Unit]
     */
    @DELETE("providers/scim_users/{id}/")
    suspend fun providersScimUsersDestroy(@Path("id") id: java.util.UUID): Response<Unit>

    /**
     * GET providers/scim_users/
     *
     * SCIMProviderUser Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param providerId  (optional)
     * @param search A search term. (optional)
     * @param userId  (optional)
     * @param userUsername  (optional)
     * @return [PaginatedSCIMProviderUserList]
     */
    @GET("providers/scim_users/")
    suspend fun providersScimUsersList(@Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("provider__id") providerId: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("user__id") userId: kotlin.Int? = null, @Query("user__username") userUsername: kotlin.String? = null): Response<PaginatedSCIMProviderUserList>

    /**
     * GET providers/scim_users/{id}/
     *
     * SCIMProviderUser Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A UUID string identifying this scim provider user.
     * @return [SCIMProviderUser]
     */
    @GET("providers/scim_users/{id}/")
    suspend fun providersScimUsersRetrieve(@Path("id") id: java.util.UUID): Response<SCIMProviderUser>

    /**
     * GET providers/scim_users/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A UUID string identifying this scim provider user.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("providers/scim_users/{id}/used_by/")
    suspend fun providersScimUsersUsedByList(@Path("id") id: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST providers/ssf/
     *
     * SSFProvider Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param ssFProviderRequest
     * @return [SSFProvider]
     */
    @POST("providers/ssf/")
    suspend fun providersSsfCreate(@Body ssFProviderRequest: SSFProviderRequest): Response<SSFProvider>

    /**
     * DELETE providers/ssf/{id}/
     *
     * SSFProvider Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Shared Signals Framework Provider.
     * @return [Unit]
     */
    @DELETE("providers/ssf/{id}/")
    suspend fun providersSsfDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET providers/ssf/
     *
     * SSFProvider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param applicationIsnull  (optional)
     * @param nameIexact  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedSSFProviderList]
     */
    @GET("providers/ssf/")
    suspend fun providersSsfList(@Query("application__isnull") applicationIsnull: kotlin.Boolean? = null, @Query("name__iexact") nameIexact: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedSSFProviderList>

    /**
     * PATCH providers/ssf/{id}/
     *
     * SSFProvider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Shared Signals Framework Provider.
     * @param patchedSSFProviderRequest  (optional)
     * @return [SSFProvider]
     */
    @PATCH("providers/ssf/{id}/")
    suspend fun providersSsfPartialUpdate(@Path("id") id: kotlin.Int, @Body patchedSSFProviderRequest: PatchedSSFProviderRequest? = null): Response<SSFProvider>

    /**
     * GET providers/ssf/{id}/
     *
     * SSFProvider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Shared Signals Framework Provider.
     * @return [SSFProvider]
     */
    @GET("providers/ssf/{id}/")
    suspend fun providersSsfRetrieve(@Path("id") id: kotlin.Int): Response<SSFProvider>

    /**
     * PUT providers/ssf/{id}/
     *
     * SSFProvider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Shared Signals Framework Provider.
     * @param ssFProviderRequest
     * @return [SSFProvider]
     */
    @PUT("providers/ssf/{id}/")
    suspend fun providersSsfUpdate(@Path("id") id: kotlin.Int, @Body ssFProviderRequest: SSFProviderRequest): Response<SSFProvider>

    /**
     * GET providers/ssf/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Shared Signals Framework Provider.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("providers/ssf/{id}/used_by/")
    suspend fun providersSsfUsedByList(@Path("id") id: kotlin.Int): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST providers/wsfed/
     *
     * WSFederationProvider Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param wsFederationProviderRequest
     * @return [WSFederationProvider]
     */
    @POST("providers/wsfed/")
    suspend fun providersWsfedCreate(@Body wsFederationProviderRequest: WSFederationProviderRequest): Response<WSFederationProvider>

    /**
     * DELETE providers/wsfed/{id}/
     *
     * WSFederationProvider Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this WS-Federation Provider.
     * @return [Unit]
     */
    @DELETE("providers/wsfed/{id}/")
    suspend fun providersWsfedDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET providers/wsfed/
     *
     * WSFederationProvider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param acsUrl  (optional)
     * @param assertionValidNotBefore  (optional)
     * @param assertionValidNotOnOrAfter  (optional)
     * @param audience  (optional)
     * @param authenticationFlow  (optional)
     * @param authnContextClassRefMapping  (optional)
     * @param authorizationFlow  (optional)
     * @param backchannelApplication  (optional)
     * @param defaultNameIdPolicy  (optional)
     * @param defaultRelayState  (optional)
     * @param digestAlgorithm  (optional)
     * @param encryptionKp  (optional)
     * @param invalidationFlow  (optional)
     * @param isBackchannel  (optional)
     * @param issuerOverride  (optional)
     * @param logoutMethod  (optional)
     * @param name  (optional)
     * @param nameIdMapping  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param propertyMappings  (optional)
     * @param samlVersion  (optional)
     * @param search A search term. (optional)
     * @param sessionValidNotOnOrAfter  (optional)
     * @param signAssertion  (optional)
     * @param signLogoutRequest  (optional)
     * @param signLogoutResponse  (optional)
     * @param signResponse  (optional)
     * @param signatureAlgorithm  (optional)
     * @param signingKp  (optional)
     * @param slsBinding  (optional)
     * @param slsUrl  (optional)
     * @param spBinding  (optional)
     * @param verificationKp  (optional)
     * @return [PaginatedWSFederationProviderList]
     */
    @GET("providers/wsfed/")
    suspend fun providersWsfedList(@Query("acs_url") acsUrl: kotlin.String? = null, @Query("assertion_valid_not_before") assertionValidNotBefore: kotlin.String? = null, @Query("assertion_valid_not_on_or_after") assertionValidNotOnOrAfter: kotlin.String? = null, @Query("audience") audience: kotlin.String? = null, @Query("authentication_flow") authenticationFlow: java.util.UUID? = null, @Query("authn_context_class_ref_mapping") authnContextClassRefMapping: java.util.UUID? = null, @Query("authorization_flow") authorizationFlow: java.util.UUID? = null, @Query("backchannel_application") backchannelApplication: java.util.UUID? = null, @Query("default_name_id_policy") defaultNameIdPolicy: SAMLNameIDPolicyEnum? = null, @Query("default_relay_state") defaultRelayState: kotlin.String? = null, @Query("digest_algorithm") digestAlgorithm: DigestAlgorithmEnum? = null, @Query("encryption_kp") encryptionKp: java.util.UUID? = null, @Query("invalidation_flow") invalidationFlow: java.util.UUID? = null, @Query("is_backchannel") isBackchannel: kotlin.Boolean? = null, @Query("issuer_override") issuerOverride: kotlin.String? = null, @Query("logout_method") logoutMethod: SAMLLogoutMethods? = null, @Query("name") name: kotlin.String? = null, @Query("name_id_mapping") nameIdMapping: java.util.UUID? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("property_mappings") propertyMappings: @JvmSuppressWildcards kotlin.collections.List<java.util.UUID>? = null, @Query("saml_version") samlVersion: SamlVersionEnum? = null, @Query("search") search: kotlin.String? = null, @Query("session_valid_not_on_or_after") sessionValidNotOnOrAfter: kotlin.String? = null, @Query("sign_assertion") signAssertion: kotlin.Boolean? = null, @Query("sign_logout_request") signLogoutRequest: kotlin.Boolean? = null, @Query("sign_logout_response") signLogoutResponse: kotlin.Boolean? = null, @Query("sign_response") signResponse: kotlin.Boolean? = null, @Query("signature_algorithm") signatureAlgorithm: SignatureAlgorithmEnum? = null, @Query("signing_kp") signingKp: java.util.UUID? = null, @Query("sls_binding") slsBinding: SAMLBindingsEnum? = null, @Query("sls_url") slsUrl: kotlin.String? = null, @Query("sp_binding") spBinding: SAMLBindingsEnum? = null, @Query("verification_kp") verificationKp: java.util.UUID? = null): Response<PaginatedWSFederationProviderList>

    /**
     * GET providers/wsfed/{id}/metadata/
     *
     * Return metadata as XML string
     * Responses:
     *  - 200:
     *  - 404: Provider has no application assigned
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this WS-Federation Provider.
     * @param download  (optional)
     * @param forceBinding  (optional)
     * @return [SAMLMetadata]
     */
    @GET("providers/wsfed/{id}/metadata/")
    suspend fun providersWsfedMetadataRetrieve(@Path("id") id: kotlin.Int, @Query("download") download: kotlin.Boolean? = null, @Query("force_binding") forceBinding: ForceBindingEnum? = null): Response<SAMLMetadata>

    /**
     * PATCH providers/wsfed/{id}/
     *
     * WSFederationProvider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this WS-Federation Provider.
     * @param patchedWSFederationProviderRequest  (optional)
     * @return [WSFederationProvider]
     */
    @PATCH("providers/wsfed/{id}/")
    suspend fun providersWsfedPartialUpdate(@Path("id") id: kotlin.Int, @Body patchedWSFederationProviderRequest: PatchedWSFederationProviderRequest? = null): Response<WSFederationProvider>

    /**
     * GET providers/wsfed/{id}/preview_user/
     *
     * Preview user data for provider
     * Responses:
     *  - 200:
     *  - 400: Bad request
     *  - 403:
     *
     * @param id A unique integer value identifying this WS-Federation Provider.
     * @param forUser  (optional)
     * @return [PropertyMappingPreview]
     */
    @GET("providers/wsfed/{id}/preview_user/")
    suspend fun providersWsfedPreviewUserRetrieve(@Path("id") id: kotlin.Int, @Query("for_user") forUser: kotlin.Int? = null): Response<PropertyMappingPreview>

    /**
     * GET providers/wsfed/{id}/
     *
     * WSFederationProvider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this WS-Federation Provider.
     * @return [WSFederationProvider]
     */
    @GET("providers/wsfed/{id}/")
    suspend fun providersWsfedRetrieve(@Path("id") id: kotlin.Int): Response<WSFederationProvider>

    /**
     * PUT providers/wsfed/{id}/
     *
     * WSFederationProvider Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this WS-Federation Provider.
     * @param wsFederationProviderRequest
     * @return [WSFederationProvider]
     */
    @PUT("providers/wsfed/{id}/")
    suspend fun providersWsfedUpdate(@Path("id") id: kotlin.Int, @Body wsFederationProviderRequest: WSFederationProviderRequest): Response<WSFederationProvider>

    /**
     * GET providers/wsfed/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this WS-Federation Provider.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("providers/wsfed/{id}/used_by/")
    suspend fun providersWsfedUsedByList(@Path("id") id: kotlin.Int): Response<kotlin.collections.List<UsedBy>>

}
