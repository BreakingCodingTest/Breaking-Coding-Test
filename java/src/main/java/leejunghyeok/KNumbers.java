package leejunghyeok;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KNumbers {
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
        //각 커맨드를 실행 하기 위한 반복문
        for(int[] command : commands) {
            //커맨드에 포함되는 범위의 수를 저장하기위 한 리스트
            List<Integer> chooses = new ArrayList<>();
            int index = 0;
            //커맨드 범위 만큼 반복하면서 위 리스트 저장 및 정렬 후 뽑고자 하는 위치 변수도 찾는다.
            for (int i = command[0] - 1; i < command[1]; i++) {
                chooses.add(array[i]);
                index = command[2];
            }
            Collections.sort(chooses);
            //해당 인덱스의 값을 저장
            answers.add(chooses.get(index-1));
        }
        int[] result = new int[answers.size()];
        for(int i=0; i< result.length; i++){
            result[i] = answers.get(i);
        }
        return result;
    }
}
