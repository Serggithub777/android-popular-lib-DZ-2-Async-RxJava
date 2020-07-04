package com.example.observer;

public interface Observable {
    void registerObserver();
    void unregisterObserver();
    void notifyAllObservers();
}
