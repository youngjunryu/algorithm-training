package Baekjoon._1072;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());

    int initZ = (int) Math.floor(((long) y * 100 / x));

    if (initZ >= 99) {
      System.out.println(-1);
      return;
    }

    int start = 1;
    int end = 1000000000;

    int result = end;

    while (start <= end) {
      int mid = (start + end) / 2;

      int nextZ = (int) Math.floor(((long) (y + mid) * 100 / (x + mid)));

      if (nextZ != initZ) {
        result = mid;
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }

    System.out.println(result);
  }
}
