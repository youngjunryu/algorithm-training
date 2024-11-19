package Baekjoon._1922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());

    List<List<Node>> map = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      map.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      map.get(a).add(new Node(b, c));
      map.get(b).add(new Node(a, c));
    }

    System.out.println(prim(map));
  }

  private static int prim(List<List<Node>> map) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    boolean[] visited = new boolean[N + 1];
    int totalCost = 0;

    pq.add(new Node(1, 0));

    while (!pq.isEmpty()) {
      Node now = pq.poll();

      if (visited[now.next]) {
        continue;
      }

      visited[now.next] = true;
      totalCost += now.cost;

      for (Node n : map.get(now.next)) {
        if (!visited[n.next]) {
          pq.add(n);
        }
      }
    }

    return totalCost;
  }

  static class Node implements Comparable<Node> {

    int next;
    int cost;

    public Node(int next, int cost) {
      this.next = next;
      this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
      return this.cost - o.cost;
    }
  }
}
