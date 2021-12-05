package com.kodo.api.application.model.message

import com.kodo.api.domain.command.CreateFeed
import com.kodo.api.domain.value.Description
import com.kodo.api.domain.value.Image
import com.kodo.api.domain.value.Name
import java.time.Instant

data class CreateFeedMessage (
     private val name: String,
     private val description: String,
     private val image: String,
     private val dateLastEdited: Instant
) {
    fun toCreateFeed(createFeedMessage: CreateFeedMessage): CreateFeed {
        return CreateFeed.CreateFeedBuilder(
            Name.create(createFeedMessage.name),
            Description.create(createFeedMessage.description),
            Image.create(createFeedMessage.image),
            createFeedMessage.dateLastEdited
        )
            .setName(createFeedMessage.name)
            .setDescription(createFeedMessage.description)
            .setImage(createFeedMessage.image)
            .setDateLastEdited(dateLastEdited)
            .build()
    }
}
