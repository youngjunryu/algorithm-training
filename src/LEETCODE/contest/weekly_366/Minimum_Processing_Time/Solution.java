package LeetCode.contest.weekly_366.Minimum_Processing_Time;

import java.util.*;

public class Solution {
  public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
    int n = processorTime.size();
    Collections.sort(processorTime);
    Collections.sort(tasks, Collections.reverseOrder());
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

    int idx = 0;
    for (int p : processorTime) {
      for (int i = 0; i < 4; i++) {
        pq.add(p + tasks.get(idx));
        idx++;
      }
    }

    return pq.poll();
  }
}
