package com.ds.algo.twelve;

import java.util.ArrayList;
import java.util.List;

public class SolutionService {

	private static int[][] input = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };

	public static void main(String[] args) {
		SolutionService service = new SolutionService();
		service.setZeroes(input);
		
		for(int i=0; i<input.length; i++) {
			for (int j=0; j<input[0].length; j++) {
				System.out.print(input[i][j]);
			}
			System.out.println();
		}
	}

	public void setZeroes(int[][] matrix) {
		
		List<String> toVisit = new ArrayList<>();

		for(int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				if(matrix[i][j] == 0) {
					toVisit.add(i+","+j);
				}
			}
		}
		
		for(String index : toVisit) {
			String[] s = index.split(",");
			int i = Integer.parseInt(s[0]);
			int j = Integer.parseInt(s[1]);
			replaceWithZero(i, j, matrix);
		}
	}
	
	public void replaceWithZero(int i, int j, int[][] matrix) {
		
		for (int tempj = j;tempj<matrix[0].length; tempj++) {
			matrix[i][tempj] = 0;
		}
		for (int tempj = j;tempj>=0; tempj--) {
			matrix[i][tempj] = 0;
		}
		for (int tempi = i;tempi<matrix.length; tempi++) {
			matrix[tempi][j] = 0;
		}
		for (int tempi = i;tempi>=0; tempi--) {
			matrix[tempi][j] = 0;
		}
	}
}
