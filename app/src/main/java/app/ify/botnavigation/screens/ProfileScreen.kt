package app.ify.botnavigation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable

fun ProfileScreen(id: Int,
                  showDetails: Boolean,
                  navigateToSettings: ()->Unit

){
    Column (
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Profile ID")

        Button(onClick = navigateToSettings) {
            Text(text = "Go to Settings")
        }
    }
}