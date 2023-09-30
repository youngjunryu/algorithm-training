package Baekjoon._2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] val = new int[n];
    for (int i = 0; i < n; i++) {
      val[i] = Integer.parseInt(br.readLine());
    }

    // dp[n][0]: n-1 칸에서 한 칸 올라온 경우, dp[n][1]: n-2번째 칸에서 2칸 올라온 경우
    int[][] dp = new int[n][2];
    dp[0][0] = val[0];

    if (n > 1) {
      dp[1][0] = val[0] + val[1];
      dp[1][1] = val[1];
    }

    for (int i = 2; i < n; i++) {
      dp[i][0] = dp[i - 1][1] + val[i];
      dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + val[i];
    }

    int result = Math.max(dp[n - 1][0], dp[n - 1][1]);

    System.out.println(result);
  }
}
