package io.github.skywalkerdarren.markdownnotebook.repository.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import io.github.skywalkerdarren.markdownnotebook.model.Note
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged

@Dao
abstract class NoteDao {
    @Insert
    abstract suspend fun addNote(vararg note: Note)

    @Query("DELETE FROM note WHERE id = :id")
    abstract suspend fun deleteNote(vararg id: String): Int

    @Update(entity = Note::class, onConflict = REPLACE)
    abstract suspend fun updateNote(vararg note: Note): Int


    @Query("SELECT * FROM note WHERE id = :id")
    abstract suspend fun getNote(id: String): Note?

    @Query("SELECT * FROM note WHERE id = :id")
    abstract fun getNoteLive(id: String): LiveData<Note>

    @Query("SELECT * FROM note WHERE id = :id")
    abstract fun _getNoteFlow(id: String): Flow<Note>
    fun getNoteFlow(id: String) = _getNoteFlow(id).distinctUntilChanged()


    @Query("SELECT * FROM note WHERE bookId = :bookId")
    abstract suspend fun getNotesByBook(bookId: String): List<Note>

    @Query("SELECT * FROM note WHERE bookId = :bookId")
    abstract fun getNotesByBookLive(bookId: String): LiveData<List<Note>>

    @Query("SELECT * FROM note WHERE bookId = :bookId")
    abstract fun _getNotesByBookFlow(bookId: String): Flow<List<Note>>
    fun getNotesByBookFlow(bookId: String) = _getNotesByBookFlow(bookId).distinctUntilChanged()
}