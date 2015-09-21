package com.example.nickdp.myfirstapp.MModel;

import com.example.nickdp.myfirstapp.MView.OnChangeListener;

import java.util.ArrayList;

/**
 * Created by NickDP on 21-09-2015.
 */
public class Observable<T> {
    private final ArrayList<OnChangeListener<T>> listeners = new ArrayList<OnChangeListener<T>>();

    public void addListener(OnChangeListener<T> listener) {
        synchronized (listeners) {
            listeners.add(listener);
        }
    }
    public void removeListener(OnChangeListener<T> listener) {
        synchronized (listeners) {
            listeners.remove(listener);
        }
    }

    protected void notifyObservers(final T model) {
        synchronized (listeners) {
            for (OnChangeListener<T> listener : listeners) {
                listener.onChange(model);
            }
        }
    }
}
