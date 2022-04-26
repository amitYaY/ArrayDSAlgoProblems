package com.ds.algo;

public class SolutionServices17 {

    private static int[] input = {2, 0, 1};
    private static int[] input1 = {2, 0, 2, 1, 1, 0};

    public static void main(String[] args) {
        sort(input);
        print(input);
        sort(input1);
        print(input1);
    }

    private static void sort(int[] nums) {
        int i = 0;
        int j = 0;
        int k = nums.length-1;

        while (j <= k) {
            if(nums[j] == 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            } else if(nums[j] == 2) {
                int temp = nums[k];
                nums[k] = nums[j];
                nums[j] = temp;
                k--;
            } else {
                j++;
            }
        }
    }

    private static void print(int[] input) {
        for (int i : input) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

}
