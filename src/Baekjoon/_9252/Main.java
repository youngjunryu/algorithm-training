package Baekjoon._9252;

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

    int[][] map = new int[aLen + 1][bLen + 1];

    for (int i = 0; i < aLen; i++) {
      for (int j = 0; j < bLen; j++) {
        char ac = a.charAt(i);
        char bc = b.charAt(j);

        if (ac == bc) {
          map[i + 1][j + 1] = map[i][j] + 1;
        } else {
          map[i + 1][j + 1] = Math.max(map[i][j + 1], map[i + 1][j]);
        }
      }
    }

    StringBuilder lcs = new StringBuilder();
    int i = aLen, j = bLen;

    while (i > 0 && j > 0) {
      if (a.charAt(i - 1) == b.charAt(j - 1)) {
        lcs.append(a.charAt(i - 1));
        i--;
        j--;
      } else if (map[i - 1][j] > map[i][j - 1]) {
        i--;
      } else {
        j--;
      }
    }

    System.out.println(lcs.length());
    System.out.println(lcs.reverse());
  }
}
