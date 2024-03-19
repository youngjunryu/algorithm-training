package Programmers.lv3.네트워크;

import java.util.*;

class Solution {
  public int solution(int n, int[][] computers) {
    int result = 0;
    boolean[] visited = new boolean[n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (computers[i][j] == 0 || visited[i] || visited[j]) continue;
        bfs(i, j, n, visited, computers);
        result++;
      }
    }

    return result;
  }

  public void bfs(int x, int y, int n, boolean[] visited, int[][] computers) {
    Queue<Integer> q = new ArrayDeque<>();
    q.add(x);
    q.add(y);
    visited[x] = true;
    visited[y] = true;

    while (!q.isEmpty()) {
      int now = q.poll();

      for (int i = 0; i < n; i++) {
        if (visited[i]) continue;

        if (computers[now][i] == 1) {
          q.add(i);
          visited[i] = true;
        }
      }
    }
  }
}

/*

1. computers[i][j] = 1 => i번 컴퓨터와 j번 컴퓨터가 연결되어 있음.
2. 언제나 computer[i][j] = 1

1 1 0
1 1 0
0 0 1

*/
