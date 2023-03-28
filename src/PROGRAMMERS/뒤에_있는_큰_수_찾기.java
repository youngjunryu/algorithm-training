package PROGRAMMERS;

import java.util.Arrays;
import java.util.Stack;

public class 뒤에_있는_큰_수_찾기 {
  public static int[] solution(int[] numbers) {
    int[] answer = new int[numbers.length];
    Stack<Node> s = new Stack<>();

    for (int i = 0; i < numbers.length; i++) {
      if (s.isEmpty()) {
        s.add(new Node(i, numbers[i]));
        continue;
      }

      while (true) {
        if (!s.isEmpty() && s.peek().number < numbers[i]) {
          Node top = s.pop();
          answer[top.idx] = numbers[i];
        } else {
          s.add(new Node(i, numbers[i]));
          break;
        }
      }
    }

    for (int i = 0; i < answer.length; i++) {
      if (answer[i] == 0) {
        answer[i] = -1;
      }
    }

    return answer;
  }

  static class Node {
    int idx;
    int number;

    public Node(int idx, int number) {
      this.idx = idx;
      this.number = number;
    }
  }

  public static void main(String[] args) {
    solution(new int[]{2, 3, 3, 5});
  }
}
