package com.example.notesappmvvm.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notesappmvvm.screens.AddScreen
import com.example.notesappmvvm.screens.MainScreen
import com.example.notesappmvvm.screens.NoteScreen
import com.example.notesappmvvm.screens.StartScreen
import com.example.notesappmvvm.ui.MainViewModel
import com.example.notesappmvvm.utils.Constants.Keys.ID
import com.example.notesappmvvm.utils.Constants.Screens.ADD_SCREEN
import com.example.notesappmvvm.utils.Constants.Screens.MAIN_SCREEN
import com.example.notesappmvvm.utils.Constants.Screens.NOTE_SCREEN
import com.example.notesappmvvm.utils.Constants.Screens.START_SCREEN

sealed class NavRoute(val rout : String){
    object Start: NavRoute(START_SCREEN)
    object Main: NavRoute(MAIN_SCREEN)
    object Add: NavRoute(ADD_SCREEN)
    object Note: NavRoute(NOTE_SCREEN)

}

@Composable
fun NotesNavHost(mViewModel: MainViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController , startDestination = NavRoute.Start.rout) {
        composable(NavRoute.Start.rout){ StartScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.Main.rout){ MainScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.Add.rout){ AddScreen(navController = navController, viewModel = mViewModel) }
        composable(NavRoute.Note.rout + "/{${ID}}") { backStackEntry ->
             NoteScreen(navController = navController, viewModel = mViewModel, nodeId = backStackEntry.arguments?.getString(ID)) }
        }

}