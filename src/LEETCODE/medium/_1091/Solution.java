package LeetCode.medium._1091;

import java.util.*;

class Solution {
  int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
  int n;

  public int shortestPathBinaryMatrix(int[][] grid) {
    if (grid[0][0] != 0) {
      return -1;
    }

    n = grid.length;
    Queue<int[]> q = new LinkedList<>();
    boolean[][] visited = new boolean[n][n];
    q.add(new int[]{0, 0, 1});
    grid[0][0] = 1;
    visited[0][0] = true;

    while (!q.isEmpty()) {
      int[] now = q.poll();

      visited[now[0]][now[1]] = true;

      for (int d = 0; d < 8; d++) {
        int nx = now[0] + dir[d][0];
        int ny = now[1] + dir[d][1];

        if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny] || grid[nx][ny] != 0) {
          continue;
        }

        grid[nx][ny] = now[2] + 1;
        q.add(new int[]{nx, ny, now[2] + 1});
        visited[nx][ny] = true;
      }
    }

    if (!visited[n - 1][n - 1]) return -1;

    return grid[n - 1][n - 1];
  }
}
