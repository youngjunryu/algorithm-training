package Programmers.lv2.영어_끝말잇기;

import java.util.*;

class Solution {
  public int[] solution(int n, String[] words) {
    int a = 0;
    int b = 0;

    HashSet<String> set = new HashSet<>();
    int cnt = 0;

    char lastChar = words[0].charAt(0);
    for (String word : words) {
      if (lastChar != word.charAt(0) || set.contains(word)) {
        a = cnt % n  + 1;
        b = cnt / n + 1;
        break;
      }

      lastChar = word.charAt(word.length() - 1);
      set.add(word);
      cnt++;
    }

    return new int[]{a, b};
  }
}

/*

1. 가장 먼저 탈락하는 사람 번호
2. 그 때 자신의 몇 번째 차례

*/
