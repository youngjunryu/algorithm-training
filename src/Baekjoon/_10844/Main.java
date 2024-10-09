package Baekjoon._10844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static final int MOD = 1_000_000_000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    long[][] dp = new long[N + 1][10];

    for (int i = 1; i <= 9; i++) {
      dp[1][i] = 1;
    }

    for (int len = 2; len <= N; len++) {
      for (int last = 0; last <= 9; last++) {
        if (last == 0) {
          dp[len][last] = dp[len - 1][last + 1] % MOD;
        } else if (last == 9) {
          dp[len][last] = dp[len - 1][last - 1] % MOD;
        } else {
          dp[len][last] = dp[len - 1][last - 1] % MOD + dp[len - 1][last + 1] % MOD;
        }
      }
    }

    long result = 0;
    for (int last = 0; last <= 9; last++) {
      result += dp[N][last] % MOD;
    }

    System.out.println(result % MOD);
  }
}

/*

1 2 3 4 5 6 7 8 9
10 12 | 21 23 | 32 34 | 43 45 | 54 56 | 65 67 | 76 78 | 87 89 | 98
101 121 123 | 210 212 232 234 | 321 323 343 345 | 432 434 454 456 | ...
1010 1012 1210 1212 1232 1234 | 2101 2121 2123 2321 2323 2343 2345 | ...
10101 10121 10121 12101 12101 12121 12123 12321 12323 12343 12345 |

 */