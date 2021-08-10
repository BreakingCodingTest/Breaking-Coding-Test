public class Week1 {
    public static void main(String[] args) {
        System.out.println(solution(3, 20, 4));

    }
    public static long solution(int price, int money, int count) {
        long answer;
        long sum = 0L;
        //count만큼 놀이기구를 반복해서 타서, 해당 수 만큼 반복문 실행
        for(int i = 1 ; i <= count ; i++){
            sum += (long) i *price;
        }
        if(sum <= money){
            return 0;
        }else{
            answer = sum - money;
            return answer;
        }

    }
}
