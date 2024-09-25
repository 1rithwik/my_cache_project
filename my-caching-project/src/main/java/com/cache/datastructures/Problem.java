package com.cache.datastructures;

import java.util.Scanner;

public class Problem {
    static void fun1(int[] arr) {
        int n = arr.length;
        long startTime = System.nanoTime();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap arr[i] and arr[minIndex]
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        long endTime = System.nanoTime();
        System.out.println(
                "Time taken to sort the array using selection sort: " + (endTime - startTime) + " nanoseconds");

        startTime = System.nanoTime();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped, the array is sorted
            if (!swapped) {
                break;
            }
        }
        endTime = System.nanoTime();
        System.out.println(
                "Time taken to sort the array using bubble sort: " + (endTime - startTime) + " nanoseconds");

        // Insertion Sort
        startTime = System.nanoTime();
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        endTime = System.nanoTime();
        System.out.println(
                "Time taken to sort the array using insertion sort: " + (endTime - startTime) + " nanoseconds");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        System.out.println("Enter the elements of the array");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        fun1(arr);
    }

}
