package app.ify.botnavigation.navigation

sealed class NavRoute (val path: String){
    // Sealed Class: represent restricted hierarchies
    // where a value can have one of the types from a
    // limited set, but no other types

    object Home: NavRoute("home")

    object Profile: NavRoute("profile"){
        val id = "id"
        val showDetails = "showDetails"
    }
    object Settings: NavRoute("settings"){

    }
}