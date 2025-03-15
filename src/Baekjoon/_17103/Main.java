package Baekjoon._17103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  static final int MAX = 1000000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    boolean[] isPrime = new boolean[MAX + 1];
    getPrime(isPrime);

    for (int i = 0; i < T; i++) {
      int N = Integer.parseInt(br.readLine());

      int sum = 0;
      for (int a = 2; a * 2 <= N; a++) {
        int b = N - a;
        if (isPrime[a] && isPrime[b]) {
          sum++;
        }
      }

      System.out.println(sum);
    }
  }

  private static void getPrime(boolean[] isPrime) {
    Arrays.fill(isPrime, true);

    isPrime[0] = false;
    isPrime[1] = false;

    for (int i = 2; i * i <= MAX; i++) {
      if (isPrime[i]) {
        for (int j = i * i; j <= MAX; j += i) {
          isPrime[j] = false;
        }
      }
    }
  }
}
