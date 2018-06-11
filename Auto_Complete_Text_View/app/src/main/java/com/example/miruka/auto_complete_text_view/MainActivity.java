package com.example.miruka.auto_complete_text_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtMsg;

    AutoCompleteTextView txtAutoComplete;
    String[] items = { "words", "starting", "with", "set", "Setback", "Setline", "Setoffs", "Setouts", "Setters", "Setting","Settled", "Settler", "Wordless", "Wordiness", "Adios" };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        txtMsg = (TextView) findViewById(R.id.txtMsg);

        txtAutoComplete = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        txtAutoComplete.addTextChangedListener((TextWatcher) this);



        txtAutoComplete.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,items));
    }



    public void onTextChanged(CharSequence s, int start, int before, int count)
    {
        txtMsg.setText(txtAutoComplete.getText());
    }

    public void beforeTextChanged(CharSequence s, int start, int count,int after)
    { }
    public void afterTextChanged(Editable s) {}
    }