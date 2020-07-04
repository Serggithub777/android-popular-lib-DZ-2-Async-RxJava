package com.example.asynctasktest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "TestAsyncActivity";

    private TestAsyncTask testAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickButton(View view) {
        testAsyncTask = new TestAsyncTask();
        testAsyncTask.execute();
        Log.d(TAG, "onClickButton: complete: " + Thread.currentThread().getName());
    }
    private static class TestAsyncTask extends AsyncTask<Void, Void, Void> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d(TAG, "onPreExecute: " + Thread.currentThread().getName());
        }

        @Override
        protected Void doInBackground(Void... voids) {


            try {
                for (int i = 0; i < 5; i++) {
                    TimeUnit.SECONDS.sleep(1);
                    Log.d(TAG, "doInBackground: " + Thread.currentThread().getName() + ": " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Log.d(TAG, "onPostExecute: complete: " + Thread.currentThread().getName());

        }
    }
}
