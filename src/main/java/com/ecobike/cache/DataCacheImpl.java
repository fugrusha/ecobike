package com.ecobike.cache;

import com.ecobike.app.annotation.Singleton;
import com.ecobike.domain.Bicycle;
import com.ecobike.domain.CacheState;
import lombok.Getter;
import lombok.Setter;

import java.util.Enumeration;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
public class DataCacheImpl implements DataCache<UUID, Bicycle> {

    private static final ConcurrentHashMap<UUID, Bicycle> cache = new ConcurrentHashMap<>();

    @Setter
    @Getter
    private CacheState state = CacheState.NO_CHANGES;

    @Override
    public void add(UUID key, Bicycle value) {
        if (key == null) {
            return;
        }

        if (value == null) {
            cache.remove(key);
        } else {
            cache.put(key, value);
        }
    }

    @Override
    public void remove(UUID key) {
        cache.remove(key);
    }

    @Override
    public Bicycle get(UUID key) {
        return Optional.ofNullable(cache.get(key))
                .orElse(null);
    }

    @Override
    public void clear() {
        cache.clear();
    }

    @Override
    public long size() {
        return cache.size();
    }

    @Override
    public Enumeration<UUID> keys() {
        return cache.keys();
    }
}
