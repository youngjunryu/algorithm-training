package Baekjoon._1167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  static ArrayList<ArrayList<Node>> map;
  static int far, max;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    map = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      map.add(new ArrayList<>());
    }

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int v = Integer.parseInt(st.nextToken());
      ArrayList<Node> nodes = map.get(v);

      while (st.hasMoreTokens()) {
        int dest = Integer.parseInt(st.nextToken());

        if (dest == -1) {
          break;
        }

        int cost = Integer.parseInt(st.nextToken());

        nodes.add(new Node(dest, cost));
      }
    }

    far = 0;
    max = 0;
    visited = new boolean[N + 1];
    visited[1] = true;
    getFar(1, 0);

    max = 0;
    visited = new boolean[N + 1];
    visited[far] = true;
    getFar(far, 0);
    System.out.println(max);
  }

  private static void getFar(int now, int len) {
    if (len > max) {
      max = len;
      far = now;
    }

    for (Node next : map.get(now)) {
      if (visited[next.dest]) {
        continue;
      }

      visited[next.dest] = true;
      getFar(next.dest, next.cost + len);
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
