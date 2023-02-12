package com.study.ainterview3.data.remote

import com.study.ainterview3.data.remote.response.ResponseDto
import retrofit2.http.GET

interface FoxApi {

    @GET("/floof/")
    suspend fun getFox() : ResponseDto

}