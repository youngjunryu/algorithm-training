package Baekjoon._11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    PriorityQueue<Node> pq = new PriorityQueue<>();
    for (int i = 0; i < N; i++) {
      int n = Integer.parseInt(br.readLine());

      if (n == 0) {
        if (pq.isEmpty()) {
          System.out.println(0);
        } else {
          Node node = pq.poll();
          System.out.println(node.num);
        }
      } else {
        pq.add(new Node(n));
      }
    }
  }

  static class Node implements Comparable<Node> {

    int num;

    public Node(int num) {
      this.num = num;
    }

    @Override
    public int compareTo(Node o) {
      int thisVal = Math.abs(this.num);
      int oVal = Math.abs(o.num);

      if (thisVal == oVal) {
        return this.num - o.num;
      }

      return thisVal - oVal;
    }
  }
}
