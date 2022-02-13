package PROGRAMMERS;

import java.util.*;

public class 네트워크 {
    static boolean[] visited;
    static List<List<Integer>> graph;

    public int solution(int n, int[][] computers) {
        graph = new ArrayList<>();
        visited = new boolean[n];
        int cnt = 0;

        for(int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++)
                if(i != j && computers[i][j] == 1)
                    graph.get(i).add(j);
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                bfs(i);
                cnt++;
            }
        }

        return cnt;
    }

    private static void bfs(int k) {
        Queue<Integer> queue = new LinkedList<>();
        visited[k] = true;
        queue.add(k);

        while(!queue.isEmpty()) {
            int temp = queue.poll();
            for(int i = 0; i < graph.get(temp).size(); i++) {
                if(!visited[graph.get(temp).get(i)]) {
                    visited[graph.get(temp).get(i)] = true;
                    queue.add(graph.get(temp).get(i));
                }
            }
        }
    }
}
