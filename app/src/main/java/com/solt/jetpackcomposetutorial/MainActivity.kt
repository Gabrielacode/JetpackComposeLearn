package com.solt.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.sp
import com.solt.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme
//Today we will be learning Jetpack Compose
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            JetpackComposeTutorialTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   ChristmasGreeting(name = "Garbi",Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,

    )
}
@Composable
fun ChristmasGreeting(name:String,modifier: Modifier = Modifier){
 Text(
     text = "Merry Christmas , $name",
     modifier,
     color = androidx.compose.ui.graphics.Color.Magenta,
     fontSize = 30.sp,
     letterSpacing = 4.sp
 )

}
//Here we are practicing with the text composable
//Composable functions are functions that define  the ui of Jetpack Compose
// There are like Flutter Widgets and depend on sate instead of manual setting of ui based on data
//A function that is annotated with @Composable is composable function
//The Text Composable is a composable function that allows us to display text on the screen
//It comes with parameters that allows us to define the style of the text
//Here we can use dp and sp as units of measurement as in XML but here there are now extension functions of the Int class

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeTutorialTheme {
        ChristmasGreeting(name = "Gabriel")
    }
}