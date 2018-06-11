package com.example.miruka.radio_button;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button ok;
    RadioButton male, female;
    String gender="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        male = (RadioButton) findViewById(R.id.male);
        female = (RadioButton) findViewById(R.id.female);
        ok=(Button)findViewById(R.id.ok) ;

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (female.isChecked()) {
                    gender = "FEMALE";
                } else {
                    gender = "MALE";
                }
                Toast.makeText(MainActivity.this,""+gender,Toast.LENGTH_LONG).show();
            }



        });

    }
}
