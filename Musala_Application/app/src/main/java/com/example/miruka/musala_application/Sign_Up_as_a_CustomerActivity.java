package com.example.miruka.musala_application;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Sign_Up_as_a_CustomerActivity extends Activity {

    EditText customer_address;
    EditText telephone_number;
    EditText email;
    EditText name;
    EditText currentLocation;
    EditText password1;
    Button customer_submit;
    ProgressBar progressBar;

    FirebaseAuth.AuthStateListener firebaseAuthListener;
    FirebaseAuth   mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up_as_a__customer);

        customer_address= findViewById(R.id.customer_address);
        telephone_number = findViewById(R.id.telephone_number);
        customer_submit = findViewById(R.id.customer_submit);
        name =findViewById(R.id.name);
        currentLocation = findViewById(R.id.currentLocation);
        password1 = findViewById(R.id.password1);
        email = findViewById(R.id.email);
        progressBar = findViewById(R.id.progressbar);



        mAuth = FirebaseAuth.getInstance();



        customer_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUserInformation();

            }
        });

    }

    private void saveUserInformation() {
        final  String namme = name.getText().toString().trim();
        final String cust_address = customer_address.getText().toString().trim();
        final  String tel_number = telephone_number.getText().toString().trim();
        final  String e_mail = email.getText().toString().trim();
        final  String password_one = password1.getText().toString().trim();
        final  String curr_location = currentLocation.getText().toString().trim();
        mAuth.createUserWithEmailAndPassword(e_mail,password_one).addOnCompleteListener(Sign_Up_as_a_CustomerActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Sign_Up_as_a_CustomerActivity.this, "Sign-Up Error", Toast.LENGTH_SHORT).show();
                }else{
                    String user_id = mAuth.getCurrentUser().getUid();
                    DatabaseReference current_user_db = FirebaseDatabase.getInstance().getReference().child("Users").child(user_id);

                    Map newPost = new HashMap();
                    newPost.put("name",namme);
                    newPost.put("cust_address",cust_address);
                    newPost.put("e_mail",e_mail);
                    newPost.put("tel_number",tel_number);
                    newPost.put("password_one",password_one);

                    current_user_db.setValue(newPost);

                }

            }
        });

        if (cust_address.isEmpty()) {
            customer_address.setError("Address is required");
            customer_address.requestFocus();
            return;

        }
        if (tel_number.isEmpty()) {
            customer_address.setError("Telephone Number is required");
            customer_address.requestFocus();
            return;

        }
        FirebaseUser user = mAuth.getCurrentUser();



    }
    private void userLogin() {

        String cust_address = customer_address.getText().toString().trim();
        String tel_number = telephone_number.getText().toString().trim();

        if(cust_address.isEmpty()){
            customer_address.setError("Email is required");
            customer_address.requestFocus();
            return;
        }

   /* if (Patterns.EMAIL_ADDRESS.matcher(eemail).matches()){
        email.setError("Please Enter a Valid email");
        email.requestFocus();
        return;
    }*/


        if (tel_number.isEmpty()){
            telephone_number.setError("Password Required");
            telephone_number.requestFocus();
            return;
        }

       /* if (ppassword.length() < 6){
            email.setError("Minimum length of password should be 6");
            email.requestFocus();
            return;

        }*/

        progressBar.setVisibility(View.VISIBLE);


    }





}
