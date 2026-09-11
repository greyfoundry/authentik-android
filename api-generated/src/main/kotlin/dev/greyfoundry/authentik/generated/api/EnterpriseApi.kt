package dev.greyfoundry.authentik.generated.api

import dev.greyfoundry.authentik.generated.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import dev.greyfoundry.authentik.generated.model.GenericError
import dev.greyfoundry.authentik.generated.model.InstallID
import dev.greyfoundry.authentik.generated.model.License
import dev.greyfoundry.authentik.generated.model.LicenseForecast
import dev.greyfoundry.authentik.generated.model.LicenseRequest
import dev.greyfoundry.authentik.generated.model.LicenseSummary
import dev.greyfoundry.authentik.generated.model.PaginatedLicenseList
import dev.greyfoundry.authentik.generated.model.PatchedLicenseRequest
import dev.greyfoundry.authentik.generated.model.UsedBy
import dev.greyfoundry.authentik.generated.model.ValidationError

interface EnterpriseApi {
    /**
     * POST enterprise/license/
     *
     * License Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param licenseRequest
     * @return [License]
     */
    @POST("enterprise/license/")
    suspend fun enterpriseLicenseCreate(@Body licenseRequest: LicenseRequest): Response<License>

    /**
     * DELETE enterprise/license/{license_uuid}/
     *
     * License Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param licenseUuid A UUID string identifying this License.
     * @return [Unit]
     */
    @DELETE("enterprise/license/{license_uuid}/")
    suspend fun enterpriseLicenseDestroy(@Path("license_uuid") licenseUuid: java.util.UUID): Response<Unit>

    /**
     * GET enterprise/license/forecast/
     *
     * Forecast how many users will be required in a year
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @return [LicenseForecast]
     */
    @GET("enterprise/license/forecast/")
    suspend fun enterpriseLicenseForecastRetrieve(): Response<LicenseForecast>

    /**
     * GET enterprise/license/install_id/
     *
     * Get install_id
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @return [InstallID]
     */
    @GET("enterprise/license/install_id/")
    suspend fun enterpriseLicenseInstallIdRetrieve(): Response<InstallID>

    /**
     * GET enterprise/license/
     *
     * License Viewset
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
     * @return [PaginatedLicenseList]
     */
    @GET("enterprise/license/")
    suspend fun enterpriseLicenseList(@Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedLicenseList>

    /**
     * PATCH enterprise/license/{license_uuid}/
     *
     * License Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param licenseUuid A UUID string identifying this License.
     * @param patchedLicenseRequest  (optional)
     * @return [License]
     */
    @PATCH("enterprise/license/{license_uuid}/")
    suspend fun enterpriseLicensePartialUpdate(@Path("license_uuid") licenseUuid: java.util.UUID, @Body patchedLicenseRequest: PatchedLicenseRequest? = null): Response<License>

    /**
     * GET enterprise/license/{license_uuid}/
     *
     * License Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param licenseUuid A UUID string identifying this License.
     * @return [License]
     */
    @GET("enterprise/license/{license_uuid}/")
    suspend fun enterpriseLicenseRetrieve(@Path("license_uuid") licenseUuid: java.util.UUID): Response<License>

    /**
     * GET enterprise/license/summary/
     *
     * Get the total license status
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param cached  (optional, default to true)
     * @return [LicenseSummary]
     */
    @GET("enterprise/license/summary/")
    suspend fun enterpriseLicenseSummaryRetrieve(@Query("cached") cached: kotlin.Boolean? = true): Response<LicenseSummary>

    /**
     * PUT enterprise/license/{license_uuid}/
     *
     * License Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param licenseUuid A UUID string identifying this License.
     * @param licenseRequest
     * @return [License]
     */
    @PUT("enterprise/license/{license_uuid}/")
    suspend fun enterpriseLicenseUpdate(@Path("license_uuid") licenseUuid: java.util.UUID, @Body licenseRequest: LicenseRequest): Response<License>

    /**
     * GET enterprise/license/{license_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param licenseUuid A UUID string identifying this License.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("enterprise/license/{license_uuid}/used_by/")
    suspend fun enterpriseLicenseUsedByList(@Path("license_uuid") licenseUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

}
