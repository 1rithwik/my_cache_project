package com.cache;

import java.util.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LruCache(int capacity) {
        super(capacity, 0.75f, true);// in linkedhashmap class we have constructor which takes 3 parameters
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LruCache<String, String> cache = new LruCache<>(3);
        cache.put("key1", "value1");
        cache.put("key2", "value2");
        cache.put("key3", "value3");
        System.out.println(cache);
        cache.get("key2");// this will make key2 as the most recently used i.e last element
        cache.put("key4", "value4");
        cache.put("key5", "value5");
        System.out.println(cache);
    }

}
