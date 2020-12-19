package io.github.skywalkerdarren.markdownnotebook.model

import java.util.*

data class Note(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val date: Long = Date().time,
    val version: Int = 0,
    val md5: String? = null
)