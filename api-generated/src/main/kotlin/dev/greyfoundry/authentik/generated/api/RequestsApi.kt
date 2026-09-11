package dev.greyfoundry.authentik.generated.api

import dev.greyfoundry.authentik.generated.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import dev.greyfoundry.authentik.generated.model.AgentGrantRequestCreateRequest
import dev.greyfoundry.authentik.generated.model.AgentGrantRequestCreated
import dev.greyfoundry.authentik.generated.model.GenericError
import dev.greyfoundry.authentik.generated.model.GrantRequest
import dev.greyfoundry.authentik.generated.model.GrantRequestCreateRequest
import dev.greyfoundry.authentik.generated.model.Link
import dev.greyfoundry.authentik.generated.model.PaginatedGrantRequestList
import dev.greyfoundry.authentik.generated.model.PaginatedRequestRuleBindingList
import dev.greyfoundry.authentik.generated.model.PaginatedRequestRuleChildBindingList
import dev.greyfoundry.authentik.generated.model.PaginatedRequestRuleList
import dev.greyfoundry.authentik.generated.model.PatchedGrantRequestFulfillRequest
import dev.greyfoundry.authentik.generated.model.PatchedRequestRuleBindingRequest
import dev.greyfoundry.authentik.generated.model.PatchedRequestRuleChildBindingRequest
import dev.greyfoundry.authentik.generated.model.PatchedRequestRuleRequest
import dev.greyfoundry.authentik.generated.model.RequestRule
import dev.greyfoundry.authentik.generated.model.RequestRuleBinding
import dev.greyfoundry.authentik.generated.model.RequestRuleBindingRequest
import dev.greyfoundry.authentik.generated.model.RequestRuleChildBinding
import dev.greyfoundry.authentik.generated.model.RequestRuleChildBindingRequest
import dev.greyfoundry.authentik.generated.model.RequestRuleRequest
import dev.greyfoundry.authentik.generated.model.RequestStatus
import dev.greyfoundry.authentik.generated.model.UsedBy
import dev.greyfoundry.authentik.generated.model.ValidationError

interface RequestsApi {
    /**
     * POST requests/grant-requests/agent/
     *
     * Delegate access an agent&#39;s owner already holds to the agent, time-boxed. Unlike &#x60;create&#x60; this persists the request directly instead of returning a flow link -- an agent authenticates with an API token and has no browser to run a flow in, so no justification is ever collected. That is why the agent may only ask for what its owner already has: the owner&#39;s approval is then the whole decision, and no reviewer is asked to judge a request with nothing in it. The returned &#x60;fulfill_url&#x60; is what the agent hands to its owner so they can act on it.
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param agentGrantRequestCreateRequest
     * @return [AgentGrantRequestCreated]
     */
    @POST("requests/grant-requests/agent/")
    suspend fun requestsGrantRequestsAgentCreate(@Body agentGrantRequestCreateRequest: AgentGrantRequestCreateRequest): Response<AgentGrantRequestCreated>

    /**
     * POST requests/grant-requests/
     *
     *
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param grantRequestCreateRequest
     * @return [Link]
     */
    @POST("requests/grant-requests/")
    suspend fun requestsGrantRequestsCreate(@Body grantRequestCreateRequest: GrantRequestCreateRequest): Response<Link>

    /**
     * DELETE requests/grant-requests/{uuid}/
     *
     *
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Grant Request.
     * @return [Unit]
     */
    @DELETE("requests/grant-requests/{uuid}/")
    suspend fun requestsGrantRequestsDestroy(@Path("uuid") uuid: java.util.UUID): Response<Unit>

    /**
     * PATCH requests/grant-requests/{uuid}/fulfill/
     *
     *
     * Responses:
     *  - 204: Request fulfilled
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Grant Request.
     * @param patchedGrantRequestFulfillRequest  (optional)
     * @return [Unit]
     */
    @PATCH("requests/grant-requests/{uuid}/fulfill/")
    suspend fun requestsGrantRequestsFulfillPartialUpdate(@Path("uuid") uuid: java.util.UUID, @Body patchedGrantRequestFulfillRequest: PatchedGrantRequestFulfillRequest? = null): Response<Unit>

    /**
     * GET requests/grant-requests/
     *
     *
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param agentOwner  (optional)
     * @param createdBy  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param status  (optional)
     * @return [PaginatedGrantRequestList]
     */
    @GET("requests/grant-requests/")
    suspend fun requestsGrantRequestsList(@Query("agent_owner") agentOwner: kotlin.Int? = null, @Query("created_by") createdBy: kotlin.Int? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("status") status: RequestStatus? = null): Response<PaginatedGrantRequestList>

