package Archiving.LEETCODE;

public class Coin_Change {
  public static int coinChange(int[] coins, int amount) {
    if (amount == 0) {
      return 0;
    }

    int[] dp = new int[10001];
    dp[0] = 0;

    for (int i = 1; i <= amount; i++) {
      int min = 100000;
      for (int c : coins) {
        if (i >= c) {
          min = Math.min(min, dp[i - c] + 1);
        }
      }
      dp[i] = min;
    }

    if (dp[amount] == 100000) {
      return -1;
    }

    return dp[amount];
  }

  public static void main(String[] args) {
    coinChange(new int[]{1, 2, 5}, 11);
  }
}
