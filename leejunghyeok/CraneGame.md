```java
package leejunghyeok;

import java.util.Stack;

/**
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
        Stack<Integer> stack = new Stack<>();
        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][move - 1] != 0) {
                    stack.push(board[j][move - 1]);
                    board[j][move - 1] = 0;
                    break;
                }
            }
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
```
