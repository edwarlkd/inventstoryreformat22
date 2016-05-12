package com.example.edward.inventstoryreformat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Edward on 4/5/2016.
 */
public class Organization extends Activity{

    private ListView mListView1, mListView2;

    private String [] data1 ={"Apple", "Orange", "Banana", "Pineapple", "Watermelon", "Kiwi"};
    private String [] data2 ={"Dr. Pepper", "Orange Juice", "Apple Juice", "Jack Daniel", "Coke", "Pepsi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.organization);

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
    This is for when users want to add more events and other schedules.
    //To be implemented further...
     */
    public void onAddingButton(View v){

        //check if it's the button for Borganization(which is button to access Org.)
        if(v.getId() == R.id.BAddInven)
        {
            Intent i = new Intent(Organization.this, OrgInsert.class);
            startActivity(i);
        }
    }

    /*
    This interaction allows users to select one or more items.
     */
    public void onSelectButton(View v)
    {
        //allow users to select n of items -> Then, delete or share.
        //if one item selected->view, delete, or share.
    }

    //long press on a item, pop up comes up with 4 choice.
    //view, edit, delete, share

    public void onClickBackorg(View v)
    {
        if(v.getId() == R.id.Bbackorg)
        {
            Intent i = new Intent(Organization.this, display.class);
            startActivity(i);
        }
    }



}
