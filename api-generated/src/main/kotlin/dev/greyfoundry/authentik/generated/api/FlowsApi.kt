package dev.greyfoundry.authentik.generated.api

import dev.greyfoundry.authentik.generated.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import okhttp3.ResponseBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import dev.greyfoundry.authentik.generated.model.Cache
import dev.greyfoundry.authentik.generated.model.ChallengeTypes
import dev.greyfoundry.authentik.generated.model.DeniedActionEnum
import dev.greyfoundry.authentik.generated.model.Flow
import dev.greyfoundry.authentik.generated.model.FlowChallengeResponseRequest
import dev.greyfoundry.authentik.generated.model.FlowDesignationEnum
import dev.greyfoundry.authentik.generated.model.FlowDiagram
import dev.greyfoundry.authentik.generated.model.FlowInspection
import dev.greyfoundry.authentik.generated.model.FlowRequest
import dev.greyfoundry.authentik.generated.model.FlowStageBinding
import dev.greyfoundry.authentik.generated.model.FlowStageBindingRequest
import dev.greyfoundry.authentik.generated.model.GenericError
import dev.greyfoundry.authentik.generated.model.InvalidResponseActionEnum
import dev.greyfoundry.authentik.generated.model.Link
import dev.greyfoundry.authentik.generated.model.PaginatedFlowList
import dev.greyfoundry.authentik.generated.model.PaginatedFlowStageBindingList
import dev.greyfoundry.authentik.generated.model.PatchedFlowRequest
import dev.greyfoundry.authentik.generated.model.PatchedFlowStageBindingRequest
import dev.greyfoundry.authentik.generated.model.PolicyEngineMode
import dev.greyfoundry.authentik.generated.model.UsedBy
import dev.greyfoundry.authentik.generated.model.ValidationError

interface FlowsApi {
    /**
     * POST flows/bindings/
     *
     * FlowStageBinding Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param flowStageBindingRequest
     * @return [FlowStageBinding]
     */
    @POST("flows/bindings/")
    suspend fun flowsBindingsCreate(@Body flowStageBindingRequest: FlowStageBindingRequest): Response<FlowStageBinding>

    /**
     * DELETE flows/bindings/{fsb_uuid}/
     *
     * FlowStageBinding Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param fsbUuid A UUID string identifying this Flow Stage Binding.
     * @return [Unit]
     */
    @DELETE("flows/bindings/{fsb_uuid}/")
    suspend fun flowsBindingsDestroy(@Path("fsb_uuid") fsbUuid: java.util.UUID): Response<Unit>

    /**
     * GET flows/bindings/
     *
     * FlowStageBinding Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param evaluateOnPlan  (optional)
     * @param fsbUuid  (optional)
     * @param invalidResponseAction  (optional)
     * @param order  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param pbmUuid  (optional)
     * @param policies  (optional)
     * @param policyEngineMode  (optional)
     * @param reEvaluatePolicies  (optional)
     * @param search A search term. (optional)
     * @param stage  (optional)
     * @param target  (optional)
     * @return [PaginatedFlowStageBindingList]
     */
    @GET("flows/bindings/")
    suspend fun flowsBindingsList(@Query("evaluate_on_plan") evaluateOnPlan: kotlin.Boolean? = null, @Query("fsb_uuid") fsbUuid: java.util.UUID? = null, @Query("invalid_response_action") invalidResponseAction: InvalidResponseActionEnum? = null, @Query("order") order: kotlin.Int? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("pbm_uuid") pbmUuid: java.util.UUID? = null, @Query("policies") policies: @JvmSuppressWildcards kotlin.collections.List<java.util.UUID>? = null, @Query("policy_engine_mode") policyEngineMode: PolicyEngineMode? = null, @Query("re_evaluate_policies") reEvaluatePolicies: kotlin.Boolean? = null, @Query("search") search: kotlin.String? = null, @Query("stage") stage: java.util.UUID? = null, @Query("target") target: java.util.UUID? = null): Response<PaginatedFlowStageBindingList>

    /**
     * PATCH flows/bindings/{fsb_uuid}/
     *
     * FlowStageBinding Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param fsbUuid A UUID string identifying this Flow Stage Binding.
     * @param patchedFlowStageBindingRequest  (optional)
     * @return [FlowStageBinding]
     */
    @PATCH("flows/bindings/{fsb_uuid}/")
    suspend fun flowsBindingsPartialUpdate(@Path("fsb_uuid") fsbUuid: java.util.UUID, @Body patchedFlowStageBindingRequest: PatchedFlowStageBindingRequest? = null): Response<FlowStageBinding>

    /**
     * GET flows/bindings/{fsb_uuid}/
     *
     * FlowStageBinding Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param fsbUuid A UUID string identifying this Flow Stage Binding.
     * @return [FlowStageBinding]
     */
    @GET("flows/bindings/{fsb_uuid}/")
    suspend fun flowsBindingsRetrieve(@Path("fsb_uuid") fsbUuid: java.util.UUID): Response<FlowStageBinding>

    /**
     * PUT flows/bindings/{fsb_uuid}/
     *
     * FlowStageBinding Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param fsbUuid A UUID string identifying this Flow Stage Binding.
     * @param flowStageBindingRequest
     * @return [FlowStageBinding]
     */
    @PUT("flows/bindings/{fsb_uuid}/")
    suspend fun flowsBindingsUpdate(@Path("fsb_uuid") fsbUuid: java.util.UUID, @Body flowStageBindingRequest: FlowStageBindingRequest): Response<FlowStageBinding>

