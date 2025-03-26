package app.ify.botnavigation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun SettingsScreen(
    navigateToHome: () ->Unit
){
    Column (modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
        ){
        Text("Settings Screen", fontSize = 40.sp)

        Button(onClick = navigateToHome) { Text(text = "Navigate to Home")}
    }
}