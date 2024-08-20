package Baekjoon._1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[][] map = new int[n][n];

    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < i + 1; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int[][] dp = new int[n][n];

    dp[0][0] = map[0][0];

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i + 1; j++) {
        if (j == 0) {
          dp[i][j] = dp[i - 1][j] + map[i][j];
        } else if (j == i) {
          dp[i][j] = dp[i - 1][j - 1] + map[i][j];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + map[i][j];
        }
      }
    }

    int result = 0;
    for (int i = 0; i < n; i++) {
      result = Math.max(dp[n - 1][i], result);
    }

    System.out.println(result);
  }
}
