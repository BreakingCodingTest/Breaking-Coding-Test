package cwpark.week2;

public class FindingPrimeNumber {
	public static void main(String[] args) {
		// n = 2 ~ 1_000_000
		int ans;
		ans = solution(10);
		System.out.println(ans); //4
		ans = solution(5);
		System.out.println(ans); //3
	}

	public static int solution(int n) {
		int answer = 0;

		for (int i = 2; i <= n; i++) {
			answer += isPrime(i) ? 1 : 0;
		}

		return answer;
	}

	private static boolean isPrime(int num) {
		if (num < 2) return false;
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) return false;
		}
		return true;
	}
}
