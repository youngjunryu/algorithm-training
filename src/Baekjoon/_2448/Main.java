package Baekjoon._2448;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static char[][] map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    map = new char[N][2 * N - 1];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < 2 * N - 1; j++) {
        map[i][j] = ' ';
      }
    }

    pow(0, N - 1, N);

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < 2 * N - 1; j++) {
        sb.append(map[i][j]);
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }

  private static void pow(int r, int c, int n) {
    if (n == 3) {
      map[r][c] = '*';
      map[r + 1][c - 1] = map[r + 1][c + 1] = '*';
      map[r + 2][c - 2] = map[r + 2][c - 1] = map[r + 2][c] = map[r + 2][c + 1] = map[r + 2][c
          + 2] = '*';
    } else {
      int cut = n / 2;
      pow(r, c, cut);
      pow(r + cut, c - cut, cut);
      pow(r + cut, c + cut, cut);
    }
  }
}
