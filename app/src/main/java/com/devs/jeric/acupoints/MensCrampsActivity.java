package com.devs.jeric.acupoints;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import me.anwarshahriar.calligrapher.Calligrapher;

public class MensCrampsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mens_cramps);

        final VideoView videoView = findViewById(R.id.videoViewmens);
        String videopath = "android.resource://" +getPackageName() + "/" + R.raw.mensanimation;
        Uri uri = Uri.parse(videopath);
        videoView.setVideoURI(uri);
        videoView.seekTo(1000);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        final Button button = (Button)findViewById(R.id.playmens);
        final Button pausebtn = (Button)findViewById(R.id.pausebtnmens);

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
