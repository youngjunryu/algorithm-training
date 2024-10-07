package Baekjoon._1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    for (int t = 0; t < T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      int[][] dp = new int[N + 1][M + 1];
      for (int i = 1; i <= M; i++) {
        dp[1][i] = i;
      }

      for (int i = 2; i <= N; i++) {
        for (int j = i; j <= M; j++) {
          for (int k = j; k >= i; k--) {
            dp[i][j] += dp[i - 1][k - 1];
          }
        }
      }

      System.out.println(dp[N][M]);
    }
  }
}
