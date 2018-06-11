package com.example.miruka.spinners2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AndroidException;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//Spinner spinner;
//CharSequence[] colors={"Red","Orange","Black","Blue","Purple","Yellow"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //spinner=(Spinner)findViewById(R.id.spinner);
        //ArrayAdapter<String> colours = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_checked,colors);
        //ArrayAdapter<CharSequence> colours = new  ArrayAdapter<CharSequence>(this,android.R.layout.simple_list_item_checked,colors);
        //colours.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spinner.setAdapter(colours);
        //spinner.setPrompt("Select Your Favourite Colour");



        Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setPrompt("Select Your Favourite Planet");
spinner.setOnItemClickListener(new setI);

    }
    public void onItemselected(AdapterView<?>adapterView,View view,int i,long l ){
        Toast.makeText(MainActivity.this, "Make it Work", Toast.LENGTH_SHORT).show();
    }
    public  void
}
