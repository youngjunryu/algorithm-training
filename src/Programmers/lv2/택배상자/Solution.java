package Programmers.lv2.택배상자;

import java.util.Stack;

public class Solution {

  public int solution(int[] order) {
    int answer = 0;

    int start = 1;
    Stack<Integer> stack = new Stack<>();

    for (int o : order) {
      if (start == o) {
        answer++;
        start++;
      } else if (start < o) {
        while (start != o) {
          stack.add(start++);
        }
        start++;
        answer++;
      } else {
        if (stack.peek().equals(o)) {
          stack.pop();
          answer++;
        } else {
          break;
        }
      }
    }

    return answer;
  }
}
