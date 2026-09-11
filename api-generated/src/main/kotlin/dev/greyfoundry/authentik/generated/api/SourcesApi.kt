package dev.greyfoundry.authentik.generated.api

import dev.greyfoundry.authentik.generated.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import dev.greyfoundry.authentik.generated.model.BindingTypeEnum
import dev.greyfoundry.authentik.generated.model.DigestAlgorithmEnum
import dev.greyfoundry.authentik.generated.model.GenericError
import dev.greyfoundry.authentik.generated.model.GroupKerberosSourceConnection
import dev.greyfoundry.authentik.generated.model.GroupKerberosSourceConnectionRequest
import dev.greyfoundry.authentik.generated.model.GroupLDAPSourceConnection
import dev.greyfoundry.authentik.generated.model.GroupLDAPSourceConnectionRequest
import dev.greyfoundry.authentik.generated.model.GroupMatchingModeEnum
import dev.greyfoundry.authentik.generated.model.GroupOAuthSourceConnection
import dev.greyfoundry.authentik.generated.model.GroupOAuthSourceConnectionRequest
import dev.greyfoundry.authentik.generated.model.GroupPlexSourceConnection
import dev.greyfoundry.authentik.generated.model.GroupPlexSourceConnectionRequest
import dev.greyfoundry.authentik.generated.model.GroupSAMLSourceConnection
import dev.greyfoundry.authentik.generated.model.GroupSAMLSourceConnectionRequest
import dev.greyfoundry.authentik.generated.model.GroupSourceConnection
import dev.greyfoundry.authentik.generated.model.GroupSourceConnectionRequest
import dev.greyfoundry.authentik.generated.model.GroupTelegramSourceConnection
import dev.greyfoundry.authentik.generated.model.GroupTelegramSourceConnectionRequest
import dev.greyfoundry.authentik.generated.model.KadminTypeEnum
import dev.greyfoundry.authentik.generated.model.KerberosSource
import dev.greyfoundry.authentik.generated.model.KerberosSourceRequest
import dev.greyfoundry.authentik.generated.model.LDAPDebug
import dev.greyfoundry.authentik.generated.model.LDAPSource
import dev.greyfoundry.authentik.generated.model.LDAPSourceRequest
import dev.greyfoundry.authentik.generated.model.OAuthSource
import dev.greyfoundry.authentik.generated.model.OAuthSourceRequest
import dev.greyfoundry.authentik.generated.model.PaginatedGroupKerberosSourceConnectionList
import dev.greyfoundry.authentik.generated.model.PaginatedGroupLDAPSourceConnectionList
import dev.greyfoundry.authentik.generated.model.PaginatedGroupOAuthSourceConnectionList
import dev.greyfoundry.authentik.generated.model.PaginatedGroupPlexSourceConnectionList
import dev.greyfoundry.authentik.generated.model.PaginatedGroupSAMLSourceConnectionList
import dev.greyfoundry.authentik.generated.model.PaginatedGroupSourceConnectionList
import dev.greyfoundry.authentik.generated.model.PaginatedGroupTelegramSourceConnectionList
import dev.greyfoundry.authentik.generated.model.PaginatedKerberosSourceList
import dev.greyfoundry.authentik.generated.model.PaginatedLDAPSourceList
import dev.greyfoundry.authentik.generated.model.PaginatedOAuthSourceList
import dev.greyfoundry.authentik.generated.model.PaginatedPlexSourceList
import dev.greyfoundry.authentik.generated.model.PaginatedSAMLSourceList
import dev.greyfoundry.authentik.generated.model.PaginatedSCIMSourceGroupList
import dev.greyfoundry.authentik.generated.model.PaginatedSCIMSourceList
import dev.greyfoundry.authentik.generated.model.PaginatedSCIMSourceUserList
import dev.greyfoundry.authentik.generated.model.PaginatedSourceList
import dev.greyfoundry.authentik.generated.model.PaginatedTelegramSourceList
import dev.greyfoundry.authentik.generated.model.PaginatedUserKerberosSourceConnectionList
import dev.greyfoundry.authentik.generated.model.PaginatedUserLDAPSourceConnectionList
import dev.greyfoundry.authentik.generated.model.PaginatedUserOAuthSourceConnectionList
import dev.greyfoundry.authentik.generated.model.PaginatedUserPlexSourceConnectionList
import dev.greyfoundry.authentik.generated.model.PaginatedUserSAMLSourceConnectionList
import dev.greyfoundry.authentik.generated.model.PaginatedUserSourceConnectionList
import dev.greyfoundry.authentik.generated.model.PaginatedUserTelegramSourceConnectionList
import dev.greyfoundry.authentik.generated.model.PatchedGroupKerberosSourceConnectionRequest
import dev.greyfoundry.authentik.generated.model.PatchedGroupLDAPSourceConnectionRequest
import dev.greyfoundry.authentik.generated.model.PatchedGroupOAuthSourceConnectionRequest
import dev.greyfoundry.authentik.generated.model.PatchedGroupPlexSourceConnectionRequest
import dev.greyfoundry.authentik.generated.model.PatchedGroupSAMLSourceConnectionRequest
import dev.greyfoundry.authentik.generated.model.PatchedGroupSourceConnectionRequest
import dev.greyfoundry.authentik.generated.model.PatchedGroupTelegramSourceConnectionRequest
import dev.greyfoundry.authentik.generated.model.PatchedKerberosSourceRequest
import dev.greyfoundry.authentik.generated.model.PatchedLDAPSourceRequest
import dev.greyfoundry.authentik.generated.model.PatchedOAuthSourceRequest
import dev.greyfoundry.authentik.generated.model.PatchedPlexSourceRequest
import dev.greyfoundry.authentik.generated.model.PatchedSAMLSourceRequest
import dev.greyfoundry.authentik.generated.model.PatchedSCIMSourceGroupRequest
import dev.greyfoundry.authentik.generated.model.PatchedSCIMSourceRequest
import dev.greyfoundry.authentik.generated.model.PatchedSCIMSourceUserRequest
import dev.greyfoundry.authentik.generated.model.PatchedTelegramSourceRequest
import dev.greyfoundry.authentik.generated.model.PatchedUserKerberosSourceConnectionRequest
import dev.greyfoundry.authentik.generated.model.PatchedUserLDAPSourceConnectionRequest
import dev.greyfoundry.authentik.generated.model.PatchedUserOAuthSourceConnectionRequest
import dev.greyfoundry.authentik.generated.model.PatchedUserPlexSourceConnectionRequest
import dev.greyfoundry.authentik.generated.model.PatchedUserSAMLSourceConnectionRequest
import dev.greyfoundry.authentik.generated.model.PatchedUserSourceConnectionRequest
import dev.greyfoundry.authentik.generated.model.PatchedUserTelegramSourceConnectionRequest
import dev.greyfoundry.authentik.generated.model.PlexSource
import dev.greyfoundry.authentik.generated.model.PlexSourceRequest
import dev.greyfoundry.authentik.generated.model.PlexTokenRedeemRequest
import dev.greyfoundry.authentik.generated.model.PolicyEngineMode
import dev.greyfoundry.authentik.generated.model.RedirectChallenge
import dev.greyfoundry.authentik.generated.model.SAMLMetadata
import dev.greyfoundry.authentik.generated.model.SAMLNameIDPolicyEnum
import dev.greyfoundry.authentik.generated.model.SAMLSource
import dev.greyfoundry.authentik.generated.model.SAMLSourceRequest
import dev.greyfoundry.authentik.generated.model.SCIMSource
import dev.greyfoundry.authentik.generated.model.SCIMSourceGroup
import dev.greyfoundry.authentik.generated.model.SCIMSourceGroupRequest
import dev.greyfoundry.authentik.generated.model.SCIMSourceRequest
import dev.greyfoundry.authentik.generated.model.SCIMSourceUser
import dev.greyfoundry.authentik.generated.model.SCIMSourceUserRequest
import dev.greyfoundry.authentik.generated.model.SignatureAlgorithmEnum
import dev.greyfoundry.authentik.generated.model.Source
import dev.greyfoundry.authentik.generated.model.SourceType
import dev.greyfoundry.authentik.generated.model.SyncStatus
import dev.greyfoundry.authentik.generated.model.TelegramAuthRequest
import dev.greyfoundry.authentik.generated.model.TelegramSource
import dev.greyfoundry.authentik.generated.model.TelegramSourceRequest
import dev.greyfoundry.authentik.generated.model.TypeCreate
import dev.greyfoundry.authentik.generated.model.UsedBy
import dev.greyfoundry.authentik.generated.model.UserKerberosSourceConnection
import dev.greyfoundry.authentik.generated.model.UserKerberosSourceConnectionRequest
import dev.greyfoundry.authentik.generated.model.UserLDAPSourceConnection
import dev.greyfoundry.authentik.generated.model.UserLDAPSourceConnectionRequest
import dev.greyfoundry.authentik.generated.model.UserMatchingModeEnum
import dev.greyfoundry.authentik.generated.model.UserOAuthSourceConnection
import dev.greyfoundry.authentik.generated.model.UserOAuthSourceConnectionRequest
import dev.greyfoundry.authentik.generated.model.UserPlexSourceConnection
import dev.greyfoundry.authentik.generated.model.UserPlexSourceConnectionRequest
import dev.greyfoundry.authentik.generated.model.UserSAMLSourceConnection
import dev.greyfoundry.authentik.generated.model.UserSAMLSourceConnectionRequest
import dev.greyfoundry.authentik.generated.model.UserSetting
import dev.greyfoundry.authentik.generated.model.UserSourceConnection
import dev.greyfoundry.authentik.generated.model.UserSourceConnectionRequest
import dev.greyfoundry.authentik.generated.model.UserTelegramSourceConnection
import dev.greyfoundry.authentik.generated.model.UserTelegramSourceConnectionRequest
import dev.greyfoundry.authentik.generated.model.ValidationError

interface SourcesApi {
    /**
     * DELETE sources/all/{slug}/
     *
     * Prevent deletion of built-in sources
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @return [Unit]
     */
    @DELETE("sources/all/{slug}/")
    suspend fun sourcesAllDestroy(@Path("slug") slug: kotlin.String): Response<Unit>

    /**
     * GET sources/all/
     *
     * Source Viewset
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
     * @param pbmUuid  (optional)
     * @param search A search term. (optional)
     * @param slug  (optional)
     * @return [PaginatedSourceList]
     */
    @GET("sources/all/")
    suspend fun sourcesAllList(@Query("managed") managed: kotlin.String? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("pbm_uuid") pbmUuid: java.util.UUID? = null, @Query("search") search: kotlin.String? = null, @Query("slug") slug: kotlin.String? = null): Response<PaginatedSourceList>

