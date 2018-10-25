package com.example.heorhii_dubinin.nestingdoll;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

public abstract class LoggingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loggingAndToasting("onCreate");
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
        Toast toast = Toast.makeText(this, msg + " " + this.getClass().getSimpleName(), Toast.LENGTH_SHORT);
        toast.show();
        Log.i(this.getClass().getSimpleName(), msg);
    }
}
