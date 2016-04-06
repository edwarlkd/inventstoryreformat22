package com.example.edward.inventstoryreformat;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View v)
    {
        //now check if Blogin button is pressed or not.
        if(v.getId()==R.id.Blogin)
        {
            EditText a = (EditText)findViewById(R.id.TFusername); //what's in textfield
            String str = a.getText().toString();
            EditText b = (EditText)findViewById(R.id.TFpassword);
            String pass = b.getText().toString();

            //check if username and password match.
            String password = helper.searchPass(str);
            if(pass.equals(password))
            {
                //starting new activity. To start, we need to make object of Intent class
                Intent i = new Intent(MainActivity.this, display.class);
                i.putExtra("Username", str);
                startActivity(i);
            }
            else // show toast message that credential doesn't match.
            {
                Toast temp = Toast.makeText(MainActivity.this, "Username and password don't match", Toast.LENGTH_SHORT);
                temp.show();
            }

        }
        if(v.getId() == R.id.Bsignup)
        {
            Intent i = new Intent(MainActivity.this, SignUp.class);
            startActivity(i);

        }
    }
}