    /**
     * GET sources/all/{slug}/
     *
     * Source Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @return [Source]
     */
    @GET("sources/all/{slug}/")
    suspend fun sourcesAllRetrieve(@Path("slug") slug: kotlin.String): Response<Source>

    /**
     * GET sources/all/types/
     *
     * Get all creatable types
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @return [kotlin.collections.List<TypeCreate>]
     */
    @GET("sources/all/types/")
    suspend fun sourcesAllTypesList(): Response<kotlin.collections.List<TypeCreate>>

    /**
     * GET sources/all/{slug}/used_by/
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
    @GET("sources/all/{slug}/used_by/")
    suspend fun sourcesAllUsedByList(@Path("slug") slug: kotlin.String): Response<kotlin.collections.List<UsedBy>>

    /**
     * GET sources/all/user_settings/
     *
     * Get all sources the user can configure
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @return [kotlin.collections.List<UserSetting>]
     */
    @GET("sources/all/user_settings/")
    suspend fun sourcesAllUserSettingsList(): Response<kotlin.collections.List<UserSetting>>

    /**
     * DELETE sources/group_connections/all/{id}/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this group source connection.
     * @return [Unit]
     */
    @DELETE("sources/group_connections/all/{id}/")
    suspend fun sourcesGroupConnectionsAllDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET sources/group_connections/all/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param group  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param sourceSlug  (optional)
     * @return [PaginatedGroupSourceConnectionList]
     */
    @GET("sources/group_connections/all/")
    suspend fun sourcesGroupConnectionsAllList(@Query("group") group: java.util.UUID? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("source__slug") sourceSlug: kotlin.String? = null): Response<PaginatedGroupSourceConnectionList>

    /**
     * PATCH sources/group_connections/all/{id}/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this group source connection.
     * @param patchedGroupSourceConnectionRequest  (optional)
     * @return [GroupSourceConnection]
     */
    @PATCH("sources/group_connections/all/{id}/")
    suspend fun sourcesGroupConnectionsAllPartialUpdate(@Path("id") id: kotlin.Int, @Body patchedGroupSourceConnectionRequest: PatchedGroupSourceConnectionRequest? = null): Response<GroupSourceConnection>

    /**
     * GET sources/group_connections/all/{id}/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this group source connection.
     * @return [GroupSourceConnection]
     */
    @GET("sources/group_connections/all/{id}/")
    suspend fun sourcesGroupConnectionsAllRetrieve(@Path("id") id: kotlin.Int): Response<GroupSourceConnection>

    /**
     * PUT sources/group_connections/all/{id}/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this group source connection.
     * @param groupSourceConnectionRequest
     * @return [GroupSourceConnection]
     */
    @PUT("sources/group_connections/all/{id}/")
    suspend fun sourcesGroupConnectionsAllUpdate(@Path("id") id: kotlin.Int, @Body groupSourceConnectionRequest: GroupSourceConnectionRequest): Response<GroupSourceConnection>

    /**
     * GET sources/group_connections/all/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this group source connection.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("sources/group_connections/all/{id}/used_by/")
    suspend fun sourcesGroupConnectionsAllUsedByList(@Path("id") id: kotlin.Int): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST sources/group_connections/kerberos/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param groupKerberosSourceConnectionRequest
     * @return [GroupKerberosSourceConnection]
     */
    @POST("sources/group_connections/kerberos/")
    suspend fun sourcesGroupConnectionsKerberosCreate(@Body groupKerberosSourceConnectionRequest: GroupKerberosSourceConnectionRequest): Response<GroupKerberosSourceConnection>

    /**
     * DELETE sources/group_connections/kerberos/{id}/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Group Kerberos Source Connection.
     * @return [Unit]
     */
    @DELETE("sources/group_connections/kerberos/{id}/")
    suspend fun sourcesGroupConnectionsKerberosDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET sources/group_connections/kerberos/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param group  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param sourceSlug  (optional)
     * @return [PaginatedGroupKerberosSourceConnectionList]
     */
    @GET("sources/group_connections/kerberos/")
    suspend fun sourcesGroupConnectionsKerberosList(@Query("group") group: java.util.UUID? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("source__slug") sourceSlug: kotlin.String? = null): Response<PaginatedGroupKerberosSourceConnectionList>

    /**
     * PATCH sources/group_connections/kerberos/{id}/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Group Kerberos Source Connection.
     * @param patchedGroupKerberosSourceConnectionRequest  (optional)
     * @return [GroupKerberosSourceConnection]
     */
    @PATCH("sources/group_connections/kerberos/{id}/")
    suspend fun sourcesGroupConnectionsKerberosPartialUpdate(@Path("id") id: kotlin.Int, @Body patchedGroupKerberosSourceConnectionRequest: PatchedGroupKerberosSourceConnectionRequest? = null): Response<GroupKerberosSourceConnection>

    /**
     * GET sources/group_connections/kerberos/{id}/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Group Kerberos Source Connection.
     * @return [GroupKerberosSourceConnection]
     */
    @GET("sources/group_connections/kerberos/{id}/")
    suspend fun sourcesGroupConnectionsKerberosRetrieve(@Path("id") id: kotlin.Int): Response<GroupKerberosSourceConnection>

    /**
     * PUT sources/group_connections/kerberos/{id}/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Group Kerberos Source Connection.
     * @param groupKerberosSourceConnectionRequest
     * @return [GroupKerberosSourceConnection]
     */
    @PUT("sources/group_connections/kerberos/{id}/")
    suspend fun sourcesGroupConnectionsKerberosUpdate(@Path("id") id: kotlin.Int, @Body groupKerberosSourceConnectionRequest: GroupKerberosSourceConnectionRequest): Response<GroupKerberosSourceConnection>

    /**
     * GET sources/group_connections/kerberos/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Group Kerberos Source Connection.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("sources/group_connections/kerberos/{id}/used_by/")
    suspend fun sourcesGroupConnectionsKerberosUsedByList(@Path("id") id: kotlin.Int): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST sources/group_connections/ldap/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param groupLDAPSourceConnectionRequest
     * @return [GroupLDAPSourceConnection]
     */
    @POST("sources/group_connections/ldap/")
    suspend fun sourcesGroupConnectionsLdapCreate(@Body groupLDAPSourceConnectionRequest: GroupLDAPSourceConnectionRequest): Response<GroupLDAPSourceConnection>

    /**
     * DELETE sources/group_connections/ldap/{id}/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Group LDAP Source Connection.
     * @return [Unit]
     */
    @DELETE("sources/group_connections/ldap/{id}/")
    suspend fun sourcesGroupConnectionsLdapDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET sources/group_connections/ldap/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param group  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param sourceSlug  (optional)
     * @return [PaginatedGroupLDAPSourceConnectionList]
     */
    @GET("sources/group_connections/ldap/")
    suspend fun sourcesGroupConnectionsLdapList(@Query("group") group: java.util.UUID? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("source__slug") sourceSlug: kotlin.String? = null): Response<PaginatedGroupLDAPSourceConnectionList>

    /**
     * PATCH sources/group_connections/ldap/{id}/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Group LDAP Source Connection.
     * @param patchedGroupLDAPSourceConnectionRequest  (optional)
     * @return [GroupLDAPSourceConnection]
     */
    @PATCH("sources/group_connections/ldap/{id}/")
    suspend fun sourcesGroupConnectionsLdapPartialUpdate(@Path("id") id: kotlin.Int, @Body patchedGroupLDAPSourceConnectionRequest: PatchedGroupLDAPSourceConnectionRequest? = null): Response<GroupLDAPSourceConnection>

    /**
     * GET sources/group_connections/ldap/{id}/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Group LDAP Source Connection.
     * @return [GroupLDAPSourceConnection]
     */
    @GET("sources/group_connections/ldap/{id}/")
    suspend fun sourcesGroupConnectionsLdapRetrieve(@Path("id") id: kotlin.Int): Response<GroupLDAPSourceConnection>

    /**
     * PUT sources/group_connections/ldap/{id}/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Group LDAP Source Connection.
     * @param groupLDAPSourceConnectionRequest
     * @return [GroupLDAPSourceConnection]
     */
    @PUT("sources/group_connections/ldap/{id}/")
    suspend fun sourcesGroupConnectionsLdapUpdate(@Path("id") id: kotlin.Int, @Body groupLDAPSourceConnectionRequest: GroupLDAPSourceConnectionRequest): Response<GroupLDAPSourceConnection>

    /**
     * GET sources/group_connections/ldap/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Group LDAP Source Connection.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("sources/group_connections/ldap/{id}/used_by/")
    suspend fun sourcesGroupConnectionsLdapUsedByList(@Path("id") id: kotlin.Int): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST sources/group_connections/oauth/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param groupOAuthSourceConnectionRequest
     * @return [GroupOAuthSourceConnection]
     */
    @POST("sources/group_connections/oauth/")
    suspend fun sourcesGroupConnectionsOauthCreate(@Body groupOAuthSourceConnectionRequest: GroupOAuthSourceConnectionRequest): Response<GroupOAuthSourceConnection>

    /**
     * DELETE sources/group_connections/oauth/{id}/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Group OAuth Source Connection.
     * @return [Unit]
     */
    @DELETE("sources/group_connections/oauth/{id}/")
    suspend fun sourcesGroupConnectionsOauthDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET sources/group_connections/oauth/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param group  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param sourceSlug  (optional)
     * @return [PaginatedGroupOAuthSourceConnectionList]
     */
    @GET("sources/group_connections/oauth/")
    suspend fun sourcesGroupConnectionsOauthList(@Query("group") group: java.util.UUID? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("source__slug") sourceSlug: kotlin.String? = null): Response<PaginatedGroupOAuthSourceConnectionList>

    /**
     * PATCH sources/group_connections/oauth/{id}/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Group OAuth Source Connection.
     * @param patchedGroupOAuthSourceConnectionRequest  (optional)
     * @return [GroupOAuthSourceConnection]
     */
    @PATCH("sources/group_connections/oauth/{id}/")
    suspend fun sourcesGroupConnectionsOauthPartialUpdate(@Path("id") id: kotlin.Int, @Body patchedGroupOAuthSourceConnectionRequest: PatchedGroupOAuthSourceConnectionRequest? = null): Response<GroupOAuthSourceConnection>

