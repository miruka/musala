package com.example.miruka.input_stream_example;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import java.io.*;
public class MainActivity extends AppCompatActivity
{
Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     bt=(Button)findViewById(R.id.bt);
        try
        {
            PlayWithRawFiles();
        }
        catch (IOException e)
        {
            Toast.makeText(getApplicationContext(), "Problems: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }
    public void PlayWithRawFiles () throws IOException
    {
        String str = "";
        StringBuffer buf = new StringBuffer();

        InputStream is = this.getResources().openRawResource(R.raw.myfile);

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        if (is != null) {
            while ((str = reader.readLine()) != null)
            {
                buf.append(str + "\n");
            }
        }
        is.close();
        Toast.makeText(getBaseContext(), buf.toString(), Toast.LENGTH_LONG).show();
    }
}
