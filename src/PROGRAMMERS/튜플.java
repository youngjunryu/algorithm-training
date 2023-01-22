package PROGRAMMERS;

import java.util.Collections;
import java.util.LinkedList;

public class 튜플 {
  public static int[] solution(String s) {
    LinkedList<LinkedList<Integer>> a = new LinkedList<>();

    s = s.substring(1, s.length() - 1);
    LinkedList<Integer> b = null;

    int idx = 0;
    while (idx < s.length()) {
      if (s.charAt(idx) == '{') {
        b = new LinkedList<>();
      } else if (s.charAt(idx) - '0' >= 0 && s.charAt(idx) - '0' <= 9) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(idx++));
        while (idx < s.length() && s.charAt(idx) - '0' >= 0 && s.charAt(idx) - '0' <= 9) {
          sb.append(s.charAt(idx++));
        }

        if (s.charAt(idx) == '}') {
          a.add(b);
        }

        b.add(Integer.parseInt(sb.toString()));
      }
      idx++;
    }

    int[] answer = new int[a.size()];

    Collections.sort(a, (o1, o2) -> o1.size() - o2.size());
    for (int i = a.size() - 1; i > 0; i--) {
      LinkedList<Integer> now = a.get(i);
      LinkedList<Integer> prev = a.get(i-1);
      for (int j = 0; j < i; j++) {
        now.remove(prev.get(j));
      }
      answer[i] = now.get(0);
    }

    answer[0] = a.get(0).get(0);

    return answer;
  }

  public static void main(String[] args) {
    solution("{{4,2,3},{3},{2,3,4,1},{2,3}}");
  }
}
