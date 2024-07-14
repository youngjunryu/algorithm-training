package Baekjoon._30106;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  static int N, M, K;
  static int[][] map;
  static int[][] check;
  static int paint;
  static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    check = new int[N][M];
    paint = 0;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (check[i][j] == 0) {
          paint++;
          dfs(i, j);
        }
      }
    }

    System.out.println(paint);
  }

  private static void dfs(int x, int y) {
    Stack<int[]> stack = new Stack<>();
    stack.push(new int[]{x, y});

    while (!stack.empty()) {
      int[] now = stack.pop();

      if (check[now[0]][now[1]] != 0) {
        continue;
      }

      check[now[0]][now[1]] = paint;

      for (int d = 0; d < 4; d++) {
        int nx = dir[d][0] + now[0];
        int ny = dir[d][1] + now[1];

        if (nx < 0 || ny < 0 || nx >= N || ny >= M || check[nx][ny] != 0) {
          continue;
        }

        if (Math.abs(map[nx][ny] - map[now[0]][now[1]]) <= K) {
          stack.push(new int[]{nx, ny});
        }
      }
    }
  }
}
