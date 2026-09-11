package dev.greyfoundry.authentik.generated.api

import dev.greyfoundry.authentik.generated.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import dev.greyfoundry.authentik.generated.model.BlueprintFile
import dev.greyfoundry.authentik.generated.model.BlueprintImportResult
import dev.greyfoundry.authentik.generated.model.BlueprintInstance
import dev.greyfoundry.authentik.generated.model.BlueprintInstanceRequest
import dev.greyfoundry.authentik.generated.model.GenericError
import dev.greyfoundry.authentik.generated.model.PaginatedBlueprintInstanceList
import dev.greyfoundry.authentik.generated.model.PatchedBlueprintInstanceRequest
import dev.greyfoundry.authentik.generated.model.UsedBy
import dev.greyfoundry.authentik.generated.model.ValidationError

import okhttp3.MultipartBody

interface ManagedApi {
    /**
     * POST managed/blueprints/{instance_uuid}/apply/
     *
     * Apply a blueprint
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param instanceUuid A UUID string identifying this Blueprint Instance.
     * @return [BlueprintInstance]
     */
    @POST("managed/blueprints/{instance_uuid}/apply/")
    suspend fun managedBlueprintsApplyCreate(@Path("instance_uuid") instanceUuid: java.util.UUID): Response<BlueprintInstance>

    /**
     * GET managed/blueprints/available/
     *
     * Get blueprints
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @return [kotlin.collections.List<BlueprintFile>]
     */
    @GET("managed/blueprints/available/")
    suspend fun managedBlueprintsAvailableList(): Response<kotlin.collections.List<BlueprintFile>>

    /**
     * POST managed/blueprints/
     *
     * Blueprint instances
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param blueprintInstanceRequest
     * @return [BlueprintInstance]
     */
    @POST("managed/blueprints/")
    suspend fun managedBlueprintsCreate(@Body blueprintInstanceRequest: BlueprintInstanceRequest): Response<BlueprintInstance>

    /**
     * DELETE managed/blueprints/{instance_uuid}/
     *
     * Blueprint instances
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param instanceUuid A UUID string identifying this Blueprint Instance.
     * @return [Unit]
     */
    @DELETE("managed/blueprints/{instance_uuid}/")
    suspend fun managedBlueprintsDestroy(@Path("instance_uuid") instanceUuid: java.util.UUID): Response<Unit>

    /**
     * POST managed/blueprints/import/
     *
     * Import blueprint from .yaml file and apply it once, without creating an instance
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param file  (optional)
     * @param path  (optional)
     * @param context  (optional)
     * @return [BlueprintImportResult]
     */
    @Multipart
    @POST("managed/blueprints/import/")
    suspend fun managedBlueprintsImportCreate(@Part file: MultipartBody.Part? = null, @Part("path") path: kotlin.String? = null, @Part("context") context: kotlin.String? = null): Response<BlueprintImportResult>

    /**
     * GET managed/blueprints/
     *
     * Blueprint instances
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param path  (optional)
     * @param search A search term. (optional)
     * @return [PaginatedBlueprintInstanceList]
     */
    @GET("managed/blueprints/")
    suspend fun managedBlueprintsList(@Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("path") path: kotlin.String? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedBlueprintInstanceList>

    /**
     * PATCH managed/blueprints/{instance_uuid}/
     *
     * Blueprint instances
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param instanceUuid A UUID string identifying this Blueprint Instance.
     * @param patchedBlueprintInstanceRequest  (optional)
     * @return [BlueprintInstance]
     */
    @PATCH("managed/blueprints/{instance_uuid}/")
    suspend fun managedBlueprintsPartialUpdate(@Path("instance_uuid") instanceUuid: java.util.UUID, @Body patchedBlueprintInstanceRequest: PatchedBlueprintInstanceRequest? = null): Response<BlueprintInstance>

    /**
     * GET managed/blueprints/{instance_uuid}/
     *
     * Blueprint instances
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param instanceUuid A UUID string identifying this Blueprint Instance.
     * @return [BlueprintInstance]
     */
    @GET("managed/blueprints/{instance_uuid}/")
    suspend fun managedBlueprintsRetrieve(@Path("instance_uuid") instanceUuid: java.util.UUID): Response<BlueprintInstance>

    /**
     * PUT managed/blueprints/{instance_uuid}/
     *
     * Blueprint instances
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param instanceUuid A UUID string identifying this Blueprint Instance.
     * @param blueprintInstanceRequest
     * @return [BlueprintInstance]
     */
    @PUT("managed/blueprints/{instance_uuid}/")
    suspend fun managedBlueprintsUpdate(@Path("instance_uuid") instanceUuid: java.util.UUID, @Body blueprintInstanceRequest: BlueprintInstanceRequest): Response<BlueprintInstance>

    /**
     * GET managed/blueprints/{instance_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param instanceUuid A UUID string identifying this Blueprint Instance.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("managed/blueprints/{instance_uuid}/used_by/")
    suspend fun managedBlueprintsUsedByList(@Path("instance_uuid") instanceUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

}
