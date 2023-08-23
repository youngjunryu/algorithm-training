package Programmers.lv2.요격_시스템;

import java.util.*;

class Solution {
  public int solution(int[][] targets) {
    int answer = 0;

    Arrays.sort(targets, (a, b) -> a[1] - b[1]);
    int[] cur = targets[0];
    for (int i = 1; i < targets.length; i++) {
      if (cur[1] > targets[i][0]) {
        continue;
      } else {
        answer++;
        cur = targets[i];
      }
    }

    return answer + 1;
  }
}

