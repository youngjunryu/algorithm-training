package LEETCODE;

import java.util.ArrayList;
import java.util.List;

public class Insert_Interval {
  public static int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> answer = new ArrayList<>();

    for (int[] i : intervals) {
      if (newInterval == null ||  newInterval[0] > i[1]) {
        answer.add(i);
      } else if (newInterval[1] < i[0]) {
        answer.add(newInterval);
        answer.add(i);
        newInterval = null;
      } else {
        newInterval[0] = Math.min(i[0], newInterval[0]);
        newInterval[1] = Math.max(i[1], newInterval[1]);
      }
    }

    if (newInterval != null) {
      answer.add(newInterval);
    }

    return answer.toArray(new int[answer.size()][]);
  }

  public static void main(String[] args) {
    insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8});
  }
}
