package com.example.shortvideo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ShortVideoUploadActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_VIDEO_CAPTURE = 1;

    private Button btnRecordAndUpload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_short_video_upload);

        btnRecordAndUpload = findViewById(R.id.btn_record_and_upload);

        // 打开系统相机拍摄短视频并上传
        btnRecordAndUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(intent, REQUEST_CODE_VIDEO_CAPTURE);
                } else {
                    Toast.makeText(ShortVideoUploadActivity.this, "无法打开相机", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_VIDEO_CAPTURE && resultCode == RESULT_OK) {
            Uri videoUri = data.getData();
            // 执行上传操作，此处略去
            Toast.makeText(ShortVideoUploadActivity.this, "上传成功", Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
