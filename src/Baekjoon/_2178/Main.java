package Baekjoon._2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[][] map = new int[N + 1][M + 1];
    int[][] count = new int[N + 1][M + 1];

    for (int i = 1; i <= N; i++) {
      String str = br.readLine();
      for (int j = 1; j <= M; j++) {
        map[i][j] = str.charAt(j - 1) - '0';
      }
    }

    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{1, 1});
    count[1][1] = 1;
    map[1][1] = 0;

    while (!q.isEmpty()) {
      int[] now = q.poll();

      for (int d = 0; d < 4; d++) {
        int nx = now[0] + dir[d][0];
        int ny = now[1] + dir[d][1];

        if (nx < 1 || ny < 1 || nx > N || ny > M || map[nx][ny] == 0) {
          continue;
        }

        if (map[nx][ny] == 1) {
          count[nx][ny] = count[now[0]][now[1]] + 1;
          map[nx][ny] = 0;
          q.add(new int[]{nx, ny});

          if (nx == N && ny == M) {
            break;
          }
        }
      }
    }

    System.out.println(count[N][M]);
  }
}
