package Baekjoon._2292;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    if (N == 1) {
      System.out.println(1);
      return;
    }

    int start = 1;
    int idx = 1;

    while (true) {
      int right = start + 6 * idx;

      if (start < N && N <= right) {
        System.out.println(idx + 1);
        break;
      }

      start = right;
      idx++;
    }
  }
}
