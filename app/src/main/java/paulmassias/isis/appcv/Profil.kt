package paulmassias.isis.appcv

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun profil(WindowSizeClass: WindowSizeClass, navController: NavController) {

    //Condition sur le format de l'écran permettant d'adapter en cas de rotation de l'appareil
    when (WindowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> { // Lorsque l'affichage en largeur est compact - > le téléphone et debout
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            )
            {
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        // Image du profil
                        painterResource(R.drawable.index),
                        contentDescription = "Portrait",
                        modifier = Modifier
                            .size(250.dp)
                            .padding(20.dp)
                            .clip(CircleShape),
                    )

                    Text( // Nom du profil
                        text = "Paul Schwarzy",
                        fontSize = 27.sp,
                        textAlign = TextAlign.Center
                    )
                    Text( // Détails du profil
                        text = "Etudiant ingénieur ISIS",
                        fontStyle = FontStyle.Italic,
                        textAlign = TextAlign.Center
                    )

                    Text( // Contact du profil
                        text = "paul.massias36@gmail.com",
                        textAlign = TextAlign.Center
                    )
                    Button(

                        // Entrée dans l'application par la page des films en tendance
                        onClick = { navController.navigate("films") },

                        modifier = Modifier.padding(all = Dp(100F))
                    )
                    {
                        Text(text = "Recruter")
                    }
                }
            }

        }
        else -> { //C'est a dire tout autre type d'affichage que téléphone debout
            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            )
            {

                Image(
                    painterResource(R.drawable.index),
                    contentDescription = "Portrait",
                    modifier = Modifier
                        .size(250.dp)
                        .padding(20.dp)
                        .clip(CircleShape),
                )

                Text(
                    text = "Paul Schwarzy",
                    fontSize = 27.sp
                )
                Row(Modifier.padding(bottom = 50.dp)) {
                    Text(
                        text = "Etudiant ingénieur ISIS",
                        fontStyle = FontStyle.Italic,
                        fontSize = 18.sp
                    )
                }

                Text(text = "paul.massias36@gmail.com")

                Button(
                    onClick = {},
                    modifier = Modifier.padding(all = Dp(70F))
                )
                {
                    Text(text = "Recruter")

                }
            }
        }
    }
}
