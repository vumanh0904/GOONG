package com.example.space_smile.service

import com.example.space_smile.model.Gps
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object apiService {

    val baseUrl = "https://64547565f803f34576294040.mockapi.io"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            // we need to add converter factory to
            // convert JSON object to Java object
            .build()
    }
}

interface GPSAPI {
    @GET("/gps")
    suspend fun getGPS(): Response<ArrayList<Gps>>
}
