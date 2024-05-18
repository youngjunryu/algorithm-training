package Baekjoon._7568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[][] arr = new int[N][2];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
    }

    int[] result = new int[N];
    for (int i = 0; i < N; i++) {
      int[] me = arr[i];
      int val = 0;
      for (int j = 0; j < N; j++) {
        if (i == j) {
          continue;
        }

        int[] next = arr[j];
        if (me[0] < next[0] && me[1] < next[1]) {
          val++;
        }
      }
      result[i] = val + 1;
    }

    for (int i : result) {
      System.out.print(i + " ");
    }
  }
}
