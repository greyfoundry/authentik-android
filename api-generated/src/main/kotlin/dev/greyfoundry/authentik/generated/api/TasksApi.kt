package dev.greyfoundry.authentik.generated.api

import dev.greyfoundry.authentik.generated.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import dev.greyfoundry.authentik.generated.model.GenericError
import dev.greyfoundry.authentik.generated.model.GlobalTaskStatus
import dev.greyfoundry.authentik.generated.model.PaginatedScheduleList
import dev.greyfoundry.authentik.generated.model.PaginatedTaskList
import dev.greyfoundry.authentik.generated.model.PatchedScheduleRequest
import dev.greyfoundry.authentik.generated.model.Schedule
import dev.greyfoundry.authentik.generated.model.ScheduleRequest
import dev.greyfoundry.authentik.generated.model.Task
import dev.greyfoundry.authentik.generated.model.TaskAggregatedStatusEnum
import dev.greyfoundry.authentik.generated.model.TaskStatusEnum
import dev.greyfoundry.authentik.generated.model.ValidationError
import dev.greyfoundry.authentik.generated.model.Worker

interface TasksApi {
    /**
     * GET tasks/schedules/
     *
     *
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param actorName  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param paused  (optional)
     * @param relObjContentTypeAppLabel  (optional)
     * @param relObjContentTypeModel  (optional)
     * @param relObjId  (optional)
     * @param relObjIdIsnull  (optional)
     * @param search A search term. (optional)
     * @return [PaginatedScheduleList]
     */
    @GET("tasks/schedules/")
    suspend fun tasksSchedulesList(@Query("actor_name") actorName: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("paused") paused: kotlin.Boolean? = null, @Query("rel_obj_content_type__app_label") relObjContentTypeAppLabel: kotlin.String? = null, @Query("rel_obj_content_type__model") relObjContentTypeModel: kotlin.String? = null, @Query("rel_obj_id") relObjId: kotlin.String? = null, @Query("rel_obj_id__isnull") relObjIdIsnull: kotlin.Boolean? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedScheduleList>

    /**
     * PATCH tasks/schedules/{id}/
     *
     *
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A UUID string identifying this Schedule.
     * @param patchedScheduleRequest  (optional)
     * @return [Schedule]
     */
    @PATCH("tasks/schedules/{id}/")
    suspend fun tasksSchedulesPartialUpdate(@Path("id") id: java.util.UUID, @Body patchedScheduleRequest: PatchedScheduleRequest? = null): Response<Schedule>

    /**
     * GET tasks/schedules/{id}/
     *
     *
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A UUID string identifying this Schedule.
     * @return [Schedule]
     */
    @GET("tasks/schedules/{id}/")
    suspend fun tasksSchedulesRetrieve(@Path("id") id: java.util.UUID): Response<Schedule>

    /**
     * POST tasks/schedules/{id}/send/
     *
     * Trigger this schedule now
     * Responses:
     *  - 204: Schedule sent successfully
     *  - 404: Schedule not found
     *  - 500: Failed to send schedule
     *  - 400:
     *  - 403:
     *
     * @param id A UUID string identifying this Schedule.
     * @return [Unit]
     */
    @POST("tasks/schedules/{id}/send/")
    suspend fun tasksSchedulesSendCreate(@Path("id") id: java.util.UUID): Response<Unit>

    /**
     * PUT tasks/schedules/{id}/
     *
     *
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A UUID string identifying this Schedule.
     * @param scheduleRequest
     * @return [Schedule]
     */
    @PUT("tasks/schedules/{id}/")
    suspend fun tasksSchedulesUpdate(@Path("id") id: java.util.UUID, @Body scheduleRequest: ScheduleRequest): Response<Schedule>

    /**
     * GET tasks/tasks/
     *
     *
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param actorName  (optional)
     * @param aggregatedStatus  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param queueName  (optional)
     * @param relObjContentTypeAppLabel  (optional)
     * @param relObjContentTypeModel  (optional)
     * @param relObjId  (optional)
     * @param relObjIdIsnull  (optional)
     * @param search A search term. (optional)
     * @param state  (optional)
     * @return [PaginatedTaskList]
     */
    @GET("tasks/tasks/")
    suspend fun tasksTasksList(@Query("actor_name") actorName: kotlin.String? = null, @Query("aggregated_status") aggregatedStatus: @JvmSuppressWildcards kotlin.collections.List<TaskAggregatedStatusEnum>? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("queue_name") queueName: kotlin.String? = null, @Query("rel_obj_content_type__app_label") relObjContentTypeAppLabel: kotlin.String? = null, @Query("rel_obj_content_type__model") relObjContentTypeModel: kotlin.String? = null, @Query("rel_obj_id") relObjId: kotlin.String? = null, @Query("rel_obj_id__isnull") relObjIdIsnull: kotlin.Boolean? = null, @Query("search") search: kotlin.String? = null, @Query("state") state: TaskStatusEnum? = null): Response<PaginatedTaskList>

    /**
     * GET tasks/tasks/{message_id}/
     *
     *
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param messageId A UUID string identifying this Task.
     * @return [Task]
     */
    @GET("tasks/tasks/{message_id}/")
    suspend fun tasksTasksRetrieve(@Path("message_id") messageId: java.util.UUID): Response<Task>

    /**
     * POST tasks/tasks/{message_id}/retry/
     *
     * Retry task
     * Responses:
     *  - 204: Task retried successfully
     *  - 400: Task is not in a retryable state
     *  - 404: Task not found
     *  - 403:
     *
     * @param messageId A UUID string identifying this Task.
     * @return [Unit]
     */
    @POST("tasks/tasks/{message_id}/retry/")
    suspend fun tasksTasksRetryCreate(@Path("message_id") messageId: java.util.UUID): Response<Unit>

    /**
     * GET tasks/tasks/status/
     *
     * Global status summary for all tasks
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @return [GlobalTaskStatus]
     */
    @GET("tasks/tasks/status/")
    suspend fun tasksTasksStatusRetrieve(): Response<GlobalTaskStatus>

    /**
     * GET tasks/workers/
     *
     * Get currently connected worker count.
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @return [kotlin.collections.List<Worker>]
     */
    @GET("tasks/workers/")
    suspend fun tasksWorkersList(): Response<kotlin.collections.List<Worker>>

}
