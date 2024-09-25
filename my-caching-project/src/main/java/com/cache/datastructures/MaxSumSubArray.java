package com.cache.datastructures;

import java.util.*;

public class MaxSumSubArray {
    public static void maxSumSubArray(int[] arr) {
        int maxSum = 0;
        int currentmax = 0;
        for (int i = 0; i < arr.length; i++) {
            currentmax += arr[i];
            if (currentmax > maxSum)
                maxSum = currentmax;
            if (currentmax < 0)
                currentmax = 0;
        }
        System.out.println("The maximum sum of a subarray is " + maxSum);
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
        maxSumSubArray(arr);
    }
}
