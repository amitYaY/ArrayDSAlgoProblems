package com.ds.algo;

import java.util.HashMap;
import java.util.Map;

public class SolutionServices14 {

//	private static int[] nums1 = { 2, 4, 5, 8, 10 }; // 30
//	private static int[] nums2 = { 4, 6, 8, 9 };

//	private static int[] nums1 = { 1, 3, 5, 7, 9 }; // 109
//	private static int[] nums2 = { 3, 5, 100 };

//	private static int[] nums1 = { 1, 2, 3, 4, 5 }; // 40
//	private static int[] nums2 = { 6, 7, 8, 9, 10 };

//	private static int[] nums1 = { 1, 4, 5, 8, 9, 11, 19 }; // 61
//	private static int[] nums2 = { 2, 3, 4, 11, 12 };

//	private static int[] nums1 = { 3, 6, 11, 19, 27, 31 };
//	private static int[] nums2 = { 5, 9, 15, 17, 21, 28, 32 };

	private static int[] nums1 = { 7, 17, 22, 32, 39, 48, 53, 60, 66, 76, 86, 96, 106, 116 }; // 2316
	private static int[] nums2 = { 2, 12, 22, 32, 34, 39, 40, 49, 56, 66, 69, 73, 85, 96, 107, 118, 130, 140, 142, 146,
			149, 155, 166, 175, 187 };

	public static void main(String[] args) {
		SolutionServices14 service = new SolutionServices14();
		int result = service.maxSum(nums1, nums2);
		System.out.println("Result: " + result);

	}

	Map<Integer, Integer> map1 = new HashMap<>();
	Map<Integer, Integer> map2 = new HashMap<>();

	Map<Integer, Integer> dp = new HashMap<>();

	int[] maxArr = null;
	int[] minArr = null;

	public int maxSum(int[] nums1, int[] nums2) {
		int result = 0;

		maxArr = nums1.length >= nums2.length ? nums1 : nums2;
		minArr = nums1.length < nums2.length ? nums1 : nums2;

		for (int i = 0; i < maxArr.length; i++) {
			map1.put(maxArr[i], i);
		}

		for (int i = 0; i < minArr.length; i++) {
			map2.put(minArr[i], i);
		}

		int index2 = -1;
		if (map2.containsKey(maxArr[0])) {
			index2 = map2.get(maxArr[0]);
		}
		result = findMaxSum(0, index2);

		int index1 = -1;
		if (map1.containsKey(minArr[0])) {
			index1 = map1.get(minArr[0]);
		}
		int temp = findMaxSum(index1, 0);

		if (temp > result) {
			result = temp;
		}

		return result;
	}

	public int findMaxSum(int index1, int index2) {
		long result = 0;

		if (index1 >= 0) {
			long tempSum = 0;
			for (int i = index1; i < maxArr.length; i++) {
				tempSum += maxArr[i];
				if (map2.containsKey(maxArr[i])) {
					int s = 0;
					if (dp.containsKey(maxArr[i])) {
						s = dp.get(maxArr[i]);
					} else {
						s = findMaxSum(i + 1, map2.get(maxArr[i]) + 1);
					}
					dp.put(maxArr[i], s);
					tempSum += s;
					break;
				}
			}
			result = tempSum;
		}

		if (index2 >= 0) {
			int tempSum = 0;
			for (int i = index2; i < minArr.length; i++) {
				tempSum += minArr[i];
				if (map1.containsKey(minArr[i])) {
					int s = 0;
					if (dp.containsKey(minArr[i])) {
						s = dp.get(minArr[i]);
					} else {
						s = findMaxSum(map1.get(minArr[i]) + 1, i + 1);
					}
					dp.put(minArr[i], s);
					tempSum += s;
					break;
				}
			}
			if (tempSum >= result) {
				result = tempSum;
			}
		}

		return (int)(result % 1000000007);
	}

}
