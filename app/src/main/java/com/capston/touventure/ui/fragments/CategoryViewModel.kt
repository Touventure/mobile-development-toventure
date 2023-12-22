package com.capston.touventure.ui.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.capston.touventure.data.model.ResultState
import com.capston.touventure.data.response.CategoryResponse
import com.capston.touventure.data.retrofit.ApiConfig2
import com.google.gson.Gson
import okhttp3.RequestBody
import retrofit2.HttpException

class CategoryViewModel: ViewModel() {
    fun postPredict(requestBody: RequestBody) = liveData {
        emit(ResultState.Loading)
        try {
            val successResponse = ApiConfig2.getApiService().postPredict(requestBody)
            emit(ResultState.Success(successResponse))
        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            val errorResponse = Gson().fromJson(errorBody, CategoryResponse::class.java)
            emit(errorResponse.let { ResultState.Error(it.toString()) })
        }
    }
}