package cwpark.week1;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DollCraneGame {
	public static void main(String[] args) {
		//[[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]	[1,5,3,5,1,2,1,4]	4
		int solution;
		solution = solution(
			new int[][] {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}},
			new int[] {1, 5, 3, 5, 1, 2, 1, 4});
		System.out.println(solution);
		solution = solution(
			new int[][] {{0, 0}, {0, 0}, {0, 2}, {3, 2}, {3, 5}},
			new int[] {1,1,1,1,1});//
		System.out.println(solution);
	}
	public static int solution(int[][] board, int[] moves) {

		List<LinkedList<Integer>> rows = IntStream.range(0, board[0].length)
			.mapToObj(i -> new LinkedList<Integer>())
			.collect(Collectors.toList());

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				int doll = board[i][j];
				// 0일 경우 저장하지 않는다.
				if (doll == 0) {
					continue;
				}
				rows.get(j).addFirst(doll);
			}
		}

		int pang = 0; // 터트린 횟수

		// 바구니에 담기
		LinkedList<Integer> resultDollBag = new LinkedList<>();
		for (int move: moves) {

			// 인형을 집을 곳이 비어 있을 경우 다음 move 진행
			LinkedList<Integer> row = rows.get(move - 1);
			if (row.isEmpty()) {
				continue;
			}
			// 중복 제거
			int doll = row.pollLast();
			if (!resultDollBag.isEmpty() && doll == resultDollBag.peekLast()) {
				pang+=2;
				resultDollBag.removeLast();
				continue;
			}
			resultDollBag.add(doll);
		}

		return pang;
	}
}
