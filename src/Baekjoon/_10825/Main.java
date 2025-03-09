package Baekjoon._10825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    StringTokenizer st;

    PriorityQueue<Node> pq = new PriorityQueue<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      String name = st.nextToken();
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      Node node = new Node(name, a, b, c);
      pq.add(node);
    }

    StringBuilder sb = new StringBuilder();
    while (!pq.isEmpty()) {
      sb.append(pq.poll().name).append("\n");
    }
    System.out.println(sb);
  }

  static class Node implements Comparable<Node> {

    String name;
    int a;
    int b;
    int c;

    public Node(String name, int a, int b, int c) {
      this.name = name;
      this.a = a;
      this.b = b;
      this.c = c;
    }


    @Override
    public int compareTo(Node o) {
      if (a == o.a) {
        if (b == o.b) {
          if (c == o.c) {
            return name.compareTo(o.name);
          }
          return o.c - c;
        }
        return b - o.b;
      }
      return o.a - a;
    }
  }
}
