package Baekjoon._2644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    int m = Integer.parseInt(br.readLine());
    List<List<Integer>> map = new ArrayList<>();
    for (int i = 0; i < n + 1; i++) {
      map.add(new ArrayList<>());
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      map.get(x).add(y);
      map.get(y).add(x);
    }

    boolean[] visited = new boolean[n + 1];
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{a, 0});
    visited[a] = true;

    while (!q.isEmpty()) {
      int[] now = q.poll();

      for (int next : map.get(now[0])) {
        if (visited[next]) {
          continue;
        }

        if (next == b) {
          System.out.println(now[1] + 1);
          return;
        }

        visited[next] = true;
        q.add(new int[]{next, now[1] + 1});
      }
    }

    System.out.println(-1);
  }
}
