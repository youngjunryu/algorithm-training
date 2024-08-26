package Baekjoon._11050;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    dp = new int[N + 1][K + 1];
    int result = binomial(N, K);
    System.out.println(result);
  }

  private static int binomial(int n, int r) {
    if (r == 0 || n == r) {
      return 1;
    }

    if (dp[n][r] == 0) {
      dp[n][r] = binomial(n - 1, r - 1) + binomial(n - 1, r);
    }

    return dp[n][r];
  }
}
