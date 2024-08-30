package Baekjoon._17070;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int[][] map;
  static int[][][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    map = new int[N + 1][N + 1];
    for (int i = 1; i <= N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    visited = new int[N + 1][N + 1][3];
    int H = 0;
    int V = 1;
    int D = 2;

    visited[1][2][H] = 1;

    for (int i = 1; i <= N; i++) {
      for (int j = 2; j <= N; j++) {
        if (i == 1 && j < 3) {
          continue;
        }

        if (map[i][j] == 1) {
          continue;
        }

        if (i >= 2 && map[i - 1][j - 1] != 1 && map[i][j - 1] != 1 && map[i - 1][j] != 1) {
          visited[i][j][D] =
              visited[i - 1][j - 1][H] + visited[i - 1][j - 1][V] + visited[i - 1][j - 1][D];
        }

        if (i >= 2 && map[i - 1][j] != 1) {
          visited[i][j][V] = visited[i - 1][j][V] + visited[i - 1][j][D];
        }

        if (map[i][j - 1] != 1) {
          visited[i][j][H] = visited[i][j - 1][H] + visited[i][j - 1][D];
        }
      }
    }

    System.out.println(visited[N][N][H] + visited[N][N][V] + visited[N][N][D]);
  }
}
