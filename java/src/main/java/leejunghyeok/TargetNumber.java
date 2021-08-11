package leejunghyeok;

public class TargetNumber {

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution(numbers, target));
    }

    public static int solution(int[] numbers, int target) {
        int index = 0;
        int sum = 0;
        int cnt = 0;

        return depthR(numbers, target, index, sum, cnt);
    }

    public static int depthR(int[] numbers, int target, int index, int sum, int cnt) {
        if(index == numbers.length) {
            if(sum == target) {
                return ++cnt;
            } else {
                return cnt;
            }
        }

        int plusSum = sum + numbers[index];
        int minusSum = sum - numbers[index];
        index++;


        cnt = depthR(numbers, target, index, plusSum, cnt);
        cnt = depthR(numbers, target, index, minusSum, cnt);
        return cnt;
    }
}
