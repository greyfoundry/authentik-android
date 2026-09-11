package dev.greyfoundry.authentik.generated.api

import dev.greyfoundry.authentik.generated.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import dev.greyfoundry.authentik.generated.model.DockerServiceConnection
import dev.greyfoundry.authentik.generated.model.DockerServiceConnectionRequest
import dev.greyfoundry.authentik.generated.model.GenericError
import dev.greyfoundry.authentik.generated.model.KubernetesServiceConnection
import dev.greyfoundry.authentik.generated.model.KubernetesServiceConnectionRequest
import dev.greyfoundry.authentik.generated.model.LDAPCheckAccess
import dev.greyfoundry.authentik.generated.model.Outpost
import dev.greyfoundry.authentik.generated.model.OutpostDefaultConfig
import dev.greyfoundry.authentik.generated.model.OutpostHealth
import dev.greyfoundry.authentik.generated.model.OutpostRequest
import dev.greyfoundry.authentik.generated.model.PaginatedDockerServiceConnectionList
import dev.greyfoundry.authentik.generated.model.PaginatedKubernetesServiceConnectionList
import dev.greyfoundry.authentik.generated.model.PaginatedLDAPOutpostConfigList
import dev.greyfoundry.authentik.generated.model.PaginatedOutpostList
import dev.greyfoundry.authentik.generated.model.PaginatedProxyOutpostConfigList
import dev.greyfoundry.authentik.generated.model.PaginatedRadiusOutpostConfigList
import dev.greyfoundry.authentik.generated.model.PaginatedServiceConnectionList
import dev.greyfoundry.authentik.generated.model.PatchedDockerServiceConnectionRequest
import dev.greyfoundry.authentik.generated.model.PatchedKubernetesServiceConnectionRequest
import dev.greyfoundry.authentik.generated.model.PatchedOutpostRequest
import dev.greyfoundry.authentik.generated.model.RadiusCheckAccess
import dev.greyfoundry.authentik.generated.model.ServiceConnection
import dev.greyfoundry.authentik.generated.model.ServiceConnectionState
import dev.greyfoundry.authentik.generated.model.TypeCreate
import dev.greyfoundry.authentik.generated.model.UsedBy
import dev.greyfoundry.authentik.generated.model.ValidationError

interface OutpostsApi {
    /**
     * POST outposts/instances/
     *
     * Outpost Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param outpostRequest
     * @return [Outpost]
     */
    @POST("outposts/instances/")
    suspend fun outpostsInstancesCreate(@Body outpostRequest: OutpostRequest): Response<Outpost>

    /**
     * GET outposts/instances/default_settings/
     *
     * Global default outpost config
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @return [OutpostDefaultConfig]
     */
    @GET("outposts/instances/default_settings/")
    suspend fun outpostsInstancesDefaultSettingsRetrieve(): Response<OutpostDefaultConfig>

    /**
     * DELETE outposts/instances/{uuid}/
     *
     * Outpost Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Outpost.
     * @return [Unit]
     */
    @DELETE("outposts/instances/{uuid}/")
    suspend fun outpostsInstancesDestroy(@Path("uuid") uuid: java.util.UUID): Response<Unit>

    /**
     * GET outposts/instances/{uuid}/health/
     *
     * Get outposts current health
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Outpost.
     * @param managedIcontains  (optional)
     * @param managedIexact  (optional)
     * @param nameIcontains  (optional)
     * @param nameIexact  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param providersIsnull  (optional)
     * @param providersByPk  (optional)
     * @param search A search term. (optional)
     * @param serviceConnectionNameIcontains  (optional)
     * @param serviceConnectionNameIexact  (optional)
     * @return [kotlin.collections.List<OutpostHealth>]
     */
    @GET("outposts/instances/{uuid}/health/")
    suspend fun outpostsInstancesHealthList(@Path("uuid") uuid: java.util.UUID, @Query("managed__icontains") managedIcontains: kotlin.String? = null, @Query("managed__iexact") managedIexact: kotlin.String? = null, @Query("name__icontains") nameIcontains: kotlin.String? = null, @Query("name__iexact") nameIexact: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("providers__isnull") providersIsnull: kotlin.Boolean? = null, @Query("providers_by_pk") providersByPk: @JvmSuppressWildcards kotlin.collections.List<kotlin.Int>? = null, @Query("search") search: kotlin.String? = null, @Query("service_connection__name__icontains") serviceConnectionNameIcontains: kotlin.String? = null, @Query("service_connection__name__iexact") serviceConnectionNameIexact: kotlin.String? = null): Response<kotlin.collections.List<OutpostHealth>>

