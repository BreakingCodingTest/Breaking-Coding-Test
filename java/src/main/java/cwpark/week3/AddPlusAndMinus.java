package cwpark.week3;

import java.util.stream.IntStream;

/**
 * 3주차
 * https://programmers.co.kr/learn/courses/30/lessons/76501
 */
public class AddPlusAndMinus {

	public static void main(String[] args) {
		int ans;
		ans = solution(new int[] {4,7,12}, new boolean[]{true,false,true});
		System.out.println(ans); // 9
		ans = solution(new int[] {1,2,3}, new boolean[]{false,false,true});
		System.out.println(ans); // 0
		ans = short_solution(new int[] {4,7,12}, new boolean[]{true,false,true});
		System.out.println(ans); // 9
		ans = short_solution(new int[] {1,2,3}, new boolean[]{false,false,true});
		System.out.println(ans); // 0
	}

	public static int solution(int[] absolutes, boolean[] signs) {
		int answer = 0;
		for (int i = 0; i < absolutes.length; i++) {
			answer += absolutes[i] * ( signs[i] ? +1 : -1 );
		}
		return answer;
	}

	public static int short_solution(int[] absolutes, boolean[] signs) {
		return IntStream.range(0, absolutes.length)
					.map(i -> absolutes[i] * (signs[i] ? +1: -1))
					.reduce(0, Integer::sum);
	}
}
