package com.kodo.api.controller

import com.kodo.api.controller.client.HelloClient
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

@MicronautTest
class HelloControllerTest{

    @Inject
    lateinit var client: HelloClient

    @Test
    fun testHelloWorldResponse() {
        assertEquals("Hello World",client.hello())
    }

}