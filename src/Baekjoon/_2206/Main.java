package Baekjoon._2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
  static int N, M;
  static int[][] map;
  static int[][][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N + 1][M + 1];
    for (int i = 1; i <= N; i++) {
      String str = br.readLine();
      for (int j = 1; j <= M; j++) {
        map[i][j] = str.charAt(j - 1) - '0';
      }
    }

    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{1, 1, 0});
    visited = new int[N + 1][M + 1][2];
    visited[1][1][1] = 1;
    visited[1][1][0] = 1;

    boolean flag = false;

    while (!q.isEmpty()) {
      int[] now = q.poll();

      if (now[0] == N && now[1] == M) {
        flag = true;
        break;
      }

      for (int d = 0; d < 4; d++) {
        int nx = now[0] + dir[d][0];
        int ny = now[1] + dir[d][1];

        if (nx < 1 || ny < 1 || nx > N || ny > M) {
          continue;
        }

        if (map[nx][ny] == 0 && visited[nx][ny][now[2]] == 0) { // 아직 방문하지 않은 곳
          q.add(new int[]{nx, ny, now[2]});
          visited[nx][ny][now[2]] = visited[now[0]][now[1]][now[2]] + 1;
        } else if (map[nx][ny] == 1 && now[2] == 0) { // 벽이고 아직 벽을 부순적 없음
          q.add(new int[]{nx, ny, 1});
          visited[nx][ny][1] = visited[now[0]][now[1]][0] + 1;
        }
      }
    }

    if (flag) {
      System.out.println(Math.max(visited[N][M][0], visited[N][M][1]));
    } else {
      System.out.println(-1);
    }
  }
}
