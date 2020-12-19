package io.github.skywalkerdarren.markdownnotebook.model

import java.util.*

data class NoteBook(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val date: Long = Date().time,
    val color: Int,
    val type: Type = Type.COMMON
) {
    enum class Type {
        COMMON,
        TODO_LIST
    }
}