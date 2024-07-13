package Baekjoon._1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());
    int[] a = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      a[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(a);

    int M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      int m = Integer.parseInt(st.nextToken());
      if (check(a, m)) {
        System.out.println(1);
      } else {
        System.out.println(0);
      }
    }
  }

  private static boolean check(int[] a, int m) {
    int left = 0;
    int right = a.length - 1;

    while (left <= right) {
      int mid = (left + right) / 2;
      if (a[mid] > m) {
        right = mid - 1;
      } else if (a[mid] < m) {
        left = mid + 1;
      } else {
        return true;
      }
    }

    return false;
  }
}
