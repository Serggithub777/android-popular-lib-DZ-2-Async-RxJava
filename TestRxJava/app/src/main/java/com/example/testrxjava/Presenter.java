package com.example.testrxjava;
import android.util.Log;
import java.util.concurrent.TimeUnit;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;

public class Presenter {
    private static final String TAG = "Presenter";

    public Observable<String> getLogMessage() {

        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) {
                try {
                    for (int i = 0; i < 15; i++) {
                        TimeUnit.SECONDS.sleep(1);
                        String message = "It is message";
                        Log.d(TAG, "getMessage: " + Thread.currentThread().getName() + ": " + message);
                        emitter.onNext(message);
                    }
                    emitter.onComplete();
                } catch (InterruptedException e) {
                    Log.d(TAG, "getLogMessage: not disposed");
                }
            }
        }).subscribeOn(Schedulers.io());
        return observable;
    }

}
