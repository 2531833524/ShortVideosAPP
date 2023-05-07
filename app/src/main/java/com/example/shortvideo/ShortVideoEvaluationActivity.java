package com.example.shortvideo;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;
import com.example.shortvideo.model.Comment;
import android.os.AsyncTask;
import java.util.List;

import java.util.List;

public class ShortVideoEvaluationActivity extends AppCompatActivity {

    private RatingBar rbShortVideoEvaluation;
    private Button btnSubmitEvaluation;
    private RecyclerView rvCommentList;
    private CommentAdapter commentAdapter;
    private String videoId = "1111"; // 假设当前视频 ID 为 V0001
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_short_video_evaluation);

        dbHelper = new DBHelper(this);

        btnSubmitEvaluation = findViewById(R.id.btn_submit_evaluation);
        rvCommentList = findViewById(R.id.rv_comment_list);

        // 初始化评论列表
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvCommentList.setLayoutManager(layoutManager);
        commentAdapter = new CommentAdapter();
        rvCommentList.setAdapter(commentAdapter);

        // 创建AsyncTask并执行
        new GetCommentListTask().execute();

        btnSubmitEvaluation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = "124";
                EditText etCommentContent = findViewById(R.id.et_comment_content);
                String content = etCommentContent.getText().toString();
                Comment comment = new Comment(videoId, username, content);

                if (dbHelper.insertComment(comment)) {
                    Toast.makeText(ShortVideoEvaluationActivity.this, "评价成功", Toast.LENGTH_SHORT).show();
                    // 刷新评论列表
                    new GetCommentListTask().execute();
                } else {
                    Toast.makeText(ShortVideoEvaluationActivity.this, "评价失败，请重试", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    // 获取评论列表数据的AsyncTask
    private class GetCommentListTask extends AsyncTask<Void, Void, List<Comment>> {

        @Override
        protected List<Comment> doInBackground(Void... voids) {
            return dbHelper.getCommentList(videoId);
        }

        @Override
        protected void onPostExecute(List<Comment> commentList) {
            super.onPostExecute(commentList);
            commentAdapter.updateData(commentList);
        }
    }
}