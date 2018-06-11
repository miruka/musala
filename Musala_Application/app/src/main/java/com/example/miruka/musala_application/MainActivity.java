package com.example.miruka.musala_application;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.Query;

import com.example.miruka.musala_application.*;

public class MainActivity extends AppCompatActivity  {
    private FirebaseAuth mAuth;
    private  FirebaseAuth firebaseAuth;
    //Firebase
    FirebaseDatabase database;
    DatabaseReference users;
    private DrawerLayout dl;
    Button login;
    private ActionBarDrawerToggle abdt;

    EditText email;
    EditText password;
    TextView signup;
    ProgressBar progressBar;

    FirebaseAuth.AuthStateListener mAuthListener;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText)findViewById(R.id.email);
        password =(EditText)findViewById(R.id.password);
        login=(Button)findViewById(R.id.login) ;
        signup = (TextView) findViewById(R.id.signup);
        progressBar = (ProgressBar)findViewById(R.id.progressbar);

        mAuth = FirebaseAuth.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();

        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");

        dl=(DrawerLayout)findViewById(R.id.drawer_layout);
        abdt= new ActionBarDrawerToggle(this,dl,R.string.Open,R.string.Close);
        abdt.setDrawerIndicatorEnabled(true);
        dl.addDrawerListener(abdt);
        abdt.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

     /*   mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if(firebaseAuth.getCurrentUser() != null){
                    finish();
                    Intent customer_navigation = new Intent(MainActivity.this, customerNavigation.class);
                    startActivity(customer_navigation);


                }

            }
        };*/


   signup.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent registration = new Intent(MainActivity.this,RegistrationActivity.class);
            startActivity(registration);
            finish();

        }
    });

    login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           loginUser();
        }
    });

        NavigationView nav_view = (NavigationView)findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id=item.getItemId();
                        if(id == R.id.my_profile)
                        {
                            Toast.makeText(MainActivity.this,"MY PROFILE", Toast.LENGTH_LONG).show();
                        }
                        else if(id == R.id.settings)
                        {
                            Toast.makeText(MainActivity.this,"SETTINGS", Toast.LENGTH_LONG).show();
                        }
                        else if(id == R.id.about_us)
                        {
                            Toast.makeText(MainActivity.this,"Need Any Equipment Fixing or are You a Fixer", Toast.LENGTH_LONG).show();
                        }
                        else if(id == R.id.home)
                        {
                          Intent intent = new Intent(MainActivity.this,MainActivity.class);
                          startActivity(intent);

                        }
                return true;
            }
        });

    }

   /* private void userLogin() {


    mAuth = FirebaseAuth.getInstance();
    }*/
  /* @Override
   protected void onStart(){
       super.onStart();
     mAuth.addAuthStateListener(mAuthListener);
   }*/

    private void loginUser() {

    String eemail = email.getText().toString().trim();
    String ppassword = password.getText().toString().trim();

    final ProgressDialog progressDialog = ProgressDialog.show(MainActivity.this,"Please wait...","Processing...",true);
        firebaseAuth.signInWithEmailAndPassword(eemail,ppassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if (task.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

                    Intent customer_navigation = new Intent(MainActivity.this, customerNavigation.class);
                    customer_navigation.putExtra("Email",firebaseAuth.getCurrentUser().getEmail());
                    startActivity(customer_navigation);
                }else{
                    Log.e("Error",task.getException().toString());
                    Toast.makeText(MainActivity.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });

    /*if (TextUtils.isEmpty(eemail) || TextUtils.isEmpty(ppassword)) {
        Toast.makeText(MainActivity.this, "Fields are empty", Toast.LENGTH_SHORT).show();

        }*/

    /*if(eemail.isEmpty()){
        email.setError("Email is required");
        email.requestFocus();
        return;
    }

   /* if (Patterns.EMAIL_ADDRESS.matcher(eemail).matches()){
        email.setError("Please Enter a Valid email");
        email.requestFocus();
        return;



    if (ppassword.isEmpty()){
        password.setError("Password Required");
        password.requestFocus();
        return;
    }

    if (ppassword.length() < 6){
        email.setError("Minimum length of password should be 6");
        email.requestFocus();
        return;

    }*/

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return abdt.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }



}
