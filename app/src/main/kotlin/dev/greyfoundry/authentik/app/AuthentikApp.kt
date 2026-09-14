package dev.greyfoundry.authentik.app

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dev.greyfoundry.authentik.ui.navigation.AppNavigation
import dev.greyfoundry.authentik.ui.theme.AuthentikTheme

@Composable
fun AuthentikApp() {
    AuthentikTheme {
        AppNavigation()
    }
}

@Preview(showBackground = true)
@Composable
private fun AuthentikAppPreview() {
    AuthentikApp()
}
