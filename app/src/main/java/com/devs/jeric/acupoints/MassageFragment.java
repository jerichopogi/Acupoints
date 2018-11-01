package com.devs.jeric.acupoints;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class MassageFragment extends Fragment {


    public MassageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_massage, container, false);

        CardView headachebtn = (CardView) view.findViewById(R.id.headachebutton);
        CardView stomachachebtn = (CardView) view.findViewById(R.id.stomachachebutton);
        CardView coldsbtn = (CardView) view.findViewById(R.id.coldsbutton);
        CardView insomniabtn = (CardView) view.findViewById(R.id.insomniabutton);
        CardView nauseabtn = (CardView) view.findViewById(R.id.nauseabutton);
        CardView stressbtn = (CardView) view.findViewById(R.id.stressbutton);
        CardView hypertensionbtn = (CardView) view.findViewById(R.id.hypertensionbutton);
        CardView menscrampsbtn = (CardView) view.findViewById(R.id.menscrampsbutton);

        menscrampsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), MensCrampsActivity.class);
                startActivity(in);
            }
        });

        hypertensionbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), HypertensionActivity.class);
                startActivity(in);
            }
        });

        stressbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), StressActivity.class);
                startActivity(in);
            }
        });

        nauseabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), NauseaActivity.class);
                startActivity(in);
            }
        });

        insomniabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), InsomniaActivity.class);
                startActivity(in);
            }
        });

        coldsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), ColdsActivity.class);
                startActivity(in);
            }
        });

        stomachachebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), Stomachache_Activity.class);
                startActivity(in);
            }
        });

        headachebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), Headache_Activity.class);
                startActivity(in);
            }
        });
        return view;
    }
}
