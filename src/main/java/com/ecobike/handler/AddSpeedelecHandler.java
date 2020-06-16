package com.ecobike.handler;

import com.ecobike.app.annotation.InjectByType;
import com.ecobike.cache.DataCache;
import com.ecobike.domain.AppState;
import com.ecobike.domain.Bicycle;
import com.ecobike.domain.BicycleType;
import com.ecobike.domain.Speedelec;
import com.ecobike.service.PrintService;
import com.ecobike.service.ValidationService;

import java.util.UUID;

public class AddSpeedelecHandler implements UserInputHandler {

    @InjectByType
    private DataCache<UUID, Bicycle> dataCache;

    @InjectByType
    private PrintService printService;

    @InjectByType
    private ValidationService validationService;

    @Override
    public void handle(String userInput) {
        printService.printf("Creating a new record of %s", BicycleType.SPEEDELEC.getValue());

        Bicycle bike = createSpeedelec();

        dataCache.add(bike.getId(), bike);
        dataCache.setState(AppState.NEED_TO_SAVE);

        printService.println("New bike was added to catalog");
        printService.println("Don't forget to save your changes into the file.\n"
                + "Use /save command for it.");
    }

    private Bicycle createSpeedelec() {
        Speedelec bike = new Speedelec();
        bike.setId(UUID.randomUUID());
        bike.setType(BicycleType.SPEEDELEC);
        bike.setBrand(validationService.getBrandName());
        bike.setColor(validationService.getColor());
        bike.setMaxSpeed(validationService.getMaxSpeed());
        bike.setWeight(validationService.getWeight());
        bike.setHasLights(validationService.getHasLights());
        bike.setBatteryCapacity(validationService.getBatteryCapacity());
        bike.setPrice(validationService.getPrice());

        return bike;
    }
}
