package Baekjoon._2775;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      int K = Integer.parseInt(br.readLine());
      int N = Integer.parseInt(br.readLine());
      int[] arr = new int[N];

      for (int j = 0; j < N; j++) {
        arr[j] = j + 1;
      }

      for (int j = 0; j < K; j++) {
        for (int k = 1; k < N; k++) {
          arr[k] += arr[k - 1];
        }
      }

      System.out.println(arr[N - 1]);
    }
  }
}

