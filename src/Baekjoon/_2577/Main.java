package Baekjoon._2577;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    long m = 1;
    for (int i = 0; i < 3; i++) {
      m *= Integer.parseInt(br.readLine());
    }

    int[] result = new int[10];

    while (m != 0) {
      int val = (int) (m % 10);
      result[val]++;
      m /= 10;
    }

    for (int i = 0; i < 10; i++) {
      System.out.println(result[i]);
    }
  }
}
