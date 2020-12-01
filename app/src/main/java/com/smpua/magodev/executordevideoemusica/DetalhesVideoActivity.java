package com.smpua.magodev.executordevideoemusica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;

public class DetalhesVideoActivity extends AppCompatActivity {
    private ViewHolder mViewHolder = new ViewHolder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_video);
        this.mViewHolder.play = findViewById(R.id.image_play_video);
        this.mViewHolder.play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),VideoActivity.class));
            }
        });
    }
    private static class ViewHolder {
        ImageView play;
    }
}