package com.example.edward.inventstoryreformat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Edward on 4/5/2016.
 */
public class OrgInsert extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orginst);
    }

    public void onSubmitButton(View v)
    {

    }

    public void onCancelButton(View v){

        //In 'OrgInsert' if the user cancelled out on inserting new item.
        if(v.getId() == R.id.Bcancel)
        {
            Intent i = new Intent(OrgInsert.this, Organization.class);
            startActivity(i);
        }
    }

}
