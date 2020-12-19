package io.github.skywalkerdarren.markdownnotebook.ui.notes

import io.github.skywalkerdarren.markdownnotebook.model.Event
import io.github.skywalkerdarren.markdownnotebook.ui.base.IViewState

data class NotesViewState(
        val text: Event<String>? = null
) : IViewState