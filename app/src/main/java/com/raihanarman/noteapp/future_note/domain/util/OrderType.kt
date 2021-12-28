package com.raihanarman.noteapp.future_note.domain.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}