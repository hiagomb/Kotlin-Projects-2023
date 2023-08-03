package com.example.section20_mvvmcleanarchiteture.data.api

import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class NewsApiServiceTest {
    private lateinit var service: NewsApiService
    private lateinit var mockWebServer: MockWebServer

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        service = Retrofit.Builder().baseUrl(mockWebServer.url(""))
            .addConverterFactory(GsonConverterFactory.create()).build().create(NewsApiService::class.java)

    }

    @Test
    fun getTopHeadLines_sentRequest_receiveExpected(){
        runBlocking {
            enqueueMOckResponses("news_response.json")
            val responseBody = service.getTopHeadLines("", "us", 1).body()
            val request = mockWebServer.takeRequest()
            Assert.assertNotNull(responseBody)
        }
    }

    @Test
    fun getTopHeadLines_receivedResponse_correctPageSize(){
        runBlocking {
            enqueueMOckResponses("news_response.json")
            val responseBody = service.getTopHeadLines("", "us", 1).body()
            val request = mockWebServer.takeRequest()
            Assert.assertEquals(38, responseBody?.totalResults, )
        }
    }

    private fun enqueueMOckResponses(fileName: String){
        val inputStream = javaClass.classLoader.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        mockWebServer.enqueue(mockResponse)
    }

    @After
    fun tearDown() {
       mockWebServer.shutdown()
    }
}