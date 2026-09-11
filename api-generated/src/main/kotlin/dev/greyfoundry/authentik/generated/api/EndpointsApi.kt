package dev.greyfoundry.authentik.generated.api

import dev.greyfoundry.authentik.generated.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import dev.greyfoundry.authentik.generated.model.AgentAuthenticationResponse
import dev.greyfoundry.authentik.generated.model.AgentConfig
import dev.greyfoundry.authentik.generated.model.AgentConnector
import dev.greyfoundry.authentik.generated.model.AgentConnectorRequest
import dev.greyfoundry.authentik.generated.model.AgentPSSODeviceRegistrationRequest
import dev.greyfoundry.authentik.generated.model.AgentPSSODeviceRegistrationResponse
import dev.greyfoundry.authentik.generated.model.AgentPSSOUserRegistrationRequest
import dev.greyfoundry.authentik.generated.model.AgentTokenResponse
import dev.greyfoundry.authentik.generated.model.AppleIndependentSecureEnclave
import dev.greyfoundry.authentik.generated.model.AppleIndependentSecureEnclaveRequest
import dev.greyfoundry.authentik.generated.model.Connector
import dev.greyfoundry.authentik.generated.model.DeviceAccessGroup
import dev.greyfoundry.authentik.generated.model.DeviceAccessGroupRequest
import dev.greyfoundry.authentik.generated.model.DeviceFactsRequest
import dev.greyfoundry.authentik.generated.model.DeviceSummary
import dev.greyfoundry.authentik.generated.model.DeviceUserBinding
import dev.greyfoundry.authentik.generated.model.DeviceUserBindingRequest
import dev.greyfoundry.authentik.generated.model.EndpointDevice
import dev.greyfoundry.authentik.generated.model.EndpointDeviceDetails
import dev.greyfoundry.authentik.generated.model.EndpointDeviceRequest
import dev.greyfoundry.authentik.generated.model.EnrollRequest
import dev.greyfoundry.authentik.generated.model.EnrollmentToken
import dev.greyfoundry.authentik.generated.model.EnrollmentTokenRequest
import dev.greyfoundry.authentik.generated.model.FleetConnector
import dev.greyfoundry.authentik.generated.model.FleetConnectorRequest
import dev.greyfoundry.authentik.generated.model.GenericError
import dev.greyfoundry.authentik.generated.model.GoogleChromeConnector
import dev.greyfoundry.authentik.generated.model.GoogleChromeConnectorRequest
import dev.greyfoundry.authentik.generated.model.MDMConfigRequest
import dev.greyfoundry.authentik.generated.model.MDMConfigResponse
import dev.greyfoundry.authentik.generated.model.PaginatedAgentConnectorList
import dev.greyfoundry.authentik.generated.model.PaginatedAppleIndependentSecureEnclaveList
import dev.greyfoundry.authentik.generated.model.PaginatedConnectorList
import dev.greyfoundry.authentik.generated.model.PaginatedDeviceAccessGroupList
import dev.greyfoundry.authentik.generated.model.PaginatedDeviceUserBindingList
import dev.greyfoundry.authentik.generated.model.PaginatedEndpointDeviceList
import dev.greyfoundry.authentik.generated.model.PaginatedEnrollmentTokenList
import dev.greyfoundry.authentik.generated.model.PaginatedFleetConnectorList
import dev.greyfoundry.authentik.generated.model.PaginatedGoogleChromeConnectorList
import dev.greyfoundry.authentik.generated.model.PatchedAgentConnectorRequest
import dev.greyfoundry.authentik.generated.model.PatchedAppleIndependentSecureEnclaveRequest
import dev.greyfoundry.authentik.generated.model.PatchedDeviceAccessGroupRequest
import dev.greyfoundry.authentik.generated.model.PatchedDeviceUserBindingRequest
import dev.greyfoundry.authentik.generated.model.PatchedEndpointDeviceRequest
import dev.greyfoundry.authentik.generated.model.PatchedEnrollmentTokenRequest
import dev.greyfoundry.authentik.generated.model.PatchedFleetConnectorRequest
import dev.greyfoundry.authentik.generated.model.PatchedGoogleChromeConnectorRequest
import dev.greyfoundry.authentik.generated.model.TokenView
import dev.greyfoundry.authentik.generated.model.TypeCreate
import dev.greyfoundry.authentik.generated.model.UsedBy
import dev.greyfoundry.authentik.generated.model.UserSelf
import dev.greyfoundry.authentik.generated.model.ValidationError

