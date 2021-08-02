import java.util.ArrayList;

public class MockTest {
    public static void main(String[] args){
        solution(new int[] {1,3,2,4,2});
    }
    public static int[] solution(int[] answers) {
        int [] firstPattern = {1,2,3,4,5};
        int [] secondPattern = {2,1,2,3,2,4,2,5};
        int [] thirdPattern = {3,3,1,1,2,2,4,4,5,5};

        int [] score = new int[3];

        int [] answer = {};
        for (int i = 0 ; i < answers.length ; i++) {
            if (answers[i] == firstPattern[i % firstPattern.length]) {
                score[0]++;
            }
            if (answers[i] == secondPattern[i % secondPattern.length]) {
                score[1]++;
            }
            if (answers[i] == thirdPattern[i % thirdPattern.length]) {
                score[2]++;
            }
        }
        int max = Math.max(score[0],Math.max(score[1],score[2]));
        ArrayList<Integer> answer_ = new ArrayList<>();
        if(max == score[0]){
            answer_.add(1);
        }if(max == score[1]){
            answer_.add(2);
        }if(max == score[2]){
            answer_.add(3);
        }
        answer = new int[answer_.size()];
        for(int i = 0 ; i < answer.length; i++){
            answer[i] = answer_.get(i);
            System.out.println("answer : " + answer[i]);
        }
        return answer;
    }
}