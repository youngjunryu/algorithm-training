package Programmers.lv3.카운트_다운;

import java.util.*;

class Solution {
  public int[] solution(int target) {
    ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 1; i <= 20; i++) {
      list.add(i);
    }
    list.add(50);
    map.add(list);

    list = new ArrayList<>();
    for (int i = 1; i <= 20; i++) {
      for (int j = 2; j <= 3; j++) {
        int value = i * j;
        if (value > 20) {
          list.add(value);
        }
      }
    }
    map.add(list);

    int[][] dp = new int[target + 1][2];
    for (int i = 0; i <= target; i++) {
      dp[i][0] = 987654321;
    }
    dp[0][0] = 0;

    for (int i = 1; i <= target; i++) {
      for (int j = 0; j < 2; j++) {
        for (int k = 0; k < map.get(j).size(); k++) {
          int prev = i - map.get(j).get(k);

          if (prev < 0) continue;

          int total = dp[prev][0] + 1;
          int valid = dp[prev][1] + 1 - j;

          if (total < dp[i][0]) {
            dp[i][0] = total;
            dp[i][1] = valid;
          } else if (total == dp[i][0]) {
            dp[i][1] = Math.max(dp[i][1], valid);
          }
        }
      }
    }


    return dp[target];
  }
}

