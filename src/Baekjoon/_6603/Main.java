package Baekjoon._6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      N = Integer.parseInt(st.nextToken());

      if (N == 0) {
        return;
      }

      int[] arr = new int[N];
      for (int i = 0; i < N; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }

      back(arr, 0, 0, new StringBuilder());
      System.out.println();
    }
  }

  private static void back(int[] arr, int idx, int n, StringBuilder sb) {
    if (n == 6) {
      System.out.println(sb.toString());
      return;
    }

    for (int i = idx; i < N; i++) {
      sb.append(arr[i]).append(" ");
      back(arr, i + 1, n + 1, sb);
      sb.deleteCharAt(sb.length() - 1);
      sb.deleteCharAt(sb.length() - 1);

      if (arr[i] / 10 >= 1) {
        sb.deleteCharAt(sb.length() - 1);
      }
    }
  }
}
