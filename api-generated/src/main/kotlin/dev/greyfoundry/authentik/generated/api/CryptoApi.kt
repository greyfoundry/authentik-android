package dev.greyfoundry.authentik.generated.api

import dev.greyfoundry.authentik.generated.infrastructure.CollectionFormats.*
import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import dev.greyfoundry.authentik.generated.model.CertificateData
import dev.greyfoundry.authentik.generated.model.CertificateGenerationRequest
import dev.greyfoundry.authentik.generated.model.CertificateKeyPair
import dev.greyfoundry.authentik.generated.model.CertificateKeyPairRequest
import dev.greyfoundry.authentik.generated.model.GenericError
import dev.greyfoundry.authentik.generated.model.KeyTypeEnum
import dev.greyfoundry.authentik.generated.model.PaginatedCertificateKeyPairList
import dev.greyfoundry.authentik.generated.model.PatchedCertificateKeyPairRequest
import dev.greyfoundry.authentik.generated.model.UsedBy
import dev.greyfoundry.authentik.generated.model.ValidationError

interface CryptoApi {
    /**
     * POST crypto/certificatekeypairs/
     *
     * CertificateKeyPair Viewset
     * Responses:
     *  - 201:
     *  - 400:
     *  - 403:
     *
     * @param certificateKeyPairRequest
     * @return [CertificateKeyPair]
     */
    @POST("crypto/certificatekeypairs/")
    suspend fun cryptoCertificatekeypairsCreate(@Body certificateKeyPairRequest: CertificateKeyPairRequest): Response<CertificateKeyPair>

    /**
     * DELETE crypto/certificatekeypairs/{kp_uuid}/
     *
     * CertificateKeyPair Viewset
     * Responses:
     *  - 204: No response body
     *  - 400:
     *  - 403:
     *
     * @param kpUuid A UUID string identifying this Certificate-Key Pair.
     * @return [Unit]
     */
    @DELETE("crypto/certificatekeypairs/{kp_uuid}/")
    suspend fun cryptoCertificatekeypairsDestroy(@Path("kp_uuid") kpUuid: java.util.UUID): Response<Unit>

    /**
     * POST crypto/certificatekeypairs/generate/
     *
     * Generate a new, self-signed certificate-key pair
     * Responses:
     *  - 200:
     *  - 400: Bad request
     *  - 403:
     *
     * @param certificateGenerationRequest
     * @return [CertificateKeyPair]
     */
    @POST("crypto/certificatekeypairs/generate/")
    suspend fun cryptoCertificatekeypairsGenerateCreate(@Body certificateGenerationRequest: CertificateGenerationRequest): Response<CertificateKeyPair>

    /**
     * GET crypto/certificatekeypairs/
     *
     * CertificateKeyPair Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param hasKey Only return certificate-key pairs with keys (optional)
     * @param keyType  (optional)
     * @param managed  (optional)
     * @param name  (optional)
     * @param ordering Which field to use when ordering the results. (optional)
     * @param page A page number within the paginated result set. (optional)
     * @param pageSize Number of results to return per page. (optional)
     * @param search A search term. (optional)
     * @return [PaginatedCertificateKeyPairList]
     */
    @GET("crypto/certificatekeypairs/")
    suspend fun cryptoCertificatekeypairsList(@Query("has_key") hasKey: kotlin.Boolean? = null, @Query("key_type") keyType: @JvmSuppressWildcards kotlin.collections.List<KeyTypeEnum>? = null, @Query("managed") managed: kotlin.String? = null, @Query("name") name: kotlin.String? = null, @Query("ordering") ordering: kotlin.String? = null, @Query("page") page: kotlin.Int? = null, @Query("page_size") pageSize: kotlin.Int? = null, @Query("search") search: kotlin.String? = null): Response<PaginatedCertificateKeyPairList>

    /**
     * PATCH crypto/certificatekeypairs/{kp_uuid}/
     *
     * CertificateKeyPair Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param kpUuid A UUID string identifying this Certificate-Key Pair.
     * @param patchedCertificateKeyPairRequest  (optional)
     * @return [CertificateKeyPair]
     */
    @PATCH("crypto/certificatekeypairs/{kp_uuid}/")
    suspend fun cryptoCertificatekeypairsPartialUpdate(@Path("kp_uuid") kpUuid: java.util.UUID, @Body patchedCertificateKeyPairRequest: PatchedCertificateKeyPairRequest? = null): Response<CertificateKeyPair>

    /**
     * GET crypto/certificatekeypairs/{kp_uuid}/
     *
     * CertificateKeyPair Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param kpUuid A UUID string identifying this Certificate-Key Pair.
     * @return [CertificateKeyPair]
     */
    @GET("crypto/certificatekeypairs/{kp_uuid}/")
    suspend fun cryptoCertificatekeypairsRetrieve(@Path("kp_uuid") kpUuid: java.util.UUID): Response<CertificateKeyPair>

    /**
     * PUT crypto/certificatekeypairs/{kp_uuid}/
     *
     * CertificateKeyPair Viewset
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param kpUuid A UUID string identifying this Certificate-Key Pair.
     * @param certificateKeyPairRequest
     * @return [CertificateKeyPair]
     */
    @PUT("crypto/certificatekeypairs/{kp_uuid}/")
    suspend fun cryptoCertificatekeypairsUpdate(@Path("kp_uuid") kpUuid: java.util.UUID, @Body certificateKeyPairRequest: CertificateKeyPairRequest): Response<CertificateKeyPair>

    /**
     * GET crypto/certificatekeypairs/{kp_uuid}/used_by/
     *
     * Get a list of all objects that use this object
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param kpUuid A UUID string identifying this Certificate-Key Pair.
     * @return [kotlin.collections.List<UsedBy>]
     */
    @GET("crypto/certificatekeypairs/{kp_uuid}/used_by/")
    suspend fun cryptoCertificatekeypairsUsedByList(@Path("kp_uuid") kpUuid: java.util.UUID): Response<kotlin.collections.List<UsedBy>>

    /**
     * GET crypto/certificatekeypairs/{kp_uuid}/view_certificate/
     *
     * Return certificate-key pairs certificate and log access
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param kpUuid A UUID string identifying this Certificate-Key Pair.
     * @param download  (optional)
     * @return [CertificateData]
     */
    @GET("crypto/certificatekeypairs/{kp_uuid}/view_certificate/")
    suspend fun cryptoCertificatekeypairsViewCertificateRetrieve(@Path("kp_uuid") kpUuid: java.util.UUID, @Query("download") download: kotlin.Boolean? = null): Response<CertificateData>

    /**
     * GET crypto/certificatekeypairs/{kp_uuid}/view_private_key/
     *
     * Return certificate-key pairs private key and log access
     * Responses:
     *  - 200:
     *  - 400:
     *  - 403:
     *
     * @param kpUuid A UUID string identifying this Certificate-Key Pair.
     * @param download  (optional)
     * @return [CertificateData]
     */
    @GET("crypto/certificatekeypairs/{kp_uuid}/view_private_key/")
    suspend fun cryptoCertificatekeypairsViewPrivateKeyRetrieve(@Path("kp_uuid") kpUuid: java.util.UUID, @Query("download") download: kotlin.Boolean? = null): Response<CertificateData>

}
