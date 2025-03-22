package Baekjoon._9205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int hx, hy;
  static int rx, ry;
  static List<int[]> stores;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    StringTokenizer st;

    for (int t = 0; t < T; t++) {
      int n = Integer.parseInt(br.readLine());

      st = new StringTokenizer(br.readLine());
      hx = Integer.parseInt(st.nextToken());
      hy = Integer.parseInt(st.nextToken());

      stores = new ArrayList<>();

      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());

        stores.add(new int[]{sx, sy});
      }

      st = new StringTokenizer(br.readLine());
      rx = Integer.parseInt(st.nextToken());
      ry = Integer.parseInt(st.nextToken());

      if (bfs()) {
        System.out.println("happy");
      } else {
        System.out.println("sad");
      }
    }
  }

  private static boolean bfs() {
    Queue<int[]> q = new ArrayDeque<>();
    q.add(new int[]{hx, hy});
    boolean[] visited = new boolean[stores.size()];

    while (!q.isEmpty()) {
      int[] now = q.poll();
      int x = now[0];
      int y = now[1];

      if (Math.abs(x - rx) + Math.abs(y - ry) <= 1000) {
        return true;
      }

      for (int i = 0; i < stores.size(); i++) {
        if (visited[i]) {
          continue;
        }

        int[] next = stores.get(i);

        int distance = Math.abs(x - next[0]) + Math.abs(y - next[1]);
        if (distance <= 1000) {
          visited[i] = true;
          q.add(new int[]{next[0], next[1]});
        }
      }
    }

    return false;
  }
}
