package Baekjoon._1978;

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

    int result = 0;

    for (int i = 0; i < N; i++) {
      int val = arr[i];

      if (val == 1) {
        continue;
      }

      if (check(val)) {
        result++;
      }
    }

    System.out.println(result);
  }

  private static boolean check(int val) {
    for (int j = 2; j <= Math.sqrt(val); j++) {
      if (val % j == 0) {
        return false;
      }
    }

    return true;
  }
}
