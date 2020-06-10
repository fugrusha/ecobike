package com.ecobike.domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

public class EqualsAndHashcodeTest {

    @Test
    public void testEBike() {
        UUID id = UUID.randomUUID();

        Ebike b1 = createEBike(id);
        Ebike b2 = createEBike(id);

        Assert.assertEquals(b1, b2);
        Assert.assertTrue(b1.equals(b2));
    }

    @Test
    public void testFoldingBike() {
        UUID id = UUID.randomUUID();

        FoldingBike b1 = createFoldingBike(id);
        FoldingBike b2 = createFoldingBike(id);;

        Assert.assertEquals(b1, b2);
        Assert.assertTrue(b1.equals(b2));
    }

    @Test
    public void testSpeedelec() {
        UUID id = UUID.randomUUID();

        Speedelec b1 = createSpeedelec(id);
        Speedelec b2 = createSpeedelec(id);;

        Assert.assertEquals(b1, b2);
        Assert.assertTrue(b1.equals(b2));
    }

    private Ebike createEBike(UUID id) {
        Ebike bike = new Ebike();
        bike.setId(id);
        bike.setType(BicycleType.E_BIKE);
        bike.setBrand("brandName");
        bike.setMaxSpeed(10);
        bike.setWeight(20000);
        bike.setHasLights(true);
        bike.setBatteryCapacity(65000);
        bike.setColor("grey");
        bike.setPrice(2800);

        return bike;
    }

    private FoldingBike createFoldingBike(UUID id) {
        FoldingBike bike = new FoldingBike();
        bike.setId(id);
        bike.setType(BicycleType.FOLDING_BIKE);
        bike.setBrand("brandName");
        bike.setNumberOfGears(10);
        bike.setWeight(20000);
        bike.setHasLights(true);
        bike.setSizeOfWheels(20);
        bike.setColor("grey");
        bike.setPrice(2800);

        return bike;
    }

    private Speedelec createSpeedelec(UUID id) {
        Speedelec bike = new Speedelec();
        bike.setId(id);
        bike.setType(BicycleType.SPEEDELEC);
        bike.setBrand("brandName");
        bike.setMaxSpeed(10);
        bike.setWeight(20000);
        bike.setHasLights(true);
        bike.setBatteryCapacity(65000);
        bike.setColor("grey");
        bike.setPrice(2800);

        return bike;
    }
}
