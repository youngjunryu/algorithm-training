package Baekjoon._1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int N, M, V;
  static ArrayList<ArrayList<Integer>> map;
  static boolean[] visited;
  static ArrayList<Integer> result;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    V = Integer.parseInt(st.nextToken());

    map = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      map.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      map.get(a).add(b);
      map.get(b).add(a);
    }

    for (int i = 0; i <= N; i++) {
      Collections.sort(map.get(i));
    }

    visited = new boolean[N + 1];
    result = new ArrayList<>();
    visited[V] = true;
    dfs(V);
    print();

    bfs();
    print();
  }

  private static void print() {
    for (int i = 0; i < result.size(); i++) {
      System.out.print(result.get(i) + " ");
    }
    System.out.println();
  }

  private static void bfs() {
    visited = new boolean[N + 1];
    result = new ArrayList<>();

    Queue<Integer> queue = new LinkedList<>();
    visited[V] = true;
    result.add(V);
    queue.add(V);

    while (!queue.isEmpty()) {
      int now = queue.poll();

      for (int next : map.get(now)) {
        if (visited[next]) {
          continue;
        }

        result.add(next);
        visited[next] = true;
        queue.add(next);
      }
    }
  }

  private static void dfs(int now) {
    result.add(now);

    for (int i = 0; i < map.get(now).size(); i++) {
      int next = map.get(now).get(i);
      if (visited[next]) {
        continue;
      }

      visited[next] = true;
      dfs(next);
    }
  }
}
