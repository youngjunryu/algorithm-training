package Baekjoon._2563;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[][] map = new int[101][101];

    int n = Integer.parseInt(br.readLine());
    while (n-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      for (int i = a; i < a + 10; i++) {
        for (int j = b; j < b + 10; j++) {
          map[i][j] = 1;
        }
      }
    }

    int result = 0;
    for (int i = 1; i <= 100; i++) {
      for (int j = 1; j <= 100; j++) {
        if (map[i][j] == 1) {
          result++;
        }
      }
    }

    System.out.println(result);
  }
}
