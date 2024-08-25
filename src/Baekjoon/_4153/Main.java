package Baekjoon._4153;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    while (true) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      if (a == 0 && b == 0 && c == 0) {
        break;
      }

      int[] arr = new int[]{a, b, c};
      Arrays.sort(arr);

      double longest = Math.pow(arr[2], 2);
      double result = Math.pow(arr[1], 2) + Math.pow(arr[0], 2);

      if (longest == result) {
        System.out.println("right");
      } else {
        System.out.println("wrong");
      }
    }
  }
}
