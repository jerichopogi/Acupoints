package com.devs.jeric.acupoints;

import android.content.Context;
import android.net.Uri;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MensCrampsActivity extends AppCompatActivity {

    private VideoView videoView;
    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mens_cramps);

        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        videoView = findViewById(R.id.videoViewmens);
        String fullScreen = getIntent().getStringExtra("fullScreenInd");
        if ("y".equals(fullScreen)) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getSupportActionBar().hide();
        }

        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.mensanimation);

        videoView.setVideoURI(videoUri);
        videoView.seekTo(1000);

        mediaController = new FullScreenMensCramps(this);
        mediaController.setAnchorView(videoView);

        videoView.setMediaController(mediaController);
    }

    @Override
    public void onPause()
    {
        super.onPause();
        PowerManager mPowerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);

        if (!mPowerManager.isScreenOn())
            if (videoView!= null && videoView.isPlaying())
                videoView.pause();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        PowerManager mPowerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);

        if (mPowerManager.isScreenOn())
        {
            videoView.resume();
        }
    }
}
