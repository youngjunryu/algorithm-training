package Baekjoon._1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static String[] map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    map = new String[N];

    for (int i = 0; i < N; i++) {
      map[i] = br.readLine();
    }

    System.out.println(qt(0, 0, N));
  }

  private static String qt(int x, int y, int len) {
    char c = map[x].charAt(y);
    for (int i = x; i < x + len; i++) {
      for (int j = y; j < y + len; j++) {
        if (c != map[i].charAt(j)) {
          return "(" + qt(x, y, len / 2) + qt(x, y + len / 2, len / 2) + qt(x + len / 2, y, len / 2)
              + qt(x + len / 2, y + len / 2, len / 2) + ")";
        }
      }
    }

    return String.valueOf(map[x].charAt(y));
  }
}
