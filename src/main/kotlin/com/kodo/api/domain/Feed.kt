package com.kodo.api.domain

import com.kodo.api.domain.command.CreateFeed

class Feed(val state: FeedState) {

    companion object {
        fun create(createFeed: CreateFeed): Feed {
            return create(createFeed.toFeedState())
        }

        fun create(feedState: FeedState): Feed {
            return Feed(feedState)
        }
    }

}
