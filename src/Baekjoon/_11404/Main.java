package Baekjoon._11404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());

    int[][] map = new int[n + 1][n + 1];

    for (int i = 0; i <= n; i++) {
      Arrays.fill(map[i], 1000_0001);
    }

    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == j) {
          map[i][j] = 0;
        }
      }
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      map[a][b] = Math.min(c, map[a][b]);
    }

    for (int k = 1; k <= n; k++) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          map[i][j] = Math.min(map[i][k] + map[k][j], map[i][j]);
        }
      }
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (map[i][j] == 1000_0001) {
          System.out.print(0 + " ");
        } else {
          System.out.print(map[i][j] + " ");
        }
      }
      System.out.println();
    }
  }
}
