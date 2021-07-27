package leejunghyeok;

import java.util.Stack;

/**
 * 처음에 작성한 코드 stack의 크기에 따라 로직을 다르게 함
 * 뽑힌 인형을 저장하는 공간인 stack의 크기가 0일경우 값을 넣고 뽑힌 인형의 위치 값을 0으로 변경
 * 0이 아닌경우 맨위에 있는 것을 pick 변수에 넣고 뽑힌 인형의 위치를 0으로 변경
 * 그 다음에 pick의 값에 따라서 stack의 맨위 값과 비교하여 +2 또는 그냥 넘어감
 *
 * int cnt = 0;
 *         Stack<Integer> stack = new Stack<>();
 *         for (int move : moves) {
 *             int pick = 0;
 *             for (int j = 0; j < board.length; j++) {
 *                 if (stack.size() == 0 && board[j][move - 1] != 0) {
 *                     stack.push(board[j][move - 1]);
 *                     board[j][move - 1] = 0;
 *                     break;
 *                 } else if (stack.size() != 0 && board[j][move - 1] != 0) {
 *                     pick = board[j][move - 1];
 *                     board[j][move - 1] = 0;
 *                     break;
 *                 }
 *             }
 *
 *             if (pick != 0 && pick == stack.peek()) {
 *                 stack.pop();
 *                 pick = 0;
 *                 cnt += 2;
 *             } else if (pick != 0 && pick != stack.peek()) {
 *                 stack.push(pick);
 *                 pick = 0;
 *             }
 *         }
 *         return cnt;
 */
public class CraneGame {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        int[][] board1 = {{1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}};
        int[] moves1 = {1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6};
        System.out.println(solution(board, moves));
        System.out.println(solution(board1, moves1));
    }
    public static int solution(int[][] board, int[] moves) {
        int cnt = 0;
        //걸린 인형들을 저장하기 위한 공간
        Stack<Integer> stack = new Stack<>();

        //위치 배열을 반복하면서 가장위에 있는 인형을 찾기 위한 2중 반복문
        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                // 맨위에 있는 인형일경우 stack에 저장 후 해당 인형 위치 0 으로 변경
                if (board[j][move - 1] != 0) {
                    stack.push(board[j][move - 1]);
                    board[j][move - 1] = 0;
                    break;
                }
            }
            //크기가 2이상 인지 확인하고 맞으면 맨위 2개를 꺼내서 확인 맞으면 +2점 아니면 다시 넣는다.
            if(stack.size() > 1) {
                int top = stack.pop();
                int secondTop = stack.pop();
                if(top == secondTop) {
                    cnt += 2;
                } else {
                    stack.push(secondTop);
                    stack.push(top);
                }
            }
        }
        return cnt;
    }
}
