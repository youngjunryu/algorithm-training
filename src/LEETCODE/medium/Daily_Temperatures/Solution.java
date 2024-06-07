package LeetCode.medium.Daily_Temperatures;

import java.util.Stack;

class Solution {

  public int[] dailyTemperatures(int[] temperatures) {
    int n = temperatures.length;
    int[] result = new int[n];
    Stack<Integer[]> stack = new Stack<>();

    for (int i = 0; i < temperatures.length; i++) {
      int val = temperatures[i];
      if (stack.isEmpty()) {
        stack.add(new Integer[]{i, val});
        continue;
      }

      while (!stack.isEmpty() && stack.peek()[1] < val) {
        Integer[] arr = stack.pop();
        result[arr[0]] = i - arr[0];
      }

      stack.add(new Integer[]{i, val});
    }

    while (!stack.isEmpty()) {
      Integer[] arr = stack.pop();
      result[arr[0]] = 0;
    }

    return result;
  }
}

