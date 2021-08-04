public class 행렬테두리회전하기 {
    public static int[][] makeBaseMatrix(int rows,int columns){
        //가로방향으로 1씩 증가하는 행렬을 구현
        //문제와 동일한 조건을 위해 인덱스가 0이 아닌 1로 시작하는 행렬로 초기화
        int initNum = 1;
        int[][] baseMatrix = new int[rows+1][columns+1];
        for(int i = 1 ; i < rows ; i++){
            for(int j = 1 ; j < columns; j++){
                baseMatrix[i][j] = initNum;
                initNum++;
            }
        }
        return baseMatrix;
    }
    public static int[] solution(int rows, int columns, int[][] queries){
        int length = queries.length; // 쿼리의 세로길이
        int[] answer = new int[length];
        int[][] baseMatrix = makeBaseMatrix(rows, columns);
        for (int[] query : queries) {
            int tmp = baseMatrix[query[0]][query[1]];
            for(int i = query[0]; i < query[2] ; i++){
                baseMatrix[]
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        solution(6,6,new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}});
    }
}
