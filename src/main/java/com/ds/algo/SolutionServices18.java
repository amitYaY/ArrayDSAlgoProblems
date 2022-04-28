package com.ds.algo;

public class SolutionServices18 {

    public static void main(String[] args) {
        int[][] res = spiralMatrixIII(4, 5, 1, 2);
        System.out.print("[");
        for (int i = 0; i < 20; i++) {
            System.out.print("[");
            System.out.print(res[i][0] + "," + res[i][1]);
            System.out.print("],");
        }
        System.out.println("]");
    }

    public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {

        int[][] res = new int[rows*cols][2];
        int k = 0;
        int a = 1, c = 1;
        int b = 1, d = 1;
        int count = rows*cols;
        while (k<count) {
            for (int i = cStart; i < cStart+a && k < count; i++) {
                if(i>=0 && i<cols && rStart >=0 && rStart< rows) {
                    res[k][0] = rStart;
                    res[k++][1] = i;
                }
            }
            cStart = cStart + a;
            a = a+2;

            for (int i = rStart; i < rStart+b && k < count; i++) {
                if(i>=0 && i<rows && cStart >=0 && cStart< cols) {
                    res[k][0] = i;
                    res[k++][1] = cStart;
                }
            }
            rStart = rStart + b;
            b = b +2;

            for (int i = cStart ; i > cStart - 1 - c && k < count; i--) {
                if(i>=0 && i<cols && rStart >=0 && rStart< rows) {
                    res[k][0] = rStart;
                    res[k++][1] = i;

                }
            }
            cStart = cStart - c - 1;
            c = c+2;

            for (int i = rStart; i > rStart - 1 - d && k < count; i--) {
                if(i>=0 && i<rows && cStart >=0 && cStart< cols) {
                    res[k][0] = i;
                    res[k++][1] = cStart;
                }
            }
            rStart = rStart - d -1;
            d = d + 2;

        }
        return res;
    }
}
