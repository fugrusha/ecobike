package com.ecobike.handler;

import com.ecobike.app.annotation.InjectByType;
import com.ecobike.cache.DataCache;
import com.ecobike.domain.Bicycle;
import com.ecobike.service.PrintService;

import java.util.Iterator;
import java.util.UUID;

public class ShowAllHandler implements UserInputHandler {

    @InjectByType
    private DataCache<UUID, Bicycle> dataCache;

    @InjectByType
    private PrintService printService;

    @Override
    public void handle(String userInput) {
        Iterator iterator = dataCache.keys().asIterator();

        int count = 0;
        while(iterator.hasNext()) {
            UUID key = (UUID) iterator.next();
            Bicycle bike = dataCache.get(key);
            printService.println(bike);

            count++;
        }

        printService.println("There are " + count + " bikes in the catalog.");
    }
}
