package Archiving.PROGRAMMERS;

import java.util.PriorityQueue;

public class 실패율 {
  public static int[] solution(int N, int[] stages) {
    int[] answer = new int[N];
    int[] arr = new int[N+2];
    for (int s : stages) {
      arr[s] += 1;
    }

    PriorityQueue<Node> pq = new PriorityQueue<>();
    for (int i = 1; i < N+1; i++) {
      int no = arr[i];
      int total = 0;

      if (no == 0) {
        pq.add(new Node(i, 0));
        continue;
      }

      for (int j = i; j < N+2; j++) {
        total += arr[j];
      }
      pq.add(new Node(i, (double)no / total));
    }

    int idx = 0;
    while (!pq.isEmpty()) {
      answer[idx++] = pq.poll().stage;
    }

    return answer;
  }

  static class Node implements Comparable<Node> {
    int stage;
    double failRate;

    public Node(int stage, double failRate) {
      this.stage = stage;
      this.failRate = failRate;
    }

    @Override
    public int compareTo(Node o) {
      if (this.failRate == o.failRate) {
        return this.stage - o.stage;
      } else if (this.failRate > o.failRate) {
        return -1;
      } else {
        return 1;
      }
    }
  }

  public static void main(String[] args) {
    solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
  }
}
