package Baekjoon._17626;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    int[] dp = new int[N + 1];
    dp[1] = 1;

    for (int i = 2; i <= N; i++) {
      int result = Integer.MAX_VALUE;
      for (int j = 1; j * j <= i; j++) {
        int k = i - j * j;
        result = Math.min(dp[k], result);
      }
      dp[i] = result + 1;
    }

    System.out.println(dp[N]);
  }
}
