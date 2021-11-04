package com.example.ristorantehttp.model.repository

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.PUT
import retrofit2.http.DELETE

interface APIService {

    @POST("/api/v1/category/save")
    suspend fun saveCategory(@Body requestBody: RequestBody): Response<ResponseBody>

    @GET("/api/v1/category/all/{search}")
    suspend fun getCategorys(): Response<ResponseBody>

    @GET("/api/v1/category/{id}")
    suspend fun getCategory(@Path("id") categoryId: String): Response<ResponseBody>

    @PUT("/api/category/3")
    suspend fun updateCategory(@Body requestBody: RequestBody): Response<ResponseBody>

   @DELETE("/api/category/3")
    suspend fun deleteCategory(): Response<ResponseBody>

}