package Baekjoon._10830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static long[][] start;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    long B = Long.parseLong(st.nextToken());

    long[][] map = new long[N][N];
    start = new long[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        long val = Long.parseLong(st.nextToken()) % 1000;
        map[i][j] = val;
        start[i][j] = val;
      }
    }

    long[][] result = pow(map, B);

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        System.out.print(result[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static long[][] pow(long[][] now, long n) {
    if (n == 1) {
      return now;
    }

    long[][] temp = pow(now, n / 2);
    if (n % 2 == 0) {
      return multiply(temp, temp);
    } else {
      return multiply(multiply(temp, temp), start);
    }
  }

  public static long[][] multiply(long[][] a, long[][] b) {
    long[][] result = new long[N][N];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        for (int k = 0; k < N; k++) {
          result[i][j] += (a[i][k] * b[k][j]) % 1000;
          result[i][j] %= 1000;
        }
      }
    }

    return result;
  }
}
