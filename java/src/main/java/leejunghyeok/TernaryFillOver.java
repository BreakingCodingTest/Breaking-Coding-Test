package leejunghyeok;

import java.util.ArrayList;
import java.util.List;

public class TernaryFillOver {
    public static void main(String[] args) {
        System.out.println(solution(125));
    }

    public static int solution(int n) {
        int answer = 0;
        int max = 0;
        int num = n;

        while(Math.pow(3, max) <= n) {
            max++;
        }
        int[] ternaries = new int[max];

        for (int i = max-1; i >= 0; i--) {
            ternaries[i] = (int) (num / Math.pow(3, i));
            num = (int) (num % Math.pow(3, i));
            if (ternaries[i] != 0) {
                answer += Math.pow(3, max - i - 1) * ternaries[i];
            }
        }

        return answer;
    }
}
