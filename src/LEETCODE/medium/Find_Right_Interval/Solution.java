package LeetCode.medium.Find_Right_Interval;

import java.util.ArrayList;
import java.util.Collections;

class Solution {

  public int[] findRightInterval(int[][] intervals) {
    int n = intervals.length;

    int[] result = new int[n];
    ArrayList<Node> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.add(new Node(i, intervals[i][0], intervals[i][1]));
    }
    Collections.sort(list);

    for (Node node : list) {
      int target = node.end;

      int left = 0;
      int right = n - 1;

      while (left <= right) {
        int mid = (left + right) / 2;

        Node next = list.get(mid);
        int nextStart = next.start;

        if (target > nextStart) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }

      if (left == n) {
        result[node.idx] = -1;
      } else {
        result[node.idx] = list.get(left).idx;
      }
    }

    return result;
  }
}

class Node implements Comparable<Node> {

  int idx;
  int start;
  int end;

  public Node(int idx, int start, int end) {
    this.idx = idx;
    this.start = start;
    this.end = end;
  }

  public int compareTo(Node o) {
    return this.start - o.start;
  }
}
