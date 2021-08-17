package leejunghyeok;

import java.util.*;

public class failure {
    public static void main(String[] args) {

        int[] stages1 = {2, 1, 2, 3, 4, 5};
        int[] stages2 = {1, 1, 1, 1, 1};
        int[] stages3 = {4, 4, 4, 4};

        System.out.println(solution(5, stages1));
        System.out.println(solution(5, stages2));
        System.out.println(solution(4, stages3));

    }
    public static int[] solution(int N, int[] stages) {
        Map<Integer, Double> stageFailure = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            double failCnt = 0;
            double clearCnt = 0;
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] == i) {
                    failCnt++;
                } else if (stages[j] > i) {
                    clearCnt++;
                }
            }
            if (failCnt + clearCnt == 0) {
                stageFailure.put(i, failCnt);
                continue;
            }
            stageFailure.put(i, failCnt / (failCnt + clearCnt));
        }
        List<Map.Entry<Integer, Double>> entryFailures = new ArrayList<>(stageFailure.entrySet());
        entryFailures.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));
        System.out.println(entryFailures);
        int[] answer = new int[entryFailures.size()];
        for (int i = 0; i < entryFailures.size(); i++) {
            answer[i] = entryFailures.get(i).getKey();
        }

        return answer;
    }
}
