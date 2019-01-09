package com.example.praneethagangisetty.fragment_ex;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIInterface {
    @GET("newstories.json")
    Call<List<String>> getLatestNews();

    @GET("item/{id}.json")
    Call<NewsModel> getNewsTitles(@Path("id") String id);

}
