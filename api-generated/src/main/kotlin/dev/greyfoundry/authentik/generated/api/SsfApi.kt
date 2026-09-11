package dev.greyfoundry.authentik.generated.api

import dev.greyfoundry.authentik.generated.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import dev.greyfoundry.authentik.generated.model.DeliveryMethodEnum
import dev.greyfoundry.authentik.generated.model.GenericError
import dev.greyfoundry.authentik.generated.model.PaginatedSSFStreamList
import dev.greyfoundry.authentik.generated.model.SSFStream
import dev.greyfoundry.authentik.generated.model.ValidationError

interface SsfApi {
    /**
     * DELETE ssf/streams/{uuid}/
     *
     * SSFStream Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this SSF Stream.
     * @return [Unit]
     */
    @DELETE("ssf/streams/{uuid}/")
    suspend fun ssfStreamsDestroy(@Path("uuid") uuid: java.util.UUID): Response<Unit>

    /**
     * GET ssf/streams/
     *
     * SSFStream Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param deliveryMethod  (optional)
     * @param endpointUrl  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param provider  (optional)
     * @param search A search term. (optional)
     * @return [PaginatedSSFStreamList]
     */
    @GET("ssf/streams/")
    suspend fun ssfStreamsList(@Query("delivery_method") deliveryMethod: DeliveryMethodEnum? = null, @Query("endpoint_url") endpointUrl: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("provider") provider: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedSSFStreamList>

    /**
     * GET ssf/streams/{uuid}/
     *
     * SSFStream Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param uuid A UUID string identifying this SSF Stream.
     * @return [SSFStream]
     */
    @GET("ssf/streams/{uuid}/")
    suspend fun ssfStreamsRetrieve(@Path("uuid") uuid: java.util.UUID): Response<SSFStream>

}
