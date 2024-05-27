package LeetCode.easy.Special_Array_With_X_Elements_Greater_Than_or_Equal_X;

class Solution {

  public int specialArray(int[] nums) {
    int[] arr = new int[1001];
    for (int num : nums) {
      arr[num]++;
    }

    int total = nums.length;
    for (int i = 0; i < 1001; i++) {
      if (i == total) {
        return i;
      }

      total -= arr[i];
    }

    return -1;
  }
}
