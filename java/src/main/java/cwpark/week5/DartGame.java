package cwpark.week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

// https://programmers.co.kr/learn/courses/30/lessons/17682
public class DartGame {
	public static void main(String[] args) {
		// System.out.println(DartResult.parseScore(new char[]{'1', '0'}, 0)); // 10
		// System.out.println(DartResult.parseScore(new char[]{'1', '0'}, 1)); // 0
		//
		// System.out.println(DartResult.parseBonus(new char[]{'S', '0'}, 0)); // S
		// System.out.println(DartResult.parseBonus(new char[]{'D', '0'}, 0)); // D
		// System.out.println(DartResult.parseBonus(new char[]{'T', '0'}, 0)); // T

		// System.out.println(DartResult.calculateNextIndex(1, 10)); // 3
		// System.out.println(DartResult.calculateNextIndex(1, 9)); // 2
		// System.out.println(DartResult.calculateNextIndex(1, 10, OPTION.NONE)); // 1
		// System.out.println(DartResult.calculateNextIndex(1, 10, OPTION.STAR)); // 2
		// System.out.println(DartResult.calculateNextIndex(1, 1, OPTION.STAR)); // 1
	}


	public int solution(String dartResult) {
		// 점수 | 보너스 | [옵션]
		// 0~10 | S,D,T | *, #, 없음

		// 파싱 작업
		List<DartResult> parsedDarResultList = DartResult.parseDartResult(dartResult);

		// 점수 계산
		return DartResult.getTotalScore(parsedDarResultList);
	}

	static class DartResult {
		int score;
		BONUS bonus;
		OPTION option;

		public DartResult(int score, BONUS bonus, OPTION option) {
			this.score = score;
			this.bonus = bonus;
			this.option = option;
		}

		private DartResult() {
		}

		public static List<DartResult> parseDartResult(String dartResult) {
			List<DartResult> dartResults = new ArrayList<>();
			char[] dartResultCharArray = dartResult.toCharArray();

			int i = 0;
			while(i < dartResultCharArray.length) {
				DartResult parsedResult = new DartResult();
				parsedResult.score = parseScore(dartResultCharArray, i);
				i = calculateNextIndex(i, parsedResult.score);

				parsedResult.bonus = parseBonus(dartResultCharArray, i);
				i += 1;

				parsedResult.option = parseOption(dartResultCharArray, i);
				i = calculateNextIndex(i, dartResultCharArray.length, parsedResult.option);
				dartResults.add(parsedResult);

			}
			return dartResults;
		}

		private static int calculateNextIndex(int i, int score) {
			return score == 10 ? i+2 : i+1;
		}

		private static int calculateNextIndex(int i, int size, OPTION option) {
			return size <= i || option == OPTION.NONE ? i : i+1;
		}

		private static OPTION parseOption(char[] dartResultCharArray, int index) {
			return dartResultCharArray.length <= index || Character.isDigit(dartResultCharArray[index]) ? OPTION.NONE : OPTION.of(dartResultCharArray[index]);
		}

		private static BONUS parseBonus(char[] dartResultCharArray, int index) {
			return BONUS.valueOf(String.valueOf(dartResultCharArray[index]));
		}

		private static int parseScore(char[] ch, int index) {
			int result = 0;
			if (!Character.isDigit(ch[index])) {
				throw new RuntimeException("character is not digit, " + ch[index]);
			}
			result = Integer.parseInt(String.valueOf(ch[index]));
			// 숫자 10 일 경우, 다음 자리까지 검사
			if (ch.length > index+1 && Character.isDigit(ch[index+1])) {
				result = 10;
			}
			return result;
		}

		public static int getTotalScore(List<DartResult> parsedDarResultList) {
			LinkedList<Integer> scores = new LinkedList<>();

			for (DartResult dartResult: parsedDarResultList) {
				scores.add(
					((int) Math.pow(dartResult.score, dartResult.bonus.power)) * (dartResult.option == OPTION.ACHA ? -1 : 1)
				);
				// star 계산
				if (dartResult.option == OPTION.STAR && !scores.isEmpty()) {
					int currentScore = scores.pollLast();
					// 이전 스코어가 존재한다면 2배 적용
					if (!scores.isEmpty()) {
						scores.addLast(scores.pollLast() * 2);
					}
					scores.addLast(currentScore * 2);
				}
			}

			return scores.stream().mapToInt(Integer::intValue).sum();
		}

		@Override
		public String toString() {
			return "DartResult{" +
				"score=" + score +
				", bonus=" + bonus +
				", option=" + option +
				'}';
		}
	}

	enum BONUS {
		S(1),D(2),T(3);

		int power;

		BONUS(int power) {
			this.power = power;
		}
	}

	enum OPTION {
		STAR('*'), ACHA('#'), NONE('0');

		char ch;
		OPTION(char ch) {
			this.ch = ch;
		}

		public static OPTION of(char c) {
			return c == STAR.ch ? STAR :
					c == ACHA.ch ? ACHA :
						NONE;
		}
	}

	/**
	 * TEST
	 */

	@Test
	void testParsing() {
		System.out.println(DartResult.parseDartResult("1S2D*3T"));
		System.out.println(DartResult.parseDartResult("10D*10T"));
		System.out.println(DartResult.parseDartResult("1D2S#10S"));
		System.out.println(DartResult.parseDartResult("1D#2S*3S"));

	}

	@Test
	void testGetTotalScore() {
		int ans;
		ans = DartResult.getTotalScore(Arrays.asList(
			new DartResult(1, BONUS.S, OPTION.STAR),
			new DartResult(2, BONUS.T, OPTION.STAR),
			new DartResult(3, BONUS.S, OPTION.NONE)
		));
		System.out.println(ans); //23

		//1D#2S*3S
		ans = DartResult.getTotalScore(Arrays.asList(
			new DartResult(1, BONUS.D, OPTION.ACHA),
			new DartResult(2, BONUS.S, OPTION.STAR),
			new DartResult(3, BONUS.S, OPTION.NONE)
		));
		System.out.println(ans); //5

		//1D2S#10S
		ans = DartResult.getTotalScore(Arrays.asList(
			new DartResult(1, BONUS.D, OPTION.NONE),
			new DartResult(2, BONUS.S, OPTION.ACHA),
			new DartResult(10, BONUS.S, OPTION.NONE)
		));
		System.out.println(ans); //9
	}

}
