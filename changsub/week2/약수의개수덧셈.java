public class 약수의개수덧셈 {
    /*
        약수의 갯수를 구하는 알고리즘을 먼저 구현
    */
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right ; i++){
            if(getMeasure(i) % 2 == 0){
                answer += i;
            }
            else{
                answer -= i;
            }
        }
        return answer;
    }
    public static int getMeasure(int num){
        int cnt = 0;
        for(int i = 1 ; i <= num ; i++){
            if(num % i == 0){
                cnt++;
            }
        }
        return cnt;
    }
}

