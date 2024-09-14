package Baekjoon._1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    for (int t = 0; t < T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int M = Integer.parseInt(st.nextToken());
      int N = Integer.parseInt(st.nextToken());
      int K = Integer.parseInt(st.nextToken());

      int[][] map = new int[N][M];

      for (int i = 0; i < K; i++) {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        map[y][x] = 1;
      }

      int result = 0;

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if (map[i][j] == 1) {
            bfs(i, j, map, N, M);
            result++;
          }
        }
      }

      System.out.println(result);
    }
  }

  private static void bfs(int x, int y, int[][] map, int N, int M) {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{x, y});

    while (!q.isEmpty()) {
      int[] now = q.poll();

      for (int d = 0; d < 4; d++) {
        int nx = dir[d][0] + now[0];
        int ny = dir[d][1] + now[1];

        if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 0) {
          continue;
        }

        map[nx][ny] = 0;
        q.add(new int[]{nx, ny});
      }
    }
  }
}
