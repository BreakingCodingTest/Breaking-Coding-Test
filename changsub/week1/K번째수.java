import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class K번째수 {
    public static int[] solution(int[] array, int[][] commands) {
        //잘려진 리스트를 임시로 가지고 있는 어레이리스트
        List<Integer> res_ = new LinkedList<>();
        //리턴값을 임시로 가지고 있는 어레이리스트
        List<Integer> answer_ = new LinkedList<>();

        int start, end, index;

        //행의 수만큼 반복한다.
        for(int i = 0; i < commands.length ; i++){
            start = commands[i][0]; //start index;
            end = commands[i][1]; //end index
            index = commands[i][2];
            if(start == end){
                answer_.add(array[start-1]);
            }
            else{
                //임시 Result 리스트에 해당 범위만큼의 원소 추가하기
                for(int j = start-1; j < end ; j++){
                    res_.add(array[j]);
                }
                Collections.sort(res_);
                answer_.add(res_.get(index-1));
                res_.clear();
            }
        }
        System.out.println(answer_);
        //answer_를 이제 배열로 바꾸면 완성
        int[] answer = answer_.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}
