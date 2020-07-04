package com.example.observer;

import android.util.Log;

public class Abonent implements Observer {
    private static final String TAG = "Abonent";

    public void updateData(String name, String num) {
        Log.d(TAG, "get spam: " + name + " number: " + num + " Tread name:  " + Thread.currentThread().getName());
    }
}
