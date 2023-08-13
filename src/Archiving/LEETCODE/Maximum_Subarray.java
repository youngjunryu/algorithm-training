package Archiving.LEETCODE;

public class Maximum_Subarray {
  public static int maxSubArray(int[] nums) {
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    int max = dp[0];

    for (int i = 1; i < nums.length; i++) {
      dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
      max = Math.max(max, dp[i]);
    }

    return max;
  }

  public static void main(String[] args) {
    maxSubArray(new int[]{5,4,-1,7,8});
  }
}
