import java.util.Stack;

public class CrainGame {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> res_stack = new Stack<>();//결과를 반영할 스택, 인형을 뽑은 후 인형을 쌓는 스택이라고 이해하기 
        int peek_value = -1;
        int count = 0;
        int row = 0;
        int col = 0;
        boolean checkFlag = true; //반복문에서 세로열로 한번만 접근했는지 체크
        /*
            move를 증가 시켜가면서 몇번째 열로 접근 할지를 결정한다.
            Line 18 : 만약 보드의 숫자가 0이 아니라면, 즉 숫자가 들어가 있다 == 인형이 존재하면,
            res_stack에 해당 값을 푸쉬하고 해당 스택을 peek()해서 연속으로 같은수가 두번 들어가는 체크한다.
        */
        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                if(board[j][move - 1] != 0){
                    res_stack.push(board[j][move - 1]);
                    if (peek_value == res_stack.peek()) {
                        doublePop(res_stack);
                        count++;
                    }
                    if(res_stack.size() == 0){
                        peek_value = -1;
                    }else{
                        peek_value = res_stack.peek();
                    }
                    row = j;
                    col = move - 1;
                    break;
                }
            }
            board[row][col] = 0; //인형을 꺼낸 인덱스의 값을 0으로 설정
        }
        answer = 2 * count;
        return answer;
    }

    public static void doublePop(Stack<Integer> stack){
        stack.pop();
        stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int [][]{{0,0,1,0,0},{0,0,1,0,0},{0,2,1,0,0},{0,2,1,0,0},{0,2,1,0,0}},new int [] {1,2,3,3,2,3,1}));
    }
}
