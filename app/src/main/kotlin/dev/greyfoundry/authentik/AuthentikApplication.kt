package dev.greyfoundry.authentik

import android.app.Application
import dev.greyfoundry.authentik.auth.AppAuthSessionRepository
import dev.greyfoundry.authentik.auth.DefaultOidcClient
import dev.greyfoundry.authentik.app.AppContainer
import dev.greyfoundry.authentik.data.instance.DataStoreInstanceRepository
import dev.greyfoundry.authentik.data.instance.DefaultInstanceConnectionRepository
import dev.greyfoundry.authentik.domain.repository.InstanceConnectionRepository
import dev.greyfoundry.authentik.domain.repository.InstanceRepository
import dev.greyfoundry.authentik.security.AndroidKeystoreCredentialStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class AuthentikApplication : Application(), AppContainer {
    private val applicationScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    override lateinit var authSessionRepository: AppAuthSessionRepository
        private set

    override lateinit var instanceRepository: InstanceRepository
        private set

    override lateinit var instanceConnectionRepository: InstanceConnectionRepository
        private set

    override fun onCreate() {
        super.onCreate()
        instanceRepository = DataStoreInstanceRepository.create(this, applicationScope)
        instanceConnectionRepository = DefaultInstanceConnectionRepository(instanceRepository)
        authSessionRepository = AppAuthSessionRepository(
            instanceRepository = instanceRepository,
            credentialStore = AndroidKeystoreCredentialStore(this),
            oidcClient = DefaultOidcClient(this),
            applicationScope = applicationScope,
        )
    }
}
