package com.example.praneethagangisetty.fragment_ex;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class CommentsFragment extends Fragment {
    static Intent intent;
    TextView tv;
    LinearLayoutManager linearLayoutManager;
    List<CommentsData> comments_titles;
    Serializable kids;
    RecyclerView rvc;
    CommentsAdapter adapter;
    List<Integer> comments_list;
    APIInterface apiService = APIClient.getClient().create(APIInterface.class);
    String t;

    public CommentsFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public CommentsFragment(String s) {
        t = s;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_comments, container, false);
        getActivity().setTitle(t);
        comments_titles = new ArrayList<CommentsData>();
        intent = getActivity().getIntent();
        if (intent.getExtras() != null) {
            tv = view.findViewById(R.id.comments);
            kids = intent.getSerializableExtra("kids");
            comments_list = (List<Integer>) kids;
            if (comments_list != null) {
                initViews(view);
                tv.setVisibility(View.GONE);
                rvc.setVisibility(View.VISIBLE);
                getCommentsTitle();
            } else {
                tv.setVisibility(View.VISIBLE);
            }
        }
        return view;
    }

    private void initViews(View view) {
        linearLayoutManager = new LinearLayoutManager(getActivity());
        rvc = view.findViewById(R.id.rvc);
        rvc.setLayoutManager(linearLayoutManager);
        rvc.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        adapter = new CommentsAdapter((CommentsActivity) getActivity(), comments_titles);
        rvc.setAdapter(adapter);
    }

    private void getCommentsTitle() {
        for (int i = 0; i < comments_list.size(); i++) {
            apiService.getNewsTitles(String.valueOf(comments_list.get(i))).enqueue(new Callback<NewsModel>() {
                @Override
                public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                    comments_titles.add(new CommentsData(response.body().getComment_text()));
                    adapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<NewsModel> call, Throwable t) {
                    Log.e(CommentsActivity.class.getSimpleName(), "Error occured in getting comments titles");
                }
            });
        }
    }
}
