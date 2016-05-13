package com.example.edward.inventstoryreformat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by Edward on 4/5/2016.
 * This is for Management portion of our application
 * To be inserted after 'Organization' is completed first.
 */
public class Management extends Activity {
    //show events in list form.
    private ListView mListView1, mListView2;

    private String [] data1 ={"Payment#1    received", "Payment#2  received", "Payment#3    received",
            "Payment#1    Paid", "Payment#2    Paid", "Payment#3    Paid"};
    private String [] data2 ={"Report #1: 4/10/2015", "Report #2: 4/20/2016", "Report #2: 4/30/2016", "Deadline: 5/4/2016"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.management);

        mListView1 = (ListView)findViewById(R.id.listView1);
        mListView2 = (ListView)findViewById(R.id.listView2);

        mListView1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data1));
        mListView2.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data2));

        ListUtils.setDynamicHeight(mListView1);
        ListUtils.setDynamicHeight(mListView2);
    }


    public static class ListUtils {
        public static void setDynamicHeight(ListView mListView) {
            ListAdapter mListAdapter = mListView.getAdapter();
            if (mListAdapter == null) {
                // when adapter is null
                return;
            }
            int height = 0;
            int desiredWidth = View.MeasureSpec.makeMeasureSpec(mListView.getWidth(), View.MeasureSpec.UNSPECIFIED);
            for (int i = 0; i < mListAdapter.getCount(); i++) {
                View listItem = mListAdapter.getView(i, null, mListView);
                listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
                height += listItem.getMeasuredHeight();
            }
            ViewGroup.LayoutParams params = mListView.getLayoutParams();
            params.height = height + (mListView.getDividerHeight() * (mListAdapter.getCount() - 1));
            mListView.setLayoutParams(params);
            mListView.requestLayout();
        }
    }
    /*
    This function is enforced when a 'Adding' button is pressed from 'management.xml'
     */

    public void onAddEventsButton(View v){

        //check if it's the button for Borganization(which is button to access Org.)
        if(v.getId() == R.id.BAddevents)
        {
            Intent i = new Intent(Management.this, ManagInsert.class);
            startActivity(i);
        }
    }


    public void onClickCalenderButton(View v)
    {
        if(v.getId() == R.id.BMcalendar)
        {
            Intent i = new Intent(Management.this, Calendarviewmanag.class);
            startActivity(i);
        }
    }

    public void onClickBackmanag(View v)
    {
        if(v.getId() == R.id.Bbackmanag)
        {
            Intent i = new Intent(Management.this, display.class);
            startActivity(i);
        }
    }

    public void onClicklistdisplay(View v)
    {
        if(v.getId() == R.id.BListmanag)
        {
            Intent i = new Intent(Management.this, Managlist.class);
            startActivity(i);
        }
    }

}
