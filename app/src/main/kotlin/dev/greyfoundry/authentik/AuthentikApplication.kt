package dev.greyfoundry.authentik

import android.app.Application
import dev.greyfoundry.authentik.auth.AppAuthSessionRepository
import dev.greyfoundry.authentik.auth.DefaultOidcClient
import dev.greyfoundry.authentik.data.instance.DataStoreInstanceRepository
import dev.greyfoundry.authentik.domain.repository.InstanceRepository
import dev.greyfoundry.authentik.security.AndroidKeystoreCredentialStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class AuthentikApplication : Application() {
    private val applicationScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    lateinit var authSessionRepository: AppAuthSessionRepository
        private set

    lateinit var instanceRepository: InstanceRepository
        private set

    override fun onCreate() {
        super.onCreate()
        instanceRepository = DataStoreInstanceRepository.create(this, applicationScope)
        authSessionRepository = AppAuthSessionRepository(
            instanceRepository = instanceRepository,
            credentialStore = AndroidKeystoreCredentialStore(this),
            oidcClient = DefaultOidcClient(this),
            applicationScope = applicationScope,
        )
    }
}
