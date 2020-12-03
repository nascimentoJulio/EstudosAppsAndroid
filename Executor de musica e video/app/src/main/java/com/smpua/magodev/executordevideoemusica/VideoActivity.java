package com.smpua.magodev.executordevideoemusica;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class VideoActivity extends AppCompatActivity {
    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        this.mViewHolder.videoView = findViewById(R.id.videoView);

        this.mViewHolder.videoView.setMediaController(new MediaController(this));
        this.mViewHolder.videoView.setVideoPath("android:resource//"+getPackageName()+"/"+R.raw.video);
        this.mViewHolder.videoView.start();

    }

    private static class ViewHolder {
        VideoView videoView;
    }
}