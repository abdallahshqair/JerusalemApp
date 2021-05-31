package com.example.jerusalemapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.jerusalemapp.R;
import com.example.jerusalemapp.adapter.NewsAdapter;
import com.example.jerusalemapp.api.Api;
import com.example.jerusalemapp.model.News;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
         recyclerView=findViewById(R.id.rec_news);

        getData();
    }

    private void getData() {
//        coursesArrayList = new ArrayList<>();
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("q", "%D8%A7%D9%84%D9%82%D8%AF%D8%B3");
        hashMap.put("from", "2021-05-08");
        hashMap.put("to", "2021-05-08");
        hashMap.put("sortBy", "popularity");
        hashMap.put("apiKey", "005523bf2e094f25aad09e843e363316");


        Call<News> callSubjectsDetails = Api.getINSTANCE(getApplicationContext())
                .getApiInterface()
                .getdata();
        callSubjectsDetails.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                Log.d("abdallah", response.body().getArticles().get(4).getAuthor() + "");
                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(new NewsAdapter(getApplicationContext(),response.body().getArticles()));

            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

            }
        });
    }
}