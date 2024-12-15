package Baekjoon._4179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int r, c;
  static char[][] map;
  static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    map = new char[r][c];
    Queue<int[]> fires = new LinkedList<>();
    Queue<int[]> spots = new LinkedList<>();
    boolean[][] visited = new boolean[r][c];

    for (int i = 0; i < r; i++) {
      String str = br.readLine();
      for (int j = 0; j < c; j++) {
        char current = str.charAt(j);
        map[i][j] = current;

        if (current == 'F') {
          fires.add(new int[]{i, j});
        } else if (current == 'J') {
          map[i][j] = '.';
          spots.add(new int[]{i, j, 0});
          visited[i][j] = true;
        }
      }
    }

    while (!spots.isEmpty()) {
      int fireTimes = fires.size();
      int spotTimes = spots.size();

      // 불 이동
      for (int i = 0; i < fireTimes; i++) {
        int[] now = fires.poll();

        for (int d = 0; d < 4; d++) {
          int nx = now[0] + dir[d][0];
          int ny = now[1] + dir[d][1];

          if (nx < 0 || ny < 0 || nx >= r || ny >= c || map[nx][ny] == '#' || map[nx][ny] == 'F') {
            continue;
          }

          map[nx][ny] = 'F';
          fires.add(new int[]{nx, ny});
        }
      }

      // 지훈 이동
      for (int i = 0; i < spotTimes; i++) {
        int[] now = spots.poll();

        for (int d = 0; d < 4; d++) {
          int nx = now[0] + dir[d][0];
          int ny = now[1] + dir[d][1];

          if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
            System.out.println(now[2] + 1);
            return;
          }

          if (map[nx][ny] == '#' || map[nx][ny] == 'F' || visited[nx][ny]) {
            continue;
          }

          visited[nx][ny] = true;
          spots.add(new int[]{nx, ny, now[2] + 1});
        }
      }
    }

    System.out.println("IMPOSSIBLE");
  }
}