    /**
     * GET flows/bindings/{fsb_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param fsbUuid A UUID string identifying this Flow Stage Binding.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("flows/bindings/{fsb_uuid}/used_by/")
    suspend fun flowsBindingsUsedByList(@Path("fsb_uuid") fsbUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * GET flows/executor/{flow_slug}/
     *
     * Get the next pending challenge from the currently active flow.
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param flowSlug
     * @param query Querystring as received
     * @return [ChallengeTypes]
     */
    @GET("flows/executor/{flow_slug}/")
    suspend fun flowsExecutorGet(@Path("flow_slug") flowSlug: kotlin.String, @Query("query") query: kotlin.String): Response<ChallengeTypes>

    /**
     * POST flows/executor/{flow_slug}/
     *
     * Solve the previously retrieved challenge and advanced to the next stage.
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param flowSlug
     * @param query Querystring as received
     * @param flowChallengeResponseRequest  (optional)
     * @return [ChallengeTypes]
     */
    @POST("flows/executor/{flow_slug}/")
    suspend fun flowsExecutorSolve(@Path("flow_slug") flowSlug: kotlin.String, @Query("query") query: kotlin.String, @Body flowChallengeResponseRequest: FlowChallengeResponseRequest? = null): Response<ChallengeTypes>

    /**
     * GET flows/inspector/{flow_slug}/
     *
     * Get current flow state and record it
     * Responses:
     *  - 200:
     *  - 400: No flow plan in session.
     *  - 403:
     *
     * @param flowSlug
     * @return [FlowInspection]
     */
    @GET("flows/inspector/{flow_slug}/")
    suspend fun flowsInspectorGet(@Path("flow_slug") flowSlug: kotlin.String): Response<FlowInspection>

    /**
     * POST flows/instances/cache_clear/
     *
     * Clear flow cache
     * Responses:
     *  - 204: Successfully cleared cache
     *  - 400: Bad request
     *  - 403:
     *
     * @return [Unit]
     */
    @POST("flows/instances/cache_clear/")
    suspend fun flowsInstancesCacheClearCreate(): Response<Unit>

    /**
     * GET flows/instances/cache_info/
     *
     * Info about cached flows
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @return [Cache]
     */
    @GET("flows/instances/cache_info/")
    suspend fun flowsInstancesCacheInfoRetrieve(): Response<Cache>

    /**
     * POST flows/instances/
     *
     * Flow Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param flowRequest
     * @return [Flow]
     */
    @POST("flows/instances/")
    suspend fun flowsInstancesCreate(@Body flowRequest: FlowRequest): Response<Flow>

    /**
     * DELETE flows/instances/{slug}/
     *
     * Flow Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @return [Unit]
     */
    @DELETE("flows/instances/{slug}/")
    suspend fun flowsInstancesDestroy(@Path("slug") slug: kotlin.String): Response<Unit>

    /**
     * GET flows/instances/{slug}/diagram/
     *
     * Return diagram for flow with slug &#x60;slug&#x60;, in the format used by flowchart.js
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @return [FlowDiagram]
     */
    @GET("flows/instances/{slug}/diagram/")
    suspend fun flowsInstancesDiagramRetrieve(@Path("slug") slug: kotlin.String): Response<FlowDiagram>

    /**
     * GET flows/instances/{slug}/execute/
     *
     * Execute flow for current user
     * Responses:
     *  - 200:
     *  - 400: Flow not applicable
     *  - 403:
     *
     * @param slug
     * @return [Link]
     */
    @GET("flows/instances/{slug}/execute/")
    suspend fun flowsInstancesExecuteRetrieve(@Path("slug") slug: kotlin.String): Response<Link>

    /**
     * GET flows/instances/{slug}/export/
     *
     * Export flow to .yaml file
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @return [ResponseBody]
     */
    @GET("flows/instances/{slug}/export/")
    suspend fun flowsInstancesExportRetrieve(@Path("slug") slug: kotlin.String): Response<ResponseBody>

    /**
     * GET flows/instances/
     *
     * Flow Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param deniedAction  (optional)
     * @param designation  (optional)
     * @param flowUuid  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param slug  (optional)
     * @return [PaginatedFlowList]
     */
    @GET("flows/instances/")
    suspend fun flowsInstancesList(@Query("denied_action") deniedAction: DeniedActionEnum? = null, @Query("designation") designation: FlowDesignationEnum? = null, @Query("flow_uuid") flowUuid: java.util.UUID? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("slug") slug: kotlin.String? = null): Response<PaginatedFlowList>

    /**
     * PATCH flows/instances/{slug}/
     *
     * Flow Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @param patchedFlowRequest  (optional)
     * @return [Flow]
     */
    @PATCH("flows/instances/{slug}/")
    suspend fun flowsInstancesPartialUpdate(@Path("slug") slug: kotlin.String, @Body patchedFlowRequest: PatchedFlowRequest? = null): Response<Flow>

    /**
     * GET flows/instances/{slug}/
     *
     * Flow Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @return [Flow]
     */
    @GET("flows/instances/{slug}/")
    suspend fun flowsInstancesRetrieve(@Path("slug") slug: kotlin.String): Response<Flow>

    /**
     * PUT flows/instances/{slug}/
     *
     * Flow Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param slug
     * @param flowRequest
     * @return [Flow]
     */
    @PUT("flows/instances/{slug}/")
    suspend fun flowsInstancesUpdate(@Path("slug") slug: kotlin.String, @Body flowRequest: FlowRequest): Response<Flow>

    /**
     * GET flows/instances/{slug}/used_by/
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
    @GET("flows/instances/{slug}/used_by/")
    suspend fun flowsInstancesUsedByList(@Path("slug") slug: kotlin.String): Response<kotlin.collections.List<UsedBy>>

}
