package Programmers.lv2.할인_행사;

import java.util.*;

public class Solution {
  public static int solution(String[] want, int[] number, String[] discount) {
    HashMap<String, Integer> wantMap = new HashMap<>();

    for (int i = 0; i < want.length; i++) {
      wantMap.put(want[i], number[i]);
    }
    int answer  = 0;

    for (int i = 0; i < discount.length - 9; i++) {
      HashMap<String, Integer> discount10d = new HashMap<>();

      for (int j = i; j < i + 10; j++) {
        if (wantMap.containsKey(discount[j])) {
          discount10d.put(discount[j], discount10d.getOrDefault(discount[j], 0) + 1);
        }
      }

      if (discount10d.equals(wantMap)) {
        answer++;
      }
    }

    return answer;
  }
}

