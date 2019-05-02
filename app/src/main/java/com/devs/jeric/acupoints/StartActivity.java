package com.devs.jeric.acupoints;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity {

    private ViewPager mslideViewpager;
    private LinearLayout mdotLayout;
    private SliderAdapter sliderAdapter;
    private TextView[] mDots;
    private Button nextBtn;
    private int mCurrentpage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        mslideViewpager = (ViewPager) findViewById(R.id.slideViewpager);
        mdotLayout = (LinearLayout) findViewById(R.id.dotLayout);
        nextBtn = (Button) findViewById(R.id.nextbtn);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        sliderAdapter = new SliderAdapter(this);

        mslideViewpager.setAdapter(sliderAdapter);

        mslideViewpager.addOnPageChangeListener(viewListener);

        if(restorePrefData()){
            Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(mainActivity);
            finish();
        }

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StartActivity.this, MainActivity.class);
                startActivity(i);
                ActivityCompat.finishAffinity(StartActivity.this);

                savePrefData();
                finish();
            }
        });

        addDotsIndicator(0);
    }

    private boolean restorePrefData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
        Boolean isIntroOpenedBefore = pref.getBoolean("isIntroOpened",false);
        return  isIntroOpenedBefore;
    }

    public void savePrefData(){
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isIntroOpened",true);
        editor.commit();
    }

    public void addDotsIndicator(int position){
        mDots = new TextView[3];
        mdotLayout.removeAllViews();

        for(int i = 0; i < mDots.length; i++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            mdotLayout.addView(mDots[i]);
        }

        if(mDots.length > 0){
            mDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
            mCurrentpage = i;
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
