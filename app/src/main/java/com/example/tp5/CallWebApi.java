package com.example.tp5;

import android.content.Intent;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CallWebApi extends AsyncTask<String, String, String> {

    private TextView mTextView;

    public CallWebApi(TextView mTextView){
        this.mTextView = mTextView;
    }

    @Override
    protected String doInBackground(String... params){
        String inputLine = "";
        StringBuilder result = null;
        URL url;
        try{
            url = new URL(params[0]);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            result = new StringBuilder();
            String line;
            while((line=reader.readLine())!=null){
                result.append(line);
            }

            in.close();
            return result.toString();
        }catch(Exception e){

        }
        return "error";
    }

    protected void onPostExecute(String result){
        GeoIP geoIP = new GeoIP();
        geoIP.parseString(result);
        mTextView.setText(geoIP.toString());
    }


} //end CallAPI
