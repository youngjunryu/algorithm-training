package Baekjoon._6064;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int t = 0; t < T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int M = Integer.parseInt(st.nextToken());
      int N = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken()) - 1;
      int y = Integer.parseInt(st.nextToken()) - 1;

      int year = x;
      boolean flag = false;

      while (year < M * N) {
        if (year % N == y) {
          flag = true;
          break;
        } else {
          year += M;
        }
      }

      if (flag) {
        System.out.println(year + 1);
      } else {
        System.out.println(-1);
      }
    }
  }
}
