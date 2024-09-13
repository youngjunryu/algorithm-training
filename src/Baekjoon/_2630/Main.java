package Baekjoon._2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int[][] map;
  static int whiteCnt, blueCnt;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    map = new int[N][N];
    whiteCnt = 0;
    blueCnt = 0;

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dfs(0, N - 1, 0, N - 1);

    System.out.println(whiteCnt);
    System.out.println(blueCnt);
  }

  private static void dfs(int sx, int ex, int sy, int ey) {
    int start = map[sx][sy];

    if (sx == ex && sy == ey) {
      if (start == 1) {
        blueCnt++;
      } else {
        whiteCnt++;
      }
      return;
    }

    boolean flag = true;

    for (int i = sx; i <= ex && flag; i++) {
      for (int j = sy; j <= ey; j++) {
        if (map[i][j] != start) {
          flag = false;
          break;
        }
      }
    }

    if (flag) {
      if (start == 1) {
        blueCnt += 1;
      } else {
        whiteCnt += 1;
      }
    } else {
      int up = (ex - sx) / 2;
      dfs(sx, sx + up, sy, sy + up);
      dfs(sx, sx + up, sy + up + 1, ey);
      dfs(sx + up + 1, ex, sy, sy + up);
      dfs(sx + up + 1, ex, sy + up + 1, ey);
    }
  }
}
