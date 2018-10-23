package com.example.heorhii_dubinin.nestingdoll;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }

    public void sendEmail(View view) {
        Intent mailIntent = new Intent();
        mailIntent.setAction(Intent.ACTION_SEND);
        mailIntent.putExtra(Intent.EXTRA_SUBJECT, "How about some nesting?");
        mailIntent.putExtra(Intent.EXTRA_TEXT, "Hello");
        mailIntent.setType("text/plain");
        startActivity(mailIntent);
    }
}
