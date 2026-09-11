package dev.greyfoundry.authentik.generated.api

import dev.greyfoundry.authentik.generated.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import dev.greyfoundry.authentik.generated.model.AccountLockdownStage
import dev.greyfoundry.authentik.generated.model.AccountLockdownStageRequest
import dev.greyfoundry.authentik.generated.model.AuthTypeEnum
import dev.greyfoundry.authentik.generated.model.AuthenticatorAttachmentEnum
import dev.greyfoundry.authentik.generated.model.AuthenticatorDuoStage
import dev.greyfoundry.authentik.generated.model.AuthenticatorDuoStageDeviceImportResponse
import dev.greyfoundry.authentik.generated.model.AuthenticatorDuoStageManualDeviceImportRequest
import dev.greyfoundry.authentik.generated.model.AuthenticatorDuoStageRequest
import dev.greyfoundry.authentik.generated.model.AuthenticatorEmailStage
import dev.greyfoundry.authentik.generated.model.AuthenticatorEmailStageRequest
import dev.greyfoundry.authentik.generated.model.AuthenticatorEndpointGDTCStage
import dev.greyfoundry.authentik.generated.model.AuthenticatorEndpointGDTCStageRequest
import dev.greyfoundry.authentik.generated.model.AuthenticatorSMSStage
import dev.greyfoundry.authentik.generated.model.AuthenticatorSMSStageRequest
import dev.greyfoundry.authentik.generated.model.AuthenticatorStaticStage
import dev.greyfoundry.authentik.generated.model.AuthenticatorStaticStageRequest
import dev.greyfoundry.authentik.generated.model.AuthenticatorTOTPStage
import dev.greyfoundry.authentik.generated.model.AuthenticatorTOTPStageRequest
import dev.greyfoundry.authentik.generated.model.AuthenticatorValidateStage
import dev.greyfoundry.authentik.generated.model.AuthenticatorValidateStageRequest
import dev.greyfoundry.authentik.generated.model.AuthenticatorWebAuthnStage
import dev.greyfoundry.authentik.generated.model.AuthenticatorWebAuthnStageRequest
import dev.greyfoundry.authentik.generated.model.CaptchaStage
import dev.greyfoundry.authentik.generated.model.CaptchaStageRequest
import dev.greyfoundry.authentik.generated.model.CertAttributeEnum
import dev.greyfoundry.authentik.generated.model.ConsentModeEnum
import dev.greyfoundry.authentik.generated.model.ConsentStage
import dev.greyfoundry.authentik.generated.model.ConsentStageRequest
import dev.greyfoundry.authentik.generated.model.DenyStage
import dev.greyfoundry.authentik.generated.model.DenyStageRequest
import dev.greyfoundry.authentik.generated.model.DigitsEnum
import dev.greyfoundry.authentik.generated.model.DummyStage
import dev.greyfoundry.authentik.generated.model.DummyStageRequest
import dev.greyfoundry.authentik.generated.model.DuoDeviceEnrollmentStatus
import dev.greyfoundry.authentik.generated.model.EmailStage
import dev.greyfoundry.authentik.generated.model.EmailStageRequest
import dev.greyfoundry.authentik.generated.model.EndpointStage
import dev.greyfoundry.authentik.generated.model.EndpointStageRequest
import dev.greyfoundry.authentik.generated.model.GenericError
import dev.greyfoundry.authentik.generated.model.GeoipBindingEnum
import dev.greyfoundry.authentik.generated.model.IdentificationStage
import dev.greyfoundry.authentik.generated.model.IdentificationStageRequest
import dev.greyfoundry.authentik.generated.model.Invitation
import dev.greyfoundry.authentik.generated.model.InvitationRequest
import dev.greyfoundry.authentik.generated.model.InvitationSendEmailRequest
import dev.greyfoundry.authentik.generated.model.InvitationStage
import dev.greyfoundry.authentik.generated.model.InvitationStageRequest
import dev.greyfoundry.authentik.generated.model.MutualTLSStage
import dev.greyfoundry.authentik.generated.model.MutualTLSStageRequest
import dev.greyfoundry.authentik.generated.model.NetworkBindingEnum
import dev.greyfoundry.authentik.generated.model.NotConfiguredActionEnum
import dev.greyfoundry.authentik.generated.model.PaginatedAccountLockdownStageList
import dev.greyfoundry.authentik.generated.model.PaginatedAuthenticatorDuoStageList
import dev.greyfoundry.authentik.generated.model.PaginatedAuthenticatorEmailStageList
import dev.greyfoundry.authentik.generated.model.PaginatedAuthenticatorEndpointGDTCStageList
import dev.greyfoundry.authentik.generated.model.PaginatedAuthenticatorSMSStageList
import dev.greyfoundry.authentik.generated.model.PaginatedAuthenticatorStaticStageList
import dev.greyfoundry.authentik.generated.model.PaginatedAuthenticatorTOTPStageList
import dev.greyfoundry.authentik.generated.model.PaginatedAuthenticatorValidateStageList
import dev.greyfoundry.authentik.generated.model.PaginatedAuthenticatorWebAuthnStageList
import dev.greyfoundry.authentik.generated.model.PaginatedCaptchaStageList
import dev.greyfoundry.authentik.generated.model.PaginatedConsentStageList
import dev.greyfoundry.authentik.generated.model.PaginatedDenyStageList
import dev.greyfoundry.authentik.generated.model.PaginatedDummyStageList
import dev.greyfoundry.authentik.generated.model.PaginatedEmailStageList
import dev.greyfoundry.authentik.generated.model.PaginatedEndpointStageList
import dev.greyfoundry.authentik.generated.model.PaginatedIdentificationStageList
import dev.greyfoundry.authentik.generated.model.PaginatedInvitationList
import dev.greyfoundry.authentik.generated.model.PaginatedInvitationStageList
import dev.greyfoundry.authentik.generated.model.PaginatedMutualTLSStageList
import dev.greyfoundry.authentik.generated.model.PaginatedPasswordStageList
import dev.greyfoundry.authentik.generated.model.PaginatedPromptList
import dev.greyfoundry.authentik.generated.model.PaginatedPromptStageList
import dev.greyfoundry.authentik.generated.model.PaginatedRedirectStageList
import dev.greyfoundry.authentik.generated.model.PaginatedSourceStageList
import dev.greyfoundry.authentik.generated.model.PaginatedStageList
import dev.greyfoundry.authentik.generated.model.PaginatedUserDeleteStageList
import dev.greyfoundry.authentik.generated.model.PaginatedUserLoginStageList
import dev.greyfoundry.authentik.generated.model.PaginatedUserLogoutStageList
import dev.greyfoundry.authentik.generated.model.PaginatedUserWriteStageList
import dev.greyfoundry.authentik.generated.model.PaginatedWebAuthnDeviceTypeList
import dev.greyfoundry.authentik.generated.model.PasswordStage
import dev.greyfoundry.authentik.generated.model.PasswordStageRequest
import dev.greyfoundry.authentik.generated.model.PatchedAccountLockdownStageRequest
import dev.greyfoundry.authentik.generated.model.PatchedAuthenticatorDuoStageRequest
import dev.greyfoundry.authentik.generated.model.PatchedAuthenticatorEmailStageRequest
import dev.greyfoundry.authentik.generated.model.PatchedAuthenticatorEndpointGDTCStageRequest
import dev.greyfoundry.authentik.generated.model.PatchedAuthenticatorSMSStageRequest
import dev.greyfoundry.authentik.generated.model.PatchedAuthenticatorStaticStageRequest
import dev.greyfoundry.authentik.generated.model.PatchedAuthenticatorTOTPStageRequest
import dev.greyfoundry.authentik.generated.model.PatchedAuthenticatorValidateStageRequest
import dev.greyfoundry.authentik.generated.model.PatchedAuthenticatorWebAuthnStageRequest
import dev.greyfoundry.authentik.generated.model.PatchedCaptchaStageRequest
import dev.greyfoundry.authentik.generated.model.PatchedConsentStageRequest
import dev.greyfoundry.authentik.generated.model.PatchedDenyStageRequest
import dev.greyfoundry.authentik.generated.model.PatchedDummyStageRequest
import dev.greyfoundry.authentik.generated.model.PatchedEmailStageRequest
import dev.greyfoundry.authentik.generated.model.PatchedEndpointStageRequest
import dev.greyfoundry.authentik.generated.model.PatchedIdentificationStageRequest
import dev.greyfoundry.authentik.generated.model.PatchedInvitationRequest
import dev.greyfoundry.authentik.generated.model.PatchedInvitationStageRequest
import dev.greyfoundry.authentik.generated.model.PatchedMutualTLSStageRequest
import dev.greyfoundry.authentik.generated.model.PatchedPasswordStageRequest
import dev.greyfoundry.authentik.generated.model.PatchedPromptRequest
import dev.greyfoundry.authentik.generated.model.PatchedPromptStageRequest
import dev.greyfoundry.authentik.generated.model.PatchedRedirectStageRequest
import dev.greyfoundry.authentik.generated.model.PatchedSourceStageRequest
import dev.greyfoundry.authentik.generated.model.PatchedUserDeleteStageRequest
import dev.greyfoundry.authentik.generated.model.PatchedUserLoginStageRequest
import dev.greyfoundry.authentik.generated.model.PatchedUserLogoutStageRequest
import dev.greyfoundry.authentik.generated.model.PatchedUserWriteStageRequest
import dev.greyfoundry.authentik.generated.model.Prompt
import dev.greyfoundry.authentik.generated.model.PromptChallenge
import dev.greyfoundry.authentik.generated.model.PromptRequest
import dev.greyfoundry.authentik.generated.model.PromptStage
import dev.greyfoundry.authentik.generated.model.PromptStageRequest
import dev.greyfoundry.authentik.generated.model.PromptTypeEnum
import dev.greyfoundry.authentik.generated.model.ProviderEnum
import dev.greyfoundry.authentik.generated.model.RedirectStage
import dev.greyfoundry.authentik.generated.model.RedirectStageRequest
import dev.greyfoundry.authentik.generated.model.SourceStage
import dev.greyfoundry.authentik.generated.model.SourceStageRequest
import dev.greyfoundry.authentik.generated.model.Stage
import dev.greyfoundry.authentik.generated.model.StageModeEnum
import dev.greyfoundry.authentik.generated.model.TypeCreate
import dev.greyfoundry.authentik.generated.model.UsedBy
import dev.greyfoundry.authentik.generated.model.UserAttributeEnum
import dev.greyfoundry.authentik.generated.model.UserCreationModeEnum
import dev.greyfoundry.authentik.generated.model.UserDeleteStage
import dev.greyfoundry.authentik.generated.model.UserDeleteStageRequest
import dev.greyfoundry.authentik.generated.model.UserLoginStage
import dev.greyfoundry.authentik.generated.model.UserLoginStageRequest
import dev.greyfoundry.authentik.generated.model.UserLogoutStage
import dev.greyfoundry.authentik.generated.model.UserLogoutStageRequest
import dev.greyfoundry.authentik.generated.model.UserSetting
import dev.greyfoundry.authentik.generated.model.UserTypeEnum
import dev.greyfoundry.authentik.generated.model.UserVerificationEnum
import dev.greyfoundry.authentik.generated.model.UserWriteStage
import dev.greyfoundry.authentik.generated.model.UserWriteStageRequest
import dev.greyfoundry.authentik.generated.model.ValidationError
import dev.greyfoundry.authentik.generated.model.WebAuthnDeviceType

interface StagesApi {
    /**
     * POST stages/account_lockdown/
     *
     * AccountLockdownStage Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param accountLockdownStageRequest
     * @return [AccountLockdownStage]
     */
    @POST("stages/account_lockdown/")
    suspend fun stagesAccountLockdownCreate(@Body accountLockdownStageRequest: AccountLockdownStageRequest): Response<AccountLockdownStage>

    /**
     * DELETE stages/account_lockdown/{stage_uuid}/
     *
     * AccountLockdownStage Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Account Lockdown Stage.
     * @return [Unit]
     */
    @DELETE("stages/account_lockdown/{stage_uuid}/")
    suspend fun stagesAccountLockdownDestroy(@Path("stage_uuid") stageUuid: java.util.UUID): Response<Unit>

