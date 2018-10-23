package com.example.heorhii_dubinin.nestingdoll;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends LoggingActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openSecondActivity(View v) {
        Intent i = new Intent(this, SecondActivity.class);
        startActivity(i);
    }
}
