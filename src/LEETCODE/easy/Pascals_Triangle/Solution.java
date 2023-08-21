package LeetCode.easy.Pascals_Triangle;

import java.util.*;

class Solution {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new LinkedList<>();

    for (int i = 1; i <= numRows; i++) {
      List<Integer> list = new LinkedList<>();
      for (int j = 0; j < i; j++) {
        if (j == 0 || j == i - 1) {
          list.add(1);
        } else {
          int val = result.get(i-2).get(j-1) + result.get(i-2).get(j);
          list.add(val);
        }
      }
      result.add(list);
    }

    return result;
  }
}
