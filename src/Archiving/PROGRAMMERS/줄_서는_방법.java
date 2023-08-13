package Archiving.PROGRAMMERS;

import java.util.ArrayList;

public class 줄_서는_방법 {
  public static int[] solution(int n, long k) {
    int[] answer = new int[n];
    int idx = 0;
    ArrayList<Integer> nums = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      nums.add(i + 1);
    }

    k--;
    while (k != 0) {
      long factorialResult = factorial(--n);
      int order = (int)(k / factorialResult);
      k = k % factorialResult;
      answer[idx++] = nums.remove(order);
    }

    for (int i = 0; i < nums.size(); i++) {
      answer[idx++] = nums.get(i);
    }

    return answer;
  }

  private static long factorial(int f) {
    long result = 1;
    while (f > 0) {
      result *= f;
      f--;
    }

    return result;
  }

  public static void main(String[] args) {
    solution(3, 5);
  }
}
