package Baekjoon._1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[][] map = new int[N + 1][N + 1];

    for (int i = 0; i < N + 1; i++) {
      Arrays.fill(map[i], 10000000);
    }

    for (int i = 1; i < N + 1; i++) {
      map[i][i] = 0;
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      map[a][b] = 1;
      map[b][a] = 1;
    }

    for (int k = 1; k <= N; k++) {
      for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
          map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
        }
      }
    }

    int min = Integer.MAX_VALUE;
    int idx = -1;

    for (int i = 1; i <= N; i++) {
      int sum = 0;
      for (int j = 1; j <= N; j++) {
        sum += map[i][j];
      }
      if (min > sum) {
        idx = i;
        min = sum;
      }
    }

    System.out.println(idx);
  }
}
