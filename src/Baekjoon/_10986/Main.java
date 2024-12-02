package Baekjoon._10986;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    long[] prefixSum = new long[n + 1];
    long[] count = new long[m];

    long result = 0;

    for (int i = 1; i <= n; i++) {
      int num = sc.nextInt();
      prefixSum[i] = prefixSum[i - 1] + num;
      int remainder = (int) (prefixSum[i] % m);
      if (remainder < 0) {
        remainder += m;
      }

      count[remainder]++;
    }

    result += count[0];

    for (int i = 0; i < m; i++) {
      if (count[i] > 1) {
        result += (count[i] * (count[i] - 1)) / 2;
      }
    }

    System.out.println(result);
  }
}

