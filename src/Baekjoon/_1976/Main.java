package Baekjoon._1976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int[] parent;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());

    parent = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      parent[i] = i;
    }

    for (int i = 1; i <= N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      for (int j = 1; j <= N; j++) {
        int val = Integer.parseInt(st.nextToken());
        if (i != j) {
          if (val == 1) {
            union(i, j);
          }
        }
      }
    }

    StringTokenizer st = new StringTokenizer(br.readLine());
    int prev = Integer.parseInt(st.nextToken());
    for (int i = 1; i < M; i++) {
      int now = Integer.parseInt(st.nextToken());

      boolean avail = isParent(prev, now);
      if (!avail) {
        System.out.println("NO");
        return;
      }

      prev = now;
    }

    System.out.println("YES");
  }

  private static int getParent(int a) {
    if (parent[a] == a) {
      return a;
    }

    return parent[a] = getParent(parent[a]);
  }

  private static boolean isParent(int a, int b) {
    a = getParent(a);
    b = getParent(b);

    return a == b;
  }

  private static void union(int a, int b) {
    a = getParent(a);
    b = getParent(b);

    if (a != b) {
      parent[b] = a;
    }
  }
}
