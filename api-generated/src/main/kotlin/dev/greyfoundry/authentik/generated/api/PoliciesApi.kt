package dev.greyfoundry.authentik.generated.api

import dev.greyfoundry.authentik.generated.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import dev.greyfoundry.authentik.generated.model.Cache
import dev.greyfoundry.authentik.generated.model.DetailedCountry
import dev.greyfoundry.authentik.generated.model.DummyPolicy
import dev.greyfoundry.authentik.generated.model.DummyPolicyRequest
import dev.greyfoundry.authentik.generated.model.EventActions
import dev.greyfoundry.authentik.generated.model.EventMatcherPolicy
import dev.greyfoundry.authentik.generated.model.EventMatcherPolicyRequest
import dev.greyfoundry.authentik.generated.model.ExpressionPolicy
import dev.greyfoundry.authentik.generated.model.ExpressionPolicyRequest
import dev.greyfoundry.authentik.generated.model.GenericError
import dev.greyfoundry.authentik.generated.model.GeoIPPolicy
import dev.greyfoundry.authentik.generated.model.GeoIPPolicyRequest
import dev.greyfoundry.authentik.generated.model.PaginatedDummyPolicyList
import dev.greyfoundry.authentik.generated.model.PaginatedEventMatcherPolicyList
import dev.greyfoundry.authentik.generated.model.PaginatedExpressionPolicyList
import dev.greyfoundry.authentik.generated.model.PaginatedGeoIPPolicyList
import dev.greyfoundry.authentik.generated.model.PaginatedPasswordExpiryPolicyList
import dev.greyfoundry.authentik.generated.model.PaginatedPasswordPolicyList
import dev.greyfoundry.authentik.generated.model.PaginatedPolicyBindingList
import dev.greyfoundry.authentik.generated.model.PaginatedPolicyList
import dev.greyfoundry.authentik.generated.model.PaginatedReputationList
import dev.greyfoundry.authentik.generated.model.PaginatedReputationPolicyList
import dev.greyfoundry.authentik.generated.model.PaginatedUniquePasswordPolicyList
import dev.greyfoundry.authentik.generated.model.PasswordExpiryPolicy
import dev.greyfoundry.authentik.generated.model.PasswordExpiryPolicyRequest
import dev.greyfoundry.authentik.generated.model.PasswordPolicy
import dev.greyfoundry.authentik.generated.model.PasswordPolicyRequest
import dev.greyfoundry.authentik.generated.model.PatchedDummyPolicyRequest
import dev.greyfoundry.authentik.generated.model.PatchedEventMatcherPolicyRequest
import dev.greyfoundry.authentik.generated.model.PatchedExpressionPolicyRequest
import dev.greyfoundry.authentik.generated.model.PatchedGeoIPPolicyRequest
import dev.greyfoundry.authentik.generated.model.PatchedPasswordExpiryPolicyRequest
import dev.greyfoundry.authentik.generated.model.PatchedPasswordPolicyRequest
import dev.greyfoundry.authentik.generated.model.PatchedPolicyBindingRequest
import dev.greyfoundry.authentik.generated.model.PatchedReputationPolicyRequest
import dev.greyfoundry.authentik.generated.model.PatchedUniquePasswordPolicyRequest
import dev.greyfoundry.authentik.generated.model.Policy
import dev.greyfoundry.authentik.generated.model.PolicyBinding
import dev.greyfoundry.authentik.generated.model.PolicyBindingRequest
import dev.greyfoundry.authentik.generated.model.PolicyTestRequest
import dev.greyfoundry.authentik.generated.model.PolicyTestResult
import dev.greyfoundry.authentik.generated.model.Reputation
import dev.greyfoundry.authentik.generated.model.ReputationPolicy
import dev.greyfoundry.authentik.generated.model.ReputationPolicyRequest
import dev.greyfoundry.authentik.generated.model.TypeCreate
import dev.greyfoundry.authentik.generated.model.UniquePasswordPolicy
import dev.greyfoundry.authentik.generated.model.UniquePasswordPolicyRequest
import dev.greyfoundry.authentik.generated.model.UsedBy
import dev.greyfoundry.authentik.generated.model.ValidationError

interface PoliciesApi {
    /**
     * POST policies/all/cache_clear/
     *
     * Clear policy cache
     * Responses:
     *  - 204: Successfully cleared cache
     *  - 400: Bad request
     *  - 403:
     *
     * @return [Unit]
     */
    @POST("policies/all/cache_clear/")
    suspend fun policiesAllCacheClearCreate(): Response<Unit>

    /**
     * GET policies/all/cache_info/
     *
     * Info about cached policies
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @return [Cache]
     */
    @GET("policies/all/cache_info/")
    suspend fun policiesAllCacheInfoRetrieve(): Response<Cache>

