package Programmers.PCCP2.신입사원_교육;

import java.util.*;

class Solution {
  public int solution(int[] ability, int number) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);

    for (int a: ability) {
      pq.add(a);
    }

    for (int i = 0; i < number; i++) {
      int a = pq.poll();
      int b = pq.poll();
      int temp = a + b;
      a = temp;
      b = temp;
      pq.add(a);
      pq.add(b);
    }

    int result = 0;
    while (!pq.isEmpty()) {
      result += pq.poll();
    }


    return result;
  }
}
