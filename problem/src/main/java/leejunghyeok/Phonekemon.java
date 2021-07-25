package leejunghyeok;

import java.util.HashSet;
import java.util.Set;

public class Phonekemon {
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
        return Math.min(phoneStyle.size(), nums.length / 2);
    }
}
