package Baekjoon._2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    dfs(2, 1);
    dfs(3, 1);
    dfs(5, 1);
    dfs(7, 1);
  }

  private static void dfs(int num, int length) {
    if (length == N) {
      System.out.println(num);
      return;
    }

    for (int i = 1; i < 10; i += 2) {
      int next = num * 10 + i;
      if (isPrime(next)) {
        dfs(next, length + 1);
      }
    }
  }

  private static boolean isPrime(int n) {
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        return false;
      }
    }

    return true;
  }
}
