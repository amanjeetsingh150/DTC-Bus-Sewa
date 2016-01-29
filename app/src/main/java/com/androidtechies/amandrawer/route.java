package com.androidtechies.amandrawer;

import android.app.ActionBar;
import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.widget.TextView;

import com.androidtechies.amandrawer.R;

/**
 * Created by Amanjeet Singh on 17-Jun-15.
 */
public class route extends Activity {
    TextView  t1,t2,t3,t4;
    Toolbar mToolbar;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ro);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(R.string.route);
       // ActionBar actionBar=getActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(true);
        t1=(TextView)findViewById(R.id.textView8);
        t2=(TextView)findViewById(R.id.textView10);
        t3=(TextView)findViewById(R.id.textView12);
        t4=(TextView)findViewById(R.id.textView7);//
        if(!SearchBus.s.getText().toString().equals(""))
        {
            useCursor();
            useCursor1();
        }
    }
    public void useCursor()
    {
        try {
            String str1 = SearchBus.s.getText().toString();
            String[] strings = {"busNumber", "source", "destination"};
            String str2 = "select busNumber, source, destination from dtc_bus where busNumber ='" + str1 + "'";
            Cursor localCursor = SearchBus.data.rawQuery(str2, null);
            for (; ; ) {
                if (!localCursor.moveToNext()) {
                    localCursor.close();

                    return;
                }
                this.t1.append(Html.fromHtml("Bus Number: <font color=#fffff><b>" + localCursor.getString(localCursor.getColumnIndex("busNumber")) + "</b> </font>"));
                this.t1.append("\n");
                this.t2.append(Html.fromHtml("Source: <font color=#fffff><b>" + localCursor.getString(localCursor.getColumnIndex("source")) + "</b> </font>"));
                this.t2.append("\n");
                this.t3.append(Html.fromHtml("Destination: <font color=#fffff><b>" + localCursor.getString(localCursor.getColumnIndex("destination")) + "</b> </font>"));
            }
        }
        catch (Exception localException){}
    }
    public void useCursor1()
    {
        try {
            String s1=SearchBus.s.getText().toString();
            String[] string={"stops"};
            String str2="select stops from bus_stops where busNumber = '" + s1 + "'";
            Cursor localCursor = SearchBus.data.rawQuery(str2, null);
            localCursor.getCount();
            int i = localCursor.getColumnIndex("stops");
            for (int j = 1;; j++)
            {
                if (!localCursor.moveToNext())
                {
                    localCursor.close();
                    return;
                }
                this.t4.append(j + ". " + localCursor.getString(i) + "\n");
            }
        }
        catch (Exception localException){}
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}