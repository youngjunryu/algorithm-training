package LeetCode.easy.Repeated_Substring_Pattern;

import java.util.*;

class Solution {
  public boolean repeatedSubstringPattern(String s) {
    int len = s.length();

    double sqrt = Math.sqrt(len);
    List<Integer> list = new ArrayList<>();
    for (int i = 1; i <= sqrt; i++) {
      if (len % i == 0) {
        if (i * i == len) {
          list.add(i);
        } else {
          list.add(i);
          list.add(len / i);
        }
      }
    }


    for (int n : list) {
      if (n == len) {
        continue;
      }

      String temp = s.substring(0, n);
      StringBuilder repeated = new StringBuilder();
      for (int i = 0; i < len / n; i++) {
        repeated.append(temp);
      }

      if (repeated.toString().equals(s))
        return true;
    }

    return false;
  }
}

