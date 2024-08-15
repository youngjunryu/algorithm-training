package Baekjoon._1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int count;
  static int result;
  static int r, c;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    count = -1;

    int len = (int) Math.pow(2, N);
    conquer(len, 0, 0);

    System.out.println(result);
  }

  private static void conquer(int n, int x, int y) {
    if (n == 2) {
      for (int i = x; i < x + 2; i++) {
        for (int j = y; j < y + 2; j++) {
          count++;
          if (i == r && j == c) {
            result = count;
          }
        }
      }
      return;
    }

    if (x <= r && r <= x + n / 2 && y <= c && c <= y + n / 2) {
      conquer(n / 2, x, y);
    } else {
      count += (int) Math.pow(n / 2, 2);
    }

    if (x <= r && r <= x + n / 2 && y + n / 2 <= c && c <= y + n) {
      conquer(n / 2, x, y + n / 2);
    } else {
      count += (int) Math.pow(n / 2, 2);
    }

    if (x + n / 2 <= r && r <= x + n && y <= c && c <= y + n / 2) {
      conquer(n / 2, x + n / 2, y);
    } else {
      count += (int) Math.pow(n / 2, 2);
    }

    if (x + n / 2 <= r && r <= x + n && y + n / 2 <= c && c <= y + n) {
      conquer(n / 2, x + n / 2, y + n / 2);
    } else {
      count += (int) Math.pow(n / 2, 2);
    }
  }
}
