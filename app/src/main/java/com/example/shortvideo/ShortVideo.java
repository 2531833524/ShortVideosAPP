package com.example.shortvideo;

public class ShortVideo {
    private String title;
    private String url;
    private int cover;

    public ShortVideo(String title, String url, int cover) {
        this.title = title;
        this.url = url;
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public int getCover() {
        return cover;
    }
}

