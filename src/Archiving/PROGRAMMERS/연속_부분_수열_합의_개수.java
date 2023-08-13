package Archiving.PROGRAMMERS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 연속_부분_수열_합의_개수 {
  public static int solution(int[] elements) {
    Set<Integer> set = new HashSet<>();

    int answer = 0;

    for (int i = 1; i <= elements.length; i++) {
      ArrayList<Integer> list = new ArrayList<>();
      Arrays.stream(elements).forEach(list::add);
      for (int j = 0; j < i - 1; j++) {
        list.add(elements[j]);
      }

      int sum = 0;
      for (int j = 0; j < i; j++) {
        sum += list.get(j);
      }

      set.add(sum);
      int idx = i;
      while (idx < list.size()) {
        sum += list.get(idx);
        sum -= list.get(idx - i);
        set.add(sum);
        idx++;
      }
    }

    return set.size();
  }

  public static void main(String[] args) {
    solution(new int[]{7, 9, 1, 1, 4});
  }
}
