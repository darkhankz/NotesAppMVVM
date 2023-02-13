package com.example.notesappmvvm.screens

import android.app.Application
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.notesappmvvm.model.Note
import com.example.notesappmvvm.navigation.NavRoute
import com.example.notesappmvvm.ui.MainViewModel
import com.example.notesappmvvm.ui.MainViewModelFactory
import com.example.notesappmvvm.ui.theme.NotesAppMVVMTheme
import com.example.notesappmvvm.utils.Constants.Keys.ADD_ICON
import com.example.notesappmvvm.utils.Constants.Keys.EMPTY_STRING
import com.example.notesappmvvm.utils.DB_TYPE
import com.example.notesappmvvm.utils.TYPE_FIREBASE
import com.example.notesappmvvm.utils.TYPE_ROOM

@Composable
fun MainScreen(navController: NavHostController, viewModel: MainViewModel) {
    val notes = viewModel.readAllNotes().observeAsState(listOf()).value
    val context = LocalContext.current
    val mViewModel: MainViewModel =
        viewModel(factory = MainViewModelFactory(context.applicationContext as Application))

    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = {
            navController.navigate(NavRoute.Add.rout)
        }) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = ADD_ICON, tint = Color.White)

        }
    }) {
        LazyColumn {
            items(notes) { note ->
                NoteItem(note = note, it = it, navController = navController)
            }
        }
    }
}

@Composable
private fun NoteItem(
    note: Note,
    it: PaddingValues,
    navController: NavHostController
) {
    val noteId = when(DB_TYPE){
        TYPE_FIREBASE -> note.firebaseId
        TYPE_ROOM -> note.id
        else -> EMPTY_STRING
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(it)
            .clickable {
                navController.navigate(NavRoute.Note.rout + "/${noteId}")
                println("Navigating to note with ID: ${note.id}")

            },
        elevation = 6.dp
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = note.title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = note.subtitle)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PrevMainScreen() {
    NotesAppMVVMTheme {
        val context = LocalContext.current
        val mViewModel: MainViewModel =
            viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
        MainScreen(navController = rememberNavController(), viewModel = mViewModel)
    }
}