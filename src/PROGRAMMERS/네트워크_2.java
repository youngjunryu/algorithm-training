package PROGRAMMERS;

import java.util.*;

public class 네트워크_2 {
    List<List<Integer>> list;
    boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        list = new ArrayList<>();
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i != j && computers[i][j] == 1) {
                    list.get(i).add(j);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                answer++;
                bfs(i);
            }
        }

        return answer;
    }

    private void bfs(int point) {
        Queue<Integer> q = new LinkedList<>();
        q.add(point);

        while(!q.isEmpty()) {
            int cur = q.poll();
            visited[cur] = true;

            for(int i = 0; i < list.get(cur).size(); i++) {
                if(!visited[list.get(cur).get(i)]) {
                    q.add(list.get(cur).get(i));
                }
            }
        }
    }
}
