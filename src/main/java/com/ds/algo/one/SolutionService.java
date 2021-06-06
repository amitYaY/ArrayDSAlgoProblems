package com.ds.algo.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionService {
	
	
	private static final Integer[] UNSORTED_INPUT = {1,5,24,75,34,38,89,54,26,91,17,66,67,68,69,70,9,83};
	private static final Integer[] SORTED_INPUT = {1,5,9,17,24,26,34,38,54,66,67,68,69,70,75,83,89,91};
			

	public static void main(String[] args) {

		SolutionService solutionService = new SolutionService();

		System.out.println("Missing Numbers from Unsorted List");
		System.out.println(Arrays.asList(solutionService.findMissingNumberFromUnsortedIntList(UNSORTED_INPUT)));

		System.out.println("###########################################################################");

		System.out.println("Missing Numbers from Sorted List");
		System.out.println(Arrays.asList(solutionService.findMissingNumberFromUnsortedIntList(SORTED_INPUT)));

	}
	
	public Integer[] findMissingNumberFromUnsortedIntList(Integer[] unsortedList) {
		//1st Approach: Sort the Array and Call findMissingNumberFromSortedIntList
		
		//2nd Create Map with Input Number as Key and Value. Iterate through 1-100 and check if key is null. That's the missing number
		List<Integer> result  = new ArrayList<>();
		
		Map<Integer, Integer> inputMap = new HashMap<>();
		
		for(Integer input : unsortedList) {
			inputMap.put(input, input);
		}
		
		for(int i=1; i<=100; i++) {
			if(!inputMap.containsKey(i)) {
				result.add(i);
			}
		}
		
		return result.toArray(new Integer[100-unsortedList.length]);
	}
	
	public Integer[] findMissingNumberFromSortedIntList(Integer[] sortedList) {
		List<Integer> result  = new ArrayList<>();
		
		int maxInput = 100 > sortedList[sortedList.length-1] ? sortedList[sortedList.length-1] : 100;
		
		for(int i=1, j=0; i<=maxInput ; i++) {
			if(i!=sortedList[j]) {
				result.add(i);
			} else {
				j++;
			}
		}
		
		for(int i = maxInput+1; i<=100; i++) {
			result.add(i);
		}
		
		return result.toArray(new Integer[100-sortedList.length]);
	}

}
