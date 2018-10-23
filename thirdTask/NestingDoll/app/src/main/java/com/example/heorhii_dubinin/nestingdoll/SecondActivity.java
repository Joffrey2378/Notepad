package com.example.heorhii_dubinin.nestingdoll;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void openThirdActivity(View v) {
        Intent i2 = new Intent(this, ThirdActivity.class);
        startActivity(i2);
    }
}
