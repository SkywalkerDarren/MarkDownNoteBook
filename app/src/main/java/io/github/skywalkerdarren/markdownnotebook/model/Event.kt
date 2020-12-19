package io.github.skywalkerdarren.markdownnotebook.model

class Event<T>(private val content: T) {
    private var handled = false

    fun peekContent(): T {
        return content
    }

    fun getContentIfNotHandled(): T? {
        return (if (!handled) content else null).also {
            handled = true
        }
    }

    fun handleIfNotHandled(block: (content: T) -> Unit) {
        if (!handled) {
            block(content)
            handled = true
        }
    }
}