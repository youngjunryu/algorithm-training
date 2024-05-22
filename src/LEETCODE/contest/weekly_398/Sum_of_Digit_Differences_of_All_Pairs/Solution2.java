package LeetCode.contest.weekly_398.Sum_of_Digit_Differences_of_All_Pairs;

import java.util.Arrays;

class Solution2 {

  public int minimumAddedCoins(int[] coins, int target) {
    Arrays.sort(coins);

    int idx = 0;
    int max = 0;
    int result = 0;

    while (max < target) {
      if (idx < coins.length && coins[idx] <= max + 1) {
        max = max + coins[idx];
        idx++;
      } else {
        max = max + max + 1;
        result++;
      }
    }

    return result;
  }
}

