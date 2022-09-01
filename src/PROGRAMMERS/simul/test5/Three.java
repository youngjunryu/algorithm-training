package PROGRAMMERS.simul.test5;

import java.util.Map;

public class Three {
  public int solution(String word) {
    int answer = 0;

    Map<Character, Integer> map = Map.of(
        'A', 0,
        'E', 1,
        'I', 2,
        'O', 3,
        'U', 4
    );
    int[] arr = new int[]{781, 156, 31, 6, 1};

    for (int i = 0; i < word.length(); i++) {
      answer += arr[i] * map.get(word.charAt(i));
      answer++;
    }

    return answer;
  }
}
