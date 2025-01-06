package Baekjoon._17135;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static int n, m, d;
  static int[][] map;
  static ArrayList<int[]> stores;
  static int answer = -1;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());

    map = new int[n][m];
    stores = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        int val = Integer.parseInt(st.nextToken());
        map[i][j] = val;

        if (val == 1) {
          stores.add(new int[]{i, j});
        }
      }
    }

    makeArchers(0, 0, new int[m]);

    System.out.println(answer);
  }

  private static void game(int[] base) {
    List<int[]> enemies = new ArrayList<>();
    for (int[] arr : stores) {
      enemies.add(arr.clone());
    }

    List<int[]> archers = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      if (base[i] == 1) {
        archers.add(new int[]{n, i});
      }
    }

    int result = 0;
    boolean[] check;

    while (!enemies.isEmpty()) {
      check = new boolean[enemies.size()];

      for (int[] a : archers) {
        int minDist = Integer.MAX_VALUE;
        int idx = -1;
        int y = m;

        for (int i = 0; i < enemies.size(); i++) {
          int[] e = enemies.get(i);
          int dist = Math.abs(e[0] - a[0]) + Math.abs(e[1] - a[1]);
          if (dist <= d) {
            if (minDist > dist) {
              minDist = dist;
              y = e[1];
              idx = i;
            } else if (minDist == dist) {
              if (y > e[1]) {
                idx = i;
                y = e[1];
              }
            }
          }
        }

        if (idx != -1) {
          check[idx] = true;
        }
      }

      for (int i = check.length - 1; i >= 0; i--) {
        if (check[i]) {
          result++;
          enemies.remove(i);
        } else {
          int[] e = enemies.get(i);
          e[0]++;
          if (e[0] >= n) {
            enemies.remove(i);
          }
        }
      }
    }

    answer = Math.max(answer, result);
  }

  private static void makeArchers(int cnt, int idx, int[] base) {
    if (cnt == 3) {
      game(base);
      return;
    }

    for (int i = idx; i < m; i++) {
      base[i] = 1;
      makeArchers(cnt + 1, i + 1, base);
      base[i] = 0;
    }
  }
}
