package Baekjoon._21736;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    char[][] map = new char[N][M];
    int sx = 0, sy = 0;
    int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    for (int i = 0; i < N; i++) {
      String val = br.readLine();
      for (int j = 0; j < M; j++) {
        char c = val.charAt(j);
        map[i][j] = c;

        if (c == 'I') {
          sx = i;
          sy = j;
        }
      }
    }

    int result = 0;
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{sx, sy});
    while (!q.isEmpty()) {
      int[] now = q.poll();
      int x = now[0];
      int y = now[1];

      for (int d = 0; d < 4; d++) {
        int nx = x + dir[d][0];
        int ny = y + dir[d][1];

        if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 'X' || map[nx][ny] == 'I') {
          continue;
        }

        if (map[nx][ny] == 'P') {
          result++;
        }

        map[nx][ny] = 'I';
        q.add(new int[]{nx, ny});
      }
    }

    if (result == 0) {
      System.out.println("TT");
    } else {
      System.out.println(result);
    }
  }
}
