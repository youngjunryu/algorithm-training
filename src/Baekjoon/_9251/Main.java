package Baekjoon._9251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String a = br.readLine();
    String b = br.readLine();

    int aLen = a.length();
    int bLen = b.length();

    int[][] length = new int[aLen + 1][bLen + 1];

    for (int i = 0; i < aLen; i++) {
      for (int j = 0; j < bLen; j++) {
        if (a.charAt(i) == b.charAt(j)) {
          length[i + 1][j + 1] = length[i][j] + 1;
        } else {
          length[i + 1][j + 1] = Math.max(length[i][j + 1], length[i + 1][j]);
        }
      }
    }

    System.out.println(length[aLen][bLen]);
  }
}
