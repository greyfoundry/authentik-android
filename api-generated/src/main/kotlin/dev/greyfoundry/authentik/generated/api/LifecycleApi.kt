package dev.greyfoundry.authentik.generated.api

import dev.greyfoundry.authentik.generated.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import dev.greyfoundry.authentik.generated.model.GenericError
import dev.greyfoundry.authentik.generated.model.LifecycleIteration
import dev.greyfoundry.authentik.generated.model.LifecycleIterationRequest
import dev.greyfoundry.authentik.generated.model.LifecycleRule
import dev.greyfoundry.authentik.generated.model.LifecycleRuleRequest
import dev.greyfoundry.authentik.generated.model.OffboardingActionEnum
import dev.greyfoundry.authentik.generated.model.OffboardingStatusEnum
import dev.greyfoundry.authentik.generated.model.PaginatedLifecycleIterationList
import dev.greyfoundry.authentik.generated.model.PaginatedLifecycleRuleList
import dev.greyfoundry.authentik.generated.model.PaginatedUserOffboardingList
import dev.greyfoundry.authentik.generated.model.PatchedLifecycleRuleRequest
import dev.greyfoundry.authentik.generated.model.Review
import dev.greyfoundry.authentik.generated.model.ReviewRequest
import dev.greyfoundry.authentik.generated.model.UserOffboarding
import dev.greyfoundry.authentik.generated.model.UserOffboardingRequest
import dev.greyfoundry.authentik.generated.model.ValidationError

interface LifecycleApi {
    /**
     * POST lifecycle/iterations/
     *
     * Mixin to validate that a valid enterprise license exists before allowing to save the object
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param lifecycleIterationRequest
     * @return [LifecycleIteration]
     */
    @POST("lifecycle/iterations/")
    suspend fun lifecycleIterationsCreate(@Body lifecycleIterationRequest: LifecycleIterationRequest): Response<LifecycleIteration>

    /**
     * GET lifecycle/iterations/latest/{content_type}/{object_id}/
     *
     * Mixin to validate that a valid enterprise license exists before allowing to save the object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param contentType
     * @param objectId
     * @param ordering Which field to use when ordering the results. (optional)
     * @param search A search term. (optional)
     * @param userIsReviewer  (optional)
     * @return [kotlin.collections.List<LifecycleIteration>]
     */
    @GET("lifecycle/iterations/latest/{content_type}/{object_id}/")
    suspend fun lifecycleIterationsListLatest(@Path("content_type") contentType: kotlin.String, @Path("object_id") objectId: kotlin.String, @Query("ordering") ordering: kotlin.String? = null, @Query("search") search: kotlin.String? = null, @Query("user_is_reviewer") userIsReviewer: kotlin.Boolean? = null): Response<kotlin.collections.List<LifecycleIteration>>

    /**
     * GET lifecycle/iterations/open/
     *
     * Mixin to validate that a valid enterprise license exists before allowing to save the object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param userIsReviewer  (optional)
     * @return [PaginatedLifecycleIterationList]
     */
    @GET("lifecycle/iterations/open/")
    suspend fun lifecycleIterationsListOpen(@Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("user_is_reviewer") userIsReviewer: kotlin.Boolean? = null): Response<PaginatedLifecycleIterationList>

    /**
     * POST lifecycle/reviews/
     *
     * Mixin to validate that a valid enterprise license exists before allowing to save the object
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param reviewRequest
     * @return [Review]
     */
    @POST("lifecycle/reviews/")
    suspend fun lifecycleReviewsCreate(@Body reviewRequest: ReviewRequest): Response<Review>

    /**
     * POST lifecycle/rules/
     *
     *
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param lifecycleRuleRequest
     * @return [LifecycleRule]
     */
    @POST("lifecycle/rules/")
    suspend fun lifecycleRulesCreate(@Body lifecycleRuleRequest: LifecycleRuleRequest): Response<LifecycleRule>

    /**
     * DELETE lifecycle/rules/{id}/
     *
     *
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A UUID string identifying this lifecycle rule.
     * @return [Unit]
     */
    @DELETE("lifecycle/rules/{id}/")
    suspend fun lifecycleRulesDestroy(@Path("id") id: java.util.UUID): Response<Unit>

    /**
     * GET lifecycle/rules/
     *
     *
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param contentTypeModel  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedLifecycleRuleList]
     */
    @GET("lifecycle/rules/")
    suspend fun lifecycleRulesList(@Query("content_type__model") contentTypeModel: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedLifecycleRuleList>

    /**
     * PATCH lifecycle/rules/{id}/
     *
     *
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A UUID string identifying this lifecycle rule.
     * @param patchedLifecycleRuleRequest  (optional)
     * @return [LifecycleRule]
     */
    @PATCH("lifecycle/rules/{id}/")
    suspend fun lifecycleRulesPartialUpdate(@Path("id") id: java.util.UUID, @Body patchedLifecycleRuleRequest: PatchedLifecycleRuleRequest? = null): Response<LifecycleRule>

    /**
     * GET lifecycle/rules/{id}/
     *
     *
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A UUID string identifying this lifecycle rule.
     * @return [LifecycleRule]
     */
    @GET("lifecycle/rules/{id}/")
    suspend fun lifecycleRulesRetrieve(@Path("id") id: java.util.UUID): Response<LifecycleRule>

    /**
     * PUT lifecycle/rules/{id}/
     *
     *
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A UUID string identifying this lifecycle rule.
     * @param lifecycleRuleRequest
     * @return [LifecycleRule]
     */
    @PUT("lifecycle/rules/{id}/")
    suspend fun lifecycleRulesUpdate(@Path("id") id: java.util.UUID, @Body lifecycleRuleRequest: LifecycleRuleRequest): Response<LifecycleRule>

    /**
     * POST lifecycle/user_offboarding/
     *
     *
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param userOffboardingRequest
     * @return [UserOffboarding]
     */
    @POST("lifecycle/user_offboarding/")
    suspend fun lifecycleUserOffboardingCreate(@Body userOffboardingRequest: UserOffboardingRequest): Response<UserOffboarding>

    /**
     * DELETE lifecycle/user_offboarding/{id}/
     *
     * Cancel a pending offboarding instead of deleting the record.  The row is retained (as &#x60;CANCELED&#x60;) so the offboarding stays visible in the audit history; deletion would erase who scheduled and cancelled it. You cannot cancel an offboarding that targets you.
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A UUID string identifying this User Offboarding.
     * @return [Unit]
     */
    @DELETE("lifecycle/user_offboarding/{id}/")
    suspend fun lifecycleUserOffboardingDestroy(@Path("id") id: java.util.UUID): Response<Unit>

    /**
     * GET lifecycle/user_offboarding/
     *
     *
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param action  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param status  (optional)
     * @param userUuid  (optional)
     * @return [PaginatedUserOffboardingList]
     */
    @GET("lifecycle/user_offboarding/")
    suspend fun lifecycleUserOffboardingList(@Query("action") action: OffboardingActionEnum? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("status") status: OffboardingStatusEnum? = null, @Query("user__uuid") userUuid: java.util.UUID? = null): Response<PaginatedUserOffboardingList>

    /**
     * GET lifecycle/user_offboarding/{id}/
     *
     *
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A UUID string identifying this User Offboarding.
     * @return [UserOffboarding]
     */
    @GET("lifecycle/user_offboarding/{id}/")
    suspend fun lifecycleUserOffboardingRetrieve(@Path("id") id: java.util.UUID): Response<UserOffboarding>

}
