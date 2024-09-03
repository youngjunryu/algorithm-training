package Baekjoon._1967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int n;
  static ArrayList<Node>[] map;
  static boolean[] visited;
  static int[] dist;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    map = new ArrayList[n + 1];
    for (int i = 0; i <= n; i++) {
      map[i] = new ArrayList<>();
    }
    dist = new int[n + 1];
    visited = new boolean[n + 1];

    for (int i = 0; i < n - 1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());

      map[a].add(new Node(b, cost));
      map[b].add(new Node(a, cost));
    }

    bfs(1);

    int first = 1;
    for (int i = 2; i <= n; i++) {
      if (dist[first] < dist[i]) {
        first = i;
      }
    }

    visited = new boolean[n + 1];
    dist = new int[n + 1];
    bfs(first);

    int result = -1;
    for (int now : dist) {
      result = Math.max(now, result);
    }

    System.out.println(result);
  }

  private static void bfs(int start) {
    Queue<Integer> q = new LinkedList<>();

    q.add(start);
    visited[start] = true;

    while (!q.isEmpty()) {
      int now = q.poll();

      for (Node next : map[now]) {
        if (!visited[next.dest]) {
          dist[next.dest] = next.cost + dist[now];
          visited[next.dest] = true;
          q.add(next.dest);
        }
      }
    }
  }

  static class Node {

    int dest;
    int cost;

    public Node(int dest, int cost) {
      this.dest = dest;
      this.cost = cost;
    }
  }
}