interface EndpointsApi {
    /**
     * GET endpoints/agents/connectors/agent_config/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @return [AgentConfig]
     */
    @GET("endpoints/agents/connectors/agent_config/")
    suspend fun endpointsAgentsConnectorsAgentConfigRetrieve(): Response<AgentConfig>

    /**
     * POST endpoints/agents/connectors/auth_fed/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 200:
     *  - 404: Device not found
     *  - 400:
     *  - 403:
     *
     * @param device
     * @return [AgentTokenResponse]
     */
    @POST("endpoints/agents/connectors/auth_fed/")
    suspend fun endpointsAgentsConnectorsAuthFedCreate(@Query("device") device: kotlin.String): Response<AgentTokenResponse>

    /**
     * POST endpoints/agents/connectors/auth_ia/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param loginHint  (optional)
     * @return [AgentAuthenticationResponse]
     */
    @POST("endpoints/agents/connectors/auth_ia/")
    suspend fun endpointsAgentsConnectorsAuthIaCreate(@Query("login_hint") loginHint: kotlin.String? = null): Response<AgentAuthenticationResponse>

    /**
     * POST endpoints/agents/connectors/check_in/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 204: Successfully checked in
     *  - 400:
     *  - 403:
     *
     * @param deviceFactsRequest  (optional)
     * @return [Unit]
     */
    @POST("endpoints/agents/connectors/check_in/")
    suspend fun endpointsAgentsConnectorsCheckInCreate(@Body deviceFactsRequest: DeviceFactsRequest? = null): Response<Unit>

    /**
     * POST endpoints/agents/connectors/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param agentConnectorRequest
     * @return [AgentConnector]
     */
    @POST("endpoints/agents/connectors/")
    suspend fun endpointsAgentsConnectorsCreate(@Body agentConnectorRequest: AgentConnectorRequest): Response<AgentConnector>

    /**
     * DELETE endpoints/agents/connectors/{connector_uuid}/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param connectorUuid A UUID string identifying this Agent Connector.
     * @return [Unit]
     */
    @DELETE("endpoints/agents/connectors/{connector_uuid}/")
    suspend fun endpointsAgentsConnectorsDestroy(@Path("connector_uuid") connectorUuid: java.util.UUID): Response<Unit>

    /**
     * POST endpoints/agents/connectors/enroll/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param enrollRequest
     * @return [AgentTokenResponse]
     */
    @POST("endpoints/agents/connectors/enroll/")
    suspend fun endpointsAgentsConnectorsEnrollCreate(@Body enrollRequest: EnrollRequest): Response<AgentTokenResponse>

