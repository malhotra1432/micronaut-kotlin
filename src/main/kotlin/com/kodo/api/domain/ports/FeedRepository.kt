package com.kodo.api.domain.ports

import com.kodo.api.adapters.entity.FeedEntity
import com.kodo.api.domain.Feed

interface FeedRepository {
    fun saveAll(feedList: List<Feed>)
    fun findAll(): List<FeedEntity>
}
