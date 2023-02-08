package com.example.notesappmvvm.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notesappmvvm.screens.Add
import com.example.notesappmvvm.screens.Main
import com.example.notesappmvvm.screens.Note
import com.example.notesappmvvm.screens.Start

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
        composable(NavRoute.Start.rout){ Start(navController = navController) }
        composable(NavRoute.Main.rout){ Main(navController = navController) }
        composable(NavRoute.Add.rout){ Add(navController = navController) }
        composable(NavRoute.Note.rout){ Note(navController = navController) }
    }
}