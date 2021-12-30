package com.raihanarman.noteapp.future_note.presentation.notes

import com.raihanarman.noteapp.future_note.domain.model.Note
import com.raihanarman.noteapp.future_note.domain.util.NoteOrder

sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()
}