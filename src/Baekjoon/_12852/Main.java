package Baekjoon._12852;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] dp = new int[N + 1];

    Arrays.fill(dp, Integer.MAX_VALUE);

    dp[1] = 0;

    int[] trace = new int[N + 1];

    for (int i = 2; i <= N; i++) {
      if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
        dp[i] = dp[i / 3] + 1;
        trace[i] = i / 3;
      }

      if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
        dp[i] = dp[i / 2] + 1;
        trace[i] = i / 2;
      }

      if (dp[i] > dp[i - 1] + 1) {
        dp[i] = dp[i - 1] + 1;
        trace[i] = i - 1;
      }
    }

    System.out.println(dp[N]);

    int num = N;
    StringBuilder result = new StringBuilder();
    result.append(num).append(" ");

    while (true) {
      num = trace[num];
      if (num == 0) {
        break;
      }

      result.append(num).append(" ");
      if (num == 1) {
        break;
      }
    }

    System.out.println(result);
  }
}