    /**
     * GET sources/group_connections/oauth/{id}/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Group OAuth Source Connection.
     * @return [GroupOAuthSourceConnection]
     */
    @GET("sources/group_connections/oauth/{id}/")
    suspend fun sourcesGroupConnectionsOauthRetrieve(@Path("id") id: kotlin.Int): Response<GroupOAuthSourceConnection>

    /**
     * PUT sources/group_connections/oauth/{id}/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Group OAuth Source Connection.
     * @param groupOAuthSourceConnectionRequest
     * @return [GroupOAuthSourceConnection]
     */
    @PUT("sources/group_connections/oauth/{id}/")
    suspend fun sourcesGroupConnectionsOauthUpdate(@Path("id") id: kotlin.Int, @Body groupOAuthSourceConnectionRequest: GroupOAuthSourceConnectionRequest): Response<GroupOAuthSourceConnection>

    /**
     * GET sources/group_connections/oauth/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Group OAuth Source Connection.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("sources/group_connections/oauth/{id}/used_by/")
    suspend fun sourcesGroupConnectionsOauthUsedByList(@Path("id") id: kotlin.Int): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST sources/group_connections/plex/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param groupPlexSourceConnectionRequest
     * @return [GroupPlexSourceConnection]
     */
    @POST("sources/group_connections/plex/")
    suspend fun sourcesGroupConnectionsPlexCreate(@Body groupPlexSourceConnectionRequest: GroupPlexSourceConnectionRequest): Response<GroupPlexSourceConnection>

    /**
     * DELETE sources/group_connections/plex/{id}/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Group Plex Source Connection.
     * @return [Unit]
     */
    @DELETE("sources/group_connections/plex/{id}/")
    suspend fun sourcesGroupConnectionsPlexDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET sources/group_connections/plex/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param group  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param sourceSlug  (optional)
     * @return [PaginatedGroupPlexSourceConnectionList]
     */
    @GET("sources/group_connections/plex/")
    suspend fun sourcesGroupConnectionsPlexList(@Query("group") group: java.util.UUID? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("source__slug") sourceSlug: kotlin.String? = null): Response<PaginatedGroupPlexSourceConnectionList>

    /**
     * PATCH sources/group_connections/plex/{id}/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Group Plex Source Connection.
     * @param patchedGroupPlexSourceConnectionRequest  (optional)
     * @return [GroupPlexSourceConnection]
     */
    @PATCH("sources/group_connections/plex/{id}/")
    suspend fun sourcesGroupConnectionsPlexPartialUpdate(@Path("id") id: kotlin.Int, @Body patchedGroupPlexSourceConnectionRequest: PatchedGroupPlexSourceConnectionRequest? = null): Response<GroupPlexSourceConnection>

    /**
     * GET sources/group_connections/plex/{id}/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Group Plex Source Connection.
     * @return [GroupPlexSourceConnection]
     */
    @GET("sources/group_connections/plex/{id}/")
    suspend fun sourcesGroupConnectionsPlexRetrieve(@Path("id") id: kotlin.Int): Response<GroupPlexSourceConnection>

    /**
     * PUT sources/group_connections/plex/{id}/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Group Plex Source Connection.
     * @param groupPlexSourceConnectionRequest
     * @return [GroupPlexSourceConnection]
     */
    @PUT("sources/group_connections/plex/{id}/")
    suspend fun sourcesGroupConnectionsPlexUpdate(@Path("id") id: kotlin.Int, @Body groupPlexSourceConnectionRequest: GroupPlexSourceConnectionRequest): Response<GroupPlexSourceConnection>

    /**
     * GET sources/group_connections/plex/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Group Plex Source Connection.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("sources/group_connections/plex/{id}/used_by/")
    suspend fun sourcesGroupConnectionsPlexUsedByList(@Path("id") id: kotlin.Int): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST sources/group_connections/saml/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param groupSAMLSourceConnectionRequest
     * @return [GroupSAMLSourceConnection]
     */
    @POST("sources/group_connections/saml/")
    suspend fun sourcesGroupConnectionsSamlCreate(@Body groupSAMLSourceConnectionRequest: GroupSAMLSourceConnectionRequest): Response<GroupSAMLSourceConnection>

    /**
     * DELETE sources/group_connections/saml/{id}/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Group SAML Source Connection.
     * @return [Unit]
     */
    @DELETE("sources/group_connections/saml/{id}/")
    suspend fun sourcesGroupConnectionsSamlDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET sources/group_connections/saml/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param group  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param sourceSlug  (optional)
     * @return [PaginatedGroupSAMLSourceConnectionList]
     */
    @GET("sources/group_connections/saml/")
    suspend fun sourcesGroupConnectionsSamlList(@Query("group") group: java.util.UUID? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("source__slug") sourceSlug: kotlin.String? = null): Response<PaginatedGroupSAMLSourceConnectionList>

    /**
     * PATCH sources/group_connections/saml/{id}/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Group SAML Source Connection.
     * @param patchedGroupSAMLSourceConnectionRequest  (optional)
     * @return [GroupSAMLSourceConnection]
     */
    @PATCH("sources/group_connections/saml/{id}/")
    suspend fun sourcesGroupConnectionsSamlPartialUpdate(@Path("id") id: kotlin.Int, @Body patchedGroupSAMLSourceConnectionRequest: PatchedGroupSAMLSourceConnectionRequest? = null): Response<GroupSAMLSourceConnection>

    /**
     * GET sources/group_connections/saml/{id}/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Group SAML Source Connection.
     * @return [GroupSAMLSourceConnection]
     */
    @GET("sources/group_connections/saml/{id}/")
    suspend fun sourcesGroupConnectionsSamlRetrieve(@Path("id") id: kotlin.Int): Response<GroupSAMLSourceConnection>

    /**
     * PUT sources/group_connections/saml/{id}/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Group SAML Source Connection.
     * @param groupSAMLSourceConnectionRequest
     * @return [GroupSAMLSourceConnection]
     */
    @PUT("sources/group_connections/saml/{id}/")
    suspend fun sourcesGroupConnectionsSamlUpdate(@Path("id") id: kotlin.Int, @Body groupSAMLSourceConnectionRequest: GroupSAMLSourceConnectionRequest): Response<GroupSAMLSourceConnection>

    /**
     * GET sources/group_connections/saml/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Group SAML Source Connection.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("sources/group_connections/saml/{id}/used_by/")
    suspend fun sourcesGroupConnectionsSamlUsedByList(@Path("id") id: kotlin.Int): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST sources/group_connections/telegram/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param groupTelegramSourceConnectionRequest
     * @return [GroupTelegramSourceConnection]
     */
    @POST("sources/group_connections/telegram/")
    suspend fun sourcesGroupConnectionsTelegramCreate(@Body groupTelegramSourceConnectionRequest: GroupTelegramSourceConnectionRequest): Response<GroupTelegramSourceConnection>

    /**
     * DELETE sources/group_connections/telegram/{id}/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Group Telegram Source Connection.
     * @return [Unit]
     */
    @DELETE("sources/group_connections/telegram/{id}/")
    suspend fun sourcesGroupConnectionsTelegramDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET sources/group_connections/telegram/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param group  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param sourceSlug  (optional)
     * @return [PaginatedGroupTelegramSourceConnectionList]
     */
    @GET("sources/group_connections/telegram/")
    suspend fun sourcesGroupConnectionsTelegramList(@Query("group") group: java.util.UUID? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("source__slug") sourceSlug: kotlin.String? = null): Response<PaginatedGroupTelegramSourceConnectionList>

    /**
     * PATCH sources/group_connections/telegram/{id}/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Group Telegram Source Connection.
     * @param patchedGroupTelegramSourceConnectionRequest  (optional)
     * @return [GroupTelegramSourceConnection]
     */
    @PATCH("sources/group_connections/telegram/{id}/")
    suspend fun sourcesGroupConnectionsTelegramPartialUpdate(@Path("id") id: kotlin.Int, @Body patchedGroupTelegramSourceConnectionRequest: PatchedGroupTelegramSourceConnectionRequest? = null): Response<GroupTelegramSourceConnection>

    /**
     * GET sources/group_connections/telegram/{id}/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Group Telegram Source Connection.
     * @return [GroupTelegramSourceConnection]
     */
    @GET("sources/group_connections/telegram/{id}/")
    suspend fun sourcesGroupConnectionsTelegramRetrieve(@Path("id") id: kotlin.Int): Response<GroupTelegramSourceConnection>

    /**
     * PUT sources/group_connections/telegram/{id}/
     *
     * Group-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Group Telegram Source Connection.
     * @param groupTelegramSourceConnectionRequest
     * @return [GroupTelegramSourceConnection]
     */
    @PUT("sources/group_connections/telegram/{id}/")
    suspend fun sourcesGroupConnectionsTelegramUpdate(@Path("id") id: kotlin.Int, @Body groupTelegramSourceConnectionRequest: GroupTelegramSourceConnectionRequest): Response<GroupTelegramSourceConnection>

    /**
     * GET sources/group_connections/telegram/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Group Telegram Source Connection.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("sources/group_connections/telegram/{id}/used_by/")
    suspend fun sourcesGroupConnectionsTelegramUsedByList(@Path("id") id: kotlin.Int): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST sources/kerberos/
     *
     * Kerberos Source Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param kerberosSourceRequest
     * @return [KerberosSource]
     */
    @POST("sources/kerberos/")
    suspend fun sourcesKerberosCreate(@Body kerberosSourceRequest: KerberosSourceRequest): Response<KerberosSource>

    /**
     * DELETE sources/kerberos/{slug}/
     *
     * Kerberos Source Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @return [Unit]
     */
    @DELETE("sources/kerberos/{slug}/")
    suspend fun sourcesKerberosDestroy(@Path("slug") slug: kotlin.String): Response<Unit>

    /**
     * GET sources/kerberos/
     *
     * Kerberos Source Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param enabled  (optional)
     * @param kadminType  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param passwordLoginUpdateInternalPassword  (optional)
     * @param pbmUuid  (optional)
     * @param realm  (optional)
     * @param search A search term. (optional)
     * @param slug  (optional)
     * @param spnegoServerName  (optional)
     * @param syncPrincipal  (optional)
     * @param syncUsers  (optional)
     * @param syncUsersPassword  (optional)
     * @return [PaginatedKerberosSourceList]
     */
    @GET("sources/kerberos/")
    suspend fun sourcesKerberosList(@Query("enabled") enabled: kotlin.Boolean? = null, @Query("kadmin_type") kadminType: KadminTypeEnum? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("password_login_update_internal_password") passwordLoginUpdateInternalPassword: kotlin.Boolean? = null, @Query("pbm_uuid") pbmUuid: java.util.UUID? = null, @Query("realm") realm: kotlin.String? = null, @Query("search") search: kotlin.String? = null, @Query("slug") slug: kotlin.String? = null, @Query("spnego_server_name") spnegoServerName: kotlin.String? = null, @Query("sync_principal") syncPrincipal: kotlin.String? = null, @Query("sync_users") syncUsers: kotlin.Boolean? = null, @Query("sync_users_password") syncUsersPassword: kotlin.Boolean? = null): Response<PaginatedKerberosSourceList>

