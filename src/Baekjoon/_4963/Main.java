package Baekjoon._4963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {-1, -1}, {-1, 1}, {1, 1},
      {1, -1}};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int w = Integer.parseInt(st.nextToken());
      int h = Integer.parseInt(st.nextToken());

      if (w == 0 && h == 0) {
        break;
      }

      int[][] map = new int[h][w];
      boolean[][] visited = new boolean[h][w];
      int result = 0;

      for (int i = 0; i < h; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < w; j++) {
          map[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
          if (map[i][j] == 1 && !visited[i][j]) {
            result++;
            bfs(i, j, map, h, w, visited);
          }
        }
      }

      System.out.println(result);
    }
  }

  private static void bfs(int x, int y, int[][] map, int h, int w, boolean[][] visited) {
    Queue<int[]> q = new LinkedList<>();
    visited[x][y] = true;
    q.add(new int[]{x, y});

    while (!q.isEmpty()) {
      int[] now = q.poll();

      for (int[] d : dir) {
        int nx = now[0] + d[0];
        int ny = now[1] + d[1];

        if (nx < 0 || ny < 0 || nx >= h || ny >= w || visited[nx][ny] || map[nx][ny] == 0) {
          continue;
        }

        visited[nx][ny] = true;
        q.add(new int[]{nx, ny});
      }
    }
  }
}
