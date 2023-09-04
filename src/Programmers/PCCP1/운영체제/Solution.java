package Programmers.PCCP1.운영체제;

import java.util.*;

class Solution {
  public long[] solution(int[][] program) {
    long[] answer = new long[11];
    PriorityQueue<int[]> yet = new PriorityQueue<>((a, b) -> {
      if (a[1] == b[1])
        return a[0] - b[0];
      return a[1] - b[1];
    });

    PriorityQueue<int[]> wait = new PriorityQueue<>((a, b) -> {
      if (a[0] == b[0])
        return a[1] - b[1];
      return a[0] - b[0];
    });

    for (int[] p : program)
      yet.add(p);

    int time = 0;
    while (!yet.isEmpty() || !wait.isEmpty()) {

      while (!yet.isEmpty() && yet.peek()[1] <= time) {
        wait.add(yet.poll());
      }

      if (!wait.isEmpty()) {
        int[] now = wait.poll();
        answer[now[0]] += time - now[1];
        time += now[2];
      } else if (!yet.isEmpty()) {
        time = yet.peek()[1];
      }
    }

    answer[0] = time;

    return answer;
  }
}
