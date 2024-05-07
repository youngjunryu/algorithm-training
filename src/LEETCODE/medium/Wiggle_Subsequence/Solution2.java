package LeetCode.medium.Wiggle_Subsequence;

public class Solution2 {

  public int wiggleMaxLength(int[] nums) {
    if (nums.length == 1) {
      return 1;
    }

    int answer = 1;
    int prevDiff = 0;

    for (int i = 1; i < nums.length; i++) {
      int diff = nums[i] - nums[i - 1];
      if ((prevDiff <= 0 && diff > 0) || (prevDiff >= 0 && diff < 0)) {
        answer++;
        prevDiff = diff;
      }
    }

    return answer;
  }
}
