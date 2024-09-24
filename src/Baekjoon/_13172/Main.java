package Baekjoon._13172;

import java.util.Scanner;

public class Main {

  static final int MOD = 1000000007;

  public static long getReverse(long x, long y) {
    if (y == 1) {
      return x;
    }

    if (y % 2 == 1) {
      return (x * getReverse(x, y - 1)) % MOD;
    }

    long val = getReverse(x, y / 2);
    return (val * val) % MOD;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int M = sc.nextInt();
    long ans = 0;

    for (int i = 0; i < M; i++) {
      int N = sc.nextInt();
      int S = sc.nextInt();
      long val = (S * getReverse(N, MOD - 2)) % MOD;
      ans += (val % MOD);
    }

    System.out.println(ans % MOD);
    sc.close();
  }
}
