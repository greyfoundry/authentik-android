package dev.greyfoundry.authentik.generated.api

import dev.greyfoundry.authentik.generated.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import dev.greyfoundry.authentik.generated.model.DataExport
import dev.greyfoundry.authentik.generated.model.Event
import dev.greyfoundry.authentik.generated.model.EventActions
import dev.greyfoundry.authentik.generated.model.EventRequest
import dev.greyfoundry.authentik.generated.model.EventStats
import dev.greyfoundry.authentik.generated.model.EventTopPerUser
import dev.greyfoundry.authentik.generated.model.EventVolume
import dev.greyfoundry.authentik.generated.model.GenericError
import dev.greyfoundry.authentik.generated.model.Notification
import dev.greyfoundry.authentik.generated.model.NotificationRequest
import dev.greyfoundry.authentik.generated.model.NotificationRule
import dev.greyfoundry.authentik.generated.model.NotificationRuleRequest
import dev.greyfoundry.authentik.generated.model.NotificationTransport
import dev.greyfoundry.authentik.generated.model.NotificationTransportRequest
import dev.greyfoundry.authentik.generated.model.NotificationTransportTest
import dev.greyfoundry.authentik.generated.model.PaginatedEventList
import dev.greyfoundry.authentik.generated.model.PaginatedNotificationList
import dev.greyfoundry.authentik.generated.model.PaginatedNotificationRuleList
import dev.greyfoundry.authentik.generated.model.PaginatedNotificationTransportList
import dev.greyfoundry.authentik.generated.model.PatchedEventRequest
import dev.greyfoundry.authentik.generated.model.PatchedNotificationRequest
import dev.greyfoundry.authentik.generated.model.PatchedNotificationRuleRequest
import dev.greyfoundry.authentik.generated.model.PatchedNotificationTransportRequest
import dev.greyfoundry.authentik.generated.model.SeverityEnum
import dev.greyfoundry.authentik.generated.model.TransportModeEnum
import dev.greyfoundry.authentik.generated.model.TypeCreate
import dev.greyfoundry.authentik.generated.model.UsedBy
import dev.greyfoundry.authentik.generated.model.ValidationError

interface EventsApi {
    /**
     * GET events/events/actions/
     *
     * Get all actions
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @return [kotlin.collections.List<TypeCreate>]
     */
    @GET("events/events/actions/")
    suspend fun eventsEventsActionsList(): Response<kotlin.collections.List<TypeCreate>>

    /**
     * POST events/events/
     *
     * Event Read-Only Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param eventRequest
     * @return [Event]
     */
    @POST("events/events/")
    suspend fun eventsEventsCreate(@Body eventRequest: EventRequest): Response<Event>

    /**
     * DELETE events/events/{event_uuid}/
     *
     * Event Read-Only Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param eventUuid A UUID string identifying this Event.
     * @return [Unit]
     */
    @DELETE("events/events/{event_uuid}/")
    suspend fun eventsEventsDestroy(@Path("event_uuid") eventUuid: java.util.UUID): Response<Unit>

    /**
     * POST events/events/export/
     *
     * Create a data export for this data type. Note that the export is generated asynchronously: this method returns a &#x60;DataExport&#x60; object that will initially have &#x60;completed&#x3D;false&#x60; as well as the permanent URL to that object in the &#x60;Location&#x60; header. You can poll that URL until &#x60;completed&#x3D;true&#x60;, at which point the &#x60;file_url&#x60; property will contain a URL to download
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param action  (optional)
     * @param actions  (optional)
     * @param brandName Brand name (optional)
     * @param clientIp  (optional)
     * @param contextAuthorizedApp Context Authorized application (optional)
     * @param contextDevice Context Device Primary Key (optional)
     * @param contextModelApp Context Model App (optional)
     * @param contextModelName Context Model Name (optional)
     * @param contextModelPk Context Model Primary Key (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param search A search term. (optional)
     * @param username Username (optional)
     * @return [DataExport]
     */
    @POST("events/events/export/")
    suspend fun eventsEventsExportCreate(@Query("action") action: kotlin.String? = null, @Query("actions") actions: @JvmSuppressWildcards kotlin.collections.List<EventActions>? = null, @Query("brand_name") brandName: kotlin.String? = null, @Query("client_ip") clientIp: kotlin.String? = null, @Query("context_authorized_app") contextAuthorizedApp: kotlin.String? = null, @Query("context_device") contextDevice: kotlin.String? = null, @Query("context_model_app") contextModelApp: kotlin.String? = null, @Query("context_model_name") contextModelName: kotlin.String? = null, @Query("context_model_pk") contextModelPk: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("search") search: kotlin.String? = null, @Query("username") username: kotlin.String? = null): Response<DataExport>

