package PROGRAMMERS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class 보석_쇼핑 {
  public static int[] solution(String[] gems) {
    int kind = new HashSet<>(Arrays.asList(gems)).size();
    HashMap<String, Integer> map = new HashMap<>();

    int[] answer = new int[2];
    int length = Integer.MAX_VALUE;
    int left = 0;
    for (int i = 0; i < gems.length; i++) {
      map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);

      while (map.get(gems[left]) > 1) {
        map.put(gems[left], map.get(gems[left]) - 1);
        left++;
      }

      if (map.size() == kind && length > (i - left)) {
        length = i - left;
        answer[0] = left + 1;
        answer[1] = i + 1;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    solution(new String[]{"AA", "AB", "AC", "AA", "AC"});
  }
}
