package Baekjoon._1865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static final int INF = 987654321;
  static ArrayList<Node> nodes;
  static int[] dist;
  static int N, total;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    for (int t = 0; t < T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      int W = Integer.parseInt(st.nextToken());
      total = M * 2 + W;

      nodes = new ArrayList<>();

      for (int i = 0; i < M; i++) {
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        nodes.add(new Node(s, e, w));
        nodes.add(new Node(e, s, w));
      }

      for (int i = 0; i < W; i++) {
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int w = -Integer.parseInt(st.nextToken());
        nodes.add(new Node(s, e, w));
      }

      dist = new int[N + 1];
      Arrays.fill(dist, INF);
      boolean isCycle = bellmanFord(1);
      if (isCycle) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }

  private static boolean bellmanFord(int start) {
    dist[start] = 0;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < total; j++) {
        Node node = nodes.get(j);
        if (dist[node.e] > dist[node.s] + node.cost) {
          dist[node.e] = dist[node.s] + node.cost;

          if (i == N - 1) {
            return true;
          }
        }

      }
    }

//    for (int i = 0; i < N; i++) {
//      for (int j = 0; j < total; j++) {
//        Node node = nodes.get(j);
//        if (dist[node.e] > dist[node.s] + node.cost) {
//          return true;
//        }
//      }
//    }

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
