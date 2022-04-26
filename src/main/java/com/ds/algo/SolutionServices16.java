package com.ds.algo;

public class SolutionServices16 {

    private static int[] input = {0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0};
    private static int[] input1 = {1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1};

    public static void main(String[] args) {
        sort(input);
        print(input);
        sort(input1);
        print(input1);
    }

    private static void sort(int[] input) {
        int length = input.length;

        for (int i = 0, j = length - 1; i < j; ) {
            if (input[i] == 0) {
                i++;
            }
            if (input[j] == 1) {
                j--;
            }
            if (input[i] != 0) {
                int temp = input[i];
                input[i] = input[j];
                input[j] = temp;
                i++;
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