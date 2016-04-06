package com.example.edward.inventstoryreformat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Edward on 4/4/2016.
 */
public class display extends Activity{

    //this class is for displayer log-in

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);


        //fetch this string value and output to Textfield created on display.xml
        //refer to 'How to create a Login form for your Android App' video
        String username = getIntent().getStringExtra("Username"); //match with one from 'MainAct.j'
        TextView tv = (TextView)findViewById(R.id.TVnameDis);
        tv.setText(username);

    }

    //if a button 'onOrganButton' is pressed
    public void onOrganButton(View v){

        //check if it's the button for Borganization(which is button to access Org.)
        if(v.getId() == R.id.BOrganization)
        {
            Intent i = new Intent(display.this, Organization.class);
            startActivity(i);
        }
    }

    public void onManagButton(View v)
    {
        //check if it's the button for Borganization(which is button to access Org.)
        if(v.getId() == R.id.BOrganization)
        {
            Intent i = new Intent(display.this, Organization.class);
            startActivity(i);
        }
    }
}
