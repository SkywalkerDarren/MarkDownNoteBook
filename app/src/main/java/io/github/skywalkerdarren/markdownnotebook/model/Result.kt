package io.github.skywalkerdarren.markdownnotebook.model

sealed class Result {
    class Success<T>(content: T)
    class Failure(exception: Exception)
}