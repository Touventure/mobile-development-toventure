package com.capston.touventure.data.retrofit

import com.capston.touventure.data.response.CategoryResponseItem
import okhttp3.RequestBody
import retrofit2.http.*

interface ApiService2 {
    @POST("category_predict")
    suspend fun postPredict(
        @Body requestBody: RequestBody
    ): List<CategoryResponseItem>
}