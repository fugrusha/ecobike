package com.ecobike.service.impl;

import com.ecobike.app.DataCache;
import com.ecobike.app.ObjectFactory;
import com.ecobike.cache.DataCacheImpl;
import com.ecobike.domain.*;
import com.ecobike.service.ReaderService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

public class ReaderServiceImpl implements ReaderService {

    private DataCache<UUID> dataCache = ObjectFactory.getInstance().createObject(DataCacheImpl.class);

    @Override
    public void readFile(Path filePath) {

        try (InputStream in = Files.newInputStream(filePath);
             BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line = null;

            while ((line = reader.readLine()) != null) {
                Bicycle bike = parseString(line);
                if (bike != null) {
                    dataCache.add(bike.getId(), bike);
                }
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }

        System.out.println(dataCache + " from reader");
    }

    private Bicycle parseString(String inputString) {
        String[] arr = inputString.split("; ");
        Bicycle bike = null;

        // TODO catch NumberFormatException and others
        if (arr[0].contains(BicycleType.FOLDING_BIKE.getValue())) {
            bike = createFoldingBike(arr);
        } else if (arr[0].contains(BicycleType.E_BIKE.getValue())) {
            bike = createEBike(arr);
        } else if (arr[0].contains(BicycleType.SPEEDELEC.getValue())) {
            bike = createSpeedelec(arr);
        } else {
            throw new IllegalArgumentException(String.format("%s type of bike is not supported", arr[0]));
        }

        return bike;
    }

    private Bicycle createSpeedelec(String[] arr) {
        String brandName = arr[0].replace(BicycleType.SPEEDELEC.getValue(), "").trim();

        Speedelec bike = new Speedelec();
        bike.setId(UUID.randomUUID());
        bike.setType(BicycleType.SPEEDELEC);
        bike.setBrand(brandName);
        bike.setMaxSpeed(Integer.parseInt(arr[1]));
        bike.setWeight(Integer.parseInt(arr[2]));
        bike.setHasLights(Boolean.parseBoolean(arr[3]));
        bike.setBatteryCapacity(Integer.parseInt(arr[4]));
        bike.setColor(arr[5]);
        bike.setPrice(Integer.parseInt(arr[6]));

        return bike;
    }

    private Bicycle createEBike(String[] arr) {
        String brandName = arr[0].replace(BicycleType.E_BIKE.getValue(), "").trim();

        Ebike bike = new Ebike();
        bike.setId(UUID.randomUUID());
        bike.setType(BicycleType.E_BIKE);
        bike.setBrand(brandName);
        bike.setMaxSpeed(Integer.parseInt(arr[1]));
        bike.setWeight(Integer.parseInt(arr[2]));
        bike.setHasLights(Boolean.parseBoolean(arr[3]));
        bike.setBatteryCapacity(Integer.parseInt(arr[4]));
        bike.setColor(arr[5]);
        bike.setPrice(Integer.parseInt(arr[6]));

        return bike;
    }

    private Bicycle createFoldingBike(String[] arr) {
        String brandName = arr[0].replace(BicycleType.FOLDING_BIKE.getValue(), "").trim();

        FoldingBike bike = new FoldingBike();
        bike.setId(UUID.randomUUID());
        bike.setType(BicycleType.FOLDING_BIKE);
        bike.setBrand(brandName);
        bike.setSizeOfWheels(Integer.parseInt(arr[1]));
        bike.setNumberOfGears(Integer.parseInt(arr[2]));
        bike.setWeight(Integer.parseInt(arr[3]));
        bike.setHasLights(Boolean.parseBoolean(arr[4]));
        bike.setColor(arr[5]);
        bike.setPrice(Integer.parseInt(arr[6]));

        return bike;
    }
}
