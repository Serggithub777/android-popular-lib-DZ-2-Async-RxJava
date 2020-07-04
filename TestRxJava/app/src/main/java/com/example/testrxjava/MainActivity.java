package com.example.testrxjava;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Disposable disposable;
    private Presenter presenter;
    private Observable<String> observable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new Presenter();
        observable = presenter.getLogMessage();
    }
    public void subscribe(View view) {
        observable.observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                Log.d(TAG, "onSubscribe: ");
                MainActivity.this.disposable = disposable;
            }

            @Override
            public void onNext(String message) {
                Log.d(TAG, "onNext: " + Thread.currentThread().getName() + ": " + message);
            }

            @Override
            public void onError(Throwable e) {
                    Log.e(TAG, "onError: " + e);
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");
            }
        });
        Log.d(TAG, "subscribe: end " + Thread.currentThread().getName());
    }
    public void unsubscribe(View view) {
        disposable.dispose();
    }
}
