package com.example.shortvideo.admin;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import com.example.shortvideo.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class AdminMainActivity extends AppCompatActivity {
    private ListView lvShortVideoList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);
        lvShortVideoList = findViewById(R.id.lv_short_video_list);
        // 简单地模拟一些短视频数据
        String[] shortVideoList = new String[]{
                "猫咪搞笑视频",
                "小清新美景",
                "穿越时空的旅行",
                "绝美云海"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, shortVideoList);
        lvShortVideoList.setAdapter(adapter);
        Button btnDeleteVideo = findViewById(R.id.btn_delete_video);
        btnDeleteVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] shortVideoList = new String[]{
                        "猫咪搞笑视频",
                        "小清新美景",
                        "穿越时空的旅行",
                        "绝美云海"
                };
                if (shortVideoList.length > 0) {
                    List<String> list = new ArrayList<>(Arrays.asList(shortVideoList)); // 将数组转换为列表
                    list.remove(0); // 删除第一项
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(AdminMainActivity.this, android.R.layout.simple_list_item_1, list);
                    lvShortVideoList.setAdapter(adapter); // 刷新列表
                }
            }
        });
    }
}
