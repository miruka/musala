package com.example.miruka.mymessenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
public class RecieveMessageActivity extends Activity {

    public  static final String EXTRA_MESSAGE="FUCK ANDROID";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recieve_message);

        Intent intent=getIntent();
        String messageText=intent.getStringExtra(EXTRA_MESSAGE);

        TextView messageView=(TextView)findViewById(R.id.message);
        messageView.setText(messageText);

    }
}
