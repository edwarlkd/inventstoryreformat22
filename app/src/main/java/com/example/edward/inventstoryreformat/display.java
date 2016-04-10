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

    /*
    If a button 'onOrganButton' is pressed, it takes the user to the 'Organization' display
    where they can insert or edit stored items.
    Parameter is of class View that we use to check on its id to see if it was
    actually pressed by the user.
     */
    public void onOrganButton(View v){

        //check if it's the button for Borganization(which is button to access Org.)
        if(v.getId() == R.id.BOrganization)
        {
            Intent i = new Intent(display.this, Organization.class);
            startActivity(i);
        }
    }

    /*
    Similarly, if 'Management' is pressed, it takes user to 'Management' portion.
    Parameter is of class View that we use to check on its id to see if it was
    actually pressed by the user.
     */
    public void onManagButton(View v)
    {
        //check if it's the button for Borganization(which is button to access Org.)
        if(v.getId() == R.id.BManagement)
        {
            Intent i = new Intent(display.this, Management.class);
            startActivity(i);
        }
    }
}
