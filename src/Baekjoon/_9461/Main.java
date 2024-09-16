package Baekjoon._9461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    long[] dp = new long[101];
    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 1;
    dp[3] = 2;

    for (int i = 4; i <= 100; i++) {
      dp[i] = dp[i - 2] + dp[i - 3];
    }

    for (int t = 0; t < T; t++) {
      int N = Integer.parseInt(br.readLine());
      System.out.println(dp[N - 1]);
    }
  }
}

/*

1 1 1 2 2 3 4 5 7 9 12 16 21





 */