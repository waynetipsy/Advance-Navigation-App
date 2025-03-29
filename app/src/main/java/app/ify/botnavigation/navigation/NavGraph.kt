package app.ify.botnavigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import app.ify.botnavigation.screens.HomeScreen
import app.ify.botnavigation.screens.ProfileScreen
import app.ify.botnavigation.screens.SettingsScreen

@Composable

fun NavGraph(navController: NavHostController){

    // Use navController to navigate to different
    // Composables defined in the nav graph

    //Nav Host: acts as a container for hosting the Nav Graph
    NavHost(navController = navController, startDestination = NavRoute.Home.path ) {
        addHomeScreen(
            navController,
            this
            )
        addProfileScreen(
            navController,
            this
        )
        addSettingsScreen(
            navController,
            this
        )
    }

}

fun addHomeScreen(navController: NavHostController,
               navGraphBuilder: NavGraphBuilder){

    //navGraphBuilder: define the composables route
    // for the HomeScreen

   navGraphBuilder.composable (route = NavRoute.Home.path
   ){
       HomeScreen(navigateToProfile = {
           id, showDetails ->
           navController.navigate(
               NavRoute.Profile.path.plus("/$id/$showDetails")
           )
       },
       navigateToSettings = {
           navController.navigate(NavRoute.Settings.path)}
       )

       }
   }

fun addProfileScreen(navController: NavHostController,
                  navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
       route = NavRoute.Profile.path.plus("/{id}/{showDetails}"),

        arguments = listOf(
            navArgument (NavRoute.Profile.id){
                type = NavType.IntType
            },
            navArgument(NavRoute.Profile.showDetails) {
                type = NavType.BoolType
            }
        )

    ){
        navBackStackEntry ->
        val args = navBackStackEntry.arguments

        ProfileScreen(id = args?.getInt(NavRoute.Profile.id)!!,
            showDetails = args.getBoolean(NavRoute.Profile.showDetails),
            navigateToSettings = { navController.navigate(NavRoute.Settings.path)}

        )
    }
}
fun addSettingsScreen(navController: NavHostController,
                      navGraphBuilder: NavGraphBuilder){
     navGraphBuilder.composable (route = NavRoute.Settings.path){
         SettingsScreen (navigateToHome = {navController.navigate(NavRoute.Home.path)})
     }
}