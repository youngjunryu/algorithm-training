package Baekjoon._11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    Node[] nodes = new Node[N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    Arrays.sort(nodes);

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    int result = 0;
    for (Node n : nodes) {
      if (pq.isEmpty()) {
        result++;
        pq.add(n.b);
        continue;
      }

      int last = pq.peek();

      if (last <= n.a) {
        pq.poll();
        pq.add(n.b);
      } else {
        pq.add(n.b);
        result++;
      }
    }

    System.out.println(result);
  }

  static class Node implements Comparable<Node> {

    int a;
    int b;

    public Node(int a, int b) {
      this.a = a;
      this.b = b;
    }

    @Override
    public int compareTo(Node o) {
      return this.a == o.a ? this.b - o.b : this.a - o.a;
    }
  }
}
