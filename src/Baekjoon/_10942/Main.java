package Baekjoon._10942;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int[] arr;
  static boolean[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    arr = new int[N + 1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i + 1] = Integer.parseInt(st.nextToken());
    }

    dp = new boolean[N + 1][N + 1];

    StringBuilder sb = new StringBuilder();

    int M = Integer.parseInt(br.readLine());
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      if (check(s, e)) {
        sb.append("1\n");
      } else {
        sb.append("0\n");
      }
    }

    System.out.println(sb);
  }

  private static boolean check(int s, int e) {
    if (s >= e) {
      return true;
    }

    if (dp[s][e]) {
      return dp[s][e];
    }

    if (arr[s] == arr[e]) {
      return dp[s][e] = check(s + 1, e - 1);
    }

    return false;
  }
}
