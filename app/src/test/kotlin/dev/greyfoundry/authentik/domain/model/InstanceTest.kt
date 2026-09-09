package dev.greyfoundry.authentik.domain.model

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class InstanceTest {
    private val instanceId = InstanceId("2f8c7ec7-09f9-4c54-b73d-7f83064e8d4e")

    @Test
    fun `normalizes an HTTPS base URL and display name`() {
        val profile = InstanceProfile.create(
            draft = InstanceDraft(
                baseUrl = "  https://Example.COM/authentik///  ",
                displayName = "  Production  ",
            ),
            id = instanceId,
        )

        assertEquals("https://example.com/authentik/", profile.baseUrl)
        assertEquals("Production", profile.displayName)
        assertEquals(instanceId, profile.id)
    }

    @Test
    fun `uses the host as the default display name`() {
        val profile = InstanceProfile.create(
            draft = InstanceDraft("https://id.example.com", displayName = "  "),
            id = instanceId,
        )

        assertEquals("id.example.com", profile.displayName)
        assertEquals("https://id.example.com/", profile.baseUrl)
    }

    @Test
    fun `rejects insecure localhost by default`() {
        assertThrows(IllegalArgumentException::class.java) {
            InstanceProfile.create(
                draft = InstanceDraft("http://localhost:9000", displayName = null),
                id = instanceId,
            )
        }
    }

    @Test
    fun `rejects a URL without a host`() {
        assertThrows(IllegalArgumentException::class.java) {
            InstanceProfile.create(
                draft = InstanceDraft("https:///missing-host", displayName = null),
                id = instanceId,
            )
        }
    }

    @Test
    fun `rejects URL components that do not belong in a base URL`() {
        listOf(
            "https://user@example.com/",
            "https://example.com/?tenant=one",
            "https://example.com/#fragment",
        ).forEach { baseUrl ->
            assertThrows(baseUrl, IllegalArgumentException::class.java) {
                InstanceProfile.create(
                    draft = InstanceDraft(baseUrl, displayName = null),
                    id = instanceId,
                )
            }
        }
    }

    @Test
    fun `keeps the instance identity stable when profile details change`() {
        val original = InstanceProfile.create(
            draft = InstanceDraft("https://id.example.com", displayName = "Primary"),
            id = instanceId,
        )

        val renamed = original.copy(displayName = "Renamed")

        assertEquals(original.id, renamed.id)
    }

    @Test
    fun `rejects malformed instance identifiers`() {
        assertThrows(IllegalArgumentException::class.java) {
            InstanceId("not-a-uuid")
        }
    }
}
