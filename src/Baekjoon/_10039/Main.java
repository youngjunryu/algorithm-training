package Baekjoon._10039;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int result = 0;
    for (int i = 0; i < 5; i++) {
      int val = Integer.parseInt(br.readLine());
      result += Math.max(val, 40);
    }
    System.out.println(result / 5);
  }
}
