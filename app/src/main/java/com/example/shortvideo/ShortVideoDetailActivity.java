package com.example.shortvideo;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;


public class ShortVideoDetailActivity extends AppCompatActivity {
    private String videoUrl;
    private int videoCover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_short_video_detail);

        // 获取传递过来的视频地址和封面
        Intent intent = getIntent();
        videoUrl = intent.getStringExtra("url");
        videoCover = intent.getIntExtra("cover", 0);

        // 显示视频封面
        ImageView ivVideoCover = findViewById(R.id.iv_video_cover);
        ivVideoCover.setImageResource(videoCover);

        // 评论按钮点击事件监听器
        ImageButton btnComment = findViewById(R.id.btn_comment);
        btnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 跳转到评论页面
                Intent intent = new Intent(ShortVideoDetailActivity.this, ShortVideoEvaluationActivity.class);
                startActivity(intent);
            }
        });

        // 上传按钮点击事件监听器
        ImageButton btnUpload = findViewById(R.id.btn_upload);
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 跳转到上传页面
                Intent intent = new Intent(ShortVideoDetailActivity.this, ShortVideoUploadActivity.class);
                startActivity(intent);
            }
        });

    }

}
