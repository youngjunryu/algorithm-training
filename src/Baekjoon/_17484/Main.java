package Baekjoon._17484;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int[][] dir = new int[][]{{1, -1}, {1, 0}, {1, 1}};
  static int N, M;
  static int[][] map;
  static int result;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    result = Integer.MAX_VALUE;
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N + 2][M + 1];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int y = 1; y <= M; y++) {
      int cost = map[1][y];
      go(1, y, -1, cost);
    }

    System.out.println(result);
  }

  public static void go(int x, int y, int lastDir, int cost) {
    if (x == N + 1) {
      result = Math.min(cost, result);
      return;
    }

    for (int d = 0; d < 3; d++) {
      if (lastDir == d) {
        continue;
      }

      int dx = x + dir[d][0];
      int dy = y + dir[d][1];
      if (isPossible(dx, dy)) {
        int dCost = map[dx][dy];
        go(dx, dy, d, cost + dCost);
      }
    }
  }

  public static boolean isPossible(int x, int y) {
    if (y < 1 || y > M) {
      return false;
    }
    return true;
  }
}
