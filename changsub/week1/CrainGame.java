import java.util.Stack;

public class CrainGame {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> res_stack = new Stack<>();//결과를 반영할 스택
        /*
            n*n 매트릭스에서 세로열의 연속적인 두 원소 중,
            작은 인데스가 0이고 큰 인덱스가 0이 아닌 원소가
            해당 세로열 중에서 가장 상위에 위치한 원소이다.
            즉, 인형뽑기 시 해당열에서 뽑아져 올라오는 원소이다.
        */
        int peek_value = -1;
        int count = 0;
        int row = 0;
        int col = 0;
        boolean checkFlag = true; //반복문에서 세로열로 한번만 접근했는지 체크
        //위에까지 인형이 차 있는경우 구현하기
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
        //System.out.println(solution(new int [][]{{2,0,1},{1,0,1},{3,3,2}},new int [] {2,1,3,3}));
        //System.out.println(solution(new int [][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}},new int [] {1,5,3,5,1,2,1,4}));
        System.out.println(solution(new int [][]{{0,0,1,0,0},{0,0,1,0,0},{0,2,1,0,0},{0,2,1,0,0},{0,2,1,0,0}},new int [] {1,2,3,3,2,3,1}));


    }
}
