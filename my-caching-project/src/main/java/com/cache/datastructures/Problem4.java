package com.cache.datastructures;

import java.util.Scanner;

public class Problem4 {
    static void waterTrapped(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            sum = sum + Math.min(arr[i], arr[i + 1]);
        }
        System.out.println("The water trapped is " + sum);
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
        waterTrapped(arr);
    }
}
