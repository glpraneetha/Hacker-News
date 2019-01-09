package com.example.praneethagangisetty.fragment_ex;


import com.google.gson.annotations.SerializedName;

public class NewsModel {
    @SerializedName("title")
    public String title;
    @SerializedName("score")
    public int score;
    @SerializedName("time")
    public long time;
    @SerializedName("by")
    public String by;
    @SerializedName("descendants")
    public int descendants;
    @SerializedName("url")
    private String url;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public int getDescendants() {
        return descendants;
    }

    public void setDescendants(int descendants) {
        this.descendants = descendants;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
