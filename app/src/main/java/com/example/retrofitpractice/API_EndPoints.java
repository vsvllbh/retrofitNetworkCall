package com.example.retrofitpractice;

import com.example.retrofitpractice.POJO.mtest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

interface API_EndPoints {

    @POST("/api/users")
    Call<mtest> createUser(@Body mtest mtest);
}
