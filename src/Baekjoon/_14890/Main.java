package Baekjoon._14890;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N, L;
  static int[][] map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());
    map = new int[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int result = 0;
    for (int i = 0; i < N; i++) {
      if (check(map[i])) {
        result++;
      }
      if (check(getColumn(map, i))) {
        result++;
      }
    }

    System.out.println(result);
  }

  public static boolean check(int[] path) {
    boolean[] visited = new boolean[N];

    for (int i = 0; i < N - 1; i++) {
      int diff = path[i] - path[i + 1];

      if (diff == 0) {
        continue;
      }

      if (diff == 1) { // 내려가는 경사로
        for (int j = 1; j <= L; j++) {
          if (i + j >= N || path[i + 1] != path[i + j] || visited[i + j]) {
            return false;
          }
          visited[i + j] = true;
        }
      } else if (diff == -1) { // 올라가는 경사로
        for (int j = 0; j < L; j++) {
          if (i - j < 0 || path[i] != path[i - j] || visited[i - j]) {
            return false;
          }
          visited[i - j] = true;
        }
      } else { // 높이 차이가 2 이상인 경우
        return false;
      }
    }

    return true;
  }

  static int[] getColumn(int[][] grid, int col) {
    int[] column = new int[N];
    for (int i = 0; i < N; i++) {
      column[i] = grid[i][col];
    }
    return column;
  }
}
