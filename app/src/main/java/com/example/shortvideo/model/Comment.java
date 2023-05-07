package com.example.shortvideo.model;
public class Comment {
    private String videoId; //视频ID
    private String userName; //用户名
    private String content; //评论内容

    public Comment(String videoId, String userName, String content) {
        this.videoId = videoId;
        this.userName = userName;
        this.content = content;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
