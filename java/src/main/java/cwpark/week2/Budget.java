package cwpark.week2;

import java.util.Arrays;

public class Budget {

	public static void main(String[] args) {
		//[1,3,2,5,4]	9 3
		int ans;
		ans = solution(new int[]{1,3,2,5,4}, 9); // 3
		System.out.println(ans);
		ans = solution(new int[]{2,2,3,3}, 10); // 4
		System.out.println(ans);
	}

	public static int solution(int[] d, int budget) {
		Arrays.sort(d);
		int sum = 0;
		int available = 0;
		for (int amount: d) {
			sum += amount;
			available += 1;

			if (sum == budget) {
				break;
			}
			if (sum > budget) {
				sum -= amount;
				available -= 1;
			}
		}

		return available;
	}
}
