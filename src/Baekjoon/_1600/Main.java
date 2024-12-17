package Baekjoon._1600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int k;
  static int[][] map;
  static int r, c;
  static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
  static int[][] horse = new int[][]{{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, -2}, {2, -1}, {2, 1},
      {1, 2}};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    k = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    c = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());

    map = new int[r][c];

    for (int i = 0; i < r; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < c; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    boolean[][][] visited = new boolean[k + 1][r][c];
    visited[k][0][0] = true;

    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{0, 0, k, 0});

    while (!q.isEmpty()) {
      int[] now = q.poll();

      if (now[0] == r - 1 && now[1] == c - 1) {
        System.out.println(now[3]);
        return;
      }

      for (int[] d : dir) {
        int nx = now[0] + d[0];
        int ny = now[1] + d[1];

        if (nx >= 0 && nx < r && ny >= 0 && ny < c && !visited[now[2]][nx][ny]
            && map[nx][ny] == 0) {
          q.add(new int[]{nx, ny, now[2], now[3] + 1});
          visited[now[2]][nx][ny] = true;
        }
      }

      if (now[2] > 0) {
        for (int[] h : horse) {
          int nx = now[0] + h[0];
          int ny = now[1] + h[1];

          if (nx >= 0 && nx < r && ny >= 0 && ny < c && !visited[now[2] - 1][nx][ny]
              && map[nx][ny] == 0) {
            q.add(new int[]{nx, ny, now[2] - 1, now[3] + 1});
            visited[now[2] - 1][nx][ny] = true;
          }
        }
      }
    }

    System.out.println(-1);
  }
}
