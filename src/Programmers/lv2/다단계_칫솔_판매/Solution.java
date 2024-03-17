package Programmers.lv2.다단계_칫솔_판매;

import java.util.*;

class Solution {
  public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
    int n = enroll.length;
    HashMap<String, String> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
      map.put(enroll[i], referral[i]);
    }

    HashMap<String, Integer> total = new HashMap<>();

    for (int i = 0; i < seller.length; i++) {
      String curName = seller[i];
      int money = amount[i] * 100;
      while (money > 0 && !curName.equals("-")) {
        total.put(curName, total.getOrDefault(curName, 0) + money - (money / 10));
        curName = map.get(curName);
        money /= 10;
      }
    }

    int[] answer = new int[n];
    for (int i = 0; i < n; i++) {
      answer[i] = total.getOrDefault(enroll[i], 0);
    }

    return answer;
  }
}
