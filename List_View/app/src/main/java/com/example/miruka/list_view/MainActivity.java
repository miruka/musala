package com.example.miruka.list_view;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView mylist;
    String[] items={"0727216073","0734233164"};
    ArrayAdapter item_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        item_adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,android.R.id.text1,items);
        mylist=(ListView)findViewById(R.id.list);
        mylist.setAdapter(item_adapter);
        mylist.setEmptyView(findViewById(R.id.empty));
        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Intent intent = new Intent(Intent.ACTION_CALL);

            intent.setData(Uri.parse("tel:" + items[i]));
            startActivity(intent);


            /*Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + items[i]));
            startActivity(intent);*/
            Toast.makeText(MainActivity.this,items[i],Toast.LENGTH_LONG).show();
            view.setBackgroundColor(Color.CYAN);

        }
    });
    }
}
