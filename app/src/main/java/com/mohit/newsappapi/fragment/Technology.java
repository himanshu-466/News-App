package com.mohit.newsappapi.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mohit.newsappapi.ApiUtilities;
import com.mohit.newsappapi.ModelClass;
import com.mohit.newsappapi.R;
import com.mohit.newsappapi.adapter;
import com.mohit.newsappapi.mainNews;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Technology extends Fragment {

    String api ="cec7d4b0ca8c4f12861db30bde214869";
    ArrayList<ModelClass> model;
    adapter newAdapter;
    private RecyclerView recyclerView;
    String country ="in";
    private String category = "technology";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_technology, container, false);
        model = new ArrayList<>();
        newAdapter = new adapter(model,getContext());
        recyclerView = view.findViewById(R.id.technology);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(newAdapter);
        findnews();

        return view;

    }

    private void findnews() {
        ApiUtilities.getApiInterface().getCategoryNews(country,category,100,api).enqueue(new Callback<mainNews>() {
            @Override
            public void onResponse(Call<mainNews> call, Response<mainNews> response) {
                if(response.isSuccessful())
                {
                    model.addAll(response.body().getArticles());
                    newAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<mainNews> call, Throwable t) {

            }
        });
    }
}