package LeetCode.easy.Reverse_String;

import java.util.*;

class Solution {
  public void reverseString(char[] s) {
    int sLen = s.length;

    for (int i = 0; i < sLen / 2; i++) {
      char temp = s[sLen - i - 1];
      s[sLen - i - 1] = s[i];
      s[i] = temp;
    }
  }
}
