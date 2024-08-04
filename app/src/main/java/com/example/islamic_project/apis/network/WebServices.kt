package com.example.islamic_project.apis.network

import com.example.islamic_project.apis.models.RadioResponse
import retrofit2.Call
import retrofit2.http.GET

interface WebServices {
    @GET("radios")
    fun getRadioChannels(): Call<RadioResponse>
}