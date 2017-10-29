package com.example.nehal.sportsapp;
import com.example.nehal.sportsapp.Models.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by nehal on 18/10/17.
 */

public interface Api {

    @GET("search")
    Call<Example> getList(@Query("query") String query);
}
