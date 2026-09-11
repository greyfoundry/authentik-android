package dev.greyfoundry.authentik.generated.api

import dev.greyfoundry.authentik.generated.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import dev.greyfoundry.authentik.generated.model.GenericError
import dev.greyfoundry.authentik.generated.model.InitialPermissions
import dev.greyfoundry.authentik.generated.model.InitialPermissionsRequest
import dev.greyfoundry.authentik.generated.model.PaginatedExtraRoleObjectPermissionList
import dev.greyfoundry.authentik.generated.model.PaginatedInitialPermissionsList
import dev.greyfoundry.authentik.generated.model.PaginatedPermissionList
import dev.greyfoundry.authentik.generated.model.PaginatedRoleAssignedObjectPermissionList
import dev.greyfoundry.authentik.generated.model.PaginatedRoleList
import dev.greyfoundry.authentik.generated.model.PatchedInitialPermissionsRequest
import dev.greyfoundry.authentik.generated.model.PatchedPermissionAssignRequest
import dev.greyfoundry.authentik.generated.model.PatchedRoleRequest
import dev.greyfoundry.authentik.generated.model.Permission
import dev.greyfoundry.authentik.generated.model.PermissionAssignRequest
import dev.greyfoundry.authentik.generated.model.PermissionAssignResult
import dev.greyfoundry.authentik.generated.model.Role
import dev.greyfoundry.authentik.generated.model.RoleRequest
import dev.greyfoundry.authentik.generated.model.UsedBy
import dev.greyfoundry.authentik.generated.model.UserAccountSerializerForRoleRequest
import dev.greyfoundry.authentik.generated.model.ValidationError

interface RbacApi {
    /**
     * POST rbac/initial_permissions/
     *
     * InitialPermissions viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param initialPermissionsRequest
     * @return [InitialPermissions]
     */
    @POST("rbac/initial_permissions/")
    suspend fun rbacInitialPermissionsCreate(@Body initialPermissionsRequest: InitialPermissionsRequest): Response<InitialPermissions>

