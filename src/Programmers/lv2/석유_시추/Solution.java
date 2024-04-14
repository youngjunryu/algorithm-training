package Programmers.lv2.석유_시추;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {

  int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
  int n, m;
  int max = 0;
  int[][] map;
  boolean[][] visited;
  boolean[] check;

  public int solution(int[][] land) {
    n = land.length;
    m = land[0].length;
    map = land;
    visited = new boolean[n][m];
    int[] ans = new int[m];
    check = new boolean[m];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited[j][i] && map[j][i] == 1) {
          int sum = bfs(j, i);
          for (int k = 0; k < m; k++) {
            if (check[k]) {
              check[k] = false;
              ans[k] += sum;
            }
          }
        }
      }
    }

    for (int i = 0; i < m; i++) {
      max = Math.max(ans[i], max);
    }

    return max;
  }

  public int bfs(int x, int y) {
    int sum = 0;
    Queue<int[]> q = new ArrayDeque<>();

    q.add(new int[]{x, y});
    visited[x][y] = true;
    check[y] = true;
    sum++;

    while (!q.isEmpty()) {
      int[] now = q.poll();

      for (int d = 0; d < 4; d++) {
        int nx = now[0] + dir[d][0];
        int ny = now[1] + dir[d][1];

        if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny]) {
          continue;
        }

        if (map[nx][ny] == 1) {
          q.add(new int[]{nx, ny});
          visited[nx][ny] = true;
          check[ny] = true;
          sum++;
        }
      }
    }

    return sum;
  }
}
