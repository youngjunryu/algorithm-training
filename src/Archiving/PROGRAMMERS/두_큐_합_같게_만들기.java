package Archiving.PROGRAMMERS;

import java.util.LinkedList;
import java.util.Queue;

public class 두_큐_합_같게_만들기 {
  public int solution(int[] queue1, int[] queue2) {
    int answer = -1;
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    long q1Sum = 0;
    long q2Sum = 0;
    int cnt = 0;

    for (int i = 0; i < queue1.length; i++) {
      int q1Val = queue1[i];
      int q2Val = queue2[i];
      q1.add(q1Val);
      q2.add(q2Val);
      q1Sum += q1Val;
      q2Sum += q2Val;
    }

    while (q1Sum != q2Sum) {
      if (q1Sum > q2Sum) {
        int remove = q1.poll();
        q1Sum -= remove;
        q2.add(remove);
        q2Sum += remove;
      } else {
        int remove = q2.poll();
        q2Sum -= remove;
        q1.add(remove);
        q1Sum += remove;
      }

      cnt++;

      if (cnt > (q1.size() + q2.size()) * 2) {
        return -1;
      }
    }

    return cnt;
  }
}
