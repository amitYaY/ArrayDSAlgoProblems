package com.ds.algo;

public class SolutionService15 {

    //private static int[][] input = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };

    private static int[][] input = { { 1, 2, 3, 4 }, { 10, 11, 12, 5 }, { 9, 8, 7, 6 } };

    public static void main(String[] args) {

        int m = input.length;
        int n = input[0].length;
        int x = 0, y = 0;

        while (m >= 0 && n >= 0) {
            for(int i = y; i< n; i++) {
                System.out.print(input[x][i]+",");
            }
            x++;

            for(int i=x; i< m; i++) {
                System.out.print(input[i][n-1]+",");
            }
            n--;

            if(x<m) {
                for(int i = n-1; i>=y; i--) {
                    System.out.print(input[m-1][i]+",");
                }
                m--;
            }

            if(y<n) {
                for (int i = m-1; i>=x; i--) {
                    System.out.print(input[i][y]+",");
                }
                y++;
            }
        }
    }
}
