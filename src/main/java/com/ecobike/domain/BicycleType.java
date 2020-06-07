package com.ecobike.domain;

public enum BicycleType {
    SPEEDELEC("SPEEDELEC"),
    FOLDING_BIKE("FOLDING BIKE"),
    E_BIKE("E-BIKE");

    private String value;

    public String getValue() {
        return value;
    }

    BicycleType(String value){
        this.value = value;
    }
}
