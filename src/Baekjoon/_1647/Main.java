package Baekjoon._1647;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static int N, M;
  static PriorityQueue<Node> pq;
  static List<List<Node>> map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      map.add(new ArrayList<>());
    }

    pq = new PriorityQueue<>();
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      map.get(a).add(new Node(b, c));
      map.get(b).add(new Node(a, c));
    }

    int result = 0;
    int cnt = 0;
    int max = 0;
    boolean[] visited = new boolean[N + 1];
    pq.add(new Node(1, 0));
    while (!pq.isEmpty()) {
      Node now = pq.poll();

      if (visited[now.dest]) {
        continue;
      }

      visited[now.dest] = true;
      result += now.cost;
      max = Math.max(max, now.cost);

      for (Node next : map.get(now.dest)) {
        if (!visited[next.dest]) {
          pq.add(next);
        }
      }

      cnt++;
      if (cnt == N) {
        break;
      }
    }

    System.out.println(result - max);
  }

  static class Node implements Comparable<Node> {

    int dest;
    int cost;

    public Node(int dest, int cost) {
      this.dest = dest;
      this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
      return this.cost - o.cost;
    }
  }
}
