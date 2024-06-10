package LeetCode.contest.weekly_401.Find_the_N_th_Value_After_K_Seconds;

import java.util.Arrays;

class Solution {

  public int valueAfterKSeconds(int n, int k) {
    int[] arr = new int[n + 1];

    Arrays.fill(arr, 1);
    int mod = 1000000007;

    for (int i = 1; i <= k; i++) {
      for (int j = 1; j <= n; j++) {
        arr[j] = (arr[j - 1] % mod + arr[j] % mod) % mod;
      }
    }

    return arr[n - 1];
  }
}