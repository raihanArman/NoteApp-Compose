package com.raihanarman.noteapp.di

import android.app.Application
import androidx.room.Room
import com.raihanarman.noteapp.future_note.data.data_source.NoteDatabase
import com.raihanarman.noteapp.future_note.data.repository.NoteRepositoryImpl
import com.raihanarman.noteapp.future_note.domain.repository.NoteRepository
import com.raihanarman.noteapp.future_note.domain.use_case.DeleteNote
import com.raihanarman.noteapp.future_note.domain.use_case.GetNotes
import com.raihanarman.noteapp.future_note.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase{
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.NOTE_DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository{
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases{
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository)
        )
    }

}