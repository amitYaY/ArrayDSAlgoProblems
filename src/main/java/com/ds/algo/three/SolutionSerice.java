package com.ds.algo.three;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class SolutionSerice {

	private static final Integer[] UNSORTED_INPUT = { 1, 5, 24, 75, 34, 38, 89, 54, 26, 91, 17, 66, 67, 68, 69, 70, 9,
			83, 99 };

	public static void main(String[] args) {

		// One Solution is Min Heap and Max Heap [In Case of if input elements are
		// streaming in continuously]

		// Brute-Force is sort the Array

		SolutionSerice serice = new SolutionSerice();

		Integer[] result = serice.findMinAndMaxNumber(UNSORTED_INPUT);

		System.out.println("Min: " + result[0] + " And Max: " + result[1]);
		
		System.out.println("##############################################");

		result = serice.findMinAndMaxNumberUsingCollections(UNSORTED_INPUT);

		System.out.println("Min: " + result[0] + " And Max: " + result[1]);
		
		System.out.println("##############################################");

		result = serice.findMinAndMaxNumberUsingTreeSet(UNSORTED_INPUT);

		System.out.println("Min: " + result[0] + " And Max: " + result[1]);
	}

	private Integer[] findMinAndMaxNumber(Integer[] input) {

		Integer[] result = { input[0], input[0] };

		for (int i = 0, j = input.length - 1; i != j && i != j + 1; i++, j--) {
			Integer min = input[i] <= input[j] ? input[i] : input[j];
			Integer max = input[i] >= input[j] ? input[i] : input[j];
			if (result[0] >= min) {
				result[0] = min;
			}

			if (result[1] <= max) {
				result[1] = max;
			}
		}
		return result;
	}

	private Integer[] findMinAndMaxNumberUsingCollections(Integer[] input) {

		Integer[] result = new Integer[2];

		List<Integer> inputList = Arrays.asList(input);

		inputList.sort(Comparator.naturalOrder());

		result[0] = inputList.get(0);
		result[1] = inputList.get(input.length - 1);

		return result;
	}
	
	private Integer[] findMinAndMaxNumberUsingTreeSet(Integer[] input) {

		Integer[] result = new Integer[2];

		List<Integer> inputList = Arrays.asList(input);
		
		TreeSet<Integer> inputSet = new TreeSet<>(inputList);

		result[0] = inputSet.first();
		result[1] = inputSet.last();

		return result;
	}

}
