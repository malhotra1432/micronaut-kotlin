package com.kodo.api.domain

import com.kodo.api.domain.value.Description
import com.kodo.api.domain.value.Image
import com.kodo.api.domain.value.Name
import java.time.Instant

class FeedState private constructor(
    val name: Name,
    val description: Description,
    val image: Image,
    val dateLastEdited: Instant
) {

    data class FeedStateBuilder(
        var name: Name,
        var description: Description,
        var image: Image,
        var dateLastEdited: Instant
    ) {
        fun setName(name: Name) = apply { this.name = name }
        fun setDescription(description: Description) = apply { this.description = description }
        fun setImage(image: Image) = apply { this.image = image }
        fun setDateLastEdited(dateLastEdited: Instant) = apply { this.dateLastEdited = dateLastEdited }
        fun build() = FeedState(name, description, image, dateLastEdited)
    }
}
