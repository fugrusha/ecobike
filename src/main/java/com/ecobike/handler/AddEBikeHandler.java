package com.ecobike.handler;

import com.ecobike.app.annotation.InjectByType;
import com.ecobike.cache.DataCache;
import com.ecobike.domain.AppState;
import com.ecobike.domain.Bicycle;
import com.ecobike.domain.BicycleType;
import com.ecobike.domain.Ebike;
import com.ecobike.service.PrintService;

import java.util.Scanner;
import java.util.UUID;

public class AddEBikeHandler implements UserInputHandler {

    @InjectByType
    private DataCache<UUID, Bicycle> dataCache;

    @InjectByType
    private PrintService printService;

    private Scanner in = new Scanner(System.in);

    @Override
    public void handle(String userInput) {
        Bicycle bike = addNewEBike();

        dataCache.add(bike.getId(), bike);
        dataCache.setState(AppState.NEED_TO_SAVE);

        printService.println("New bike was added to catalog");
        printService.println("Don't forget to save your changes into the file.\n"
                + "Use /save command for it.");
    }

    private Bicycle addNewEBike() {
        Ebike bike = new Ebike();
        bike.setId(UUID.randomUUID());
        bike.setType(BicycleType.E_BIKE);
        printService.printf("Creating new record of %s with id=%s", bike.getType(), bike.getId());

        printService.println("Enter brand name:");
        String userInput = in.nextLine();
        bike.setBrand(userInput);

        printService.println("Enter maximum speed (in km/h):");
        userInput = in.nextLine();
        bike.setMaxSpeed(Integer.parseInt(userInput));

        printService.println("Enter weight of the e-bike (in grams):");
        userInput = in.nextLine();
        bike.setWeight(Integer.parseInt(userInput));

        printService.println("Enter availability of lights at front and back (TRUE/FALSE):");
        userInput = in.nextLine();
        bike.setHasLights(Boolean.parseBoolean(userInput));

        printService.println("Enter battery capacity (in mAh):");
        userInput = in.nextLine();
        bike.setBatteryCapacity(Integer.parseInt(userInput));

        printService.println("Enter color:");
        userInput = in.nextLine();
        bike.setColor(userInput);

        printService.println("Enter price:");
        userInput = in.nextLine();
        bike.setPrice(Integer.parseInt(userInput));

        return bike;
    }
}
