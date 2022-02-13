package PROGRAMMERS;

import java.util.*;

public class 순위 {
    static List<List<Integer>> graph;
    static int[][] weights;

    public int solution(int n, int[][] results) {
        graph = new ArrayList<>();
        weights = new int[n][2];
        boolean[] visited;
        int cnt = 0;

        for(int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for(int[] arr : results)
            graph.get(arr[0] - 1).add(arr[1] - 1);

        for(int i = 0; i < n; i++) {
            visited = new boolean[n];
            dfs(i, i, visited);
        }

        for(int i = 0;  i < n; i++) {
            if(weights[i][0] + weights[i][1] == n - 1) {
                cnt++;
            }
        }

        return cnt;
    }

    private static void dfs(int base, int next, boolean[] visited) {
        if(base != next) {
            visited[next] = true;
            weights[base][0] += 1;
            weights[next][1] += 1;
        }

        for(int i = 0; i < graph.get(next).size(); i++) {
            if(!visited[graph.get(next).get(i)])
                dfs(base, graph.get(next).get(i), visited);
        }
    }
}
