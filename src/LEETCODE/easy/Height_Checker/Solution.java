package LeetCode.easy.Height_Checker;

import java.util.Arrays;

class Solution {

  public int heightChecker(int[] heights) {
    int[] arr = heights.clone();
    Arrays.sort(heights);

    int result = 0;
    for (int i = 0; i < heights.length; i++) {
      if (arr[i] != heights[i]) {
        result++;
      }
    }

    return result;
  }
}
