package com.example.pricematchapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

import java.net.*;
import java.io.*;


public class FindPriceMatch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_price_match);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.URL_MESSAGE);


        try {
            URL aURL = new URL(message);
            String path = aURL.getPath();
            String[] parts = path.split("/");

            String id = parts[parts.length - 1];
            //String input = "http://api.walmartlabs.com/v1/items/" + id + "?format=json&apiKey=k8xqnhk9pdaa3xh4bvng4645";

            try {
                try {

                    URL url = new URL("http://json.org/example.html");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setRequestProperty("Accept", "application/json");

                    if (conn.getResponseCode() != 200) {
                        throw new RuntimeException("Failed : HTTP error code : "
                                + conn.getResponseCode());
                    }

                    BufferedReader br = new BufferedReader(new InputStreamReader(
                            (conn.getInputStream())));

                    String output;
                    System.out.println("Output from Server .... \n");
                    output = br.readLine();

                    JSONObject json = new JSONObject(output);


                    conn.disconnect();

                    String price = json.getString("salePrice");
                    String upc = json.getString("upc");

                    TextView textView = findViewById(R.id.priceFromComp);
                    textView.setText(price);

                } catch (MalformedURLException e) {

                    e.printStackTrace();

                } catch (IOException e) {

                    e.printStackTrace();

                }


            } catch (JSONException e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


//        public static void readJsonFromURL (String link){
//            URL link_ = null;
//            try {
//                link_ = new URL(link);
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            }
//            BufferedReader in = null;
//            try {
//                in = new BufferedReader(
//                        new InputStreamReader(link.openStream()));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            String inputLine;
//            try {
//                while ((inputLine = in.readLine()) != null)
//                    System.out.println(inputLine);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                in.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }





    }








}