    /**
     * GET events/events/
     *
     * Event Read-Only Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param action  (optional)
     * @param actions  (optional)
     * @param brandName Brand name (optional)
     * @param clientIp  (optional)
     * @param contextAuthorizedApp Context Authorized application (optional)
     * @param contextDevice Context Device Primary Key (optional)
     * @param contextModelApp Context Model App (optional)
     * @param contextModelName Context Model Name (optional)
     * @param contextModelPk Context Model Primary Key (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param username Username (optional)
     * @return [PaginatedEventList]
     */
    @GET("events/events/")
    suspend fun eventsEventsList(@Query("action") action: kotlin.String? = null, @Query("actions") actions: @JvmSuppressWildcards kotlin.collections.List<EventActions>? = null, @Query("brand_name") brandName: kotlin.String? = null, @Query("client_ip") clientIp: kotlin.String? = null, @Query("context_authorized_app") contextAuthorizedApp: kotlin.String? = null, @Query("context_device") contextDevice: kotlin.String? = null, @Query("context_model_app") contextModelApp: kotlin.String? = null, @Query("context_model_name") contextModelName: kotlin.String? = null, @Query("context_model_pk") contextModelPk: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("username") username: kotlin.String? = null): Response<PaginatedEventList>

    /**
     * PATCH events/events/{event_uuid}/
     *
     * Event Read-Only Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param eventUuid A UUID string identifying this Event.
     * @param patchedEventRequest  (optional)
     * @return [Event]
     */
    @PATCH("events/events/{event_uuid}/")
    suspend fun eventsEventsPartialUpdate(@Path("event_uuid") eventUuid: java.util.UUID, @Body patchedEventRequest: PatchedEventRequest? = null): Response<Event>

    /**
     * GET events/events/{event_uuid}/
     *
     * Event Read-Only Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param eventUuid A UUID string identifying this Event.
     * @return [Event]
     */
    @GET("events/events/{event_uuid}/")
    suspend fun eventsEventsRetrieve(@Path("event_uuid") eventUuid: java.util.UUID): Response<Event>

    /**
     * GET events/events/stats/
     *
     * Get event stats for specified filters and count steps
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param countSteps Timedelta, format of &#39;weeks&#x3D;3;days&#x3D;2;hours&#x3D;3,seconds&#x3D;2&#39;
     * @param action  (optional)
     * @param actions  (optional)
     * @param brandName Brand name (optional)
     * @param clientIp  (optional)
     * @param contextAuthorizedApp Context Authorized application (optional)
     * @param contextDevice Context Device Primary Key (optional)
     * @param contextModelApp Context Model App (optional)
     * @param contextModelName Context Model Name (optional)
     * @param contextModelPk Context Model Primary Key (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param search A search term. (optional)
     * @param username Username (optional)
     * @return [EventStats]
     */
    @GET("events/events/stats/")
    suspend fun eventsEventsStatsRetrieve(@Query("count_steps") countSteps: @JvmSuppressWildcards kotlin.collections.List<kotlin.String>, @Query("action") action: kotlin.String? = null, @Query("actions") actions: @JvmSuppressWildcards kotlin.collections.List<EventActions>? = null, @Query("brand_name") brandName: kotlin.String? = null, @Query("client_ip") clientIp: kotlin.String? = null, @Query("context_authorized_app") contextAuthorizedApp: kotlin.String? = null, @Query("context_device") contextDevice: kotlin.String? = null, @Query("context_model_app") contextModelApp: kotlin.String? = null, @Query("context_model_name") contextModelName: kotlin.String? = null, @Query("context_model_pk") contextModelPk: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("search") search: kotlin.String? = null, @Query("username") username: kotlin.String? = null): Response<EventStats>

