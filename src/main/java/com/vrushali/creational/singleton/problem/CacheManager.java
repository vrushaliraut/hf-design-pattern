package com.vrushali.creational.singleton.problem;

import java.util.HashMap;
import java.util.Map;

/* Build in-memory cache, where different parts of our syste, can store and retrieve data

* */
public class CacheManager {
    Map<String, String> cache = new HashMap<>();

    public void addToCache(String key, String value) {
        cache.put(key, value);
    }

    public String getFromCache(String key) {
        return cache.get(key);
    }
}
