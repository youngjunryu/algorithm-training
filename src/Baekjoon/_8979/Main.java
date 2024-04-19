package Baekjoon._8979;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static int A, B, C;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    PriorityQueue<Node> pq = new PriorityQueue<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int k = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      if (k == K) {
        A = a;
        B = b;
        C = c;
      }

      pq.add(new Node(a, b, c));
    }

    int result = 1;
    while (!pq.isEmpty()) {
      Node n = pq.poll();
      if (n.a == A && n.b == B && n.c == C) {
        break;
      } else {
        result++;
      }
    }

    System.out.println(result);
  }

  static class Node implements Comparable<Node> {

    int a;
    int b;
    int c;

    public Node(int a, int b, int c) {
      this.a = a;
      this.b = b;
      this.c = c;
    }

    public int compareTo(Node o) {
      if (a == o.a) {
        if (b == o.b) {
          return o.c - c;
        } else {
          return o.b - b;
        }
      } else {
        return o.a - a;
      }
    }
  }
}
