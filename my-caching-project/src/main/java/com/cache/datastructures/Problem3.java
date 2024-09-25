package com.cache.datastructures;

import java.util.Scanner;

public class Problem3 {

    static void maxContainer(int[] arr) {
        int i = 0, j = arr.length - 1;
        int Maxarea = 0, area = 0;
        while (i < j) {
            area = Math.min(arr[i], arr[j]) * (j - i);
            Maxarea = Math.max(Maxarea, area);
            // Maxarea=Math.max(Maxarea,Math.min(arr[i],arr[j])*(j-i));
            if (arr[i] < arr[j])
                i++;
            else
                j--;
        }
        System.out.println("The maximum container area is" + Maxarea);
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
        maxContainer(arr);
    }
}
