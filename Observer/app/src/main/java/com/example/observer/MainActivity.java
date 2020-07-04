package com.example.observer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Spammer spammer = new Spammer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void subscribe (View view) {
           spammer.registerObserver();
    }
    public void unsubscribe (View view) {
           spammer.unregisterObserver();
    }
    public void spam (View view) {
           spammer.newSapam("This is spam", "number one");
    }
}
