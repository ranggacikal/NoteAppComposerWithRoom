package com.ranggacikal.noteappcompose.screen

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ranggacikal.noteappcompose.data.NotesDataSource
import com.ranggacikal.noteappcompose.model.Note
import com.ranggacikal.noteappcompose.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel() {

    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNotes().distinctUntilChanged().collect { listOfNotes ->
                if (listOfNotes.isEmpty()) {
                    Log.d("EmptyNotes", ": Empty List")
                } else {
                    _noteList.value = listOfNotes
                }
            }
        }
//        noteList.addAll(NotesDataSource().loadNotes())
    }

    fun addNote(note: Note) = viewModelScope.launch { repository.addNote(note) }
    fun updateNote(note: Note) = viewModelScope.launch { repository.updateNote(note) }
    fun removeNote(note: Note) = viewModelScope.launch { repository.deleteNote(note) }

}