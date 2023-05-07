package com.example.shortvideo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
public class ShortVideoListActivity extends AppCompatActivity {
    private ListView lvShortVideoList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_short_video_list);
        lvShortVideoList = findViewById(R.id.lv_short_video_list);
        // 模拟一些短视频数据
        String[] shortVideoList = new String[] {
                "猫咪搞笑视频",
                "小清新美景",
                "穿越时空的旅行",
                "绝美云海"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, shortVideoList);
        lvShortVideoList.setAdapter(adapter);
        // 添加短视频点击事件
        lvShortVideoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // 从短视频列表中获取点击的短视频标题
                String shortVideoTitle = adapterView.getItemAtPosition(i).toString();
                // 创建跳转到 PlayVideoActivity 的 Intent
                Intent intent = new Intent(ShortVideoListActivity.this, PlayVideoActivity.class);
                // 将短视频标题传递给 PlayVideoActivity
                intent.putExtra("shortVideoTitle", shortVideoTitle);
                // 启动 PlayVideoActivity
                startActivity(intent);
            }
        });
    }
}


