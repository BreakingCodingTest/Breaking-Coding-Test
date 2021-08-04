import java.util.*;

class 소수찾기 {
    public int solution(int n) {
        int answer = 0;

        for (int i = 2; i <= n; i++) {
            answer += isPrimeNum(i) ? 1 : 0;
        }
        return answer;
    }
    public static boolean isPrimeNum(int num){
        if(num < 2){
            return false;
        }
        //이 부분에 대한 설명 필요
        for(int i = 2; i*i <= num; i++){
            if(num%i == 0)
                return false;
        }
        return true;
    }
}