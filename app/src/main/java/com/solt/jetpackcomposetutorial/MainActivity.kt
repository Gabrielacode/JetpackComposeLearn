package com.solt.jetpackcomposetutorial

import android.os.Bundle
import android.util.Log
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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
                val text = rememberSaveable {
                    mutableStateOf("")
                }
                var listOfNames by rememberSaveable {
                    //WHen dealing with mutable state if u are working with list
                    //Dont use mutable list as any change to the list doesnt change the value of the state
                    //instead using lists as they are submitting new lists to update state
                    mutableStateOf(listOf(""))
                }
                //KNow lets follow Phillip Lackner Course
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Row(modifier = Modifier.fillMaxWidth()){
                        //A text field is like an edit text in xml but it need state so we will create a state object to represent the text written
                        //The on value change will be used to update the text of the textfield and so recomposition must take place
                        //And then the textfield displays the new text in the textfield
                        OutlinedTextField(value = text.value, onValueChange ={value -> text.value = value} )
                        Button(onClick = {
                            //We will add the names list to our names if the name is not empty
                            if(text.value.isNotEmpty()) listOfNames = listOfNames+text.value
                        }) {

                            Icon(imageVector =Icons.Default.Add , contentDescription ="Add" )

                        }
                    }
                    //The second value will be a Lazy column and the lazy column needs a list
                    LazyColumn {
                      items(listOfNames){
                          Text(text = it, modifier = Modifier.padding(8.dp))
                      }
                    }
                }
            }
        }
    }
}
