package Baekjoon._11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  static int[] map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    map = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      map[i] = i;
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      if (!isSame(u, v)) {
        union(u, v);
      }
    }

    Set<Integer> set = new HashSet<>();
    for (int i = 1; i <= N; i++) {
      set.add(find(i));
    }

    System.out.println(set.size());
  }

  private static void union(int x, int y) {
    x = find(x);
    y = find(y);

    if (x != y) {
      map[y] = x;
    }
  }

  private static boolean isSame(int x, int y) {
    int a = find(x);
    int b = find(y);

    if (a != b) {
      return false;
    }

    return true;
  }

  private static int find(int x) {
    if (map[x] == x) {
      return x;
    }

    return map[x] = find(map[x]);
  }
}