    /**
     * DELETE policies/all/{policy_uuid}/
     *
     * Policy Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this Policy.
     * @return [Unit]
     */
    @DELETE("policies/all/{policy_uuid}/")
    suspend fun policiesAllDestroy(@Path("policy_uuid") policyUuid: java.util.UUID): Response<Unit>

    /**
     * GET policies/all/
     *
     * Policy Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param bindingsIsnull  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param promptstageIsnull  (optional)
     * @param search A search term. (optional)
     * @return [PaginatedPolicyList]
     */
    @GET("policies/all/")
    suspend fun policiesAllList(@Query("bindings__isnull") bindingsIsnull: kotlin.Boolean? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("promptstage__isnull") promptstageIsnull: kotlin.Boolean? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedPolicyList>

    /**
     * GET policies/all/{policy_uuid}/
     *
     * Policy Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this Policy.
     * @return [Policy]
     */
    @GET("policies/all/{policy_uuid}/")
    suspend fun policiesAllRetrieve(@Path("policy_uuid") policyUuid: java.util.UUID): Response<Policy>

    /**
     * POST policies/all/{policy_uuid}/test/
     *
     * Test policy
     * Responses:
     *  - 200:
     *  - 400: Invalid parameters
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this Policy.
     * @param policyTestRequest
     * @return [PolicyTestResult]
     */
    @POST("policies/all/{policy_uuid}/test/")
    suspend fun policiesAllTestCreate(@Path("policy_uuid") policyUuid: java.util.UUID, @Body policyTestRequest: PolicyTestRequest): Response<PolicyTestResult>

    /**
     * GET policies/all/types/
     *
     * Get all creatable types
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @return [kotlin.collections.List<TypeCreate>]
     */
    @GET("policies/all/types/")
    suspend fun policiesAllTypesList(): Response<kotlin.collections.List<TypeCreate>>

    /**
     * GET policies/all/{policy_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this Policy.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("policies/all/{policy_uuid}/used_by/")
    suspend fun policiesAllUsedByList(@Path("policy_uuid") policyUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST policies/bindings/
     *
     * PolicyBinding Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param policyBindingRequest
     * @return [PolicyBinding]
     */
    @POST("policies/bindings/")
    suspend fun policiesBindingsCreate(@Body policyBindingRequest: PolicyBindingRequest): Response<PolicyBinding>

    /**
     * DELETE policies/bindings/{policy_binding_uuid}/
     *
     * PolicyBinding Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param policyBindingUuid A UUID string identifying this Policy Binding.
     * @return [Unit]
     */
    @DELETE("policies/bindings/{policy_binding_uuid}/")
    suspend fun policiesBindingsDestroy(@Path("policy_binding_uuid") policyBindingUuid: java.util.UUID): Response<Unit>

    /**
     * GET policies/bindings/
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
     * @return [PaginatedPolicyBindingList]
     */
    @GET("policies/bindings/")
    suspend fun policiesBindingsList(@Query("enabled") enabled: kotlin.Boolean? = null, @Query("order") order: kotlin.Int? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("policy") policy: java.util.UUID? = null, @Query("policy__isnull") policyIsnull: kotlin.Boolean? = null, @Query("search") search: kotlin.String? = null, @Query("target") target: java.util.UUID? = null, @Query("target_in") targetIn: @JvmSuppressWildcards kotlin.collections.List<java.util.UUID>? = null, @Query("timeout") timeout: kotlin.Int? = null): Response<PaginatedPolicyBindingList>

    /**
     * PATCH policies/bindings/{policy_binding_uuid}/
     *
     * PolicyBinding Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyBindingUuid A UUID string identifying this Policy Binding.
     * @param patchedPolicyBindingRequest  (optional)
     * @return [PolicyBinding]
     */
    @PATCH("policies/bindings/{policy_binding_uuid}/")
    suspend fun policiesBindingsPartialUpdate(@Path("policy_binding_uuid") policyBindingUuid: java.util.UUID, @Body patchedPolicyBindingRequest: PatchedPolicyBindingRequest? = null): Response<PolicyBinding>

    /**
     * GET policies/bindings/{policy_binding_uuid}/
     *
     * PolicyBinding Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyBindingUuid A UUID string identifying this Policy Binding.
     * @return [PolicyBinding]
     */
    @GET("policies/bindings/{policy_binding_uuid}/")
    suspend fun policiesBindingsRetrieve(@Path("policy_binding_uuid") policyBindingUuid: java.util.UUID): Response<PolicyBinding>

    /**
     * PUT policies/bindings/{policy_binding_uuid}/
     *
     * PolicyBinding Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyBindingUuid A UUID string identifying this Policy Binding.
     * @param policyBindingRequest
     * @return [PolicyBinding]
     */
    @PUT("policies/bindings/{policy_binding_uuid}/")
    suspend fun policiesBindingsUpdate(@Path("policy_binding_uuid") policyBindingUuid: java.util.UUID, @Body policyBindingRequest: PolicyBindingRequest): Response<PolicyBinding>

    /**
     * GET policies/bindings/{policy_binding_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyBindingUuid A UUID string identifying this Policy Binding.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("policies/bindings/{policy_binding_uuid}/used_by/")
    suspend fun policiesBindingsUsedByList(@Path("policy_binding_uuid") policyBindingUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST policies/dummy/
     *
     * Dummy Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param dummyPolicyRequest
     * @return [DummyPolicy]
     */
    @POST("policies/dummy/")
    suspend fun policiesDummyCreate(@Body dummyPolicyRequest: DummyPolicyRequest): Response<DummyPolicy>

    /**
     * DELETE policies/dummy/{policy_uuid}/
     *
     * Dummy Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this Dummy Policy.
     * @return [Unit]
     */
    @DELETE("policies/dummy/{policy_uuid}/")
    suspend fun policiesDummyDestroy(@Path("policy_uuid") policyUuid: java.util.UUID): Response<Unit>

    /**
     * GET policies/dummy/
     *
     * Dummy Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param created  (optional)
     * @param executionLogging  (optional)
     * @param lastUpdated  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param policyUuid  (optional)
     * @param result  (optional)
     * @param search A search term. (optional)
     * @param waitMax  (optional)
     * @param waitMin  (optional)
     * @return [PaginatedDummyPolicyList]
     */
    @GET("policies/dummy/")
    suspend fun policiesDummyList(@Query("created") created: java.time.OffsetDateTime? = null, @Query("execution_logging") executionLogging: kotlin.Boolean? = null, @Query("last_updated") lastUpdated: java.time.OffsetDateTime? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("policy_uuid") policyUuid: java.util.UUID? = null, @Query("result") result: kotlin.Boolean? = null, @Query("search") search: kotlin.String? = null, @Query("wait_max") waitMax: kotlin.Int? = null, @Query("wait_min") waitMin: kotlin.Int? = null): Response<PaginatedDummyPolicyList>

    /**
     * PATCH policies/dummy/{policy_uuid}/
     *
     * Dummy Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this Dummy Policy.
     * @param patchedDummyPolicyRequest  (optional)
     * @return [DummyPolicy]
     */
    @PATCH("policies/dummy/{policy_uuid}/")
    suspend fun policiesDummyPartialUpdate(@Path("policy_uuid") policyUuid: java.util.UUID, @Body patchedDummyPolicyRequest: PatchedDummyPolicyRequest? = null): Response<DummyPolicy>

    /**
     * GET policies/dummy/{policy_uuid}/
     *
     * Dummy Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this Dummy Policy.
     * @return [DummyPolicy]
     */
    @GET("policies/dummy/{policy_uuid}/")
    suspend fun policiesDummyRetrieve(@Path("policy_uuid") policyUuid: java.util.UUID): Response<DummyPolicy>

    /**
     * PUT policies/dummy/{policy_uuid}/
     *
     * Dummy Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this Dummy Policy.
     * @param dummyPolicyRequest
     * @return [DummyPolicy]
     */
    @PUT("policies/dummy/{policy_uuid}/")
    suspend fun policiesDummyUpdate(@Path("policy_uuid") policyUuid: java.util.UUID, @Body dummyPolicyRequest: DummyPolicyRequest): Response<DummyPolicy>

    /**
     * GET policies/dummy/{policy_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this Dummy Policy.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("policies/dummy/{policy_uuid}/used_by/")
    suspend fun policiesDummyUsedByList(@Path("policy_uuid") policyUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST policies/event_matcher/
     *
     * Event Matcher Policy Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param eventMatcherPolicyRequest
     * @return [EventMatcherPolicy]
     */
    @POST("policies/event_matcher/")
    suspend fun policiesEventMatcherCreate(@Body eventMatcherPolicyRequest: EventMatcherPolicyRequest): Response<EventMatcherPolicy>

    /**
     * DELETE policies/event_matcher/{policy_uuid}/
     *
     * Event Matcher Policy Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this Event Matcher Policy.
     * @return [Unit]
     */
    @DELETE("policies/event_matcher/{policy_uuid}/")
    suspend fun policiesEventMatcherDestroy(@Path("policy_uuid") policyUuid: java.util.UUID): Response<Unit>

    /**
     * GET policies/event_matcher/
     *
     * Event Matcher Policy Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param action  (optional)
     * @param app  (optional)
     * @param clientIp  (optional)
     * @param created  (optional)
     * @param executionLogging  (optional)
     * @param lastUpdated  (optional)
     * @param model  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param policyUuid  (optional)
     * @param query  (optional)
     * @param search A search term. (optional)
     * @return [PaginatedEventMatcherPolicyList]
     */
    @GET("policies/event_matcher/")
    suspend fun policiesEventMatcherList(@Query("action") action: EventActions? = null, @Query("app") app: kotlin.String? = null, @Query("client_ip") clientIp: kotlin.String? = null, @Query("created") created: java.time.OffsetDateTime? = null, @Query("execution_logging") executionLogging: kotlin.Boolean? = null, @Query("last_updated") lastUpdated: java.time.OffsetDateTime? = null, @Query("model") model: kotlin.String? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("policy_uuid") policyUuid: java.util.UUID? = null, @Query("query") query: kotlin.String? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedEventMatcherPolicyList>

    /**
     * PATCH policies/event_matcher/{policy_uuid}/
     *
     * Event Matcher Policy Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this Event Matcher Policy.
     * @param patchedEventMatcherPolicyRequest  (optional)
     * @return [EventMatcherPolicy]
     */
    @PATCH("policies/event_matcher/{policy_uuid}/")
    suspend fun policiesEventMatcherPartialUpdate(@Path("policy_uuid") policyUuid: java.util.UUID, @Body patchedEventMatcherPolicyRequest: PatchedEventMatcherPolicyRequest? = null): Response<EventMatcherPolicy>

    /**
     * GET policies/event_matcher/{policy_uuid}/
     *
     * Event Matcher Policy Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this Event Matcher Policy.
     * @return [EventMatcherPolicy]
     */
    @GET("policies/event_matcher/{policy_uuid}/")
    suspend fun policiesEventMatcherRetrieve(@Path("policy_uuid") policyUuid: java.util.UUID): Response<EventMatcherPolicy>

    /**
     * PUT policies/event_matcher/{policy_uuid}/
     *
     * Event Matcher Policy Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this Event Matcher Policy.
     * @param eventMatcherPolicyRequest
     * @return [EventMatcherPolicy]
     */
    @PUT("policies/event_matcher/{policy_uuid}/")
    suspend fun policiesEventMatcherUpdate(@Path("policy_uuid") policyUuid: java.util.UUID, @Body eventMatcherPolicyRequest: EventMatcherPolicyRequest): Response<EventMatcherPolicy>

    /**
     * GET policies/event_matcher/{policy_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this Event Matcher Policy.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("policies/event_matcher/{policy_uuid}/used_by/")
    suspend fun policiesEventMatcherUsedByList(@Path("policy_uuid") policyUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST policies/expression/
     *
     * Source Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param expressionPolicyRequest
     * @return [ExpressionPolicy]
     */
    @POST("policies/expression/")
    suspend fun policiesExpressionCreate(@Body expressionPolicyRequest: ExpressionPolicyRequest): Response<ExpressionPolicy>

    /**
     * DELETE policies/expression/{policy_uuid}/
     *
     * Source Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this Expression Policy.
     * @return [Unit]
     */
    @DELETE("policies/expression/{policy_uuid}/")
    suspend fun policiesExpressionDestroy(@Path("policy_uuid") policyUuid: java.util.UUID): Response<Unit>

    /**
     * GET policies/expression/
     *
     * Source Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param created  (optional)
     * @param executionLogging  (optional)
     * @param expression  (optional)
     * @param lastUpdated  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param policyUuid  (optional)
     * @param search A search term. (optional)
     * @return [PaginatedExpressionPolicyList]
     */
    @GET("policies/expression/")
    suspend fun policiesExpressionList(@Query("created") created: java.time.OffsetDateTime? = null, @Query("execution_logging") executionLogging: kotlin.Boolean? = null, @Query("expression") expression: kotlin.String? = null, @Query("last_updated") lastUpdated: java.time.OffsetDateTime? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("policy_uuid") policyUuid: java.util.UUID? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedExpressionPolicyList>

    /**
     * PATCH policies/expression/{policy_uuid}/
     *
     * Source Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this Expression Policy.
     * @param patchedExpressionPolicyRequest  (optional)
     * @return [ExpressionPolicy]
     */
    @PATCH("policies/expression/{policy_uuid}/")
    suspend fun policiesExpressionPartialUpdate(@Path("policy_uuid") policyUuid: java.util.UUID, @Body patchedExpressionPolicyRequest: PatchedExpressionPolicyRequest? = null): Response<ExpressionPolicy>

    /**
     * GET policies/expression/{policy_uuid}/
     *
     * Source Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this Expression Policy.
     * @return [ExpressionPolicy]
     */
    @GET("policies/expression/{policy_uuid}/")
    suspend fun policiesExpressionRetrieve(@Path("policy_uuid") policyUuid: java.util.UUID): Response<ExpressionPolicy>

    /**
     * PUT policies/expression/{policy_uuid}/
     *
     * Source Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this Expression Policy.
     * @param expressionPolicyRequest
     * @return [ExpressionPolicy]
     */
    @PUT("policies/expression/{policy_uuid}/")
    suspend fun policiesExpressionUpdate(@Path("policy_uuid") policyUuid: java.util.UUID, @Body expressionPolicyRequest: ExpressionPolicyRequest): Response<ExpressionPolicy>

    /**
     * GET policies/expression/{policy_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this Expression Policy.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("policies/expression/{policy_uuid}/used_by/")
    suspend fun policiesExpressionUsedByList(@Path("policy_uuid") policyUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST policies/geoip/
     *
     * GeoIP Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param geoIPPolicyRequest
     * @return [GeoIPPolicy]
     */
    @POST("policies/geoip/")
    suspend fun policiesGeoipCreate(@Body geoIPPolicyRequest: GeoIPPolicyRequest): Response<GeoIPPolicy>

    /**
     * DELETE policies/geoip/{policy_uuid}/
     *
     * GeoIP Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this GeoIP Policy.
     * @return [Unit]
     */
    @DELETE("policies/geoip/{policy_uuid}/")
    suspend fun policiesGeoipDestroy(@Path("policy_uuid") policyUuid: java.util.UUID): Response<Unit>

    /**
     * GET policies/geoip_iso3166/
     *
     * Get all countries in ISO-3166-1
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @return [kotlin.collections.List<DetailedCountry>]
     */
    @GET("policies/geoip_iso3166/")
    suspend fun policiesGeoipIso3166List(): Response<kotlin.collections.List<DetailedCountry>>

    /**
     * GET policies/geoip/
     *
     * GeoIP Viewset
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
     * @return [PaginatedGeoIPPolicyList]
     */
    @GET("policies/geoip/")
    suspend fun policiesGeoipList(@Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedGeoIPPolicyList>

    /**
     * PATCH policies/geoip/{policy_uuid}/
     *
     * GeoIP Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this GeoIP Policy.
     * @param patchedGeoIPPolicyRequest  (optional)
     * @return [GeoIPPolicy]
     */
    @PATCH("policies/geoip/{policy_uuid}/")
    suspend fun policiesGeoipPartialUpdate(@Path("policy_uuid") policyUuid: java.util.UUID, @Body patchedGeoIPPolicyRequest: PatchedGeoIPPolicyRequest? = null): Response<GeoIPPolicy>

    /**
     * GET policies/geoip/{policy_uuid}/
     *
     * GeoIP Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this GeoIP Policy.
     * @return [GeoIPPolicy]
     */
    @GET("policies/geoip/{policy_uuid}/")
    suspend fun policiesGeoipRetrieve(@Path("policy_uuid") policyUuid: java.util.UUID): Response<GeoIPPolicy>

    /**
     * PUT policies/geoip/{policy_uuid}/
     *
     * GeoIP Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this GeoIP Policy.
     * @param geoIPPolicyRequest
     * @return [GeoIPPolicy]
     */
    @PUT("policies/geoip/{policy_uuid}/")
    suspend fun policiesGeoipUpdate(@Path("policy_uuid") policyUuid: java.util.UUID, @Body geoIPPolicyRequest: GeoIPPolicyRequest): Response<GeoIPPolicy>

    /**
     * GET policies/geoip/{policy_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this GeoIP Policy.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("policies/geoip/{policy_uuid}/used_by/")
    suspend fun policiesGeoipUsedByList(@Path("policy_uuid") policyUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST policies/password/
     *
     * Password Policy Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param passwordPolicyRequest
     * @return [PasswordPolicy]
     */
    @POST("policies/password/")
    suspend fun policiesPasswordCreate(@Body passwordPolicyRequest: PasswordPolicyRequest): Response<PasswordPolicy>

    /**
     * DELETE policies/password/{policy_uuid}/
     *
     * Password Policy Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this Password Policy.
     * @return [Unit]
     */
    @DELETE("policies/password/{policy_uuid}/")
    suspend fun policiesPasswordDestroy(@Path("policy_uuid") policyUuid: java.util.UUID): Response<Unit>

    /**
     * POST policies/password_expiry/
     *
     * Password Expiry Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param passwordExpiryPolicyRequest
     * @return [PasswordExpiryPolicy]
     */
    @POST("policies/password_expiry/")
    suspend fun policiesPasswordExpiryCreate(@Body passwordExpiryPolicyRequest: PasswordExpiryPolicyRequest): Response<PasswordExpiryPolicy>

    /**
     * DELETE policies/password_expiry/{policy_uuid}/
     *
     * Password Expiry Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this Password Expiry Policy.
     * @return [Unit]
     */
    @DELETE("policies/password_expiry/{policy_uuid}/")
    suspend fun policiesPasswordExpiryDestroy(@Path("policy_uuid") policyUuid: java.util.UUID): Response<Unit>

    /**
     * GET policies/password_expiry/
     *
     * Password Expiry Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param created  (optional)
     * @param days  (optional)
     * @param denyOnly  (optional)
     * @param executionLogging  (optional)
     * @param lastUpdated  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param policyUuid  (optional)
     * @param search A search term. (optional)
     * @return [PaginatedPasswordExpiryPolicyList]
     */
    @GET("policies/password_expiry/")
    suspend fun policiesPasswordExpiryList(@Query("created") created: java.time.OffsetDateTime? = null, @Query("days") days: kotlin.Int? = null, @Query("deny_only") denyOnly: kotlin.Boolean? = null, @Query("execution_logging") executionLogging: kotlin.Boolean? = null, @Query("last_updated") lastUpdated: java.time.OffsetDateTime? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("policy_uuid") policyUuid: java.util.UUID? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedPasswordExpiryPolicyList>

    /**
     * PATCH policies/password_expiry/{policy_uuid}/
     *
     * Password Expiry Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this Password Expiry Policy.
     * @param patchedPasswordExpiryPolicyRequest  (optional)
     * @return [PasswordExpiryPolicy]
     */
    @PATCH("policies/password_expiry/{policy_uuid}/")
    suspend fun policiesPasswordExpiryPartialUpdate(@Path("policy_uuid") policyUuid: java.util.UUID, @Body patchedPasswordExpiryPolicyRequest: PatchedPasswordExpiryPolicyRequest? = null): Response<PasswordExpiryPolicy>

    /**
     * GET policies/password_expiry/{policy_uuid}/
     *
     * Password Expiry Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this Password Expiry Policy.
     * @return [PasswordExpiryPolicy]
     */
    @GET("policies/password_expiry/{policy_uuid}/")
    suspend fun policiesPasswordExpiryRetrieve(@Path("policy_uuid") policyUuid: java.util.UUID): Response<PasswordExpiryPolicy>

    /**
     * PUT policies/password_expiry/{policy_uuid}/
     *
     * Password Expiry Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this Password Expiry Policy.
     * @param passwordExpiryPolicyRequest
     * @return [PasswordExpiryPolicy]
     */
    @PUT("policies/password_expiry/{policy_uuid}/")
    suspend fun policiesPasswordExpiryUpdate(@Path("policy_uuid") policyUuid: java.util.UUID, @Body passwordExpiryPolicyRequest: PasswordExpiryPolicyRequest): Response<PasswordExpiryPolicy>

    /**
     * GET policies/password_expiry/{policy_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this Password Expiry Policy.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("policies/password_expiry/{policy_uuid}/used_by/")
    suspend fun policiesPasswordExpiryUsedByList(@Path("policy_uuid") policyUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * GET policies/password/
     *
     * Password Policy Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param amountDigits  (optional)
     * @param amountLowercase  (optional)
     * @param amountSymbols  (optional)
     * @param amountUppercase  (optional)
     * @param checkHaveIBeenPwned  (optional)
     * @param checkStaticRules  (optional)
     * @param checkZxcvbn  (optional)
     * @param created  (optional)
     * @param errorMessage  (optional)
     * @param executionLogging  (optional)
     * @param hibpAllowedCount  (optional)
     * @param lastUpdated  (optional)
     * @param lengthMin  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param passwordField  (optional)
     * @param policyUuid  (optional)
     * @param search A search term. (optional)
     * @param symbolCharset  (optional)
     * @param zxcvbnScoreThreshold  (optional)
     * @return [PaginatedPasswordPolicyList]
     */
    @GET("policies/password/")
    suspend fun policiesPasswordList(@Query("amount_digits") amountDigits: kotlin.Int? = null, @Query("amount_lowercase") amountLowercase: kotlin.Int? = null, @Query("amount_symbols") amountSymbols: kotlin.Int? = null, @Query("amount_uppercase") amountUppercase: kotlin.Int? = null, @Query("check_have_i_been_pwned") checkHaveIBeenPwned: kotlin.Boolean? = null, @Query("check_static_rules") checkStaticRules: kotlin.Boolean? = null, @Query("check_zxcvbn") checkZxcvbn: kotlin.Boolean? = null, @Query("created") created: java.time.OffsetDateTime? = null, @Query("error_message") errorMessage: kotlin.String? = null, @Query("execution_logging") executionLogging: kotlin.Boolean? = null, @Query("hibp_allowed_count") hibpAllowedCount: kotlin.Int? = null, @Query("last_updated") lastUpdated: java.time.OffsetDateTime? = null, @Query("length_min") lengthMin: kotlin.Int? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("password_field") passwordField: kotlin.String? = null, @Query("policy_uuid") policyUuid: java.util.UUID? = null, @Query("search") search: kotlin.String? = null, @Query("symbol_charset") symbolCharset: kotlin.String? = null, @Query("zxcvbn_score_threshold") zxcvbnScoreThreshold: kotlin.Int? = null): Response<PaginatedPasswordPolicyList>

    /**
     * PATCH policies/password/{policy_uuid}/
     *
     * Password Policy Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this Password Policy.
     * @param patchedPasswordPolicyRequest  (optional)
     * @return [PasswordPolicy]
     */
    @PATCH("policies/password/{policy_uuid}/")
    suspend fun policiesPasswordPartialUpdate(@Path("policy_uuid") policyUuid: java.util.UUID, @Body patchedPasswordPolicyRequest: PatchedPasswordPolicyRequest? = null): Response<PasswordPolicy>

    /**
     * GET policies/password/{policy_uuid}/
     *
     * Password Policy Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this Password Policy.
     * @return [PasswordPolicy]
     */
    @GET("policies/password/{policy_uuid}/")
    suspend fun policiesPasswordRetrieve(@Path("policy_uuid") policyUuid: java.util.UUID): Response<PasswordPolicy>

    /**
     * PUT policies/password/{policy_uuid}/
     *
     * Password Policy Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this Password Policy.
     * @param passwordPolicyRequest
     * @return [PasswordPolicy]
     */
    @PUT("policies/password/{policy_uuid}/")
    suspend fun policiesPasswordUpdate(@Path("policy_uuid") policyUuid: java.util.UUID, @Body passwordPolicyRequest: PasswordPolicyRequest): Response<PasswordPolicy>

    /**
     * GET policies/password/{policy_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this Password Policy.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("policies/password/{policy_uuid}/used_by/")
    suspend fun policiesPasswordUsedByList(@Path("policy_uuid") policyUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST policies/reputation/
     *
     * Reputation Policy Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param reputationPolicyRequest
     * @return [ReputationPolicy]
     */
    @POST("policies/reputation/")
    suspend fun policiesReputationCreate(@Body reputationPolicyRequest: ReputationPolicyRequest): Response<ReputationPolicy>

    /**
     * DELETE policies/reputation/{policy_uuid}/
     *
     * Reputation Policy Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this Reputation Policy.
     * @return [Unit]
     */
    @DELETE("policies/reputation/{policy_uuid}/")
    suspend fun policiesReputationDestroy(@Path("policy_uuid") policyUuid: java.util.UUID): Response<Unit>

    /**
     * GET policies/reputation/
     *
     * Reputation Policy Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param checkIp  (optional)
     * @param checkUsername  (optional)
     * @param created  (optional)
     * @param executionLogging  (optional)
     * @param lastUpdated  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param policyUuid  (optional)
     * @param search A search term. (optional)
     * @param threshold  (optional)
     * @return [PaginatedReputationPolicyList]
     */
    @GET("policies/reputation/")
    suspend fun policiesReputationList(@Query("check_ip") checkIp: kotlin.Boolean? = null, @Query("check_username") checkUsername: kotlin.Boolean? = null, @Query("created") created: java.time.OffsetDateTime? = null, @Query("execution_logging") executionLogging: kotlin.Boolean? = null, @Query("last_updated") lastUpdated: java.time.OffsetDateTime? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("policy_uuid") policyUuid: java.util.UUID? = null, @Query("search") search: kotlin.String? = null, @Query("threshold") threshold: kotlin.Int? = null): Response<PaginatedReputationPolicyList>

    /**
     * PATCH policies/reputation/{policy_uuid}/
     *
     * Reputation Policy Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this Reputation Policy.
     * @param patchedReputationPolicyRequest  (optional)
     * @return [ReputationPolicy]
     */
    @PATCH("policies/reputation/{policy_uuid}/")
    suspend fun policiesReputationPartialUpdate(@Path("policy_uuid") policyUuid: java.util.UUID, @Body patchedReputationPolicyRequest: PatchedReputationPolicyRequest? = null): Response<ReputationPolicy>

    /**
     * GET policies/reputation/{policy_uuid}/
     *
     * Reputation Policy Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this Reputation Policy.
     * @return [ReputationPolicy]
     */
    @GET("policies/reputation/{policy_uuid}/")
    suspend fun policiesReputationRetrieve(@Path("policy_uuid") policyUuid: java.util.UUID): Response<ReputationPolicy>

    /**
     * DELETE policies/reputation/scores/{reputation_uuid}/
     *
     * Reputation Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param reputationUuid A UUID string identifying this Reputation Score.
     * @return [Unit]
     */
    @DELETE("policies/reputation/scores/{reputation_uuid}/")
    suspend fun policiesReputationScoresDestroy(@Path("reputation_uuid") reputationUuid: java.util.UUID): Response<Unit>

    /**
     * GET policies/reputation/scores/
     *
     * Reputation Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param identifier  (optional)
     * @param identifierIn Multiple values may be separated by commas. (optional)
     * @param ip  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param score  (optional)
     * @param search A search term. (optional)
     * @return [PaginatedReputationList]
     */
    @GET("policies/reputation/scores/")
    suspend fun policiesReputationScoresList(@Query("identifier") identifier: kotlin.String? = null, @Query("identifier_in") identifierIn: CSVParams? = null, @Query("ip") ip: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("score") score: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedReputationList>

    /**
     * GET policies/reputation/scores/{reputation_uuid}/
     *
     * Reputation Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param reputationUuid A UUID string identifying this Reputation Score.
     * @return [Reputation]
     */
    @GET("policies/reputation/scores/{reputation_uuid}/")
    suspend fun policiesReputationScoresRetrieve(@Path("reputation_uuid") reputationUuid: java.util.UUID): Response<Reputation>

    /**
     * GET policies/reputation/scores/{reputation_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param reputationUuid A UUID string identifying this Reputation Score.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("policies/reputation/scores/{reputation_uuid}/used_by/")
    suspend fun policiesReputationScoresUsedByList(@Path("reputation_uuid") reputationUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * PUT policies/reputation/{policy_uuid}/
     *
     * Reputation Policy Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this Reputation Policy.
     * @param reputationPolicyRequest
     * @return [ReputationPolicy]
     */
    @PUT("policies/reputation/{policy_uuid}/")
    suspend fun policiesReputationUpdate(@Path("policy_uuid") policyUuid: java.util.UUID, @Body reputationPolicyRequest: ReputationPolicyRequest): Response<ReputationPolicy>

    /**
     * GET policies/reputation/{policy_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this Reputation Policy.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("policies/reputation/{policy_uuid}/used_by/")
    suspend fun policiesReputationUsedByList(@Path("policy_uuid") policyUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST policies/unique_password/
     *
     * Password Uniqueness Policy Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param uniquePasswordPolicyRequest
     * @return [UniquePasswordPolicy]
     */
    @POST("policies/unique_password/")
    suspend fun policiesUniquePasswordCreate(@Body uniquePasswordPolicyRequest: UniquePasswordPolicyRequest): Response<UniquePasswordPolicy>

    /**
     * DELETE policies/unique_password/{policy_uuid}/
     *
     * Password Uniqueness Policy Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this Password Uniqueness Policy.
     * @return [Unit]
     */
    @DELETE("policies/unique_password/{policy_uuid}/")
    suspend fun policiesUniquePasswordDestroy(@Path("policy_uuid") policyUuid: java.util.UUID): Response<Unit>

    /**
     * GET policies/unique_password/
     *
     * Password Uniqueness Policy Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param created  (optional)
     * @param executionLogging  (optional)
     * @param lastUpdated  (optional)
     * @param name  (optional)
     * @param numHistoricalPasswords  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param passwordField  (optional)
     * @param policyUuid  (optional)
     * @param search A search term. (optional)
     * @return [PaginatedUniquePasswordPolicyList]
     */
    @GET("policies/unique_password/")
    suspend fun policiesUniquePasswordList(@Query("created") created: java.time.OffsetDateTime? = null, @Query("execution_logging") executionLogging: kotlin.Boolean? = null, @Query("last_updated") lastUpdated: java.time.OffsetDateTime? = null, @Query("name") name: kotlin.String? = null, @Query("num_historical_passwords") numHistoricalPasswords: kotlin.Int? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("password_field") passwordField: kotlin.String? = null, @Query("policy_uuid") policyUuid: java.util.UUID? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedUniquePasswordPolicyList>

    /**
     * PATCH policies/unique_password/{policy_uuid}/
     *
     * Password Uniqueness Policy Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this Password Uniqueness Policy.
     * @param patchedUniquePasswordPolicyRequest  (optional)
     * @return [UniquePasswordPolicy]
     */
    @PATCH("policies/unique_password/{policy_uuid}/")
    suspend fun policiesUniquePasswordPartialUpdate(@Path("policy_uuid") policyUuid: java.util.UUID, @Body patchedUniquePasswordPolicyRequest: PatchedUniquePasswordPolicyRequest? = null): Response<UniquePasswordPolicy>

    /**
     * GET policies/unique_password/{policy_uuid}/
     *
     * Password Uniqueness Policy Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this Password Uniqueness Policy.
     * @return [UniquePasswordPolicy]
     */
    @GET("policies/unique_password/{policy_uuid}/")
    suspend fun policiesUniquePasswordRetrieve(@Path("policy_uuid") policyUuid: java.util.UUID): Response<UniquePasswordPolicy>

    /**
     * PUT policies/unique_password/{policy_uuid}/
     *
     * Password Uniqueness Policy Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this Password Uniqueness Policy.
     * @param uniquePasswordPolicyRequest
     * @return [UniquePasswordPolicy]
     */
    @PUT("policies/unique_password/{policy_uuid}/")
    suspend fun policiesUniquePasswordUpdate(@Path("policy_uuid") policyUuid: java.util.UUID, @Body uniquePasswordPolicyRequest: UniquePasswordPolicyRequest): Response<UniquePasswordPolicy>

    /**
     * GET policies/unique_password/{policy_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param policyUuid A UUID string identifying this Password Uniqueness Policy.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("policies/unique_password/{policy_uuid}/used_by/")
    suspend fun policiesUniquePasswordUsedByList(@Path("policy_uuid") policyUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

}
