package com.ecobike.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

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

    @Override
    public String serialize() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getType().getValue()).append(" ");
        sb.append(this.getBrand()).append("; ");
        sb.append(this.getSizeOfWheels()).append("; ");
        sb.append(this.getNumberOfGears()).append("; ");
        sb.append(this.getWeight()).append("; ");
        sb.append(this.isHasLights()).append("; ");
        sb.append(this.getColor()).append("; ");
        sb.append(this.getPrice()).append("\n");

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FoldingBike bike = (FoldingBike) o;
        return sizeOfWheels == bike.sizeOfWheels &&
                numberOfGears == bike.numberOfGears &&
                this.getId() == bike.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(sizeOfWheels, numberOfGears, this.getId());
    }
}
