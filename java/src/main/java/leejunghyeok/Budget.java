package leejunghyeok;

import java.util.Arrays;

public class Budget {
    public static void main(String[] args) {
        int[] d = {1, 3, 2, 5, 4};
        int budget = 9;
        System.out.println(solution(d, budget));
    }
    public static int solution(int[] d, int budget) {
        Arrays.sort(d);
        int answer = 0;

        for (int j : d) {
            budget -= j;
            if (budget >= 0) {
                answer++;
            } else {
                break;
            }
        }

        return answer;
    }
}