    /**
     * PATCH sources/kerberos/{slug}/
     *
     * Kerberos Source Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @param patchedKerberosSourceRequest  (optional)
     * @return [KerberosSource]
     */
    @PATCH("sources/kerberos/{slug}/")
    suspend fun sourcesKerberosPartialUpdate(@Path("slug") slug: kotlin.String, @Body patchedKerberosSourceRequest: PatchedKerberosSourceRequest? = null): Response<KerberosSource>

    /**
     * GET sources/kerberos/{slug}/
     *
     * Kerberos Source Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @return [KerberosSource]
     */
    @GET("sources/kerberos/{slug}/")
    suspend fun sourcesKerberosRetrieve(@Path("slug") slug: kotlin.String): Response<KerberosSource>

    /**
     * GET sources/kerberos/{slug}/sync/status/
     *
     * Get provider&#39;s sync status
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @return [SyncStatus]
     */
    @GET("sources/kerberos/{slug}/sync/status/")
    suspend fun sourcesKerberosSyncStatusRetrieve(@Path("slug") slug: kotlin.String): Response<SyncStatus>

    /**
     * PUT sources/kerberos/{slug}/
     *
     * Kerberos Source Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @param kerberosSourceRequest
     * @return [KerberosSource]
     */
    @PUT("sources/kerberos/{slug}/")
    suspend fun sourcesKerberosUpdate(@Path("slug") slug: kotlin.String, @Body kerberosSourceRequest: KerberosSourceRequest): Response<KerberosSource>

    /**
     * GET sources/kerberos/{slug}/used_by/
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
    @GET("sources/kerberos/{slug}/used_by/")
    suspend fun sourcesKerberosUsedByList(@Path("slug") slug: kotlin.String): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST sources/ldap/
     *
     * LDAP Source Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param ldAPSourceRequest
     * @return [LDAPSource]
     */
    @POST("sources/ldap/")
    suspend fun sourcesLdapCreate(@Body ldAPSourceRequest: LDAPSourceRequest): Response<LDAPSource>

    /**
     * GET sources/ldap/{slug}/debug/
     *
     * Get raw LDAP data to debug
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @return [LDAPDebug]
     */
    @GET("sources/ldap/{slug}/debug/")
    suspend fun sourcesLdapDebugRetrieve(@Path("slug") slug: kotlin.String): Response<LDAPDebug>

    /**
     * DELETE sources/ldap/{slug}/
     *
     * LDAP Source Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @return [Unit]
     */
    @DELETE("sources/ldap/{slug}/")
    suspend fun sourcesLdapDestroy(@Path("slug") slug: kotlin.String): Response<Unit>

    /**
     * GET sources/ldap/
     *
     * LDAP Source Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param additionalGroupDn  (optional)
     * @param additionalUserDn  (optional)
     * @param baseDn  (optional)
     * @param bindCn  (optional)
     * @param clientCertificate  (optional)
     * @param deleteNotFoundObjects  (optional)
     * @param enabled  (optional)
     * @param groupMembershipField  (optional)
     * @param groupObjectFilter  (optional)
     * @param groupPropertyMappings  (optional)
     * @param lookupGroupsFromUser  (optional)
     * @param name  (optional)
     * @param objectUniquenessField  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param passwordLoginUpdateInternalPassword  (optional)
     * @param pbmUuid  (optional)
     * @param peerCertificate  (optional)
     * @param search A search term. (optional)
     * @param serverUri  (optional)
     * @param slug  (optional)
     * @param sni  (optional)
     * @param startTls  (optional)
     * @param syncGroupHierarchy  (optional)
     * @param syncGroups  (optional)
     * @param syncParentGroup  (optional)
     * @param syncUsers  (optional)
     * @param syncUsersPassword  (optional)
     * @param userMembershipAttribute  (optional)
     * @param userObjectFilter  (optional)
     * @param userPropertyMappings  (optional)
     * @return [PaginatedLDAPSourceList]
     */
    @GET("sources/ldap/")
    suspend fun sourcesLdapList(@Query("additional_group_dn") additionalGroupDn: kotlin.String? = null, @Query("additional_user_dn") additionalUserDn: kotlin.String? = null, @Query("base_dn") baseDn: kotlin.String? = null, @Query("bind_cn") bindCn: kotlin.String? = null, @Query("client_certificate") clientCertificate: java.util.UUID? = null, @Query("delete_not_found_objects") deleteNotFoundObjects: kotlin.Boolean? = null, @Query("enabled") enabled: kotlin.Boolean? = null, @Query("group_membership_field") groupMembershipField: kotlin.String? = null, @Query("group_object_filter") groupObjectFilter: kotlin.String? = null, @Query("group_property_mappings") groupPropertyMappings: @JvmSuppressWildcards kotlin.collections.List<java.util.UUID>? = null, @Query("lookup_groups_from_user") lookupGroupsFromUser: kotlin.Boolean? = null, @Query("name") name: kotlin.String? = null, @Query("object_uniqueness_field") objectUniquenessField: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("password_login_update_internal_password") passwordLoginUpdateInternalPassword: kotlin.Boolean? = null, @Query("pbm_uuid") pbmUuid: java.util.UUID? = null, @Query("peer_certificate") peerCertificate: java.util.UUID? = null, @Query("search") search: kotlin.String? = null, @Query("server_uri") serverUri: kotlin.String? = null, @Query("slug") slug: kotlin.String? = null, @Query("sni") sni: kotlin.Boolean? = null, @Query("start_tls") startTls: kotlin.Boolean? = null, @Query("sync_group_hierarchy") syncGroupHierarchy: kotlin.Boolean? = null, @Query("sync_groups") syncGroups: kotlin.Boolean? = null, @Query("sync_parent_group") syncParentGroup: java.util.UUID? = null, @Query("sync_users") syncUsers: kotlin.Boolean? = null, @Query("sync_users_password") syncUsersPassword: kotlin.Boolean? = null, @Query("user_membership_attribute") userMembershipAttribute: kotlin.String? = null, @Query("user_object_filter") userObjectFilter: kotlin.String? = null, @Query("user_property_mappings") userPropertyMappings: @JvmSuppressWildcards kotlin.collections.List<java.util.UUID>? = null): Response<PaginatedLDAPSourceList>

    /**
     * PATCH sources/ldap/{slug}/
     *
     * LDAP Source Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @param patchedLDAPSourceRequest  (optional)
     * @return [LDAPSource]
     */
    @PATCH("sources/ldap/{slug}/")
    suspend fun sourcesLdapPartialUpdate(@Path("slug") slug: kotlin.String, @Body patchedLDAPSourceRequest: PatchedLDAPSourceRequest? = null): Response<LDAPSource>

    /**
     * GET sources/ldap/{slug}/
     *
     * LDAP Source Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @return [LDAPSource]
     */
    @GET("sources/ldap/{slug}/")
    suspend fun sourcesLdapRetrieve(@Path("slug") slug: kotlin.String): Response<LDAPSource>

    /**
     * GET sources/ldap/{slug}/sync/status/
     *
     * Get provider&#39;s sync status
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @return [SyncStatus]
     */
    @GET("sources/ldap/{slug}/sync/status/")
    suspend fun sourcesLdapSyncStatusRetrieve(@Path("slug") slug: kotlin.String): Response<SyncStatus>

    /**
     * PUT sources/ldap/{slug}/
     *
     * LDAP Source Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @param ldAPSourceRequest
     * @return [LDAPSource]
     */
    @PUT("sources/ldap/{slug}/")
    suspend fun sourcesLdapUpdate(@Path("slug") slug: kotlin.String, @Body ldAPSourceRequest: LDAPSourceRequest): Response<LDAPSource>

    /**
     * GET sources/ldap/{slug}/used_by/
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
    @GET("sources/ldap/{slug}/used_by/")
    suspend fun sourcesLdapUsedByList(@Path("slug") slug: kotlin.String): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST sources/oauth/
     *
     * Source Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param oauthSourceRequest
     * @return [OAuthSource]
     */
    @POST("sources/oauth/")
    suspend fun sourcesOauthCreate(@Body oauthSourceRequest: OAuthSourceRequest): Response<OAuthSource>

    /**
     * DELETE sources/oauth/{slug}/
     *
     * Source Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @return [Unit]
     */
    @DELETE("sources/oauth/{slug}/")
    suspend fun sourcesOauthDestroy(@Path("slug") slug: kotlin.String): Response<Unit>

    /**
     * GET sources/oauth/
     *
     * Source Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param accessTokenUrl  (optional)
     * @param additionalScopes  (optional)
     * @param authenticationFlow  (optional)
     * @param authorizationUrl  (optional)
     * @param consumerKey  (optional)
     * @param enabled  (optional)
     * @param enrollmentFlow  (optional)
     * @param groupMatchingMode  (optional)
     * @param hasJwks Only return sources with JWKS data (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param pbmUuid  (optional)
     * @param policyEngineMode  (optional)
     * @param profileUrl  (optional)
     * @param providerType  (optional)
     * @param requestTokenUrl  (optional)
     * @param search A search term. (optional)
     * @param slug  (optional)
     * @param userMatchingMode  (optional)
     * @return [PaginatedOAuthSourceList]
     */
    @GET("sources/oauth/")
    suspend fun sourcesOauthList(@Query("access_token_url") accessTokenUrl: kotlin.String? = null, @Query("additional_scopes") additionalScopes: kotlin.String? = null, @Query("authentication_flow") authenticationFlow: java.util.UUID? = null, @Query("authorization_url") authorizationUrl: kotlin.String? = null, @Query("consumer_key") consumerKey: kotlin.String? = null, @Query("enabled") enabled: kotlin.Boolean? = null, @Query("enrollment_flow") enrollmentFlow: java.util.UUID? = null, @Query("group_matching_mode") groupMatchingMode: GroupMatchingModeEnum? = null, @Query("has_jwks") hasJwks: kotlin.Boolean? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("pbm_uuid") pbmUuid: java.util.UUID? = null, @Query("policy_engine_mode") policyEngineMode: PolicyEngineMode? = null, @Query("profile_url") profileUrl: kotlin.String? = null, @Query("provider_type") providerType: kotlin.String? = null, @Query("request_token_url") requestTokenUrl: kotlin.String? = null, @Query("search") search: kotlin.String? = null, @Query("slug") slug: kotlin.String? = null, @Query("user_matching_mode") userMatchingMode: UserMatchingModeEnum? = null): Response<PaginatedOAuthSourceList>

