package com.ranggacikal.noteappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ranggacikal.noteappcompose.screen.NoteScreen
import com.ranggacikal.noteappcompose.screen.NoteViewModel
import com.ranggacikal.noteappcompose.ui.theme.NoteAppComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteAppComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val noteViewModel = viewModel<NoteViewModel>()
                    NotesApp(noteViewModel)
                }
            }
        }
    }

    @Composable
    fun NotesApp(noteViewModel: NoteViewModel) {
        val noteList = noteViewModel.noteList.collectAsState().value

        NoteScreen(
            notes = noteList,
            onAddNote = { noteViewModel.addNote(it) },
            onRemoveNote = { noteViewModel.removeNote(it) })
    }
}