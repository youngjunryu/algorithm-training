package Baekjoon._11066;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      int n = Integer.parseInt(br.readLine());
      int[] sum = new int[n + 1];

      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 1; i <= n; i++) {
        sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
      }

      int[][] dp = new int[n + 1][n + 1];

      for (int i = 1; i < n; i++) {
        for (int from = 1; from + i <= n; from++) {
          int to = from + i;
          dp[from][to] = Integer.MAX_VALUE;
          for (int mid = from; mid < to; mid++) {
            dp[from][to] = Math.min(dp[from][to],
                dp[from][mid] + dp[mid + 1][to] + sum[to] - sum[from - 1]);
          }
        }
      }

      System.out.println(dp[1][n]);
    }
  }
}
