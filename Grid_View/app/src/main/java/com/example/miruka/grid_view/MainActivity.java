package com.example.miruka.grid_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    GridView mygrid;
    TextView txtmsg;
    String[] items = {"Japan", "China", "Malasia", "Comoros Island"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtmsg = (TextView)findViewById(R.id.txtMsg1);

        mygrid = (GridView) findViewById(R.id.my_gridview);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1);

        myspin.setAdapter(adapter);

        mygrid.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> container, View v, int position, long id) {

                txtmsg.setText(items[position]);
            }
        });
    }
}
