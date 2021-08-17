package leejunghyeok;

public class InsufficientAmount {
    public static void main(String[] args) {
        int price = 3;
        int money = 20;
        int count = 4;
        System.out.println(solution(price, money, count));
    }

    private static long solution(int price, int money, int count) {
        long answer;
        long maxPrice = (long) price * count;

        if(count % 2 != 0) {
            answer = ((price + maxPrice) * (count / 2)) + (price + maxPrice) / 2;
        } else {
            answer = (price + maxPrice) * (count / 2);
        }

        if(answer <= money) {
            return 0;
        }
        return answer - money;
    }

}
