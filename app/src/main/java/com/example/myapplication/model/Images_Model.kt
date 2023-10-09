package com.example.myapplication.model

/**
 * @Author Gaurav Naresh Pandit
 * @Since 05/10/23
 **/

data class ImagesModel (
    val results: List<Result>
)

data class Result (
    val image: String,
    val download: String? = null,
    val diffrentSizes: List<String>,
    val by: String,
    val source: String,
    val id: String
)
