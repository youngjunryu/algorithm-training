package LeetCode.contest.weekly_398.Sum_of_Digit_Differences_of_All_Pairs;

class Solution {

  public long sumDigitDifferences(int[] nums) {
    long result = 0;
    int n = nums.length;
    int len = (nums[0] + "").length();

    for (int i = 0; i < len; i++) {
      int[] arr = new int[10];

      for (int j = 0; j < n; j++) {
        int cur = (nums[j] + "").charAt(i) - '0';
        arr[cur]++;

        result += (j + 1 - arr[cur]);
      }
    }

    return result;
  }
}


