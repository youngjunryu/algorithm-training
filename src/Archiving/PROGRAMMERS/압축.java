package Archiving.PROGRAMMERS;

import java.util.ArrayList;
import java.util.HashMap;

public class 압축 {
  static HashMap<String, Integer> dict;
  static int dictIdx;

  public static int[] solution(String msg) {
    init();

    ArrayList<Integer> answerList = new ArrayList<>();
    boolean flag = false;

    while (msg.length() > 0) {
      int idx = 1;

      while (dict.containsKey(msg.substring(0, idx))) {
        idx++;

        if (idx > msg.length()) {
          flag = true;
          break;
        }
      }

      answerList.add(dict.get(msg.substring(0, idx - 1)));

      if (flag) {
        break;
      }
      dict.put(msg.substring(0, idx), dictIdx++);
      msg = msg.substring(idx - 1);
    }

    int[] answer = new int[answerList.size()];
    for (int i = 0; i < answerList.size(); i++) {
      answer[i] = answerList.get(i);
    }

    return answer;
  }

  private static void init() {
    dict = new HashMap<>();
    dictIdx = 1;
    for (char i = 65; i <= 90; i++) {
      dict.put(String.valueOf(i), dictIdx++);
    }
  }

  public static void main(String[] args) {
    solution("TOBEORNOTTOBEORTOBEORNOT");
  }
}
