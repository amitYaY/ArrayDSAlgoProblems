package com.ds.algo;

public class SolutionServices21 {

    public static void main(String[] args) {

        int[] a = {1,4,5};
        int[] b = {2,5,4};
        SolutionServices21 services = new SolutionServices21();
        System.out.println(services.minSwap(a, b));
    }

    public int minSwap(int[] a, int[] b) {
        int n = a.length;
        int[][] t = new int[n][2];

        t[0][0] = 0;
        t[0][1] = 1;

        for(int i=1; i< n; i++) {
            t[i][0] = Integer.MAX_VALUE;
            t[i][1] = Integer.MAX_VALUE;
            if(a[i-1] < a[i] && b[i-1] < b [i]) {
                t[i][0] = t[i-1][0];
                t[i][1] = t[i-1][1] + 1;
            }

            if(a[i-1] < b[i] && b[i-1] < a[i]) {
                t[i][0] = Math.min(t[i][0], t[i-1][1]);
                t[i][1] = Math.min(t[i][1], t[i-1][0] + 1);
            }
        }

        return Math.min(t[n - 1][0], t[n - 1][1]);
    }
}
