package cwpark.week3;

/**
 * 3주차 추가문제
 * https://programmers.co.kr/learn/courses/30/lessons/82612
 */
public class InsufficientMoney {

	public static void main(String[] args) {
		long ans;
		ans = solution(3,20, 4);
		System.out.println(ans); // 10
		ans = solution(3,20, 1);
		System.out.println(ans); // 0
		ans = solution(3,3, 1);
		System.out.println(ans); // 0
		ans = solution(3,6, 1);
		System.out.println(ans); // 0
		ans = solution(2500,6, 1);
		System.out.println(ans); // 2494
		ans = solution(2500,2501, 1);
		System.out.println(ans); // 0
		ans = solution(2500,2499, 1);
		System.out.println(ans); // 1
		ans = solution(2500, 1_000_000_000, 2500);
		System.out.println(ans); // 6815625000
	}

	public static long solution(int price, int money, int count) {
		long amount = 0;
		long shortage = money;
		for (int i = 0; i < count; i++) {
			amount += price;
			shortage -= amount;
		}
		return shortage > 0 ? 0 : Math.abs(shortage);
	}
}
