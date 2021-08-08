package leejunghyeok;

import java.util.ArrayList;
import java.util.List;

public class MatrixRotation {
    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2, 2, 5, 4}, {3,3,6,6}, {5,1,6,3}};
        solution(rows, columns, queries);
    }
    public static int[] solution(int rows, int columns, int[][] queries) {
        List<Integer> results = new ArrayList<>();
        int[][] board = new int[rows][columns];
        int cnt = 1;
        creatMatrix(rows, columns, board, cnt);
        for(int[] query : queries) {
            results.add(rotateMatrix(board, query));
        }
        int[] answer = new int[results.size()];
        System.out.println(results);
        for (int i = 0; i < answer.length; i++) {
            answer[i] = results.get(i);
        }
        return answer;
    }

    private static void creatMatrix(int rows, int columns, int[][] board, int cnt) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = cnt++;
            }
        }
    }

    private static int rotateMatrix(int[][] board, int[] query) {
        int min = board.length * board[0].length;
        int startRow = query[0] - 1;
        int startColumn = query[1] - 1;
        int endRow = query[2] - 1;
        int endColumn = query[3] - 1;

        int now = Integer.MAX_VALUE;
        int before = board.length * board.length;
        for (int i = startColumn; i <= endColumn; i++) {
            now = board[startRow][i];
            board[startRow][i] = before;
            before = now;
            min = Math.min(before, min);
        }
        for (int i = startRow+1; i <= endRow; i++) {
            now = board[i][endColumn];
            board[i][endColumn] = before;
            before = now;
            min = Math.min(before, min);
        }
        for (int i = endColumn-1; i >= startColumn; i--) {
            now = board[endRow][i];
            board[endRow][i] = before;
            before = now;
            min = Math.min(before, min);
        }for (int i = endRow-1; i >= startRow; i--) {
            now = board[i][startColumn];
            board[i][startColumn] = before;
            before = now;
            min = Math.min(before, min);
        }
        return min;
    }
}
/**
 * // 처음 생각 했던 풀이
 * class Solution {
 *     public int[] solution(int rows, int columns, int[][] queries) {
 *         List<Integer> results = new ArrayList<>();
 *         int[][] board = new int[rows][columns];
 *         int cnt = 1;
 *         for (int i = 0; i < rows; i++) {
 *             for (int j = 0; j < columns; j++) {
 *                 board[i][j] = cnt++;
 *             }
 *         }
 *
 *         for(int[] query : queries) {
 *             results.add(rotateMatrix(board, query));
 *         }
 *         int[] answer = new int[results.size()];
 *         for (int i = 0; i < answer.length; i++) {
 *             answer[i] = results.get(i);
 *         }
 *         return answer;
 *     }
 *
 *     private static int rotateMatrix(int[][] board, int[] query) {
 *         int min = board.length * board[0].length;
 *         int temp = board[query[0]-1][query[3]-1];
 *         int temp1 = board[query[2]-1][query[3]-1];
 *         int temp4 = board[query[2]-1][query[1]-1];
 *         for (int i = query[3] - 1; i > query[1]-1; i--) {
 *             board[query[0] - 1][i] = board[query[0] - 1][i-1];
 *             min = Math.min(min, board[query[0] - 1][i]);
 *         }
 *         for (int i = query[2] - 1; i > query[0]; i--) {
 *             board[i][query[3] - 1] = board[i - 1][query[3] - 1];
 *             min = Math.min(min, board[i][query[3] - 1]);
 *         }
 *         board[query[0]][query[3]-1] = temp;
 *
 *         for (int i = query[1]; i < query[3]-1; i++) {
 *             board[query[2] - 1][i - 1] = board[query[2] - 1][i];
 *             min = Math.min(min, board[query[2] - 1][i - 1]);
 *         }
 *         board[query[2]-1][query[3]-2] = temp1;
 *         for (int j = query[0]-1; j < query[2]-1; j++) {
 *             board[j][query[0]-1] = board[j+1][query[0]-1];
 *             min = Math.min(min, board[j][query[0]-1]);
 *         }
 *         board[query[2]-2][query[1]-1] = temp4;
 *         min = Math.min(min, Math.min(temp1, Math.min(temp, temp4)));
 *         return min;
 */