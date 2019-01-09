package com.example.praneethagangisetty.fragment_ex;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewNewsFragment extends Fragment {

    String tag;
    APIInterface apiService = APIClient.getClient().create(APIInterface.class);
    RecyclerView rv;
    MyAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    LinkedList<NewsData> list;
    ProgressBar pb;
    boolean lastPage=false;
    boolean isLoading=false;
    int pages;
    int currentpage=1;
    List<String> p;

    public NewNewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_news, container, false);
        getActivity().setTitle("Option1");
        initViews(view);
        rv.addOnScrollListener(new PaginationScrollListener((LinearLayoutManager) layoutManager,getActivity()) {
            @Override
            protected void loadMoreItems() {
                isLoading=true;
                loadNextPage();
            }

            @Override
            public boolean isLastPage() {
                return lastPage;
            }
            @Override
            public boolean isLoading(){
                return isLoading;
            }
        });
        getFirstTen();
        return view;
    }

    private void initViews(View view) {

        tag = MainActivity.class.getSimpleName();
        layoutManager = new LinearLayoutManager(getActivity());
        rv = view.findViewById(R.id.rv);
        pb = view.findViewById(R.id.pb);
        rv.setLayoutManager(layoutManager);
        rv.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        list = new LinkedList<>();
        adapter = new MyAdapter(getActivity(), list);
        setProgressBar(list);
        rv.setAdapter(adapter);
    }

    private void setProgressBar(LinkedList<NewsData> list) {
        if (list.isEmpty()) {
            rv.setVisibility(View.GONE);
            pb.setVisibility(View.VISIBLE);
        } else {
            rv.setVisibility(View.VISIBLE);
            pb.setVisibility(View.GONE);
        }
    }

    private void loadNextPage() {
        int k = list.size();
        currentpage++;
        if (currentpage == pages) {
            lastPage = true;
        }
        for (int i = k; i < k + 5; i++) {
            apiService.getNewsTitles(p.get(i)).enqueue(new Callback<NewsModel>() {
                @Override
                public void onResponse(@NonNull Call<NewsModel> call, @NonNull Response<NewsModel> response) {
                    if (response.body() != null) {
                        int h = list.size() + 1;
                        adapter.removeLoadingFooter();
                        isLoading = false;
                        list.add(new NewsData(h, response.body().getScore(), response.body().getTitle(), response.body().getUrl(), response.body().getTime(), response.body().getBy(), response.body().getDescendants()));
                        Log.v(tag, "Current size" + list.size());
                        adapter.notifyDataSetChanged();
                        if (currentpage < pages) adapter.addLoadingFooter();

                    }
                }

                @Override
                public void onFailure(@NonNull Call<NewsModel> call, @NonNull Throwable t) {
                    Log.e(tag, "Error occured in getNewsTexts");
                }
            });
        }
    }

    private void getNewsTexts(List<String> s) {
        for (int i = 0; i < 10; i++) {
            apiService.getNewsTitles(s.get(i)).enqueue(new Callback<NewsModel>() {
                @Override
                public void onResponse(@NonNull Call<NewsModel> call, @NonNull Response<NewsModel> response) {
                    if (response.body() != null) {
                        int h = list.size() + 1;
                        list.add(new NewsData(h, response.body().getScore(), response.body().getTitle(), response.body().getUrl(), response.body().getTime(), response.body().getBy(), response.body().getDescendants()));
                        Log.v(tag, "Current size" + list.size());
                        adapter.notifyDataSetChanged();
                        setProgressBar(list);
                        if (currentpage <= pages) adapter.addLoadingFooter();
                        else lastPage = true;

                    }
                }

                @Override
                public void onFailure(@NonNull Call<NewsModel> call, @NonNull Throwable t) {
                    Log.e(tag, "Error occured in getNewsTexts");
                }
            });
        }
    }

    public void getFirstTen() {
        p = new ArrayList<String>();
        apiService.getLatestNews().enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                Log.v(tag, "this reached");
                p = response.body();
                if (p != null) {
                    pages = (p.size())/5;
                    getNewsTexts(p);
                }
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                Log.e(tag, "Error occured in getFirstTen");
            }
        });
    }
}
