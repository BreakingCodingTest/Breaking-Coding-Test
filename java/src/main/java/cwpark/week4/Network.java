package cwpark.week4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Network {

	public static void main(String[] args) {
		Network network = new Network();
		int ans;
		ans = network.solution(3, new int[][]{{1,1,0},{1,1,0},{0,0,1}}); // [[1, 1, 0], [1, 1, 0], [0, 0, 1]]	2
		System.out.println(ans);
	}

	public int solution(int n, int[][] computers) {
		int answer = 0;
		boolean[] visited = new boolean[n];
		for (int i = 0; i < computers.length; i++) {
			if (!visited[i]) {
				dfs(i, computers, visited);
				answer += 1;
			}
		}

 		return answer;
	}

	public void dfs(int nodeNumber, int[][] listOfNodes, boolean[] visited) {
		visited[nodeNumber] = true;

		for (int j = 0; j < listOfNodes.length; j++) {
			if (nodeNumber != j && listOfNodes[nodeNumber][j] == 1 && !visited[j]) {
				dfs(j, listOfNodes, visited);
			}
		}
	}
}
