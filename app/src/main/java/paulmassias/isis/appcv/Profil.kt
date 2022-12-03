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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
    fun profil(WindowSizeClass: WindowSizeClass, navController : NavController) {


        when (WindowSizeClass.widthSizeClass) {
            WindowWidthSizeClass.Compact -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Top
                )
                {
                    Row(Modifier.padding(bottom = 50.dp)) {
                        Text(
                            text = "Etudiant ingénieur ISIS",
                            fontStyle = FontStyle.Italic,
                            fontSize = 18.sp
                        )
                    }
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

                    Text(text = "paul.massias36@gmail.com")
                    Button(
                        onClick = {navController.navigate("films")},
                        modifier = Modifier.padding(all = Dp(70F))
                    )
                    {
                        Text(text = "Recruter")
                    }
                }

            }
            else -> {
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
