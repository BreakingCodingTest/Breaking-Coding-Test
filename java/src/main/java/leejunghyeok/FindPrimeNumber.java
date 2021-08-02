package leejunghyeok;

public class FindPrimeNumber {
    public static void main(String[] args) {
        System.out.println(solution(10));
    }
    public static int solution(int n) {
        int answer = 0;
        boolean[] checkPrime = new boolean[n + 1];
        for(int i=2; i < checkPrime.length; i++) {
            for(int j=i*2; j < checkPrime.length; j += i) {
                checkPrime[j] = true;
            }
        }
        for(int i=2; i<checkPrime.length; i++) {
            if(!checkPrime[i]) {
                answer++;
            }
        }
        return answer;
    }
}
