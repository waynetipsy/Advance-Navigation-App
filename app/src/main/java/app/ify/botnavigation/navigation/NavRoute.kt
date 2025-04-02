package app.ify.botnavigation.navigation

sealed class NavRoute (val path: String){
    // Sealed Class: represent restricted hierarchies
    // where a value can have one of the types from a
    // limited set, but no other types

    object Home: NavRoute("home")

    object Profile: NavRoute("profile"){

        fun createRoute(id: Int, showDetails: Boolean): String{
            return "profile/$id/$showDetails"
        }

        val id = "id"
        val showDetails = "showDetails"
    }
    object Settings: NavRoute("settings"){

    }
}