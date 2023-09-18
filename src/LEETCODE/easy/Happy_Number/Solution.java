package LeetCode.easy.Happy_Number;

import java.util.*;

class Solution {
  public boolean isHappy(int n) {
    HashSet<Integer> set = new HashSet<>();
    set.add(n);

    while (true) {
      if (n == 1) {
        return true;
      }

      String s = String.valueOf(n);
      int sum = 0;
      for (int i = 0; i < s.length(); i++) {
        sum += (int)Math.pow((int)(s.charAt(i) - '0'), 2);
      }
      n = sum;

      if (set.contains(n)) {
        return false;
      }

      set.add(n);
    }
  }
}

