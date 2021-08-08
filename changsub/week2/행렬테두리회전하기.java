import java.util.*;

public class 행렬테두리회전하기 {
    private static int[][] makeBaseMatrix(int rows,int columns){
        //가로방향으로 1씩 증가하는 행렬을 구현
        //문제와 동일한 조건을 위해 인덱스가 0이 아닌 1로 시작하는 행렬로 초기화
        int[][] baseMatrix = new int[rows+1][columns+1];
        int initNum = 1;
        for(int i = 1 ; i <= rows ; i++){
            for(int j = 1 ; j <= columns; j++){
                baseMatrix[i][j] = initNum++;
            }
        }
        return baseMatrix;
    }

    private static void printMat(int[][] mat) {
        Arrays.stream(mat).forEach(row -> System.out.println(Arrays.toString(row)));
    }

    //x value means 행, y value means 열
    /*
        rotate 진행과정 in 3 by 3 matrix
        1   2   3
        4   5   6
        7   8   9
        1) 왼쪽 변 회전 진행 -> 1은 위로 밀려서 없어지기 때문에 tmp에 저장
        4   2   3
        7   5   6
       []  8   9
        2) 아래쪽 변 회전 진행
        4   2   3
        7   5   6
        8   9  []
        3) 오른쪽 변 회전 진행
        4   2   []
        7   5   3
        8   9   6
        4) 윗변 회전 진행
        4   4   2
        7   5   3
        8   9   6
        5) (x1,y1) 값을 (x1, y1 + 1)에 대입 (Temp 사용)
    * */
    private static int rotateMatrix(int[][] matrix, int x1, int y1, int x2, int y2) {
        int temp = matrix[x1][y1];
        int min = temp;

        //왼쪽 변 회전 --> 위로 한칸씩 옮겨서 이동
        for (int i = x1; i < x2; i++) {
            matrix[i][y1] = matrix[i + 1][y1];
            min = Math.min(min, matrix[i][y1]);
        }
        //아랫변 회전
        for (int i = y1; i < y2; i++){
            matrix[x2][i] = matrix[x2][i+1];
            min = Math.min(min, matrix[x2][i]);
        }
        //오른쪽 변 회전
        for (int i = x2; i > x1; i--){
            matrix[i][y2] = matrix[i-1][y2];
            min = Math.min(min, matrix[i][y2]);
        }
        //윗변 회전 -->
        for (int i = y2; i > y1; i--){
            matrix[x1][i] = matrix[x1][i-1];
            min = Math.min(min, matrix[x1][i]);
        }
        matrix[x1][y1 + 1] = temp;
        return min;
    }
    public static int[] solution(int rows, int columns, int[][] queries){
        int length = queries.length; // 쿼리의 세로길이
        int[] answer = new int[length];
        int[][] baseMatrix = makeBaseMatrix(rows, columns);
        //queries의 행의 갯수만큼 회전을 시킴
        for(int i = 0 ; i < length ; i++){
            int[] aryQuery = queries[i];//옮겨야 하는 좌표를 1차원 배열로 새롭게 할당
            answer[i] = rotateMatrix(baseMatrix,aryQuery[0],aryQuery[1],aryQuery[2],aryQuery[3]);
        }
        printMat(baseMatrix);
        return answer;
    }

    public static void main(String[] args) {
        solution(3,3,new int[][]{{1,1,3,3}});
    }
}
