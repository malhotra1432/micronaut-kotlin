package com.kodo.api.domain.ports

import com.kodo.api.adapters.entity.FeedEntity
import com.kodo.api.domain.command.CreateFeed

interface FeedService {
    fun storeFeed(createFeedList: List<CreateFeed>)
    fun fetchFeeds(): List<FeedEntity>
}
