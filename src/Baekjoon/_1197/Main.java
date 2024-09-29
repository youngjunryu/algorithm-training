package Baekjoon._1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static int V, E;
  static ArrayList<ArrayList<Node>> map;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());

    map = new ArrayList<>();
    for (int i = 0; i <= V; i++) {
      map.add(new ArrayList<>());
    }

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      int C = Integer.parseInt(st.nextToken());

      map.get(A).add(new Node(B, C));
      map.get(B).add(new Node(A, C));
    }

    int result = 0;
    int cnt = 0;
    visited = new boolean[V + 1];
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(1, 0));

    while (!pq.isEmpty()) {
      Node now = pq.poll();

      if (visited[now.dest]) {
        continue;
      }

      visited[now.dest] = true;
      result += now.cost;

      for (Node next : map.get(now.dest)) {
        if (visited[next.dest]) {
          continue;
        }

        pq.add(next);
      }

      cnt++;

      if (cnt == V) {
        break;
      }
    }

    System.out.println(result);
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
