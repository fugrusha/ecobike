package com.ecobike.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoldingBike extends Bicycle {

    private int sizeOfWheels;

    private int numberOfGears;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getType().getValue());
        sb.append(" ").append(this.getBrand());
        sb.append(" with ").append(this.numberOfGears).append(" gear(s)");
        sb.append(" and ");

        if (!this.isHasLights()) {
            sb.append("no ");
        }
        sb.append("head/tail light.\n");
        sb.append("Price: ").append(this.getPrice()).append(" euros.\n");

        return sb.toString();
    }
}
