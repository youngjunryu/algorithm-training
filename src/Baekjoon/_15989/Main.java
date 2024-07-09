package Baekjoon._15989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    int[] dp = new int[10001];
    dp[0] = 1;

    for (int i = 1; i <= 3; i++) {
      for (int j = i; j <= 10000; j++) {
        dp[j] += dp[j - i];
      }
    }

    for (int i = 0; i < T; i++) {
      int n = Integer.parseInt(br.readLine());
      System.out.println(dp[n]);
    }
  }
}
