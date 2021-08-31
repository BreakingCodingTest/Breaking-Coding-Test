package cwpark.week5;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// https://programmers.co.kr/learn/courses/30/lessons/68935
public class FlipTernary {
	public static void main(String[] args) {
//		testConvertTo10();

		int ans;

		ans = solution(45);
		System.out.println(ans); // 7

		ans = solution(125);
		System.out.println(ans); //229

	}
	public static int solution(int n) {
		int quotient = n;
		int remainder;
		LinkedList<Integer> ternary = new LinkedList<>();
		while (quotient != 0) {
			remainder = quotient % 3;
			quotient /= 3;
			ternary.addFirst(remainder);
		}

		// 10진법 변환
		return convertTo10(ternary);
	}

	private static int convertTo10(List<Integer> ternary) {
		int digit = 0;
		int answer = 0;
		for (int num: ternary) {
			answer += Math.pow(3, digit) * num;
			digit += 1;
		}
		return answer;
	}

	private static void testConvertTo10() {
		int ans;
		final LinkedList<Integer> testcase1 = new LinkedList<>(Arrays.asList(2, 2, 1, 1, 1));
		Collections.reverse(testcase1);
		ans = convertTo10(testcase1);
		System.out.println(ans); //229
	}
}
