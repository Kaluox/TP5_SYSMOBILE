package com.example.tp5;

import android.content.Intent;
import android.os.AsyncTask;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
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
    private GeoIP parseXML( XmlPullParser parser ) throws XmlPullParserException, IOException {
        int eventType = parser.getEventType();
        GeoIP result = new GeoIP();
        while( eventType!= XmlPullParser.END_DOCUMENT) {
            String name = null;
            switch(eventType)
            {
                case XmlPullParser.START_TAG:
                name = parser.getName();
                if( name.equals("Error")) {
                    System.out.println("Web API Error!");
                }
                else if( name.equals("countryCode")) {
                    result.countryCode=parser.nextText();
                }
                else if(name.equals("query")) {
                    result.query= parser.nextText();
                }
                else if(name.equals("country")) {
                    result.country= parser.nextText();
                }
                //ajouter d'autres champs
                break;
                case XmlPullParser.END_TAG:
                    break;
            } // end switch
            eventType = parser.next();
        } // end while
        return result;
    }

    protected void onPostExecute(String result){
        System.out.println("##########     Entering onPostExecute     ##########");
        GeoIP geoIP = new GeoIP();
        geoIP.parseString(result);
        mTextView.setText(result);
    }
} //end CallAPI
