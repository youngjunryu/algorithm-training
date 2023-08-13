package Archiving.LEETCODE;

import java.util.Map;
import java.util.Stack;

public class Valid_Parentheses {
  public boolean isValid(String s) {
    Map<Character, Character> map = Map.of('(', ')', '{', '}', '[', ']');
    Stack<Character> stack = new Stack<>();
    boolean answer = true;

    for (int i = 0; i < s.length(); i++) {
      char cur = s.charAt(i);

      if (cur == '(' || cur == '{' || cur == '[') {
        stack.push(cur);
      } else {
        if (stack.isEmpty()) {
          answer = false;
          break;
        } else {
          if (map.get(stack.peek()) == cur) {
            stack.pop();
          } else {
            answer = false;
            break;
          }
        }
      }
    }

    if (!stack.isEmpty()) {
      answer = false;
    }

    return answer;
  }
}
