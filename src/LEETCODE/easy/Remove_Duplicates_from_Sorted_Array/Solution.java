package LeetCode.easy.Remove_Duplicates_from_Sorted_Array;

class Solution {
  public int removeDuplicates(int[] nums) {
    int result = 1;
    int i = 0;

    for (int j = 1; j < nums.length; j++) {
      if (nums[i] != nums[j]) {
        nums[i + 1] = nums[j];
        i += 1;
        result++;
      }
    }

    return result;
  }
}