    /**
     * DELETE rbac/initial_permissions/{id}/
     *
     * InitialPermissions viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Initial Permissions.
     * @return [Unit]
     */
    @DELETE("rbac/initial_permissions/{id}/")
    suspend fun rbacInitialPermissionsDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET rbac/initial_permissions/
     *
     * InitialPermissions viewset
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
     * @return [PaginatedInitialPermissionsList]
     */
    @GET("rbac/initial_permissions/")
    suspend fun rbacInitialPermissionsList(@Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedInitialPermissionsList>

    /**
     * PATCH rbac/initial_permissions/{id}/
     *
     * InitialPermissions viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Initial Permissions.
     * @param patchedInitialPermissionsRequest  (optional)
     * @return [InitialPermissions]
     */
    @PATCH("rbac/initial_permissions/{id}/")
    suspend fun rbacInitialPermissionsPartialUpdate(@Path("id") id: kotlin.Int, @Body patchedInitialPermissionsRequest: PatchedInitialPermissionsRequest? = null): Response<InitialPermissions>

    /**
     * GET rbac/initial_permissions/{id}/
     *
     * InitialPermissions viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Initial Permissions.
     * @return [InitialPermissions]
     */
    @GET("rbac/initial_permissions/{id}/")
    suspend fun rbacInitialPermissionsRetrieve(@Path("id") id: kotlin.Int): Response<InitialPermissions>

    /**
     * PUT rbac/initial_permissions/{id}/
     *
     * InitialPermissions viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Initial Permissions.
     * @param initialPermissionsRequest
     * @return [InitialPermissions]
     */
    @PUT("rbac/initial_permissions/{id}/")
    suspend fun rbacInitialPermissionsUpdate(@Path("id") id: kotlin.Int, @Body initialPermissionsRequest: InitialPermissionsRequest): Response<InitialPermissions>

    /**
     * GET rbac/initial_permissions/{id}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Initial Permissions.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("rbac/initial_permissions/{id}/used_by/")
    suspend fun rbacInitialPermissionsUsedByList(@Path("id") id: kotlin.Int): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST rbac/permissions/assigned_by_roles/{uuid}/assign/
     *
     * Assign permission(s) to role. When &#x60;object_pk&#x60; is set, the permissions are only assigned to the specific object, otherwise they are assigned globally.
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Role.
     * @param permissionAssignRequest
     * @return [kotlin.collections.List<PermissionAssignResult>]
     */
    @POST("rbac/permissions/assigned_by_roles/{uuid}/assign/")
    suspend fun rbacPermissionsAssignedByRolesAssign(@Path("uuid") uuid: java.util.UUID, @Body permissionAssignRequest: PermissionAssignRequest): Response<kotlin.collections.List<PermissionAssignResult>>

    /**
     * GET rbac/permissions/assigned_by_roles/
     *
     * Get assigned object permissions for a single object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param model
     * @param objectPk  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedRoleAssignedObjectPermissionList]
     */
    @GET("rbac/permissions/assigned_by_roles/")
    suspend fun rbacPermissionsAssignedByRolesList(@Query("model") model: kotlin.String, @Query("object_pk") objectPk: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedRoleAssignedObjectPermissionList>

    /**
     * PATCH rbac/permissions/assigned_by_roles/{uuid}/unassign/
     *
     * Unassign permission(s) to role. When &#x60;object_pk&#x60; is set, the permissions are only assigned to the specific object, otherwise they are assigned globally.
     * Responses:
     *  - 204: Successfully unassigned
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Role.
     * @param patchedPermissionAssignRequest  (optional)
     * @return [Unit]
     */
    @PATCH("rbac/permissions/assigned_by_roles/{uuid}/unassign/")
    suspend fun rbacPermissionsAssignedByRolesUnassignPartialUpdate(@Path("uuid") uuid: java.util.UUID, @Body patchedPermissionAssignRequest: PatchedPermissionAssignRequest? = null): Response<Unit>

    /**
     * GET rbac/permissions/
     *
     * Read-only list of all permissions, filterable by model and app
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param codename  (optional)
     * @param contentTypeAppLabel  (optional)
     * @param contentTypeModel  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param role  (optional)
     * @param search A search term. (optional)
     * @return [PaginatedPermissionList]
     */
    @GET("rbac/permissions/")
    suspend fun rbacPermissionsList(@Query("codename") codename: kotlin.String? = null, @Query("content_type__app_label") contentTypeAppLabel: kotlin.String? = null, @Query("content_type__model") contentTypeModel: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("role") role: kotlin.String? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedPermissionList>

    /**
     * GET rbac/permissions/{id}/
     *
     * Read-only list of all permissions, filterable by model and app
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this permission.
     * @return [Permission]
     */
    @GET("rbac/permissions/{id}/")
    suspend fun rbacPermissionsRetrieve(@Path("id") id: kotlin.Int): Response<Permission>

    /**
     * GET rbac/permissions/roles/
     *
     * Get a role&#39;s assigned object permissions
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param uuid  (optional)
     * @return [PaginatedExtraRoleObjectPermissionList]
     */
    @GET("rbac/permissions/roles/")
    suspend fun rbacPermissionsRolesList(@Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("uuid") uuid: java.util.UUID? = null): Response<PaginatedExtraRoleObjectPermissionList>

    /**
     * POST rbac/roles/{uuid}/add_user/
     *
     * Add user to role
     * Responses:
     *  - 204: User added
     *  - 404: User not found
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Role.
     * @param userAccountSerializerForRoleRequest
     * @return [Unit]
     */
    @POST("rbac/roles/{uuid}/add_user/")
    suspend fun rbacRolesAddUserCreate(@Path("uuid") uuid: java.util.UUID, @Body userAccountSerializerForRoleRequest: UserAccountSerializerForRoleRequest): Response<Unit>

    /**
     * POST rbac/roles/
     *
     * Role viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param roleRequest
     * @return [Role]
     */
    @POST("rbac/roles/")
    suspend fun rbacRolesCreate(@Body roleRequest: RoleRequest): Response<Role>

    /**
     * DELETE rbac/roles/{uuid}/
     *
     * Role viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Role.
     * @return [Unit]
     */
    @DELETE("rbac/roles/{uuid}/")
    suspend fun rbacRolesDestroy(@Path("uuid") uuid: java.util.UUID): Response<Unit>

    /**
     * GET rbac/roles/
     *
     * Role viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param groups  (optional)
     * @param inherited Include inherited roles (requires users or groups filter) (optional)
     * @param managed  (optional)
     * @param managedIsnull  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param users  (optional)
     * @return [PaginatedRoleList]
     */
    @GET("rbac/roles/")
    suspend fun rbacRolesList(@Query("groups") groups: java.util.UUID? = null, @Query("inherited") inherited: kotlin.Boolean? = null, @Query("managed") managed: @JvmSuppressWildcards kotlin.collections.List<kotlin.String>? = null, @Query("managed__isnull") managedIsnull: kotlin.Boolean? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("users") users: kotlin.Int? = null): Response<PaginatedRoleList>

    /**
     * PATCH rbac/roles/{uuid}/
     *
     * Role viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Role.
     * @param patchedRoleRequest  (optional)
     * @return [Role]
     */
    @PATCH("rbac/roles/{uuid}/")
    suspend fun rbacRolesPartialUpdate(@Path("uuid") uuid: java.util.UUID, @Body patchedRoleRequest: PatchedRoleRequest? = null): Response<Role>

    /**
     * POST rbac/roles/{uuid}/remove_user/
     *
     * Remove user from role
     * Responses:
     *  - 204: User removed
     *  - 404: User not found
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Role.
     * @param userAccountSerializerForRoleRequest
     * @return [Unit]
     */
    @POST("rbac/roles/{uuid}/remove_user/")
    suspend fun rbacRolesRemoveUserCreate(@Path("uuid") uuid: java.util.UUID, @Body userAccountSerializerForRoleRequest: UserAccountSerializerForRoleRequest): Response<Unit>

    /**
     * GET rbac/roles/{uuid}/
     *
     * Role viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Role.
     * @return [Role]
     */
    @GET("rbac/roles/{uuid}/")
    suspend fun rbacRolesRetrieve(@Path("uuid") uuid: java.util.UUID): Response<Role>

    /**
     * PUT rbac/roles/{uuid}/
     *
     * Role viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Role.
     * @param roleRequest
     * @return [Role]
     */
    @PUT("rbac/roles/{uuid}/")
    suspend fun rbacRolesUpdate(@Path("uuid") uuid: java.util.UUID, @Body roleRequest: RoleRequest): Response<Role>

    /**
     * GET rbac/roles/{uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Role.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("rbac/roles/{uuid}/used_by/")
    suspend fun rbacRolesUsedByList(@Path("uuid") uuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

}
