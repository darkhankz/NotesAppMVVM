package com.example.notesappmvvm.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notesappmvvm.screens.AddScreen
import com.example.notesappmvvm.screens.MainScreen
import com.example.notesappmvvm.screens.NoteScreen
import com.example.notesappmvvm.screens.StartScreen

sealed class NavRoute(val rout : String){
    object Start: NavRoute("start_screen")
    object Main: NavRoute("main_screen")
    object Add: NavRoute("add_screen")
    object Note: NavRoute("note_screen")

}

@Composable
fun NotesNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController , startDestination = NavRoute.Start.rout) {
        composable(NavRoute.Start.rout){ StartScreen(navController = navController) }
        composable(NavRoute.Main.rout){ MainScreen(navController = navController) }
        composable(NavRoute.Add.rout){ AddScreen(navController = navController) }
        composable(NavRoute.Note.rout){ NoteScreen(navController = navController) }
    }
}