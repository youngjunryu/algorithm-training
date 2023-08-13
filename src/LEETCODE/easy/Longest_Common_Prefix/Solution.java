package LeetCode.easy.Longest_Common_Prefix;

import java.util.*;

class Solution {
  public String longestCommonPrefix(String[] strs) {
    Arrays.sort(strs);
    var v1 = strs[0];
    var v2 = strs[strs.length - 1];
    var idx = 0;

    while (idx < v1.length() && idx < v2.length()) {
      if (v1.charAt(idx) == v2.charAt(idx)) {
        idx++;
      } else {
        break;
      }
    }

    return v1.substring(0, idx);
  }
}