    /**
     * PATCH sources/oauth/{slug}/
     *
     * Source Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @param patchedOAuthSourceRequest  (optional)
     * @return [OAuthSource]
     */
    @PATCH("sources/oauth/{slug}/")
    suspend fun sourcesOauthPartialUpdate(@Path("slug") slug: kotlin.String, @Body patchedOAuthSourceRequest: PatchedOAuthSourceRequest? = null): Response<OAuthSource>

    /**
     * GET sources/oauth/{slug}/
     *
     * Source Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @return [OAuthSource]
     */
    @GET("sources/oauth/{slug}/")
    suspend fun sourcesOauthRetrieve(@Path("slug") slug: kotlin.String): Response<OAuthSource>

    /**
     * GET sources/oauth/source_types/
     *
     * Get all creatable source types. If ?name is set, only returns the type for &lt;name&gt;. If &lt;name&gt; isn&#39;t found, returns the default type.
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param name  (optional)
     * @return [kotlin.collections.List<SourceType>]
     */
    @GET("sources/oauth/source_types/")
    suspend fun sourcesOauthSourceTypesList(@Query("name") name: kotlin.String? = null): Response<kotlin.collections.List<SourceType>>

    /**
     * PUT sources/oauth/{slug}/
     *
     * Source Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @param oauthSourceRequest
     * @return [OAuthSource]
     */
    @PUT("sources/oauth/{slug}/")
    suspend fun sourcesOauthUpdate(@Path("slug") slug: kotlin.String, @Body oauthSourceRequest: OAuthSourceRequest): Response<OAuthSource>

    /**
     * GET sources/oauth/{slug}/used_by/
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
    @GET("sources/oauth/{slug}/used_by/")
    suspend fun sourcesOauthUsedByList(@Path("slug") slug: kotlin.String): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST sources/plex/
     *
     * Plex source Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param plexSourceRequest
     * @return [PlexSource]
     */
    @POST("sources/plex/")
    suspend fun sourcesPlexCreate(@Body plexSourceRequest: PlexSourceRequest): Response<PlexSource>

    /**
     * DELETE sources/plex/{slug}/
     *
     * Plex source Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @return [Unit]
     */
    @DELETE("sources/plex/{slug}/")
    suspend fun sourcesPlexDestroy(@Path("slug") slug: kotlin.String): Response<Unit>

    /**
     * GET sources/plex/
     *
     * Plex source Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param allowFriends  (optional)
     * @param authenticationFlow  (optional)
     * @param clientId  (optional)
     * @param enabled  (optional)
     * @param enrollmentFlow  (optional)
     * @param groupMatchingMode  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param pbmUuid  (optional)
     * @param policyEngineMode  (optional)
     * @param search A search term. (optional)
     * @param slug  (optional)
     * @param userMatchingMode  (optional)
     * @return [PaginatedPlexSourceList]
     */
    @GET("sources/plex/")
    suspend fun sourcesPlexList(@Query("allow_friends") allowFriends: kotlin.Boolean? = null, @Query("authentication_flow") authenticationFlow: java.util.UUID? = null, @Query("client_id") clientId: kotlin.String? = null, @Query("enabled") enabled: kotlin.Boolean? = null, @Query("enrollment_flow") enrollmentFlow: java.util.UUID? = null, @Query("group_matching_mode") groupMatchingMode: GroupMatchingModeEnum? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("pbm_uuid") pbmUuid: java.util.UUID? = null, @Query("policy_engine_mode") policyEngineMode: PolicyEngineMode? = null, @Query("search") search: kotlin.String? = null, @Query("slug") slug: kotlin.String? = null, @Query("user_matching_mode") userMatchingMode: UserMatchingModeEnum? = null): Response<PaginatedPlexSourceList>

    /**
     * PATCH sources/plex/{slug}/
     *
     * Plex source Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @param patchedPlexSourceRequest  (optional)
     * @return [PlexSource]
     */
    @PATCH("sources/plex/{slug}/")
    suspend fun sourcesPlexPartialUpdate(@Path("slug") slug: kotlin.String, @Body patchedPlexSourceRequest: PatchedPlexSourceRequest? = null): Response<PlexSource>

    /**
     * POST sources/plex/redeem_token_authenticated/
     *
     * Redeem a plex token for an authenticated user, creating a connection
     * Responses:
     *  - 204: No response body
     *  - 400: Token not found
     *  - 403: Access denied
     *
     * @param plexTokenRedeemRequest
     * @param slug  (optional)
     * @return [Unit]
     */
    @POST("sources/plex/redeem_token_authenticated/")
    suspend fun sourcesPlexRedeemTokenAuthenticatedCreate(@Body plexTokenRedeemRequest: PlexTokenRedeemRequest, @Query("slug") slug: kotlin.String? = null): Response<Unit>

    /**
     * POST sources/plex/redeem_token/
     *
     * Redeem a plex token, check it&#39;s access to resources against what&#39;s allowed for the source, and redirect to an authentication/enrollment flow.
     * Responses:
     *  - 200:
     *  - 400: Token not found
     *  - 403: Access denied
     *
     * @param plexTokenRedeemRequest
     * @param slug  (optional)
     * @return [RedirectChallenge]
     */
    @POST("sources/plex/redeem_token/")
    suspend fun sourcesPlexRedeemTokenCreate(@Body plexTokenRedeemRequest: PlexTokenRedeemRequest, @Query("slug") slug: kotlin.String? = null): Response<RedirectChallenge>

    /**
     * GET sources/plex/{slug}/
     *
     * Plex source Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @return [PlexSource]
     */
    @GET("sources/plex/{slug}/")
    suspend fun sourcesPlexRetrieve(@Path("slug") slug: kotlin.String): Response<PlexSource>

    /**
     * PUT sources/plex/{slug}/
     *
     * Plex source Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @param plexSourceRequest
     * @return [PlexSource]
     */
    @PUT("sources/plex/{slug}/")
    suspend fun sourcesPlexUpdate(@Path("slug") slug: kotlin.String, @Body plexSourceRequest: PlexSourceRequest): Response<PlexSource>

    /**
     * GET sources/plex/{slug}/used_by/
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
    @GET("sources/plex/{slug}/used_by/")
    suspend fun sourcesPlexUsedByList(@Path("slug") slug: kotlin.String): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST sources/saml/
     *
     * SAMLSource Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param saMLSourceRequest
     * @return [SAMLSource]
     */
    @POST("sources/saml/")
    suspend fun sourcesSamlCreate(@Body saMLSourceRequest: SAMLSourceRequest): Response<SAMLSource>

    /**
     * DELETE sources/saml/{slug}/
     *
     * SAMLSource Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @return [Unit]
     */
    @DELETE("sources/saml/{slug}/")
    suspend fun sourcesSamlDestroy(@Path("slug") slug: kotlin.String): Response<Unit>

    /**
     * GET sources/saml/
     *
     * SAMLSource Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param allowIdpInitiated  (optional)
     * @param authenticationFlow  (optional)
     * @param bindingType  (optional)
     * @param digestAlgorithm  (optional)
     * @param enabled  (optional)
     * @param enrollmentFlow  (optional)
     * @param forceAuthn  (optional)
     * @param issuerOverride  (optional)
     * @param managed  (optional)
     * @param name  (optional)
     * @param nameIdPolicy  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param pbmUuid  (optional)
     * @param policyEngineMode  (optional)
     * @param preAuthenticationFlow  (optional)
     * @param search A search term. (optional)
     * @param signatureAlgorithm  (optional)
     * @param signedAssertion  (optional)
     * @param signedResponse  (optional)
     * @param signingKp  (optional)
     * @param sloUrl  (optional)
     * @param slug  (optional)
     * @param ssoUrl  (optional)
     * @param temporaryUserDeleteAfter  (optional)
     * @param userMatchingMode  (optional)
     * @param verificationKp  (optional)
     * @return [PaginatedSAMLSourceList]
     */
    @GET("sources/saml/")
    suspend fun sourcesSamlList(@Query("allow_idp_initiated") allowIdpInitiated: kotlin.Boolean? = null, @Query("authentication_flow") authenticationFlow: java.util.UUID? = null, @Query("binding_type") bindingType: BindingTypeEnum? = null, @Query("digest_algorithm") digestAlgorithm: DigestAlgorithmEnum? = null, @Query("enabled") enabled: kotlin.Boolean? = null, @Query("enrollment_flow") enrollmentFlow: java.util.UUID? = null, @Query("force_authn") forceAuthn: kotlin.Boolean? = null, @Query("issuer_override") issuerOverride: kotlin.String? = null, @Query("managed") managed: kotlin.String? = null, @Query("name") name: kotlin.String? = null, @Query("name_id_policy") nameIdPolicy: SAMLNameIDPolicyEnum? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("pbm_uuid") pbmUuid: java.util.UUID? = null, @Query("policy_engine_mode") policyEngineMode: PolicyEngineMode? = null, @Query("pre_authentication_flow") preAuthenticationFlow: java.util.UUID? = null, @Query("search") search: kotlin.String? = null, @Query("signature_algorithm") signatureAlgorithm: SignatureAlgorithmEnum? = null, @Query("signed_assertion") signedAssertion: kotlin.Boolean? = null, @Query("signed_response") signedResponse: kotlin.Boolean? = null, @Query("signing_kp") signingKp: java.util.UUID? = null, @Query("slo_url") sloUrl: kotlin.String? = null, @Query("slug") slug: kotlin.String? = null, @Query("sso_url") ssoUrl: kotlin.String? = null, @Query("temporary_user_delete_after") temporaryUserDeleteAfter: kotlin.String? = null, @Query("user_matching_mode") userMatchingMode: UserMatchingModeEnum? = null, @Query("verification_kp") verificationKp: java.util.UUID? = null): Response<PaginatedSAMLSourceList>

    /**
     * GET sources/saml/{slug}/metadata/
     *
     * Return metadata as XML string
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @return [SAMLMetadata]
     */
    @GET("sources/saml/{slug}/metadata/")
    suspend fun sourcesSamlMetadataRetrieve(@Path("slug") slug: kotlin.String): Response<SAMLMetadata>

