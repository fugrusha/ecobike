package com.ecobike.service.impl;

import com.ecobike.app.annotation.InjectByType;
import com.ecobike.app.annotation.Singleton;
import com.ecobike.service.PrintService;
import com.ecobike.service.ValidationService;

import java.util.Scanner;

@Singleton
public class ValidationServiceImpl implements ValidationService {

    @InjectByType
    private PrintService printService;

    private final Scanner in = new Scanner(System.in);

    @Override
    public String getBrandName() {
        String brand = getInputString("Enter brand name:");
        printService.printf("Thank you! Got %s color", brand);
        return brand;
    }

    @Override
    public String getColor() {
        String color = getInputString("Enter color:");
        printService.printf("Thank you! Got %s color", color);
        return color;
    }

    @Override
    public int getMaxSpeed() {
        int maxSpeed = getPositiveNumber("Enter maximum speed (in km/h). It must be positive");
        printService.printf("Thank you! Got %d km/h maximum speed", maxSpeed);
        return maxSpeed;
    }

    @Override
    public int getWeight() {
        int weight = getPositiveNumber("Enter weight of the e-bike (in grams):");
        printService.printf("Thank you! Got %d grams weight of the bike", weight);
        return weight;
    }

    @Override
    public boolean getHasLights() {
        boolean hasLights = getBoolean("Enter availability of lights at front and back (TRUE/FALSE):");
        printService.printf("Thank you! Got %s value", hasLights);
        return hasLights;
    }

    @Override
    public int getBatteryCapacity() {
        int capacity = getPositiveNumber("Enter battery capacity (in mAh):");
        printService.printf("Thank you! Got battery capacity %d mAh", capacity);
        return capacity;
    }

    @Override
    public int getPrice() {
        int price = getPositiveNumber("Enter price:");
        printService.printf("Thank you! Got %d UAH", price);
        return price;
    }

    @Override
    public int getSizeOfWheels() {
        int size = getPositiveNumber("Enter size of the wheels (in inch):");
        printService.printf("Thank you! Got size of the wheels %d inches", size);
        return size;
    }

    @Override
    public int getNumberOfGears() {
        int numberOfGears = getPositiveNumber("Enter number of gears:");
        printService.printf("Thank you! Got %d number of gears", numberOfGears);
        return numberOfGears;
    }

    private String getInputString(String message) {
        printService.println(message);
        return in.nextLine();
    }

    private int getPositiveNumber(String message) {
        int number;

        do {
            printService.println(message);
            while (!in.hasNextInt()) {
                System.out.println("That's not a number! Try again!");
                in.next();
            }

            number = in.nextInt();
        } while (number <= 0);

        return number;
    }

    private boolean getBoolean(String message) {
        boolean returnValue;

        printService.println(message);
        while (!in.hasNextBoolean()) {
            System.out.println("Try again! Required values: true or false");
            in.next();
        }

        returnValue = in.nextBoolean();

        return returnValue;
    }
}
