package Archiving.PROGRAMMERS.simul.test7;

import java.util.ArrayList;
import java.util.List;

public class One {
  public int[] solution(int []arr) {
    int[] answer;
    List<Integer> list = new ArrayList<>();
    int prev = arr[0];
    list.add(arr[0]);

    for (int i = 1; i < arr.length; i++) {
      if (prev != arr[i]) {
        list.add(arr[i]);
        prev = arr[i];
      }
    }


    answer = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      answer[i] = list.get(i);
    }

    return answer;
  }
}
