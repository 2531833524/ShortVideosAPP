package com.example.shortvideo;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.shortvideo.model.Comment;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "svideo.sqlite";
    private static final int DB_VERSION = 1;
    private final Context context;
    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public SQLiteDatabase openDatabase() {
        File dbFile = context.getDatabasePath(DB_NAME);
        if (!dbFile.exists()) {
            try {
                InputStream is = context.getAssets().open(DB_NAME);
                OutputStream os = new FileOutputStream(dbFile);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    os.write(buffer, 0, length);
                }
                os.flush();
                os.close();
                is.close();
            } catch (IOException e) {
                throw new RuntimeException("Error creating source database", e);
            }
        }
        return SQLiteDatabase.openDatabase(dbFile.getPath(), null, SQLiteDatabase.OPEN_READWRITE);
    }
    // 根据视频ID从数据库中获取评论列表
    public List<Comment> getCommentList(String videoId) {
        List<Comment> commentList = new ArrayList<>();
        SQLiteDatabase db = openDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM comment_list WHERE video_id=?", new String[]{videoId});
        while (cursor.moveToNext()) {
            @SuppressLint("Range") String username = cursor.getString(cursor.getColumnIndex("user_name"));
            @SuppressLint("Range") String content = cursor.getString(cursor.getColumnIndex("comment"));
            Comment comment = new Comment(videoId, username, content);
            commentList.add(comment);
        }
        cursor.close();
        db.close();
        return commentList;
    }
    // 向数据库中插入评论
    public boolean insertComment(Comment comment) {
        SQLiteDatabase db = openDatabase();
        ContentValues values = new ContentValues();
        values.put("video_id", comment.getVideoId());
        values.put("user_name", comment.getUserName());
        values.put("comment", comment.getContent());
        long id = db.insert("comment_list", null, values);
        db.close();
        return (id != -1);
    }
}
