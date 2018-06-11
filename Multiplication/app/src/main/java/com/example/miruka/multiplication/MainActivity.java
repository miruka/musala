package com.example.miruka.multiplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText m_editText1;
    private EditText m_editText2;
    private TextView m_answer;

    private Button m_calculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m_editText1 = (EditText) findViewById(R.id.editText);
        m_editText2 = (EditText) findViewById(R.id.editText2);

        m_answer = (TextView) findViewById(R.id.answer);

        m_calculate = (Button) findViewById(R.id.calculate);

        m_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
            }
        });
    }
        public void calculate()
        {
            double value1=Double.parseDouble(m_editText1.getText().toString());
            double value2=Double.parseDouble(m_editText2.getText().toString());
            double calculate=(value1*value2);
            m_answer.setText(Double.toString(calculate));
        }

}
