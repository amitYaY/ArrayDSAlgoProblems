package com.ds.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionServices6 {
	
	private static final Integer[] INPUT = {6,6,6,6};
	
	private static final Integer[] SIGNED_INPUT = {1,3,5,7,24,6,14,11,6,34,-57,7,6,-54,66,9,6,5,69,-2};

	public static void main(String[] args) {
		SolutionServices6 service = new SolutionServices6();
		System.out.println(service.findPairOfNumIfAllPositive_One(INPUT,12));
		System.out.println("####################################################");
		System.out.println(service.findPairOfNumAllAnyTypeNumber(SIGNED_INPUT,12));

	}
	
	private List<List<Integer>> findPairOfNumIfAllPositive_One(Integer[] input, int target) {

		Map<Integer, Integer> temp = new HashMap<>();
		List<List<Integer>> result = new ArrayList<>();
		for (Integer in : input) {
			if (in < target) {
				if (temp.containsKey(in)) {
					temp.put(in, temp.get(in)+1);
				} else {
					temp.put(in, 1);
				}
			}
		}
		
		for (Integer in : input) {
			int diff = target - in;
			
			int i = 0;
			
			if(diff == in) {
				i = 1;
			}
			
			if (temp.containsKey(diff)) {
				for (; i < temp.get(diff); i++) {
					List<Integer> pair = new ArrayList<>();
					pair.add(in);
					pair.add(diff);
					result.add(pair);
				}
				temp.put(in, temp.get(in) - 1);
			}
		}
		return result;
	}
	
	private List<List<Integer>> findPairOfNumAllAnyTypeNumber(Integer[] input, int target) {

		Map<Integer, Integer> temp = new HashMap<>();
		List<List<Integer>> result = new ArrayList<>();
		for (Integer in : input) {
			if (temp.containsKey(in)) {
				temp.put(in, temp.get(in) + 1);
			} else {
				temp.put(in, 1);
			}
		}

		for (Integer in : input) {
			int diff = target - in;
			int i = 0;

			if (diff == in) {
				i = 1;
			}
			if (temp.containsKey(diff)) {
				for (; i < temp.get(diff); i++) {
					List<Integer> pair = new ArrayList<>();
					pair.add(in);
					pair.add(diff);
					result.add(pair);
				}
				temp.put(in, temp.get(in) - 1);
			}
		}

		return result;
	}

}
