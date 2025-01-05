package Baekjoon._4386;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  static int n;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());

    ArrayList<double[]> store = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      store.add(
          new double[]{Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken())});
    }

    List<List<Node>> graph = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      graph.add(new LinkedList<>());
    }

    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        double cost = Math.sqrt(Math.pow(store.get(i)[0] - store.get(j)[0], 2) + Math.pow(
            store.get(i)[1] - store.get(j)[1], 2));
        graph.get(i).add(new Node(j, cost));
        graph.get(j).add(new Node(i, cost));
      }
    }

    boolean[] visited = new boolean[n];
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(0, 0));

    double answer = 0;
    int cnt = 0;

    while (!pq.isEmpty()) {
      Node now = pq.poll();

      if (visited[now.v]) {
        continue;
      }

      visited[now.v] = true;
      answer += now.cost;

      for (Node next : graph.get(now.v)) {
        if (!visited[next.v]) {
          pq.add(next);
        }
      }

      cnt++;

      if (cnt == n) {
        break;
      }
    }

    System.out.println(answer);
  }

  static class Node implements Comparable<Node> {

    int v;
    double cost;

    public Node(int v, double cost) {
      this.v = v;
      this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
      return (int) (this.cost - o.cost);
    }
  }
}
