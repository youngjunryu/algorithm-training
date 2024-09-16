package Baekjoon._11727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] dp = new int[N + 1];

    if (N == 1) {
      System.out.println(1);
      return;
    } else if (N == 2) {
      System.out.println(3);
      return;
    }

    dp[1] = 1;
    dp[2] = 3;

    for (int i = 3; i <= N; i++) {
      dp[i] = (2 * dp[i - 2] + dp[i - 1]) % 10007;
    }

    System.out.println(dp[N]);
  }
}
