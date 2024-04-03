package Baekjoon._1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    int K = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());

    int[] arr = new int[K];

    for (int i = 0; i < K; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    long left = 0;
    long right = (long)((Math.pow(2, 31)) - 1);

    while (left <= right) {
      long mid = (left + right) / 2;

      long sum = calculate(arr, mid);
      if (sum < N) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    System.out.println(right);
  }

  public static long calculate(int[] arr, long mid) {
    long sum = 0;
    for (int a : arr) {
      sum += a / mid;
    }
    return sum;
  }
}
