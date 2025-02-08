package com.solt.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.solt.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme
import com.solt.jetpackcomposetutorial.ui.theme.Purple80

//Today we will be learning Jetpack Compose
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            JetpackComposeTutorialTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   ChristmasGreeting(name = "Garbi",Modifier.padding(innerPadding))
                   ChristmasGreeting(name = "Ralphi",Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
   Text(
       text = "Greetings $name",
       modifier = modifier
   )

}
@Composable
fun threeBestFriends(name1:String,name2:String,name3:String){
    //We will be testing the column composable
    //We can also add modifiers
    //The horizontalAlignment ->which aligns the column items in the horizontal axis
   //The vertical arrangment -> arranges the elements in the vertical axis

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
            .background(Purple80, RoundedCornerShape(12.dp)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ){
         Text(text = "Name$name1")
         Text(text = "Name$name2")
         Text(text = "Name$name3")
    }
}

@Composable
fun threeBestElements(name1:String,name2:String,name3:String){
    //We will be testing the row layout composable
    //We can also add modifiers
    //The horizontalArrangement ->which aligns the row items in the horizontal axis
    //The vertical alignment -> arranges the elements in the vertical axis

    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
            .background(Purple80, RoundedCornerShape(12.dp)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ){
        Text(text = "Name$name1")
        Text(text = "Name$name2")
        Text(text = "Name$name3")
    }
}

@Composable
fun threeBoxes(){
  //Here we will be looking at the box layout
    //Which is like the Frame layout in xml
    //where elements stack on each other
    //And has more flexibility
    //The children can also specify a z index to determine the z positioning in the box layout
    //And an alignment on where there are aligned to
    Box(
        modifier = Modifier.size(500.dp)
    ){
     Box(modifier = Modifier
         .background(Color.Red)
         .size(40.dp)
         .align(Alignment.BottomEnd)
     )
        Box(modifier = Modifier
            .background(Color.Green)
            .size(40.dp)
            .zIndex(2.0f)
            .align(Alignment.Center)
        )
        Box(modifier = Modifier
            .background(Color.Magenta)
            .size(40.dp))
    }
}
@Composable
fun imageViewer(){
    //We will be looking at how we can add images to composables
    //using the image composable
    //Painter resource is like setting app:srcCompat to ImageView in xml
    //We can customize the image in many ways
    //Like bluring it, color filter ,color matrix etc
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "TestImage",
        modifier = Modifier
            .fillMaxSize()
            .clip(CircleShape)
            .blur(3.dp)
            .background(Color.Magenta)
        ,

    )
}
@Composable
fun iconViewer(){
   //We also have the icon which is a way of displaying icons it uses the theme color and gives u access to Material Icons
    Icon(
        imageVector = Icons.Default.Edit,
        contentDescription = null
    )
}

@Composable
fun usingKotlinSyntaxInComposable(value:String ="Default",num :Int =1){
  //We can use the kotlin syntax in composables
    //To make very intresting layouts
    //Here we use the for each to create multiple elements based on the num parameter and define thier text color and font size

    Column(){
        for(i in 1 ..num){
            Text(value,fontSize =(value.length*2).sp,
                color = when{
                    i%2 ==0->Color.Blue
                    else -> {Color.Magenta}
                })
        }
    }

}
@Composable
fun ChristmasGreeting(name:String,modifier: Modifier = Modifier,color:Color = Color.Magenta){
 Text(
     text = "Merry Christmas , $name",
     modifier =
     Modifier
         .background(Color.Gray, RoundedCornerShape(4.dp))
         .padding(4.dp)
         .background(Color.Red)
         .border(2.dp, Color.Cyan)
         .padding(2.dp)
         .border(2.dp, Color.Blue)
         .size(400.dp),
     color = color,
     fontSize = 30.sp,
     letterSpacing = 4.sp,
     textAlign = TextAlign.Justify,

 )

}
//Modifiers are like constraints or settings that determine how a view will be both in it layout and appearance
//Though like View , Composables can have a common set of designs that can be applied Like background colors , padding
//While more specific settings can be applied to the individual composables
//Modifiers are executed sequentially so the way we define them is the way they are applied to the composable
//There are some modifiers that can only be in used in certain composables those are called scoped modifiers

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeTutorialTheme {
        usingKotlinSyntaxInComposable(num =6)
    }
    //Composables are drawn on top of each other so for us to arrange them in an orderly manner we will need layouts
    //We have the column composable which layouts elements vertically
    //We also have the row composable which layouts elements horizontally
    //And the box which layouts them in a z order
}