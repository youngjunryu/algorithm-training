package Baekjoon._1562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static final int MOD = 1000000000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    // dp[length][last][mask] 길이가 length인 계단 수에서 마지막 자리가 last 이고 mask로 나타낸 숫자들이 등장한 상태
    long[][][] dp = new long[n + 1][10][1024];

    for (int i = 1; i <= 9; i++) {
      dp[1][i][1 << i] = 1;
    }

    for (int len = 1; len < n; len++) {
      for (int last = 0; last <= 9; last++) {
        for (int mask = 0; mask < 1024; mask++) {
          if (dp[len][last][mask] == 0) {
            continue;
          }

          for (int status = -1; status <= 1; status += 2) {
            int next = last + status;

            if (next < 0 || next > 9) {
              continue;
            }

            int nextMask = mask | (1 << next);
            dp[len + 1][next][nextMask] = (dp[len + 1][next][nextMask] + dp[len][last][mask]) % MOD;
          }
        }
      }
    }

    long result = 0;
    for (int i = 0; i <= 9; i++) {
      result = (result + dp[n][i][1023]) % MOD;
    }

    System.out.println(result);
  }
}
