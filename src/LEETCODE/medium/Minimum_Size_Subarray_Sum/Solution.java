package LeetCode.medium.Minimum_Size_Subarray_Sum;

public class Solution {

  public int minSubArrayLen(int target, int[] nums) {
    int left = 1;
    int right = nums.length;
    int mn = 0;

    while (left <= right) {
      int mid = (left + right) / 2;

      if (windowCheck(mid, nums, target)) {
        mn = mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return mn;
  }

  private boolean windowCheck(int size, int[] nums, int target) {
    int i = 0;
    int j = 0;
    int sum = 0;
    int mn = Integer.MIN_VALUE;

    while (j < nums.length) {
      sum += nums[j];

      while (j - i + 1 == size) {
        mn = Math.max(sum, mn);
        sum -= nums[i];
        i++;
      }

      j++;
    }

    if (mn >= target) {
      return true;
    }
    return false;
  }
}
