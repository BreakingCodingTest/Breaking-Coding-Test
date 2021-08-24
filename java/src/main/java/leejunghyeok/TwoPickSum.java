package leejunghyeok;

import java.util.*;

public class TwoPickSum {
    public static void main(String[] args) {
        int[] numbers = {2, 1, 3, 4, 1};
        System.out.println(Arrays.toString(solution(numbers)));
    }
        public static int[] solution(int[] numbers) {
            Set<Integer> addSet = new HashSet<>();
            for(int i=0; i< numbers.length; i++) {
                for(int j=0; j< numbers.length; j++) {
                    if(i==j) {
                        continue;
                    }
                    addSet.add(numbers[i]+numbers[j]);
                }
            }
            List<Integer> collect = new ArrayList<>(addSet);
            int[] answer = new int[addSet.size()];
            for (int i = 0; i < collect.size(); i++) {
                answer[i] = collect.get(i);
            }
            Arrays.sort(answer);
            return answer;
        }

}
