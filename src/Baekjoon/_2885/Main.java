package Baekjoon._2885;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int K = Integer.parseInt(br.readLine());

    int n = 1;
    while (n < K) {
      n *= 2;
    }

    StringBuilder sb = new StringBuilder();
    sb.append(n).append(" ");

    int result = 0;
    while (K != 0) {
      if (K >= n) {
        K -= n;
      } else {
        n /= 2;
        result++;
      }
    }

    sb.append(result);
    System.out.println(sb);
  }
}
