package io.github.skywalkerdarren.markdownnotebook.repository.local

import androidx.room.TypeConverter
import io.github.skywalkerdarren.markdownnotebook.model.Note

class Convectors {
    @TypeConverter
    fun noteType2Int(type: Note.Type): Int {
        return type.value
    }

    @TypeConverter
    fun int2NoteType(type: Int): Note.Type {
        return Note.Type.parserValue(type)
    }
}