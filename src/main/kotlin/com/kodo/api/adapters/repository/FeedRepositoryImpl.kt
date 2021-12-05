package com.kodo.api.adapters.repository

import com.kodo.api.adapters.codec.FeedStateAdapter
import com.kodo.api.adapters.entity.FeedEntity
import com.kodo.api.adapters.repository.jpa.FeedJPARepository
import com.kodo.api.domain.Feed
import com.kodo.api.domain.ports.FeedRepository
import jakarta.inject.Singleton

@Singleton
class FeedRepositoryImpl(private val feedJPARepository: FeedJPARepository<FeedEntity>) : FeedRepository {

    override fun saveAll(feedList: List<Feed>) {
        val feedEntityList: MutableList<FeedEntity> = mutableListOf()
        for (feed in feedList) {
            feedEntityList.add(FeedStateAdapter.encode(feed.state))
        }
        try {
            feedJPARepository.saveAll(feedEntityList)
        } catch (e: Exception) {
            throw RuntimeException("Unable to store data $e")
        }
    }
}
