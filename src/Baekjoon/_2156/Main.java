package Baekjoon._2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] grape = new int[10001];

    for (int i = 0; i < N; i++) {
      grape[i] = Integer.parseInt(br.readLine());
    }

    int[] dp = new int[10001];
    dp[0] = grape[0];
    dp[1] = grape[0] + grape[1];
    dp[2] = Math.max(Math.max(grape[0], grape[1]) + grape[2], dp[1]);

    for (int i = 3; i < N; i++) {
      dp[i] = Math.max(Math.max(dp[i - 3] + grape[i - 1] + grape[i], dp[i - 2] + grape[i]),
          dp[i - 1]);
    }

    System.out.println(dp[N - 1]);
  }
}
/*

XXX

 */