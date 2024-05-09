package LeetCode.medium.Minimum_Number_if_Coins_to_be_Added;

import java.util.Arrays;

public class Solution2 {

  public int minimumAddedCoins(int[] coins, int target) {
    Arrays.sort(coins);

    int max = 0;
    int idx = 0;
    int add = 0;

    while (max < target) {
      if (idx < coins.length && coins[idx] <= max + 1) {
        max = max + coins[idx];
        idx++;
      } else {
        max = max + max + 1;
        add++;
      }
    }

    return add;
  }
}
