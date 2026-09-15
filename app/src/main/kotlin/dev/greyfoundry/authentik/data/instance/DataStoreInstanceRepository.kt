package dev.greyfoundry.authentik.data.instance

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dev.greyfoundry.authentik.domain.model.InstanceDraft
import dev.greyfoundry.authentik.domain.model.InstanceId
import dev.greyfoundry.authentik.domain.model.InstanceProfile
import dev.greyfoundry.authentik.domain.repository.InstanceRepository
import java.io.IOException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

private val Context.instanceMetadataDataStore by preferencesDataStore(
    name = "instance_metadata",
)

class DataStoreInstanceRepository(
    private val dataStore: DataStore<Preferences>,
    scope: CoroutineScope,
) : InstanceRepository {
    private val repositoryStates = dataStore.data
        .catch { failure ->
            if (failure is IOException) {
                emit(emptyPreferences())
            } else {
                throw failure
            }
        }
        .map(::decodeState)

    private val storedState = repositoryStates
        .stateIn(
            scope = scope,
            started = SharingStarted.Eagerly,
            initialValue = RepositoryState(),
        )

    override suspend fun get(instanceId: InstanceId): InstanceProfile? =
        repositoryStates.first().instances.firstOrNull { it.id == instanceId }

    override suspend fun getByBaseUrl(baseUrl: String): InstanceProfile? =
        repositoryStates.first().instances.firstOrNull { it.baseUrl == baseUrl }

    override val instances: StateFlow<List<InstanceProfile>> = storedState
        .map { state -> state.instances }
        .stateIn(
            scope = scope,
            started = SharingStarted.Eagerly,
            initialValue = emptyList(),
        )

    override val activeInstance: StateFlow<InstanceProfile?> = storedState
        .map { state ->
            state.instances.firstOrNull { it.id == state.activeInstanceId }
        }
        .stateIn(
            scope = scope,
            started = SharingStarted.Eagerly,
            initialValue = null,
        )

    override suspend fun add(draft: InstanceDraft): InstanceProfile {
        val profile = InstanceProfile.create(draft)
        dataStore.edit { preferences ->
            val state = decodeState(preferences)
            check(state.instances.none { it.id == profile.id }) {
                "Generated instance identifier already exists."
            }
            preferences[INSTANCE_PROFILES] = encodeProfiles(state.instances + profile)
        }
        return profile
    }

    override suspend fun update(profile: InstanceProfile) {
        dataStore.edit { preferences ->
            val instances = decodeState(preferences).instances.toMutableList()
            val index = instances.indexOfFirst { it.id == profile.id }
            if (index < 0) {
                throw NoSuchElementException("Instance profile not found.")
            }
            instances[index] = profile
            preferences[INSTANCE_PROFILES] = encodeProfiles(instances)
        }
    }

    override suspend fun remove(instanceId: InstanceId) {
        dataStore.edit { preferences ->
            val state = decodeState(preferences)
            val remaining = state.instances.filterNot { it.id == instanceId }
            if (remaining.isEmpty()) {
                preferences.remove(INSTANCE_PROFILES)
            } else {
                preferences[INSTANCE_PROFILES] = encodeProfiles(remaining)
            }
            if (state.activeInstanceId == instanceId) {
                preferences.remove(ACTIVE_INSTANCE_ID)
            }
        }
    }

    override suspend fun setActive(instanceId: InstanceId) {
        dataStore.edit { preferences ->
            val state = decodeState(preferences)
            if (state.instances.none { it.id == instanceId }) {
                throw NoSuchElementException("Instance profile not found.")
            }
            preferences[ACTIVE_INSTANCE_ID] = instanceId.value
        }
    }

    private fun decodeState(preferences: Preferences): RepositoryState {
        val instances = preferences[INSTANCE_PROFILES]
            ?.let { JSON.decodeFromString<List<StoredInstance>>(it) }
            .orEmpty()
            .map(StoredInstance::toDomain)
        check(instances.distinctBy(InstanceProfile::id).size == instances.size) {
            "Stored instance identifiers must be unique."
        }
        val activeInstanceId = preferences[ACTIVE_INSTANCE_ID]
            ?.let { value -> runCatching { InstanceId(value) }.getOrNull() }
            ?.takeIf { candidate -> instances.any { it.id == candidate } }
        return RepositoryState(instances, activeInstanceId)
    }

    private fun encodeProfiles(instances: List<InstanceProfile>): String =
        JSON.encodeToString(instances.map(StoredInstance::fromDomain))

    companion object {
        fun create(
            context: Context,
            scope: CoroutineScope,
        ): DataStoreInstanceRepository = DataStoreInstanceRepository(
            dataStore = context.applicationContext.instanceMetadataDataStore,
            scope = scope,
        )

        private val INSTANCE_PROFILES = stringPreferencesKey("instance_profiles")
        private val ACTIVE_INSTANCE_ID = stringPreferencesKey("active_instance_id")
        private val JSON = Json {
            ignoreUnknownKeys = true
        }
    }
}

private data class RepositoryState(
    val instances: List<InstanceProfile> = emptyList(),
    val activeInstanceId: InstanceId? = null,
)

@Serializable
private data class StoredInstance(
    @SerialName("id")
    val id: String,

    @SerialName("base_url")
    val baseUrl: String,

    @SerialName("display_name")
    val displayName: String,
) {
    fun toDomain(): InstanceProfile = InstanceProfile(
        id = InstanceId(id),
        baseUrl = baseUrl,
        displayName = displayName,
    )

    companion object {
        fun fromDomain(profile: InstanceProfile): StoredInstance = StoredInstance(
            id = profile.id.value,
            baseUrl = profile.baseUrl,
            displayName = profile.displayName,
        )
    }
}