    /**
     * GET requests/grant-requests/pending_review/
     *
     * List pending grant requests the current user is eligible to review.
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param agentOwner  (optional)
     * @param createdBy  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param status  (optional)
     * @return [PaginatedGrantRequestList]
     */
    @GET("requests/grant-requests/pending_review/")
    suspend fun requestsGrantRequestsPendingReviewList(@Query("agent_owner") agentOwner: kotlin.Int? = null, @Query("created_by") createdBy: kotlin.Int? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("status") status: RequestStatus? = null): Response<PaginatedGrantRequestList>

    /**
     * GET requests/grant-requests/{uuid}/
     *
     *
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Grant Request.
     * @return [GrantRequest]
     */
    @GET("requests/grant-requests/{uuid}/")
    suspend fun requestsGrantRequestsRetrieve(@Path("uuid") uuid: java.util.UUID): Response<GrantRequest>

    /**
     * DELETE requests/grant-requests/{uuid}/revoke/
     *
     * Immediately end an active grant. Available to the same reviewers who could approve it in the first place.
     * Responses:
     *  - 204: Grant revoked
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Grant Request.
     * @return [Unit]
     */
    @DELETE("requests/grant-requests/{uuid}/revoke/")
    suspend fun requestsGrantRequestsRevokeDestroy(@Path("uuid") uuid: java.util.UUID): Response<Unit>

    /**
     * POST requests/rule-bindings/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param requestRuleBindingRequest
     * @return [RequestRuleBinding]
     */
    @POST("requests/rule-bindings/")
    suspend fun requestsRuleBindingsCreate(@Body requestRuleBindingRequest: RequestRuleBindingRequest): Response<RequestRuleBinding>

    /**
     * DELETE requests/rule-bindings/{uuid}/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Request Rule Binding.
     * @return [Unit]
     */
    @DELETE("requests/rule-bindings/{uuid}/")
    suspend fun requestsRuleBindingsDestroy(@Path("uuid") uuid: java.util.UUID): Response<Unit>

    /**
     * GET requests/rule-bindings/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param rule  (optional)
     * @param search A search term. (optional)
     * @param target  (optional)
     * @return [PaginatedRequestRuleBindingList]
     */
    @GET("requests/rule-bindings/")
    suspend fun requestsRuleBindingsList(@Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("rule") rule: java.util.UUID? = null, @Query("search") search: kotlin.String? = null, @Query("target") target: java.util.UUID? = null): Response<PaginatedRequestRuleBindingList>

    /**
     * PATCH requests/rule-bindings/{uuid}/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Request Rule Binding.
     * @param patchedRequestRuleBindingRequest  (optional)
     * @return [RequestRuleBinding]
     */
    @PATCH("requests/rule-bindings/{uuid}/")
    suspend fun requestsRuleBindingsPartialUpdate(@Path("uuid") uuid: java.util.UUID, @Body patchedRequestRuleBindingRequest: PatchedRequestRuleBindingRequest? = null): Response<RequestRuleBinding>

    /**
     * GET requests/rule-bindings/{uuid}/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Request Rule Binding.
     * @return [RequestRuleBinding]
     */
    @GET("requests/rule-bindings/{uuid}/")
    suspend fun requestsRuleBindingsRetrieve(@Path("uuid") uuid: java.util.UUID): Response<RequestRuleBinding>

    /**
     * PUT requests/rule-bindings/{uuid}/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Request Rule Binding.
     * @param requestRuleBindingRequest
     * @return [RequestRuleBinding]
     */
    @PUT("requests/rule-bindings/{uuid}/")
    suspend fun requestsRuleBindingsUpdate(@Path("uuid") uuid: java.util.UUID, @Body requestRuleBindingRequest: RequestRuleBindingRequest): Response<RequestRuleBinding>

    /**
     * GET requests/rule-bindings/{uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Request Rule Binding.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("requests/rule-bindings/{uuid}/used_by/")
    suspend fun requestsRuleBindingsUsedByList(@Path("uuid") uuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST requests/rule-child-bindings/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param requestRuleChildBindingRequest
     * @return [RequestRuleChildBinding]
     */
    @POST("requests/rule-child-bindings/")
    suspend fun requestsRuleChildBindingsCreate(@Body requestRuleChildBindingRequest: RequestRuleChildBindingRequest): Response<RequestRuleChildBinding>

