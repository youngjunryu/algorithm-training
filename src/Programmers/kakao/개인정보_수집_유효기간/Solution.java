package Programmers.kakao.개인정보_수집_유효기간;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {

  HashMap<String, Integer> map = new HashMap<>();

  public int[] solution(String today, String[] terms, String[] privacies) {
    String[] nowArr = today.split("\\.");
    StringBuilder nowSb = new StringBuilder();
    nowSb.append(nowArr[0]);
    nowSb.append(nowArr[1]);
    nowSb.append(nowArr[2]);
    int now = Integer.parseInt(nowSb.toString());

    for (int i = 0; i < terms.length; i++) {
      String[] termsArr = terms[i].split(" ");
      map.put(termsArr[0], Integer.parseInt(termsArr[1]));
    }

    ArrayList<Integer> resultList = new ArrayList<>();

    for (int i = 0; i < privacies.length; i++) {
      String[] pArr = privacies[i].split(" ");

      String[] start = pArr[0].split("\\.");
      int plus = map.get(pArr[1]);

      int year = Integer.parseInt(start[0]);
      int month = Integer.parseInt(start[1]);
      int day = Integer.parseInt(start[2]);

      if (day == 1) {
        month -= 1;
        day = 28;
      } else {
        day -= 1;
      }

      year += plus / 12;
      month += plus % 12;

      if (month >= 13) {
        year++;
        month = month - 12;
      }

      StringBuilder sb = new StringBuilder();
      sb.append(year);
      if (month < 10) {
        sb.append("0");
      }
      sb.append(month);
      if (day < 10) {
        sb.append("0");
      }
      sb.append(day);

      int a = Integer.parseInt(sb.toString());
      if (now > a) {
        resultList.add(i + 1);
      }
    }

    int[] result = new int[resultList.size()];
    for (int i = 0; i < resultList.size(); i++) {
      result[i] = resultList.get(i);
    }

    return result;
  }
}
