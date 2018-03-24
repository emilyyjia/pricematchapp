package com.example.pricematchapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {
    public static final String URL_MESSAGE = "com.example.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendURL(View view) {
        Intent intent = new Intent(this, FindPriceMatch.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(URL_MESSAGE, message);
        startActivity(intent);
    }
}
