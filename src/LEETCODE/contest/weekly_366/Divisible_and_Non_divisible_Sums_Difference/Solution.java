package LeetCode.contest.weekly_366.Divisible_and_Non_divisible_Sums_Difference;

import java.util.*;

public class Solution {
  public int differenceOfSums(int n, int m) {
    List<Integer> one = new ArrayList<>();
    List<Integer> two = new ArrayList<>();

    for (int i = 1; i <= n; i++) {
      if (i % m == 0) {
        two.add(i);
      } else {
        one.add(i);
      }
    }

    int num1 = 0;
    for (int a : one) {
      num1 += a;
    }

    int num2 = 0;
    for (int a : two) {
      num2 += a;
    }

    return num1 - num2;
  }
}
