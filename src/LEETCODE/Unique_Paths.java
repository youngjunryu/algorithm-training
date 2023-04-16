package LEETCODE;

import java.util.*;

class Unique_Paths {
  public int uniquePaths(int m, int n) {
    int[][] map = new int[m][n];
    for (int i = 0; i < m; i++) {
      Arrays.fill(map[i], -1);
    }

    return solve(0, 0, m, n, map);
  }

  public int solve(int x, int y, int m, int n, int[][] map) {
    if (x >= m || y >= n) return 0;
    if (x == m - 1 && y == n - 1) return 1;
    if (map[x][y] != -1) return map[x][y];
    return map[x][y] = solve(x + 1, y, m, n, map) + solve(x, y + 1, m, n, map);
  }
}