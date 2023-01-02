package PROGRAMMERS;

import java.util.PriorityQueue;

public class 배달 {
  static int INF = 500001;
  static int[][] graph;
  static int[] dist;

  public static int solution(int N, int[][] road, int K) {
    int answer = 0;
    graph = new int[N+1][N+1];
    dist = new int[N+1];

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        if (i == j) graph[i][j] = 0;
        else graph[i][j] = INF;
      }
    }

    for (int[] r : road) {
      int time = Math.min(graph[r[0]][r[1]], r[2]);
      graph[r[0]][r[1]] = time;
      graph[r[1]][r[0]] = time;
    }

    for (int i = 1; i <= N; i++) {
      dist[i] = INF;
    }

    dijkstra(1, N);

    for (int i = 1; i <= N; i++) {
      if (dist[i] <= K) {
        answer++;
      }
    }

    return answer;
  }

  private static void dijkstra(int src, int N) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    boolean[] visited = new boolean[N+1];

    dist[src] = 0;
    pq.add(new int[]{0, src});

    while (!pq.isEmpty()) {
      int[] cur = pq.poll();
      int u = cur[1];

      if (visited[u]) continue;

      visited[u] = true;

      for (int v = 1; v <= N; v++) {
        if (dist[v] > dist[u] + graph[u][v]) {
          dist[v] = dist[u] + graph[u][v];
          pq.add(new int[]{dist[v], v});
        }
      }
    }
  }

  public static void main(String[] args) {
    solution(5, new int[][]{{1,2,1}, {2,3,3}, {5,2,2}, {1,4,2}, {5,3,1}, {5,4,2}}, 3);
  }
}
