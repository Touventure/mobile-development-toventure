package com.capston.touventure.data.utils

open class Event<out T>(private val content: T) {

    @Suppress("")
    var hasBeenHandled = false
        private set

    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }
}