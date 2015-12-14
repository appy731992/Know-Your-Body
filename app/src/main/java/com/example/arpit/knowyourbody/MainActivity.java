package com.example.arpit.knowyourbody;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "AppyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState");
    }

    public void calculate(View view){
        Intent intent = new Intent(this,CalculateActivity.class);
        startActivity(intent);
    }

    public void daily(View view){
        Intent intent = new Intent(this,DailyActivity.class);
        startActivity(intent);
    }

    public void build(View view){
        Intent intent = new Intent(this,BuildActivity.class);
        startActivity(intent);
    }
    public void lose(View view){
        Intent intent = new Intent(this,LoseActivity.class);
        startActivity(intent);
    }
    public void protein(View view){
        Intent intent = new Intent(this,ProteinActivity.class);
        startActivity(intent);
    }
}
