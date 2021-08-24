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


        //while문으로 최대 지수 찾음
        while(Math.pow(3, max) <= n) {
            max++;
        }
        //최대 지수 크기 만큼의 배열 만듬
        int[] ternaries = new int[max];

        //배열의 반대로 반복
        for (int i = max-1; i >= 0; i--) {
            //최대지수의 값 (i)번째의 배열에 몇번 나뉘어 지는지 계산하고
            ternaries[i] = (int) (num / Math.pow(3, i));
            // 최대지수로 나눈값의 나머지를 최신화
            num = (int) (num % Math.pow(3, i));
            //만약 나눠진 값이라면
            if (ternaries[i] != 0) {
                //정답에 원래 지수 크기의 반대로 계산하여 더함
                answer += Math.pow(3, max - i - 1) * ternaries[i];
            }
        }

        return answer;
    }
}
