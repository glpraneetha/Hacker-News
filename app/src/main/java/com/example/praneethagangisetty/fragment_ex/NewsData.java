package com.example.praneethagangisetty.fragment_ex;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NewsData {
    String id, serial_no, points, news_title, url=null, time, by, descendants;
    List<Integer> kids;

    public NewsData() {

    }

    public NewsData(String h, List<Integer> i, int a, int b, String c, String d, long e, String f, int g) {
        serial_no = String.valueOf(a);
        points = String.valueOf(b) + "p";
        news_title = c;
        url = d;
        time = convert(e);
        by = f;
        descendants = String.valueOf(g);
        id = h;
        kids = i;
    }

    private String convert(long e) {
        Date date=new Date(e*1000);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("MMM DD, yyyy , hh:mm");
        return simpleDateFormat.format(date);
    }

    public List<Integer> getKids() {
        return kids;
    }

    public void setKids(List<Integer> list) {
        kids = list;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSerial_no() {
        return serial_no;
    }

    public void setSerial_no(String serial_no) {
        this.serial_no = serial_no;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
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

    public String getDescendants() {
        return descendants;
    }

    public void setDescendants(String descendants) {
        this.descendants = descendants;
    }

    public String getTitle() {
        return news_title;
    }

    public void setTitle(String title) {
        this.news_title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
