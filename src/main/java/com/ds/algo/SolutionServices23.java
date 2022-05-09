package com.ds.algo;

public class SolutionServices23 {

    private int max = Integer.MIN_VALUE;

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        max = nums[0];
        int sum = nums[0];
        for(int i=1; i<len; i++) {
            sum = nums[i] + (sum > 0 ? sum : 0);
            if(sum > max) {
                max = sum;
            }
        }
        return max;
    }

}
