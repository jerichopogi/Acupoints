package com.devs.jeric.acupoints;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ViewFlipper;


/**
 * A simple {@link Fragment} subclass.
 */
public class FactsFragment extends Fragment {
    private ViewFlipper viewFlipper;
    Button Next, Previous,btn;

    public FactsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_facts, container, false);

        Next = (Button)view.findViewById(R.id.nextbtn);
        Previous = (Button)view.findViewById(R.id.previousbtn);
        viewFlipper = view.findViewById(R.id.viewFlipper);

        Next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                viewFlipper.setInAnimation(getActivity().getApplicationContext(), R.anim.slide_in_right);
                viewFlipper.setOutAnimation(getActivity().getApplicationContext(), R.anim.slide_out_left);
                viewFlipper.showNext();
            }
        });

        Previous.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                viewFlipper.setInAnimation(getActivity().getApplicationContext(), android.R.anim.slide_in_left);
                viewFlipper.setOutAnimation(getActivity().getApplicationContext(), android.R.anim.slide_out_right);
                viewFlipper.showPrevious();
            }
        });

        return view;
    }
}
