package LeetCode.contest.weekly_398.Special_Array_I;

class Solution {

  public boolean isArraySpecial(int[] nums) {
    if (nums.length == 1) {
      return true;
    }
    for (int i = 0; i < nums.length - 1; i++) {
      boolean num1 = nums[i] % 2 == 0;
      boolean num2 = nums[i + 1] % 2 == 0;
      if (num1 == num2) {
        return false;
      }
    }
    return true;
  }
}
