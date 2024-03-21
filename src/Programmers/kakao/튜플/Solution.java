package Programmers.kakao.튜플;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
  public int[] solution(String s) {
    s = s.substring(0, s.length() - 2).replace("{", "");
    String[] arr = s.split("},");

    Arrays.sort(arr, (o1, o2) -> o1.length() - o2.length());
    HashSet<String> set = new HashSet<>();
    int[] answer = new int[arr.length];

    for (int i = 0; i < arr.length; i++) {
      String[] numbers = arr[i].split(",");
      for (String n : numbers) {
        if (!set.contains(n)) {
          answer[i] = Integer.parseInt(n);
          set.add(n);
        }
      }
    }

    return answer;
  }
}
