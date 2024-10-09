package Baekjoon._2193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    if (N == 1) {
      System.out.println(1);
      return;
    }

    long[] dp = new long[N + 1];
    dp[1] = 1;
    dp[2] = 1;

    if (N <= 2) {
      System.out.println(dp[N]);
    } else {
      for (int i = 3; i <= N; i++) {
        dp[i] = 1;
        for (int j = i - 2; j >= 1; j--) {
          dp[i] += dp[j];
        }
      }

      System.out.println(dp[N]);
    }
  }
}

/*

1

10

100
101

1000
1010
1001

10000
10001
10010
10100
10101

dp[1] = 1
dp[2] = 2;
n >= 3 : dp[n] = dp[n - 2] + dp[n - 3] .... d[1] + 1;

 */