    /**
     * PATCH sources/saml/{slug}/
     *
     * SAMLSource Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @param patchedSAMLSourceRequest  (optional)
     * @return [SAMLSource]
     */
    @PATCH("sources/saml/{slug}/")
    suspend fun sourcesSamlPartialUpdate(@Path("slug") slug: kotlin.String, @Body patchedSAMLSourceRequest: PatchedSAMLSourceRequest? = null): Response<SAMLSource>

    /**
     * GET sources/saml/{slug}/
     *
     * SAMLSource Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @return [SAMLSource]
     */
    @GET("sources/saml/{slug}/")
    suspend fun sourcesSamlRetrieve(@Path("slug") slug: kotlin.String): Response<SAMLSource>

    /**
     * PUT sources/saml/{slug}/
     *
     * SAMLSource Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @param saMLSourceRequest
     * @return [SAMLSource]
     */
    @PUT("sources/saml/{slug}/")
    suspend fun sourcesSamlUpdate(@Path("slug") slug: kotlin.String, @Body saMLSourceRequest: SAMLSourceRequest): Response<SAMLSource>

    /**
     * GET sources/saml/{slug}/used_by/
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
    @GET("sources/saml/{slug}/used_by/")
    suspend fun sourcesSamlUsedByList(@Path("slug") slug: kotlin.String): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST sources/scim/
     *
     * SCIMSource Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param scIMSourceRequest
     * @return [SCIMSource]
     */
    @POST("sources/scim/")
    suspend fun sourcesScimCreate(@Body scIMSourceRequest: SCIMSourceRequest): Response<SCIMSource>

    /**
     * DELETE sources/scim/{slug}/
     *
     * SCIMSource Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @return [Unit]
     */
    @DELETE("sources/scim/{slug}/")
    suspend fun sourcesScimDestroy(@Path("slug") slug: kotlin.String): Response<Unit>

    /**
     * POST sources/scim_groups/
     *
     * SCIMSourceGroup Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param scIMSourceGroupRequest
     * @return [SCIMSourceGroup]
     */
    @POST("sources/scim_groups/")
    suspend fun sourcesScimGroupsCreate(@Body scIMSourceGroupRequest: SCIMSourceGroupRequest): Response<SCIMSourceGroup>

    /**
     * DELETE sources/scim_groups/{id}/
     *
     * SCIMSourceGroup Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique value identifying this scim source group.
     * @return [Unit]
     */
    @DELETE("sources/scim_groups/{id}/")
    suspend fun sourcesScimGroupsDestroy(@Path("id") id: kotlin.String): Response<Unit>

    /**
     * GET sources/scim_groups/
     *
     * SCIMSourceGroup Viewset
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
     * @param search A search term. (optional)
     * @param sourceSlug  (optional)
     * @return [PaginatedSCIMSourceGroupList]
     */
    @GET("sources/scim_groups/")
    suspend fun sourcesScimGroupsList(@Query("group__group_uuid") groupGroupUuid: java.util.UUID? = null, @Query("group__name") groupName: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("source__slug") sourceSlug: kotlin.String? = null): Response<PaginatedSCIMSourceGroupList>

    /**
     * PATCH sources/scim_groups/{id}/
     *
     * SCIMSourceGroup Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique value identifying this scim source group.
     * @param patchedSCIMSourceGroupRequest  (optional)
     * @return [SCIMSourceGroup]
     */
    @PATCH("sources/scim_groups/{id}/")
    suspend fun sourcesScimGroupsPartialUpdate(@Path("id") id: kotlin.String, @Body patchedSCIMSourceGroupRequest: PatchedSCIMSourceGroupRequest? = null): Response<SCIMSourceGroup>

    /**
     * GET sources/scim_groups/{id}/
     *
     * SCIMSourceGroup Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique value identifying this scim source group.
     * @return [SCIMSourceGroup]
     */
    @GET("sources/scim_groups/{id}/")
    suspend fun sourcesScimGroupsRetrieve(@Path("id") id: kotlin.String): Response<SCIMSourceGroup>

    /**
     * PUT sources/scim_groups/{id}/
     *
     * SCIMSourceGroup Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique value identifying this scim source group.
     * @param scIMSourceGroupRequest
     * @return [SCIMSourceGroup]
     */
    @PUT("sources/scim_groups/{id}/")
    suspend fun sourcesScimGroupsUpdate(@Path("id") id: kotlin.String, @Body scIMSourceGroupRequest: SCIMSourceGroupRequest): Response<SCIMSourceGroup>

    /**
     * GET sources/scim_groups/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique value identifying this scim source group.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("sources/scim_groups/{id}/used_by/")
    suspend fun sourcesScimGroupsUsedByList(@Path("id") id: kotlin.String): Response<kotlin.collections.List<UsedBy>>

    /**
     * GET sources/scim/
     *
     * SCIMSource Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param pbmUuid  (optional)
     * @param search A search term. (optional)
     * @param slug  (optional)
     * @return [PaginatedSCIMSourceList]
     */
    @GET("sources/scim/")
    suspend fun sourcesScimList(@Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("pbm_uuid") pbmUuid: java.util.UUID? = null, @Query("search") search: kotlin.String? = null, @Query("slug") slug: kotlin.String? = null): Response<PaginatedSCIMSourceList>

    /**
     * PATCH sources/scim/{slug}/
     *
     * SCIMSource Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @param patchedSCIMSourceRequest  (optional)
     * @return [SCIMSource]
     */
    @PATCH("sources/scim/{slug}/")
    suspend fun sourcesScimPartialUpdate(@Path("slug") slug: kotlin.String, @Body patchedSCIMSourceRequest: PatchedSCIMSourceRequest? = null): Response<SCIMSource>

    /**
     * GET sources/scim/{slug}/
     *
     * SCIMSource Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @return [SCIMSource]
     */
    @GET("sources/scim/{slug}/")
    suspend fun sourcesScimRetrieve(@Path("slug") slug: kotlin.String): Response<SCIMSource>

    /**
     * PUT sources/scim/{slug}/
     *
     * SCIMSource Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @param scIMSourceRequest
     * @return [SCIMSource]
     */
    @PUT("sources/scim/{slug}/")
    suspend fun sourcesScimUpdate(@Path("slug") slug: kotlin.String, @Body scIMSourceRequest: SCIMSourceRequest): Response<SCIMSource>

    /**
     * GET sources/scim/{slug}/used_by/
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
    @GET("sources/scim/{slug}/used_by/")
    suspend fun sourcesScimUsedByList(@Path("slug") slug: kotlin.String): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST sources/scim_users/
     *
     * SCIMSourceUser Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param scIMSourceUserRequest
     * @return [SCIMSourceUser]
     */
    @POST("sources/scim_users/")
    suspend fun sourcesScimUsersCreate(@Body scIMSourceUserRequest: SCIMSourceUserRequest): Response<SCIMSourceUser>

    /**
     * DELETE sources/scim_users/{id}/
     *
     * SCIMSourceUser Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique value identifying this scim source user.
     * @return [Unit]
     */
    @DELETE("sources/scim_users/{id}/")
    suspend fun sourcesScimUsersDestroy(@Path("id") id: kotlin.String): Response<Unit>

    /**
     * GET sources/scim_users/
     *
     * SCIMSourceUser Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param sourceSlug  (optional)
     * @param userId  (optional)
     * @param userUsername  (optional)
     * @return [PaginatedSCIMSourceUserList]
     */
    @GET("sources/scim_users/")
    suspend fun sourcesScimUsersList(@Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("source__slug") sourceSlug: kotlin.String? = null, @Query("user__id") userId: kotlin.Int? = null, @Query("user__username") userUsername: kotlin.String? = null): Response<PaginatedSCIMSourceUserList>

    /**
     * PATCH sources/scim_users/{id}/
     *
     * SCIMSourceUser Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique value identifying this scim source user.
     * @param patchedSCIMSourceUserRequest  (optional)
     * @return [SCIMSourceUser]
     */
    @PATCH("sources/scim_users/{id}/")
    suspend fun sourcesScimUsersPartialUpdate(@Path("id") id: kotlin.String, @Body patchedSCIMSourceUserRequest: PatchedSCIMSourceUserRequest? = null): Response<SCIMSourceUser>

    /**
     * GET sources/scim_users/{id}/
     *
     * SCIMSourceUser Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique value identifying this scim source user.
     * @return [SCIMSourceUser]
     */
    @GET("sources/scim_users/{id}/")
    suspend fun sourcesScimUsersRetrieve(@Path("id") id: kotlin.String): Response<SCIMSourceUser>

    /**
     * PUT sources/scim_users/{id}/
     *
     * SCIMSourceUser Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique value identifying this scim source user.
     * @param scIMSourceUserRequest
     * @return [SCIMSourceUser]
     */
    @PUT("sources/scim_users/{id}/")
    suspend fun sourcesScimUsersUpdate(@Path("id") id: kotlin.String, @Body scIMSourceUserRequest: SCIMSourceUserRequest): Response<SCIMSourceUser>

    /**
     * GET sources/scim_users/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique value identifying this scim source user.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("sources/scim_users/{id}/used_by/")
    suspend fun sourcesScimUsersUsedByList(@Path("id") id: kotlin.String): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST sources/telegram/{slug}/connect_user/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 201:
     *  - 403: Access denied
     *  - 400:
     *
     * @param slug
     * @param telegramAuthRequest
     * @return [UserTelegramSourceConnection]
     */
    @POST("sources/telegram/{slug}/connect_user/")
    suspend fun sourcesTelegramConnectUserCreate(@Path("slug") slug: kotlin.String, @Body telegramAuthRequest: TelegramAuthRequest): Response<UserTelegramSourceConnection>

    /**
     * POST sources/telegram/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param telegramSourceRequest
     * @return [TelegramSource]
     */
    @POST("sources/telegram/")
    suspend fun sourcesTelegramCreate(@Body telegramSourceRequest: TelegramSourceRequest): Response<TelegramSource>

    /**
     * DELETE sources/telegram/{slug}/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @return [Unit]
     */
    @DELETE("sources/telegram/{slug}/")
    suspend fun sourcesTelegramDestroy(@Path("slug") slug: kotlin.String): Response<Unit>

