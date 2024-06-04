package Baekjoon._1446;

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
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int D = Integer.parseInt(st.nextToken());

    List<List<Node>> map = new ArrayList<>();
    for (int i = 0; i < 10001; i++) {
      map.add(new ArrayList<>());
    }

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      List<Node> list = map.get(s);
      list.add(new Node(e, w));
    }

    for (int i = 0; i < D; i++) {
      List<Node> list = map.get(i);
      list.add(new Node(i + 1, 1));
    }

    int[] dist = new int[10001];
    Arrays.fill(dist, Integer.MAX_VALUE);

    dist[0] = 0;
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(0, 0));

    while (!pq.isEmpty()) {
      Node now = pq.poll();

      if (now.dest == D) {
        break;
      }

      if (now.dest > D) {
        continue;
      }

      if (dist[now.dest] < now.w) {
        continue;
      }

      for (Node next : map.get(now.dest)) {
        int ww = now.w + next.w;
        if (dist[next.dest] > ww) {
          dist[next.dest] = ww;
          pq.add(new Node(next.dest, ww));
        }
      }
    }

    System.out.println(dist[D]);
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
