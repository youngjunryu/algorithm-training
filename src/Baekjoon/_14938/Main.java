package Baekjoon._14938;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int n;
  static int m;
  static int r;
  static int[] point;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());
    point = new int[n + 1];

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= n; i++) {
      point[i] = Integer.parseInt(st.nextToken());
    }

    int[][] dist = new int[n + 1][n + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (i == j) {
          dist[i][j] = 0;
        } else {
          dist[i][j] = 123456789;
        }
      }
    }

    for (int i = 0; i < r; i++) {
      st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int l = Integer.parseInt(st.nextToken());

      dist[a][b] = l;
      dist[b][a] = l;
    }

    for (int k = 1; k <= n; k++) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
        }
      }
    }

    int result = -1;
    for (int i = 1; i <= n; i++) {
      int count = 0;
      for (int j = 1; j <= n; j++) {
        int cost = dist[i][j];
        if (cost <= m) {
          count += point[j];
        }
      }
      result = Math.max(count, result);
    }

    System.out.println(result);
  }
}
