package com.ds.algo;

import java.util.ArrayList;
import java.util.List;

public class SolutionServices19 {

    public static void main(String[] args) {
        int[][] grid = {{0,0,1},{1,1,0},{1,0,0}};
        SolutionServices19 service = new SolutionServices19();
        System.out.println(service.minSwaps(grid));
    }

    public int minSwaps(int[][] grid) {
        int ans = 0;
        int len = grid.length;
        List<Integer> list = new ArrayList<>();
        for(int[] row : grid) {
            int j = len - 1;
            int count = 0;
            while(j>=0) {
                if(row[j] == 0) {
                    count++;
                    j--;
                } else {
                    break;
                }
            }
            list.add(count);
        }

        for(int i=0; i<len;i++) {
            int noOfRequiredZeros = len - i -1;
            int index = -1;
            for(int j=i; j<len; j++) {
                if(list.get(j) >= noOfRequiredZeros) {
                    index = j;
                    break;
                }
            }
            if(index == -1) {
                return -1;
            }
            ans = ans + index - i;
            for (int j=index; j>i; j--) {
                int temp = list.get(j);
                list.set(j, list.get(j-1));
                list.set(j-1, temp);
            }
        }
        return ans;
    }

}
