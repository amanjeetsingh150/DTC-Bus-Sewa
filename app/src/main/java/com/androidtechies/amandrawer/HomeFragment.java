package com.androidtechies.amandrawer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Amanjeet Singh on 12-Aug-15.
 */
public class HomeFragment extends Fragment {
    EditText e1,e2;
    String s1,s2;
    Button b1;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home,
                container, false);
        e1= (EditText) rootView.findViewById(R.id.editText2);
        e2= (EditText) rootView.findViewById(R.id.editText3);
        b1=(Button)rootView.findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                Toast t=Toast.makeText(getActivity(),"Please select the bus option in google maps to view the bus number available.",Toast.LENGTH_LONG);
                t.show();
                String url="https://www.google.co.in/maps/dir/"+s1+",+New+Delhi,+Delhi/"+ s2+ ",+New+Delhi,+Delhi/@28.6127912,77.2616739,14z/data=!4m8!4m7!1m2!1m1!1s0x390cfb08c81f50cf:0x455019574c65ba2f!1m2!1m1!1s0x390ce2127da1cf23";
                Uri gmmIntentUri=Uri.parse(url);
                Intent mapIntent= new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);

            }
        });

        return rootView;
    }
}
