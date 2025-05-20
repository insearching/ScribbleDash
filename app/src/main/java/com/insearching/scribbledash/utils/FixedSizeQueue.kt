package com.insearching.scribbledash.utils

class FixedSizeQueue<T>(private val maxSize: Int) {
    private val queue = ArrayDeque<T>()

    fun add(element: T) {
        if (queue.size == maxSize) {
            queue.removeFirst()
        }
        queue.addLast(element)
    }

    fun pop(): T? {
        return queue.removeLastOrNull()
    }

    fun toList(): List<T> = queue.toList()
    fun size(): Int = queue.size
    fun isEmpty(): Boolean = queue.isEmpty()
    fun clear() = queue.clear()
}