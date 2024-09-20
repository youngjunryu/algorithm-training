package Baekjoon._1504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static int N, M;
  static ArrayList<ArrayList<Node>> map;
  static int MAX = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      map.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      map.get(a).add(new Node(b, c));
      map.get(b).add(new Node(a, c));
    }

    st = new StringTokenizer(br.readLine());
    int v1 = Integer.parseInt(st.nextToken());
    int v2 = Integer.parseInt(st.nextToken());

    int oneToV1 = dijkstra(1, v1);
    int v1ToV2 = dijkstra(v1, v2);
    int v2ToN = dijkstra(v2, N);

    int first;
    if (oneToV1 == MAX || v1ToV2 == MAX || v2ToN == MAX) {
      first = -1;
    } else {
      first = oneToV1 + v1ToV2 + v2ToN;
    }

    int oneToV2 = dijkstra(1, v2);
    int v2Tov1 = dijkstra(v2, v1);
    int v1ToN = dijkstra(v1, N);
    int second;
    if (oneToV2 == MAX || v2Tov1 == MAX || v1ToN == MAX) {
      second = -1;
    } else {
      second = oneToV2 + v2Tov1 + v1ToN;
    }

    if (first == -1 || second == -1) {
      System.out.println(Math.max(first, second));
    } else {
      System.out.println(Math.min(first, second));
    }
  }

  private static int dijkstra(int start, int end) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(start, 0));
    int[] dist = new int[N + 1];
    Arrays.fill(dist, MAX);
    dist[start] = 0;

    while (!pq.isEmpty()) {
      Node now = pq.poll();

      if (now.dest == end) {
        break;
      }

      if (now.cost > dist[now.dest]) {
        continue;
      }

      for (Node next : map.get(now.dest)) {
        int cost = now.cost + next.cost;
        if (dist[next.dest] > cost) {
          dist[next.dest] = cost;
          pq.add(new Node(next.dest, cost));
        }
      }
    }

    return dist[end];
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
