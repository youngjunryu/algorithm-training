package Archiving.PROGRAMMERS;

import java.util.*;

public class 가장_먼_노드 {
    public static int solution(int n, int[][] edge) {
        boolean[][] graph = new boolean[n+1][n+1];
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        int answer = 0;

        for(int i = 0; i < edge.length; i++) {
            graph[edge[i][0]][edge[i][1]] = true;
            graph[edge[i][1]][edge[i][0]] = true;
        }

        visited[1] = true;
        queue.add(1);

        while(!queue.isEmpty()) {
            int qSize = queue.size();
            for(int i = 0; i < qSize; i++) {
                int cur = queue.poll();
                for(int j = 1; j <= n; j++) {
                    if(graph[cur][j] && !visited[j]) {
                        visited[j] = true;
                        queue.add(j);
                    }
                }
            }
            answer = qSize;
        }

        return answer;
    }
}

/*

6
[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]
3

 */