package Archiving.PROGRAMMERS;

import java.util.Map;

public class 성격_유형_검사하기 {
  public String solution(String[] survey, int[] choices) {
    StringBuilder sb = new StringBuilder();
    Map<Character, Integer> map1 = Map.of('R', 0, 'T', 1, 'C', 2,
                                         'F', 3, 'J', 4, 'M', 5,
                                         'A', 6, 'N', 7);

    Map<Integer, Character> map2 = Map.of( 0, 'R', 1, 'T', 2, 'C',
                                          3, 'F', 4, 'J', 5, 'M',
                                          6, 'A', 7, 'N');

    int[] arr = new int[8];

    for (int i = 0; i < survey.length; i++) {
      if (choices[i] >= 1 && choices[i] <= 3) {
        char c = survey[i].charAt(0);
        arr[map1.get(c)] += 4 - choices[i];
      } else if (choices[i] >= 5 && choices[i] <= 7) {
        char c = survey[i].charAt(1);
        arr[map1.get(c)] += choices[i] - 4;
      }
    }

    for (int i = 0; i < arr.length - 1; i += 2) {
      if (arr[i] >= arr[i+1]) {
        sb.append(map2.get(i));
      } else {
        sb.append(map2.get(i+1));
      }
    }

    return sb.toString();
  }
}
