package dev.greyfoundry.authentik.generated.api

import dev.greyfoundry.authentik.generated.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import dev.greyfoundry.authentik.generated.model.Agent
import dev.greyfoundry.authentik.generated.model.AgentCreateRequest
import dev.greyfoundry.authentik.generated.model.AgentCreated
import dev.greyfoundry.authentik.generated.model.AgentRequest
import dev.greyfoundry.authentik.generated.model.GenericError
import dev.greyfoundry.authentik.generated.model.PaginatedAgentList
import dev.greyfoundry.authentik.generated.model.PatchedAgentRequest
import dev.greyfoundry.authentik.generated.model.ValidationError

interface AgentsApi {
    /**
     * POST agents/agents/
     *
     * Admin-provisioned delegate identities. An admin creates a Agent for a given parent user, then grants it access the same way as any other User -- ordinary PolicyBindings pointed at whatever it needs.
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param agentCreateRequest  (optional)
     * @return [AgentCreated]
     */
    @POST("agents/agents/")
    suspend fun agentsAgentsCreate(@Body agentCreateRequest: AgentCreateRequest? = null): Response<AgentCreated>

    /**
     * DELETE agents/agents/{id}/
     *
     * Admin-provisioned delegate identities. An admin creates a Agent for a given parent user, then grants it access the same way as any other User -- ordinary PolicyBindings pointed at whatever it needs.
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Agent.
     * @return [Unit]
     */
    @DELETE("agents/agents/{id}/")
    suspend fun agentsAgentsDestroy(@Path("id") id: kotlin.Int): Response<Unit>

    /**
     * GET agents/agents/
     *
     * Admin-provisioned delegate identities. An admin creates a Agent for a given parent user, then grants it access the same way as any other User -- ordinary PolicyBindings pointed at whatever it needs.
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param parent  (optional)
     * @param search A search term. (optional)
     * @return [PaginatedAgentList]
     */
    @GET("agents/agents/")
    suspend fun agentsAgentsList(@Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("parent") parent: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedAgentList>

    /**
     * PATCH agents/agents/{id}/
     *
     * Admin-provisioned delegate identities. An admin creates a Agent for a given parent user, then grants it access the same way as any other User -- ordinary PolicyBindings pointed at whatever it needs.
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Agent.
     * @param patchedAgentRequest  (optional)
     * @return [Agent]
     */
    @PATCH("agents/agents/{id}/")
    suspend fun agentsAgentsPartialUpdate(@Path("id") id: kotlin.Int, @Body patchedAgentRequest: PatchedAgentRequest? = null): Response<Agent>

    /**
     * GET agents/agents/{id}/
     *
     * Admin-provisioned delegate identities. An admin creates a Agent for a given parent user, then grants it access the same way as any other User -- ordinary PolicyBindings pointed at whatever it needs.
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Agent.
     * @return [Agent]
     */
    @GET("agents/agents/{id}/")
    suspend fun agentsAgentsRetrieve(@Path("id") id: kotlin.Int): Response<Agent>

    /**
     * PUT agents/agents/{id}/
     *
     * Admin-provisioned delegate identities. An admin creates a Agent for a given parent user, then grants it access the same way as any other User -- ordinary PolicyBindings pointed at whatever it needs.
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Agent.
     * @param agentRequest
     * @return [Agent]
     */
    @PUT("agents/agents/{id}/")
    suspend fun agentsAgentsUpdate(@Path("id") id: kotlin.Int, @Body agentRequest: AgentRequest): Response<Agent>

}
