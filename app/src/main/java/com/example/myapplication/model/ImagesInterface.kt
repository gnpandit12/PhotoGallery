package com.example.myapplication.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

/**
 * Copyright (c) 2021 Pegadroid IQ Solutions Pvt. Ltd.
 * @Author Gaurav Naresh Pandit
 * @Since 03/10/23
 **/
interface ImagesInterface {


    @Headers("X-RapidAPI-Key: 0s0qjlQFDUmshegmnfr8NfCpko85p1ksKEnjsnKSnWqkk1DQqV",
        "X-RapidAPI-Host: free-images-api.p.rapidapi.com")
    @GET("/images/wallpaper")
    fun getAllImages(): Call<ImagesModel>

}