    /**
     * DELETE requests/rule-child-bindings/{uuid}/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Request Rule Child Binding.
     * @return [Unit]
     */
    @DELETE("requests/rule-child-bindings/{uuid}/")
    suspend fun requestsRuleChildBindingsDestroy(@Path("uuid") uuid: java.util.UUID): Response<Unit>

    /**
     * GET requests/rule-child-bindings/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param binding  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param target  (optional)
     * @return [PaginatedRequestRuleChildBindingList]
     */
    @GET("requests/rule-child-bindings/")
    suspend fun requestsRuleChildBindingsList(@Query("binding") binding: java.util.UUID? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("target") target: java.util.UUID? = null): Response<PaginatedRequestRuleChildBindingList>

    /**
     * PATCH requests/rule-child-bindings/{uuid}/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Request Rule Child Binding.
     * @param patchedRequestRuleChildBindingRequest  (optional)
     * @return [RequestRuleChildBinding]
     */
    @PATCH("requests/rule-child-bindings/{uuid}/")
    suspend fun requestsRuleChildBindingsPartialUpdate(@Path("uuid") uuid: java.util.UUID, @Body patchedRequestRuleChildBindingRequest: PatchedRequestRuleChildBindingRequest? = null): Response<RequestRuleChildBinding>

    /**
     * GET requests/rule-child-bindings/{uuid}/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Request Rule Child Binding.
     * @return [RequestRuleChildBinding]
     */
    @GET("requests/rule-child-bindings/{uuid}/")
    suspend fun requestsRuleChildBindingsRetrieve(@Path("uuid") uuid: java.util.UUID): Response<RequestRuleChildBinding>

    /**
     * PUT requests/rule-child-bindings/{uuid}/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Request Rule Child Binding.
     * @param requestRuleChildBindingRequest
     * @return [RequestRuleChildBinding]
     */
    @PUT("requests/rule-child-bindings/{uuid}/")
    suspend fun requestsRuleChildBindingsUpdate(@Path("uuid") uuid: java.util.UUID, @Body requestRuleChildBindingRequest: RequestRuleChildBindingRequest): Response<RequestRuleChildBinding>

    /**
     * GET requests/rule-child-bindings/{uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Request Rule Child Binding.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("requests/rule-child-bindings/{uuid}/used_by/")
    suspend fun requestsRuleChildBindingsUsedByList(@Path("uuid") uuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST requests/rules/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param requestRuleRequest
     * @return [RequestRule]
     */
    @POST("requests/rules/")
    suspend fun requestsRulesCreate(@Body requestRuleRequest: RequestRuleRequest): Response<RequestRule>

    /**
     * DELETE requests/rules/{uuid}/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Request Rule.
     * @return [Unit]
     */
    @DELETE("requests/rules/{uuid}/")
    suspend fun requestsRulesDestroy(@Path("uuid") uuid: java.util.UUID): Response<Unit>

    /**
     * GET requests/rules/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
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
     * @param requestFlowSlug  (optional)
     * @param search A search term. (optional)
     * @return [PaginatedRequestRuleList]
     */
    @GET("requests/rules/")
    suspend fun requestsRulesList(@Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("pbm_uuid") pbmUuid: java.util.UUID? = null, @Query("request_flow__slug") requestFlowSlug: kotlin.String? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedRequestRuleList>

    /**
     * PATCH requests/rules/{uuid}/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Request Rule.
     * @param patchedRequestRuleRequest  (optional)
     * @return [RequestRule]
     */
    @PATCH("requests/rules/{uuid}/")
    suspend fun requestsRulesPartialUpdate(@Path("uuid") uuid: java.util.UUID, @Body patchedRequestRuleRequest: PatchedRequestRuleRequest? = null): Response<RequestRule>

    /**
     * GET requests/rules/{uuid}/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Request Rule.
     * @return [RequestRule]
     */
    @GET("requests/rules/{uuid}/")
    suspend fun requestsRulesRetrieve(@Path("uuid") uuid: java.util.UUID): Response<RequestRule>

    /**
     * PUT requests/rules/{uuid}/
     *
     * Mixin to add a used_by endpoint to return a list of all objects using this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Request Rule.
     * @param requestRuleRequest
     * @return [RequestRule]
     */
    @PUT("requests/rules/{uuid}/")
    suspend fun requestsRulesUpdate(@Path("uuid") uuid: java.util.UUID, @Body requestRuleRequest: RequestRuleRequest): Response<RequestRule>

    /**
     * GET requests/rules/{uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Request Rule.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("requests/rules/{uuid}/used_by/")
    suspend fun requestsRulesUsedByList(@Path("uuid") uuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

}
