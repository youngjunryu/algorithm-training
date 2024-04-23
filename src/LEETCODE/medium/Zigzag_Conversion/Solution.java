package LeetCode.medium.Zigzag_Conversion;

import java.util.ArrayList;
import java.util.List;

class Solution {

  public String convert(String s, int numRows) {
    if (s.length() == 1 || numRows == 1) {
      return s;
    }

    List<List<Character>> list = new ArrayList<>();
    for (int i = 0; i < numRows; i++) {
      list.add(new ArrayList<>());
    }

    boolean up = true;
    int idx = 0;
    for (int i = 0; i < s.length(); i++) {
      list.get(idx).add(s.charAt(i));
      idx += up ? 1 : -1;

      if (idx == numRows) {
        idx = numRows - 2;
        up = false;
      } else if (idx == -1) {
        idx = 1;
        up = true;
      }
    }

    StringBuilder sb = new StringBuilder();
    for (List<Character> l : list) {
      for (Character c : l) {
        sb.append(c);
      }
    }

    return sb.toString();
  }
}
