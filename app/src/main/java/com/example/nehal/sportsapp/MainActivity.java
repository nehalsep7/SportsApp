package com.example.nehal.sportsapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.nehal.sportsapp.Models.Example;
import com.example.nehal.sportsapp.Models.Hit;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<Hit> responseList = new ArrayList<>();
    private SportsAdapter mListAdapter;
    private Api api;
    private static int count;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        api = AppUtils.getRetrofitApi(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycleView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mListAdapter = new SportsAdapter(responseList);
        mRecyclerView.setAdapter(mListAdapter);
        getList();
    }

    private void getList() {
        Call<Example> call = api.getList("sports");
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                response.body();
                responseList.addAll(response.body().getHits());
                mListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                t.printStackTrace();

            }
        });
    }
}
