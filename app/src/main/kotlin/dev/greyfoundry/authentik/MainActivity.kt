package dev.greyfoundry.authentik

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import dev.greyfoundry.authentik.ui.theme.AuthentikTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AuthentikCompanionApp()
        }
    }
}

@Composable
private fun AuthentikCompanionApp() {
    AuthentikTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.safeContentPadding(),
            ) {
                Text(text = stringResource(R.string.app_name))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AuthentikCompanionAppPreview() {
    AuthentikCompanionApp()
}
