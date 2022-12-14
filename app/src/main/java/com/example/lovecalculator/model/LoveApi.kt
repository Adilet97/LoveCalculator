package com.example.lovecalculator.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

// 	.addHeader("X-RapidAPI-Key", "566b84e26bmsh397b7858f0b7187p164fb8jsn5645552edd77")
//	.addHeader("X-RapidAPI-Host", "love-calculator.p.rapidapi.com")

interface LoveApi {

    @GET("getPercentage")
    fun getPercentage(
        @Query("fname")
        firstName: String,
        @Query("sname")
        secondName: String,
        @Header("X-RapidAPI-Key") key: String = "5117cefdb8msh6239bbc071e85f2p1135a7jsn0eadd39e2649",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com",
    ): Call<LoveModel>

}