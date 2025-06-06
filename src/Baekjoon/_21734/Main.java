package Baekjoon._21734;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();

    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      int val = (int) c;
      int sum = 0;
      while (val > 0) {
        sum += val % 10;
        val /= 10;
      }

      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < sum; j++) {
        sb.append(c);
      }
      System.out.println(sb);
    }
  }
}
