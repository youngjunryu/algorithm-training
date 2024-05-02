package LeetCode.easy.Assign_Cookies;

import java.util.Arrays;

public class Solution {

  public int findContentChildren(int[] g, int[] s) {
    if (s.length == 0) {
      return 0;
    }

    Arrays.sort(g);
    Arrays.sort(s);

    int gIdx = g.length - 1;
    int sIdx = s.length - 1;

    int result = 0;
    for (int i = gIdx; i >= 0; i--) {
      if (s[sIdx] >= g[i]) {
        result++;
        sIdx -= 1;
      }

      if (sIdx < 0) {
        break;
      }
    }

    return result;
  }
}

