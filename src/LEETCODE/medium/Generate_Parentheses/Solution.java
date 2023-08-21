package LeetCode.medium.Generate_Parentheses;

import java.util.*;

class Solution {
  List<String> result = new ArrayList<>();

  public List<String> generateParenthesis(int n) {
    backtracking(n, "", 0, 0);
    return result;
  }

  private void backtracking(int n, String s, int left, int right) {
    if (n * 2 == s.length()) {
      result.add(s);
      return;
    }

    if (left < n) {
      backtracking(n, s + "(", left + 1, right);
    }

    if (right < left) {
      backtracking(n, s + ")", left, right + 1);
    }
  }
}

