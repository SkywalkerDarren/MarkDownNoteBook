package io.github.skywalkerdarren.markdownnotebook.ui.settings

import io.github.skywalkerdarren.markdownnotebook.model.Event
import io.github.skywalkerdarren.markdownnotebook.ui.base.IViewState

data class SettingsViewState(
        val text: Event<String>? = null
) : IViewState