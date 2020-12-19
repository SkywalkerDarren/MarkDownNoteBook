package io.github.skywalkerdarren.markdownnotebook.ui.trash

import io.github.skywalkerdarren.markdownnotebook.model.Event
import io.github.skywalkerdarren.markdownnotebook.ui.base.IViewState

data class TrashViewState(
        val text: Event<String>? = null
) : IViewState