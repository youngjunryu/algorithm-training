package Baekjoon._14500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[][] dir = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
  static int N, M;
  static int[][] map;
  static boolean[][] visited;
  static int max = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    visited = new boolean[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        int num = Integer.parseInt(st.nextToken());
        map[i][j] = num;
      }
    }

    // method 1
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        visited[i][j] = true;
        search(i, j, 1, map[i][j]);
        visited[i][j] = false;
      }
    }

    // method 2
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        for (int k = 0; k < 4; k++) {
          int sum = map[i][j];

          for (int z = 0; z < 4; z++) {
            if (z == k) {
              continue;
            }

            int nx = i + dir[z][0];
            int ny = j + dir[z][1];

            if (isOutOfRange(nx, ny)) {
              break;
            }

            sum += map[nx][ny];
          }

          max = Math.max(sum, max);
        }
      }
    }

    System.out.println(max);
  }

  private static void search(int x, int y, int cnt, int sum) {
    if (cnt == 4) {
      max = Math.max(sum, max);
      return;
    }

    for (int i = 0; i < 4; i++) {
      int nx = x + dir[i][0];
      int ny = y + dir[i][1];

      if (isOutOfRange(nx, ny)) {
        continue;
      }

      if (visited[nx][ny]) {
        continue;
      }

      visited[nx][ny] = true;
      search(nx, ny, cnt + 1, sum + map[nx][ny]);
      visited[nx][ny] = false;
    }
  }

  private static boolean isOutOfRange(int x, int y) {
    if (x < 0 || x >= N || y < 0 || y >= M) {
      return true;
    }
    return false;
  }
}