    /**
     * GET stages/account_lockdown/
     *
     * AccountLockdownStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param deactivateUser  (optional)
     * @param deleteSessions  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param revokeTokens  (optional)
     * @param search A search term. (optional)
     * @param selfServiceCompletionFlow  (optional)
     * @param setUnusablePassword  (optional)
     * @param stageUuid  (optional)
     * @return [PaginatedAccountLockdownStageList]
     */
    @GET("stages/account_lockdown/")
    suspend fun stagesAccountLockdownList(@Query("deactivate_user") deactivateUser: kotlin.Boolean? = null, @Query("delete_sessions") deleteSessions: kotlin.Boolean? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("revoke_tokens") revokeTokens: kotlin.Boolean? = null, @Query("search") search: kotlin.String? = null, @Query("self_service_completion_flow") selfServiceCompletionFlow: java.util.UUID? = null, @Query("set_unusable_password") setUnusablePassword: kotlin.Boolean? = null, @Query("stage_uuid") stageUuid: java.util.UUID? = null): Response<PaginatedAccountLockdownStageList>

    /**
     * PATCH stages/account_lockdown/{stage_uuid}/
     *
     * AccountLockdownStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Account Lockdown Stage.
     * @param patchedAccountLockdownStageRequest  (optional)
     * @return [AccountLockdownStage]
     */
    @PATCH("stages/account_lockdown/{stage_uuid}/")
    suspend fun stagesAccountLockdownPartialUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body patchedAccountLockdownStageRequest: PatchedAccountLockdownStageRequest? = null): Response<AccountLockdownStage>

    /**
     * GET stages/account_lockdown/{stage_uuid}/
     *
     * AccountLockdownStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Account Lockdown Stage.
     * @return [AccountLockdownStage]
     */
    @GET("stages/account_lockdown/{stage_uuid}/")
    suspend fun stagesAccountLockdownRetrieve(@Path("stage_uuid") stageUuid: java.util.UUID): Response<AccountLockdownStage>

    /**
     * PUT stages/account_lockdown/{stage_uuid}/
     *
     * AccountLockdownStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Account Lockdown Stage.
     * @param accountLockdownStageRequest
     * @return [AccountLockdownStage]
     */
    @PUT("stages/account_lockdown/{stage_uuid}/")
    suspend fun stagesAccountLockdownUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body accountLockdownStageRequest: AccountLockdownStageRequest): Response<AccountLockdownStage>

    /**
     * GET stages/account_lockdown/{stage_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Account Lockdown Stage.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("stages/account_lockdown/{stage_uuid}/used_by/")
    suspend fun stagesAccountLockdownUsedByList(@Path("stage_uuid") stageUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * DELETE stages/all/{stage_uuid}/
     *
     * Stage Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this stage.
     * @return [Unit]
     */
    @DELETE("stages/all/{stage_uuid}/")
    suspend fun stagesAllDestroy(@Path("stage_uuid") stageUuid: java.util.UUID): Response<Unit>

    /**
     * GET stages/all/
     *
     * Stage Viewset
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
     * @return [PaginatedStageList]
     */
    @GET("stages/all/")
    suspend fun stagesAllList(@Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedStageList>

    /**
     * GET stages/all/{stage_uuid}/
     *
     * Stage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this stage.
     * @return [Stage]
     */
    @GET("stages/all/{stage_uuid}/")
    suspend fun stagesAllRetrieve(@Path("stage_uuid") stageUuid: java.util.UUID): Response<Stage>

    /**
     * GET stages/all/types/
     *
     * Get all creatable types
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @return [kotlin.collections.List<TypeCreate>]
     */
    @GET("stages/all/types/")
    suspend fun stagesAllTypesList(): Response<kotlin.collections.List<TypeCreate>>

    /**
     * GET stages/all/{stage_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this stage.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("stages/all/{stage_uuid}/used_by/")
    suspend fun stagesAllUsedByList(@Path("stage_uuid") stageUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * GET stages/all/user_settings/
     *
     * Get all stages the user can configure
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @return [kotlin.collections.List<UserSetting>]
     */
    @GET("stages/all/user_settings/")
    suspend fun stagesAllUserSettingsList(): Response<kotlin.collections.List<UserSetting>>

    /**
     * POST stages/authenticator/duo/
     *
     * AuthenticatorDuoStage Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param authenticatorDuoStageRequest
     * @return [AuthenticatorDuoStage]
     */
    @POST("stages/authenticator/duo/")
    suspend fun stagesAuthenticatorDuoCreate(@Body authenticatorDuoStageRequest: AuthenticatorDuoStageRequest): Response<AuthenticatorDuoStage>

    /**
     * DELETE stages/authenticator/duo/{stage_uuid}/
     *
     * AuthenticatorDuoStage Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Duo Authenticator Setup Stage.
     * @return [Unit]
     */
    @DELETE("stages/authenticator/duo/{stage_uuid}/")
    suspend fun stagesAuthenticatorDuoDestroy(@Path("stage_uuid") stageUuid: java.util.UUID): Response<Unit>

    /**
     * POST stages/authenticator/duo/{stage_uuid}/enrollment_status/
     *
     * Check enrollment status of user details in current session
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Duo Authenticator Setup Stage.
     * @return [DuoDeviceEnrollmentStatus]
     */
    @POST("stages/authenticator/duo/{stage_uuid}/enrollment_status/")
    suspend fun stagesAuthenticatorDuoEnrollmentStatusCreate(@Path("stage_uuid") stageUuid: java.util.UUID): Response<DuoDeviceEnrollmentStatus>

    /**
     * POST stages/authenticator/duo/{stage_uuid}/import_device_manual/
     *
     * Import duo devices into authentik
     * Responses:
     *  - 204: Enrollment successful
     *  - 400: Bad request
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Duo Authenticator Setup Stage.
     * @param authenticatorDuoStageManualDeviceImportRequest
     * @return [Unit]
     */
    @POST("stages/authenticator/duo/{stage_uuid}/import_device_manual/")
    suspend fun stagesAuthenticatorDuoImportDeviceManualCreate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body authenticatorDuoStageManualDeviceImportRequest: AuthenticatorDuoStageManualDeviceImportRequest): Response<Unit>

    /**
     * POST stages/authenticator/duo/{stage_uuid}/import_devices_automatic/
     *
     * Import duo devices into authentik
     * Responses:
     *  - 200:
     *  - 400: Bad request
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Duo Authenticator Setup Stage.
     * @return [AuthenticatorDuoStageDeviceImportResponse]
     */
    @POST("stages/authenticator/duo/{stage_uuid}/import_devices_automatic/")
    suspend fun stagesAuthenticatorDuoImportDevicesAutomaticCreate(@Path("stage_uuid") stageUuid: java.util.UUID): Response<AuthenticatorDuoStageDeviceImportResponse>

    /**
     * GET stages/authenticator/duo/
     *
     * AuthenticatorDuoStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param apiHostname  (optional)
     * @param clientId  (optional)
     * @param configureFlow  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedAuthenticatorDuoStageList]
     */
    @GET("stages/authenticator/duo/")
    suspend fun stagesAuthenticatorDuoList(@Query("api_hostname") apiHostname: kotlin.String? = null, @Query("client_id") clientId: kotlin.String? = null, @Query("configure_flow") configureFlow: java.util.UUID? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedAuthenticatorDuoStageList>

    /**
     * PATCH stages/authenticator/duo/{stage_uuid}/
     *
     * AuthenticatorDuoStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Duo Authenticator Setup Stage.
     * @param patchedAuthenticatorDuoStageRequest  (optional)
     * @return [AuthenticatorDuoStage]
     */
    @PATCH("stages/authenticator/duo/{stage_uuid}/")
    suspend fun stagesAuthenticatorDuoPartialUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body patchedAuthenticatorDuoStageRequest: PatchedAuthenticatorDuoStageRequest? = null): Response<AuthenticatorDuoStage>

    /**
     * GET stages/authenticator/duo/{stage_uuid}/
     *
     * AuthenticatorDuoStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Duo Authenticator Setup Stage.
     * @return [AuthenticatorDuoStage]
     */
    @GET("stages/authenticator/duo/{stage_uuid}/")
    suspend fun stagesAuthenticatorDuoRetrieve(@Path("stage_uuid") stageUuid: java.util.UUID): Response<AuthenticatorDuoStage>

    /**
     * PUT stages/authenticator/duo/{stage_uuid}/
     *
     * AuthenticatorDuoStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Duo Authenticator Setup Stage.
     * @param authenticatorDuoStageRequest
     * @return [AuthenticatorDuoStage]
     */
    @PUT("stages/authenticator/duo/{stage_uuid}/")
    suspend fun stagesAuthenticatorDuoUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body authenticatorDuoStageRequest: AuthenticatorDuoStageRequest): Response<AuthenticatorDuoStage>

    /**
     * GET stages/authenticator/duo/{stage_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Duo Authenticator Setup Stage.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("stages/authenticator/duo/{stage_uuid}/used_by/")
    suspend fun stagesAuthenticatorDuoUsedByList(@Path("stage_uuid") stageUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST stages/authenticator/email/
     *
     * AuthenticatorEmailStage Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param authenticatorEmailStageRequest
     * @return [AuthenticatorEmailStage]
     */
    @POST("stages/authenticator/email/")
    suspend fun stagesAuthenticatorEmailCreate(@Body authenticatorEmailStageRequest: AuthenticatorEmailStageRequest): Response<AuthenticatorEmailStage>

    /**
     * DELETE stages/authenticator/email/{stage_uuid}/
     *
     * AuthenticatorEmailStage Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Email Authenticator Setup Stage.
     * @return [Unit]
     */
    @DELETE("stages/authenticator/email/{stage_uuid}/")
    suspend fun stagesAuthenticatorEmailDestroy(@Path("stage_uuid") stageUuid: java.util.UUID): Response<Unit>

    /**
     * GET stages/authenticator/email/
     *
     * AuthenticatorEmailStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param configureFlow  (optional)
     * @param friendlyName  (optional)
     * @param fromAddress  (optional)
     * @param host  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param password  (optional)
     * @param port  (optional)
     * @param search A search term. (optional)
     * @param stageUuid  (optional)
     * @param subject  (optional)
     * @param template  (optional)
     * @param timeout  (optional)
     * @param tokenExpiry  (optional)
     * @param useGlobalSettings  (optional)
     * @param useSsl  (optional)
     * @param useTls  (optional)
     * @param username  (optional)
     * @return [PaginatedAuthenticatorEmailStageList]
     */
    @GET("stages/authenticator/email/")
    suspend fun stagesAuthenticatorEmailList(@Query("configure_flow") configureFlow: java.util.UUID? = null, @Query("friendly_name") friendlyName: kotlin.String? = null, @Query("from_address") fromAddress: kotlin.String? = null, @Query("host") host: kotlin.String? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("password") password: kotlin.String? = null, @Query("port") port: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("stage_uuid") stageUuid: java.util.UUID? = null, @Query("subject") subject: kotlin.String? = null, @Query("template") template: kotlin.String? = null, @Query("timeout") timeout: kotlin.Int? = null, @Query("token_expiry") tokenExpiry: kotlin.String? = null, @Query("use_global_settings") useGlobalSettings: kotlin.Boolean? = null, @Query("use_ssl") useSsl: kotlin.Boolean? = null, @Query("use_tls") useTls: kotlin.Boolean? = null, @Query("username") username: kotlin.String? = null): Response<PaginatedAuthenticatorEmailStageList>

    /**
     * PATCH stages/authenticator/email/{stage_uuid}/
     *
     * AuthenticatorEmailStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Email Authenticator Setup Stage.
     * @param patchedAuthenticatorEmailStageRequest  (optional)
     * @return [AuthenticatorEmailStage]
     */
    @PATCH("stages/authenticator/email/{stage_uuid}/")
    suspend fun stagesAuthenticatorEmailPartialUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body patchedAuthenticatorEmailStageRequest: PatchedAuthenticatorEmailStageRequest? = null): Response<AuthenticatorEmailStage>

    /**
     * GET stages/authenticator/email/{stage_uuid}/
     *
     * AuthenticatorEmailStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Email Authenticator Setup Stage.
     * @return [AuthenticatorEmailStage]
     */
    @GET("stages/authenticator/email/{stage_uuid}/")
    suspend fun stagesAuthenticatorEmailRetrieve(@Path("stage_uuid") stageUuid: java.util.UUID): Response<AuthenticatorEmailStage>

    /**
     * PUT stages/authenticator/email/{stage_uuid}/
     *
     * AuthenticatorEmailStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Email Authenticator Setup Stage.
     * @param authenticatorEmailStageRequest
     * @return [AuthenticatorEmailStage]
     */
    @PUT("stages/authenticator/email/{stage_uuid}/")
    suspend fun stagesAuthenticatorEmailUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body authenticatorEmailStageRequest: AuthenticatorEmailStageRequest): Response<AuthenticatorEmailStage>

    /**
     * GET stages/authenticator/email/{stage_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Email Authenticator Setup Stage.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("stages/authenticator/email/{stage_uuid}/used_by/")
    suspend fun stagesAuthenticatorEmailUsedByList(@Path("stage_uuid") stageUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST stages/authenticator/endpoint_gdtc/
     *
     * AuthenticatorEndpointGDTCStage Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param authenticatorEndpointGDTCStageRequest
     * @return [AuthenticatorEndpointGDTCStage]
     */
    @POST("stages/authenticator/endpoint_gdtc/")
    suspend fun stagesAuthenticatorEndpointGdtcCreate(@Body authenticatorEndpointGDTCStageRequest: AuthenticatorEndpointGDTCStageRequest): Response<AuthenticatorEndpointGDTCStage>

    /**
     * DELETE stages/authenticator/endpoint_gdtc/{stage_uuid}/
     *
     * AuthenticatorEndpointGDTCStage Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Endpoint Authenticator Google Device Trust Connector Stage.
     * @return [Unit]
     */
    @DELETE("stages/authenticator/endpoint_gdtc/{stage_uuid}/")
    suspend fun stagesAuthenticatorEndpointGdtcDestroy(@Path("stage_uuid") stageUuid: java.util.UUID): Response<Unit>

    /**
     * GET stages/authenticator/endpoint_gdtc/
     *
     * AuthenticatorEndpointGDTCStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param configureFlow  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedAuthenticatorEndpointGDTCStageList]
     */
    @GET("stages/authenticator/endpoint_gdtc/")
    suspend fun stagesAuthenticatorEndpointGdtcList(@Query("configure_flow") configureFlow: java.util.UUID? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedAuthenticatorEndpointGDTCStageList>

    /**
     * PATCH stages/authenticator/endpoint_gdtc/{stage_uuid}/
     *
     * AuthenticatorEndpointGDTCStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Endpoint Authenticator Google Device Trust Connector Stage.
     * @param patchedAuthenticatorEndpointGDTCStageRequest  (optional)
     * @return [AuthenticatorEndpointGDTCStage]
     */
    @PATCH("stages/authenticator/endpoint_gdtc/{stage_uuid}/")
    suspend fun stagesAuthenticatorEndpointGdtcPartialUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body patchedAuthenticatorEndpointGDTCStageRequest: PatchedAuthenticatorEndpointGDTCStageRequest? = null): Response<AuthenticatorEndpointGDTCStage>

    /**
     * GET stages/authenticator/endpoint_gdtc/{stage_uuid}/
     *
     * AuthenticatorEndpointGDTCStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Endpoint Authenticator Google Device Trust Connector Stage.
     * @return [AuthenticatorEndpointGDTCStage]
     */
    @GET("stages/authenticator/endpoint_gdtc/{stage_uuid}/")
    suspend fun stagesAuthenticatorEndpointGdtcRetrieve(@Path("stage_uuid") stageUuid: java.util.UUID): Response<AuthenticatorEndpointGDTCStage>

    /**
     * PUT stages/authenticator/endpoint_gdtc/{stage_uuid}/
     *
     * AuthenticatorEndpointGDTCStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Endpoint Authenticator Google Device Trust Connector Stage.
     * @param authenticatorEndpointGDTCStageRequest
     * @return [AuthenticatorEndpointGDTCStage]
     */
    @PUT("stages/authenticator/endpoint_gdtc/{stage_uuid}/")
    suspend fun stagesAuthenticatorEndpointGdtcUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body authenticatorEndpointGDTCStageRequest: AuthenticatorEndpointGDTCStageRequest): Response<AuthenticatorEndpointGDTCStage>

    /**
     * GET stages/authenticator/endpoint_gdtc/{stage_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Endpoint Authenticator Google Device Trust Connector Stage.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("stages/authenticator/endpoint_gdtc/{stage_uuid}/used_by/")
    suspend fun stagesAuthenticatorEndpointGdtcUsedByList(@Path("stage_uuid") stageUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST stages/authenticator/sms/
     *
     * AuthenticatorSMSStage Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param authenticatorSMSStageRequest
     * @return [AuthenticatorSMSStage]
     */
    @POST("stages/authenticator/sms/")
    suspend fun stagesAuthenticatorSmsCreate(@Body authenticatorSMSStageRequest: AuthenticatorSMSStageRequest): Response<AuthenticatorSMSStage>

    /**
     * DELETE stages/authenticator/sms/{stage_uuid}/
     *
     * AuthenticatorSMSStage Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this SMS Authenticator Setup Stage.
     * @return [Unit]
     */
    @DELETE("stages/authenticator/sms/{stage_uuid}/")
    suspend fun stagesAuthenticatorSmsDestroy(@Path("stage_uuid") stageUuid: java.util.UUID): Response<Unit>

    /**
     * GET stages/authenticator/sms/
     *
     * AuthenticatorSMSStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param accountSid  (optional)
     * @param auth  (optional)
     * @param authPassword  (optional)
     * @param authType  (optional)
     * @param configureFlow  (optional)
     * @param friendlyName  (optional)
     * @param fromNumber  (optional)
     * @param mapping  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param provider  (optional)
     * @param search A search term. (optional)
     * @param stageUuid  (optional)
     * @param verifyOnly  (optional)
     * @return [PaginatedAuthenticatorSMSStageList]
     */
    @GET("stages/authenticator/sms/")
    suspend fun stagesAuthenticatorSmsList(@Query("account_sid") accountSid: kotlin.String? = null, @Query("auth") auth: kotlin.String? = null, @Query("auth_password") authPassword: kotlin.String? = null, @Query("auth_type") authType: AuthTypeEnum? = null, @Query("configure_flow") configureFlow: java.util.UUID? = null, @Query("friendly_name") friendlyName: kotlin.String? = null, @Query("from_number") fromNumber: kotlin.String? = null, @Query("mapping") mapping: java.util.UUID? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("provider") provider: ProviderEnum? = null, @Query("search") search: kotlin.String? = null, @Query("stage_uuid") stageUuid: java.util.UUID? = null, @Query("verify_only") verifyOnly: kotlin.Boolean? = null): Response<PaginatedAuthenticatorSMSStageList>

    /**
     * PATCH stages/authenticator/sms/{stage_uuid}/
     *
     * AuthenticatorSMSStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this SMS Authenticator Setup Stage.
     * @param patchedAuthenticatorSMSStageRequest  (optional)
     * @return [AuthenticatorSMSStage]
     */
    @PATCH("stages/authenticator/sms/{stage_uuid}/")
    suspend fun stagesAuthenticatorSmsPartialUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body patchedAuthenticatorSMSStageRequest: PatchedAuthenticatorSMSStageRequest? = null): Response<AuthenticatorSMSStage>

    /**
     * GET stages/authenticator/sms/{stage_uuid}/
     *
     * AuthenticatorSMSStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this SMS Authenticator Setup Stage.
     * @return [AuthenticatorSMSStage]
     */
    @GET("stages/authenticator/sms/{stage_uuid}/")
    suspend fun stagesAuthenticatorSmsRetrieve(@Path("stage_uuid") stageUuid: java.util.UUID): Response<AuthenticatorSMSStage>

    /**
     * PUT stages/authenticator/sms/{stage_uuid}/
     *
     * AuthenticatorSMSStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this SMS Authenticator Setup Stage.
     * @param authenticatorSMSStageRequest
     * @return [AuthenticatorSMSStage]
     */
    @PUT("stages/authenticator/sms/{stage_uuid}/")
    suspend fun stagesAuthenticatorSmsUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body authenticatorSMSStageRequest: AuthenticatorSMSStageRequest): Response<AuthenticatorSMSStage>

    /**
     * GET stages/authenticator/sms/{stage_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this SMS Authenticator Setup Stage.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("stages/authenticator/sms/{stage_uuid}/used_by/")
    suspend fun stagesAuthenticatorSmsUsedByList(@Path("stage_uuid") stageUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST stages/authenticator/static/
     *
     * AuthenticatorStaticStage Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param authenticatorStaticStageRequest
     * @return [AuthenticatorStaticStage]
     */
    @POST("stages/authenticator/static/")
    suspend fun stagesAuthenticatorStaticCreate(@Body authenticatorStaticStageRequest: AuthenticatorStaticStageRequest): Response<AuthenticatorStaticStage>

    /**
     * DELETE stages/authenticator/static/{stage_uuid}/
     *
     * AuthenticatorStaticStage Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Static Authenticator Setup Stage.
     * @return [Unit]
     */
    @DELETE("stages/authenticator/static/{stage_uuid}/")
    suspend fun stagesAuthenticatorStaticDestroy(@Path("stage_uuid") stageUuid: java.util.UUID): Response<Unit>

    /**
     * GET stages/authenticator/static/
     *
     * AuthenticatorStaticStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param configureFlow  (optional)
     * @param friendlyName  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param stageUuid  (optional)
     * @param tokenCount  (optional)
     * @param tokenLength  (optional)
     * @return [PaginatedAuthenticatorStaticStageList]
     */
    @GET("stages/authenticator/static/")
    suspend fun stagesAuthenticatorStaticList(@Query("configure_flow") configureFlow: java.util.UUID? = null, @Query("friendly_name") friendlyName: kotlin.String? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("stage_uuid") stageUuid: java.util.UUID? = null, @Query("token_count") tokenCount: kotlin.Int? = null, @Query("token_length") tokenLength: kotlin.Int? = null): Response<PaginatedAuthenticatorStaticStageList>

    /**
     * PATCH stages/authenticator/static/{stage_uuid}/
     *
     * AuthenticatorStaticStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Static Authenticator Setup Stage.
     * @param patchedAuthenticatorStaticStageRequest  (optional)
     * @return [AuthenticatorStaticStage]
     */
    @PATCH("stages/authenticator/static/{stage_uuid}/")
    suspend fun stagesAuthenticatorStaticPartialUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body patchedAuthenticatorStaticStageRequest: PatchedAuthenticatorStaticStageRequest? = null): Response<AuthenticatorStaticStage>

    /**
     * GET stages/authenticator/static/{stage_uuid}/
     *
     * AuthenticatorStaticStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Static Authenticator Setup Stage.
     * @return [AuthenticatorStaticStage]
     */
    @GET("stages/authenticator/static/{stage_uuid}/")
    suspend fun stagesAuthenticatorStaticRetrieve(@Path("stage_uuid") stageUuid: java.util.UUID): Response<AuthenticatorStaticStage>

    /**
     * PUT stages/authenticator/static/{stage_uuid}/
     *
     * AuthenticatorStaticStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Static Authenticator Setup Stage.
     * @param authenticatorStaticStageRequest
     * @return [AuthenticatorStaticStage]
     */
    @PUT("stages/authenticator/static/{stage_uuid}/")
    suspend fun stagesAuthenticatorStaticUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body authenticatorStaticStageRequest: AuthenticatorStaticStageRequest): Response<AuthenticatorStaticStage>

    /**
     * GET stages/authenticator/static/{stage_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Static Authenticator Setup Stage.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("stages/authenticator/static/{stage_uuid}/used_by/")
    suspend fun stagesAuthenticatorStaticUsedByList(@Path("stage_uuid") stageUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST stages/authenticator/totp/
     *
     * AuthenticatorTOTPStage Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param authenticatorTOTPStageRequest
     * @return [AuthenticatorTOTPStage]
     */
    @POST("stages/authenticator/totp/")
    suspend fun stagesAuthenticatorTotpCreate(@Body authenticatorTOTPStageRequest: AuthenticatorTOTPStageRequest): Response<AuthenticatorTOTPStage>

    /**
     * DELETE stages/authenticator/totp/{stage_uuid}/
     *
     * AuthenticatorTOTPStage Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this TOTP Authenticator Setup Stage.
     * @return [Unit]
     */
    @DELETE("stages/authenticator/totp/{stage_uuid}/")
    suspend fun stagesAuthenticatorTotpDestroy(@Path("stage_uuid") stageUuid: java.util.UUID): Response<Unit>

    /**
     * GET stages/authenticator/totp/
     *
     * AuthenticatorTOTPStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param configureFlow  (optional)
     * @param digits  (optional)
     * @param friendlyName  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param stageUuid  (optional)
     * @return [PaginatedAuthenticatorTOTPStageList]
     */
    @GET("stages/authenticator/totp/")
    suspend fun stagesAuthenticatorTotpList(@Query("configure_flow") configureFlow: java.util.UUID? = null, @Query("digits") digits: DigitsEnum? = null, @Query("friendly_name") friendlyName: kotlin.String? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("stage_uuid") stageUuid: java.util.UUID? = null): Response<PaginatedAuthenticatorTOTPStageList>

    /**
     * PATCH stages/authenticator/totp/{stage_uuid}/
     *
     * AuthenticatorTOTPStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this TOTP Authenticator Setup Stage.
     * @param patchedAuthenticatorTOTPStageRequest  (optional)
     * @return [AuthenticatorTOTPStage]
     */
    @PATCH("stages/authenticator/totp/{stage_uuid}/")
    suspend fun stagesAuthenticatorTotpPartialUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body patchedAuthenticatorTOTPStageRequest: PatchedAuthenticatorTOTPStageRequest? = null): Response<AuthenticatorTOTPStage>

    /**
     * GET stages/authenticator/totp/{stage_uuid}/
     *
     * AuthenticatorTOTPStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this TOTP Authenticator Setup Stage.
     * @return [AuthenticatorTOTPStage]
     */
    @GET("stages/authenticator/totp/{stage_uuid}/")
    suspend fun stagesAuthenticatorTotpRetrieve(@Path("stage_uuid") stageUuid: java.util.UUID): Response<AuthenticatorTOTPStage>

    /**
     * PUT stages/authenticator/totp/{stage_uuid}/
     *
     * AuthenticatorTOTPStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this TOTP Authenticator Setup Stage.
     * @param authenticatorTOTPStageRequest
     * @return [AuthenticatorTOTPStage]
     */
    @PUT("stages/authenticator/totp/{stage_uuid}/")
    suspend fun stagesAuthenticatorTotpUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body authenticatorTOTPStageRequest: AuthenticatorTOTPStageRequest): Response<AuthenticatorTOTPStage>

    /**
     * GET stages/authenticator/totp/{stage_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this TOTP Authenticator Setup Stage.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("stages/authenticator/totp/{stage_uuid}/used_by/")
    suspend fun stagesAuthenticatorTotpUsedByList(@Path("stage_uuid") stageUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST stages/authenticator/validate/
     *
     * AuthenticatorValidateStage Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param authenticatorValidateStageRequest
     * @return [AuthenticatorValidateStage]
     */
    @POST("stages/authenticator/validate/")
    suspend fun stagesAuthenticatorValidateCreate(@Body authenticatorValidateStageRequest: AuthenticatorValidateStageRequest): Response<AuthenticatorValidateStage>

    /**
     * DELETE stages/authenticator/validate/{stage_uuid}/
     *
     * AuthenticatorValidateStage Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Authenticator Validation Stage.
     * @return [Unit]
     */
    @DELETE("stages/authenticator/validate/{stage_uuid}/")
    suspend fun stagesAuthenticatorValidateDestroy(@Path("stage_uuid") stageUuid: java.util.UUID): Response<Unit>

    /**
     * GET stages/authenticator/validate/
     *
     * AuthenticatorValidateStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param configurationStages  (optional)
     * @param name  (optional)
     * @param notConfiguredAction  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedAuthenticatorValidateStageList]
     */
    @GET("stages/authenticator/validate/")
    suspend fun stagesAuthenticatorValidateList(@Query("configuration_stages") configurationStages: @JvmSuppressWildcards kotlin.collections.List<java.util.UUID>? = null, @Query("name") name: kotlin.String? = null, @Query("not_configured_action") notConfiguredAction: NotConfiguredActionEnum? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedAuthenticatorValidateStageList>

    /**
     * PATCH stages/authenticator/validate/{stage_uuid}/
     *
     * AuthenticatorValidateStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Authenticator Validation Stage.
     * @param patchedAuthenticatorValidateStageRequest  (optional)
     * @return [AuthenticatorValidateStage]
     */
    @PATCH("stages/authenticator/validate/{stage_uuid}/")
    suspend fun stagesAuthenticatorValidatePartialUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body patchedAuthenticatorValidateStageRequest: PatchedAuthenticatorValidateStageRequest? = null): Response<AuthenticatorValidateStage>

    /**
     * GET stages/authenticator/validate/{stage_uuid}/
     *
     * AuthenticatorValidateStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Authenticator Validation Stage.
     * @return [AuthenticatorValidateStage]
     */
    @GET("stages/authenticator/validate/{stage_uuid}/")
    suspend fun stagesAuthenticatorValidateRetrieve(@Path("stage_uuid") stageUuid: java.util.UUID): Response<AuthenticatorValidateStage>

    /**
     * PUT stages/authenticator/validate/{stage_uuid}/
     *
     * AuthenticatorValidateStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Authenticator Validation Stage.
     * @param authenticatorValidateStageRequest
     * @return [AuthenticatorValidateStage]
     */
    @PUT("stages/authenticator/validate/{stage_uuid}/")
    suspend fun stagesAuthenticatorValidateUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body authenticatorValidateStageRequest: AuthenticatorValidateStageRequest): Response<AuthenticatorValidateStage>

    /**
     * GET stages/authenticator/validate/{stage_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Authenticator Validation Stage.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("stages/authenticator/validate/{stage_uuid}/used_by/")
    suspend fun stagesAuthenticatorValidateUsedByList(@Path("stage_uuid") stageUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST stages/authenticator/webauthn/
     *
     * AuthenticatorWebAuthnStage Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param authenticatorWebAuthnStageRequest
     * @return [AuthenticatorWebAuthnStage]
     */
    @POST("stages/authenticator/webauthn/")
    suspend fun stagesAuthenticatorWebauthnCreate(@Body authenticatorWebAuthnStageRequest: AuthenticatorWebAuthnStageRequest): Response<AuthenticatorWebAuthnStage>

    /**
     * DELETE stages/authenticator/webauthn/{stage_uuid}/
     *
     * AuthenticatorWebAuthnStage Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this WebAuthn Authenticator Setup Stage.
     * @return [Unit]
     */
    @DELETE("stages/authenticator/webauthn/{stage_uuid}/")
    suspend fun stagesAuthenticatorWebauthnDestroy(@Path("stage_uuid") stageUuid: java.util.UUID): Response<Unit>

    /**
     * GET stages/authenticator/webauthn_device_types/
     *
     * WebAuthnDeviceType Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param aaguid  (optional)
     * @param description  (optional)
     * @param icon  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedWebAuthnDeviceTypeList]
     */
    @GET("stages/authenticator/webauthn_device_types/")
    suspend fun stagesAuthenticatorWebauthnDeviceTypesList(@Query("aaguid") aaguid: java.util.UUID? = null, @Query("description") description: kotlin.String? = null, @Query("icon") icon: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedWebAuthnDeviceTypeList>

    /**
     * GET stages/authenticator/webauthn_device_types/{aaguid}/
     *
     * WebAuthnDeviceType Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param aaguid A UUID string identifying this WebAuthn Device type.
     * @return [WebAuthnDeviceType]
     */
    @GET("stages/authenticator/webauthn_device_types/{aaguid}/")
    suspend fun stagesAuthenticatorWebauthnDeviceTypesRetrieve(@Path("aaguid") aaguid: java.util.UUID): Response<WebAuthnDeviceType>

    /**
     * GET stages/authenticator/webauthn/
     *
     * AuthenticatorWebAuthnStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param authenticatorAttachment  (optional)
     * @param configureFlow  (optional)
     * @param deviceTypeRestrictions  (optional)
     * @param maxAttempts  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param residentKeyRequirement  (optional)
     * @param search A search term. (optional)
     * @param userVerification  (optional)
     * @return [PaginatedAuthenticatorWebAuthnStageList]
     */
    @GET("stages/authenticator/webauthn/")
    suspend fun stagesAuthenticatorWebauthnList(@Query("authenticator_attachment") authenticatorAttachment: AuthenticatorAttachmentEnum? = null, @Query("configure_flow") configureFlow: java.util.UUID? = null, @Query("device_type_restrictions") deviceTypeRestrictions: @JvmSuppressWildcards kotlin.collections.List<java.util.UUID>? = null, @Query("max_attempts") maxAttempts: kotlin.Int? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("resident_key_requirement") residentKeyRequirement: UserVerificationEnum? = null, @Query("search") search: kotlin.String? = null, @Query("user_verification") userVerification: UserVerificationEnum? = null): Response<PaginatedAuthenticatorWebAuthnStageList>

    /**
     * PATCH stages/authenticator/webauthn/{stage_uuid}/
     *
     * AuthenticatorWebAuthnStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this WebAuthn Authenticator Setup Stage.
     * @param patchedAuthenticatorWebAuthnStageRequest  (optional)
     * @return [AuthenticatorWebAuthnStage]
     */
    @PATCH("stages/authenticator/webauthn/{stage_uuid}/")
    suspend fun stagesAuthenticatorWebauthnPartialUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body patchedAuthenticatorWebAuthnStageRequest: PatchedAuthenticatorWebAuthnStageRequest? = null): Response<AuthenticatorWebAuthnStage>

    /**
     * GET stages/authenticator/webauthn/{stage_uuid}/
     *
     * AuthenticatorWebAuthnStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this WebAuthn Authenticator Setup Stage.
     * @return [AuthenticatorWebAuthnStage]
     */
    @GET("stages/authenticator/webauthn/{stage_uuid}/")
    suspend fun stagesAuthenticatorWebauthnRetrieve(@Path("stage_uuid") stageUuid: java.util.UUID): Response<AuthenticatorWebAuthnStage>

    /**
     * PUT stages/authenticator/webauthn/{stage_uuid}/
     *
     * AuthenticatorWebAuthnStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this WebAuthn Authenticator Setup Stage.
     * @param authenticatorWebAuthnStageRequest
     * @return [AuthenticatorWebAuthnStage]
     */
    @PUT("stages/authenticator/webauthn/{stage_uuid}/")
    suspend fun stagesAuthenticatorWebauthnUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body authenticatorWebAuthnStageRequest: AuthenticatorWebAuthnStageRequest): Response<AuthenticatorWebAuthnStage>

    /**
     * GET stages/authenticator/webauthn/{stage_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this WebAuthn Authenticator Setup Stage.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("stages/authenticator/webauthn/{stage_uuid}/used_by/")
    suspend fun stagesAuthenticatorWebauthnUsedByList(@Path("stage_uuid") stageUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST stages/captcha/
     *
     * CaptchaStage Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param captchaStageRequest
     * @return [CaptchaStage]
     */
    @POST("stages/captcha/")
    suspend fun stagesCaptchaCreate(@Body captchaStageRequest: CaptchaStageRequest): Response<CaptchaStage>

    /**
     * DELETE stages/captcha/{stage_uuid}/
     *
     * CaptchaStage Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Captcha Stage.
     * @return [Unit]
     */
    @DELETE("stages/captcha/{stage_uuid}/")
    suspend fun stagesCaptchaDestroy(@Path("stage_uuid") stageUuid: java.util.UUID): Response<Unit>

    /**
     * GET stages/captcha/
     *
     * CaptchaStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param publicKey  (optional)
     * @param search A search term. (optional)
     * @return [PaginatedCaptchaStageList]
     */
    @GET("stages/captcha/")
    suspend fun stagesCaptchaList(@Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("public_key") publicKey: kotlin.String? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedCaptchaStageList>

    /**
     * PATCH stages/captcha/{stage_uuid}/
     *
     * CaptchaStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Captcha Stage.
     * @param patchedCaptchaStageRequest  (optional)
     * @return [CaptchaStage]
     */
    @PATCH("stages/captcha/{stage_uuid}/")
    suspend fun stagesCaptchaPartialUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body patchedCaptchaStageRequest: PatchedCaptchaStageRequest? = null): Response<CaptchaStage>

    /**
     * GET stages/captcha/{stage_uuid}/
     *
     * CaptchaStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Captcha Stage.
     * @return [CaptchaStage]
     */
    @GET("stages/captcha/{stage_uuid}/")
    suspend fun stagesCaptchaRetrieve(@Path("stage_uuid") stageUuid: java.util.UUID): Response<CaptchaStage>

    /**
     * PUT stages/captcha/{stage_uuid}/
     *
     * CaptchaStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Captcha Stage.
     * @param captchaStageRequest
     * @return [CaptchaStage]
     */
    @PUT("stages/captcha/{stage_uuid}/")
    suspend fun stagesCaptchaUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body captchaStageRequest: CaptchaStageRequest): Response<CaptchaStage>

    /**
     * GET stages/captcha/{stage_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Captcha Stage.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("stages/captcha/{stage_uuid}/used_by/")
    suspend fun stagesCaptchaUsedByList(@Path("stage_uuid") stageUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST stages/consent/
     *
     * ConsentStage Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param consentStageRequest
     * @return [ConsentStage]
     */
    @POST("stages/consent/")
    suspend fun stagesConsentCreate(@Body consentStageRequest: ConsentStageRequest): Response<ConsentStage>

    /**
     * DELETE stages/consent/{stage_uuid}/
     *
     * ConsentStage Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Consent Stage.
     * @return [Unit]
     */
    @DELETE("stages/consent/{stage_uuid}/")
    suspend fun stagesConsentDestroy(@Path("stage_uuid") stageUuid: java.util.UUID): Response<Unit>

    /**
     * GET stages/consent/
     *
     * ConsentStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param consentExpireIn  (optional)
     * @param mode  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param stageUuid  (optional)
     * @return [PaginatedConsentStageList]
     */
    @GET("stages/consent/")
    suspend fun stagesConsentList(@Query("consent_expire_in") consentExpireIn: kotlin.String? = null, @Query("mode") mode: ConsentModeEnum? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("stage_uuid") stageUuid: java.util.UUID? = null): Response<PaginatedConsentStageList>

    /**
     * PATCH stages/consent/{stage_uuid}/
     *
     * ConsentStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Consent Stage.
     * @param patchedConsentStageRequest  (optional)
     * @return [ConsentStage]
     */
    @PATCH("stages/consent/{stage_uuid}/")
    suspend fun stagesConsentPartialUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body patchedConsentStageRequest: PatchedConsentStageRequest? = null): Response<ConsentStage>

    /**
     * GET stages/consent/{stage_uuid}/
     *
     * ConsentStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Consent Stage.
     * @return [ConsentStage]
     */
    @GET("stages/consent/{stage_uuid}/")
    suspend fun stagesConsentRetrieve(@Path("stage_uuid") stageUuid: java.util.UUID): Response<ConsentStage>

    /**
     * PUT stages/consent/{stage_uuid}/
     *
     * ConsentStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Consent Stage.
     * @param consentStageRequest
     * @return [ConsentStage]
     */
    @PUT("stages/consent/{stage_uuid}/")
    suspend fun stagesConsentUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body consentStageRequest: ConsentStageRequest): Response<ConsentStage>

    /**
     * GET stages/consent/{stage_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Consent Stage.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("stages/consent/{stage_uuid}/used_by/")
    suspend fun stagesConsentUsedByList(@Path("stage_uuid") stageUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST stages/deny/
     *
     * DenyStage Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param denyStageRequest
     * @return [DenyStage]
     */
    @POST("stages/deny/")
    suspend fun stagesDenyCreate(@Body denyStageRequest: DenyStageRequest): Response<DenyStage>

    /**
     * DELETE stages/deny/{stage_uuid}/
     *
     * DenyStage Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Deny Stage.
     * @return [Unit]
     */
    @DELETE("stages/deny/{stage_uuid}/")
    suspend fun stagesDenyDestroy(@Path("stage_uuid") stageUuid: java.util.UUID): Response<Unit>

    /**
     * GET stages/deny/
     *
     * DenyStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param denyMessage  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param stageUuid  (optional)
     * @return [PaginatedDenyStageList]
     */
    @GET("stages/deny/")
    suspend fun stagesDenyList(@Query("deny_message") denyMessage: kotlin.String? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("stage_uuid") stageUuid: java.util.UUID? = null): Response<PaginatedDenyStageList>

    /**
     * PATCH stages/deny/{stage_uuid}/
     *
     * DenyStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Deny Stage.
     * @param patchedDenyStageRequest  (optional)
     * @return [DenyStage]
     */
    @PATCH("stages/deny/{stage_uuid}/")
    suspend fun stagesDenyPartialUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body patchedDenyStageRequest: PatchedDenyStageRequest? = null): Response<DenyStage>

    /**
     * GET stages/deny/{stage_uuid}/
     *
     * DenyStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Deny Stage.
     * @return [DenyStage]
     */
    @GET("stages/deny/{stage_uuid}/")
    suspend fun stagesDenyRetrieve(@Path("stage_uuid") stageUuid: java.util.UUID): Response<DenyStage>

    /**
     * PUT stages/deny/{stage_uuid}/
     *
     * DenyStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Deny Stage.
     * @param denyStageRequest
     * @return [DenyStage]
     */
    @PUT("stages/deny/{stage_uuid}/")
    suspend fun stagesDenyUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body denyStageRequest: DenyStageRequest): Response<DenyStage>

    /**
     * GET stages/deny/{stage_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Deny Stage.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("stages/deny/{stage_uuid}/used_by/")
    suspend fun stagesDenyUsedByList(@Path("stage_uuid") stageUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST stages/dummy/
     *
     * DummyStage Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param dummyStageRequest
     * @return [DummyStage]
     */
    @POST("stages/dummy/")
    suspend fun stagesDummyCreate(@Body dummyStageRequest: DummyStageRequest): Response<DummyStage>

    /**
     * DELETE stages/dummy/{stage_uuid}/
     *
     * DummyStage Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Dummy Stage.
     * @return [Unit]
     */
    @DELETE("stages/dummy/{stage_uuid}/")
    suspend fun stagesDummyDestroy(@Path("stage_uuid") stageUuid: java.util.UUID): Response<Unit>

    /**
     * GET stages/dummy/
     *
     * DummyStage Viewset
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
     * @param stageUuid  (optional)
     * @param throwError  (optional)
     * @return [PaginatedDummyStageList]
     */
    @GET("stages/dummy/")
    suspend fun stagesDummyList(@Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("stage_uuid") stageUuid: java.util.UUID? = null, @Query("throw_error") throwError: kotlin.Boolean? = null): Response<PaginatedDummyStageList>

    /**
     * PATCH stages/dummy/{stage_uuid}/
     *
     * DummyStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Dummy Stage.
     * @param patchedDummyStageRequest  (optional)
     * @return [DummyStage]
     */
    @PATCH("stages/dummy/{stage_uuid}/")
    suspend fun stagesDummyPartialUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body patchedDummyStageRequest: PatchedDummyStageRequest? = null): Response<DummyStage>

    /**
     * GET stages/dummy/{stage_uuid}/
     *
     * DummyStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Dummy Stage.
     * @return [DummyStage]
     */
    @GET("stages/dummy/{stage_uuid}/")
    suspend fun stagesDummyRetrieve(@Path("stage_uuid") stageUuid: java.util.UUID): Response<DummyStage>

    /**
     * PUT stages/dummy/{stage_uuid}/
     *
     * DummyStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Dummy Stage.
     * @param dummyStageRequest
     * @return [DummyStage]
     */
    @PUT("stages/dummy/{stage_uuid}/")
    suspend fun stagesDummyUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body dummyStageRequest: DummyStageRequest): Response<DummyStage>

    /**
     * GET stages/dummy/{stage_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Dummy Stage.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("stages/dummy/{stage_uuid}/used_by/")
    suspend fun stagesDummyUsedByList(@Path("stage_uuid") stageUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST stages/email/
     *
     * EmailStage Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param emailStageRequest
     * @return [EmailStage]
     */
    @POST("stages/email/")
    suspend fun stagesEmailCreate(@Body emailStageRequest: EmailStageRequest): Response<EmailStage>

    /**
     * DELETE stages/email/{stage_uuid}/
     *
     * EmailStage Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Email Stage.
     * @return [Unit]
     */
    @DELETE("stages/email/{stage_uuid}/")
    suspend fun stagesEmailDestroy(@Path("stage_uuid") stageUuid: java.util.UUID): Response<Unit>

    /**
     * GET stages/email/
     *
     * EmailStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param activateUserOnSuccess  (optional)
     * @param fromAddress  (optional)
     * @param host  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param port  (optional)
     * @param search A search term. (optional)
     * @param subject  (optional)
     * @param template  (optional)
     * @param timeout  (optional)
     * @param tokenExpiry  (optional)
     * @param useGlobalSettings  (optional)
     * @param useSsl  (optional)
     * @param useTls  (optional)
     * @param username  (optional)
     * @return [PaginatedEmailStageList]
     */
    @GET("stages/email/")
    suspend fun stagesEmailList(@Query("activate_user_on_success") activateUserOnSuccess: kotlin.Boolean? = null, @Query("from_address") fromAddress: kotlin.String? = null, @Query("host") host: kotlin.String? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("port") port: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("subject") subject: kotlin.String? = null, @Query("template") template: kotlin.String? = null, @Query("timeout") timeout: kotlin.Int? = null, @Query("token_expiry") tokenExpiry: kotlin.String? = null, @Query("use_global_settings") useGlobalSettings: kotlin.Boolean? = null, @Query("use_ssl") useSsl: kotlin.Boolean? = null, @Query("use_tls") useTls: kotlin.Boolean? = null, @Query("username") username: kotlin.String? = null): Response<PaginatedEmailStageList>

    /**
     * PATCH stages/email/{stage_uuid}/
     *
     * EmailStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Email Stage.
     * @param patchedEmailStageRequest  (optional)
     * @return [EmailStage]
     */
    @PATCH("stages/email/{stage_uuid}/")
    suspend fun stagesEmailPartialUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body patchedEmailStageRequest: PatchedEmailStageRequest? = null): Response<EmailStage>

    /**
     * GET stages/email/{stage_uuid}/
     *
     * EmailStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Email Stage.
     * @return [EmailStage]
     */
    @GET("stages/email/{stage_uuid}/")
    suspend fun stagesEmailRetrieve(@Path("stage_uuid") stageUuid: java.util.UUID): Response<EmailStage>

    /**
     * GET stages/email/templates/
     *
     * Get all available templates, including custom templates
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @return [kotlin.collections.List<TypeCreate>]
     */
    @GET("stages/email/templates/")
    suspend fun stagesEmailTemplatesList(): Response<kotlin.collections.List<TypeCreate>>

    /**
     * PUT stages/email/{stage_uuid}/
     *
     * EmailStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Email Stage.
     * @param emailStageRequest
     * @return [EmailStage]
     */
    @PUT("stages/email/{stage_uuid}/")
    suspend fun stagesEmailUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body emailStageRequest: EmailStageRequest): Response<EmailStage>

    /**
     * GET stages/email/{stage_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Email Stage.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("stages/email/{stage_uuid}/used_by/")
    suspend fun stagesEmailUsedByList(@Path("stage_uuid") stageUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST stages/endpoints/
     *
     * EndpointStage Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param endpointStageRequest
     * @return [EndpointStage]
     */
    @POST("stages/endpoints/")
    suspend fun stagesEndpointsCreate(@Body endpointStageRequest: EndpointStageRequest): Response<EndpointStage>

    /**
     * DELETE stages/endpoints/{stage_uuid}/
     *
     * EndpointStage Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Endpoint Stage.
     * @return [Unit]
     */
    @DELETE("stages/endpoints/{stage_uuid}/")
    suspend fun stagesEndpointsDestroy(@Path("stage_uuid") stageUuid: java.util.UUID): Response<Unit>

    /**
     * GET stages/endpoints/
     *
     * EndpointStage Viewset
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
     * @return [PaginatedEndpointStageList]
     */
    @GET("stages/endpoints/")
    suspend fun stagesEndpointsList(@Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedEndpointStageList>

    /**
     * PATCH stages/endpoints/{stage_uuid}/
     *
     * EndpointStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Endpoint Stage.
     * @param patchedEndpointStageRequest  (optional)
     * @return [EndpointStage]
     */
    @PATCH("stages/endpoints/{stage_uuid}/")
    suspend fun stagesEndpointsPartialUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body patchedEndpointStageRequest: PatchedEndpointStageRequest? = null): Response<EndpointStage>

    /**
     * GET stages/endpoints/{stage_uuid}/
     *
     * EndpointStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Endpoint Stage.
     * @return [EndpointStage]
     */
    @GET("stages/endpoints/{stage_uuid}/")
    suspend fun stagesEndpointsRetrieve(@Path("stage_uuid") stageUuid: java.util.UUID): Response<EndpointStage>

    /**
     * PUT stages/endpoints/{stage_uuid}/
     *
     * EndpointStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Endpoint Stage.
     * @param endpointStageRequest
     * @return [EndpointStage]
     */
    @PUT("stages/endpoints/{stage_uuid}/")
    suspend fun stagesEndpointsUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body endpointStageRequest: EndpointStageRequest): Response<EndpointStage>

    /**
     * GET stages/endpoints/{stage_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Endpoint Stage.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("stages/endpoints/{stage_uuid}/used_by/")
    suspend fun stagesEndpointsUsedByList(@Path("stage_uuid") stageUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST stages/identification/
     *
     * IdentificationStage Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param identificationStageRequest
     * @return [IdentificationStage]
     */
    @POST("stages/identification/")
    suspend fun stagesIdentificationCreate(@Body identificationStageRequest: IdentificationStageRequest): Response<IdentificationStage>

    /**
     * DELETE stages/identification/{stage_uuid}/
     *
     * IdentificationStage Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Identification Stage.
     * @return [Unit]
     */
    @DELETE("stages/identification/{stage_uuid}/")
    suspend fun stagesIdentificationDestroy(@Path("stage_uuid") stageUuid: java.util.UUID): Response<Unit>

    /**
     * GET stages/identification/
     *
     * IdentificationStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param captchaStage  (optional)
     * @param caseInsensitiveMatching  (optional)
     * @param enrollmentFlow  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param passwordStage  (optional)
     * @param passwordlessFlow  (optional)
     * @param recoveryFlow  (optional)
     * @param search A search term. (optional)
     * @param showMatchedUser  (optional)
     * @param showSourceLabels  (optional)
     * @param webauthnStage  (optional)
     * @return [PaginatedIdentificationStageList]
     */
    @GET("stages/identification/")
    suspend fun stagesIdentificationList(@Query("captcha_stage") captchaStage: java.util.UUID? = null, @Query("case_insensitive_matching") caseInsensitiveMatching: kotlin.Boolean? = null, @Query("enrollment_flow") enrollmentFlow: java.util.UUID? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("password_stage") passwordStage: java.util.UUID? = null, @Query("passwordless_flow") passwordlessFlow: java.util.UUID? = null, @Query("recovery_flow") recoveryFlow: java.util.UUID? = null, @Query("search") search: kotlin.String? = null, @Query("show_matched_user") showMatchedUser: kotlin.Boolean? = null, @Query("show_source_labels") showSourceLabels: kotlin.Boolean? = null, @Query("webauthn_stage") webauthnStage: java.util.UUID? = null): Response<PaginatedIdentificationStageList>

    /**
     * PATCH stages/identification/{stage_uuid}/
     *
     * IdentificationStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Identification Stage.
     * @param patchedIdentificationStageRequest  (optional)
     * @return [IdentificationStage]
     */
    @PATCH("stages/identification/{stage_uuid}/")
    suspend fun stagesIdentificationPartialUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body patchedIdentificationStageRequest: PatchedIdentificationStageRequest? = null): Response<IdentificationStage>

    /**
     * GET stages/identification/{stage_uuid}/
     *
     * IdentificationStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Identification Stage.
     * @return [IdentificationStage]
     */
    @GET("stages/identification/{stage_uuid}/")
    suspend fun stagesIdentificationRetrieve(@Path("stage_uuid") stageUuid: java.util.UUID): Response<IdentificationStage>

    /**
     * PUT stages/identification/{stage_uuid}/
     *
     * IdentificationStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Identification Stage.
     * @param identificationStageRequest
     * @return [IdentificationStage]
     */
    @PUT("stages/identification/{stage_uuid}/")
    suspend fun stagesIdentificationUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body identificationStageRequest: IdentificationStageRequest): Response<IdentificationStage>

    /**
     * GET stages/identification/{stage_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Identification Stage.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("stages/identification/{stage_uuid}/used_by/")
    suspend fun stagesIdentificationUsedByList(@Path("stage_uuid") stageUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST stages/invitation/invitations/
     *
     * Invitation Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param invitationRequest
     * @return [Invitation]
     */
    @POST("stages/invitation/invitations/")
    suspend fun stagesInvitationInvitationsCreate(@Body invitationRequest: InvitationRequest): Response<Invitation>

    /**
     * DELETE stages/invitation/invitations/{invite_uuid}/
     *
     * Invitation Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param inviteUuid A UUID string identifying this Invitation.
     * @return [Unit]
     */
    @DELETE("stages/invitation/invitations/{invite_uuid}/")
    suspend fun stagesInvitationInvitationsDestroy(@Path("invite_uuid") inviteUuid: java.util.UUID): Response<Unit>

    /**
     * GET stages/invitation/invitations/
     *
     * Invitation Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param createdByUsername  (optional)
     * @param expires  (optional)
     * @param flowSlug  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedInvitationList]
     */
    @GET("stages/invitation/invitations/")
    suspend fun stagesInvitationInvitationsList(@Query("created_by__username") createdByUsername: kotlin.String? = null, @Query("expires") expires: java.time.OffsetDateTime? = null, @Query("flow__slug") flowSlug: kotlin.String? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedInvitationList>

    /**
     * PATCH stages/invitation/invitations/{invite_uuid}/
     *
     * Invitation Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param inviteUuid A UUID string identifying this Invitation.
     * @param patchedInvitationRequest  (optional)
     * @return [Invitation]
     */
    @PATCH("stages/invitation/invitations/{invite_uuid}/")
    suspend fun stagesInvitationInvitationsPartialUpdate(@Path("invite_uuid") inviteUuid: java.util.UUID, @Body patchedInvitationRequest: PatchedInvitationRequest? = null): Response<Invitation>

    /**
     * GET stages/invitation/invitations/{invite_uuid}/
     *
     * Invitation Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param inviteUuid A UUID string identifying this Invitation.
     * @return [Invitation]
     */
    @GET("stages/invitation/invitations/{invite_uuid}/")
    suspend fun stagesInvitationInvitationsRetrieve(@Path("invite_uuid") inviteUuid: java.util.UUID): Response<Invitation>

    /**
     * POST stages/invitation/invitations/{invite_uuid}/send_email/
     *
     * Send invitation link via email to one or more addresses
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param inviteUuid A UUID string identifying this Invitation.
     * @param invitationSendEmailRequest
     * @return [Unit]
     */
    @POST("stages/invitation/invitations/{invite_uuid}/send_email/")
    suspend fun stagesInvitationInvitationsSendEmailCreate(@Path("invite_uuid") inviteUuid: java.util.UUID, @Body invitationSendEmailRequest: InvitationSendEmailRequest): Response<Unit>

    /**
     * PUT stages/invitation/invitations/{invite_uuid}/
     *
     * Invitation Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param inviteUuid A UUID string identifying this Invitation.
     * @param invitationRequest
     * @return [Invitation]
     */
    @PUT("stages/invitation/invitations/{invite_uuid}/")
    suspend fun stagesInvitationInvitationsUpdate(@Path("invite_uuid") inviteUuid: java.util.UUID, @Body invitationRequest: InvitationRequest): Response<Invitation>

    /**
     * GET stages/invitation/invitations/{invite_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param inviteUuid A UUID string identifying this Invitation.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("stages/invitation/invitations/{invite_uuid}/used_by/")
    suspend fun stagesInvitationInvitationsUsedByList(@Path("invite_uuid") inviteUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST stages/invitation/stages/
     *
     * InvitationStage Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param invitationStageRequest
     * @return [InvitationStage]
     */
    @POST("stages/invitation/stages/")
    suspend fun stagesInvitationStagesCreate(@Body invitationStageRequest: InvitationStageRequest): Response<InvitationStage>

    /**
     * DELETE stages/invitation/stages/{stage_uuid}/
     *
     * InvitationStage Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Invitation Stage.
     * @return [Unit]
     */
    @DELETE("stages/invitation/stages/{stage_uuid}/")
    suspend fun stagesInvitationStagesDestroy(@Path("stage_uuid") stageUuid: java.util.UUID): Response<Unit>

    /**
     * GET stages/invitation/stages/
     *
     * InvitationStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param continueFlowWithoutInvitation  (optional)
     * @param name  (optional)
     * @param noFlows  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param stageUuid  (optional)
     * @return [PaginatedInvitationStageList]
     */
    @GET("stages/invitation/stages/")
    suspend fun stagesInvitationStagesList(@Query("continue_flow_without_invitation") continueFlowWithoutInvitation: kotlin.Boolean? = null, @Query("name") name: kotlin.String? = null, @Query("no_flows") noFlows: kotlin.Boolean? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("stage_uuid") stageUuid: java.util.UUID? = null): Response<PaginatedInvitationStageList>

    /**
     * PATCH stages/invitation/stages/{stage_uuid}/
     *
     * InvitationStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Invitation Stage.
     * @param patchedInvitationStageRequest  (optional)
     * @return [InvitationStage]
     */
    @PATCH("stages/invitation/stages/{stage_uuid}/")
    suspend fun stagesInvitationStagesPartialUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body patchedInvitationStageRequest: PatchedInvitationStageRequest? = null): Response<InvitationStage>

    /**
     * GET stages/invitation/stages/{stage_uuid}/
     *
     * InvitationStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Invitation Stage.
     * @return [InvitationStage]
     */
    @GET("stages/invitation/stages/{stage_uuid}/")
    suspend fun stagesInvitationStagesRetrieve(@Path("stage_uuid") stageUuid: java.util.UUID): Response<InvitationStage>

    /**
     * PUT stages/invitation/stages/{stage_uuid}/
     *
     * InvitationStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Invitation Stage.
     * @param invitationStageRequest
     * @return [InvitationStage]
     */
    @PUT("stages/invitation/stages/{stage_uuid}/")
    suspend fun stagesInvitationStagesUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body invitationStageRequest: InvitationStageRequest): Response<InvitationStage>

    /**
     * GET stages/invitation/stages/{stage_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Invitation Stage.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("stages/invitation/stages/{stage_uuid}/used_by/")
    suspend fun stagesInvitationStagesUsedByList(@Path("stage_uuid") stageUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST stages/mtls/
     *
     * MutualTLSStage Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param mutualTLSStageRequest
     * @return [MutualTLSStage]
     */
    @POST("stages/mtls/")
    suspend fun stagesMtlsCreate(@Body mutualTLSStageRequest: MutualTLSStageRequest): Response<MutualTLSStage>

    /**
     * DELETE stages/mtls/{stage_uuid}/
     *
     * MutualTLSStage Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Mutual TLS Stage.
     * @return [Unit]
     */
    @DELETE("stages/mtls/{stage_uuid}/")
    suspend fun stagesMtlsDestroy(@Path("stage_uuid") stageUuid: java.util.UUID): Response<Unit>

    /**
     * GET stages/mtls/
     *
     * MutualTLSStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param certAttribute  (optional)
     * @param certificateAuthorities  (optional)
     * @param mode  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param stageUuid  (optional)
     * @param userAttribute  (optional)
     * @return [PaginatedMutualTLSStageList]
     */
    @GET("stages/mtls/")
    suspend fun stagesMtlsList(@Query("cert_attribute") certAttribute: CertAttributeEnum? = null, @Query("certificate_authorities") certificateAuthorities: @JvmSuppressWildcards kotlin.collections.List<java.util.UUID>? = null, @Query("mode") mode: StageModeEnum? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("stage_uuid") stageUuid: java.util.UUID? = null, @Query("user_attribute") userAttribute: UserAttributeEnum? = null): Response<PaginatedMutualTLSStageList>

    /**
     * PATCH stages/mtls/{stage_uuid}/
     *
     * MutualTLSStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Mutual TLS Stage.
     * @param patchedMutualTLSStageRequest  (optional)
     * @return [MutualTLSStage]
     */
    @PATCH("stages/mtls/{stage_uuid}/")
    suspend fun stagesMtlsPartialUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body patchedMutualTLSStageRequest: PatchedMutualTLSStageRequest? = null): Response<MutualTLSStage>

    /**
     * GET stages/mtls/{stage_uuid}/
     *
     * MutualTLSStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Mutual TLS Stage.
     * @return [MutualTLSStage]
     */
    @GET("stages/mtls/{stage_uuid}/")
    suspend fun stagesMtlsRetrieve(@Path("stage_uuid") stageUuid: java.util.UUID): Response<MutualTLSStage>

    /**
     * PUT stages/mtls/{stage_uuid}/
     *
     * MutualTLSStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Mutual TLS Stage.
     * @param mutualTLSStageRequest
     * @return [MutualTLSStage]
     */
    @PUT("stages/mtls/{stage_uuid}/")
    suspend fun stagesMtlsUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body mutualTLSStageRequest: MutualTLSStageRequest): Response<MutualTLSStage>

    /**
     * GET stages/mtls/{stage_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Mutual TLS Stage.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("stages/mtls/{stage_uuid}/used_by/")
    suspend fun stagesMtlsUsedByList(@Path("stage_uuid") stageUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST stages/password/
     *
     * PasswordStage Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param passwordStageRequest
     * @return [PasswordStage]
     */
    @POST("stages/password/")
    suspend fun stagesPasswordCreate(@Body passwordStageRequest: PasswordStageRequest): Response<PasswordStage>

    /**
     * DELETE stages/password/{stage_uuid}/
     *
     * PasswordStage Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Password Stage.
     * @return [Unit]
     */
    @DELETE("stages/password/{stage_uuid}/")
    suspend fun stagesPasswordDestroy(@Path("stage_uuid") stageUuid: java.util.UUID): Response<Unit>

    /**
     * GET stages/password/
     *
     * PasswordStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param allowShowPassword  (optional)
     * @param configureFlow  (optional)
     * @param failedAttemptsBeforeCancel  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedPasswordStageList]
     */
    @GET("stages/password/")
    suspend fun stagesPasswordList(@Query("allow_show_password") allowShowPassword: kotlin.Boolean? = null, @Query("configure_flow") configureFlow: java.util.UUID? = null, @Query("failed_attempts_before_cancel") failedAttemptsBeforeCancel: kotlin.Int? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedPasswordStageList>

    /**
     * PATCH stages/password/{stage_uuid}/
     *
     * PasswordStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Password Stage.
     * @param patchedPasswordStageRequest  (optional)
     * @return [PasswordStage]
     */
    @PATCH("stages/password/{stage_uuid}/")
    suspend fun stagesPasswordPartialUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body patchedPasswordStageRequest: PatchedPasswordStageRequest? = null): Response<PasswordStage>

    /**
     * GET stages/password/{stage_uuid}/
     *
     * PasswordStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Password Stage.
     * @return [PasswordStage]
     */
    @GET("stages/password/{stage_uuid}/")
    suspend fun stagesPasswordRetrieve(@Path("stage_uuid") stageUuid: java.util.UUID): Response<PasswordStage>

    /**
     * PUT stages/password/{stage_uuid}/
     *
     * PasswordStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Password Stage.
     * @param passwordStageRequest
     * @return [PasswordStage]
     */
    @PUT("stages/password/{stage_uuid}/")
    suspend fun stagesPasswordUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body passwordStageRequest: PasswordStageRequest): Response<PasswordStage>

    /**
     * GET stages/password/{stage_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Password Stage.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("stages/password/{stage_uuid}/used_by/")
    suspend fun stagesPasswordUsedByList(@Path("stage_uuid") stageUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST stages/prompt/prompts/
     *
     * Prompt Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param promptRequest
     * @return [Prompt]
     */
    @POST("stages/prompt/prompts/")
    suspend fun stagesPromptPromptsCreate(@Body promptRequest: PromptRequest): Response<Prompt>

    /**
     * DELETE stages/prompt/prompts/{prompt_uuid}/
     *
     * Prompt Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param promptUuid A UUID string identifying this Prompt.
     * @return [Unit]
     */
    @DELETE("stages/prompt/prompts/{prompt_uuid}/")
    suspend fun stagesPromptPromptsDestroy(@Path("prompt_uuid") promptUuid: java.util.UUID): Response<Unit>

    /**
     * GET stages/prompt/prompts/
     *
     * Prompt Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param fieldKey  (optional)
     * @param label  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param placeholder  (optional)
     * @param search A search term. (optional)
     * @param type  (optional)
     * @return [PaginatedPromptList]
     */
    @GET("stages/prompt/prompts/")
    suspend fun stagesPromptPromptsList(@Query("field_key") fieldKey: kotlin.String? = null, @Query("label") label: kotlin.String? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("placeholder") placeholder: kotlin.String? = null, @Query("search") search: kotlin.String? = null, @Query("type") type: PromptTypeEnum? = null): Response<PaginatedPromptList>

    /**
     * PATCH stages/prompt/prompts/{prompt_uuid}/
     *
     * Prompt Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param promptUuid A UUID string identifying this Prompt.
     * @param patchedPromptRequest  (optional)
     * @return [Prompt]
     */
    @PATCH("stages/prompt/prompts/{prompt_uuid}/")
    suspend fun stagesPromptPromptsPartialUpdate(@Path("prompt_uuid") promptUuid: java.util.UUID, @Body patchedPromptRequest: PatchedPromptRequest? = null): Response<Prompt>

    /**
     * POST stages/prompt/prompts/preview/
     *
     * Preview a prompt as a challenge, just like a flow would receive
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param promptRequest
     * @return [PromptChallenge]
     */
    @POST("stages/prompt/prompts/preview/")
    suspend fun stagesPromptPromptsPreviewCreate(@Body promptRequest: PromptRequest): Response<PromptChallenge>

    /**
     * GET stages/prompt/prompts/{prompt_uuid}/
     *
     * Prompt Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param promptUuid A UUID string identifying this Prompt.
     * @return [Prompt]
     */
    @GET("stages/prompt/prompts/{prompt_uuid}/")
    suspend fun stagesPromptPromptsRetrieve(@Path("prompt_uuid") promptUuid: java.util.UUID): Response<Prompt>

    /**
     * PUT stages/prompt/prompts/{prompt_uuid}/
     *
     * Prompt Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param promptUuid A UUID string identifying this Prompt.
     * @param promptRequest
     * @return [Prompt]
     */
    @PUT("stages/prompt/prompts/{prompt_uuid}/")
    suspend fun stagesPromptPromptsUpdate(@Path("prompt_uuid") promptUuid: java.util.UUID, @Body promptRequest: PromptRequest): Response<Prompt>

    /**
     * GET stages/prompt/prompts/{prompt_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param promptUuid A UUID string identifying this Prompt.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("stages/prompt/prompts/{prompt_uuid}/used_by/")
    suspend fun stagesPromptPromptsUsedByList(@Path("prompt_uuid") promptUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST stages/prompt/stages/
     *
     * PromptStage Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param promptStageRequest
     * @return [PromptStage]
     */
    @POST("stages/prompt/stages/")
    suspend fun stagesPromptStagesCreate(@Body promptStageRequest: PromptStageRequest): Response<PromptStage>

    /**
     * DELETE stages/prompt/stages/{stage_uuid}/
     *
     * PromptStage Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Prompt Stage.
     * @return [Unit]
     */
    @DELETE("stages/prompt/stages/{stage_uuid}/")
    suspend fun stagesPromptStagesDestroy(@Path("stage_uuid") stageUuid: java.util.UUID): Response<Unit>

    /**
     * GET stages/prompt/stages/
     *
     * PromptStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param fields  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param stageUuid  (optional)
     * @param validationPolicies  (optional)
     * @return [PaginatedPromptStageList]
     */
    @GET("stages/prompt/stages/")
    suspend fun stagesPromptStagesList(@Query("fields") fields: @JvmSuppressWildcards kotlin.collections.List<java.util.UUID>? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("stage_uuid") stageUuid: java.util.UUID? = null, @Query("validation_policies") validationPolicies: @JvmSuppressWildcards kotlin.collections.List<java.util.UUID>? = null): Response<PaginatedPromptStageList>

    /**
     * PATCH stages/prompt/stages/{stage_uuid}/
     *
     * PromptStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Prompt Stage.
     * @param patchedPromptStageRequest  (optional)
     * @return [PromptStage]
     */
    @PATCH("stages/prompt/stages/{stage_uuid}/")
    suspend fun stagesPromptStagesPartialUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body patchedPromptStageRequest: PatchedPromptStageRequest? = null): Response<PromptStage>

    /**
     * GET stages/prompt/stages/{stage_uuid}/
     *
     * PromptStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Prompt Stage.
     * @return [PromptStage]
     */
    @GET("stages/prompt/stages/{stage_uuid}/")
    suspend fun stagesPromptStagesRetrieve(@Path("stage_uuid") stageUuid: java.util.UUID): Response<PromptStage>

    /**
     * PUT stages/prompt/stages/{stage_uuid}/
     *
     * PromptStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Prompt Stage.
     * @param promptStageRequest
     * @return [PromptStage]
     */
    @PUT("stages/prompt/stages/{stage_uuid}/")
    suspend fun stagesPromptStagesUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body promptStageRequest: PromptStageRequest): Response<PromptStage>

    /**
     * GET stages/prompt/stages/{stage_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Prompt Stage.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("stages/prompt/stages/{stage_uuid}/used_by/")
    suspend fun stagesPromptStagesUsedByList(@Path("stage_uuid") stageUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST stages/redirect/
     *
     * RedirectStage Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param redirectStageRequest
     * @return [RedirectStage]
     */
    @POST("stages/redirect/")
    suspend fun stagesRedirectCreate(@Body redirectStageRequest: RedirectStageRequest): Response<RedirectStage>

    /**
     * DELETE stages/redirect/{stage_uuid}/
     *
     * RedirectStage Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Redirect Stage.
     * @return [Unit]
     */
    @DELETE("stages/redirect/{stage_uuid}/")
    suspend fun stagesRedirectDestroy(@Path("stage_uuid") stageUuid: java.util.UUID): Response<Unit>

    /**
     * GET stages/redirect/
     *
     * RedirectStage Viewset
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
     * @return [PaginatedRedirectStageList]
     */
    @GET("stages/redirect/")
    suspend fun stagesRedirectList(@Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedRedirectStageList>

    /**
     * PATCH stages/redirect/{stage_uuid}/
     *
     * RedirectStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Redirect Stage.
     * @param patchedRedirectStageRequest  (optional)
     * @return [RedirectStage]
     */
    @PATCH("stages/redirect/{stage_uuid}/")
    suspend fun stagesRedirectPartialUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body patchedRedirectStageRequest: PatchedRedirectStageRequest? = null): Response<RedirectStage>

    /**
     * GET stages/redirect/{stage_uuid}/
     *
     * RedirectStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Redirect Stage.
     * @return [RedirectStage]
     */
    @GET("stages/redirect/{stage_uuid}/")
    suspend fun stagesRedirectRetrieve(@Path("stage_uuid") stageUuid: java.util.UUID): Response<RedirectStage>

    /**
     * PUT stages/redirect/{stage_uuid}/
     *
     * RedirectStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Redirect Stage.
     * @param redirectStageRequest
     * @return [RedirectStage]
     */
    @PUT("stages/redirect/{stage_uuid}/")
    suspend fun stagesRedirectUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body redirectStageRequest: RedirectStageRequest): Response<RedirectStage>

    /**
     * GET stages/redirect/{stage_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Redirect Stage.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("stages/redirect/{stage_uuid}/used_by/")
    suspend fun stagesRedirectUsedByList(@Path("stage_uuid") stageUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST stages/source/
     *
     * SourceStage Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param sourceStageRequest
     * @return [SourceStage]
     */
    @POST("stages/source/")
    suspend fun stagesSourceCreate(@Body sourceStageRequest: SourceStageRequest): Response<SourceStage>

    /**
     * DELETE stages/source/{stage_uuid}/
     *
     * SourceStage Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Source Stage.
     * @return [Unit]
     */
    @DELETE("stages/source/{stage_uuid}/")
    suspend fun stagesSourceDestroy(@Path("stage_uuid") stageUuid: java.util.UUID): Response<Unit>

    /**
     * GET stages/source/
     *
     * SourceStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param resumeTimeout  (optional)
     * @param search A search term. (optional)
     * @param source  (optional)
     * @param stageUuid  (optional)
     * @return [PaginatedSourceStageList]
     */
    @GET("stages/source/")
    suspend fun stagesSourceList(@Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("resume_timeout") resumeTimeout: kotlin.String? = null, @Query("search") search: kotlin.String? = null, @Query("source") source: java.util.UUID? = null, @Query("stage_uuid") stageUuid: java.util.UUID? = null): Response<PaginatedSourceStageList>

    /**
     * PATCH stages/source/{stage_uuid}/
     *
     * SourceStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Source Stage.
     * @param patchedSourceStageRequest  (optional)
     * @return [SourceStage]
     */
    @PATCH("stages/source/{stage_uuid}/")
    suspend fun stagesSourcePartialUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body patchedSourceStageRequest: PatchedSourceStageRequest? = null): Response<SourceStage>

    /**
     * GET stages/source/{stage_uuid}/
     *
     * SourceStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Source Stage.
     * @return [SourceStage]
     */
    @GET("stages/source/{stage_uuid}/")
    suspend fun stagesSourceRetrieve(@Path("stage_uuid") stageUuid: java.util.UUID): Response<SourceStage>

    /**
     * PUT stages/source/{stage_uuid}/
     *
     * SourceStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Source Stage.
     * @param sourceStageRequest
     * @return [SourceStage]
     */
    @PUT("stages/source/{stage_uuid}/")
    suspend fun stagesSourceUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body sourceStageRequest: SourceStageRequest): Response<SourceStage>

    /**
     * GET stages/source/{stage_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this Source Stage.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("stages/source/{stage_uuid}/used_by/")
    suspend fun stagesSourceUsedByList(@Path("stage_uuid") stageUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST stages/user_delete/
     *
     * UserDeleteStage Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param userDeleteStageRequest
     * @return [UserDeleteStage]
     */
    @POST("stages/user_delete/")
    suspend fun stagesUserDeleteCreate(@Body userDeleteStageRequest: UserDeleteStageRequest): Response<UserDeleteStage>

    /**
     * DELETE stages/user_delete/{stage_uuid}/
     *
     * UserDeleteStage Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this User Delete Stage.
     * @return [Unit]
     */
    @DELETE("stages/user_delete/{stage_uuid}/")
    suspend fun stagesUserDeleteDestroy(@Path("stage_uuid") stageUuid: java.util.UUID): Response<Unit>

    /**
     * GET stages/user_delete/
     *
     * UserDeleteStage Viewset
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
     * @param stageUuid  (optional)
     * @return [PaginatedUserDeleteStageList]
     */
    @GET("stages/user_delete/")
    suspend fun stagesUserDeleteList(@Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("stage_uuid") stageUuid: java.util.UUID? = null): Response<PaginatedUserDeleteStageList>

    /**
     * PATCH stages/user_delete/{stage_uuid}/
     *
     * UserDeleteStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this User Delete Stage.
     * @param patchedUserDeleteStageRequest  (optional)
     * @return [UserDeleteStage]
     */
    @PATCH("stages/user_delete/{stage_uuid}/")
    suspend fun stagesUserDeletePartialUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body patchedUserDeleteStageRequest: PatchedUserDeleteStageRequest? = null): Response<UserDeleteStage>

    /**
     * GET stages/user_delete/{stage_uuid}/
     *
     * UserDeleteStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this User Delete Stage.
     * @return [UserDeleteStage]
     */
    @GET("stages/user_delete/{stage_uuid}/")
    suspend fun stagesUserDeleteRetrieve(@Path("stage_uuid") stageUuid: java.util.UUID): Response<UserDeleteStage>

    /**
     * PUT stages/user_delete/{stage_uuid}/
     *
     * UserDeleteStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this User Delete Stage.
     * @param userDeleteStageRequest
     * @return [UserDeleteStage]
     */
    @PUT("stages/user_delete/{stage_uuid}/")
    suspend fun stagesUserDeleteUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body userDeleteStageRequest: UserDeleteStageRequest): Response<UserDeleteStage>

    /**
     * GET stages/user_delete/{stage_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this User Delete Stage.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("stages/user_delete/{stage_uuid}/used_by/")
    suspend fun stagesUserDeleteUsedByList(@Path("stage_uuid") stageUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST stages/user_login/
     *
     * UserLoginStage Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param userLoginStageRequest
     * @return [UserLoginStage]
     */
    @POST("stages/user_login/")
    suspend fun stagesUserLoginCreate(@Body userLoginStageRequest: UserLoginStageRequest): Response<UserLoginStage>

    /**
     * DELETE stages/user_login/{stage_uuid}/
     *
     * UserLoginStage Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this User Login Stage.
     * @return [Unit]
     */
    @DELETE("stages/user_login/{stage_uuid}/")
    suspend fun stagesUserLoginDestroy(@Path("stage_uuid") stageUuid: java.util.UUID): Response<Unit>

    /**
     * GET stages/user_login/
     *
     * UserLoginStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param geoipBinding  (optional)
     * @param name  (optional)
     * @param networkBinding  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param rememberDevice  (optional)
     * @param rememberMeOffset  (optional)
     * @param search A search term. (optional)
     * @param sessionDuration  (optional)
     * @param stageUuid  (optional)
     * @param terminateOtherSessions  (optional)
     * @return [PaginatedUserLoginStageList]
     */
    @GET("stages/user_login/")
    suspend fun stagesUserLoginList(@Query("geoip_binding") geoipBinding: GeoipBindingEnum? = null, @Query("name") name: kotlin.String? = null, @Query("network_binding") networkBinding: NetworkBindingEnum? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("remember_device") rememberDevice: kotlin.String? = null, @Query("remember_me_offset") rememberMeOffset: kotlin.String? = null, @Query("search") search: kotlin.String? = null, @Query("session_duration") sessionDuration: kotlin.String? = null, @Query("stage_uuid") stageUuid: java.util.UUID? = null, @Query("terminate_other_sessions") terminateOtherSessions: kotlin.Boolean? = null): Response<PaginatedUserLoginStageList>

    /**
     * PATCH stages/user_login/{stage_uuid}/
     *
     * UserLoginStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this User Login Stage.
     * @param patchedUserLoginStageRequest  (optional)
     * @return [UserLoginStage]
     */
    @PATCH("stages/user_login/{stage_uuid}/")
    suspend fun stagesUserLoginPartialUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body patchedUserLoginStageRequest: PatchedUserLoginStageRequest? = null): Response<UserLoginStage>

    /**
     * GET stages/user_login/{stage_uuid}/
     *
     * UserLoginStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this User Login Stage.
     * @return [UserLoginStage]
     */
    @GET("stages/user_login/{stage_uuid}/")
    suspend fun stagesUserLoginRetrieve(@Path("stage_uuid") stageUuid: java.util.UUID): Response<UserLoginStage>

    /**
     * PUT stages/user_login/{stage_uuid}/
     *
     * UserLoginStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this User Login Stage.
     * @param userLoginStageRequest
     * @return [UserLoginStage]
     */
    @PUT("stages/user_login/{stage_uuid}/")
    suspend fun stagesUserLoginUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body userLoginStageRequest: UserLoginStageRequest): Response<UserLoginStage>

    /**
     * GET stages/user_login/{stage_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this User Login Stage.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("stages/user_login/{stage_uuid}/used_by/")
    suspend fun stagesUserLoginUsedByList(@Path("stage_uuid") stageUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST stages/user_logout/
     *
     * UserLogoutStage Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param userLogoutStageRequest
     * @return [UserLogoutStage]
     */
    @POST("stages/user_logout/")
    suspend fun stagesUserLogoutCreate(@Body userLogoutStageRequest: UserLogoutStageRequest): Response<UserLogoutStage>

    /**
     * DELETE stages/user_logout/{stage_uuid}/
     *
     * UserLogoutStage Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this User Logout Stage.
     * @return [Unit]
     */
    @DELETE("stages/user_logout/{stage_uuid}/")
    suspend fun stagesUserLogoutDestroy(@Path("stage_uuid") stageUuid: java.util.UUID): Response<Unit>

    /**
     * GET stages/user_logout/
     *
     * UserLogoutStage Viewset
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
     * @param stageUuid  (optional)
     * @return [PaginatedUserLogoutStageList]
     */
    @GET("stages/user_logout/")
    suspend fun stagesUserLogoutList(@Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("stage_uuid") stageUuid: java.util.UUID? = null): Response<PaginatedUserLogoutStageList>

    /**
     * PATCH stages/user_logout/{stage_uuid}/
     *
     * UserLogoutStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this User Logout Stage.
     * @param patchedUserLogoutStageRequest  (optional)
     * @return [UserLogoutStage]
     */
    @PATCH("stages/user_logout/{stage_uuid}/")
    suspend fun stagesUserLogoutPartialUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body patchedUserLogoutStageRequest: PatchedUserLogoutStageRequest? = null): Response<UserLogoutStage>

    /**
     * GET stages/user_logout/{stage_uuid}/
     *
     * UserLogoutStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this User Logout Stage.
     * @return [UserLogoutStage]
     */
    @GET("stages/user_logout/{stage_uuid}/")
    suspend fun stagesUserLogoutRetrieve(@Path("stage_uuid") stageUuid: java.util.UUID): Response<UserLogoutStage>

    /**
     * PUT stages/user_logout/{stage_uuid}/
     *
     * UserLogoutStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this User Logout Stage.
     * @param userLogoutStageRequest
     * @return [UserLogoutStage]
     */
    @PUT("stages/user_logout/{stage_uuid}/")
    suspend fun stagesUserLogoutUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body userLogoutStageRequest: UserLogoutStageRequest): Response<UserLogoutStage>

    /**
     * GET stages/user_logout/{stage_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this User Logout Stage.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("stages/user_logout/{stage_uuid}/used_by/")
    suspend fun stagesUserLogoutUsedByList(@Path("stage_uuid") stageUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * POST stages/user_write/
     *
     * UserWriteStage Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param userWriteStageRequest
     * @return [UserWriteStage]
     */
    @POST("stages/user_write/")
    suspend fun stagesUserWriteCreate(@Body userWriteStageRequest: UserWriteStageRequest): Response<UserWriteStage>

    /**
     * DELETE stages/user_write/{stage_uuid}/
     *
     * UserWriteStage Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this User Write Stage.
     * @return [Unit]
     */
    @DELETE("stages/user_write/{stage_uuid}/")
    suspend fun stagesUserWriteDestroy(@Path("stage_uuid") stageUuid: java.util.UUID): Response<Unit>

    /**
     * GET stages/user_write/
     *
     * UserWriteStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param createUsersAsInactive  (optional)
     * @param createUsersGroup  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @param stageUuid  (optional)
     * @param userCreationMode  (optional)
     * @param userPathTemplate  (optional)
     * @param userType  (optional)
     * @return [PaginatedUserWriteStageList]
     */
    @GET("stages/user_write/")
    suspend fun stagesUserWriteList(@Query("create_users_as_inactive") createUsersAsInactive: kotlin.Boolean? = null, @Query("create_users_group") createUsersGroup: java.util.UUID? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null, @Query("stage_uuid") stageUuid: java.util.UUID? = null, @Query("user_creation_mode") userCreationMode: UserCreationModeEnum? = null, @Query("user_path_template") userPathTemplate: kotlin.String? = null, @Query("user_type") userType: UserTypeEnum? = null): Response<PaginatedUserWriteStageList>

    /**
     * PATCH stages/user_write/{stage_uuid}/
     *
     * UserWriteStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this User Write Stage.
     * @param patchedUserWriteStageRequest  (optional)
     * @return [UserWriteStage]
     */
    @PATCH("stages/user_write/{stage_uuid}/")
    suspend fun stagesUserWritePartialUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body patchedUserWriteStageRequest: PatchedUserWriteStageRequest? = null): Response<UserWriteStage>

    /**
     * GET stages/user_write/{stage_uuid}/
     *
     * UserWriteStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this User Write Stage.
     * @return [UserWriteStage]
     */
    @GET("stages/user_write/{stage_uuid}/")
    suspend fun stagesUserWriteRetrieve(@Path("stage_uuid") stageUuid: java.util.UUID): Response<UserWriteStage>

    /**
     * PUT stages/user_write/{stage_uuid}/
     *
     * UserWriteStage Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this User Write Stage.
     * @param userWriteStageRequest
     * @return [UserWriteStage]
     */
    @PUT("stages/user_write/{stage_uuid}/")
    suspend fun stagesUserWriteUpdate(@Path("stage_uuid") stageUuid: java.util.UUID, @Body userWriteStageRequest: UserWriteStageRequest): Response<UserWriteStage>

    /**
     * GET stages/user_write/{stage_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param stageUuid A UUID string identifying this User Write Stage.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("stages/user_write/{stage_uuid}/used_by/")
    suspend fun stagesUserWriteUsedByList(@Path("stage_uuid") stageUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

}
