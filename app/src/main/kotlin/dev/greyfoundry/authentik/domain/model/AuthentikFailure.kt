package dev.greyfoundry.authentik.domain.model

sealed class AuthentikFailure(
    message: String,
    cause: Throwable? = null,
) : RuntimeException(message, cause)

class NetworkUnavailable(cause: Throwable) :
    AuthentikFailure("The authentik instance could not be reached.", cause)

class TlsFailure(cause: Throwable) :
    AuthentikFailure("The authentik instance did not pass TLS verification.", cause)

class AuthenticationExpired :
    AuthentikFailure("Authentication is required for this authentik instance.")

class PermissionDenied :
    AuthentikFailure("The current account is not allowed to perform this request.")

class NotFound : AuthentikFailure("The requested authentik resource was not found.")

class Conflict : AuthentikFailure("The authentik resource changed or conflicts with this request.")

class RateLimited : AuthentikFailure("The authentik instance is temporarily rate limiting requests.")

class ServerError(val statusCode: Int) :
    AuthentikFailure("The authentik instance returned HTTP $statusCode.")

class MalformedServerResponse(cause: Throwable? = null) :
    AuthentikFailure("The authentik instance returned an unreadable response.", cause)
