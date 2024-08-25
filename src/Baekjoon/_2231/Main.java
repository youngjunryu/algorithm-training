package Baekjoon._2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    for (int i = 1; i <= 1000000; i++) {
      int val = i;
      int sum = i;
      while (val != 0) {
        sum += val % 10;
        val /= 10;
      }

      if (sum == N) {
        System.out.println(i);
        return;
      }
    }

    System.out.println(0);
  }
}

/*

198 + 18 = 216

216 + 2 + 1 + 6 =

 */