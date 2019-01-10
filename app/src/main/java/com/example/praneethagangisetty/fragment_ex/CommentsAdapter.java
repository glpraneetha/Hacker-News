package com.example.praneethagangisetty.fragment_ex;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.MyViewHolder> {
    List<CommentsData> commentsData;
    Context c;
    public CommentsAdapter(CommentsActivity commentsActivity, List<CommentsData> comments_titles) {
        c=commentsActivity;
        commentsData=comments_titles;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView comments_text,comments_time,comments_by,kids;
        public MyViewHolder(View itemView) {
            super(itemView);
            comments_text=(TextView)itemView.findViewById(R.id.comments_text);
            comments_time=(TextView)itemView.findViewById(R.id.time);
            comments_by=(TextView)itemView.findViewById(R.id.by);
            kids=(TextView)itemView.findViewById(R.id.descendants);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comments_layout, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(CommentsAdapter.MyViewHolder holder, int position) {
        CommentsData c=commentsData.get(position);
        holder.comments_text.setText(Html.fromHtml(c.getComment_title()));
        holder.comments_time.setText(c.getTime());
        holder.comments_by.setText(c.getBy());
        holder.kids.setText(c.getSizeofkids());
    }

    @Override
    public int getItemCount() {
        return commentsData.size();
    }

}
