package LEETCODE;

import java.util.*;

public class Minimum_Window_Substring {
  HashMap<Character, Integer> goal;

  public String minWindow(String s, String t) {
    int total = t.length();
    int now = 0;
    int minSize = s.length() + 1;
    String result = "";
    goal = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      char c = t.charAt(i);
      goal.put(c, goal.getOrDefault(c, 0) + 1);
    }

    HashMap<Character, Integer> map = new HashMap<>();
    int start = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (!goal.containsKey(c)) {
        continue;
      }

      int count = map.getOrDefault(c, 0);
      if (count < goal.get(c)) {
        now++;
      }
      map.put(c, count + 1);

      if (now == total) {
        while (!goal.containsKey(s.charAt(start)) || (map.get(s.charAt(start)) > goal.get(s.charAt(start)))) {
          char startChar = s.charAt(start);
          if (goal.containsKey(startChar) && (map.get(startChar) > goal.get(startChar))) {
            int num = map.get(startChar);
            map.put(startChar, num - 1);
          }
          start++;
        }

        if (minSize > i - start + 1) {
          minSize = i - start + 1;
          result = s.substring(start, i + 1);
        }
      }
    }

    return result;
  }
}
