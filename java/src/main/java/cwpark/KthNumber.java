package cwpark;

import java.util.Arrays;

public class KthNumber {
	public static void main(String[] args) {
		KthNumber kthNumber = new KthNumber();
		final int[] answ = kthNumber.solution(new int[] {1, 5, 2, 6, 3, 7, 4},
			new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});//[5, 6, 3])

		System.out.println(Arrays.toString(answ));

	}
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		for (int i = 0; i < commands.length; i++) {
			int[] sliced = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
			Arrays.sort(sliced);
			answer[i] = sliced[commands[i][2] - 1];
		}

		return answer;
	}
}
