package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5214 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    for (int i = 0; i < N + M + 1; i++) {
      map.add(new ArrayList<>());
    }

    for (int i = N + 1; i < N + M + 1; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < K; j++) {
        int num = Integer.parseInt(st.nextToken());
        map.get(i).add(num);
        map.get(num).add(i);
      }
    }

    boolean[] visited = new boolean[N + M + 1];
    Queue<Integer> q = new LinkedList<>();
    q.add(1);
    visited[1] = true;
    int[] dist = new int[N + M + 1];
    while (!q.isEmpty()) {
      int cur = q.poll();

      if (cur == N) {
        break;
      }

      for (int next : map.get(cur)) {
        if (visited[next]) {
          continue;
        }

        dist[next] = dist[cur] + 1;
        q.add(next);
        visited[next] = true;
      }
    }

    if (N != 1 && dist[N] == 0) {
      System.out.println(-1);
    } else {
      System.out.println(dist[N] / 2 + 1);
    }
   }
}
