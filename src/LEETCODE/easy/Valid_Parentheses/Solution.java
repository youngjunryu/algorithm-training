package LeetCode.easy.Valid_Parentheses;

import java.util.*;

class Solution {
  public boolean isValid(String s) {
    var stack = new Stack<Character>();
    Map<Character, Character> map = Map.of('(', ')', '{', '}', '[', ']');

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(' || c == '{' || c == '[') {
        stack.push(c);
      } else {
        if (stack.size() > 0 && map.get(stack.peek()) == c) {
          stack.pop();
        } else {
          return false;
        }
      }
    }

    if (stack.size() > 0) {
      return false;
    }

    return true;
  }
}
