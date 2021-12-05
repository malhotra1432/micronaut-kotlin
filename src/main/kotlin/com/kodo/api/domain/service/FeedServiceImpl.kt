package com.kodo.api.domain.service

import com.kodo.api.domain.Feed
import com.kodo.api.domain.command.CreateFeed
import com.kodo.api.domain.ports.FeedRepository
import com.kodo.api.domain.ports.FeedService
import jakarta.inject.Singleton

@Singleton
class FeedServiceImpl(private val feedRepository: FeedRepository) : FeedService {

    override fun storeFeed(createFeedList: List<CreateFeed>) {
        val feedList: MutableList<Feed> = mutableListOf()
        for (createFeed in createFeedList) {
            feedList.add(Feed.create(createFeed))
        }
        try {
            feedRepository.saveAll(feedList)
        } catch (e: Exception) {
            throw RuntimeException("Unable to store data $e")
        }
    }
}
