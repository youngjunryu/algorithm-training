package PROGRAMMERS;

import java.util.LinkedList;
import java.util.Queue;

public class 가장_먼_노드_2 {
    public static int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[][] graph = new boolean[n+1][n+1];
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];

        for(int[] arr : edge) {
            graph[arr[0]][arr[1]] = true;
            graph[arr[1]][arr[0]] = true;
        }

        visited[1] = true;
        q.add(1);

        while(!q.isEmpty()) {
            int qSize = q.size();
            for(int i = 0; i < qSize; i++) {
                int cur = q.poll();
                for(int j = 1; j <= n; j++) {
                    if(graph[cur][j] && !visited[j]) {
                        q.add(j);
                        visited[j] = true;
                    }
                }
            }
            answer = qSize;
        }

        return answer;
    }

    public static void main(String[] args) {
        solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});
    }
}

/*
6	[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]	3
 */