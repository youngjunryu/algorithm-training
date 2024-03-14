package Programmers.lv2.방문_길이;

import java.util.*;

class Solution {
  public int solution(String dirs) {
    HashSet<String> set = new HashSet<>();
    int x = 5;
    int y = 5;

    for (int i = 0; i < dirs.length(); i++) {
      char c = dirs.charAt(i);
      int a, b;

      if (c == 'U') {
        a = x;
        b = y + 1;
      } else if (c == 'D') {
        a  = x;
        b = y - 1;
      } else if (c == 'R') {
        a = x + 1;
        b = y;
      } else {
        a = x - 1;
        b = y;
      }

      if (!isRange(a, b)) {
        continue;
      }

      StringBuilder sb = new StringBuilder();
      set.add(sb.append(x).append(y).append(a).append(b).toString());
      sb = new StringBuilder();
      set.add(sb.append(a).append(b).append(x).append(y).toString());
      x = a;
      y = b;
    }

    return set.size() / 2;
  }

  private boolean isRange(int a, int b) {
    if (a >= 0 && b >= 0 && a <= 10 && b <= 10) {
      return true;
    }
    return false;
  }
}
