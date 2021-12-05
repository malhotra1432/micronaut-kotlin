package com.kodo.api.adapters.repository.jpa

import com.kodo.api.adapters.codec.FeedStateAdapter
import com.kodo.api.adapters.entity.FeedEntity
import jakarta.inject.Singleton
import java.io.File

@Singleton
class FeedJPARepositoryImpl : FeedJPARepository<FeedEntity> {
    override fun saveAll(data: List<FeedEntity>) {
        try {
            File("data.json").writeText(FeedStateAdapter.encodeFeedEntityToJSON(data))
        } catch (e: Exception) {
            throw RuntimeException("Unable to store data $e")
        }
    }
}
