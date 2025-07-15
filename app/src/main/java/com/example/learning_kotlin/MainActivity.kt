package com.example.learning_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.learning_kotlin.ui.theme.LearningKotlinTheme
import com.example.learning_kotlin.ui.theme.components.ProfileInfo

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearningKotlinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        val cardModel = CardModel(1,"Class 1","This is class 1",true)
                        val cardModelArray = listOf(
                            CardModel(1, "Class 1", "This is class 1", false),
                            CardModel(2, "Class 2", "This is class 2", true),
                            CardModel(3, "Class 3", "This is class 3", false),
                            CardModel(4, "Class 4", "This is class 4", true)
                        )
                        Greeting(
                            name = "I am Ayyan"
                            , modifier = Modifier.padding(bottom = 10.dp).fillMaxWidth()
                        )
//                        Card(
//                            cardModel
//                        )
                        Column(verticalArrangement = Arrangement.spacedBy(16.dp)){
                            cardModelArray.forEach{ card ->
                                Card(
                                    card
                                )
                            }
                            ProfileInfo(image = R.drawable.walter3, username = "Walter White", description = "Meth Kingpin")
                            ProfileInfo(image = R.drawable.walter3, username = "Michael Scofield", description = "Genius Man")

                        }

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
        color = MaterialTheme.colorScheme.primary,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.bodyLarge
    )
}

@Composable
fun Card(cardModel: CardModel){
        Row(modifier = Modifier.padding(horizontal = 12.dp).border(border = BorderStroke(width = 1.dp, color = Color.DarkGray)).fillMaxWidth().padding(all = 8.dp), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Text(text = cardModel.id.toString()+".", color = Color.DarkGray)
            Column{
                Text(text = cardModel.title, fontWeight = FontWeight.Bold, fontSize = 5.em)
                if(cardModel.showDescription){
                    Text(text = cardModel.description, color = Color.Gray, fontSize = 3.1.em)
                }
                else{
                    Text(text = "No description", color = Color.Gray, fontSize = 3.1.em)
                }
            }

        }

}

data class CardModel(val id:Int, val title:String, val description: String, val showDescription: Boolean)
