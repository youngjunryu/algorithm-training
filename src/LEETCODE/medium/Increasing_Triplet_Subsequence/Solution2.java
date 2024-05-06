package LeetCode.medium.Increasing_Triplet_Subsequence;

class Solution2 {

  public boolean increasingTriplet(int[] nums) {
    int first = Integer.MAX_VALUE;
    int second = Integer.MAX_VALUE;

    for (int n : nums) {
      if (first >= n) {
        first = n;
      } else if (second >= n) {
        second = n;
      } else {
        return true;
      }
    }

    return false;
  }
}