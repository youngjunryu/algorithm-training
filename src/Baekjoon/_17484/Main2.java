package Baekjoon._17484;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {

  static int N, M;
  static int[][] map;
  static int result;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    result = Integer.MAX_VALUE;
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int[][][] dp = new int[N][M][3];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        Arrays.fill(dp[i][j], result);
      }
    }

    for (int i = 0; i < M; i++) {
      dp[0][i][0] = map[0][i];
      dp[0][i][1] = map[0][i];
      dp[0][i][2] = map[0][i];
    }

    for (int i = 1; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (j == 0) {
          dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + map[i][j];
          dp[i][j][1] = dp[i - 1][j][0] + map[i][j];
        } else if (j == M - 1) {
          dp[i][j][2] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][0]) + map[i][j];
          dp[i][j][1] = dp[i - 1][j][2] + map[i][j];
        } else {
          dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + map[i][j];
          dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + map[i][j];
          dp[i][j][2] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][0]) + map[i][j];
        }
      }
    }

    for (int i = 0; i < M; i++) {
      for (int j = 0; j < 3; j++) {
        result = Math.min(dp[N - 1][i][j], result);
      }
    }

    System.out.println(result);
  }
}
