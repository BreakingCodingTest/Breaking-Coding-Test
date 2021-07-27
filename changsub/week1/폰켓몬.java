import java.util.ArrayList;

public class 폰켓몬 {
    public int solution(int[] nums) {
        int answer = 0;
        int size = (nums.length) / 2;
        //중복제거를 위한 arrayList. Set을 사용해도 무방
        ArrayList<Integer> kind_list = new ArrayList<>();
        for(int data : nums){
            if(!kind_list.contains(data)){
                kind_list.add(data);
            }
        }
        int cnt = kind_list.size();
        if(size < cnt){
            answer = size;
        }
        else{
            answer = cnt;
        }
        return answer;
    }
}
