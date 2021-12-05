package com.kodo.api.adapters.codec

import com.kodo.api.adapters.entity.FeedEntity
import com.kodo.api.domain.FeedState
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
class FeedStateAdapter {
    companion object {
        fun encodeFeedEntityToJSON(feedEntity: FeedEntity): String {
            return Json.encodeToString(feedEntity)
        }

        fun encodeFeedEntityToJSON(feedEntityList: List<FeedEntity>): String {
            return Json.encodeToString(feedEntityList)
        }

        fun encode(feedState: FeedState): FeedEntity {
            return FeedEntity.FeedEntityBuilder(
                feedState.name.name,
                feedState.description.description,
                feedState.image.image,
                feedState.dateLastEdited,
            ).build()
        }
    }
}
