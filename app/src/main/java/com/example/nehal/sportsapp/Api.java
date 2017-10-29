package com.example.nehal.sportsapp;
import com.example.nehal.sportsapp.Models.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface Api {

    @GET("search")
    Call<Example> getList(@Query("query") String query);
}