    /**
     * GET events/events/top_per_user/
     *
     * Get the top_n events grouped by user count
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param action  (optional)
     * @param actions  (optional)
     * @param brandName Brand name (optional)
     * @param clientIp  (optional)
     * @param contextAuthorizedApp Context Authorized application (optional)
     * @param contextDevice Context Device Primary Key (optional)
     * @param contextModelApp Context Model App (optional)
     * @param contextModelName Context Model Name (optional)
     * @param contextModelPk Context Model Primary Key (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param search A search term. (optional)
     * @param topN  (optional, default to 15)
     * @param username Username (optional)
     * @return [kotlin.collections.List<EventTopPerUser>]
     */
    @GET("events/events/top_per_user/")
    suspend fun eventsEventsTopPerUserList(@Query("action") action: kotlin.String? = null, @Query("actions") actions: @JvmSuppressWildcards kotlin.collections.List<EventActions>? = null, @Query("brand_name") brandName: kotlin.String? = null, @Query("client_ip") clientIp: kotlin.String? = null, @Query("context_authorized_app") contextAuthorizedApp: kotlin.String? = null, @Query("context_device") contextDevice: kotlin.String? = null, @Query("context_model_app") contextModelApp: kotlin.String? = null, @Query("context_model_name") contextModelName: kotlin.String? = null, @Query("context_model_pk") contextModelPk: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("search") search: kotlin.String? = null, @Query("top_n") topN: kotlin.Int? = 15, @Query("username") username: kotlin.String? = null): Response<kotlin.collections.List<EventTopPerUser>>

    /**
     * PUT events/events/{event_uuid}/
     *
     * Event Read-Only Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param eventUuid A UUID string identifying this Event.
     * @param eventRequest
     * @return [Event]
     */
    @PUT("events/events/{event_uuid}/")
    suspend fun eventsEventsUpdate(@Path("event_uuid") eventUuid: java.util.UUID, @Body eventRequest: EventRequest): Response<Event>

    /**
     * GET events/events/volume/
     *
     * Get event volume for specified filters and timeframe
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param action  (optional)
     * @param actions  (optional)
     * @param brandName Brand name (optional)
     * @param clientIp  (optional)
     * @param contextAuthorizedApp Context Authorized application (optional)
     * @param contextDevice Context Device Primary Key (optional)
     * @param contextModelApp Context Model App (optional)
     * @param contextModelName Context Model Name (optional)
     * @param contextModelPk Context Model Primary Key (optional)
     * @param historyDays  (optional, default to 7)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param search A search term. (optional)
     * @param username Username (optional)
     * @return [kotlin.collections.List<EventVolume>]
     */
    @GET("events/events/volume/")
    suspend fun eventsEventsVolumeList(@Query("action") action: kotlin.String? = null, @Query("actions") actions: @JvmSuppressWildcards kotlin.collections.List<EventActions>? = null, @Query("brand_name") brandName: kotlin.String? = null, @Query("client_ip") clientIp: kotlin.String? = null, @Query("context_authorized_app") contextAuthorizedApp: kotlin.String? = null, @Query("context_device") contextDevice: kotlin.String? = null, @Query("context_model_app") contextModelApp: kotlin.String? = null, @Query("context_model_name") contextModelName: kotlin.String? = null, @Query("context_model_pk") contextModelPk: kotlin.String? = null, @Query("history_days") historyDays: kotlin.Int? = 7, @Query("ordering") ordering: kotlin.String? = null, @Query("search") search: kotlin.String? = null, @Query("username") username: kotlin.String? = null): Response<kotlin.collections.List<EventVolume>>

    /**
     * DELETE events/notifications/{uuid}/
     *
     * Notification Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Notification.
     * @return [Unit]
     */
    @DELETE("events/notifications/{uuid}/")
    suspend fun eventsNotificationsDestroy(@Path("uuid") uuid: java.util.UUID): Response<Unit>

