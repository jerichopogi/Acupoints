package com.devs.jeric.acupoints;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;
import android.widget.VideoView;

import java.net.URI;

public class MainActivity extends AppCompatActivity{
    Button clk;
    VideoView vid;

    private BottomNavigationView mainNav;
    private FrameLayout mainFrame;

    private MassageFragment massageFragment;
    private RemindersFragment remindersFragment;
    private FactsFragment factsFragment;

    private CardView headacheCard;

    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clk = (Button) findViewById(R.id.button);
        vid = (VideoView) findViewById(R.id.videoView);

        mainFrame = (FrameLayout) findViewById(R.id.main_frame);
        mainNav = (BottomNavigationView) findViewById(R.id.main_nav);

        massageFragment = new MassageFragment();
        remindersFragment = new RemindersFragment();
        factsFragment = new FactsFragment();

        mainFrame = (FrameLayout) findViewById(R.id.main_frame);

        initFragment(massageFragment);

        mainGrid = (GridLayout)findViewById(R.id.main_grid);

        setSingleEvent(mainGrid);

        mainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.nav_massage:
                        initFragment(massageFragment);
                        return true;

                    case R.id.nav_reminders:
                        initFragment(remindersFragment);
                        return true;

                    case R.id.nav_facts:
                        initFragment(factsFragment);
                        return true;

                    default:
                        return false;
                }
            }
        });
    }

    private void setSingleEvent(GridLayout mainGrid) {
        for(int i = 0; i<mainGrid.getChildCount();i++){
            CardView cardView = (CardView)mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "At index number "+ finalI, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void initFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }

    //public void videoplay(View v){
        //String videopath = "android.resource://com.devs.jeric.acupoints/"+R.raw
        //Uri Uri uri = Uri.parse(videopath);
        //vid.setVideoURI(uri);
        //vid.start();
    //}
}
