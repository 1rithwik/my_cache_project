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

// import com.google.common.cache.CacheBuilder;
// import com.google.common.cache.CacheLoader;
// import com.google.common.cache.LoadingCache;

// import java.util.concurrent.TimeUnit;

// public class GuavaCacheExample {
// public static void main(String[] args) throws Exception {
// // Create a LoadingCache
// LoadingCache<String, String> cache = CacheBuilder.newBuilder()
// .maximumSize(100) // Set maximum size
// .expireAfterWrite(10, TimeUnit.MINUTES) // Set expiration time
// .build(new CacheLoader<String, String>() {
// @Override
// public String load(String key) {
// return fetchFromDatabase(key); // Custom load logic
// }
// });

// // Use the cache
// String value = cache.get("myKey"); // Will load if not present
// System.out.println("Value: " + value);
// }

// private static String fetchFromDatabase(String key) {
// // Simulate fetching data from a database
// return "Value for " + key;
// }
// }
