package io.github.skywalkerdarren.markdownnotebook.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Note(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val bookId: String,
    val title: String,
    val date: Long = Date().time,
    val version: Int = 0,
    val md5: String? = null,
    val type: Type = Type.COMMON
) {
    enum class Type(val value: Int) {
        COMMON(0),
        TODO_LIST(1);

        companion object {
            fun parserValue(i: Int): Type {
                return when (i) {
                    COMMON.value -> COMMON
                    TODO_LIST.value -> TODO_LIST
                    else -> throw IllegalArgumentException("no this type: $i")
                }
            }
        }
    }
}