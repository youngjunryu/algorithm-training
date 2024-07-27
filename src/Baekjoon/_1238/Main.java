package Baekjoon._1238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int X = Integer.parseInt(st.nextToken());

    int[][] map = new int[N + 1][N + 1];

    for (int i = 0; i < N + 1; i++) {
      Arrays.fill(map[i], -1);
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int t = Integer.parseInt(st.nextToken());

      map[s][e] = t;
    }

    int max = -1;
    for (int start = 1; start <= N; start++) {
      int go = dijkstra(N, start, map, X);
      int back = dijkstra(N, X, map, start);
      int sum = go + back;
      max = Math.max(sum, max);
    }

    System.out.println(max);
  }

  private static int dijkstra(int n, int start, int[][] map, int end) {
    if (start == end) {
      return 0;
    }

    int[] dist = new int[n + 1];
    Arrays.fill(dist, Integer.MAX_VALUE);

    dist[start] = 0;

    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(start, 0));

    while (!pq.isEmpty()) {
      Node now = pq.poll();

      if (now.num == end) {
        break;
      }

      if (now.val > dist[now.num]) {
        continue;
      }

      for (int i = 1; i <= n; i++) {
        if (now.num != i && map[now.num][i] != -1) {
          int val = now.val + map[now.num][i];
          if (dist[i] > val) {
            dist[i] = val;
            pq.add(new Node(i, val));
          }
        }
      }
    }

    return dist[end];
  }

  static class Node implements Comparable<Node> {

    int num;
    int val;

    public Node(int num, int val) {
      this.num = num;
      this.val = val;
    }

    @Override
    public int compareTo(Node o) {
      return this.val - o.val;
    }
  }
}
