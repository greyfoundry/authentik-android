package dev.greyfoundry.authentik.data.instance

import androidx.datastore.core.DataStore
import androidx.datastore.core.okio.OkioStorage
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.PreferencesSerializer
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import dev.greyfoundry.authentik.domain.model.InstanceDraft
import dev.greyfoundry.authentik.domain.model.InstanceId
import dev.greyfoundry.authentik.domain.model.InstanceProfile
import java.io.File
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import okio.FileSystem
import okio.Path.Companion.toPath
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertThrows
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder

class InstanceRepositoryTest {
    @get:Rule
    val temporaryFolder = TemporaryFolder()

    private lateinit var scope: CoroutineScope
    private lateinit var dataStore: DataStore<Preferences>
    private lateinit var repository: DataStoreInstanceRepository

    @Before
    fun setUp() {
        scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
        val dataStoreFile = File(temporaryFolder.root, "instances.preferences_pb")
        dataStore = PreferenceDataStoreFactory.create(
            storage = OkioStorage(
                fileSystem = FileSystem.SYSTEM,
                serializer = PreferencesSerializer,
                producePath = { dataStoreFile.absolutePath.toPath() },
            ),
            scope = scope,
        )
        repository = DataStoreInstanceRepository(dataStore, scope)
    }

    @After
    fun tearDown() {
        scope.cancel()
    }

    @Test
    fun `adds and updates normalized instance profiles in insertion order`() = runBlocking {
        val first = repository.add(InstanceDraft("https://One.Example.com", " One "))
        val second = repository.add(InstanceDraft("https://two.example.com/authentik", null))

        assertEquals(
            listOf(first, second),
            awaitInstances { it.size == 2 },
        )

        val renamed = first.copy(displayName = "Primary")
        repository.update(renamed)

        assertEquals(
            listOf(renamed, second),
            awaitInstances { instances -> instances.firstOrNull()?.displayName == "Primary" },
        )
    }

    @Test
    fun `selects an existing instance and reflects profile updates`() = runBlocking {
        val instance = repository.add(InstanceDraft("https://id.example.com", "Identity"))

        repository.setActive(instance.id)
        assertEquals(instance, awaitActive { it?.id == instance.id })

        val renamed = instance.copy(displayName = "Renamed")
        repository.update(renamed)

        assertEquals(renamed, awaitActive { it?.displayName == "Renamed" })
    }

    @Test
    fun `removing the active instance clears active selection`() = runBlocking {
        val instance = repository.add(InstanceDraft("https://id.example.com", null))
        repository.setActive(instance.id)
        awaitActive { it != null }

        repository.remove(instance.id)

        assertEquals(emptyList<InstanceProfile>(), awaitInstances(List<InstanceProfile>::isEmpty))
        assertNull(awaitActive { it == null })
    }

    @Test
    fun `rejects updates and selection for unknown identifiers`() {
        val missingId = InstanceId("7261b3f2-7f63-4f1a-9c29-55706998a70c")
        val missingProfile = InstanceProfile.create(
            draft = InstanceDraft("https://missing.example.com", "Missing"),
            id = missingId,
        )

        assertThrows(NoSuchElementException::class.java) {
            runBlocking { repository.setActive(missingId) }
        }
        assertThrows(NoSuchElementException::class.java) {
            runBlocking { repository.update(missingProfile) }
        }
    }

    @Test
    fun `reads one profile by identifier`() = runBlocking {
        val instance = repository.add(InstanceDraft("https://id.example.com", "Identity"))
        val missingId = InstanceId("6978cd24-0312-4fad-a78c-0d6fe2e8279f")

        assertEquals(instance, repository.get(instance.id))
        assertNull(repository.get(missingId))
    }

    @Test
    fun `persists only instance metadata and active selection`() = runBlocking {
        val instance = repository.add(InstanceDraft("https://id.example.com", "Identity"))
        repository.setActive(instance.id)

        val preferences = dataStore.data.first()
        assertEquals(
            setOf("instance_profiles", "active_instance_id"),
            preferences.asMap().keys.map { it.name }.toSet(),
        )
        val serializedProfiles = preferences[stringPreferencesKey("instance_profiles")].orEmpty()
        assertFalse(serializedProfiles.contains("password", ignoreCase = true))
        assertFalse(serializedProfiles.contains("token", ignoreCase = true))
        assertFalse(serializedProfiles.contains("credential", ignoreCase = true))
    }

    @Test
    fun `ignores additive fields in stored instance metadata`() = runBlocking {
        val expected = InstanceProfile(
            id = InstanceId("311cb976-967b-4590-8ee2-99c3c51d52c4"),
            baseUrl = "https://id.example.com/",
            displayName = "Identity",
        )
        dataStore.edit { preferences ->
            preferences[stringPreferencesKey("instance_profiles")] = """
                [{
                  "id": "${expected.id.value}",
                  "base_url": "${expected.baseUrl}",
                  "display_name": "${expected.displayName}",
                  "future_field": true
                }]
            """.trimIndent()
        }

        assertEquals(listOf(expected), awaitInstances { it == listOf(expected) })
    }

    private suspend fun awaitInstances(
        predicate: (List<InstanceProfile>) -> Boolean,
    ) = withTimeout(5_000) { repository.instances.first(predicate) }

    private suspend fun awaitActive(
        predicate: (InstanceProfile?) -> Boolean,
    ) = withTimeout(5_000) { repository.activeInstance.first(predicate) }
}
