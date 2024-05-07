package LeetCode.medium.Minimum_Number_if_Coins_to_be_Added;

public class Solution {

  public int solution(int[] coins, int target) {
    int idx = 0;
    int add = 0;
    int max = 0;

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
