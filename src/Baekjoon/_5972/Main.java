package Baekjoon._5972;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    List<List<Node>> map = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      map.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      int C = Integer.parseInt(st.nextToken());
      map.get(A).add(new Node(B, C));
      map.get(B).add(new Node(A, C));
    }

    PriorityQueue<Node> pq = new PriorityQueue<>();
    int[] dist = new int[N + 1];
    Arrays.fill(dist, Integer.MAX_VALUE);

    dist[1] = 0;
    pq.add(new Node(1, 0));

    while (!pq.isEmpty()) {
      Node now = pq.poll();

      if (now.dest == N) {
        break;
      }

      if (dist[now.dest] < now.w) {
        continue;
      }

      for (Node next : map.get(now.dest)) {
        if (dist[next.dest] > now.w + next.w) {
          dist[next.dest] = now.w + next.w;
          pq.add(new Node(next.dest, dist[next.dest]));
        }
      }
    }

    System.out.println(dist[N]);
  }

  static class Node implements Comparable<Node> {

    int dest;
    int w;

    public Node(int dest, int w) {
      this.dest = dest;
      this.w = w;
    }

    @Override
    public int compareTo(Node o) {
      return this.w - o.w;
    }
  }
}
