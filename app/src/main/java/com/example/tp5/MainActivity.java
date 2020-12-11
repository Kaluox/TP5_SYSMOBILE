package com.example.tp5;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.StrictMode;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivity lecontext = this;
        // Titre
        lecontext.setTitle("test");
        // Example of a call to a native method
        TextView tv = findViewById(R.id.textView);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                URL url;
                HttpURLConnection urlConnection = null;
                try {
                    url = new URL("http://www.google.com/");
                    urlConnection = (HttpURLConnection) url.openConnection();
                    InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                    readStream(in);
                    urlConnection.disconnect();
                }catch (Exception e){
                    // TODO Auto generated catch block
                    e.printStackTrace();
                    urlConnection.disconnect();}
                }
        });
    }

    private void readStream(InputStream in) {
        TextView tv = findViewById(R.id.textView);
        try {
            int x = in.read();
            tv.setText(x);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}