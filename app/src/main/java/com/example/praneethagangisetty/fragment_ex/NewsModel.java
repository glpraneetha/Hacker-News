package com.example.praneethagangisetty.fragment_ex;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsModel {
    @SerializedName("title")
    public String title;
    @SerializedName("text")
    public String comment_text;
    @SerializedName("score")
    public int score;
    @SerializedName("kids")
    public List<Integer> kids=null;
    @SerializedName("time")
    public long time;
    @SerializedName("by")
    public String by;
    @SerializedName("descendants")
    public int descendants;
    @SerializedName("url")
    private String url;

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }

    public List<Integer> getKids() {
        return kids;
    }

    public void setKids(List<Integer> kids) {
        this.kids = kids;
    }

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

    public int size_kids(){
        if(kids!=null){
            return kids.size();
        }
        return 0;
    }
}
