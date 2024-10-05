package Baekjoon._11049;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[][] matrix = new int[N][2];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      matrix[i][0] = r;
      matrix[i][1] = c;
    }

    int[][] dp = new int[N][N];

    for (int range = 2; range <= N; range++) {
      for (int i = 0; i <= N - range; i++) {
        int j = i + range - 1;

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
          min = Math.min(min, dp[i][k] + dp[k + 1][j] + matrix[i][0] * matrix[k][1] * matrix[j][1]);
        }

        dp[i][j] = min;
      }
    }

    System.out.println(dp[0][N - 1]);
  }
}
