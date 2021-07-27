package cwpark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mouigosa {
	public static void main(String[] args) {
		int[] ans;
		ans = solution(new int[]{1,2,3,4,5}); //1
		System.out.println(Arrays.toString(ans));

		ans = solution(new int[]{1,3,2,4,2}); //1,2,3
		System.out.println(Arrays.toString(ans));
	}

	public static int[] solution(int[] answers) {
		int[] supo1 = new int[]{1, 2, 3, 4, 5};
		int[] supo2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
		int[] supo3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

		int[] scoreBoard = new int[3];

 		for (int i = 0; i < answers.length; i++) {
			scoreBoard[0] += (answers[i] == supo1[i % supo1.length]) ? 1 : 0;
			scoreBoard[1] += (answers[i] == supo2[i % supo2.length]) ? 1 : 0;
			scoreBoard[2] += (answers[i] == supo3[i % supo3.length]) ? 1 : 0;

		}
		int max = Math.max(Math.max(scoreBoard[0], scoreBoard[1]), scoreBoard[2]);

 		List<Integer> answer = new ArrayList<>();
 		if (scoreBoard[0] == max) answer.add(1);
 		if (scoreBoard[1] == max) answer.add(2);
 		if (scoreBoard[2] == max) answer.add(3);

 		return answer.stream().mapToInt(Integer::intValue).toArray();
	}
}
