package com.ecobike.app;

public interface Config {

    <T> Class<? extends T> getImplClass(Class<T> type);
}
