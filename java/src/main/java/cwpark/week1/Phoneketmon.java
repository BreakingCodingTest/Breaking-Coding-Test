package cwpark.week1;

import java.util.HashSet;
import java.util.Set;

public class Phoneketmon {

	public static void main(String[] args) {
		Phoneketmon p = new Phoneketmon();
		int ans;
		ans = p.solution(new int[]{3,1,2,3}); //2
		System.out.println(ans);
		ans = p.solution(new int[]{3,3,3,2,2,4}); //3
		System.out.println(ans);
		ans = p.solution(new int[]{3,3,3,2,2,2}); //2
		System.out.println(ans);

	}

	public int solution(int[] nums) {
		final int MAX_KINDS = 200_001;
		Set<Integer> kinds = new HashSet<>(MAX_KINDS);

		for (int num : nums) {
			kinds.add(num);
		}

		return Math.min(kinds.size(), (nums.length / 2));
	}
}
