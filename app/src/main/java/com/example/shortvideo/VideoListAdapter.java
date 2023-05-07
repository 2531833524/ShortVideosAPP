package com.example.shortvideo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class VideoListAdapter extends ArrayAdapter<ShortVideo> {
    private int resource;
    public VideoListAdapter(Context context, List<ShortVideo> objects) {
        super(context, 0, objects);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ShortVideo shortVideo = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_video_list, parent, false);
        }
        TextView tvVideoTitle = convertView.findViewById(R.id.tv_video_title);
        ImageView ivVideoCover = convertView.findViewById(R.id.iv_video_cover);
        tvVideoTitle.setText(shortVideo.getTitle());
        ivVideoCover.setImageResource(shortVideo.getCover());
        return convertView;
    }
}

