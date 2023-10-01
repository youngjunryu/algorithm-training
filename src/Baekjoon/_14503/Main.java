package Baekjoon._14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int n, m;
  static int[][] map;
  static Robot robot;
  static int[][] d = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());
    robot = new Robot(r, c, d);

    map = new int[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int result = run();
    System.out.println(result);
  }

  static int run() {
    map[robot.r][robot.c] = -1;
    int result = 1;

    while (true) {
      boolean check = false;
      for (int i = 0; i < 4; i++) {
        robot.changeDir();
        int nr = robot.r + d[robot.d][0];
        int nc = robot.c + d[robot.d][1];

        if (map[nr][nc] == 0) {
          map[nr][nc] = -1;
          robot.r = nr;
          robot.c = nc;
          result++;
          check = true;
          break;
        }
      }

      if (!check) {
        int nr = robot.r - d[robot.d][0];
        int nc = robot.c - d[robot.d][1];
        if (map[nr][nc] == 1) {
          return result;
        } else {
          robot.r = nr;
          robot.c = nc;
        }
      }
    }
  }

  static class Robot {
    int r, c;
    int d;

    public Robot(int r, int c, int d) {
      this.r = r;
      this.c = c;
      this.d = d;
    }

    public void changeDir() {
      if (d == 0) {
        d = 3;
      } else {
        d -= 1;
      }
    }
  }
}
