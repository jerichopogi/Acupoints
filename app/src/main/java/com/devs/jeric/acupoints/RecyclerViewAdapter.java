package com.devs.jeric.acupoints;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{

    private Context mContext;
    private List<Symptoms> mData;

    public RecyclerViewAdapter(Context mContext, List<Symptoms> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_layout,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.symptom_title.setText(mData.get(position).getSymptomtitle());
        holder.symptom_image.setImageResource(mData.get(position).getThumbnail());

        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, HeadAcheActivity.class);
                intent.putExtra("Title", mData.get(position).getSymptomtitle());
                intent.putExtra("Thumbnail", mData.get(position).getThumbnail());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView symptom_title;
        ImageView symptom_image;
        CardView cardview;

        public MyViewHolder(View itemView) {
            super(itemView);

            symptom_title = (TextView) itemView.findViewById(R.id.symptom_text_id);
            symptom_image = (ImageView) itemView.findViewById(R.id.image_view_id);
            cardview = (CardView)itemView.findViewById(R.id.cardview_id);
        }
    }
}
