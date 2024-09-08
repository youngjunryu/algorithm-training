package Baekjoon._11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(arr);

    int result = 0;
    for (int i = N - 1; i >= 0; i--) {
      int val = arr[i];

      if (K >= val) {
        result += K / val;
        K = K % val;
      }
    }

    System.out.println(result);
  }
}
