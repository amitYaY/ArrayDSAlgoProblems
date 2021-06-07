package com.ds.algo.two;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SolutionSerice {

	private static final Integer[] INPUT = { 1, 12, 3, 5, 67, 56, 35, 56, 53, 2, 34, 5, 45, 3, 1, 65, 56 };

	public static void main(String[] args) {

		SolutionSerice serice = new SolutionSerice();
		System.out.println(Arrays.asList(serice.findDuplicateNumber(INPUT)));
	}

	private Integer[] findDuplicateNumber(Integer[] input) {

		Map<Integer, Integer> checkMap = new HashMap<>();

		Set<Integer> result = new HashSet<>();

		for (Integer num : input) {
			if (checkMap.putIfAbsent(num, num) != null) {
				result.add(num);
			}
		}
		return result.toArray(new Integer[result.size()]);
	}

}
