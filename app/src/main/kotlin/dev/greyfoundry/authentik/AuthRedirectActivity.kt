package dev.greyfoundry.authentik

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import dev.greyfoundry.authentik.domain.model.InstanceId
import kotlinx.coroutines.launch

class AuthRedirectActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val instanceId = intent.getStringExtra(EXTRA_INSTANCE_ID)
            ?.let { value -> runCatching { InstanceId(value) }.getOrNull() }
        val application = application as? AuthentikApplication
        if (instanceId == null || application == null) {
            finish()
            return
        }

        lifecycleScope.launch {
            runCatching {
                application.authSessionRepository.consumeAuthorizationResponse(instanceId, intent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_INSTANCE_ID = "dev.greyfoundry.authentik.extra.INSTANCE_ID"
        const val EXTRA_CANCELLED = "dev.greyfoundry.authentik.extra.CANCELLED"
    }
}
