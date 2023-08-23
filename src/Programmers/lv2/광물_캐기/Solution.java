package Programmers.lv2.광물_캐기;

import java.util.*;

class Solution {
  public int solution(int[] picks, String[] minerals) {
    int answer = 0;
    Queue<Node> pq = new PriorityQueue<>();
    int pickCnt = 0;

    for (int p : picks) {
      pickCnt += p;
    }

    for (int i = 0; pickCnt > 0 && i < minerals.length; i += 5) {
      pickCnt--;
      int end = Math.min(i + 5, minerals.length);
      int dCnt = 0, iCnt = 0, sCnt = 0;

      for (int j = i; j < end; j++) {
        if (minerals[j].equals("diamond")) {
          dCnt++;
        } else if (minerals[j].equals("iron")) {
          iCnt++;
        } else if (minerals[j].equals("stone")) {
          sCnt++;
        }
      }

      pq.add(new Node(dCnt, iCnt, sCnt));
    }

    int[][] board = new int[][]{
        {1, 1, 1},
        {5, 1, 1},
        {25, 5, 1}
    };

    int pickIdx = 0;
    while (!pq.isEmpty()) {
      Node cur = pq.poll();

      while (true) {
        if (picks[pickIdx] > 0) {
          break;
        }

        pickIdx++;

        if (pickIdx >= 3) {
          return answer;
        }
      }

      answer += board[pickIdx][0] * cur.dCnt;
      answer += board[pickIdx][1] * cur.iCnt;
      answer += board[pickIdx][2] * cur.sCnt;
      picks[pickIdx]--;
    }

    return answer;
  }

  class Node implements Comparable<Node> {
    int dCnt;
    int iCnt;
    int sCnt;

    public Node(int dCnt, int iCnt, int sCnt) {
      this.dCnt = dCnt;
      this.iCnt = iCnt;
      this.sCnt = sCnt;
    }

    @Override
    public int compareTo(Node n) {
      if (dCnt == n.dCnt) {
        if (iCnt == n.iCnt) {
          return n.sCnt - sCnt;
        }
        return n.iCnt - iCnt;
      }
      return n.dCnt - dCnt;
    }
  }
}
