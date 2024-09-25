package com.cache.datastructures;

import java.util.*;

public class TwoSumArr {
    public static void twoSum(HashMap<Integer, Integer> map, int target) {
        for (int i : map.keySet()) {
            int complement = target - i;
            if (map.containsKey(complement)) {
                System.out.println("The indices are " + map.get(i) + " and " + map.get(complement));
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            map.put(sc.nextInt(), i);
        }
        System.out.println("Enter the target sum");
        int target = sc.nextInt();
        twoSum(map, target);
        sc.close();
    }

}
