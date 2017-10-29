package com.example.nehal.sportsapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

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
    private ProgressDialog progressDialog;
    private SpinnerHintAdapter categoryAdapter;
    private AppCompatSpinner queryCategory;
    private String selectItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        fetchDropdown();
    }

    private void initialize() {
        queryCategory = (AppCompatSpinner)findViewById(R.id.spinner);
        api = AppUtils.getRetrofitApi(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycleView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mListAdapter = new SportsAdapter(responseList);
        mRecyclerView.setAdapter(mListAdapter);
        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(MainActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if(responseList.get(position) != null){
                    if(!TextUtils.isEmpty(responseList.get(position).getUrl())){
                        Intent i = new Intent(MainActivity.this,DetailActivity.class);
                        i.putExtra("url",responseList.get(position).getUrl());
                        startActivity(i);
                    }else{
                        Toast.makeText(MainActivity.this, "No URL for webView", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        }));
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading Items");
    }

    private void fetchDropdown() {
        String productCategory[] = getResources().getStringArray(R.array.query_options);
        categoryAdapter = new SpinnerHintAdapter(MainActivity.this, productCategory, R.layout.support_simple_spinner_dropdown_item);
        categoryAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        queryCategory.setAdapter(categoryAdapter);
        queryCategory.setSelection(categoryAdapter.getCount());
        queryCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position) != null && !parent.getItemAtPosition(position).toString().equalsIgnoreCase("Select an item")) {
                    responseList.clear();
                    mListAdapter.notifyDataSetChanged();
                    selectItem = parent.getItemAtPosition(position).toString();
                    getList(selectItem);
                } else {
                    selectItem = null;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void getList(String selection) {
        Call<Example> call = api.getList(selection);
        if(progressDialog != null)
            progressDialog.show();
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if(progressDialog != null && progressDialog.isShowing())
                    progressDialog.hide();
                response.body();
                responseList.addAll(response.body().getHits());
                mListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                t.printStackTrace();
                if(progressDialog != null )
                    progressDialog.hide();
                Toast.makeText(MainActivity.this, "Failed to fetch items", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
