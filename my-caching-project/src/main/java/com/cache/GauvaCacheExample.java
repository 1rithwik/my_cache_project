package com.cache;

import com.google.common.cache.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GauvaCacheExample {
    public static void main(String[] args) {
        LoadingCache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(2000)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        return "Value for " + key;
                    }
                });
        try {
            String[] genres = { "Action", "Comedy", "Drama", "Horror", "Romance", "Sci-Fi", "Thriller" };
            // Write code to generate 1000 movies with random genres and push in
            // popularMoviewCache
            for (int i = 0; i < 2000; i++) {
                String movie = "Movie" + i;
                String genre = genres[new Random().nextInt(genres.length)];
                cache.put(movie, genre);
            }
            // Thread.sleep(1000);
            for (int i = 0; i < 100; i++) {
                long startTime = System.nanoTime();
                String movie = cache.get("Movie92600");
                long endTime = System.nanoTime();
                System.out.println("Time taken to fetch the movie: " + (endTime - startTime) + " nanoseconds");
            }

            // It would be retrieved from cache
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// import com.google.common.cache.Cache;
// import com.google.common.cache.CacheBuilder;

// import java.util.concurrent.TimeUnit;

// public class GuavaCacheExample {
// public static void main(String[] args) {
// // Create a cache that holds String keys and Integer values
// Cache<String, Integer> cache = CacheBuilder.newBuilder()
// .maximumSize(100) // Maximum number of entries in the cache
// .expireAfterWrite(10, TimeUnit.MINUTES) // Expire entries 10 minutes after
// write
// .build();

// // Adding values to the cache
// cache.put("key1", 1);
// cache.put("key2", 2);

// // Retrieving values from the cache
// Integer value1 = cache.getIfPresent("key1");
// System.out.println("Value for key1: " + value1); // Should print 1

// // Attempting to retrieve a non-existent key
// Integer value3 = cache.getIfPresent("key3");
// System.out.println("Value for key3: " + value3); // Should print null

// // Invalidating a specific key
// cache.invalidate("key1");

// // Checking the value after invalidation
// Integer value1AfterInvalidation = cache.getIfPresent("key1");
// System.out.println("Value for key1 after invalidation: " +
// value1AfterInvalidation); // Should print null
// }
// }
