package com.example.notesappmvvm.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.notesappmvvm.navigation.NavRoute
import com.example.notesappmvvm.ui.theme.NotesAppMVVMTheme

@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = {
            navController.navigate(NavRoute.Add.rout)
        }) {
            Icon(imageVector = Icons.Filled.Add , contentDescription = "Add Icons", tint = Color.White)

        }
    } ) {
        Column {
            NoteItem(title = "Note 1", subtitle = "Subtitle for note 1", it, navController)
            NoteItem(title = "Note 2", subtitle = "Subtitle for note 2", it, navController)
            NoteItem(title = "Note 3", subtitle = "Subtitle for note 3", it, navController)
            NoteItem(title = "Note 4", subtitle = "Subtitle for note 4", it, navController)
        }

    }
}

@Composable
private fun NoteItem(title: String,
                     subtitle: String,
                     it: PaddingValues,
                     navController: NavHostController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(it)
            .clickable {
                navController.navigate(NavRoute.Note.rout)
            },
        elevation = 6.dp
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = subtitle)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PrevMainScreen(){
    NotesAppMVVMTheme {
        MainScreen(navController = rememberNavController())
        
    }
}