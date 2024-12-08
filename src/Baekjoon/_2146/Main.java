package Baekjoon._2146;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int[][] map;
  static int idx;
  static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
  static int min;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    min = Integer.MAX_VALUE;
    N = Integer.parseInt(br.readLine());
    map = new int[N][N];
    idx = 2;

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (map[i][j] == 1) {
          find(i, j);
          idx++;
        }
      }
    }

    // 가장자리 찾기
    Queue<int[]> edges = new LinkedList<>();

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (map[i][j] != 0) {
          for (int d = 0; d < 4; d++) {
            int nx = i + dir[d][0];
            int ny = j + dir[d][1];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 0) {
              edges.add(new int[]{i, j});
              break;
            }
          }
        }
      }
    }

    // 각 가장자리에서 가장 짧은 대륙 연결
    for (int[] edge : edges) {
      int val = map[edge[0]][edge[1]];
      go(edge[0], edge[1], val);
    }

    System.out.println(min);
  }

  private static void go(int x, int y, int val) {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{x, y, val, 0});

    boolean[][] visited = new boolean[N][N];
    visited[x][y] = true;

    while (!q.isEmpty()) {
      int[] now = q.poll();

      for (int d = 0; d < 4; d++) {
        int nx = now[0] + dir[d][0];
        int ny = now[1] + dir[d][1];

        if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == val || visited[nx][ny]) {
          continue;
        }

        if (map[nx][ny] == 0) {
          q.add(new int[]{nx, ny, val, now[3] + 1});
          visited[nx][ny] = true;
        } else {
          min = Math.min(min, now[3]);
          return;
        }
      }
    }
  }

  private static void find(int x, int y) {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{x, y});

    map[x][y] = idx;

    while (!q.isEmpty()) {
      int[] now = q.poll();

      for (int d = 0; d < 4; d++) {
        int nx = now[0] + dir[d][0];
        int ny = now[1] + dir[d][1];

        if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == 0) {
          continue;
        }

        if (map[nx][ny] == 1) {
          map[nx][ny] = idx;
          q.add(new int[]{nx, ny});
        }
      }
    }
  }
}