    /**
     * GET sources/telegram/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param authenticationFlow  (optional)
     * @param botUsername  (optional)
     * @param enabled  (optional)
     * @param enrollmentFlow  (optional)
     * @param groupMatchingMode  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param pbmUuid  (optional)
     * @param policyEngineMode  (optional)
     * @param requestMessageAccess  (optional)
     * @param search A search term. (optional)
     * @param slug  (optional)
     * @param userMatchingMode  (optional)
     * @return [PaginatedTelegramSourceList]
     */
    @GET("sources/telegram/")
    suspend fun sourcesTelegramList(@Query("authentication_flow") authenticationFlow: java.util.UUID? = null, @Query("bot_username") botUsername: kotlin.String? = null, @Query("enabled") enabled: kotlin.Boolean? = null, @Query("enrollment_flow") enrollmentFlow: java.util.UUID? = null, @Query("group_matching_mode") groupMatchingMode: GroupMatchingModeEnum? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("pbm_uuid") pbmUuid: java.util.UUID? = null, @Query("policy_engine_mode") policyEngineMode: PolicyEngineMode? = null, @Query("request_message_access") requestMessageAccess: kotlin.Boolean? = null, @Query("search") search: kotlin.String? = null, @Query("slug") slug: kotlin.String? = null, @Query("user_matching_mode") userMatchingMode: UserMatchingModeEnum? = null): Response<PaginatedTelegramSourceList>

    /**
     * PATCH sources/telegram/{slug}/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @param patchedTelegramSourceRequest  (optional)
     * @return [TelegramSource]
     */
    @PATCH("sources/telegram/{slug}/")
    suspend fun sourcesTelegramPartialUpdate(@Path("slug") slug: kotlin.String, @Body patchedTelegramSourceRequest: PatchedTelegramSourceRequest? = null): Response<TelegramSource>

    /**
     * GET sources/telegram/{slug}/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @return [TelegramSource]
     */
    @GET("sources/telegram/{slug}/")
    suspend fun sourcesTelegramRetrieve(@Path("slug") slug: kotlin.String): Response<TelegramSource>

    /**
     * PUT sources/telegram/{slug}/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @param telegramSourceRequest
     * @return [TelegramSource]
     */
    @PUT("sources/telegram/{slug}/")
    suspend fun sourcesTelegramUpdate(@Path("slug") slug: kotlin.String, @Body telegramSourceRequest: TelegramSourceRequest): Response<TelegramSource>

    /**
     * GET sources/telegram/{slug}/used_by/
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
    @GET("sources/telegram/{slug}/used_by/")
    suspend fun sourcesTelegramUsedByList(@Path("slug") slug: kotlin.String): Response<kotlin.collections.List<UsedBy>>

    /**
     * DELETE sources/user_connections/all/{id}/
     *
     * User-source connection Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this user source connection.
     * @return [Unit]
     */
    @DELETE("sources/user_connections/all/{id}/")
    suspend fun sourcesUserConnectionsAllDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET sources/user_connections/all/
     *
     * User-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param sourceSlug  (optional)
     * @param user  (optional)
     * @return [PaginatedUserSourceConnectionList]
     */
    @GET("sources/user_connections/all/")
    suspend fun sourcesUserConnectionsAllList(@Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("source__slug") sourceSlug: kotlin.String? = null, @Query("user") user: kotlin.Int? = null): Response<PaginatedUserSourceConnectionList>

    /**
     * PATCH sources/user_connections/all/{id}/
     *
     * User-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this user source connection.
     * @param patchedUserSourceConnectionRequest  (optional)
     * @return [UserSourceConnection]
     */
    @PATCH("sources/user_connections/all/{id}/")
    suspend fun sourcesUserConnectionsAllPartialUpdate(@Path("id") id: kotlin.Int, @Body patchedUserSourceConnectionRequest: PatchedUserSourceConnectionRequest? = null): Response<UserSourceConnection>

    /**
     * GET sources/user_connections/all/{id}/
     *
     * User-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this user source connection.
     * @return [UserSourceConnection]
     */
    @GET("sources/user_connections/all/{id}/")
    suspend fun sourcesUserConnectionsAllRetrieve(@Path("id") id: kotlin.Int): Response<UserSourceConnection>

    /**
     * PUT sources/user_connections/all/{id}/
     *
     * User-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this user source connection.
     * @param userSourceConnectionRequest
     * @return [UserSourceConnection]
     */
    @PUT("sources/user_connections/all/{id}/")
    suspend fun sourcesUserConnectionsAllUpdate(@Path("id") id: kotlin.Int, @Body userSourceConnectionRequest: UserSourceConnectionRequest): Response<UserSourceConnection>

    /**
     * GET sources/user_connections/all/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this user source connection.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("sources/user_connections/all/{id}/used_by/")
    suspend fun sourcesUserConnectionsAllUsedByList(@Path("id") id: kotlin.Int): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST sources/user_connections/kerberos/
     *
     * User-source connection Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param userKerberosSourceConnectionRequest
     * @return [UserKerberosSourceConnection]
     */
    @POST("sources/user_connections/kerberos/")
    suspend fun sourcesUserConnectionsKerberosCreate(@Body userKerberosSourceConnectionRequest: UserKerberosSourceConnectionRequest): Response<UserKerberosSourceConnection>

    /**
     * DELETE sources/user_connections/kerberos/{id}/
     *
     * User-source connection Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User Kerberos Source Connection.
     * @return [Unit]
     */
    @DELETE("sources/user_connections/kerberos/{id}/")
    suspend fun sourcesUserConnectionsKerberosDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET sources/user_connections/kerberos/
     *
     * User-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param sourceSlug  (optional)
     * @param user  (optional)
     * @return [PaginatedUserKerberosSourceConnectionList]
     */
    @GET("sources/user_connections/kerberos/")
    suspend fun sourcesUserConnectionsKerberosList(@Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("source__slug") sourceSlug: kotlin.String? = null, @Query("user") user: kotlin.Int? = null): Response<PaginatedUserKerberosSourceConnectionList>

    /**
     * PATCH sources/user_connections/kerberos/{id}/
     *
     * User-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User Kerberos Source Connection.
     * @param patchedUserKerberosSourceConnectionRequest  (optional)
     * @return [UserKerberosSourceConnection]
     */
    @PATCH("sources/user_connections/kerberos/{id}/")
    suspend fun sourcesUserConnectionsKerberosPartialUpdate(@Path("id") id: kotlin.Int, @Body patchedUserKerberosSourceConnectionRequest: PatchedUserKerberosSourceConnectionRequest? = null): Response<UserKerberosSourceConnection>

    /**
     * GET sources/user_connections/kerberos/{id}/
     *
     * User-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User Kerberos Source Connection.
     * @return [UserKerberosSourceConnection]
     */
    @GET("sources/user_connections/kerberos/{id}/")
    suspend fun sourcesUserConnectionsKerberosRetrieve(@Path("id") id: kotlin.Int): Response<UserKerberosSourceConnection>

    /**
     * PUT sources/user_connections/kerberos/{id}/
     *
     * User-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User Kerberos Source Connection.
     * @param userKerberosSourceConnectionRequest
     * @return [UserKerberosSourceConnection]
     */
    @PUT("sources/user_connections/kerberos/{id}/")
    suspend fun sourcesUserConnectionsKerberosUpdate(@Path("id") id: kotlin.Int, @Body userKerberosSourceConnectionRequest: UserKerberosSourceConnectionRequest): Response<UserKerberosSourceConnection>

    /**
     * GET sources/user_connections/kerberos/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User Kerberos Source Connection.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("sources/user_connections/kerberos/{id}/used_by/")
    suspend fun sourcesUserConnectionsKerberosUsedByList(@Path("id") id: kotlin.Int): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST sources/user_connections/ldap/
     *
     * User-source connection Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param userLDAPSourceConnectionRequest
     * @return [UserLDAPSourceConnection]
     */
    @POST("sources/user_connections/ldap/")
    suspend fun sourcesUserConnectionsLdapCreate(@Body userLDAPSourceConnectionRequest: UserLDAPSourceConnectionRequest): Response<UserLDAPSourceConnection>

    /**
     * DELETE sources/user_connections/ldap/{id}/
     *
     * User-source connection Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User LDAP Source Connection.
     * @return [Unit]
     */
    @DELETE("sources/user_connections/ldap/{id}/")
    suspend fun sourcesUserConnectionsLdapDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET sources/user_connections/ldap/
     *
     * User-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param sourceSlug  (optional)
     * @param user  (optional)
     * @return [PaginatedUserLDAPSourceConnectionList]
     */
    @GET("sources/user_connections/ldap/")
    suspend fun sourcesUserConnectionsLdapList(@Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("source__slug") sourceSlug: kotlin.String? = null, @Query("user") user: kotlin.Int? = null): Response<PaginatedUserLDAPSourceConnectionList>

    /**
     * PATCH sources/user_connections/ldap/{id}/
     *
     * User-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User LDAP Source Connection.
     * @param patchedUserLDAPSourceConnectionRequest  (optional)
     * @return [UserLDAPSourceConnection]
     */
    @PATCH("sources/user_connections/ldap/{id}/")
    suspend fun sourcesUserConnectionsLdapPartialUpdate(@Path("id") id: kotlin.Int, @Body patchedUserLDAPSourceConnectionRequest: PatchedUserLDAPSourceConnectionRequest? = null): Response<UserLDAPSourceConnection>

    /**
     * GET sources/user_connections/ldap/{id}/
     *
     * User-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User LDAP Source Connection.
     * @return [UserLDAPSourceConnection]
     */
    @GET("sources/user_connections/ldap/{id}/")
    suspend fun sourcesUserConnectionsLdapRetrieve(@Path("id") id: kotlin.Int): Response<UserLDAPSourceConnection>

    /**
     * PUT sources/user_connections/ldap/{id}/
     *
     * User-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User LDAP Source Connection.
     * @param userLDAPSourceConnectionRequest
     * @return [UserLDAPSourceConnection]
     */
    @PUT("sources/user_connections/ldap/{id}/")
    suspend fun sourcesUserConnectionsLdapUpdate(@Path("id") id: kotlin.Int, @Body userLDAPSourceConnectionRequest: UserLDAPSourceConnectionRequest): Response<UserLDAPSourceConnection>

    /**
     * GET sources/user_connections/ldap/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User LDAP Source Connection.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("sources/user_connections/ldap/{id}/used_by/")
    suspend fun sourcesUserConnectionsLdapUsedByList(@Path("id") id: kotlin.Int): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST sources/user_connections/oauth/
     *
     * User-source connection Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param userOAuthSourceConnectionRequest
     * @return [UserOAuthSourceConnection]
     */
    @POST("sources/user_connections/oauth/")
    suspend fun sourcesUserConnectionsOauthCreate(@Body userOAuthSourceConnectionRequest: UserOAuthSourceConnectionRequest): Response<UserOAuthSourceConnection>

