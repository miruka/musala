package com.example.miruka.sqllite;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText id_1,name_1;
Button add,read,update,delete;
DbHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydb= new DbHelper(this);
        id_1=(EditText)findViewById(R.id.id_1);
        name_1=(EditText)findViewById(R.id.name_1);
        add=(Button)findViewById(R.id.add);
        read=(Button)findViewById(R.id.read);
        update=(Button)findViewById(R.id.update);
        delete=(Button)findViewById(R.id.delete);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydb.writeData(id_1.getText().toString(),name_1.getText().toString());
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor crs = mydb.readData(id_1.getText().toString());
                name_1.setText(crs.getString(0));
                if (crs.moveToFirst()){
                    do {
                        name_1.setText(crs.getString(0));
                    }while (crs.moveToNext());
                }
                crs.close();
            }
        });//end

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