    /**
     * GET endpoints/agents/connectors/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param enabled  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedAgentConnectorList]
     */
    @GET("endpoints/agents/connectors/")
    suspend fun endpointsAgentsConnectorsList(@Query("enabled") enabled: kotlin.Boolean? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedAgentConnectorList>

    /**
     * POST endpoints/agents/connectors/{connector_uuid}/mdm_config/
     *
     * Generate configuration for MDM systems to deploy authentik Agent
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param connectorUuid A UUID string identifying this Agent Connector.
     * @param mdMConfigRequest
     * @return [MDMConfigResponse]
     */
    @POST("endpoints/agents/connectors/{connector_uuid}/mdm_config/")
    suspend fun endpointsAgentsConnectorsMdmConfigCreate(@Path("connector_uuid") connectorUuid: java.util.UUID, @Body mdMConfigRequest: MDMConfigRequest): Response<MDMConfigResponse>

    /**
     * PATCH endpoints/agents/connectors/{connector_uuid}/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param connectorUuid A UUID string identifying this Agent Connector.
     * @param patchedAgentConnectorRequest  (optional)
     * @return [AgentConnector]
     */
    @PATCH("endpoints/agents/connectors/{connector_uuid}/")
    suspend fun endpointsAgentsConnectorsPartialUpdate(@Path("connector_uuid") connectorUuid: java.util.UUID, @Body patchedAgentConnectorRequest: PatchedAgentConnectorRequest? = null): Response<AgentConnector>

    /**
     * GET endpoints/agents/connectors/{connector_uuid}/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param connectorUuid A UUID string identifying this Agent Connector.
     * @return [AgentConnector]
     */
    @GET("endpoints/agents/connectors/{connector_uuid}/")
    suspend fun endpointsAgentsConnectorsRetrieve(@Path("connector_uuid") connectorUuid: java.util.UUID): Response<AgentConnector>

    /**
     * PUT endpoints/agents/connectors/{connector_uuid}/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param connectorUuid A UUID string identifying this Agent Connector.
     * @param agentConnectorRequest
     * @return [AgentConnector]
     */
    @PUT("endpoints/agents/connectors/{connector_uuid}/")
    suspend fun endpointsAgentsConnectorsUpdate(@Path("connector_uuid") connectorUuid: java.util.UUID, @Body agentConnectorRequest: AgentConnectorRequest): Response<AgentConnector>

    /**
     * GET endpoints/agents/connectors/{connector_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param connectorUuid A UUID string identifying this Agent Connector.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("endpoints/agents/connectors/{connector_uuid}/used_by/")
    suspend fun endpointsAgentsConnectorsUsedByList(@Path("connector_uuid") connectorUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST endpoints/agents/enrollment_tokens/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param enrollmentTokenRequest
     * @return [EnrollmentToken]
     */
    @POST("endpoints/agents/enrollment_tokens/")
    suspend fun endpointsAgentsEnrollmentTokensCreate(@Body enrollmentTokenRequest: EnrollmentTokenRequest): Response<EnrollmentToken>

    /**
     * DELETE endpoints/agents/enrollment_tokens/{token_uuid}/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param tokenUuid A UUID string identifying this Enrollment Token.
     * @return [Unit]
     */
    @DELETE("endpoints/agents/enrollment_tokens/{token_uuid}/")
    suspend fun endpointsAgentsEnrollmentTokensDestroy(@Path("token_uuid") tokenUuid: java.util.UUID): Response<Unit>

    /**
     * GET endpoints/agents/enrollment_tokens/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param connector  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param tokenUuid  (optional)
     * @return [PaginatedEnrollmentTokenList]
     */
    @GET("endpoints/agents/enrollment_tokens/")
    suspend fun endpointsAgentsEnrollmentTokensList(@Query("connector") connector: java.util.UUID? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("token_uuid") tokenUuid: java.util.UUID? = null): Response<PaginatedEnrollmentTokenList>

    /**
     * PATCH endpoints/agents/enrollment_tokens/{token_uuid}/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param tokenUuid A UUID string identifying this Enrollment Token.
     * @param patchedEnrollmentTokenRequest  (optional)
     * @return [EnrollmentToken]
     */
    @PATCH("endpoints/agents/enrollment_tokens/{token_uuid}/")
    suspend fun endpointsAgentsEnrollmentTokensPartialUpdate(@Path("token_uuid") tokenUuid: java.util.UUID, @Body patchedEnrollmentTokenRequest: PatchedEnrollmentTokenRequest? = null): Response<EnrollmentToken>

    /**
     * GET endpoints/agents/enrollment_tokens/{token_uuid}/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param tokenUuid A UUID string identifying this Enrollment Token.
     * @return [EnrollmentToken]
     */
    @GET("endpoints/agents/enrollment_tokens/{token_uuid}/")
    suspend fun endpointsAgentsEnrollmentTokensRetrieve(@Path("token_uuid") tokenUuid: java.util.UUID): Response<EnrollmentToken>

    /**
     * PUT endpoints/agents/enrollment_tokens/{token_uuid}/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param tokenUuid A UUID string identifying this Enrollment Token.
     * @param enrollmentTokenRequest
     * @return [EnrollmentToken]
     */
    @PUT("endpoints/agents/enrollment_tokens/{token_uuid}/")
    suspend fun endpointsAgentsEnrollmentTokensUpdate(@Path("token_uuid") tokenUuid: java.util.UUID, @Body enrollmentTokenRequest: EnrollmentTokenRequest): Response<EnrollmentToken>

    /**
     * GET endpoints/agents/enrollment_tokens/{token_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param tokenUuid A UUID string identifying this Enrollment Token.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("endpoints/agents/enrollment_tokens/{token_uuid}/used_by/")
    suspend fun endpointsAgentsEnrollmentTokensUsedByList(@Path("token_uuid") tokenUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * GET endpoints/agents/enrollment_tokens/{token_uuid}/view_key/
     *
     * Return token key and log access
     * Responses:
     *  - 200:
     *  - 404: Token not found or expired
     *  - 400:
     *  - 403:
     *
     * @param tokenUuid A UUID string identifying this Enrollment Token.
     * @return [TokenView]
     */
    @GET("endpoints/agents/enrollment_tokens/{token_uuid}/view_key/")
    suspend fun endpointsAgentsEnrollmentTokensViewKeyRetrieve(@Path("token_uuid") tokenUuid: java.util.UUID): Response<TokenView>

    /**
     * POST endpoints/agents/psso/ise/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param appleIndependentSecureEnclaveRequest
     * @return [AppleIndependentSecureEnclave]
     */
    @POST("endpoints/agents/psso/ise/")
    suspend fun endpointsAgentsPssoIseCreate(@Body appleIndependentSecureEnclaveRequest: AppleIndependentSecureEnclaveRequest): Response<AppleIndependentSecureEnclave>

    /**
     * DELETE endpoints/agents/psso/ise/{uuid}/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Apple Independent Secure Enclave.
     * @return [Unit]
     */
    @DELETE("endpoints/agents/psso/ise/{uuid}/")
    suspend fun endpointsAgentsPssoIseDestroy(@Path("uuid") uuid: java.util.UUID): Response<Unit>

    /**
     * GET endpoints/agents/psso/ise/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param appleEnclaveKeyId  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param user  (optional)
     * @return [PaginatedAppleIndependentSecureEnclaveList]
     */
    @GET("endpoints/agents/psso/ise/")
    suspend fun endpointsAgentsPssoIseList(@Query("apple_enclave_key_id") appleEnclaveKeyId: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("user") user: kotlin.Int? = null): Response<PaginatedAppleIndependentSecureEnclaveList>

    /**
     * PATCH endpoints/agents/psso/ise/{uuid}/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Apple Independent Secure Enclave.
     * @param patchedAppleIndependentSecureEnclaveRequest  (optional)
     * @return [AppleIndependentSecureEnclave]
     */
    @PATCH("endpoints/agents/psso/ise/{uuid}/")
    suspend fun endpointsAgentsPssoIsePartialUpdate(@Path("uuid") uuid: java.util.UUID, @Body patchedAppleIndependentSecureEnclaveRequest: PatchedAppleIndependentSecureEnclaveRequest? = null): Response<AppleIndependentSecureEnclave>

    /**
     * GET endpoints/agents/psso/ise/{uuid}/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Apple Independent Secure Enclave.
     * @return [AppleIndependentSecureEnclave]
     */
    @GET("endpoints/agents/psso/ise/{uuid}/")
    suspend fun endpointsAgentsPssoIseRetrieve(@Path("uuid") uuid: java.util.UUID): Response<AppleIndependentSecureEnclave>

    /**
     * PUT endpoints/agents/psso/ise/{uuid}/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Apple Independent Secure Enclave.
     * @param appleIndependentSecureEnclaveRequest
     * @return [AppleIndependentSecureEnclave]
     */
    @PUT("endpoints/agents/psso/ise/{uuid}/")
    suspend fun endpointsAgentsPssoIseUpdate(@Path("uuid") uuid: java.util.UUID, @Body appleIndependentSecureEnclaveRequest: AppleIndependentSecureEnclaveRequest): Response<AppleIndependentSecureEnclave>

    /**
     * GET endpoints/agents/psso/ise/{uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Apple Independent Secure Enclave.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("endpoints/agents/psso/ise/{uuid}/used_by/")
    suspend fun endpointsAgentsPssoIseUsedByList(@Path("uuid") uuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST endpoints/agents/psso/register/device/
     *
     *
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param agentPSSODeviceRegistrationRequest
     * @return [AgentPSSODeviceRegistrationResponse]
     */
    @POST("endpoints/agents/psso/register/device/")
    suspend fun endpointsAgentsPssoRegisterDeviceCreate(@Body agentPSSODeviceRegistrationRequest: AgentPSSODeviceRegistrationRequest): Response<AgentPSSODeviceRegistrationResponse>

    /**
     * POST endpoints/agents/psso/register/user/
     *
     *
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param agentPSSOUserRegistrationRequest
     * @return [UserSelf]
     */
    @POST("endpoints/agents/psso/register/user/")
    suspend fun endpointsAgentsPssoRegisterUserCreate(@Body agentPSSOUserRegistrationRequest: AgentPSSOUserRegistrationRequest): Response<UserSelf>

    /**
     * DELETE endpoints/connectors/{connector_uuid}/
     *
     * Connector Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param connectorUuid A UUID string identifying this connector.
     * @return [Unit]
     */
    @DELETE("endpoints/connectors/{connector_uuid}/")
    suspend fun endpointsConnectorsDestroy(@Path("connector_uuid") connectorUuid: java.util.UUID): Response<Unit>

    /**
     * GET endpoints/connectors/
     *
     * Connector Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedConnectorList]
     */
    @GET("endpoints/connectors/")
    suspend fun endpointsConnectorsList(@Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedConnectorList>

    /**
     * GET endpoints/connectors/{connector_uuid}/
     *
     * Connector Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param connectorUuid A UUID string identifying this connector.
     * @return [Connector]
     */
    @GET("endpoints/connectors/{connector_uuid}/")
    suspend fun endpointsConnectorsRetrieve(@Path("connector_uuid") connectorUuid: java.util.UUID): Response<Connector>

    /**
     * GET endpoints/connectors/types/
     *
     * Get all creatable types
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @return [kotlin.collections.List<TypeCreate>]
     */
    @GET("endpoints/connectors/types/")
    suspend fun endpointsConnectorsTypesList(): Response<kotlin.collections.List<TypeCreate>>

    /**
     * GET endpoints/connectors/{connector_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param connectorUuid A UUID string identifying this connector.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("endpoints/connectors/{connector_uuid}/used_by/")
    suspend fun endpointsConnectorsUsedByList(@Path("connector_uuid") connectorUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST endpoints/device_access_groups/
     *
     * DeviceAccessGroup Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param deviceAccessGroupRequest
     * @return [DeviceAccessGroup]
     */
    @POST("endpoints/device_access_groups/")
    suspend fun endpointsDeviceAccessGroupsCreate(@Body deviceAccessGroupRequest: DeviceAccessGroupRequest): Response<DeviceAccessGroup>

    /**
     * DELETE endpoints/device_access_groups/{pbm_uuid}/
     *
     * DeviceAccessGroup Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param pbmUuid A UUID string identifying this Device access group.
     * @return [Unit]
     */
    @DELETE("endpoints/device_access_groups/{pbm_uuid}/")
    suspend fun endpointsDeviceAccessGroupsDestroy(@Path("pbm_uuid") pbmUuid: java.util.UUID): Response<Unit>

    /**
     * GET endpoints/device_access_groups/
     *
     * DeviceAccessGroup Viewset
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
     * @return [PaginatedDeviceAccessGroupList]
     */
    @GET("endpoints/device_access_groups/")
    suspend fun endpointsDeviceAccessGroupsList(@Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("pbm_uuid") pbmUuid: java.util.UUID? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedDeviceAccessGroupList>

    /**
     * PATCH endpoints/device_access_groups/{pbm_uuid}/
     *
     * DeviceAccessGroup Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pbmUuid A UUID string identifying this Device access group.
     * @param patchedDeviceAccessGroupRequest  (optional)
     * @return [DeviceAccessGroup]
     */
    @PATCH("endpoints/device_access_groups/{pbm_uuid}/")
    suspend fun endpointsDeviceAccessGroupsPartialUpdate(@Path("pbm_uuid") pbmUuid: java.util.UUID, @Body patchedDeviceAccessGroupRequest: PatchedDeviceAccessGroupRequest? = null): Response<DeviceAccessGroup>

    /**
     * GET endpoints/device_access_groups/{pbm_uuid}/
     *
     * DeviceAccessGroup Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pbmUuid A UUID string identifying this Device access group.
     * @return [DeviceAccessGroup]
     */
    @GET("endpoints/device_access_groups/{pbm_uuid}/")
    suspend fun endpointsDeviceAccessGroupsRetrieve(@Path("pbm_uuid") pbmUuid: java.util.UUID): Response<DeviceAccessGroup>

    /**
     * PUT endpoints/device_access_groups/{pbm_uuid}/
     *
     * DeviceAccessGroup Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pbmUuid A UUID string identifying this Device access group.
     * @param deviceAccessGroupRequest
     * @return [DeviceAccessGroup]
     */
    @PUT("endpoints/device_access_groups/{pbm_uuid}/")
    suspend fun endpointsDeviceAccessGroupsUpdate(@Path("pbm_uuid") pbmUuid: java.util.UUID, @Body deviceAccessGroupRequest: DeviceAccessGroupRequest): Response<DeviceAccessGroup>

    /**
     * GET endpoints/device_access_groups/{pbm_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pbmUuid A UUID string identifying this Device access group.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("endpoints/device_access_groups/{pbm_uuid}/used_by/")
    suspend fun endpointsDeviceAccessGroupsUsedByList(@Path("pbm_uuid") pbmUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST endpoints/device_bindings/
     *
     * PolicyBinding Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param deviceUserBindingRequest
     * @return [DeviceUserBinding]
     */
    @POST("endpoints/device_bindings/")
    suspend fun endpointsDeviceBindingsCreate(@Body deviceUserBindingRequest: DeviceUserBindingRequest): Response<DeviceUserBinding>

    /**
     * DELETE endpoints/device_bindings/{policy_binding_uuid}/
     *
     * PolicyBinding Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param policyBindingUuid A UUID string identifying this Device User binding.
     * @return [Unit]
     */
    @DELETE("endpoints/device_bindings/{policy_binding_uuid}/")
    suspend fun endpointsDeviceBindingsDestroy(@Path("policy_binding_uuid") policyBindingUuid: java.util.UUID): Response<Unit>

    /**
     * GET endpoints/device_bindings/
     *
     * PolicyBinding Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param enabled  (optional)
     * @param order  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param policy  (optional)
     * @param policyIsnull  (optional)
     * @param search A search term. (optional)
     * @param target  (optional)
     * @param targetIn  (optional)
     * @param timeout  (optional)
     * @return [PaginatedDeviceUserBindingList]
     */
    @GET("endpoints/device_bindings/")
    suspend fun endpointsDeviceBindingsList(@Query("enabled") enabled: kotlin.Boolean? = null, @Query("order") order: kotlin.Int? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("policy") policy: java.util.UUID? = null, @Query("policy__isnull") policyIsnull: kotlin.Boolean? = null, @Query("search") search: kotlin.String? = null, @Query("target") target: java.util.UUID? = null, @Query("target_in") targetIn: @JvmSuppressWildcards kotlin.collections.List<java.util.UUID>? = null, @Query("timeout") timeout: kotlin.Int? = null): Response<PaginatedDeviceUserBindingList>

    /**
     * PATCH endpoints/device_bindings/{policy_binding_uuid}/
     *
     * PolicyBinding Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyBindingUuid A UUID string identifying this Device User binding.
     * @param patchedDeviceUserBindingRequest  (optional)
     * @return [DeviceUserBinding]
     */
    @PATCH("endpoints/device_bindings/{policy_binding_uuid}/")
    suspend fun endpointsDeviceBindingsPartialUpdate(@Path("policy_binding_uuid") policyBindingUuid: java.util.UUID, @Body patchedDeviceUserBindingRequest: PatchedDeviceUserBindingRequest? = null): Response<DeviceUserBinding>

    /**
     * GET endpoints/device_bindings/{policy_binding_uuid}/
     *
     * PolicyBinding Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyBindingUuid A UUID string identifying this Device User binding.
     * @return [DeviceUserBinding]
     */
    @GET("endpoints/device_bindings/{policy_binding_uuid}/")
    suspend fun endpointsDeviceBindingsRetrieve(@Path("policy_binding_uuid") policyBindingUuid: java.util.UUID): Response<DeviceUserBinding>

    /**
     * PUT endpoints/device_bindings/{policy_binding_uuid}/
     *
     * PolicyBinding Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyBindingUuid A UUID string identifying this Device User binding.
     * @param deviceUserBindingRequest
     * @return [DeviceUserBinding]
     */
    @PUT("endpoints/device_bindings/{policy_binding_uuid}/")
    suspend fun endpointsDeviceBindingsUpdate(@Path("policy_binding_uuid") policyBindingUuid: java.util.UUID, @Body deviceUserBindingRequest: DeviceUserBindingRequest): Response<DeviceUserBinding>

    /**
     * GET endpoints/device_bindings/{policy_binding_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyBindingUuid A UUID string identifying this Device User binding.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("endpoints/device_bindings/{policy_binding_uuid}/used_by/")
    suspend fun endpointsDeviceBindingsUsedByList(@Path("policy_binding_uuid") policyBindingUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * DELETE endpoints/devices/{device_uuid}/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param deviceUuid A UUID string identifying this Device.
     * @return [Unit]
     */
    @DELETE("endpoints/devices/{device_uuid}/")
    suspend fun endpointsDevicesDestroy(@Path("device_uuid") deviceUuid: java.util.UUID): Response<Unit>

    /**
     * GET endpoints/devices/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param identifier  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedEndpointDeviceList]
     */
    @GET("endpoints/devices/")
    suspend fun endpointsDevicesList(@Query("identifier") identifier: kotlin.String? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedEndpointDeviceList>

    /**
     * PATCH endpoints/devices/{device_uuid}/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param deviceUuid A UUID string identifying this Device.
     * @param patchedEndpointDeviceRequest  (optional)
     * @return [EndpointDevice]
     */
    @PATCH("endpoints/devices/{device_uuid}/")
    suspend fun endpointsDevicesPartialUpdate(@Path("device_uuid") deviceUuid: java.util.UUID, @Body patchedEndpointDeviceRequest: PatchedEndpointDeviceRequest? = null): Response<EndpointDevice>

    /**
     * GET endpoints/devices/{device_uuid}/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param deviceUuid A UUID string identifying this Device.
     * @return [EndpointDeviceDetails]
     */
    @GET("endpoints/devices/{device_uuid}/")
    suspend fun endpointsDevicesRetrieve(@Path("device_uuid") deviceUuid: java.util.UUID): Response<EndpointDeviceDetails>

    /**
     * GET endpoints/devices/summary/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @return [DeviceSummary]
     */
    @GET("endpoints/devices/summary/")
    suspend fun endpointsDevicesSummaryRetrieve(): Response<DeviceSummary>

    /**
     * PUT endpoints/devices/{device_uuid}/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param deviceUuid A UUID string identifying this Device.
     * @param endpointDeviceRequest
     * @return [EndpointDevice]
     */
    @PUT("endpoints/devices/{device_uuid}/")
    suspend fun endpointsDevicesUpdate(@Path("device_uuid") deviceUuid: java.util.UUID, @Body endpointDeviceRequest: EndpointDeviceRequest): Response<EndpointDevice>

    /**
     * GET endpoints/devices/{device_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param deviceUuid A UUID string identifying this Device.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("endpoints/devices/{device_uuid}/used_by/")
    suspend fun endpointsDevicesUsedByList(@Path("device_uuid") deviceUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST endpoints/fleet/connectors/
     *
     * FleetConnector Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param fleetConnectorRequest
     * @return [FleetConnector]
     */
    @POST("endpoints/fleet/connectors/")
    suspend fun endpointsFleetConnectorsCreate(@Body fleetConnectorRequest: FleetConnectorRequest): Response<FleetConnector>

    /**
     * DELETE endpoints/fleet/connectors/{connector_uuid}/
     *
     * FleetConnector Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param connectorUuid A UUID string identifying this Fleet Connector.
     * @return [Unit]
     */
    @DELETE("endpoints/fleet/connectors/{connector_uuid}/")
    suspend fun endpointsFleetConnectorsDestroy(@Path("connector_uuid") connectorUuid: java.util.UUID): Response<Unit>

    /**
     * GET endpoints/fleet/connectors/
     *
     * FleetConnector Viewset
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
     * @return [PaginatedFleetConnectorList]
     */
    @GET("endpoints/fleet/connectors/")
    suspend fun endpointsFleetConnectorsList(@Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedFleetConnectorList>

    /**
     * PATCH endpoints/fleet/connectors/{connector_uuid}/
     *
     * FleetConnector Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param connectorUuid A UUID string identifying this Fleet Connector.
     * @param patchedFleetConnectorRequest  (optional)
     * @return [FleetConnector]
     */
    @PATCH("endpoints/fleet/connectors/{connector_uuid}/")
    suspend fun endpointsFleetConnectorsPartialUpdate(@Path("connector_uuid") connectorUuid: java.util.UUID, @Body patchedFleetConnectorRequest: PatchedFleetConnectorRequest? = null): Response<FleetConnector>

    /**
     * GET endpoints/fleet/connectors/{connector_uuid}/
     *
     * FleetConnector Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param connectorUuid A UUID string identifying this Fleet Connector.
     * @return [FleetConnector]
     */
    @GET("endpoints/fleet/connectors/{connector_uuid}/")
    suspend fun endpointsFleetConnectorsRetrieve(@Path("connector_uuid") connectorUuid: java.util.UUID): Response<FleetConnector>

    /**
     * PUT endpoints/fleet/connectors/{connector_uuid}/
     *
     * FleetConnector Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param connectorUuid A UUID string identifying this Fleet Connector.
     * @param fleetConnectorRequest
     * @return [FleetConnector]
     */
    @PUT("endpoints/fleet/connectors/{connector_uuid}/")
    suspend fun endpointsFleetConnectorsUpdate(@Path("connector_uuid") connectorUuid: java.util.UUID, @Body fleetConnectorRequest: FleetConnectorRequest): Response<FleetConnector>

    /**
     * GET endpoints/fleet/connectors/{connector_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param connectorUuid A UUID string identifying this Fleet Connector.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("endpoints/fleet/connectors/{connector_uuid}/used_by/")
    suspend fun endpointsFleetConnectorsUsedByList(@Path("connector_uuid") connectorUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST endpoints/google_chrome/connectors/
     *
     * GoogleChromeConnector Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param googleChromeConnectorRequest
     * @return [GoogleChromeConnector]
     */
    @POST("endpoints/google_chrome/connectors/")
    suspend fun endpointsGoogleChromeConnectorsCreate(@Body googleChromeConnectorRequest: GoogleChromeConnectorRequest): Response<GoogleChromeConnector>

    /**
     * DELETE endpoints/google_chrome/connectors/{connector_uuid}/
     *
     * GoogleChromeConnector Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param connectorUuid A UUID string identifying this Google Device Trust Connector.
     * @return [Unit]
     */
    @DELETE("endpoints/google_chrome/connectors/{connector_uuid}/")
    suspend fun endpointsGoogleChromeConnectorsDestroy(@Path("connector_uuid") connectorUuid: java.util.UUID): Response<Unit>

    /**
     * GET endpoints/google_chrome/connectors/
     *
     * GoogleChromeConnector Viewset
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
     * @return [PaginatedGoogleChromeConnectorList]
     */
    @GET("endpoints/google_chrome/connectors/")
    suspend fun endpointsGoogleChromeConnectorsList(@Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedGoogleChromeConnectorList>

    /**
     * PATCH endpoints/google_chrome/connectors/{connector_uuid}/
     *
     * GoogleChromeConnector Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param connectorUuid A UUID string identifying this Google Device Trust Connector.
     * @param patchedGoogleChromeConnectorRequest  (optional)
     * @return [GoogleChromeConnector]
     */
    @PATCH("endpoints/google_chrome/connectors/{connector_uuid}/")
    suspend fun endpointsGoogleChromeConnectorsPartialUpdate(@Path("connector_uuid") connectorUuid: java.util.UUID, @Body patchedGoogleChromeConnectorRequest: PatchedGoogleChromeConnectorRequest? = null): Response<GoogleChromeConnector>

    /**
     * GET endpoints/google_chrome/connectors/{connector_uuid}/
     *
     * GoogleChromeConnector Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param connectorUuid A UUID string identifying this Google Device Trust Connector.
     * @return [GoogleChromeConnector]
     */
    @GET("endpoints/google_chrome/connectors/{connector_uuid}/")
    suspend fun endpointsGoogleChromeConnectorsRetrieve(@Path("connector_uuid") connectorUuid: java.util.UUID): Response<GoogleChromeConnector>

    /**
     * PUT endpoints/google_chrome/connectors/{connector_uuid}/
     *
     * GoogleChromeConnector Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param connectorUuid A UUID string identifying this Google Device Trust Connector.
     * @param googleChromeConnectorRequest
     * @return [GoogleChromeConnector]
     */
    @PUT("endpoints/google_chrome/connectors/{connector_uuid}/")
    suspend fun endpointsGoogleChromeConnectorsUpdate(@Path("connector_uuid") connectorUuid: java.util.UUID, @Body googleChromeConnectorRequest: GoogleChromeConnectorRequest): Response<GoogleChromeConnector>

    /**
     * GET endpoints/google_chrome/connectors/{connector_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param connectorUuid A UUID string identifying this Google Device Trust Connector.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("endpoints/google_chrome/connectors/{connector_uuid}/used_by/")
    suspend fun endpointsGoogleChromeConnectorsUsedByList(@Path("connector_uuid") connectorUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

}
