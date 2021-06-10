package com.ds.algo.six;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionService {
	
	private static final Integer[] INPUT = {1,3,5,7,24,26,11,34,38,7,54,66,9,67,68,5,69,70,75,83,89,91,99};
	
	private static final Integer[] SIGNED_INPUT = {1,3,5,7,24,14,11,34,-57,7,-54,66,9,5,69,-2};

	public static void main(String[] args) {
		SolutionService service = new SolutionService();
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
		
		for(Integer in : temp.keySet()) {
			int diff = target - in;
			if(temp.containsKey(diff) && temp.get(in) > 0) {
				while(temp.get(diff)>0) {
					List<Integer> pair = new ArrayList<>();
					pair.add(in);
					pair.add(diff);
					result.add(pair);
					temp.put(diff, temp.get(diff)-1);
				}
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
		
		for(Integer in : temp.keySet()) {
			int diff = target - in;
			if(temp.containsKey(diff) && temp.get(in) > 0) {
				while(temp.get(diff)>0) {
					List<Integer> pair = new ArrayList<>();
					pair.add(in);
					pair.add(diff);
					result.add(pair);
					temp.put(diff, temp.get(diff)-1);
				}
			}
		}
		
		return result;
	}

}
