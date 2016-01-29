package com.androidtechies.amandrawer;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

/**
 * Created by Amanjeet Singh on 12-Aug-15.
 */
public class SearchBus extends Fragment {
    public static AutoCompleteTextView s;
    Button b;
    public static SQLiteDatabase data;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_bus,
                container, false);
        s=(AutoCompleteTextView)rootView.findViewById(R.id.autoCompleteTextView);
        b=(Button)rootView.findViewById(R.id.button);
        this.data=new DBconnect(this).openDatabase();
        setbuslist();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), route.class);
                startActivity(i);

            }
        });
        return rootView;
    }
    public void setbuslist()
    {
        Cursor localCursor = this.data.rawQuery("select distinct busNumber from dtc_bus", null);
        String[] arrayOfString=null;
        if ((localCursor != null) && (localCursor.getCount() > 0)) {
            arrayOfString = new String[localCursor.getCount()];
        }
        for (int i = 0;; i++)
        {
            if (!localCursor.moveToNext())
            {
                this.s.setThreshold(1);
                ArrayAdapter<String> adapter;
                adapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_list_item_1,arrayOfString);
                this.s.setAdapter(adapter);
                localCursor.close();
                return;
            }
            arrayOfString[i] = localCursor.getString(localCursor.getColumnIndex("busNumber"));
        }
    }
}
