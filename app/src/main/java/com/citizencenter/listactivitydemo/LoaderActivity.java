package com.citizencenter.listactivitydemo;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import steelkiwi.com.library.DotsLoaderView;

public class LoaderActivity extends AppCompatActivity
{
    DotsLoaderView dotsLoaderView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader);

        dotsLoaderView =findViewById(R.id.dotsLoaderView);
        downloadDemo();
    }

    private void downloadDemo()
    {
        AsyncTask<String,String,String> asyncTask = new AsyncTask<String, String, String>()
        {
            @Override
            protected void onPreExecute()
            {
                dotsLoaderView.show();
            }

            @Override
            protected String doInBackground(String... strings)
            {
                try
                {
                    Thread.sleep(7000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }

                return "done";
            }

            @Override
            protected void onPostExecute(String s)
            {
                if (s.equals("done"))
                {
                    dotsLoaderView.hide();
                }
            }
        };

        asyncTask.execute();
    }
}
