package Baekjoon._14442;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
  static int N, M, K;
  static int[][] map;
  static int[][][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    map = new int[N][M];
    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = str.charAt(j) - '0';
      }
    }

    visited = new int[N][M][K + 1];
    visited[0][0][0] = 1;
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{0, 0, 0});
    boolean flag = false;

    while (!q.isEmpty()) {
      int[] now = q.poll();
      int count = now[2];

      if (now[0] == N - 1 && now[1] == M - 1) {
        flag = true;
        break;
      }

      for (int d = 0; d < 4; d++) {
        int nx = now[0] + dir[d][0];
        int ny = now[1] + dir[d][1];

        if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
          continue;
        }

        if (map[nx][ny] == 0 && visited[nx][ny][count] == 0) {
          visited[nx][ny][count] = visited[now[0]][now[1]][count] + 1;
          q.add(new int[]{nx, ny, count});
        } else if (map[nx][ny] == 1 && count < K && visited[nx][ny][count + 1] == 0) {
          visited[nx][ny][count + 1] = visited[now[0]][now[1]][count] + 1;
          q.add(new int[]{nx, ny, count + 1});
        }
      }
    }

    if (flag) {
      int min = Integer.MAX_VALUE;
      for (int i = 0; i <= K; i++) {
        if (visited[N - 1][M - 1][i] != 0) {
          min = Math.min(min, visited[N - 1][M - 1][i]);
        }
      }
      System.out.println(min);
    } else {
      System.out.println(-1);
    }
  }
}
