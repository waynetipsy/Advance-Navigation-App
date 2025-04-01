package app.ify.botnavigation.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavController

@Composable
fun BottomNavigationBar(navController: NavController) {

    //1- The Items of Bottom Nav Bar
    val navItems = listOf(NavItem.Home, NavItem.Profile, NavItem.Settings)

     //2- Create a state variable that persists across recompositions
    var selectedItem by rememberSaveable {
        mutableStateOf(0)
    }

    // 3- Navigation Bar
    NavigationBar {
       navItems.forEachIndexed { index, item ->
           NavigationBarItem(
               selected = selectedItem == index,
               onClick = {
                   selectedItem = index
                   navController.navigate(item.path) {
                       navController.graph.startDestinationRoute?.let { route ->
                           popUpTo(route) {
                               saveState = true
                           }
                           launchSingleTop = true
                           restoreState = true
                       }
                   }

               },
               icon = {
                   Icon(
                       imageVector = item.icon,
                       contentDescription = item.title) },
               label = { Text(item.title) }

           )

       }
       }
}