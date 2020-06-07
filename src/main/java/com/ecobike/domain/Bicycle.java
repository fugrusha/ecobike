package com.ecobike.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Bicycle {

    private BicycleType type;

    private String brand;

    private int weight;

    private boolean hasLights;

    private String color;

    private int price;
}
