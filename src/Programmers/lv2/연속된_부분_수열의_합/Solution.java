package Programmers.lv2.연속된_부분_수열의_합;

import java.util.*;

class Solution {
  public int[] solution(int[] sequence, int k) {
    Queue<Node> pq = new PriorityQueue<>();
    int start = 0, end = 0;
    int sum = sequence[start];

    while (start <= end && end < sequence.length) {
      if (sum == k) {
        pq.add(new Node(start, end));
        sum -= sequence[start];
        start++;
        end++;
        if (end < sequence.length) {
          sum += sequence[end];
        } else {
          break;
        }
      } else if (sum < k) {
        end++;
        if (end < sequence.length) {
          sum += sequence[end];
        } else {
          break;
        }
      } else if (sum > k) {
        sum -= sequence[start];
        start++;
      }
    }

    Node result = pq.poll();

    return new int[]{result.sIdx, result.eIdx};
  }

  class Node implements Comparable<Node> {
    int sIdx;
    int eIdx;

    public Node(int sIdx, int eIdx) {
      this.sIdx = sIdx;
      this.eIdx = eIdx;
    }

    @Override
    public int compareTo(Node n) {
      if ((eIdx - sIdx) == (n.eIdx - n.sIdx)) {
        return sIdx < n.sIdx ? -1 : 1;
      }

      return (eIdx - sIdx) < (n.eIdx - n.sIdx) ? -1 : 1;
    }
  }
}
