package com.cache;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CacheMain {
    public static void main(String[] args) {
        // Create a fixed thread pool with 2 threads
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Submit a task to calculate the factorial of 5
        Future<Long> futureFactorial = executorService.submit(new FactorialTask(5));

        // Continue processing other tasks or actions
        System.out.println("Main thread is doing other work...");

        // Simulate doing other work with sleep
        try {
            Thread.sleep(1000); // Simulating other processing time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Now retrieve the result of the factorial calculation
        try {
            Long result = futureFactorial.get(); // This will block if the computation is not done yet
            System.out.println("Factorial result: " + result);
        } catch (InterruptedException e) {
            System.err.println("Task was interrupted.");
        } catch (ExecutionException e) {
            System.err.println("An error occurred while executing the task: " + e.getCause());
        } finally {
            // Shutdown the executor service
            executorService.shutdown();
        }
    }
}

class FactorialTask implements Callable<Long> {
    private final int number;

    public FactorialTask(int number) {
        this.number = number;
    }

    @Override
    public Long call() throws Exception {
        return calculateFactorial(number);
    }

    private Long calculateFactorial(int n) {
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
