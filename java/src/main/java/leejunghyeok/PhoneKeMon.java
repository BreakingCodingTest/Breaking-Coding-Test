package leejunghyeok;

import java.util.HashSet;
import java.util.Set;

public class PhoneKeMon {
    public static void main(String[] args) {
        int[] nums1 = {3, 1, 2, 3};
        int[] nums2 = {3, 3, 3, 2, 2, 4};
        int[] nums3 = {3, 3, 3, 2, 2, 2};
        System.out.println(solution(nums1));
        System.out.println(solution(nums2));
        System.out.println(solution(nums3));
    }

    public static int solution(int[] nums) {
        Set<Integer> phoneStyle = new HashSet<>();
        for (int num : nums) {
            phoneStyle.add(num);
        }
        // 최대 뽑을 수 있는 포켓몬과 실제로 뽑을 수 있는 포켓몬수 중 작은 값을 출력
        // 3번째 case를 보면 최대 뽑을 수 있는 포켓몬 수는 3마리지만 실제로 뽑을 수 있는 폰켓몬 의 수는 2마리 (3,2)
        return Math.min(phoneStyle.size(), nums.length / 2);
    }
}
