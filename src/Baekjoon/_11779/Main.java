package Baekjoon._11779;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static int n, m;
  static ArrayList<ArrayList<Node>> map;
  static int start, end;
  static int[] dist;
  static int[] renew;
  static final int MAX_VALUE = 123456789;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());
    map = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      map.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      map.get(s).add(new Node(e, c));
    }

    StringTokenizer st = new StringTokenizer(br.readLine());
    start = Integer.parseInt(st.nextToken());
    end = Integer.parseInt(st.nextToken());
    dist = new int[n + 1];
    Arrays.fill(dist, MAX_VALUE);
    renew = new int[n + 1];

    dijkstra(start, end);
    getResult();
  }

  private static void getResult() {
    ArrayDeque<Integer> route = new ArrayDeque<>();
    int next = end;
    while (true) {
      route.addFirst(next);
      next = renew[next];
      if (next == start) {
        route.addFirst(start);
        break;
      }
    }

    System.out.println(dist[end]);
    System.out.println(route.size());
    for (int i : route) {
      System.out.print(i + " ");
    }
  }

  private static void dijkstra(int start, int end) {
    PriorityQueue<Node> pq = new PriorityQueue<>();

    dist[start] = 0;
    pq.add(new Node(start, 0));

    while (!pq.isEmpty()) {
      Node now = pq.poll();

      if (now.dest == end) {
        break;
      }

      if (dist[now.dest] < now.cost) {
        continue;
      }

      for (Node next : map.get(now.dest)) {
        int cost = next.cost + now.cost;

        if (cost < dist[next.dest]) {
          renew[next.dest] = now.dest;
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
