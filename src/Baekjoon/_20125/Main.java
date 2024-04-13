package Baekjoon._20125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  static char[][] map = new char[1001][1001];
  static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    for (int i = 1; i <= N; i++) {
      String str = br.readLine();
      for (int j = 1; j <= N; j++) {
        map[i][j] = str.charAt(j - 1);
      }
    }

    int[] hearts = getHeart(N);
    int[] len = new int[5];
    int idx = 0;

    int[] now = new int[]{hearts[0], hearts[1]};
    int result = 0;

    // 왼쪽 팔
    while (true) {
      int[] next = new int[]{now[0] + dir[3][0], now[1] + dir[3][1]};
      if (!check(next)) {
        len[idx] = result;
        break;
      }
      result++;
      now = next.clone();
    }

    // 오른쪽 팔
    idx++;
    now = new int[]{hearts[0], hearts[1]};
    result = 0;
    while (true) {
      int[] next = new int[]{now[0] + dir[1][0], now[1] + dir[1][1]};
      if (!check(next)) {
        len[idx] = result;
        break;
      }
      result++;
      now = next.clone();
    }

    // 허리
    idx++;
    now = new int[]{hearts[0], hearts[1]};
    result = 0;
    while (true) {
      int[] next = new int[]{now[0] + dir[2][0], now[1] + dir[2][1]};
      if (!check(next)) {
        len[idx] = result;
        break;
      }
      result++;
      now = next.clone();
    }

    int lastX = now[0];
    int lastY = now[1];

    // 왼쪽 다리
    idx++;
    result = 0;
    now[0] = lastX;
    now[1] = lastY - 1;
    while (true) {
      int[] next = new int[]{now[0] + dir[2][0], now[1] + dir[2][1]};
      if (!check(next)) {
        len[idx] = result;
        break;
      }
      result++;
      now = next.clone();
    }

    // 오른쪽 다리
    idx++;
    result = 0;
    now[0] = lastX;
    now[1] = lastY + 1;
    while (true) {
      int[] next = new int[]{now[0] + dir[2][0], now[1] + dir[2][1]};
      if (!check(next)) {
        len[idx] = result;
        break;
      }
      result++;
      now = next.clone();
    }

    // 심장이 위치한 행의 번호 x와 열의 번호 y
    System.out.println(hearts[0] + " " + hearts[1]);
    // 왼쪽 팔, 오른쪽 팔, 허리, 왼쪽 다리, 오른쪽 다리의 길이
    Arrays.stream(len).forEach(a -> System.out.print(a + " "));
  }

  private static boolean check(int[] next) {
    if (next[0] > N || next[1] > N || next[0] < 1 || next[1] < 1) {
      return false;
    }

    if (map[next[0]][next[1]] != '*') {
      return false;
    }

    return true;
  }

  private static int[] getHeart(int N) {
    for (int i = 2; i <= N - 2; i++) {
      for (int j = 2; j <= N - 2; j++) {
        boolean flag = true;
        if (map[i][j] == '*') {
          for (int d = 0; d < 4; d++) {
            int dx = i + dir[d][0];
            int dy = j + dir[d][1];
            if (map[dx][dy] != '*') {
              flag = false;
              break;
            }
          }

          if (flag) {
            return new int[]{i, j};
          }
        }
      }
    }

    return null;
  }
}
