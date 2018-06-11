package com.example.miruka.musala_application;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Sign_Up_as_a_ProfessionalActivity extends Activity {

    EditText profession_address;
    EditText telephone_number;
    //Spinner profession;
   // Spinner current_location;
    EditText location;
    EditText profession;
    EditText email;
    EditText name;
    EditText password;
    Button profession_submit;
    ProgressBar progressBar;

    FirebaseAuth.AuthStateListener firebaseAuthListener;
    FirebaseAuth   mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up_as_a__professional);

        profession_address= findViewById(R.id.profession_address);
        telephone_number = findViewById(R.id.telephone_number);
        profession_submit = findViewById(R.id.profession_submit);
        name =findViewById(R.id.name);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        progressBar = findViewById(R.id.progressbar);

         //profession =(Spinner) findViewById(R.id.spinnerProfession);
         //current_location =(Spinner) findViewById(R.id.spinnerLocation);
            profession =findViewById(R.id.profession);
            location = findViewById(R.id.location);


        /* // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.profession_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        profession.setAdapter(adapter);
        profession.setPrompt("Select Profession");



        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.location_array, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        current_location.setAdapter(adapter1);
        current_location.setPrompt("Select Your Current Work Location ");*/

        profession_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUserInformation();

            }
        });
    }

    private void saveUserInformation() {
        final  String namme = name.getText().toString().trim();
        final  String prof_address = profession_address.getText().toString().trim();
        final  String tel_number = telephone_number.getText().toString().trim();
        final  String e_mail = email.getText().toString().trim();
        final  String password_one = password.getText().toString().trim();
        final String prof = profession.getText().toString().trim();
        final String loc = location.getText().toString().trim();
       // final  String curr_location = current_location.getSelectedItem().toString().trim();
        //final  String professional = profession.getSelectedItem().toString().trim();

        mAuth = FirebaseAuth.getInstance();

        mAuth.createUserWithEmailAndPassword(e_mail,password_one).addOnCompleteListener(Sign_Up_as_a_ProfessionalActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Sign_Up_as_a_ProfessionalActivity.this, "Sign-Up Error", Toast.LENGTH_SHORT).show();
                }else{
                    String user_id = mAuth.getCurrentUser().getUid();
                    DatabaseReference current_user_db = FirebaseDatabase.getInstance().getReference().child("Users").child(user_id);

                    Map newPost = new HashMap();
                    newPost.put("name",namme);
                    newPost.put("professional_address",prof_address);
                    //newPost.put("email",e_mail);
                    newPost.put("tel_number",tel_number);
                    //newPost.put("password",password_one);
                    newPost.put("location",loc);
                    newPost.put("profession",prof);
                    //newPost.put("current_location",curr_location);
                    //newPost.put("profession",professional);
                    current_user_db.setValue(newPost);

                }

            }
        });

       /* if (cust_address.isEmpty()) {
            customer_address.setError("Address is required");
            customer_address.requestFocus();
            return;

        }
        if (tel_number.isEmpty()) {
            customer_address.setError("Telephone Number is required");
            customer_address.requestFocus();
            return;

        }
        FirebaseUser user = mAuth.getCurrentUser();*/



    }
}
