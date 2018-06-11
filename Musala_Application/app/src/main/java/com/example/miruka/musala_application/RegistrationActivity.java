package com.example.miruka.musala_application;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class RegistrationActivity extends AppCompatActivity {
Button customer;
Button profession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        customer=(Button)findViewById(R.id.customer);
        profession=(Button)findViewById(R.id.profession);

        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent customer = new Intent(RegistrationActivity.this,Sign_Up_as_a_CustomerActivity.class);
                startActivity(customer);
            }
        });

        profession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registration=new Intent(RegistrationActivity.this,Sign_Up_as_a_ProfessionalActivity.class);
                startActivity(registration);
            }
        });
    }
}
