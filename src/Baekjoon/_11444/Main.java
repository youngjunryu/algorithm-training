package Baekjoon._11444;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  final static long MOD = 1000000007;
  public static long[][] origin = {{1, 1}, {1, 0}};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    long n = Long.parseLong(br.readLine());
    long[][] start = {{1, 1}, {1, 0}};

    System.out.println(pow(start, n - 1)[0][0]);
  }

  public static long[][] pow(long[][] val, long n) {
    if (n == 1 || n == 0) {
      return val;
    }

    long[][] result = pow(val, n / 2);

    if (n % 2 == 0) {
      return multiply(result, result);
    } else {
      return multiply(multiply(result, result), origin);
    }
  }

  private static long[][] multiply(long[][] a, long[][] b) {
    long[][] result = new long[2][2];

    result[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % MOD;
    result[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % MOD;
    result[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % MOD;
    result[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % MOD;

    return result;
  }
}
