package dev.greyfoundry.authentik.generated.api

import dev.greyfoundry.authentik.generated.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import dev.greyfoundry.authentik.generated.model.Domain
import dev.greyfoundry.authentik.generated.model.DomainRequest
import dev.greyfoundry.authentik.generated.model.GenericError
import dev.greyfoundry.authentik.generated.model.PaginatedDomainList
import dev.greyfoundry.authentik.generated.model.PaginatedTenantList
import dev.greyfoundry.authentik.generated.model.PatchedDomainRequest
import dev.greyfoundry.authentik.generated.model.PatchedTenantRequest
import dev.greyfoundry.authentik.generated.model.Tenant
import dev.greyfoundry.authentik.generated.model.TenantAdminGroupRequestRequest
import dev.greyfoundry.authentik.generated.model.TenantRecoveryKeyRequestRequest
import dev.greyfoundry.authentik.generated.model.TenantRecoveryKeyResponse
import dev.greyfoundry.authentik.generated.model.TenantRequest
import dev.greyfoundry.authentik.generated.model.ValidationError

interface TenantsApi {
    /**
     * POST tenants/domains/
     *
     * Domain ViewSet
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param domainRequest
     * @return [Domain]
     */
    @POST("tenants/domains/")
    suspend fun tenantsDomainsCreate(@Body domainRequest: DomainRequest): Response<Domain>

    /**
     * DELETE tenants/domains/{id}/
     *
     * Domain ViewSet
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Domain.
     * @return [Unit]
     */
    @DELETE("tenants/domains/{id}/")
    suspend fun tenantsDomainsDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET tenants/domains/
     *
     * Domain ViewSet
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedDomainList]
     */
    @GET("tenants/domains/")
    suspend fun tenantsDomainsList(@Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedDomainList>

    /**
     * PATCH tenants/domains/{id}/
     *
     * Domain ViewSet
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Domain.
     * @param patchedDomainRequest  (optional)
     * @return [Domain]
     */
    @PATCH("tenants/domains/{id}/")
    suspend fun tenantsDomainsPartialUpdate(@Path("id") id: kotlin.Int, @Body patchedDomainRequest: PatchedDomainRequest? = null): Response<Domain>

    /**
     * GET tenants/domains/{id}/
     *
     * Domain ViewSet
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Domain.
     * @return [Domain]
     */
    @GET("tenants/domains/{id}/")
    suspend fun tenantsDomainsRetrieve(@Path("id") id: kotlin.Int): Response<Domain>

    /**
     * PUT tenants/domains/{id}/
     *
     * Domain ViewSet
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Domain.
     * @param domainRequest
     * @return [Domain]
     */
    @PUT("tenants/domains/{id}/")
    suspend fun tenantsDomainsUpdate(@Path("id") id: kotlin.Int, @Body domainRequest: DomainRequest): Response<Domain>

    /**
     * POST tenants/tenants/
     *
     * Tenant Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param tenantRequest
     * @return [Tenant]
     */
    @POST("tenants/tenants/")
    suspend fun tenantsTenantsCreate(@Body tenantRequest: TenantRequest): Response<Tenant>

    /**
     * POST tenants/tenants/{tenant_uuid}/create_admin_group/
     *
     * Create admin group and add user to it.
     * Responses:
     *  - 204: Group created successfully.
     *  - 400: Bad request
     *  - 404: User not found
     *  - 403:
     *
     * @param tenantUuid A UUID string identifying this Tenant.
     * @param tenantAdminGroupRequestRequest
     * @return [Unit]
     */
    @POST("tenants/tenants/{tenant_uuid}/create_admin_group/")
    suspend fun tenantsTenantsCreateAdminGroupCreate(@Path("tenant_uuid") tenantUuid: java.util.UUID, @Body tenantAdminGroupRequestRequest: TenantAdminGroupRequestRequest): Response<Unit>

    /**
     * POST tenants/tenants/{tenant_uuid}/create_recovery_key/
     *
     * Create recovery key for user.
     * Responses:
     *  - 200:
     *  - 400: Bad request
     *  - 404: User not found
     *  - 403:
     *
     * @param tenantUuid A UUID string identifying this Tenant.
     * @param tenantRecoveryKeyRequestRequest
     * @return [TenantRecoveryKeyResponse]
     */
    @POST("tenants/tenants/{tenant_uuid}/create_recovery_key/")
    suspend fun tenantsTenantsCreateRecoveryKeyCreate(@Path("tenant_uuid") tenantUuid: java.util.UUID, @Body tenantRecoveryKeyRequestRequest: TenantRecoveryKeyRequestRequest): Response<TenantRecoveryKeyResponse>

    /**
     * DELETE tenants/tenants/{tenant_uuid}/
     *
     * Tenant Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param tenantUuid A UUID string identifying this Tenant.
     * @return [Unit]
     */
    @DELETE("tenants/tenants/{tenant_uuid}/")
    suspend fun tenantsTenantsDestroy(@Path("tenant_uuid") tenantUuid: java.util.UUID): Response<Unit>

    /**
     * GET tenants/tenants/
     *
     * Tenant Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedTenantList]
     */
    @GET("tenants/tenants/")
    suspend fun tenantsTenantsList(@Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedTenantList>

    /**
     * PATCH tenants/tenants/{tenant_uuid}/
     *
     * Tenant Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param tenantUuid A UUID string identifying this Tenant.
     * @param patchedTenantRequest  (optional)
     * @return [Tenant]
     */
    @PATCH("tenants/tenants/{tenant_uuid}/")
    suspend fun tenantsTenantsPartialUpdate(@Path("tenant_uuid") tenantUuid: java.util.UUID, @Body patchedTenantRequest: PatchedTenantRequest? = null): Response<Tenant>

    /**
     * GET tenants/tenants/{tenant_uuid}/
     *
     * Tenant Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param tenantUuid A UUID string identifying this Tenant.
     * @return [Tenant]
     */
    @GET("tenants/tenants/{tenant_uuid}/")
    suspend fun tenantsTenantsRetrieve(@Path("tenant_uuid") tenantUuid: java.util.UUID): Response<Tenant>

    /**
     * PUT tenants/tenants/{tenant_uuid}/
     *
     * Tenant Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param tenantUuid A UUID string identifying this Tenant.
     * @param tenantRequest
     * @return [Tenant]
     */
    @PUT("tenants/tenants/{tenant_uuid}/")
    suspend fun tenantsTenantsUpdate(@Path("tenant_uuid") tenantUuid: java.util.UUID, @Body tenantRequest: TenantRequest): Response<Tenant>

}
