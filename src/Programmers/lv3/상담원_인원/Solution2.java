package Programmers.lv3.상담원_인원;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution2 {

  List<List<Time>> timeForEachType = new ArrayList<>();
  int[][] waitTimeForEachType;

  public int solution(int k, int n, int[][] reqs) {
    waitTimeForEachType = new int[k + 1][n + 1];

    for (int i = 0; i < k + 1; i++) {
      timeForEachType.add(new ArrayList<>());
    }

    for (int[] req : reqs) {
      timeForEachType.get(req[2]).add(new Time(req[0], req[1]));
    }

    for (int i = 1; i <= k; i++) {
      if (timeForEachType.get(i).isEmpty()) {
        continue;
      }

      for (int j = 1; j <= n - k + 1; j++) {
        int waitTime = calculateWaitTime(i, j);
        waitTimeForEachType[i][j] = waitTime;
      }
    }

    int[] sumOfCounselor = new int[k + 1];
    Arrays.fill(sumOfCounselor, 1);

    for (int t = 0; t < n - k; t++) {
      int maxVal = 0;
      int maxType = -1;

      for (int type = 1; type <= k; type++) {
        int val = waitTimeForEachType[type][sumOfCounselor[type]] - waitTimeForEachType[type][
            sumOfCounselor[type] + 1];

        if (maxVal < val) {
          maxVal = val;
          maxType = type;
        }
      }

      sumOfCounselor[maxType]++;
    }

    int result = 0;

    for (int type = 1; type <= k; type++) {
      result += waitTimeForEachType[type][sumOfCounselor[type]];
    }

    return result;
  }

  private int calculateWaitTime(int type, int total) {
    int sum = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (Time t : timeForEachType.get(type)) {
      if (pq.isEmpty() || pq.size() < total) {
        pq.add(t.start + t.duration);
      } else {
        int time = pq.poll();

        if (time >= t.start) {
          sum += time - t.start;
          pq.add(time + t.duration);
        } else {
          pq.add(t.start + t.duration);
        }
      }
    }

    return sum;
  }

  class Time {

    int start;
    int duration;

    public Time(int start, int duration) {
      this.start = start;
      this.duration = duration;
    }
  }

}
