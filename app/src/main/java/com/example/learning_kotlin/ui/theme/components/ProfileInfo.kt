package com.example.learning_kotlin.ui.theme.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.learning_kotlin.R

@Composable
fun ProfileInfo(image:Int,username:String,description:String){
    Row(modifier = Modifier.padding(horizontal = 8.dp).border(border = BorderStroke(width = 1.dp, color = Color.Black)).fillMaxWidth().padding(all = 12.dp), horizontalArrangement = Arrangement.spacedBy(12.dp), verticalAlignment = Alignment.CenterVertically) {
//        Box(
//            modifier = Modifier
//                .size(30.dp)
//                .border(border = BorderStroke(width = 1.dp, color = Color.Black), shape = CircleShape)
//        )
        Image(
            painter = painterResource(id = image),
            contentDescription = "Profile Picture",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .border(1.dp, Color.DarkGray, CircleShape)
        )
        Column {
            Text(text = username, fontWeight = FontWeight.Bold, fontSize = 5.em)
            Text(text = description, color = Color.Gray)
        }

    }
}