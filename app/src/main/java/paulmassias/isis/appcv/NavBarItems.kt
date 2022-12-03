package paulmassias.isis.appcv

import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock


object NavBarItems {
    val BarItems = listOf(
        BarItem(
            title = "Films",
            image = Icons.Filled.Home,
            route = "films"
        ),
        BarItem(
            title = "Series",
            image = Icons.Filled.Lock,
            route = "listeSerie"
        ),
        BarItem(
            title = "Casting",
            image = Icons.Filled.Favorite,
            route = "listePersonnes"
        )
    )
}