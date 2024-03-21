package Programmers.lv2.롤케이크_자르기;

import java.util.*;

class Solution {
  public int solution(int[] topping) {
    HashMap<Integer, Integer> prev = new HashMap<>();
    HashMap<Integer, Integer> next = new HashMap<>();

    for (int t : topping) {
      next.put(t, next.getOrDefault(t, 0) + 1);
    }

    int same = next.size() / 2;

    int answer = 0;
    for (int t : topping) {
      prev.put(t, prev.getOrDefault(t, 0) + 1);
      int prevSize = prev.size();

      next.put(t, next.get(t) - 1);
      if (next.get(t) == 0) next.remove(t);
      int nextSize = next.size();

      if (prevSize == nextSize) answer++;
    }

    return answer;
  }
}
