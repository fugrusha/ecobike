package com.ecobike.cache;

import com.ecobike.app.annotation.Singleton;
import com.ecobike.domain.AppState;

import java.util.Enumeration;

public interface DataCache<T, E> {

    void add(T key, E value);

    void remove(T key);

    E get(T key);

    Enumeration<T> keys();

    void clear();

    long size();

    AppState state = AppState.NO_CHANGES;

    AppState getState();

    void setState(AppState newState);
}
