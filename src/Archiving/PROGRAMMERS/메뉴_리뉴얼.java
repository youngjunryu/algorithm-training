package Archiving.PROGRAMMERS;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class 메뉴_리뉴얼 {
  static HashMap<String, Integer> map;
  static HashMap<Integer, Integer> mapCnt;
  static LinkedList<String> answerList;

  public static String[] solution(String[] orders, int[] course) {
    map = new HashMap<>();
    mapCnt = new HashMap<>();
    answerList = new LinkedList<>();

    for (String o : orders) {
      for (int c : course) {
        dfs(o, c, "", 0);
      }
    }

    List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
    entryList.sort(Map.Entry.comparingByValue());

    for (int i = entryList.size() - 1; i >= 0; i--) {
      Map.Entry<String, Integer> entry = entryList.get(i);
      if (entry.getValue() < 2) {
        break;
      }

      if (mapCnt.containsKey(entry.getKey().length())) {
        if (mapCnt.get(entry.getKey().length()) == entry.getValue()) {
          answerList.add(entry.getKey());
        }
      } else {
        mapCnt.put(entry.getKey().length(), entry.getValue());
        answerList.add(entry.getKey());
      }
    }

    Collections.sort(answerList);
    String[] answer = new String[answerList.size()];

    for (int i = 0; i < answer.length; i++) {
      answer[i] = answerList.get(i);
    }

    return answer;
  }

  private static void dfs(String o, int c, String temp, int idx) {
    if (temp.length() == c) {
      char[] charArr = temp.toCharArray();
      Arrays.sort(charArr);
      String result = new String(charArr);
      map.put(result, map.getOrDefault(result, 0) + 1);
      return;
    }

    for (int i = idx; i < o.length(); i++) {
      dfs(o, c, temp + o.charAt(i), i + 1);
    }
  }

  public static void main(String[] args) {
    solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4});
  }
}
