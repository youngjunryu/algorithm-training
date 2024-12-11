package Baekjoon._1937;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int n;
  static int[][] map;
  static int[][] dp;
  static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    map = new int[n][n];
    dp = new int[n][n];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        dp[i][j] = -1;
      }
    }

    int result = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        result = Math.max(result, dfs(i, j));
      }
    }

    System.out.println(result);
  }

  private static int dfs(int x, int y) {
    if (dp[x][y] != -1) {
      return dp[x][y];
    }

    dp[x][y] = 1;

    for (int d = 0; d < 4; d++) {
      int nx = x + dir[d][0];
      int ny = y + dir[d][1];

      if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
        continue;
      }

      if (map[x][y] < map[nx][ny]) {
        dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
      }
    }

    return dp[x][y];
  }
}
