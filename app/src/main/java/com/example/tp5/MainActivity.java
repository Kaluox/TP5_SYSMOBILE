package com.example.tp5;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivity lecontext = this;
        // Titre
        lecontext.setTitle("Main page");

        EditText editText = (EditText)findViewById(R.id.editTextIpAdress);

        // Button Configuration
        Button sendBtn = (Button)findViewById(R.id.button);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(lecontext, ResultActivity.class);
                intent.putExtra("IP", editText.getEditableText().toString());
                startActivity(intent);
            }
        });

    }
}