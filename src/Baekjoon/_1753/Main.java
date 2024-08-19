package Baekjoon._1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static int V, E;
  static ArrayList<ArrayList<Node>> graph;
  static int[] dist;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());

    int K = Integer.parseInt(br.readLine());

    graph = new ArrayList<>();
    for (int i = 0; i <= V; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      graph.get(u).add(new Node(v, w));
    }

    dijkstra(K);
    
    for (int i = 1; i <= V; i++) {
      if (dist[i] == Integer.MAX_VALUE) {
        System.out.println("INF");
      } else {
        System.out.println(dist[i]);
      }
    }
  }

  private static void dijkstra(int k) {
    dist = new int[V + 1];

    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[k] = 0;

    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(k, 0));

    while (!pq.isEmpty()) {
      Node now = pq.poll();

      if (dist[now.dest] < now.cost) {
        continue;
      }

      for (Node next : graph.get(now.dest)) {
        int cost = now.cost + next.cost;
        if (dist[next.dest] > cost) {
          dist[next.dest] = cost;
          pq.add(new Node(next.dest, cost));
        }
      }
    }
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
