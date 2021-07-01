package com.ds.algo.eleven;

import java.util.HashMap;
import java.util.Map;

public class SolutionService {

	private static int[] input = { 0, 1, 0 };

	public static void main(String[] args) {
		SolutionService service = new SolutionService();
		int result = service.findMaxLength(input);
		System.out.println("Result: " + result);
	}

	public int findMaxLength(int[] nums) {
		int result = 0;

		int len = nums.length;

		int sum = 0;

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < len; i++) {

			if (nums[i] == 0) {
				nums[i] = -1;
			}

			sum += nums[i];

			if (sum == 0) {
				result = result > i + 1 ? result : i + 1;
			}

			if (!map.containsKey(sum)) {
				map.put(sum, i);
			} else {
				int index = map.get(sum);
				int diff = i + 1 - index;
				result = result > diff ? result : diff;
			}

		}

		return result;
	}

}
