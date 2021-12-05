package com.kodo.api.adapters.repository.jpa

import com.kodo.api.adapters.codec.FeedStateAdapter
import com.kodo.api.adapters.entity.FeedEntity
import jakarta.inject.Singleton
import java.io.File

@Singleton
class FeedJPARepositoryImpl: FeedJPARepository<FeedEntity> {
    override fun saveAll(data: List<FeedEntity>) {
        File("demo.json").writeText(FeedStateAdapter.encodeFeedEntityToJSON(data))
    }
}
