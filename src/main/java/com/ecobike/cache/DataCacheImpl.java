package com.ecobike.cache;

import com.ecobike.app.DataCache;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Enumeration;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class DataCacheImpl implements DataCache<UUID> {

    private static final ConcurrentHashMap<UUID, CacheObject> cache = new ConcurrentHashMap<>();

    @Override
    public void add(UUID key, Object value) {
        if (key == null) {
            return;
        }

        if (value == null) {
            cache.remove(key);
        } else {
            cache.put(key, new CacheObject(value));
        }
    }

    @Override
    public void remove(UUID key) {
        cache.remove(key);
    }

    @Override
    public Object get(UUID key) {
        return Optional.ofNullable(cache.get(key))
                .map(CacheObject::getValue)
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

    @AllArgsConstructor
    private static class CacheObject {

        @Getter
        private Object value;
    }
}
