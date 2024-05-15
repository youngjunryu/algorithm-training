package Baekjoon._17266;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int[] arr;
  static int N;
  static int M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());
    arr = new int[M];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int left = 1;
    int right = 100000;

    while (left <= right) {
      int mid = (left + right) / 2;

      boolean result = check(mid);
      if (result) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    System.out.println(left);
  }

  private static boolean check(int len) {
    int prev = 0;

    for (int i = 0; i < M; i++) {
      int now = arr[i];

      if (now - len <= prev) {
        prev = now + len;
      } else {
        return false;
      }
    }

    if (prev < N) {
      return false;
    }

    return true;
  }
}
