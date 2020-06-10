package com.ecobike.handler;

import com.ecobike.app.annotation.InjectByType;
import com.ecobike.cache.DataCache;
import com.ecobike.domain.AppState;
import com.ecobike.domain.Bicycle;
import com.ecobike.domain.BicycleType;
import com.ecobike.domain.FoldingBike;
import com.ecobike.service.PrintService;

import java.util.Scanner;
import java.util.UUID;

public class AddFoldingBikeHandler implements UserInputHandler {

    @InjectByType
    private DataCache<UUID, Bicycle> dataCache;

    @InjectByType
    private PrintService printService;

    private Scanner in = new Scanner(System.in);

    @Override
    public void handle(String userInput) {
        Bicycle bike = createFoldingBike();

        dataCache.add(bike.getId(), bike);
        dataCache.setState(AppState.NEED_TO_SAVE);

        printService.println("New bike was added to catalog");
        printService.println("Don't forget to save your changes into the file.\n"
                + "Use /save command for it.");
    }

    private Bicycle createFoldingBike() {
        FoldingBike bike = new FoldingBike();
        bike.setId(UUID.randomUUID());
        bike.setType(BicycleType.FOLDING_BIKE);
        printService.printf("Creating new record of %s with id=%s", bike.getType(), bike.getId());

        printService.println("Enter brand name:");
        String userInput = in.nextLine();
        bike.setBrand(userInput);

        printService.println("Enter size of the wheels (in inch):");
        userInput = in.nextLine();
        bike.setSizeOfWheels(Integer.parseInt(userInput));

        printService.println("Enter number of gears:");
        userInput = in.nextLine();
        bike.setNumberOfGears(Integer.parseInt(userInput));

        printService.println("Enter weight of the e-bike (in grams):");
        userInput = in.nextLine();
        bike.setWeight(Integer.parseInt(userInput));

        printService.println("Enter availability of lights at front and back (TRUE/FALSE):");
        userInput = in.nextLine();
        bike.setHasLights(Boolean.parseBoolean(userInput));

        printService.println("Enter color:");
        userInput = in.nextLine();
        bike.setColor(userInput);

        printService.println("Enter price:");
        userInput = in.nextLine();
        bike.setPrice(Integer.parseInt(userInput));

        return bike;
    }
}
