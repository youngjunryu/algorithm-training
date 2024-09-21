package Baekjoon._11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static ArrayList<ArrayList<Integer>> map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    map = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      map.add(new ArrayList<>());
    }

    for (int i = 0; i < N - 1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      map.get(a).add(b);
      map.get(b).add(a);
    }

    int[] parent = new int[N + 1];
    boolean[] visited = new boolean[N + 1];
    visited[1] = true;
    Queue<Integer> q = new LinkedList<>();
    q.add(1);
    while (!q.isEmpty()) {
      int now = q.poll();

      for (int next : map.get(now)) {
        if (visited[next]) {
          continue;
        }

        parent[next] = now;
        visited[next] = true;
        q.add(next);
      }
    }

    for (int i = 2; i <= N; i++) {
      System.out.println(parent[i]);
    }
  }
}
