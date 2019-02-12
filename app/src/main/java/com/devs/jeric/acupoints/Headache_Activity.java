package com.devs.jeric.acupoints;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import me.anwarshahriar.calligrapher.Calligrapher;

public class Headache_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_headache_);

        final VideoView videoView = findViewById(R.id.videoViewheadache);
        String videopath = "android.resource://" +getPackageName() + "/" + R.raw.headacheanimation;
        Uri uri = Uri.parse(videopath);
        videoView.setVideoURI(uri);
        videoView.seekTo(1000);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        final Button button =(Button) findViewById(R.id.playheadache);
        final Button pausebtn = (Button) findViewById(R.id.pausebtnheadache);

        button.setVisibility(View.VISIBLE);
        pausebtn.setVisibility(View.GONE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setVisibility(View.GONE);
                pausebtn.setVisibility(View.VISIBLE);
                videoView.start();
            }
        });

        pausebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pausebtn.setVisibility(View.GONE);
                button.setVisibility(View.VISIBLE);
                videoView.pause();
            }
        });
    }
}
