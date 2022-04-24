package com.ds.algo;

import java.util.Arrays;

public class SolutionServices5 {
	
	private static final Integer[] UNSORTED_INPUT = {1,5,24,75,34,38,89,54,26,91,17,66,67,68,69,70,9,83,99};

	public static void main(String[] args) {
		SolutionServices5 service = new SolutionServices5();
		System.out.println("#####################################################################");
		System.out.println(Arrays.asList(service.reverseInputArrayUsingExtraSpace(UNSORTED_INPUT)));
		System.out.println("#####################################################################");
		System.out.println(Arrays.asList(service.reverseInputArrayWithOutExtraSpace(UNSORTED_INPUT)));
	}
	
	private Integer[] reverseInputArrayUsingExtraSpace(Integer[] input) {
		Integer[] result = new Integer[input.length];
		for(int i=0, j=input.length-1; i<input.length; i++,j--) {
			result[j] = input[i];
		}
		return result;
	}
	
	private Integer[] reverseInputArrayWithOutExtraSpace(Integer[] input) {
		
		// This method will change the Original Array
		
		for(int i=0, j=input.length-1; i<(input.length/2); i++,j--) {
			int temp = input[i];
			input[i] = input[j];
			input[j] = temp;
		}
		
		return input;
	}

}
