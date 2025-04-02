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
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(navController: NavController) {

    //1- The Items of Bottom Nav Bar
    val navItems = listOf(NavItem.Home, NavItem.Profile, NavItem.Settings)

     //2- Create a state variable that persists across recompositions

    // Synchronization between NavigationBar and Current Screen

    //3- Observing the current back stack entry
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    //4=- Current Route
    val currentRoute = navBackStackEntry?.destination?.route

    //2- Create a state variable that persists across recompositions
    var selectedItem = navItems.indexOfFirst { it.path == currentRoute }
    var selectedNavItem by rememberSaveable {
        mutableStateOf(if (selectedItem >= 0) selectedItem else 0)
    }

    // 3- Navigation Bar
    NavigationBar {
       navItems.forEachIndexed { index, item ->
           NavigationBarItem(
               selected = selectedItem == index,
               onClick = {
                   selectedNavItem = index

                   // Handling the navigation to the profile screen
                   //Passing argument between the screens
                   val route = if (item.path == NavRoute.Profile.path){
                       NavRoute.Profile.path.plus("/123/true")
                   }else {
                       item.path
                   }

                   navController.navigate(route) {
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