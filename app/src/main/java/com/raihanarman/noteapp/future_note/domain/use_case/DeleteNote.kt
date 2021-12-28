package com.raihanarman.noteapp.future_note.domain.use_case

import com.raihanarman.noteapp.future_note.domain.model.Note
import com.raihanarman.noteapp.future_note.domain.repository.NoteRepository

class DeleteNote(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note){
        repository.deleteNote(note)
    }
}