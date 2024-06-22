package LeetCode.medium.Count_Number_of_Nice_Subarrays;

class Solution {

  public int numberOfSubarrays(int[] nums, int k) {
    int result = 0;
    int runningCount = 0;
    int oddCount = 0;
    int l = 0;

    for (int r = 0; r < nums.length; r++) {
      if (nums[r] % 2 != 0) {
        oddCount++;
        runningCount = 0;
      }

      while (oddCount == k) {
        runningCount++;
        if (nums[l] % 2 != 0) {
          oddCount--;
        }
        l++;
      }

      result += runningCount;
    }
    return result;
  }
}
