package Baekjoon._15829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int L = Integer.parseInt(br.readLine());
    String str = br.readLine();

    long result = 0;
    for (int i = 0; i < L; i++) {
      int v = str.charAt(i) - 'a' + 1;
      result += v * hash(i);
    }

    result = result % 1234567891;
    System.out.println(result);
  }

  private static long hash(int n) {
    return n == 0 ? 1 : 31 * hash(n - 1) % 1234567891;
  }
}
