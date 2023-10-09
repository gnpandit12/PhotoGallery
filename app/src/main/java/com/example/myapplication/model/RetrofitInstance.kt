package com.example.myapplication.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Copyright (c) 2021 Pegadroid IQ Solutions Pvt. Ltd.
 * @Author Gaurav Naresh Pandit
 * @Since 03/10/23
 **/

object RetrofitInstance {
    val api: ImagesInterface by lazy {
        Retrofit.Builder()
            .baseUrl("https://free-images-api.p.rapidapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ImagesInterface::class.java)
    }
}