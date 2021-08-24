package cwpark.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//https://programmers.co.kr/learn/courses/30/lessons/83201
public class MutualRating {

	public static void main(String[] args) {
		//testRemoveOwnRating();
		/*
		[[100,90,98,88,65],[50,45,99,85,77],[47,88,95,80,67],[61,57,100,80,65],[24,90,94,75,65]]	"FBABD"
		[[50,90],[50,87]]	"DA"
		[[70,49,90],[68,50,38],[73,31,100]]	"CFD"
		 */
		String ans;
		ans = solution(new int[][] {{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}});
		System.out.println(ans); // FBABD
	}

	public static String solution(int[][] scores) {
		StringBuilder answer = new StringBuilder();

		for (int i = 0; i < scores.length; i++) {
			// 각 학생들의 평균을 구하기 위해 "열(column)" 기준 리스트로 모음
			List<Integer> studentRating = getStudentRating(i, scores);
			// 학생들이 자기 자신을 평가한 점수가 유일한 최고점 또는 유일한 최저점이라면 그 점수는 제외
			List<Integer> removedOwnRating = removeBoundaryOwnRating(i, studentRating);
			// 평균과 학점을 구함
			answer.append(rating(average(removedOwnRating)));
		}
		return answer.toString();
	}

	private static List<Integer> getStudentRating(int studentNumber, int[][] allScores) {
		List<Integer> scores = new ArrayList<>();
		for (int i = 0; i < allScores[studentNumber].length; i++) {
			scores.add(allScores[i][studentNumber]);
		}
		return scores;
	}

	private static List<Integer> removeBoundaryOwnRating(int studentNumber, List<Integer> scores) {
		// 학생 자신의 점수만 제외한 점수 리스트
		List<Integer> scoresExceptOwn = IntStream.range(0, scores.size())
										.filter(i -> i != studentNumber)
										.map(scores::get)
										.boxed()
										.collect(Collectors.toList());

		int min = scoresExceptOwn.stream().reduce(Integer.MAX_VALUE, Integer::min);
		int max = scoresExceptOwn.stream().reduce(Integer.MIN_VALUE, Integer::max);

		// | min---n1---n2---...---max |
		// min 보다 크거나 같고 max 보다 작거나 같으면 최종 반환 리스트에 포함
		final int studentOwnScore = scores.get(studentNumber);
		if (studentOwnScore >= min && studentOwnScore <= max) {
			scoresExceptOwn.add(studentOwnScore);
		}

		return scoresExceptOwn;
	}

	private static int average(List<Integer> scores) {
		int avg = 0;
		for (int score: scores) {
			avg += score;
		}
		return avg / scores.size();
	}

	private static String rating(int avg) {
		return avg >= 90 ? "A" :
				avg >= 80 ? "B" :
					avg >= 70 ? "C" :
						avg >= 50 ? "D" :
							"F";
	}

	// test
	private static void testRemoveOwnRating() {
		// (100), 90,98,88,65 (0번 학생)
		System.out.println(removeBoundaryOwnRating(0, Arrays.asList(100, 90, 98, 88, 65)));
		// 90,(45),88,57,90 (1번 학생)
		System.out.println(removeBoundaryOwnRating(1, Arrays.asList(90,45,88,57,90)));
		// 90,45,88,57,90 (0번 학생)
		System.out.println(removeBoundaryOwnRating(0, Arrays.asList(90,45,88,57,90)));
		// 98,99,95,100,94(2번 학생)
		System.out.println(removeBoundaryOwnRating(2, Arrays.asList(98,99,95,100,94)));

	}
}
