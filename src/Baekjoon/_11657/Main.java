package Baekjoon._11657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static final int INF = Integer.MAX_VALUE;
  static ArrayList<Node> nodes;
  static long[] dist;
  static int N, M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    nodes = new ArrayList<>();

    for (int t = 0; t < M; t++) {
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      int C = Integer.parseInt(st.nextToken());

      nodes.add(new Node(A, B, C));
    }

    dist = new long[N + 1];

    Arrays.fill(dist, INF);

    boolean isCycle = bellmanFord(1);

    if (isCycle) {
      System.out.println("-1");
    } else {
      for (int i = 2; i <= N; i++) {
        if (dist[i] == INF) {
          System.out.println("-1");
        } else {
          System.out.println(dist[i]);
        }
      }
    }
  }

  private static boolean bellmanFord(int start) {
    dist[start] = 0;
    for (int i = 0; i < N - 1; i++) {
      for (int j = 0; j < M; j++) {
        Node node = nodes.get(j);
        if (dist[node.s] != INF && dist[node.e] > dist[node.s] + node.cost) {
          dist[node.e] = dist[node.s] + node.cost;
        }
      }
    }

    for (Node node : nodes) {
      if (dist[node.s] != INF && dist[node.e] > dist[node.s] + node.cost) {
        return true;
      }
    }

    return false;
  }

  static class Node {

    int s;
    int e;
    int cost;

    public Node(int s, int e, int cost) {
      this.s = s;
      this.e = e;
      this.cost = cost;
    }
  }
}