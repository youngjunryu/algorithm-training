package Baekjoon._20040;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int[] parent;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    parent = new int[N];

    for (int i = 0; i < N; i++) {
      parent[i] = i;
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      if (union(a, b)) {
        continue;
      } else {
        System.out.println(i + 1);
        return;
      }
    }

    System.out.println(0);
  }

  private static int find(int x) {
    if (x == parent[x]) {
      return x;
    }

    return parent[x] = find(parent[x]);
  }

  private static boolean union(int x, int y) {
    x = find(x);
    y = find(y);

    if (x < y) {
      parent[y] = x;
      return true;
    } else if (x > y) {
      parent[x] = y;
      return true;
    } else {
      return false;
    }
  }
}
