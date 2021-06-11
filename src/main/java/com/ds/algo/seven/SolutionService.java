package com.ds.algo.seven;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SolutionService {
	
	private static final Integer[] INPUT = { 1, 12, 3, 5, 67, 56, 35, 56, 53, 2, 34, 5, 45, 3, 1, 65, 56};
	

	public static void main(String[] args) {
		SolutionService service = new SolutionService();
		System.out.println(service.findAllDuplicates(INPUT));

	}
	
	private List<Integer> findAllDuplicates(Integer[] input) {

		Map<Integer, Integer> temp = new HashMap<>();
		
		for (Integer in : input) {
			if (temp.containsKey(in)) {
				temp.put(in, temp.get(in) + 1);
			} else {
				temp.put(in, 1);
			}
		}
		return temp.entrySet().stream().filter(entry -> entry.getValue()>1).map(Map.Entry::getKey).collect(Collectors.toList());
	}
}
