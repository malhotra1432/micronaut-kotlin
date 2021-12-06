package com.kodo.api.adapters.repository.jpa

interface FeedJPARepository<T> {
    fun saveAll(data: List<T>)
    fun findAll(): List<T>
}
