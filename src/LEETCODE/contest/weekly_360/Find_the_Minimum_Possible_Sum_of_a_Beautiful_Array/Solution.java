package LeetCode.contest.weekly_360.Find_the_Minimum_Possible_Sum_of_a_Beautiful_Array;

import java.util.*;

public class Solution {
  public long minimumPossibleSum(int n, int target) {
    long sum = 0;
    Set<Integer> set = new HashSet<>();
    int cur = 1;

    while (true) {
      if (!set.contains(target - cur)) {
        sum += cur;
        set.add(cur);
      }

      cur++;

      if (set.size() == n) {
        break;
      }
    }

    return sum;
  }
}
