package LeetCode.medium.Reverse_Words_in_a_String;

import java.util.Map;
import java.util.TreeMap;

class Solution {

  public String reverseWords(String s) {
    StringBuilder sb = new StringBuilder();

    TreeMap<Integer, String> map = new TreeMap<>();
    int i = 0;
    for (; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == ' ') {
        if (sb.length() > 0) {
          map.put(-i, sb.toString());
          sb = new StringBuilder();
        } else {

        }
      } else {
        sb.append(c);
      }
    }

    if (sb.length() > 0) {
      map.put(-i, sb.toString());
    }

    sb = new StringBuilder();
    for (Map.Entry<Integer, String> entry : map.entrySet()) {
      sb.append(entry.getValue() + " ");
    }

    sb.deleteCharAt(sb.length() - 1);

    return sb.toString();
  }
}
