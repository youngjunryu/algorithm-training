package PROGRAMMERS.simul.test5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Two {
  public int[] solution(int[] numbers) {
    int[] answer;

    Set<Integer> set = new HashSet<>();

    for (int i = 0; i < numbers.length; i++) {
      for (int j = 0; j < numbers.length; j++) {
        if (i == j) {
          continue;
        }

        set.add(numbers[i] + numbers[j]);
      }
    }

    List<Integer> list = set.stream().sorted().collect(Collectors.toList());
    answer = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      answer[i] = list.get(i);
    }

    System.out.println(Arrays.toString(answer));

    return answer;
  }
}
