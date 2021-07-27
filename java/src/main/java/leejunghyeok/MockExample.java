package leejunghyeok;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockExample {
    public static void main(String[] args) {
        int[] answers1 = {1,2,3,4,5,1,2,3,4,5,1,2,3,4,5};
        int[] answers2 = {1,3,2,4,2};
        System.out.println(Arrays.toString(solution(answers1)));
        System.out.println(Arrays.toString(solution(answers2)));
    }

    public static int[] solution(int[] answers) {
        List<Integer> results = new ArrayList<>();
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int firstScore = 0;
        int secondScore = 0;
        int thirdScore = 0;
        int max = 0;
        for(int i=0; i < answers.length; i++) {
            if(first[i % first.length] == answers[i]) {
                firstScore++;
            }
            if(second[i % second.length] == answers[i]) {
                secondScore++;

            }
            if(third[i % third.length] == answers[i]) {
                thirdScore++;
            }
        }
        max = Math.max(firstScore, Math.max(secondScore, thirdScore));

        if(firstScore == max && firstScore != 0) {
            results.add(1);
        }
        if (secondScore == max && secondScore != 0) {
            results.add(2);
        }
        if(thirdScore == max && thirdScore != 0) {
            results.add(3);
        }
        int[] resultArr = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            resultArr[i] = results.get(i);
        }

        return resultArr;
    }
}
