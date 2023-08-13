package Archiving.LEETCODE;

import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation {
  static Stack<Integer> s;

  public static int evalRPN(String[] tokens) {
    s = new Stack<>();

    for (String t : tokens) {
      int[] nums;
      switch (t) {
        case "*":
          nums = getNums();
          s.push(nums[0] * nums[1]);
          break;
        case "/":
          nums = getNums();
          s.push(nums[1] / nums[0]);
          break;
        case "+":
          nums = getNums();
          s.push(nums[0] + nums[1]);
          break;
        case "-":
          nums = getNums();
          s.push(nums[1] - nums[0]);
          break;
        default:
          s.push(Integer.parseInt(t));
          break;
      }
    }

    return s.peek();
  }

  private static int[] getNums() {
    return new int[]{s.pop(), s.pop()};
  }

  public static void main(String[] args) {
    evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"});
  }
}
