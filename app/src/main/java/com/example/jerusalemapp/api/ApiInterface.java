package com.example.jerusalemapp.api;

import com.example.jerusalemapp.model.News;

import java.util.HashMap;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

//    @GET("v2/everything")
//    Call<News> getdata(@Body HashMap<String, String> hashMapsemester_subject);
    @GET("v2/everything?q=%D8%A7%D9%84%D9%82%D8%AF%D8%B3&from=2021-05-08&to=2021-05-08&sortBy=popularity&apiKey=005523bf2e094f25aad09e843e363316")
    Call<News> getdata();
}
