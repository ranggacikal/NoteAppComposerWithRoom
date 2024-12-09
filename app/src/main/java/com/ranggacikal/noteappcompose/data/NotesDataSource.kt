package com.ranggacikal.noteappcompose.data

import com.ranggacikal.noteappcompose.model.Note

class NotesDataSource {
    fun loadNotes(): List<Note> {
        return listOf(
            Note(title = "Title Notes 1", description = "Ini adalah contoh untuk Description Notes Nomor 1"),
            Note(title = "Title Notes 2", description = "Ini adalah contoh untuk Description Notes Nomor 2"),
            Note(title = "Title Notes 3", description = "Ini adalah contoh untuk Description Notes Nomor 3"),
            Note(title = "Title Notes 4", description = "Ini adalah contoh untuk Description Notes Nomor 4"),
            Note(title = "Title Notes 5", description = "Ini adalah contoh untuk Description Notes Nomor 5"),
            Note(title = "Title Notes 6", description = "Ini adalah contoh untuk Description Notes Nomor 6"),
            Note(title = "Title Notes 7", description = "Ini adalah contoh untuk Description Notes Nomor 7"),
            Note(title = "Title Notes 8", description = "Ini adalah contoh untuk Description Notes Nomor 8"),
            Note(title = "Title Notes 9", description = "Ini adalah contoh untuk Description Notes Nomor 9"),
            Note(title = "Title Notes 10", description = "Ini adalah contoh untuk Description Notes Nomor 10"),
        )
    }
}