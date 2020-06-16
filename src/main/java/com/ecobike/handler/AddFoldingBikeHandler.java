package com.ecobike.handler;

import com.ecobike.app.annotation.InjectByType;
import com.ecobike.cache.DataCache;
import com.ecobike.domain.AppState;
import com.ecobike.domain.Bicycle;
import com.ecobike.domain.BicycleType;
import com.ecobike.domain.FoldingBike;
import com.ecobike.service.PrintService;
import com.ecobike.service.ValidationService;

import java.util.UUID;

public class AddFoldingBikeHandler implements UserInputHandler {

    @InjectByType
    private DataCache<UUID, Bicycle> dataCache;

    @InjectByType
    private PrintService printService;

    @InjectByType
    private ValidationService validationService;

    @Override
    public void handle(String userInput) {
        printService.printf("Creating a new record of %s ", BicycleType.FOLDING_BIKE.getValue());

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
        bike.setBrand(validationService.getBrandName());
        bike.setSizeOfWheels(validationService.getSizeOfWheels());
        bike.setNumberOfGears(validationService.getNumberOfGears());
        bike.setWeight(validationService.getWeight());
        bike.setHasLights(validationService.getHasLights());
        bike.setColor(validationService.getColor());
        bike.setPrice(validationService.getPrice());

        return bike;
    }
}
