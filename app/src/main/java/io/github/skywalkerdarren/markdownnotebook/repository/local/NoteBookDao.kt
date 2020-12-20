package io.github.skywalkerdarren.markdownnotebook.repository.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import io.github.skywalkerdarren.markdownnotebook.model.NoteBook
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged

@Dao
abstract class NoteBookDao {
    @Insert
    abstract suspend fun addNoteBook(vararg book: NoteBook)

    @Query("DELETE FROM notebook WHERE id = :id")
    abstract suspend fun deleteNoteBook(vararg id: String): Int

    @Update(entity = NoteBook::class, onConflict = REPLACE)
    abstract suspend fun updateNoteBook(vararg book: NoteBook): Int


    @Query("SELECT * FROM notebook WHERE id = :id")
    abstract suspend fun getNoteBook(id: String): NoteBook?

    @Query("SELECT * FROM notebook WHERE id = :id")
    abstract fun getNoteBookLive(id: String): LiveData<NoteBook>

    @Query("SELECT * FROM notebook WHERE id = :id")
    abstract fun _getNoteBookFlow(id: String): Flow<NoteBook>
    fun getNoteBookFlow(id: String) = _getNoteBookFlow(id).distinctUntilChanged()


    @Query("SELECT * FROM notebook")
    abstract suspend fun getNoteBooks(): List<NoteBook>

    @Query("SELECT * FROM notebook")
    abstract fun getNoteBooksLive(): LiveData<List<NoteBook>>

    @Query("SELECT * FROM notebook")
    abstract fun _getNoteBooksFlow(): Flow<List<NoteBook>>
    fun getNoteBooksFlow() = _getNoteBooksFlow().distinctUntilChanged()

}