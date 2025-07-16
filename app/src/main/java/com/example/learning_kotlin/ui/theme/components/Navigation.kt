package com.example.learning_kotlin.ui.theme.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BottomNavBar(
    items: List<BottomNavItem>,
    currentRoute: String,
    onItemSelected: (String) -> Unit
) {
    NavigationBar(
        containerColor = Color.White,
        contentColor = Color.Black,
        modifier = Modifier.border(border = BorderStroke(width = 1.dp, color = Color.Gray))
    ) {
        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = { onItemSelected(item.route) },
                label = { Text(item.label) },
                alwaysShowLabel = true,
                icon = {
                }
            )
        }
    }
}


data class BottomNavItem(
    val label: String,
    val route: String,
)
