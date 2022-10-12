package LEETCODE;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Merge_Intervals {
  public static int[][] merge(int[][] intervals) {
    List<int[]> result = new LinkedList<>();
    Arrays.sort(intervals, (i1, i2) -> (i1[0] - i2[0]));
    int start = intervals[0][0];
    int end = intervals[0][1];

    for (int i = 1; i < intervals.length; i++) {
      int[] iv = intervals[i];
      if (iv[0] > end && iv[1] > end) {
        result.add(new int[]{start, end});
        start = iv[0];
        end = iv[1];
      } else if (iv[1] > end){
        end = iv[1];
      }
    }

    result.add(new int[]{start, end});

    int[][] answer = new int[result.size()][2];
    for (int i = 0; i < result.size(); i++) {
      answer[i][0] = result.get(i)[0];
      answer[i][1] = result.get(i)[1];
    }

    return answer;
  }

  public static void main(String[] args) {
    merge(new int[][]{{1, 4}, {4, 5}});
  }
}
