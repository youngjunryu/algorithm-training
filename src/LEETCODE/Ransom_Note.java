package LEETCODE;

import java.util.HashMap;

public class Ransom_Note {
  static HashMap<Character, Integer> map;

  public static boolean canConstruct(String ransomNote, String magazine) {
    initMap(magazine);
    return getAnswer(ransomNote);
  }

  private static boolean getAnswer(String ransomNote) {
    for (int i = 0; i < ransomNote.length(); i++) {
      char c = ransomNote.charAt(i);
      if (map.containsKey(c)) {
        Integer n = map.get(c);
        if (n == 0) {
          return false;
        }
        map.put(c, n-1);
      } else {
        return false;
      }
    }

    return true;
  }

  private static void initMap(String magazine) {
    map = new HashMap<>();
    for (int i = 0; i < magazine.length(); i++) {
      char c = magazine.charAt(i);
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
  }

  public static void main(String[] args) {
    System.out.println(canConstruct("a", "b"));
  }
}
