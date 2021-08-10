public class 음양더하기 {
    public static int solution(int[] absolutes, boolean[] signs){
        int answer = 0;
        for(int i = 0 ; i < signs.length ; i++){
            if(!signs[i]){
                //signs 안의 내용이 거짓일경우,absolutes[i]는 음수
                absolutes[i] *= -1;
            }
        }
        for(int absolute : absolutes){
            answer += absolute;
        }
        return answer;
    }

    public static void main(String[] args) {
        solution(new int[]{4, 7, 2}, new boolean[]{true, false, true});
    }
}
