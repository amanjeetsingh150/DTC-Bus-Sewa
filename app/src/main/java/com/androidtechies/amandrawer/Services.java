package com.androidtechies.amandrawer;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Services extends ActionBarActivity {
    Toolbar mToolbar;
    Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(R.string.serve);
        b1= (Button) findViewById(R.id.button3);
        b2= (Button) findViewById(R.id.button4);
        b3= (Button) findViewById(R.id.button5);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),serve.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent my = new Intent(android.content.Intent.ACTION_VIEW);
                my.setData(Uri.parse("http://www.delhi.gov.in/wps/wcm/connect/7507f00046280988a480f4980705e910/Special+Trips+Provided+to+%26+from+Delhi+University+2013-2014.docx?MOD=AJPERES&lmod=-322963001&CACHEID=7507f00046280988a480f4980705e910"));
                my.addCategory(Intent.CATEGORY_BROWSABLE);
                startActivity(my);

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("http://www.delhi.gov.in/wps/wcm/connect/66f1d80045d8fc70bc75fe9fdec5f098/IGI+Airport+Bus+Service.xlsx?MOD=AJPERES&lmod=-322799927"));
                myWebLink.addCategory(Intent.CATEGORY_BROWSABLE);
                startActivity(myWebLink);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_services, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
