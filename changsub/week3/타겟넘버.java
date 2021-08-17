public class 타겟넘버 {
    public static int dfs(int[] numbers, int node, int sum, int target) {
        if(node == numbers.length){
            if(sum==target)
                return 1;
            return 0;
        }
        return dfs(numbers, node+1, sum + numbers[node], target)
                + dfs(numbers, node+1, sum - numbers[node], target);
    }
    public static void main(String[] args) {

        int answer = 0;

        answer = dfs(new int[]{1,1,1,1,1}, 0, 0, 3);
        System.out.println("answer = " + answer);
    }
}
