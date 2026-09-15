package dev.greyfoundry.authentik

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import dev.greyfoundry.authentik.auth.AppAuthSessionRepository
import dev.greyfoundry.authentik.domain.model.InstanceId
import dev.greyfoundry.authentik.domain.repository.InstanceRepository
import kotlinx.coroutines.launch

class AuthRedirectActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val instanceId = intent.getStringExtra(EXTRA_INSTANCE_ID)
            ?.let { value -> runCatching { InstanceId(value) }.getOrNull() }
        val application = application as? AuthentikApplication
        if (instanceId == null || application == null) {
            returnToMain()
            return
        }

        lifecycleScope.launch {
            runCatching {
                completeAuthorizationCallback(
                    authRepository = application.authSessionRepository,
                    instanceRepository = application.instanceRepository,
                    instanceId = instanceId,
                    responseIntent = intent,
                )
            }
            returnToMain()
        }
    }

    companion object {
        const val EXTRA_INSTANCE_ID = "dev.greyfoundry.authentik.extra.INSTANCE_ID"
        const val EXTRA_CANCELLED = "dev.greyfoundry.authentik.extra.CANCELLED"
    }

    private fun returnToMain() {
        startActivity(authCallbackReturnIntent(this))
        finish()
    }
}

internal fun authCallbackReturnIntent(context: Context): Intent =
    Intent(context, MainActivity::class.java).addFlags(
        Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP,
    )

internal suspend fun completeAuthorizationCallback(
    authRepository: AppAuthSessionRepository,
    instanceRepository: InstanceRepository,
    instanceId: InstanceId,
    responseIntent: Intent,
) {
    authRepository.consumeAuthorizationResponse(instanceId, responseIntent)
    instanceRepository.setActive(instanceId)
}
