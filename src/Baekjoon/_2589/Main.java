package Baekjoon._2589;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int n, m;
  static char[][] map;
  static int max;
  static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    max = -1;

    map = new char[n][m];

    for (int i = 0; i < n; i++) {
      String str = br.readLine();
      for (int j = 0; j < m; j++) {
        map[i][j] = str.charAt(j);
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (map[i][j] == 'L') {
          go(i, j);
        }
      }
    }

    System.out.println(max);
  }

  private static void go(int x, int y) {
    boolean[][] visited = new boolean[n][m];

    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{x, y, 0});
    visited[x][y] = true;

    while (!q.isEmpty()) {
      int[] now = q.poll();

      for (int d = 0; d < 4; d++) {
        int nx = now[0] + dir[d][0];
        int ny = now[1] + dir[d][1];

        if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
          continue;
        }

        if (visited[nx][ny] || map[nx][ny] == 'W') {
          continue;
        }

        visited[nx][ny] = true;
        q.add(new int[]{nx, ny, now[2] + 1});
        max = Math.max(max, now[2] + 1);
      }
    }
  }
}
