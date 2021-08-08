package cwpark.week2;

public class NumberOfDivisor {
	public static void main(String[] args) {
		// int counts;
		// counts = getNumberOfDivisor(13);
		// System.out.println(counts); // 2
		// counts = getNumberOfDivisor(14);
		// System.out.println(counts); // 4

		int answer;
		answer = solution(13, 17); //43
		System.out.println(answer);
		answer = solution(24, 27); //52
		System.out.println(answer);

	}

	public static int solution(int left, int right) {
		int answer = 0;

		for (int i = left; i <= right; i++) {
			answer += getNumberOfDivisor(i) % 2 == 0 ? +i : -i;
		}

		return answer;
	}

	private static int getNumberOfDivisor(int num) {
		int count = 0;
		for (int i = 1; i * i <= num; i++) {
			if (i * i == num) {
				count += 1;
			} else if (num % i == 0) {
				count += 2;
			}
		}

		return count;
	}
}
