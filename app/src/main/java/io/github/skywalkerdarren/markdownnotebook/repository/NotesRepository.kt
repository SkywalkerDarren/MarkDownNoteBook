package io.github.skywalkerdarren.markdownnotebook.repository

import io.github.skywalkerdarren.markdownnotebook.model.Note
import io.github.skywalkerdarren.markdownnotebook.repository.local.AppDatabase
import io.github.skywalkerdarren.markdownnotebook.repository.local.NoteBookDao
import io.github.skywalkerdarren.markdownnotebook.repository.local.NoteDao
import kotlinx.coroutines.flow.Flow

class NotesRepository private constructor(
    private val noteDao: NoteDao,
    private val noteBookDao: NoteBookDao,
) {
    companion object {
        val instance by lazy {
            val noteDao = AppDatabase.db.noteDao()
            val noteBookDao = AppDatabase.db.noteBookDao()
            NotesRepository(noteDao, noteBookDao)
        }
    }

    fun getNote(id: String): Flow<Note> {
        return noteDao.getNoteFlow(id)
    }

    suspend fun getNoteOneShot(id: String): Note? {
        return noteDao.getNote(id)
    }
}