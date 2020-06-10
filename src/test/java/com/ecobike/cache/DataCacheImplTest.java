package com.ecobike.cache;

import com.ecobike.app.annotation.InjectByType;
import com.ecobike.domain.Bicycle;
import com.ecobike.domain.BicycleType;
import com.ecobike.domain.Ebike;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

public class DataCacheImplTest {

    @InjectByType
    private DataCache<UUID, Bicycle> cache = new DataCacheImpl();;

    @After
    public void after() {
        cache.clear();
    }

    @Test
    public void testClear() {
        Ebike bike = createEBike();
        UUID key = bike.getId();

        Assert.assertEquals(0, cache.size());
        cache.add(key, bike);
        Assert.assertEquals(1, cache.size());
        cache.clear();
        Assert.assertEquals(0, cache.size());
    }

    @Test
    public void testAddItem() {
        Ebike bike = createEBike();
        UUID key = bike.getId();

        Assert.assertEquals(0, cache.size());
        cache.add(key, bike);
        Assert.assertEquals(1, cache.size());
    }

    @Test
    public void testAddAlreadyExistedKey() {
        Ebike bike1 = createEBike();
        Ebike bike2 = createEBike();
        UUID key = bike1.getId();

        Assert.assertEquals(0, cache.size());
        cache.add(key, bike1);
        Assert.assertEquals(1, cache.size());
        cache.add(key, bike2);
        Assert.assertEquals(1, cache.size());

        // check if item was replaced
        Bicycle actualResult = cache.get(key);
        Assert.assertEquals(bike2.getId(), actualResult.getId());
    }

    @Test
    public void testRemoveItem() {
        Ebike bike = createEBike();
        UUID key = bike.getId();

        cache.add(key, bike);
        Assert.assertEquals(1, cache.size());

        cache.remove(key);
        Assert.assertEquals(0, cache.size());
    }

    @Test
    public void testRemoveByUnExistedKey() {
        Ebike bike = createEBike();
        UUID key = bike.getId();

        cache.add(key, bike);
        Assert.assertEquals(1, cache.size());

        cache.remove(UUID.randomUUID());
        Assert.assertEquals(1, cache.size());
    }

    @Test
    public void testGetItem() {
        Ebike bike = createEBike();
        UUID key = bike.getId();

        cache.add(key, bike);
        Assert.assertEquals(1, cache.size());

        Bicycle actualResult = cache.get(key);
        Assert.assertEquals(key, actualResult.getId());
    }

    @Test
    public void testGetByUnExistedKey() {
        Ebike bike = createEBike();
        UUID key = bike.getId();

        cache.add(key, bike);
        Assert.assertEquals(1, cache.size());

        Bicycle actualResult = cache.get(UUID.randomUUID());
        Assert.assertNull(actualResult);
    }

    @Test
    public void testSize() {
        Ebike bike1 = createEBike();
        UUID key1 = bike1.getId();
        Ebike bike2 = createEBike();
        UUID key2 = bike2.getId();

        Assert.assertEquals(0, cache.size());

        cache.add(key1, bike1);
        cache.add(key2, bike2);

        Assert.assertEquals(2, cache.size());
    }

    @Test
    public void testKeys() {
        Ebike bike1 = createEBike();
        UUID key1 = bike1.getId();
        Ebike bike2 = createEBike();
        UUID key2 = bike2.getId();

        Set<UUID> expectedResult = Set.of(key1, key2);

        cache.add(key1, bike1);
        cache.add(key2, bike2);

        Iterator keys = cache.keys().asIterator();

        while(keys.hasNext()) {
            UUID key = (UUID) keys.next();
            Assert.assertTrue(expectedResult.contains(key));
        }
    }

    private Ebike createEBike() {
        Ebike bike = new Ebike();
        bike.setId(UUID.randomUUID());
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
}
