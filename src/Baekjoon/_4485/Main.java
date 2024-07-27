package Baekjoon._4485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int idx = 0;

    while (true) {
      int N = Integer.parseInt(br.readLine());
      idx++;

      if (N == 0) {
        return;
      }

      int[][] map = new int[N][N];

      for (int i = 0; i < N; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
          map[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      int result = dijstra(N, map);
      System.out.println("Problem " + idx + ": " + result);
    }
  }

  private static int dijstra(int n, int[][] map) {
    int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int[][] dist = new int[n][n];

    for (int i = 0; i < n; i++) {
      Arrays.fill(dist[i], Integer.MAX_VALUE);
    }

    dist[0][0] = map[0][0];

    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(0, 0, dist[0][0]));

    while (!pq.isEmpty()) {
      Node now = pq.poll();

      if (dist[now.x][now.y] < now.val) {
        continue;
      }

      for (int d = 0; d < 4; d++) {
        int nx = now.x + dir[d][0];
        int ny = now.y + dir[d][1];

        if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
          continue;
        }

        int newVal = now.val + map[nx][ny];
        if (newVal < dist[nx][ny]) {
          dist[nx][ny] = newVal;
          pq.add(new Node(nx, ny, newVal));
        }
      }
    }

    return dist[n - 1][n - 1];
  }

  private static void print(int[][] dist) {
    for (int i = 0; i < dist.length; i++) {
      for (int j = 0; j < dist.length; j++) {
        System.out.print(dist[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  static class Node implements Comparable<Node> {

    int x;
    int y;
    int val;

    public Node(int x, int y, int val) {
      this.x = x;
      this.y = y;
      this.val = val;
    }

    @Override
    public int compareTo(Node o) {
      return this.val - o.val;
    }
  }
}
