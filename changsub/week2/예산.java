import java.util.*;

public class 예산 {
    public int solution(int[] d, int budget) {
        int sum = 0;
        int cnt = 0;
        Arrays.sort(d);
        for(int i = 0 ; i < d.length ; i++){
            sum += d[i];
            if(sum <= budget){
                cnt++;
            }
        }
        if(sum <= budget){
            return d.length;
        }else{
            return cnt;
        }
    }
}
