package Archiving.LEETCODE;

import java.util.HashMap;

public class Longest_Substring_Without_Repeating_Characters {
  public static int lengthOfLongestSubstring(String s) {
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    int len = s.length();
    int left = 0;
    int max = 0;

    for (int right = 0; right < len; right++) {
      char c = s.charAt(right);
      if (map.containsKey(c) && map.get(c) >= left) {
        left = map.get(c) + 1;
      } else {
        max = Math.max(max, right - left + 1);
      }

      map.put(c, right);
    }

    return max;
  }

  public static void main(String[] args) {
    lengthOfLongestSubstring("abcabcbb");
  }
}
