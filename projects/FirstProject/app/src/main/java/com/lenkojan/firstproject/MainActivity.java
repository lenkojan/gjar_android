package com.lenkojan.firstproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClean(View v) {
        ((TextView) findViewById(R.id.textView1)).setText("");
    }

    public void onAdd(View v) {
        String currentText = ((TextView) findViewById(R.id.textView1)).getText().toString();
        String newText = ((EditText) findViewById(R.id.editText1)).getText().toString() + "\n" + currentText;
        ((EditText) findViewById(R.id.editText1)).setText("");
        ((TextView) findViewById(R.id.textView1)).setText(newText);
    }
}
