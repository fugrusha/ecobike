package com.ecobike.handler;

import com.ecobike.app.DataCache;
import com.ecobike.app.ObjectFactory;

import java.util.Iterator;
import java.util.UUID;

public class ShowAllHandler implements UserInputHandler {

    private DataCache dataCache = ObjectFactory.getInstance().createObject(DataCache.class);

    @Override
    public void handle(String userInput) {
        System.out.println("Show all handler response");

        Iterator iterator = dataCache.keys().asIterator();

        while(iterator.hasNext()) {
            UUID key = (UUID) iterator.next();
            Object o = dataCache.get(key);
            System.out.print(o);
        }
    }
}
