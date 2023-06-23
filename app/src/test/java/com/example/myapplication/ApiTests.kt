package com.example.myapplication

import com.example.myapplication.data.SearchUsefulActivityApi
import com.example.myapplication.data.UsefulActivitiesRepository
import com.example.myapplication.data.UsefulActivityDto
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ApiTests {

    @Test
    fun testGetUsefulActivitySuccess() {
        runBlocking {
            val api: SearchUsefulActivityApi = mock()

            val activityDto = UsefulActivityDto(
                accessibility = 0.3,
                activity = "",
                key = "",
                link = "",
                participants = 1,
                price = 0.2,
                type = ""
            )

            Mockito.`when`(api.getUsefulActivity()).thenReturn(activityDto)

            val repository = UsefulActivitiesRepository(api)

            repository.getUsefulActivity()

            verify(api).getUsefulActivity()
        }
    }

    @Test(expected = Exception::class)
    fun testGetUsefulActivityError() {
        runBlocking {
            val api: SearchUsefulActivityApi = mock()

            Mockito.`when`(api.getUsefulActivity()).thenThrow(Exception())

            val repository = UsefulActivitiesRepository(api)

            repository.getUsefulActivity()
        }
    }

}
