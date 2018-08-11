package com.citizencenter.listactivitydemo;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] string = getResources().getStringArray(R.array.days);
        ListView listView = getListView();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,string);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(MainActivity.this,((TextView)v).getText().toString(),Toast.LENGTH_SHORT).show();
        Log.e("positonIs",""+position);
        Log.e("idIs",""+id);
        startActivity(new Intent(this,LoaderActivity.class));
    }
}
