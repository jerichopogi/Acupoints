package com.devs.jeric.acupoints;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
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

        sliderAdapter = new SliderAdapter(this);

        mslideViewpager.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        mslideViewpager.addOnPageChangeListener(viewListener);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StartActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    public void addDotsIndicator(int position){
        mDots = new TextView[3];
        mdotLayout.removeAllViews();

        for(int i = 0; i < mDots.length; i++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
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
