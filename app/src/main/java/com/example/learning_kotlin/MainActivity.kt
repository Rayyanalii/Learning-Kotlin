package com.example.learning_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learning_kotlin.ui.theme.LearningKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearningKotlinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        Greeting(
                            name = "I am Ayyan"
                            , modifier = Modifier.padding(bottom = 10.dp)
                        )
                        Card(
                            title="Class 1",
                            description = "This is class 1"
                        )
                        Card(
                            title="Class 2",
                            description = "This is class 2"
                        )
                        Card(
                            title="Class 3",
                            description = "This is class 3"
                        )
                    }

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
        color = Color.Blue
    )
}

@Composable
fun Card(title:String,description:String){
    Column(modifier= Modifier.padding(vertical = 8.dp, horizontal = 4.dp).border(border = BorderStroke(1.dp, color = Color.Black)).padding(all = 8.dp)) {
        Text(text = title, fontWeight = FontWeight.Bold)
        Text(text = description, color = Color.Gray)
    }

}
