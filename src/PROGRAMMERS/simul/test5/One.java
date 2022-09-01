package PROGRAMMERS.simul.test5;

import java.util.ArrayList;
import java.util.List;

public class One {
  public int solution(int n) {
    int answer = 0;

    List<Integer> list = new ArrayList<>();

    while (true) {
      if (n == 0) {
        break;
      }

      int value = n % 3;
      n /= 3;

      list.add(value);
    }

    int k = 1;
    for (int i = list.size() - 1; i >= 0; i--) {
      answer += list.get(i) * k;
      k *= 3;
    }

    return answer;
  }
}
