package com.example.praneethagangisetty.fragment_ex;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommentsData {
    String comment_title,time,by,sizeofkids;
    public CommentsData(String a,long b,String c,int d){
        comment_title=a;
        time=convert(b);
        by=c;
        sizeofkids=String.valueOf(d);
    }
    private String convert(long e) {
        Date date=new Date(e*1000);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("MMM DD, yyyy , hh:mm");
        return simpleDateFormat.format(date);
    }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getSizeofkids() {
        return sizeofkids;
    }

    public void setSizeofkids(String sizeofkids) {
        this.sizeofkids = sizeofkids;
    }

    public String getComment_title() {
        return comment_title;
    }

    public void setComment_title(String comment_title) {
        this.comment_title = comment_title;
    }
}
