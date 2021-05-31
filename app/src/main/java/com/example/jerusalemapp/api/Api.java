package com.example.jerusalemapp.api;

import android.content.Context;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    private static Api INSTANCE;
    private static ApiInterface apiInterface;
    private static final String BASE_URL = "https://newsapi.org/";
    public Api(Context context) {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    apiInterface = retrofit.create(ApiInterface.class);
}

    public static ApiInterface getApiInterface() {
        return apiInterface;
    }

    public static Api getINSTANCE(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new Api(context);
        }
        return INSTANCE;
    }

}
