package com.devs.jeric.acupoints;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

public class StomachacheFullScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stomachache_full_screen);

        final VideoView videoView = findViewById(R.id.stomachachFull);
        String videopath = "android.resource://" +getPackageName() + "/" + R.raw.stomachacheanimation;
        Uri uri = Uri.parse(videopath);
        videoView.setVideoURI(uri);
        videoView.seekTo(1000);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
