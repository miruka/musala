package com.example.miruka.mymessenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
public class CreateMessageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
    }
    public void onSendMessage(View view)
            {
                EditText messageview=(EditText)findViewById(R.id.message);
                String messageText=messageview.getText().toString();

                //Intent intent=new Intent(this,RecieveMessageActivity.class);
               // intent.putExtra(RecieveMessageActivity.EXTRA_MESSAGE,messageText);
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,messageText);
                String chooserTitle= getString(R.string.chooser);
                Intent chosenIntent = Intent.createChooser(intent,chooserTitle);
                startActivity(chosenIntent);
            }
}
