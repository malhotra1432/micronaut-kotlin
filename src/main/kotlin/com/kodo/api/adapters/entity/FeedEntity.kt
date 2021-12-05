package com.kodo.api.adapters.entity

import com.kodo.api.config.GlobalSerializer
import kotlinx.serialization.Serializable
import java.time.Instant

@Serializable
data class FeedEntity(
    private val name: String,
    private val description: String,
    private val image: String,
    @Serializable(with = GlobalSerializer::class) private val dateLastEdited: Instant
) {
    data class FeedEntityBuilder(
        var name: String,
        var description: String,
        var image: String,
        var dateLastEdited: Instant
    ) {
        fun name(name: String) = apply { this.name = name }
        fun description(description: String) = apply { this.description = description }
        fun image(image: String) = apply { this.image = image }
        fun dateLastEdited(dateLastEdited: Instant) = apply { this.dateLastEdited = dateLastEdited }
        fun build() =
            FeedEntity(name, description, image, dateLastEdited)
    }
}
