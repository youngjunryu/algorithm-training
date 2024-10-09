package Baekjoon._11055;

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

    int[] dp = new int[N];
    dp[0] = arr[0];

    for (int i = 1; i < N; i++) {
      dp[i] = arr[i];
      for (int j = 0; j < i; j++) {
        if (arr[i] > arr[j]) {
          dp[i] = Math.max(dp[i], dp[j] + arr[i]);
        }
      }
    }

    int result = 0;
    for (int i = 0; i < N; i++) {
      result = Math.max(result, dp[i]);
    }
    System.out.println(result);
  }
}

/*

1 1
2 101
2 3
3 53
4 113
3 6


 */