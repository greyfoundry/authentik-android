package dev.greyfoundry.authentik.auth

import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import dev.greyfoundry.authentik.AuthRedirectActivity
import dev.greyfoundry.authentik.MainActivity
import dev.greyfoundry.authentik.authCallbackReturnIntent
import net.openid.appauth.RedirectUriReceiverActivity
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AuthRedirectTest {
    @Test
    fun exactOAuthRedirectResolvesToAppAuthReceiver() {
        val context = ApplicationProvider.getApplicationContext<android.content.Context>()
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(AuthConfiguration.REDIRECT_URI)).apply {
            addCategory(Intent.CATEGORY_BROWSABLE)
        }

        val resolved = context.packageManager.resolveActivity(intent, 0)

        assertEquals(RedirectUriReceiverActivity::class.java.name, resolved?.activityInfo?.name)
        assertEquals(context.packageName, resolved?.activityInfo?.packageName)
    }

    @Test
    fun unrelatedPathDoesNotResolveToAppAuthReceiver() {
        val context = ApplicationProvider.getApplicationContext<android.content.Context>()
        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("dev.greyfoundry.authentik://oauth2redirect/unrelated"),
        ).apply {
            addCategory(Intent.CATEGORY_BROWSABLE)
        }

        val resolved = context.packageManager.resolveActivity(intent, 0)

        assertNull(resolved)
    }

    @Test
    fun internalCallbackActivityIsNotExported() {
        val context = ApplicationProvider.getApplicationContext<android.content.Context>()

        val activity = context.packageManager.getActivityInfo(
            ComponentName(context, AuthRedirectActivity::class.java),
            0,
        )

        assertEquals(false, activity.exported)
    }

    @Test
    fun callbackReturnsToTheExistingMainTask() {
        val context = ApplicationProvider.getApplicationContext<android.content.Context>()

        val intent = authCallbackReturnIntent(context)

        assertEquals(MainActivity::class.java.name, intent.component?.className)
        assertTrue(intent.flags and Intent.FLAG_ACTIVITY_CLEAR_TOP != 0)
        assertTrue(intent.flags and Intent.FLAG_ACTIVITY_SINGLE_TOP != 0)
    }
}
