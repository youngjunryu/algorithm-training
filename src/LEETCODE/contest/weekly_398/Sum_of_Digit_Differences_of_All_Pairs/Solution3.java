package LeetCode.contest.weekly_398.Sum_of_Digit_Differences_of_All_Pairs;

class Solution3 {

  public long sumDigitDifferences(int[] nums) {
    int total = nums.length;
    int len = String.valueOf(nums[0]).length();
    long result = 0;

    for (int i = 0; i < len; i++) {
      int[] cnt = new int[10];

      for (int j = 0; j < total; j++) {
        int val = String.valueOf(nums[j]).charAt(i) - '0';
        cnt[val]++;

        result += (j + 1 - cnt[val]);
      }
    }

    return result;
  }
}