    /**
     * GET outposts/instances/
     *
     * Outpost Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param managedIcontains  (optional)
     * @param managedIexact  (optional)
     * @param nameIcontains  (optional)
     * @param nameIexact  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param providersIsnull  (optional)
     * @param providersByPk  (optional)
     * @param search A search term. (optional)
     * @param serviceConnectionNameIcontains  (optional)
     * @param serviceConnectionNameIexact  (optional)
     * @return [PaginatedOutpostList]
     */
    @GET("outposts/instances/")
    suspend fun outpostsInstancesList(@Query("managed__icontains") managedIcontains: kotlin.String? = null, @Query("managed__iexact") managedIexact: kotlin.String? = null, @Query("name__icontains") nameIcontains: kotlin.String? = null, @Query("name__iexact") nameIexact: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("providers__isnull") providersIsnull: kotlin.Boolean? = null, @Query("providers_by_pk") providersByPk: @JvmSuppressWildcards kotlin.collections.List<kotlin.Int>? = null, @Query("search") search: kotlin.String? = null, @Query("service_connection__name__icontains") serviceConnectionNameIcontains: kotlin.String? = null, @Query("service_connection__name__iexact") serviceConnectionNameIexact: kotlin.String? = null): Response<PaginatedOutpostList>

    /**
     * PATCH outposts/instances/{uuid}/
     *
     * Outpost Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Outpost.
     * @param patchedOutpostRequest  (optional)
     * @return [Outpost]
     */
    @PATCH("outposts/instances/{uuid}/")
    suspend fun outpostsInstancesPartialUpdate(@Path("uuid") uuid: java.util.UUID, @Body patchedOutpostRequest: PatchedOutpostRequest? = null): Response<Outpost>

    /**
     * GET outposts/instances/{uuid}/
     *
     * Outpost Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Outpost.
     * @return [Outpost]
     */
    @GET("outposts/instances/{uuid}/")
    suspend fun outpostsInstancesRetrieve(@Path("uuid") uuid: java.util.UUID): Response<Outpost>

    /**
     * PUT outposts/instances/{uuid}/
     *
     * Outpost Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Outpost.
     * @param outpostRequest
     * @return [Outpost]
     */
    @PUT("outposts/instances/{uuid}/")
    suspend fun outpostsInstancesUpdate(@Path("uuid") uuid: java.util.UUID, @Body outpostRequest: OutpostRequest): Response<Outpost>

    /**
     * GET outposts/instances/{uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Outpost.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("outposts/instances/{uuid}/used_by/")
    suspend fun outpostsInstancesUsedByList(@Path("uuid") uuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * GET outposts/ldap/{id}/check_access/
     *
     * Check access to a single application by slug
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this LDAP Provider.
     * @param appSlug  (optional)
     * @return [LDAPCheckAccess]
     */
    @GET("outposts/ldap/{id}/check_access/")
    suspend fun outpostsLdapAccessCheck(@Path("id") id: kotlin.Int, @Query("app_slug") appSlug: kotlin.String? = null): Response<LDAPCheckAccess>

