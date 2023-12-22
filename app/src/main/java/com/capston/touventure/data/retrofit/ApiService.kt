package com.capston.touventure.data.retrofit

import com.capston.touventure.data.response.TourismResponse
import retrofit2.http.*

interface ApiService {

    @GET("tourism")
    suspend fun getTourism(
    ): TourismResponse

}