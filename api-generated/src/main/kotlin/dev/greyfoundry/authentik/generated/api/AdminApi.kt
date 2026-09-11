package dev.greyfoundry.authentik.generated.api

import dev.greyfoundry.authentik.generated.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import dev.greyfoundry.authentik.generated.model.App
import dev.greyfoundry.authentik.generated.model.FileList
import dev.greyfoundry.authentik.generated.model.GenericError
import dev.greyfoundry.authentik.generated.model.PatchedSettingsRequest
import dev.greyfoundry.authentik.generated.model.Settings
import dev.greyfoundry.authentik.generated.model.SettingsRequest
import dev.greyfoundry.authentik.generated.model.SystemInfo
import dev.greyfoundry.authentik.generated.model.UsageEnum
import dev.greyfoundry.authentik.generated.model.UsedBy
import dev.greyfoundry.authentik.generated.model.ValidationError
import dev.greyfoundry.authentik.generated.model.Version
import dev.greyfoundry.authentik.generated.model.VersionHistory

import okhttp3.MultipartBody

interface AdminApi {
    /**
     * GET admin/apps/
     *
     * Read-only view list all installed apps
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @return [kotlin.collections.List<App>]
     */
    @GET("admin/apps/")
    suspend fun adminAppsList(): Response<kotlin.collections.List<App>>

    /**
     * POST admin/file/
     *
     * Upload file to storage backend.
     * Responses:
     *  - 200: No response body
     *  - 400:
     *  - 403:
     *
     * @param file
     * @param name  (optional)
     * @param usage  (optional, default to "media")
     * @return [Unit]
     */
    @Multipart
    @POST("admin/file/")
    suspend fun adminFileCreate(@Part file: MultipartBody.Part, @Part("name") name: kotlin.String? = null, @Part("usage") usage: kotlin.String? = "media"): Response<Unit>

    /**
     * DELETE admin/file/
     *
     * Delete file from storage backend.
     * Responses:
     *  - 200: No response body
     *  - 400:
     *  - 403:
     *
     * @param name  (optional)
     * @param usage  (optional)
     * @return [Unit]
     */
    @DELETE("admin/file/")
    suspend fun adminFileDestroy(@Query("name") name: kotlin.String? = null, @Query("usage") usage: UsageEnum? = null): Response<Unit>

    /**
     * GET admin/file/
     *
     * List files from storage backend.
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param manageableOnly  (optional, default to false)
     * @param search A search term. (optional)
     * @param usage  (optional)
     * @return [kotlin.collections.List<FileList>]
     */
    @GET("admin/file/")
    suspend fun adminFileList(@Query("manageable_only") manageableOnly: kotlin.Boolean? = false, @Query("search") search: kotlin.String? = null, @Query("usage") usage: UsageEnum? = null): Response<kotlin.collections.List<FileList>>

    /**
     * GET admin/file/used_by/
     *
     *
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param name  (optional)
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("admin/file/used_by/")
    suspend fun adminFileUsedByList(@Query("name") name: kotlin.String? = null): Response<kotlin.collections.List<UsedBy>>

    /**
     * GET admin/models/
     *
     * Read-only view list all installed models
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param filterHasAttributes  (optional)
     * @return [kotlin.collections.List<App>]
     */
    @GET("admin/models/")
    suspend fun adminModelsList(@Query("filter_has_attributes") filterHasAttributes: kotlin.Boolean? = null): Response<kotlin.collections.List<App>>

    /**
     * PATCH admin/settings/
     *
     * Settings view
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param patchedSettingsRequest  (optional)
     * @return [Settings]
     */
    @PATCH("admin/settings/")
    suspend fun adminSettingsPartialUpdate(@Body patchedSettingsRequest: PatchedSettingsRequest? = null): Response<Settings>

    /**
     * GET admin/settings/
     *
     * Settings view
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @return [Settings]
     */
    @GET("admin/settings/")
    suspend fun adminSettingsRetrieve(): Response<Settings>

    /**
     * PUT admin/settings/
     *
     * Settings view
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param settingsRequest
     * @return [Settings]
     */
    @PUT("admin/settings/")
    suspend fun adminSettingsUpdate(@Body settingsRequest: SettingsRequest): Response<Settings>

    /**
     * POST admin/system/
     *
     * Get system information.
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @return [SystemInfo]
     */
    @POST("admin/system/")
    suspend fun adminSystemCreate(): Response<SystemInfo>

    /**
     * GET admin/system/
     *
     * Get system information.
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @return [SystemInfo]
     */
    @GET("admin/system/")
    suspend fun adminSystemRetrieve(): Response<SystemInfo>

    /**
     * GET admin/version/history/
     *
     * VersionHistory Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param build  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param search A search term. (optional)
     * @param version  (optional)
     * @return [kotlin.collections.List<VersionHistory>]
     */
    @GET("admin/version/history/")
    suspend fun adminVersionHistoryList(@Query("build") build: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("search") search: kotlin.String? = null, @Query("version") version: kotlin.String? = null): Response<kotlin.collections.List<VersionHistory>>

    /**
     * GET admin/version/history/{id}/
     *
     * VersionHistory Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A unique integer value identifying this Version history.
     * @return [VersionHistory]
     */
    @GET("admin/version/history/{id}/")
    suspend fun adminVersionHistoryRetrieve(@Path("id") id: kotlin.Int): Response<VersionHistory>

    /**
     * GET admin/version/
     *
     * Get running and latest version.
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @return [Version]
     */
    @GET("admin/version/")
    suspend fun adminVersionRetrieve(): Response<Version>

}
