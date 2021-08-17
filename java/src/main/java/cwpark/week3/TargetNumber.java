package cwpark.week3;

/**
 * 3주차
 * https://programmers.co.kr/learn/courses/30/lessons/43165
 */
public class TargetNumber {

	public static void main(String[] args) {
		int ans;
		ans = solution(new int[]{1,1,1,1,1}, 3);
		System.out.println(ans); // 5
	}

	public static int solution(int[] numbers, int target) {
		int answer = 0;

		answer = dfs(numbers, target, numbers[0], 1) + dfs(numbers, target, -1 * numbers[0], 1);
		return answer;
	}

	private static int dfs(int[] numbers, int target, int sum, int i) {
		if (i == numbers.length) {
			if (sum == target) {
				return 1;
			} else {
				return 0;
			}
		}

		int result = 0;
		result += dfs(numbers, target, sum+numbers[i], i+1);
		result += dfs(numbers, target, sum-numbers[i], i+1);
		return result;
	}

}