    /**
     * GET events/notifications/
     *
     * Notification Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param body  (optional)
     * @param created  (optional)
     * @param event  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param seen  (optional)
     * @param severity  (optional)
     * @param user  (optional)
     * @return [PaginatedNotificationList]
     */
    @GET("events/notifications/")
    suspend fun eventsNotificationsList(@Query("body") body: kotlin.String? = null, @Query("created") created: java.time.OffsetDateTime? = null, @Query("event") event: java.util.UUID? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("seen") seen: kotlin.Boolean? = null, @Query("severity") severity: SeverityEnum? = null, @Query("user") user: kotlin.Int? = null): Response<PaginatedNotificationList>

    /**
     * POST events/notifications/mark_all_seen/
     *
     * Mark all the user&#39;s notifications as seen
     * Responses:
     *  - 204: Marked tasks as read successfully.
     *  - 400:
     *  - 403:
     *
     * @return [Unit]
     */
    @POST("events/notifications/mark_all_seen/")
    suspend fun eventsNotificationsMarkAllSeenCreate(): Response<Unit>

    /**
     * PATCH events/notifications/{uuid}/
     *
     * Notification Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Notification.
     * @param patchedNotificationRequest  (optional)
     * @return [Notification]
     */
    @PATCH("events/notifications/{uuid}/")
    suspend fun eventsNotificationsPartialUpdate(@Path("uuid") uuid: java.util.UUID, @Body patchedNotificationRequest: PatchedNotificationRequest? = null): Response<Notification>

    /**
     * GET events/notifications/{uuid}/
     *
     * Notification Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Notification.
     * @return [Notification]
     */
    @GET("events/notifications/{uuid}/")
    suspend fun eventsNotificationsRetrieve(@Path("uuid") uuid: java.util.UUID): Response<Notification>

    /**
     * PUT events/notifications/{uuid}/
     *
     * Notification Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Notification.
     * @param notificationRequest  (optional)
     * @return [Notification]
     */
    @PUT("events/notifications/{uuid}/")
    suspend fun eventsNotificationsUpdate(@Path("uuid") uuid: java.util.UUID, @Body notificationRequest: NotificationRequest? = null): Response<Notification>

    /**
     * GET events/notifications/{uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Notification.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("events/notifications/{uuid}/used_by/")
    suspend fun eventsNotificationsUsedByList(@Path("uuid") uuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST events/rules/
     *
     * NotificationRule Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param notificationRuleRequest
     * @return [NotificationRule]
     */
    @POST("events/rules/")
    suspend fun eventsRulesCreate(@Body notificationRuleRequest: NotificationRuleRequest): Response<NotificationRule>

    /**
     * DELETE events/rules/{pbm_uuid}/
     *
     * NotificationRule Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param pbmUuid A UUID string identifying this Notification Rule.
     * @return [Unit]
     */
    @DELETE("events/rules/{pbm_uuid}/")
    suspend fun eventsRulesDestroy(@Path("pbm_uuid") pbmUuid: java.util.UUID): Response<Unit>

    /**
     * GET events/rules/
     *
     * NotificationRule Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param destinationGroupName  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param severity  (optional)
     * @return [PaginatedNotificationRuleList]
     */
    @GET("events/rules/")
    suspend fun eventsRulesList(@Query("destination_group__name") destinationGroupName: kotlin.String? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("severity") severity: SeverityEnum? = null): Response<PaginatedNotificationRuleList>

    /**
     * PATCH events/rules/{pbm_uuid}/
     *
     * NotificationRule Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pbmUuid A UUID string identifying this Notification Rule.
     * @param patchedNotificationRuleRequest  (optional)
     * @return [NotificationRule]
     */
    @PATCH("events/rules/{pbm_uuid}/")
    suspend fun eventsRulesPartialUpdate(@Path("pbm_uuid") pbmUuid: java.util.UUID, @Body patchedNotificationRuleRequest: PatchedNotificationRuleRequest? = null): Response<NotificationRule>

