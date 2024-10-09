package Baekjoon._1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    long[] dp = new long[n];
    dp[0] = arr[0];
    for (int i = 1; i < n; i++) {
      dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
    }

    long result = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      result = Math.max(dp[i], result);
    }
    System.out.println(result);
  }
}

/*

0 10 10
1 6 -4
2 9 3
3 10 1
4 15 5
5 21 6
6 -14 -35
7 -2 12
8 33 21
9 32 -1

 */
