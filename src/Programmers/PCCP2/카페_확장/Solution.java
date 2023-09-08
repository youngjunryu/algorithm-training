package Programmers.PCCP2.카페_확장;

import java.util.*;

class Solution {
  public int solution(int[] menu, int[] order, int k) {
    int answer = 0;
    ArrayList<Integer> arr = new ArrayList<>();

    int time = 0;

    for(int i = 0; i < k * order.length; i++){
      if (time < i) time = i;

      if (arr.size() != 0 && i == arr.get(0)) {
        arr.remove(0);
      }

      if (i % k == 0) {
        time += menu[order[i/k]];
        arr.add(time);
      }

      answer = Math.max(answer,arr.size());
    }

    return answer;
  }
}

