package com.example.observer;

import android.util.Log;

import java.util.ArrayList;

public class Spammer implements Observable {
    private static final String TAG = "Spammer";
    Abonent abonent = new Abonent();
    private boolean isSubscribe = false;
    private String name;
    private String num;

    public void newSapam(String name, String num) {
           this.name = name;
           this.num = num;
        if (isSubscribe) {
            notifyAllObservers();
        }

    }

    @Override
    public void registerObserver() {
         isSubscribe = true;
    }

    @Override
    public void unregisterObserver() {
        isSubscribe = false;
    }

    @Override
    public void notifyAllObservers() {
        Log.d(TAG, "notifyAllObservers: " + "Tread name: " + Thread.currentThread().getName());
        abonent.updateData(name,num);
    }
}