    /**
     * GET outposts/ldap/
     *
     * LDAPProvider Viewset
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
     * @return [PaginatedLDAPOutpostConfigList]
     */
    @GET("outposts/ldap/")
    suspend fun outpostsLdapList(@Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedLDAPOutpostConfigList>

    /**
     * GET outposts/proxy/
     *
     * ProxyProvider Viewset
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
     * @return [PaginatedProxyOutpostConfigList]
     */
    @GET("outposts/proxy/")
    suspend fun outpostsProxyList(@Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedProxyOutpostConfigList>

    /**
     * GET outposts/radius/{id}/check_access/
     *
     * Check access to a single application by slug
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Radius Provider.
     * @param appSlug  (optional)
     * @return [RadiusCheckAccess]
     */
    @GET("outposts/radius/{id}/check_access/")
    suspend fun outpostsRadiusAccessCheck(@Path("id") id: kotlin.Int, @Query("app_slug") appSlug: kotlin.String? = null): Response<RadiusCheckAccess>

    /**
     * GET outposts/radius/
     *
     * RadiusProvider Viewset
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
     * @return [PaginatedRadiusOutpostConfigList]
     */
    @GET("outposts/radius/")
    suspend fun outpostsRadiusList(@Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedRadiusOutpostConfigList>

    /**
     * DELETE outposts/service_connections/all/{uuid}/
     *
     * ServiceConnection Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Outpost Service-Connection.
     * @return [Unit]
     */
    @DELETE("outposts/service_connections/all/{uuid}/")
    suspend fun outpostsServiceConnectionsAllDestroy(@Path("uuid") uuid: java.util.UUID): Response<Unit>

    /**
     * GET outposts/service_connections/all/
     *
     * ServiceConnection Viewset
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
     * @return [PaginatedServiceConnectionList]
     */
    @GET("outposts/service_connections/all/")
    suspend fun outpostsServiceConnectionsAllList(@Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedServiceConnectionList>

    /**
     * GET outposts/service_connections/all/{uuid}/
     *
     * ServiceConnection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Outpost Service-Connection.
     * @return [ServiceConnection]
     */
    @GET("outposts/service_connections/all/{uuid}/")
    suspend fun outpostsServiceConnectionsAllRetrieve(@Path("uuid") uuid: java.util.UUID): Response<ServiceConnection>

    /**
     * GET outposts/service_connections/all/{uuid}/state/
     *
     * Get the service connection&#39;s state
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Outpost Service-Connection.
     * @return [ServiceConnectionState]
     */
    @GET("outposts/service_connections/all/{uuid}/state/")
    suspend fun outpostsServiceConnectionsAllStateRetrieve(@Path("uuid") uuid: java.util.UUID): Response<ServiceConnectionState>

    /**
     * GET outposts/service_connections/all/types/
     *
     * Get all creatable types
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @return [kotlin.collections.List<TypeCreate>]
     */
    @GET("outposts/service_connections/all/types/")
    suspend fun outpostsServiceConnectionsAllTypesList(): Response<kotlin.collections.List<TypeCreate>>

    /**
     * GET outposts/service_connections/all/{uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Outpost Service-Connection.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("outposts/service_connections/all/{uuid}/used_by/")
    suspend fun outpostsServiceConnectionsAllUsedByList(@Path("uuid") uuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST outposts/service_connections/docker/
     *
     * DockerServiceConnection Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param dockerServiceConnectionRequest
     * @return [DockerServiceConnection]
     */
    @POST("outposts/service_connections/docker/")
    suspend fun outpostsServiceConnectionsDockerCreate(@Body dockerServiceConnectionRequest: DockerServiceConnectionRequest): Response<DockerServiceConnection>

    /**
     * DELETE outposts/service_connections/docker/{uuid}/
     *
     * DockerServiceConnection Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Docker Service-Connection.
     * @return [Unit]
     */
    @DELETE("outposts/service_connections/docker/{uuid}/")
    suspend fun outpostsServiceConnectionsDockerDestroy(@Path("uuid") uuid: java.util.UUID): Response<Unit>

    /**
     * GET outposts/service_connections/docker/
     *
     * DockerServiceConnection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param local  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param tlsAuthentication  (optional)
     * @param tlsVerification  (optional)
     * @param url  (optional)
     * @return [PaginatedDockerServiceConnectionList]
     */
    @GET("outposts/service_connections/docker/")
    suspend fun outpostsServiceConnectionsDockerList(@Query("local") local: kotlin.Boolean? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("tls_authentication") tlsAuthentication: java.util.UUID? = null, @Query("tls_verification") tlsVerification: java.util.UUID? = null, @Query("url") url: kotlin.String? = null): Response<PaginatedDockerServiceConnectionList>

    /**
     * PATCH outposts/service_connections/docker/{uuid}/
     *
     * DockerServiceConnection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Docker Service-Connection.
     * @param patchedDockerServiceConnectionRequest  (optional)
     * @return [DockerServiceConnection]
     */
    @PATCH("outposts/service_connections/docker/{uuid}/")
    suspend fun outpostsServiceConnectionsDockerPartialUpdate(@Path("uuid") uuid: java.util.UUID, @Body patchedDockerServiceConnectionRequest: PatchedDockerServiceConnectionRequest? = null): Response<DockerServiceConnection>

    /**
     * GET outposts/service_connections/docker/{uuid}/
     *
     * DockerServiceConnection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Docker Service-Connection.
     * @return [DockerServiceConnection]
     */
    @GET("outposts/service_connections/docker/{uuid}/")
    suspend fun outpostsServiceConnectionsDockerRetrieve(@Path("uuid") uuid: java.util.UUID): Response<DockerServiceConnection>

    /**
     * PUT outposts/service_connections/docker/{uuid}/
     *
     * DockerServiceConnection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Docker Service-Connection.
     * @param dockerServiceConnectionRequest
     * @return [DockerServiceConnection]
     */
    @PUT("outposts/service_connections/docker/{uuid}/")
    suspend fun outpostsServiceConnectionsDockerUpdate(@Path("uuid") uuid: java.util.UUID, @Body dockerServiceConnectionRequest: DockerServiceConnectionRequest): Response<DockerServiceConnection>

    /**
     * GET outposts/service_connections/docker/{uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Docker Service-Connection.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("outposts/service_connections/docker/{uuid}/used_by/")
    suspend fun outpostsServiceConnectionsDockerUsedByList(@Path("uuid") uuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST outposts/service_connections/kubernetes/
     *
     * KubernetesServiceConnection Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param kubernetesServiceConnectionRequest
     * @return [KubernetesServiceConnection]
     */
    @POST("outposts/service_connections/kubernetes/")
    suspend fun outpostsServiceConnectionsKubernetesCreate(@Body kubernetesServiceConnectionRequest: KubernetesServiceConnectionRequest): Response<KubernetesServiceConnection>

    /**
     * DELETE outposts/service_connections/kubernetes/{uuid}/
     *
     * KubernetesServiceConnection Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Kubernetes Service-Connection.
     * @return [Unit]
     */
    @DELETE("outposts/service_connections/kubernetes/{uuid}/")
    suspend fun outpostsServiceConnectionsKubernetesDestroy(@Path("uuid") uuid: java.util.UUID): Response<Unit>

    /**
     * GET outposts/service_connections/kubernetes/
     *
     * KubernetesServiceConnection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param local  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedKubernetesServiceConnectionList]
     */
    @GET("outposts/service_connections/kubernetes/")
    suspend fun outpostsServiceConnectionsKubernetesList(@Query("local") local: kotlin.Boolean? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedKubernetesServiceConnectionList>

    /**
     * PATCH outposts/service_connections/kubernetes/{uuid}/
     *
     * KubernetesServiceConnection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Kubernetes Service-Connection.
     * @param patchedKubernetesServiceConnectionRequest  (optional)
     * @return [KubernetesServiceConnection]
     */
    @PATCH("outposts/service_connections/kubernetes/{uuid}/")
    suspend fun outpostsServiceConnectionsKubernetesPartialUpdate(@Path("uuid") uuid: java.util.UUID, @Body patchedKubernetesServiceConnectionRequest: PatchedKubernetesServiceConnectionRequest? = null): Response<KubernetesServiceConnection>

    /**
     * GET outposts/service_connections/kubernetes/{uuid}/
     *
     * KubernetesServiceConnection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Kubernetes Service-Connection.
     * @return [KubernetesServiceConnection]
     */
    @GET("outposts/service_connections/kubernetes/{uuid}/")
    suspend fun outpostsServiceConnectionsKubernetesRetrieve(@Path("uuid") uuid: java.util.UUID): Response<KubernetesServiceConnection>

    /**
     * PUT outposts/service_connections/kubernetes/{uuid}/
     *
     * KubernetesServiceConnection Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Kubernetes Service-Connection.
     * @param kubernetesServiceConnectionRequest
     * @return [KubernetesServiceConnection]
     */
    @PUT("outposts/service_connections/kubernetes/{uuid}/")
    suspend fun outpostsServiceConnectionsKubernetesUpdate(@Path("uuid") uuid: java.util.UUID, @Body kubernetesServiceConnectionRequest: KubernetesServiceConnectionRequest): Response<KubernetesServiceConnection>

    /**
     * GET outposts/service_connections/kubernetes/{uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Kubernetes Service-Connection.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("outposts/service_connections/kubernetes/{uuid}/used_by/")
    suspend fun outpostsServiceConnectionsKubernetesUsedByList(@Path("uuid") uuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

}
