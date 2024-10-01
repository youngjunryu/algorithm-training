package Baekjoon._1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    for (int t = 0; t < T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int K = Integer.parseInt(st.nextToken());

      int[] cost = new int[N + 1];
      st = new StringTokenizer(br.readLine());
      for (int i = 1; i <= N; i++) {
        cost[i] = Integer.parseInt(st.nextToken());
      }

      ArrayList<ArrayList<Integer>> map = new ArrayList<>();
      for (int i = 0; i < N + 1; i++) {
        map.add(new ArrayList<>());
      }

      int[] count = new int[N + 1];
      for (int i = 0; i < K; i++) {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        map.get(x).add(y);
        count[y]++;
      }

      int W = Integer.parseInt(br.readLine());

      int wResult = dijkstra(N, map, cost, count, W);
      System.out.println(wResult);
    }
  }

  private static int dijkstra(int N, ArrayList<ArrayList<Integer>> map, int[] cost, int[] count,
      int w) {
    int[] dist = new int[N + 1];

    Queue<int[]> pq = new LinkedList<>();

    for (int i = 1; i <= N; i++) {
      if (count[i] == 0) {
        pq.add(new int[]{i, cost[i]});
        dist[i] = cost[i];
      }
    }

    while (!pq.isEmpty()) {
      int[] arr = pq.poll();
      int now = arr[0];
      int time = arr[1];

      if (now == w) {
        break;
      }

      if (dist[now] > time) {
        continue;
      }

      for (int next : map.get(now)) {
        int newTime = time + cost[next];
        if (newTime > dist[next]) {
          dist[next] = newTime;
        }

        count[next]--;
        if (count[next] == 0) {
          pq.add(new int[]{next, dist[next]});
        }
      }
    }

    return dist[w];
  }
}
