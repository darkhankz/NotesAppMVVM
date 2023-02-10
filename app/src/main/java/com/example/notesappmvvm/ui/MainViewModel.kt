package com.example.notesappmvvm.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.notesappmvvm.database.AppRoomDatabase
import com.example.notesappmvvm.database.room.repository.RoomRepository
import com.example.notesappmvvm.model.Note
import com.example.notesappmvvm.utils.REPOSITORY
import com.example.notesappmvvm.utils.TYPE_ROOM
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val context = application
    fun initDatabase(type: String, onSuccess: () -> Unit){
        when(type){
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(context = context).getRoomDao()
                REPOSITORY = RoomRepository(dao)
                onSuccess()
            }

        }
        Log.d("checkData", "MainViewModel initDatabase with type: $type")
    }

    fun addNote(note: Note, onSuccess: () -> Unit){
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.create(note = note){
                viewModelScope.launch(Dispatchers.Main){
                    onSuccess()
                }
            }

        }
    }

    fun readAllNotes() = REPOSITORY.readAll

}

class MainViewModelFactory(
    private val application: Application
    ): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
         return MainViewModel(application = application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}