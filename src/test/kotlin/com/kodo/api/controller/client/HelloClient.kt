package com.kodo.api.controller.client

import io.micronaut.core.async.annotation.SingleResult
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import org.reactivestreams.Publisher

@Client("/hello")
interface HelloClient {

    @Get(consumes = [MediaType.TEXT_PLAIN])
    @SingleResult
    fun hello(): String
}