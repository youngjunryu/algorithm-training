package Baekjoon._1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

  static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
  static int R, C;
  static HashSet<String> set;
  static String[][] map;
  static int result;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    set = new HashSet<>();

    map = new String[R][C];
    for (int i = 0; i < R; i++) {
      String str = br.readLine();
      for (int j = 0; j < C; j++) {
        map[i][j] = String.valueOf(str.charAt(j));
      }
    }

    set.add(map[0][0]);
    result = 0;
    backtracking(0, 0, 1);
    System.out.println(result);
  }

  private static void backtracking(int x, int y, int count) {
    result = Math.max(count, result);

    for (int d = 0; d < 4; d++) {
      int nx = x + dir[d][0];
      int ny = y + dir[d][1];

      if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
        continue;
      }

      String next = map[nx][ny];

      if (set.contains(next)) {
        continue;
      }

      set.add(next);
      backtracking(nx, ny, count + 1);
      set.remove(next);
    }
  }
}
