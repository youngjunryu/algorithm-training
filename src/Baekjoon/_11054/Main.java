package Baekjoon._11054;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int[] up = new int[N];
    int[] down = new int[N];

    for (int i = 0; i < N; i++) {
      up[i] = 1;
      for (int u = 0; u < i; u++) {
        if (arr[u] < arr[i]) {
          up[i] = Math.max(up[i], up[u] + 1);
        }
      }
    }

    for (int i = N - 1; i >= 0; i--) {
      down[i] = 1;
      for (int d = N - 1; d > i; d--) {
        if (arr[d] < arr[i]) {
          down[i] = Math.max(down[d] + 1, down[i]);
        }
      }
    }

    int result = 0;

    for (int i = 0; i < N; i++) {
      System.out.println(i + " " + up[i] + " " + down[i]);
      result = Math.max(up[i] + down[i] - 1, result);
    }

    System.out.println(result);
  }
}
