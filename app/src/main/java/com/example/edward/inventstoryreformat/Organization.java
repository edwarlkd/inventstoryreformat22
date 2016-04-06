package com.example.edward.inventstoryreformat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Edward on 4/5/2016.
 */
public class Organization extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.organization);

        //fetch this string value
        String username = getIntent().getStringExtra("Name");

        //this is an example simply insert our username
        //TextView tv = (TextView)findViewById(R.id.TVusername);
        //tv.setText(username);



    }

    public void onAddingButton(View v){

        //check if it's the button for Borganization(which is button to access Org.)
        if(v.getId() == R.id.BAddInven)
        {
            Intent i = new Intent(Organization.this, OrgInsert.class);
            startActivity(i);
        }
    }



}