    /**
     * DELETE sources/user_connections/oauth/{id}/
     *
     * User-source connection Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User OAuth Source Connection.
     * @return [Unit]
     */
    @DELETE("sources/user_connections/oauth/{id}/")
    suspend fun sourcesUserConnectionsOauthDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET sources/user_connections/oauth/
     *
     * User-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param sourceSlug  (optional)
     * @param user  (optional)
     * @return [PaginatedUserOAuthSourceConnectionList]
     */
    @GET("sources/user_connections/oauth/")
    suspend fun sourcesUserConnectionsOauthList(@Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("source__slug") sourceSlug: kotlin.String? = null, @Query("user") user: kotlin.Int? = null): Response<PaginatedUserOAuthSourceConnectionList>

    /**
     * PATCH sources/user_connections/oauth/{id}/
     *
     * User-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User OAuth Source Connection.
     * @param patchedUserOAuthSourceConnectionRequest  (optional)
     * @return [UserOAuthSourceConnection]
     */
    @PATCH("sources/user_connections/oauth/{id}/")
    suspend fun sourcesUserConnectionsOauthPartialUpdate(@Path("id") id: kotlin.Int, @Body patchedUserOAuthSourceConnectionRequest: PatchedUserOAuthSourceConnectionRequest? = null): Response<UserOAuthSourceConnection>

    /**
     * GET sources/user_connections/oauth/{id}/
     *
     * User-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User OAuth Source Connection.
     * @return [UserOAuthSourceConnection]
     */
    @GET("sources/user_connections/oauth/{id}/")
    suspend fun sourcesUserConnectionsOauthRetrieve(@Path("id") id: kotlin.Int): Response<UserOAuthSourceConnection>

    /**
     * PUT sources/user_connections/oauth/{id}/
     *
     * User-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User OAuth Source Connection.
     * @param userOAuthSourceConnectionRequest
     * @return [UserOAuthSourceConnection]
     */
    @PUT("sources/user_connections/oauth/{id}/")
    suspend fun sourcesUserConnectionsOauthUpdate(@Path("id") id: kotlin.Int, @Body userOAuthSourceConnectionRequest: UserOAuthSourceConnectionRequest): Response<UserOAuthSourceConnection>

    /**
     * GET sources/user_connections/oauth/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User OAuth Source Connection.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("sources/user_connections/oauth/{id}/used_by/")
    suspend fun sourcesUserConnectionsOauthUsedByList(@Path("id") id: kotlin.Int): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST sources/user_connections/plex/
     *
     * User-source connection Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param userPlexSourceConnectionRequest
     * @return [UserPlexSourceConnection]
     */
    @POST("sources/user_connections/plex/")
    suspend fun sourcesUserConnectionsPlexCreate(@Body userPlexSourceConnectionRequest: UserPlexSourceConnectionRequest): Response<UserPlexSourceConnection>

    /**
     * DELETE sources/user_connections/plex/{id}/
     *
     * User-source connection Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User Plex Source Connection.
     * @return [Unit]
     */
    @DELETE("sources/user_connections/plex/{id}/")
    suspend fun sourcesUserConnectionsPlexDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET sources/user_connections/plex/
     *
     * User-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param sourceSlug  (optional)
     * @param user  (optional)
     * @return [PaginatedUserPlexSourceConnectionList]
     */
    @GET("sources/user_connections/plex/")
    suspend fun sourcesUserConnectionsPlexList(@Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("source__slug") sourceSlug: kotlin.String? = null, @Query("user") user: kotlin.Int? = null): Response<PaginatedUserPlexSourceConnectionList>

    /**
     * PATCH sources/user_connections/plex/{id}/
     *
     * User-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User Plex Source Connection.
     * @param patchedUserPlexSourceConnectionRequest  (optional)
     * @return [UserPlexSourceConnection]
     */
    @PATCH("sources/user_connections/plex/{id}/")
    suspend fun sourcesUserConnectionsPlexPartialUpdate(@Path("id") id: kotlin.Int, @Body patchedUserPlexSourceConnectionRequest: PatchedUserPlexSourceConnectionRequest? = null): Response<UserPlexSourceConnection>

    /**
     * GET sources/user_connections/plex/{id}/
     *
     * User-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User Plex Source Connection.
     * @return [UserPlexSourceConnection]
     */
    @GET("sources/user_connections/plex/{id}/")
    suspend fun sourcesUserConnectionsPlexRetrieve(@Path("id") id: kotlin.Int): Response<UserPlexSourceConnection>

    /**
     * PUT sources/user_connections/plex/{id}/
     *
     * User-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User Plex Source Connection.
     * @param userPlexSourceConnectionRequest
     * @return [UserPlexSourceConnection]
     */
    @PUT("sources/user_connections/plex/{id}/")
    suspend fun sourcesUserConnectionsPlexUpdate(@Path("id") id: kotlin.Int, @Body userPlexSourceConnectionRequest: UserPlexSourceConnectionRequest): Response<UserPlexSourceConnection>

    /**
     * GET sources/user_connections/plex/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User Plex Source Connection.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("sources/user_connections/plex/{id}/used_by/")
    suspend fun sourcesUserConnectionsPlexUsedByList(@Path("id") id: kotlin.Int): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST sources/user_connections/saml/
     *
     * User-source connection Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param userSAMLSourceConnectionRequest
     * @return [UserSAMLSourceConnection]
     */
    @POST("sources/user_connections/saml/")
    suspend fun sourcesUserConnectionsSamlCreate(@Body userSAMLSourceConnectionRequest: UserSAMLSourceConnectionRequest): Response<UserSAMLSourceConnection>

    /**
     * DELETE sources/user_connections/saml/{id}/
     *
     * User-source connection Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User SAML Source Connection.
     * @return [Unit]
     */
    @DELETE("sources/user_connections/saml/{id}/")
    suspend fun sourcesUserConnectionsSamlDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET sources/user_connections/saml/
     *
     * User-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param sourceSlug  (optional)
     * @param user  (optional)
     * @return [PaginatedUserSAMLSourceConnectionList]
     */
    @GET("sources/user_connections/saml/")
    suspend fun sourcesUserConnectionsSamlList(@Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("source__slug") sourceSlug: kotlin.String? = null, @Query("user") user: kotlin.Int? = null): Response<PaginatedUserSAMLSourceConnectionList>

    /**
     * PATCH sources/user_connections/saml/{id}/
     *
     * User-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User SAML Source Connection.
     * @param patchedUserSAMLSourceConnectionRequest  (optional)
     * @return [UserSAMLSourceConnection]
     */
    @PATCH("sources/user_connections/saml/{id}/")
    suspend fun sourcesUserConnectionsSamlPartialUpdate(@Path("id") id: kotlin.Int, @Body patchedUserSAMLSourceConnectionRequest: PatchedUserSAMLSourceConnectionRequest? = null): Response<UserSAMLSourceConnection>

    /**
     * GET sources/user_connections/saml/{id}/
     *
     * User-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User SAML Source Connection.
     * @return [UserSAMLSourceConnection]
     */
    @GET("sources/user_connections/saml/{id}/")
    suspend fun sourcesUserConnectionsSamlRetrieve(@Path("id") id: kotlin.Int): Response<UserSAMLSourceConnection>

    /**
     * PUT sources/user_connections/saml/{id}/
     *
     * User-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User SAML Source Connection.
     * @param userSAMLSourceConnectionRequest
     * @return [UserSAMLSourceConnection]
     */
    @PUT("sources/user_connections/saml/{id}/")
    suspend fun sourcesUserConnectionsSamlUpdate(@Path("id") id: kotlin.Int, @Body userSAMLSourceConnectionRequest: UserSAMLSourceConnectionRequest): Response<UserSAMLSourceConnection>

    /**
     * GET sources/user_connections/saml/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User SAML Source Connection.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("sources/user_connections/saml/{id}/used_by/")
    suspend fun sourcesUserConnectionsSamlUsedByList(@Path("id") id: kotlin.Int): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST sources/user_connections/telegram/
     *
     * User-source connection Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param userTelegramSourceConnectionRequest
     * @return [UserTelegramSourceConnection]
     */
    @POST("sources/user_connections/telegram/")
    suspend fun sourcesUserConnectionsTelegramCreate(@Body userTelegramSourceConnectionRequest: UserTelegramSourceConnectionRequest): Response<UserTelegramSourceConnection>

    /**
     * DELETE sources/user_connections/telegram/{id}/
     *
     * User-source connection Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User Telegram Source Connection.
     * @return [Unit]
     */
    @DELETE("sources/user_connections/telegram/{id}/")
    suspend fun sourcesUserConnectionsTelegramDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET sources/user_connections/telegram/
     *
     * User-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param sourceSlug  (optional)
     * @param user  (optional)
     * @return [PaginatedUserTelegramSourceConnectionList]
     */
    @GET("sources/user_connections/telegram/")
    suspend fun sourcesUserConnectionsTelegramList(@Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("source__slug") sourceSlug: kotlin.String? = null, @Query("user") user: kotlin.Int? = null): Response<PaginatedUserTelegramSourceConnectionList>

    /**
     * PATCH sources/user_connections/telegram/{id}/
     *
     * User-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User Telegram Source Connection.
     * @param patchedUserTelegramSourceConnectionRequest  (optional)
     * @return [UserTelegramSourceConnection]
     */
    @PATCH("sources/user_connections/telegram/{id}/")
    suspend fun sourcesUserConnectionsTelegramPartialUpdate(@Path("id") id: kotlin.Int, @Body patchedUserTelegramSourceConnectionRequest: PatchedUserTelegramSourceConnectionRequest? = null): Response<UserTelegramSourceConnection>

    /**
     * GET sources/user_connections/telegram/{id}/
     *
     * User-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User Telegram Source Connection.
     * @return [UserTelegramSourceConnection]
     */
    @GET("sources/user_connections/telegram/{id}/")
    suspend fun sourcesUserConnectionsTelegramRetrieve(@Path("id") id: kotlin.Int): Response<UserTelegramSourceConnection>

    /**
     * PUT sources/user_connections/telegram/{id}/
     *
     * User-source connection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User Telegram Source Connection.
     * @param userTelegramSourceConnectionRequest
     * @return [UserTelegramSourceConnection]
     */
    @PUT("sources/user_connections/telegram/{id}/")
    suspend fun sourcesUserConnectionsTelegramUpdate(@Path("id") id: kotlin.Int, @Body userTelegramSourceConnectionRequest: UserTelegramSourceConnectionRequest): Response<UserTelegramSourceConnection>

    /**
     * GET sources/user_connections/telegram/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this User Telegram Source Connection.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("sources/user_connections/telegram/{id}/used_by/")
    suspend fun sourcesUserConnectionsTelegramUsedByList(@Path("id") id: kotlin.Int): Response<kotlin.collections.List<UsedBy>>

}
