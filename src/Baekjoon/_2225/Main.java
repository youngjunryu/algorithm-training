package Baekjoon._2225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[][] dp = new int[N + 1][K + 1];

    // 0을 i개로 만드는 방법은 항상 1가지
    for (int i = 1; i <= K; i++) {
      dp[0][i] = 1;
    }

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= K; j++) {
        dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1000000000;
      }
    }

    System.out.println(dp[N][K]);
  }
}
