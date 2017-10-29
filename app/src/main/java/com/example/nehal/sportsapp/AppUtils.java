package com.example.nehal.sportsapp;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nehal on 18/10/17.
 */

public class AppUtils {

    public static Api getRetrofitApi(Context context) {
        return getRetrofitApi(getBaseURL(), context);
    }

    public static Api getRetrofitApi(String url, final Context context) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .build();

        Api api = retrofit.create(Api.class);
        return api;
    }

    public static String getBaseURL() {
        return BuildConfig.SERVER_URL;
    }
}
