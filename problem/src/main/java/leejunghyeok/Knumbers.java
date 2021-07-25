package leejunghyeok;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Knumbers {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int [] result = solution(array, commands);
        for(int num : result) {
            System.out.println(num);
        }
    }

    public static int[] solution(int[] array, int[][] commands) {
        List<Integer> answers = new ArrayList<>();
        for(int[] command : commands) {
            List<Integer> chooses = new ArrayList<>();
            int index = 0;
            for (int i = command[0] - 1; i < command[1]; i++) {
                chooses.add(array[i]);
                index = command[2];
            }
            Collections.sort(chooses);
            answers.add(chooses.get(index-1));
        }
        int[] result = new int[answers.size()];
        for(int i=0; i< result.length; i++){
            result[i] = answers.get(i);
        }
        return result;
    }
}
