package Baekjoon._15652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N, M;
  static int[] arr;
  static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[M];
    sb = new StringBuilder();

    back(1, 0);
    System.out.println(sb.toString());
  }

  private static void back(int now, int depth) {
    if (depth == M) {
      for (int n : arr) {
        sb.append(n).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = now; i <= N; i++) {
      arr[depth] = i;
      back(i, depth + 1);
    }
  }
}
