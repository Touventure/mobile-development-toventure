package com.capston.touventure.ui.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.capston.touventure.data.model.ResultState
import com.capston.touventure.data.response.TourismResponse
import com.capston.touventure.data.retrofit.ApiConfig
import com.google.gson.Gson
import retrofit2.HttpException

class HomeViewModel : ViewModel() {
    fun getTourism() = liveData {
        emit(ResultState.Loading)
        try {
            val successResponse = ApiConfig.getApiService().getTourism()
            emit(ResultState.Success(successResponse))
        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            val errorResponse = Gson().fromJson(errorBody, TourismResponse::class.java)
            emit(errorResponse.status?.let { ResultState.Error(it) })
        }
    }
}