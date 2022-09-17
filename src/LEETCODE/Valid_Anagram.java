package LEETCODE;

import java.util.HashMap;

public class Valid_Anagram {
  static HashMap<Character, Integer> map;

  public static boolean isAnagram(String s, String t) {
    map = new HashMap<>();
    initMap(s);
    return getAnswer(t);
  }

  private static boolean getAnswer(String t) {
    for (int i = 0; i < t.length(); i++) {
      char c = t.charAt(i);
      if (map.containsKey(c) && map.get(c) >= 1) {
        map.put(c, map.get(c) - 1);
      } else {
        return false;
      }
    }

    for (Character c : map.keySet()) {
      if (map.get(c) >= 1) {
        return false;
      }
    }

    return true;
  }

  private static void initMap(String s) {
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
  }
}