    /**
     * GET events/rules/{pbm_uuid}/
     *
     * NotificationRule Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pbmUuid A UUID string identifying this Notification Rule.
     * @return [NotificationRule]
     */
    @GET("events/rules/{pbm_uuid}/")
    suspend fun eventsRulesRetrieve(@Path("pbm_uuid") pbmUuid: java.util.UUID): Response<NotificationRule>

    /**
     * PUT events/rules/{pbm_uuid}/
     *
     * NotificationRule Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pbmUuid A UUID string identifying this Notification Rule.
     * @param notificationRuleRequest
     * @return [NotificationRule]
     */
    @PUT("events/rules/{pbm_uuid}/")
    suspend fun eventsRulesUpdate(@Path("pbm_uuid") pbmUuid: java.util.UUID, @Body notificationRuleRequest: NotificationRuleRequest): Response<NotificationRule>

    /**
     * GET events/rules/{pbm_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param pbmUuid A UUID string identifying this Notification Rule.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("events/rules/{pbm_uuid}/used_by/")
    suspend fun eventsRulesUsedByList(@Path("pbm_uuid") pbmUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST events/transports/
     *
     * NotificationTransport Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param notificationTransportRequest
     * @return [NotificationTransport]
     */
    @POST("events/transports/")
    suspend fun eventsTransportsCreate(@Body notificationTransportRequest: NotificationTransportRequest): Response<NotificationTransport>

    /**
     * DELETE events/transports/{uuid}/
     *
     * NotificationTransport Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Notification Transport.
     * @return [Unit]
     */
    @DELETE("events/transports/{uuid}/")
    suspend fun eventsTransportsDestroy(@Path("uuid") uuid: java.util.UUID): Response<Unit>

    /**
     * GET events/transports/
     *
     * NotificationTransport Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param mode  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param sendOnce  (optional)
     * @param webhookUrl  (optional)
     * @return [PaginatedNotificationTransportList]
     */
    @GET("events/transports/")
    suspend fun eventsTransportsList(@Query("mode") mode: TransportModeEnum? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("send_once") sendOnce: kotlin.Boolean? = null, @Query("webhook_url") webhookUrl: kotlin.String? = null): Response<PaginatedNotificationTransportList>

    /**
     * PATCH events/transports/{uuid}/
     *
     * NotificationTransport Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Notification Transport.
     * @param patchedNotificationTransportRequest  (optional)
     * @return [NotificationTransport]
     */
    @PATCH("events/transports/{uuid}/")
    suspend fun eventsTransportsPartialUpdate(@Path("uuid") uuid: java.util.UUID, @Body patchedNotificationTransportRequest: PatchedNotificationTransportRequest? = null): Response<NotificationTransport>

    /**
     * GET events/transports/{uuid}/
     *
     * NotificationTransport Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Notification Transport.
     * @return [NotificationTransport]
     */
    @GET("events/transports/{uuid}/")
    suspend fun eventsTransportsRetrieve(@Path("uuid") uuid: java.util.UUID): Response<NotificationTransport>

    /**
     * POST events/transports/{uuid}/test/
     *
     * Send example notification using selected transport. Requires Modify permissions.
     * Responses:
     *  - 200:
     *  - 500: Failed to test transport
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Notification Transport.
     * @return [NotificationTransportTest]
     */
    @POST("events/transports/{uuid}/test/")
    suspend fun eventsTransportsTestCreate(@Path("uuid") uuid: java.util.UUID): Response<NotificationTransportTest>

    /**
     * PUT events/transports/{uuid}/
     *
     * NotificationTransport Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Notification Transport.
     * @param notificationTransportRequest
     * @return [NotificationTransport]
     */
    @PUT("events/transports/{uuid}/")
    suspend fun eventsTransportsUpdate(@Path("uuid") uuid: java.util.UUID, @Body notificationTransportRequest: NotificationTransportRequest): Response<NotificationTransport>

    /**
     * GET events/transports/{uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this Notification Transport.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("events/transports/{uuid}/used_by/")
    suspend fun eventsTransportsUsedByList(@Path("uuid") uuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

}
