package Baekjoon._13700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int n;
  static int s;
  static int d;
  static int f;
  static int b;
  static int k;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    s = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());
    f = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    int[] street = new int[n + 1];

    if (k != 0) {
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < k; i++) {
        int val = Integer.parseInt(st.nextToken());
        street[val] = 1;
      }
    }

    Queue<int[]> q = new LinkedList<>();
    boolean[] visited = new boolean[n + 1];
    q.add(new int[]{s, 0}); // 현 위치, 카운트
    visited[s] = true;
    int result = -1;

    while (!q.isEmpty()) {
      int[] now = q.poll();

      int flag1 = go(q, visited, street, f, now[0], now[1]);
      int flag2 = go(q, visited, street, -b, now[0], now[1]);

      if (flag1 != 0) {
        result = flag1;
        break;
      }

      if (flag2 != 0) {
        result = flag2;
        break;
      }
    }

    if (result == -1) {
      System.out.println("BUG FOUND");
    } else {
      System.out.println(result);
    }
  }

  private static int go(Queue<int[]> q, boolean[] visited, int[] street, int plus, int now,
      int count) {
    int next = now + plus;

    if (next == d) {
      return count + 1;
    }

    if (next > 0 && next <= n && street[next] == 0 && !visited[next]) {
      visited[next] = true;
      q.add(new int[]{next, count + 1});
    }

    return 0;
  }
}
