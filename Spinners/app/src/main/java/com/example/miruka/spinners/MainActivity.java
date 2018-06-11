package com.example.miruka.spinners;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner myspin;
    TextView txtmsg;
    String[] items = {"Japan", "China", "Malasia","Comoros Island"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtmsg = (TextView) findViewById(R.id.txtMsg);

        myspin = (Spinner) findViewById(R.id.my_spinner);

        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        myspin.setAdapter(aa);
    }

    public void onItemSelected(AdapterView<?> container, View row,int position,long id){
        txtmsg.setText(items[position]);
    }

    public void onNothingSelected(AdapterView<?> container) {
        txtmsg.setText("");
    }

}