package com.example.tp5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.MalformedURLException;
import java.net.URL;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ResultActivity lecontext = this;
        // Titre
        lecontext.setTitle("Ip result");

        TextView textViewResult = (TextView)findViewById(R.id.textViewResult);

        CallWebApi c = new CallWebApi(textViewResult);
        String ipString = getIntent().getStringExtra("IP");
        String urlString = "http://ip-api.com/xml/" + ipString;
        try {
            URL url = new URL(urlString);
            c.execute(url.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Button doneButton = (Button)findViewById(R.id.buttonDone);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}