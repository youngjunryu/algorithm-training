package Baekjoon._15654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static int N, M;
  static int[] temp;
  static StringBuilder sb;
  static int[] arr;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[N];
    temp = new int[M];
    sb = new StringBuilder();

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);
    visited = new boolean[N];

    back(0);
    System.out.println(sb.toString());
  }

  private static void back(int depth) {
    if (depth == M) {
      for (int n : temp) {
        sb.append(n).append(" ");
      }

      sb.append("\n");
      return;
    }

    for (int i = 0; i < N; i++) {
      if (!visited[i]) {
        temp[depth] = arr[i];
        visited[i] = true;
        back(depth + 1);
        visited[i] = false;
      }
    }
  }
}
