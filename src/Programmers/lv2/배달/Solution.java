package Programmers.lv2.배달;

import java.util.*;

class Solution {
  final int INF = 500001;
  int[][] graph;
  int[] dist;

  public int solution(int N, int[][] road, int K) {
    graph = new int[N + 1][N + 1];
    dist = new int[N + 1];

    for(int i = 1; i <= N; i++) {
      for(int j = 1; j <= N; j++) {
        if(i == j) graph[i][j] = 0;
        else graph[i][j] = INF;
      }
    }

    for (int[] r : road) {
      int cost = Math.min(graph[r[0]][r[1]], r[2]);
      graph[r[0]][r[1]] = cost;
      graph[r[1]][r[0]] = cost;
    }

    for (int i = 1; i <= N; i++)
      dist[i] = INF;

    dijstra(1, N);

    int result = 0;
    for (int i = 1; i <= N; i++) {
      System.out.println(dist[i]);
      if (dist[i] <= K) {
        result++;
      }
    }

    return result;
  }

  public void dijstra(int x, int N) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
    boolean[] visited = new boolean[N + 1];

    dist[x] = 0;
    pq.add(new int[]{x, 0});

    while (!pq.isEmpty()) {
      int[] cur = pq.poll();

      if (visited[cur[0]]) continue;
      visited[x] = true;

      for (int i = 1; i <= N; i++) {
        if (dist[i] > dist[cur[0]] + graph[cur[0]][i]) {
          dist[i] = dist[cur[0]] + graph[cur[0]][i];
          pq.add(new int[]{i, dist[i]});
        }
      }
    }
  }
}

/*

1번 마을에서 각 마을로 음식 배라
N개의 마을 중에서 K 시간 이하로 배달이 가능한 마을에서만 주문 받음
한 점에서 나머지 점들에 대한 최소 비용 구해야 함 => 다익스트라(최단 경로 알고리즘)

*/