package com.raihanarman.noteapp.future_note.presentation.notes

import com.raihanarman.noteapp.future_note.domain.model.Note
import com.raihanarman.noteapp.future_note.domain.util.NoteOrder
import com.raihanarman.noteapp.future_note.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
