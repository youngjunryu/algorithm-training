package LeetCode.easy.Two_Sum;

class Solution {
  public int[] twoSum(int[] nums, int target) {
    var first = -1;
    var second = -1;

    boolean flag = true;
    for (var i = 0; i < nums.length && flag; i++) {
      first = i;
      var val = target - nums[i];
      for (var j = i + 1; j < nums.length; j++) {
        if (val == nums[j]) {
          second = j;
          flag = false;
          break;
        }
      }
    }

    return new int[]{first, second};
  }
}
