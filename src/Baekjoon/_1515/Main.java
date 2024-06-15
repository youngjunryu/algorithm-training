package Baekjoon._1515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();

    int idx = 0;

    int base = 0;
    while (base++ <= 30000) {
      String tmp = String.valueOf(base);
      for (int i = 0; i < tmp.length(); i++) {
        if (tmp.charAt(i) == s.charAt(idx)) {
          idx++;
        }
        if (idx == s.length()) {
          System.out.println(base);
          return;
        }
      }
    }
  }
}
