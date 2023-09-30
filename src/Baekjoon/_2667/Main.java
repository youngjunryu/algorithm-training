package Baekjoon._2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
  static int n;
  static int[][] map;
  static boolean[][] visited;
  static List<Integer> results = new ArrayList<>();
  static int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    map = new int[n][n];
    visited = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      String str = br.readLine();
      for (int j = 0; j < n; j++) {
        map[i][j] = (str.charAt(j) - '0');
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (map[i][j] == 1 && !visited[i][j]) {
          results.add(bfs(i, j));
        }
      }
    }

    Collections.sort(results);
    System.out.println(results.size());
    for (int r : results) {
      System.out.println(r);
    }
  }

  static int bfs(int x, int y) {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{x, y});
    visited[x][y] = true;
    int result = 1;
    while (!q.isEmpty()) {
      int[] cur = q.poll();

      for (int i = 0; i < 4; i++) {
        int dx = d[i][0] + cur[0];
        int dy = d[i][1] + cur[1];

        if (dx < 0 || dy < 0 || dx >= n || dy >= n || map[dx][dy] != 1 || visited[dx][dy]) {
          continue;
        }

        visited[dx][dy] = true;
        result++;
        q.add(new int[]{dx, dy});
      }
    }

    return result;
  }
}
