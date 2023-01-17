package LEETCODE;

import java.util.*;

public class Letter_Combinations_of_a_Phone_Number {
  HashMap<Integer, ArrayList<Character>> map;
  ArrayList<String> results;

  public List<String> letterCombinations(String digits) {
    init();
    results = new ArrayList<>();

    if (digits.length() == 0) {
      return results;
    }

    backtracking(digits, 0, "");
    return results;
  }

  public void backtracking(String digits, int cur, String now) {
    if (cur == digits.length()) {
      results.add(now);
      return;
    }

    for (char c : map.get(digits.charAt(cur) - '0')) {
      backtracking(digits, cur + 1, now + c);
    }
  }

  public void init() {
    map = new HashMap<>();
    int num = 97;
    for (int i = 2; i <= 9; i++) {
      ArrayList<Character> list = new ArrayList<>();
      for (int j = 0; j < 3; j++) {
        list.add((char)num);
        num++;
      }

      if (i == 7 || i == 9) {
        list.add((char)num);
        num++;
      }

      map.put(i, list);
    }
  }
}
