package cwpark.week2;

import java.util.Arrays;

public class RotateBorderOfArray {

	public static void main(String[] args) {
		//6,6 [[2,2,5,4],[3,3,6,6],[5,1,6,3]] // [8, 10, 25]
		int[] ans;
		ans = solution(6,6,new int[][]{{2,2,5,4}, {3,3,6,6}, {5,1,6,3}});
		System.out.println(Arrays.toString(ans)); // 8, 10, 25

		// matrix 생성 테스트
		// int[][] mat = createMatrix(6,6);
		// Arrays.stream(mat).forEach(row -> System.out.println(Arrays.toString(row)));
		// int[][] mat = createMatrix(6, 6);
		// System.out.println(getMinOnTheBorder(mat, new int[]{2,2,5,4})); // 8
		// printMat(mat);
		// System.out.println(getMinOnTheBorder(createMatrix(6,6), new int[]{3,3,6,6})); // 10
	}

	private static void printMat(int[][] mat) {
		Arrays.stream(mat).forEach(row -> System.out.println(Arrays.toString(row)));
	}

	public static int[] solution(int rows, int columns, int[][] queries) {
		final int LENGTH = queries.length;
		int[] answer = new int[LENGTH];
		// create matrix
		int[][] matrix = createMatrix(rows, columns);

		for (int i = 0; i < LENGTH; i++) {
			answer[i] = getMinOnTheBorder(matrix, queries[i]);
		}
		return answer;
	}

	private static int[][] createMatrix(int rows, int columns) {
		int[][] matrix = new int[rows][columns];
		int element = 1;
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= columns; j++) {
				matrix[i-1][j-1] = element++;
			}
		}
		return matrix;
	}

	private static int getMinOnTheBorder(int[][] matrix, int[] query) {
		int rowStart = query[0] - 1;
		int rowEnd = query[2] - 1;
		int colStart = query[1] - 1;
		int colEnd = query[3] - 1;
		int startNum = matrix[rowStart][colStart];

		int min = Integer.MAX_VALUE;
		// 1. 첫 행
		int temp = Integer.MAX_VALUE;
		int before = Integer.MAX_VALUE;
		for (int i = colStart; i <= colEnd; i++) {
			temp = matrix[rowStart][i];
			matrix[rowStart][i] = before;
			before = temp;
			min = Math.min(min, before);
		}
		// 2. 마지막 열
		for (int i = rowStart+1; i <= rowEnd; i++) {
			temp = matrix[i][colEnd];
			matrix[i][colEnd] = before;
			before = temp;
			min = Math.min(min, before);
		}
		// 3. 마지막 행
		for (int i = colEnd-1; i >= colStart; i--) {
			temp = matrix[rowEnd][i];
			matrix[rowEnd][i] = before;
			before = temp;
			min = Math.min(min, before);
		}
		// 4. 첫 열
		for (int i = rowEnd-1; i >= rowStart; i--) {
			temp = matrix[i][colStart];
			matrix[i][colStart] = before;
			before = temp;
			min = Math.min(min, before);
		}

		return min;
	}
}
