package com.example.notesappmvvm.utils

import com.example.notesappmvvm.database.DatabaseRepository

const val TYPE_DATABASE = "type_database"
const val TYPE_ROOM = "type_room"
const val TYPE_FIREBASE = "type_firebase"
const val FIREBASE_ID = "firebaseId"
lateinit var REPOSITORY: DatabaseRepository
lateinit var LOGIN: String
lateinit var PASSWORD: String


object Constants{
    object Keys{
        const val NOTE_DATABASE = "notes_database"
        const val NOTE_TABLE = "notes_table"
        const val ADD_NEW_NOTE = "Add new note"
        const val NOTE_TITLE = "Not title"
        const val NOTE_SUBTITLE = "Not subtitle"
        const val ADD_NOTE = "Add note"
        const val EMPTY_STRING = ""
        const val ADD_ICON = "Add Icons"
        const val TITLE = "title"
        const val SUBTITLE = "subtitle"
        const val ROOM_DATABASE = "Room database"
        const val FIREBASE_DATABASE = "Firebase database"
        const val WHAT_WILL_WE_USE = "What will we use"
        const val UNKNOWN_VIEW_MODEL_CLASS = "Unknown ViewModel Class"
        const val ID = "Id"
        const val NONE = "None"
        const val UPDATE = "UPDATE"
        const val DELETE = "DELETE"
        const val NAV_BACK = "NAV_BACK"
        const val EDIT_NOTE = "Edit note"
        const val UPDATE_NOTE = "Update note"
        const val SIGN_IN = "Sign in"
        const val LOG_IN = "Log in"
        const val LOGIN_TEXT = "Login"
        var PASSWORD = "Password"


    }
    object Screens{
        const val START_SCREEN = "start_screen"
        const val MAIN_SCREEN = "main_screen"
        const val NOTE_SCREEN = "note_screen"
        const val ADD_SCREEN = "add_screen"
    }
}