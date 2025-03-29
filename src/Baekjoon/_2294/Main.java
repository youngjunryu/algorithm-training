package Baekjoon._2294;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[] cost = new int[n];
    for (int i = 0; i < n; i++) {
      cost[i] = Integer.parseInt(br.readLine());
    }

    int[] dp = new int[k + 1];
    Arrays.fill(dp, k + 1);
    dp[0] = 0;

    for (int i = 0; i < n; i++) {
      for (int j = cost[i]; j <= k; j++) {
        dp[j] = Math.min(dp[j], dp[j - cost[i]] + 1);
      }
    }

    if (dp[k] == k + 1) {
      System.out.println(-1);
      return
    }

    System.out.println(dp[k]);
  }
}
