package PROGRAMMERS.simul.test7;

import java.util.ArrayList;
import java.util.List;

public class Three {
  public long[] solution(long[] numbers) {
    long[] answer;
    List<Long> ansList = new ArrayList<>();

    for (long n : numbers) {
      if (n % 2 == 0) {
        ansList.add(n + 1);
      } else {
        String binary = "0" + Long.toBinaryString(n);
        StringBuilder sb = new StringBuilder(binary);

        int lastZeroIdx = sb.lastIndexOf("0");
        sb.setCharAt(lastZeroIdx, '1');

        int nextOneIdx = sb.indexOf("1", lastZeroIdx + 1);
        sb.setCharAt(nextOneIdx, '0');

        ansList.add(Long.parseLong(sb.toString(), 2));
        System.out.println(Long.parseLong(sb.toString(), 2));
      }
    }

    answer = new long[ansList.size()];
    for (int i = 0; i < ansList.size(); i++) {
      answer[i] = ansList.get(i);
    }

    return answer;
  }
}
