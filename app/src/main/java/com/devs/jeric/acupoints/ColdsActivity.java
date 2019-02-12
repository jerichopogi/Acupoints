package com.devs.jeric.acupoints;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import me.anwarshahriar.calligrapher.Calligrapher;

public class ColdsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colds);



        final VideoView videoView = findViewById(R.id.videoViewcolds);
        String videopath = "android.resource://" +getPackageName() + "/" + R.raw.coldsanimation;
        Uri uri = Uri.parse(videopath);
        videoView.setVideoURI(uri);
        videoView.seekTo(1000);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        final Button button = (Button)findViewById(R.id.playcolds);
        final Button pausebtn = (Button)findViewById(R.id.pausebtncolds);

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
