package com.kodo.api.application.controller
import com.kodo.api.application.model.message.CreateFeedMessage
import com.kodo.api.domain.command.CreateFeed
import com.kodo.api.domain.ports.FeedService
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import jakarta.inject.Inject

@Controller("/api/v1")
class FeedController {

    @Inject
    lateinit var feedService: FeedService

    @Post("/store/feed")
    fun storeFeed(@Body createFeedMessageList: List<CreateFeedMessage>){
        val createFeedList: MutableList<CreateFeed> = mutableListOf()
        for (createFeedMessage in createFeedMessageList){
            createFeedList.add(createFeedMessage.toCreateFeed(createFeedMessage))
        }
        return feedService.storeFeed(createFeedList)
    }

}
