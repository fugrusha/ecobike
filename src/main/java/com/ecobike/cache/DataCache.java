package com.ecobike.cache;

import com.ecobike.domain.CacheState;

import java.util.Enumeration;

public interface DataCache<T, E> {

    void add(T key, E value);

    void remove(T key);

    E get(T key);

    Enumeration<T> keys();

    void clear();

    long size();

    CacheState state = CacheState.NO_CHANGES;

    CacheState getState();

    void setState(CacheState newState);
}
