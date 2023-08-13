package Archiving.PROGRAMMERS;

import java.util.ArrayList;
import java.util.List;

public class 순위_2 {
    List<List<Integer>> graph;
    boolean[] visited;
    int[][] weight;

    public int solution(int n, int[][] results) {
        int answer = 0;
        weight = new int[n+1][2];
        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] result : results) {
            graph.get(result[0]).add(result[1]);
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n+1];
            dfs(i, i);
        }

        for (int i = 1; i <= n; i++) {
            if (weight[i][0] + weight[i][1] == n-1) {
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int base, int next) {

        if (base != next) {
            visited[next] = true;
            weight[base][0] += 1;
            weight[next][1] += 1;
        }

        for (int i = 0; i < graph.get(next).size(); i++) {
            if (!visited[graph.get(next).get(i)]) {
                dfs(base, graph.get(next).get(i));
            }
        }
    }
}
