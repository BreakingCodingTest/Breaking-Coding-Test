package leejunghyeok;

public class SumFactors {
    public static void main(String[] args) {
        System.out.println(solution(13, 17));
    }
    public static int solution(int left, int right) {
        int cnt = 0;
        int answer = 0;
        for (int i = left; i <= right; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (j * j == i) {
                    cnt += 1;
                } else if (i % j == 0) {
                    cnt += 2;
                }
            }
            if(cnt % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
            cnt = 0;
        }
        return answer;
    }
}
