package dev.greyfoundry.authentik.generated.api

import dev.greyfoundry.authentik.generated.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import dev.greyfoundry.authentik.generated.model.DataExport
import dev.greyfoundry.authentik.generated.model.GenericError
import dev.greyfoundry.authentik.generated.model.PaginatedDataExportList
import dev.greyfoundry.authentik.generated.model.ValidationError

interface ReportsApi {
    /**
     * DELETE reports/exports/{id}/
     *
     *
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param id A UUID string identifying this Data Export.
     * @return [Unit]
     */
    @DELETE("reports/exports/{id}/")
    suspend fun reportsExportsDestroy(@Path("id") id: java.util.UUID): Response<Unit>

    /**
     * GET reports/exports/
     *
     *
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedDataExportList]
     */
    @GET("reports/exports/")
    suspend fun reportsExportsList(@Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedDataExportList>

    /**
     * GET reports/exports/{id}/
     *
     *
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param id A UUID string identifying this Data Export.
     * @return [DataExport]
     */
    @GET("reports/exports/{id}/")
    suspend fun reportsExportsRetrieve(@Path("id") id: java.util.UUID): Response<DataExport>

}
