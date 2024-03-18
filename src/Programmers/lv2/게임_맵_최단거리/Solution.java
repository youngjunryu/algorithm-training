package Programmers.lv2.게임_맵_최단거리;

import java.util.*;

class Solution {
  int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public int solution(int[][] maps) {
    int answer = 0;

    int n = maps.length;
    int m = maps[0].length;

    return bfs(0, 0, n, m, maps);
  }

  public int bfs(int x, int y, int n, int m, int[][] maps) {
    Queue<int[]> q = new ArrayDeque<>();
    boolean[][] visited = new boolean[n][m];
    int[][] cntMaps = new int[n][m];
    for (int i = 0; i < n; i++)
      Arrays.fill(cntMaps[i], -1);

    q.add(new int[]{x , y});
    visited[x][y] = true;
    cntMaps[0][0] = 1;

    while (!q.isEmpty()) {
      int[] cur = q.poll();

      for (int d = 0; d < 4; d++) {
        int dx = dir[d][0] + cur[0];
        int dy = dir[d][1] + cur[1];

        if (dx < 0 || dy < 0 || dx >= n || dy >= m || visited[dx][dy]) {
          continue;
        }

        if (maps[dx][dy] == 0) {
          continue;
        }

        q.add(new int[]{dx, dy});
        cntMaps[dx][dy] = cntMaps[cur[0]][cur[1]] + 1;
        visited[dx][dy] = true;
      }
    }

    return cntMaps[n - 1][m - 1];
  }
}

/*

0은 벽이 있는 자리, 1은 벽이 없는 자리

*/
