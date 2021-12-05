package com.kodo.api.domain.command

import com.kodo.api.domain.FeedState
import com.kodo.api.domain.value.Description
import com.kodo.api.domain.value.Image
import com.kodo.api.domain.value.Name
import java.time.Instant

class CreateFeed(
    private val name: Name,
    private val description: Description,
    private val image: Image,
    private val dateLastEdited: Instant
) {
    data class CreateFeedBuilder(
        var name: Name,
        var description: Description,
        var image: Image,
        var dateLastEdited: Instant
    ) {
        fun setName(name: String) = apply { this.name = Name.create(name) }
        fun setDescription(description: String) = apply { this.description = Description.create(description) }
        fun setImage(image: String) = apply { this.image = Image.create(image) }
        fun setDateLastEdited(dateLastEdited: Instant) = apply { this.dateLastEdited = dateLastEdited }
        fun build() =
            CreateFeed(name, description, image, dateLastEdited)
    }

    fun toFeedState(): FeedState {
        return FeedState.FeedStateBuilder(name, description, image, dateLastEdited)
            .setName(name)
            .setDescription(description)
            .setImage(image)
            .setDateLastEdited(dateLastEdited)
            .build()
    }
}
