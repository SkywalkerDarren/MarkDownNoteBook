package io.github.skywalkerdarren.markdownnotebook.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class NoteBook(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val name: String,
    val date: Long = Date().time,
    val color: Int,
)