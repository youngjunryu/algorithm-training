package Baekjoon._15684;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static boolean[][] ladder;
  static int n, m, h;
  static int answer = 4;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    h = Integer.parseInt(st.nextToken());

    ladder = new boolean[h + 1][n + 1];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      ladder[a][b] = true;
    }

    backtracking(0, 1, 1);
    System.out.println(answer > 3 ? -1 : answer);
  }

  static void backtracking(int count, int r, int c) {
    if (count >= answer) {
      return;
    }

    if (check()) {
      answer = Math.min(answer, count);
      return;
    }

    for (int i = r; i <= h; i++, c = 1) {
      for (int j = c; j < n; j++) {
        if (!ladder[i][j] && !ladder[i][j - 1] && !ladder[i][j + 1]) {
          ladder[i][j] = true;
          backtracking(count + 1, i, j + 2);
          ladder[i][j] = false;
        }
      }
    }
  }

  static boolean check() {
    for (int i = 1; i <= n; i++) {
      int current = i; // y

      for (int j = 1; j <= h; j++) { // x
        if (ladder[j][current]) {
          current++;
        } else if (current > 1 && ladder[j][current - 1]) {
          current--;
        }
      }

      if (current != i) {
        return false;
      }
    }

    return true;
  }
}

/*

5 5 6

1 1
3 2
2 3
5 1
5 4


1 1
1 2
2 2
3 2
3 3
4 3
5 3


 */