package paulmassias.isis.appcv

import androidx.compose.ui.graphics.vector.ImageVector

//Définition de la class BarItem qui composera la bottombar de navigation
data class BarItem(
    val title: String,
    val image: ImageVector,
    val route: String
)
