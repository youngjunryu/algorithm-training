package Baekjoon._2096;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static int MAX_VALUE = 1000_000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[][] map = new int[N][3];
    int[][] maxDp = new int[N][3];
    int[][] minDp = new int[N][3];

    for (int i = 0; i < N; i++) {
      Arrays.fill(minDp[i], MAX_VALUE);
    }

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        int val = Integer.parseInt(st.nextToken());
        if (i == 0) {
          maxDp[i][j] = val;
          minDp[i][j] = val;
        }

        map[i][j] = val;
      }
    }

    // 최대 점수 구하기
    for (int i = 1; i < N; i++) {
      for (int j = 0; j < 3; j++) {
        if (j == 0) {
          maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i - 1][j + 1] + map[i][j]);
        } else if (j == 2) {
          maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i - 1][j - 1] + map[i][j]);
        } else {
          maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i - 1][j - 1] + map[i][j]);
          maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i - 1][j + 1] + map[i][j]);
        }

        maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i - 1][j] + map[i][j]);
      }
    }

    // 최소 점수 구하기
    for (int i = 1; i < N; i++) {
      for (int j = 0; j < 3; j++) {
        if (j == 0) {
          minDp[i][j] = Math.min(minDp[i][j], minDp[i - 1][j + 1] + map[i][j]);
        } else if (j == 2) {
          minDp[i][j] = Math.min(minDp[i][j], minDp[i - 1][j - 1] + map[i][j]);
        } else {
          minDp[i][j] = Math.min(minDp[i][j], minDp[i - 1][j - 1] + map[i][j]);
          minDp[i][j] = Math.min(minDp[i][j], minDp[i - 1][j + 1] + map[i][j]);
        }
        minDp[i][j] = Math.min(minDp[i][j], minDp[i - 1][j] + map[i][j]);
      }
    }

    int min = MAX_VALUE;
    int max = -1;

    for (int i = 0; i < 3; i++) {
      min = Math.min(min, minDp[N - 1][i]);
      max = Math.max(max, maxDp[N - 1][i]);
    }

    System.out.println(max + " " + min);
  }
}
