package com.kodo.api.domain.service

import com.kodo.api.domain.Feed
import com.kodo.api.domain.command.CreateFeed
import com.kodo.api.domain.ports.FeedRepository
import com.kodo.api.domain.ports.FeedService
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class FeedServiceImpl : FeedService {
    @Inject
    lateinit var feedRepository: FeedRepository

    override fun storeFeed(createFeedList: List<CreateFeed>) {
        val feedList: MutableList<Feed> = mutableListOf()
        for (createFeed in createFeedList){
            feedList.add(Feed.create(createFeed))
        }
        feedRepository.saveAll(feedList)
    }
}
