package com.kodo.api.adapters.repository

import com.kodo.api.adapters.codec.FeedStateAdapter
import com.kodo.api.adapters.entity.FeedEntity
import com.kodo.api.adapters.repository.jpa.FeedJPARepository
import com.kodo.api.domain.Feed
import com.kodo.api.domain.ports.FeedRepository
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class FeedRepositoryImpl: FeedRepository {

    @Inject
    lateinit var feedJPARepository: FeedJPARepository<FeedEntity>

    override fun saveAll(feedList: List<Feed>) {
        val feedEntityList: MutableList<FeedEntity> = mutableListOf()
        for (feed in feedList) {
            feedEntityList.add(FeedStateAdapter.encode(feed.state))
        }
        feedJPARepository.saveAll(feedEntityList)
    }

}
