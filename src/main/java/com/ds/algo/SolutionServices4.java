package com.ds.algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SolutionServices4 {

	private static final Integer[] INPUT = { 1, 12, 3, 5, 67, 56, 35, 56, 53, 2, 34, 5, 45, 3, 1, 65, 56 };

	public static void main(String[] args) {

		SolutionServices4 serice = new SolutionServices4();

		Integer[] result = serice.removeDuplicates(INPUT);

		System.out.println("Final List: " + Arrays.asList(result));
		
	}

	private Integer[] removeDuplicates(Integer[] input) {

		Map<Integer, Integer> tempMap = new HashMap<>();

		for (Integer num : input) {
			tempMap.put(num, num);
		}
		
		Set<Integer> keySet = tempMap.keySet();
		
		return keySet.toArray(new Integer[keySet.size()]);
	}

}
