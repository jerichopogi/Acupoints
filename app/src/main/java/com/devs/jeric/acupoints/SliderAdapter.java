package com.devs.jeric.acupoints;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }

    public int[] slideIcons = {
        R.drawable.icon2,R.drawable.logosplash,R.drawable.icon3,
    };

    public String[] slidedecs = {
            "Acupressure is a specific type of massage that relies primarily on using the thumbs, fingers and palms to apply pressure to various points on the body. Therapists may use various rhythms,"+
                    "pressures and techniques in the practice. Shiatsu massage is a style of acupressure therapy.",
            "Along with its ability to help treat variety of ailments, patients experience additional benefits of acupressure massage. It's a deeply relaxing experience and like other types of massage, " +
                    " can help with,Relieving stress, tension and anxiety,Improving sleep, Relaxing muscles and joints, Soothing the pain and discomfort of a sports or other injury, Reducing digestive issues" +
                    ", Minimizing headaches, Alleviating chronic pain",
            "Acupressure is a therapy developed over 5,000 years ago as an important aspect of Asian, especially Chinese, medicine. It uses precise finger placement and pressure over specific"+
                    "points along the body. These points follow specific channels,"+
                    "known as meridians – the same channels used in acupuncture."

};

    @Override
    public int getCount() {
        return slidedecs.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==(RelativeLayout) object;
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideViewIcon = (ImageView) view.findViewById(R.id.slideIcon);
        TextView slideDescription = (TextView) view.findViewById(R.id.slideDesc);

        slideViewIcon.setImageResource(slideIcons[position]);
        slideDescription.setText(slidedecs[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
