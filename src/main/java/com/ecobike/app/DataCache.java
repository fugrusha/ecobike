package com.ecobike.app;

import java.util.Enumeration;

public interface DataCache<T> {

    void add(T key, Object value);

    void remove(T key);

    Object get(T key);

    Enumeration<T> keys();

    void clear();

    long size();
}
