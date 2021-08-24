package leejunghyeok;

import java.util.LinkedList;
import java.util.Queue;

public class Network {
    public static void main(String[] args) {
        int n = 3;
        int[][] computer = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(solution(n, computer));
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        int bfsAnswer = 0;
        boolean[] visit = new boolean[computers.length];
        boolean[] bfsVisit = new boolean[computers.length];
        for(int i=0; i < computers.length; i++) {
            if(!visit[i]) {
                dfsR(visit, computers, i);
                answer++;
            }

        }
        for(int i=0; i < computers.length; i++) {
            if(!bfsVisit[i]) {
                bfsR(bfsVisit, computers, i);
                bfsAnswer++;
            }
        }
        return answer;
    }


    //bfs 풀이
    private static void bfsR(boolean[] visit, int[][] computers, int i) {
        visit[i] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while(!q.isEmpty()) {
            Integer poll = q.poll();
            for(int j=0; j < computers.length; j++) {
                if(poll != j && !visit[j] && computers[poll][j] == 1) {
                    q.add(j);
                    visit[j] = true;
                }
            }
        }
    }


    //dfs
    private static boolean[] dfsR(boolean[] visit, int[][] computers, int i) {
        visit[i] = true;
        for(int j=0; j < computers[i].length; j++) {
            if(i != j && !visit[j] && computers[i][j] == 1) {
                visit = dfsR(visit, computers, j);
            }
        }

        return visit;
    }
}
