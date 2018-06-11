package com.example.miruka.check_box;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button order;
    CheckBox coffee,mandazi,tea;
    String myOrder="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coffee=(CheckBox)findViewById(R.id.coffee);
        mandazi=(CheckBox)findViewById(R.id.mandazi);
        tea=(CheckBox)findViewById(R.id.tea);

        order=(Button)findViewById(R.id.order);

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mandazi.isChecked()){
                    myOrder=myOrder+" "+mandazi.getText().toString();
                }
                if (tea.isChecked()){
                    myOrder=myOrder+""+tea.getText().toString();
                }
                Toast.makeText(MainActivity.this," "+myOrder,Toast.LENGTH_LONG).show();


            }
        });
    }
}
