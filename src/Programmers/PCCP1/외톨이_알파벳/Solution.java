package Programmers.PCCP1.외톨이_알파벳;

import java.util.*;

class Solution {
  public String solution(String input_string) {
    String answer = "";
    Set<Character> set = new HashSet<>();
    Set<Character> result = new HashSet<>();

    char now = input_string.charAt(0);
    for (int i = 1; i < input_string.length(); i++) {
      if (now == input_string.charAt(i)) {
        continue;
      } else {
        if (set.contains(now)) {
          result.add(now);
        } else {
          set.add(now);
        }

        now = input_string.charAt(i);
      }
    }

    if (set.contains(now)) {
      result.add(now);
    } else {
      set.add(now);
    }

    if (result.size() == 0) {
      return "N";
    }

    for (char c : result) {
      answer += c;
    }

    char[] arr = answer.toCharArray();
    Arrays.sort(arr);
    answer = new String(arr);

    return answer;
  }
}
