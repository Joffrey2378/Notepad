package com.example.heorhii_dubinin.nestingdoll;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        loggingAndToasting("onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        loggingAndToasting("onStart");
        super.onStart();
    }

    @Override
    protected void onStop() {
        loggingAndToasting("onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        loggingAndToasting("onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        loggingAndToasting("onPause");
        super.onPause();
    }

    @Override
    protected void onResume() {
        loggingAndToasting("onResume");
        super.onResume();
    }

    @Override
    protected void onRestart() {
        loggingAndToasting("onRestart");
        super.onRestart();
    }

    public void loggingAndToasting(String msg) {
        Toast toast = Toast.makeText(this, msg + " " + TAG, Toast.LENGTH_SHORT);
        toast.show();
        Log.v(TAG, msg);
    }

    public void openSecondActivity(View v) {
        Intent i = new Intent(this, SecondActivity.class);
        startActivity(i);
    }
}
