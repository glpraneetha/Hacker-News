package com.example.praneethagangisetty.fragment_ex;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public List<NewsData> newsData;
    Context c;
    private static final int ITEM = 0;
    private static final int LOADING = 1;
    private boolean isLoadingAdded = false;

    public MyAdapter(Context ct, List<NewsData> s) {
        c = ct;
        newsData = s;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView news_title, serial_no, points, url, time, by, descendants;

        public ItemViewHolder(View itemView) {
            super(itemView);
            serial_no = (TextView) itemView.findViewById(R.id.serial_no);
            points = (TextView) itemView.findViewById(R.id.points);
            url = (TextView) itemView.findViewById(R.id.url);
            time = (TextView) itemView.findViewById(R.id.time);
            by = (TextView) itemView.findViewById(R.id.by);
            descendants = (TextView) itemView.findViewById(R.id.descendants);
            news_title = (TextView) itemView.findViewById(R.id.news_title);
        }
    }

    protected class LoadingViewHolder extends RecyclerView.ViewHolder {
        public LoadingViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder myViewHolder = null;
        switch (viewType) {
            case ITEM:
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout, parent, false);
                myViewHolder = new ItemViewHolder(view);
                break;
            case LOADING:
                View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_progressbar, parent, false);
                myViewHolder = new LoadingViewHolder(view1);
        }
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final NewsData n;
        n = newsData.get(position);

        switch (getItemViewType(position)) {
            case ITEM:
                ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
                itemViewHolder.news_title.setText(n.getTitle());
                itemViewHolder.serial_no.setText(n.getSerial_no());
                itemViewHolder.points.setText(n.getPoints());
                itemViewHolder.url.setText(splitString(n.getUrl()));
                itemViewHolder.time.setText(n.getTime());
                itemViewHolder.descendants.setText(n.getDescendants());
                itemViewHolder.by.setText(n.getBy());
                break;
            case LOADING:
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return (position == newsData.size() - 1 && isLoadingAdded) ? LOADING : ITEM;
    }

    public void addLoadingFooter() {
        isLoadingAdded = true;
    }

    public void removeLoadingFooter() {
        isLoadingAdded = false;
    }

    private String splitString(String url) {
        String[] parts;
        String new_url = null, url2;
        if (url != null) {
            if (url.contains("http://")) {
                new_url = url.substring(7);
            }
            if (url.contains("https://")) {
                new_url = url.substring(8);
            }
            url2 = new_url;
            if (url2.contains("www.")) {
                url2 = new_url.substring(4);
            }
            parts = url2.split("/");
            return parts[0];
        }
        return url;
    }

    @Override
    public int getItemCount() {
        return newsData.size();
    }

    public NewsData getItem(int position) {
        return newsData.get(position);
    }

}
