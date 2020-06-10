package com.ecobike.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public abstract class Bicycle {

    private UUID id;

    private BicycleType type;

    private String brand;

    private int weight;

    private boolean hasLights;

    private String color;

    private int price;

    public abstract String serialize();
}
