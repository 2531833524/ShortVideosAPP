package com.example.shortvideo;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayVideoActivity extends AppCompatActivity {

    private TextView tvShortVideoTitle;
    private ImageButton btnComment;
    private ImageButton btnUpload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);

//        // 获取短视频标题
//        String shortVideoTitle = getIntent().getStringExtra("shortVideoTitle");
//
//        // 初始化控件
//        tvShortVideoTitle = findViewById(R.id.tv_short_video_title);
//        btnComment = findViewById(R.id.btn_comment);
//        btnUpload = findViewById(R.id.btn_upload);
//
//        // 设置短视频标题
//        tvShortVideoTitle.setText(shortVideoTitle);


// 获取短视频标题
        String shortVideoTitle = getIntent().getStringExtra("shortVideoTitle");

// 初始化控件
        ImageView ivVideoBackground = findViewById(R.id.iv_video_background);
        btnComment = findViewById(R.id.btn_comment);
        btnUpload = findViewById(R.id.btn_upload);

// 为背景图片设置对应的图片资源
        ivVideoBackground.setImageResource(R.drawable.video_background_image1);

        
        
        // 为评论按钮添加点击事件监听器
        btnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlayVideoActivity.this, ShortVideoEvaluationActivity.class);
                startActivity(intent);
            }
        });

        // 为上传按钮添加点击事件监听器
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlayVideoActivity.this, ShortVideoUploadActivity.class);
                startActivity(intent);
            }
        });
    }
}

