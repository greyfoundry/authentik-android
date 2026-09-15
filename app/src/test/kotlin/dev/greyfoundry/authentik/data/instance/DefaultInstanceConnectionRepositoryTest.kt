package dev.greyfoundry.authentik.data.instance

import dev.greyfoundry.authentik.compat.AuthentikGateway
import dev.greyfoundry.authentik.domain.model.CompatibilityLevel
import dev.greyfoundry.authentik.domain.model.InstanceDraft
import dev.greyfoundry.authentik.domain.model.InstanceId
import dev.greyfoundry.authentik.domain.model.InstanceProfile
import dev.greyfoundry.authentik.domain.model.ServerProfile
import dev.greyfoundry.authentik.domain.repository.InstanceRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class DefaultInstanceConnectionRepositoryTest {
    @Test
    fun `profiles then persists a normalized supported instance`() = runBlocking {
        val instances = RecordingInstanceRepository()
        var profiledBaseUrl: String? = null
        val repository = DefaultInstanceConnectionRepository(instances) { candidate ->
            profiledBaseUrl = candidate.baseUrl
            FixedGateway(server(CompatibilityLevel.SUPPORTED))
        }

        val result = repository.connect(" HTTPS://AUTH.EXAMPLE.COM ")

        assertEquals("https://auth.example.com/", profiledBaseUrl)
        assertEquals("https://auth.example.com/", result.instance.baseUrl)
        assertEquals(1, instances.addCalls)
    }

    @Test
    fun `reuses a previously saved instance with the same normalized URL`() = runBlocking {
        val existing = profile()
        val instances = RecordingInstanceRepository(existing)
        val repository = DefaultInstanceConnectionRepository(instances) {
            FixedGateway(server(CompatibilityLevel.SUPPORTED))
        }

        val result = repository.connect("https://auth.example.com")

        assertEquals(existing.id, result.instance.id)
        assertEquals(0, instances.addCalls)
    }

    @Test
    fun `does not persist an unsupported instance`() = runBlocking {
        val instances = RecordingInstanceRepository()
        val repository = DefaultInstanceConnectionRepository(instances) {
            FixedGateway(server(CompatibilityLevel.UNSUPPORTED))
        }

        val result = repository.connect("https://old.example.com")

        assertEquals(CompatibilityLevel.UNSUPPORTED, result.server.compatibilityLevel)
        assertEquals(0, instances.addCalls)
        assertNull(instances.activeInstance.value)
    }

    private fun server(level: CompatibilityLevel) = ServerProfile(
        versionCurrent = "2026.8.1",
        versionLatest = null,
        buildHash = null,
        outdated = false,
        outpostOutdated = false,
        compatibilityLevel = level,
    )

    private fun profile() = InstanceProfile(
        id = InstanceId("479df0e0-c5ab-41ed-b62c-3900e12493ce"),
        baseUrl = "https://auth.example.com/",
        displayName = "auth.example.com",
    )
}

private class FixedGateway(
    private val profile: ServerProfile,
) : AuthentikGateway {
    override suspend fun serverProfile(): ServerProfile = profile
}

private class RecordingInstanceRepository(
    initial: InstanceProfile? = null,
) : InstanceRepository {
    private val values = initial?.let(::listOf).orEmpty().toMutableList()
    private val mutableInstances = MutableStateFlow(values.toList())
    private val mutableActive = MutableStateFlow<InstanceProfile?>(null)
    var addCalls = 0

    override val activeInstance: StateFlow<InstanceProfile?> = mutableActive
    override val instances: StateFlow<List<InstanceProfile>> = mutableInstances

    override suspend fun get(instanceId: InstanceId): InstanceProfile? =
        values.firstOrNull { it.id == instanceId }

    override suspend fun getByBaseUrl(baseUrl: String): InstanceProfile? =
        values.firstOrNull { it.baseUrl == baseUrl }

    override suspend fun add(draft: InstanceDraft): InstanceProfile {
        addCalls += 1
        val created = InstanceProfile.create(draft)
        values += created
        mutableInstances.value = values.toList()
        return created
    }

    override suspend fun update(profile: InstanceProfile) = Unit

    override suspend fun remove(instanceId: InstanceId) = Unit

    override suspend fun setActive(instanceId: InstanceId) {
        mutableActive.value = get(instanceId)
    }
}
