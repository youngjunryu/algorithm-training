package Baekjoon._1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N, S;
  static int[] arr;
  static int result = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());

    arr = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    go(0, 0);

    if (S == 0) {
      result -= 1;
    }

    System.out.println(result);
  }

  private static void go(int idx, int sum) {
    if (N == idx) {
      if (sum == S) {
        result++;
      }
      return;
    }

    go(idx + 1, arr[idx] + sum);
    go(idx + 1, sum);
  }
}
