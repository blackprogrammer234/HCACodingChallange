package com.example.hcacodingchallenge.api
import com.example.hcacodingchallenge.models.Item
import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {
    @GET("/2.3/questions?order=desc&sort=activity&site=stackoverflow")
    fun getData(): Call<List<Item>>
}