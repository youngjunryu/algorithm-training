package Baekjoon._2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int[][] map;
  static int step;
  static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    map = new int[N][N];
    step = 1;
    int answer = 1;

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        step = Math.max(step, map[i][j]);
      }
    }

    for (int t = 1; t <= step; t++) {
      int[][] check = new int[N][N];
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (map[i][j] <= t) {
            check[i][j] = -1;
          }
        }
      }

      int idx = 0;
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (check[i][j] == 0) {
            bfs(check, i, j, ++idx);
          }
        }
      }

      answer = Math.max(idx, answer);
    }

    System.out.println(answer);
  }

  private static void bfs(int[][] check, int x, int y, int idx) {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{x, y});
    check[x][y] = idx;

    while (!q.isEmpty()) {
      int[] now = q.poll();

      for (int d = 0; d < 4; d++) {
        int nx = now[0] + dir[d][0];
        int ny = now[1] + dir[d][1];

        if (nx < 0 || ny < 0 || nx >= N || ny >= N || check[nx][ny] != 0) {
          continue;
        }

        check[nx][ny] = idx;
        q.add(new int[]{nx, ny});
      }
    }
  }
}
