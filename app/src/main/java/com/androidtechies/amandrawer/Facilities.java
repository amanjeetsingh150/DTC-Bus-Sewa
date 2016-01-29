package com.androidtechies.amandrawer;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class Facilities extends Fragment {
    ImageButton i1,i2,i3;
    Intent a,b,c;
    public Facilities() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_fac, container, false);
        i1= (ImageButton) rootView.findViewById(R.id.imageButton);
        i2=(ImageButton)rootView.findViewById(R.id.imageButton2);
        i3=(ImageButton)rootView.findViewById(R.id.imageButton3);
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a= new Intent(getActivity(),tick.class);
                startActivity(a);
                //"
            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            public  void onClick(View view)
            {
                b=new Intent(getActivity(),Helpline.class);
                startActivity(b);
            }
        });
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                c=new Intent(getActivity(),Services.class);
                startActivity(c);
            }
        });

        return rootView;
    }


}
